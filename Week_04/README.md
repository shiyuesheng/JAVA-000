## 作业

#### 2.（必做）思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？

-  [JustSleep](./HomeworkJustSleep.java)

```````````````java
    private static int result = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> result = sum());
        Thread.sleep(500);

        System.out.println("异步计算结果为：" + result);
    }

```````````````

-  [ThreadJoin](./HomeworkThreadJoin.java)

```````````````java
    private static int result = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread = new Thread(() -> result = sum());
        thread.start();
        thread.join();

        System.out.println("异步计算结果为：" + result);
    }

```````````````

-  [Future](./HomeworkFuture.java)

```````````````java
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> result = executorService.submit(() -> sum());

        System.out.println("异步计算结果为：" + result.get());
    }

```````````````

-  [FutureTask](./HomeworkFutureTask.java)

```````````````java
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> sum());
        new Thread(futureTask).start();

        System.out.println("异步计算结果为：" + futureTask.get());
    }

```````````````

-  [CompletableFuture](./HomeworkCompletableFuture.java)

```````````````java
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer result = CompletableFuture.supplyAsync(() -> sum()).join();
        System.out.println("异步计算结果为：" + result);
    }

```````````````

-  [CountDownLatch](./HomeworkCountDownLatch.java)

```````````````java
    private static int result = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            try {
                result = sum();
            } finally {
                countDownLatch.countDown();
            }
        }).start();
        countDownLatch.await();

        System.out.println("异步计算结果为：" + result);
    }

```````````````

#### 4.（必做）把多线程和并发相关知识带你梳理一遍，画一个脑图，截图上传到 Github 上。
可选工具：xmind，百度脑图，wps，MindManage 或其他。