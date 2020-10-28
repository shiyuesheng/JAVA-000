## 作业

一、GC总结
> 压测记录见 [GCLogAnalysis-GC-Record](./GCLogAnalysis-GC-Record.md)、[Gateway-Server-wrk-Record](./Gateway-Server-wrk-Record.md)

1. Serial
	- 串行收集器，收集过程STW
	- 新生代标记-复制，老年代标记-整理
	- 相关参数 -XX:+UseSerialGC
	- 优点：稳定，效率高
	- 缺点：堆内存空间大STW时间长
1. ParNew
	- Serial并行版，收集时使用多线程
	- 新生代标记-复制，老年代标记-整理
	- 相关参数 
		- -XX:+UseParNewGC 
		- -XX:ParallelGCThreads（收集线程数量）
	- 优点：稳定，效率高
	- 缺点：堆内存空间大STW时间长，相比于Serial，优势在于利用多核，如果是单核处理器，未必比Serial性能好
1. Parallel
	- 类似ParNew，不同之处在于更关注系统吞吐量。
		- 自适应调节，JVM收集运行数据，作出调整，提供最合适的停顿时间、提高吞吐量
		- 也可以自己配置，新手建议JVM自适应调节
	- 新生代标记-复制，老年代标记-整理
	- 相关参数 -XX:+UseParallelGC
	- 优点：适合后台任务服务，稳定的高吞吐非常适合定时任务
	- 缺点：相交于后两个，不太适合频繁交互，低停顿的场景
1. CMS
	- 专注于缩短停顿时间
	- 老年代标记-清楚
	- 相关参数：
		- -XX:+UseConcMarkSweepGC 使用CMS收集器
		- -XX:+UseCMSCompactAtFullCollection Full GC后，进行一次碎片整理；cpu独占的，停顿时间变长
		- -XX:CMSFullGCsBeforeCompaction 几次Full GC后，进行一次碎片整理
		- -XX:ParallelCMSThreads CMS的线程数量，可简单设置为cpu数量
	- 优点：并发收集、清除，低停顿
	- 缺点：并发阶段、吞吐量下降，而且老年代因为（标记-清除算法）会导致内存碎片，需要人工优化碎片整理策略
1. G1
	- 专注于缩短停顿时间，而且可以设置期望的停顿时间，G1则努力达成
	- 完全不同于上面所有收集器的内存布局，虽然还沿用分代的概念，但是已经年轻代，老年代已经不在物理隔离，而是混成了一块块的区域（Region）
	- 相关参数
		- -XX:+UseG1GC
		- -XX:MaxGCPauseMillis 期望暂停时间			- -XX:GCPauseIntervalMillis 期望暂停间隔
		- -XX:G1HeapRegionSize	G1内堆内存区块大小
	- 优点：可预测停顿，Region合并，减少内存碎片
	- 缺点：堆内存够大，G1就更能体现强大，庙小了容不下大佛

&emsp; &emsp; &emsp; CMS、G1从我的[GCLogAnalysis-GC-Record](./GCLogAnalysis-GC-Record.md)测试数据来看，相较于之前三个，不接受外部请求时的吞吐量没有明显的提升，但是使用网关服务压测时[Gateway-Server-wrk-Record](./Gateway-Server-wrk-Record.md)，每秒处理的请求出有明显的提升，为什么呢？
</br>



二、IO、Netty压测分析
> 压测记录见 [IO-wrk-Record](./IO-wrk-Record.md)

- 单线程socket性能最差
- 多线程的反而比线程池的性能要好一些，这个我预想的不太一样。无限制的创建新的线程是一笔开销，同时线程数量过多造成的CPU上下文切换又是一笔开销，实在是想不通为是什么。我倾向于猜测测试变量没有达到线程池模型性能超过无限线程模型性能的交叉点。
- netty性能远远超过了上面两种同步阻塞模型，虽然用多线程，线程池优化了性能。但是netty的同步非阻塞IO、IO多路复用无疑是高纬打击👊，期待后面的学习。

三、Http访问
> 代码见 [HttpClientDemo.java](./HttpClientDemo.java),使用了apache组件