## GCLogAnalysis GC

#### Serial
````
java -XX:+PrintGCDetails -XX:+UseSerialGC -Xms256M -Xmx256M GCLogAnalysis
Young GC:7
Full GC:24 基本上FullGC开始后用户线程就无限挂起了
Count:4102
java -XX:+PrintGCDetails -XX:+UseSerialGC -Xms512M -Xmx512M GCLogAnalysis
Young GC:11
Full GC:2
Count:9066
java -XX:+PrintGCDetails -XX:+UseSerialGC -Xms1024M -Xmx1024M GCLogAnalysis
Young GC:7
Full GC:0
Count:10288
java -XX:+PrintGCDetails -XX:+UseSerialGC -Xms2048M -Xmx2048M GCLogAnalysis
Young GC:3
Full GC:0
Count:8278
java -XX:+PrintGCDetails -XX:+UseSerialGC -Xms4096M -Xmx4096M GCLogAnalysis
Young GC:1
Full GC:0
Count:5718
````
#### ParNew
````
java -XX:+PrintGCDetails -XX:+UseParNewGC -Xms256M -Xmx256M GCLogAnalysis
Young GC:7
Full GC:30 基本上FullGC开始后用户线程就无限挂起了
Count:4015
java -XX:+PrintGCDetails -XX:+UseParNewGC -Xms512M -Xmx512M GCLogAnalysis
Young GC:11
Full GC:2
Count:9101
java -XX:+PrintGCDetails -XX:+UseParNewGC -Xms1024M -Xmx1024M GCLogAnalysis
Young GC:7
Full GC:0
Count:10938
java -XX:+PrintGCDetails -XX:+UseParNewGC -Xms2048M -Xmx2048M GCLogAnalysis
Young GC:3
Full GC:0
Count:8339
java -XX:+PrintGCDetails -XX:+UseParNewGC -Xms4096M -Xmx4096M GCLogAnalysis
Young GC:1
Full GC:0
Count:5549
````
#### PS
````
java -XX:+PrintGCDetails -XX:+UseParallelGC -Xms256M -Xmx256M GCLogAnalysis
Young GC:6
Full GC:30
Count:3634
java -XX:+PrintGCDetails -XX:+UseParallelGC -Xms512M -Xmx512M GCLogAnalysis
Young GC:12
Full GC:8
Count:7141
java -XX:+PrintGCDetails -XX:+UseParallelGC -Xms1024M -Xmx1024M GCLogAnalysis
Young GC:9
Full GC:1
Count:11741
java -XX:+PrintGCDetails -XX:+UseParallelGC -Xms2048M -Xmx2048M GCLogAnalysis
Young GC:4
Full GC:0
Count:10275
java -XX:+PrintGCDetails -XX:+UseParallelGC -Xms4096M -Xmx4096M GCLogAnalysis
Young GC:1
Full GC:0
Count:7015
````
#### CMS
````
java -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -Xms256M -Xmx256M GCLogAnalysis
Young GC:
Full GC:
Count:3392
java -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -Xms512M -Xmx512M GCLogAnalysis
Young GC:
Full GC:
Count:8523
java -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -Xms1024M -Xmx1024M GCLogAnalysis
Young GC:
Full GC:
Count:10307
java -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -Xms2048M -Xmx2048M GCLogAnalysis
Young GC:
Full GC:
Count:10475
java -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -Xms4096M -Xmx4096M GCLogAnalysis
Young GC:
Full GC:
Count:9503
````
#### G1
````
java -XX:+PrintGCDetails -XX:+UseG1GC -Xms256M -Xmx256M GCLogAnalysis
Young GC:
Full GC:
Count:3988
java -XX:+PrintGCDetails -XX:+UseG1GC -Xms512M -Xmx512M GCLogAnalysis
Young GC:
Full GC:
Count:10958
java -XX:+PrintGCDetails -XX:+UseG1GC -Xms1024M -Xmx1024M GCLogAnalysis
Young GC:
Full GC:
Count:11915
java -XX:+PrintGCDetails -XX:+UseG1GC -Xms2048M -Xmx2048M GCLogAnalysis
Young GC:
Full GC:
Count:11438
java -XX:+PrintGCDetails -XX:+UseG1GC -Xms4096M -Xmx4096M GCLogAnalysis
Young GC:
Full GC:
Count:12354
````