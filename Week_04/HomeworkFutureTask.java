package java0.conc0303;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class HomeworkFutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> sum());
        new Thread(futureTask).start();

        System.out.println("异步计算结果为：" + futureTask.get());
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
