package java0.conc0303;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeworkThreadJoin {

    private static int result = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread = new Thread(() -> result = sum());
        thread.start();
        thread.join();

        System.out.println("异步计算结果为：" + result);
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}
