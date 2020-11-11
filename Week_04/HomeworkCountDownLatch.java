package java0.conc0303;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

public class HomeworkCountDownLatch {

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
