package demo;

import java.util.concurrent.*;

public class tp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Task task = new Task();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 10, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(4));

        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(111);
            }
        });
//        System.out.println(future.get());

    }
}


class Task {
    public int mytask() {
        return 1;
    }
}