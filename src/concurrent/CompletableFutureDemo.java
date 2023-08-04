package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFutureDemo completableFutureDemo = new CompletableFutureDemo();
        completableFutureDemo.CFDemo();
    }

    public void TPDemo() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100));

        for (int i = 0; i < 10; i++) {
            int c = i+100;
            final int[] b = {c};
            threadPoolExecutor.execute(()->{
                b[0] +=100;
                System.out.println(b[0]);
            });
        }
    }

    public void CFDemo() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100));

        for (int i = 0; i < 10; i++) {
            int c = i+100;
            final int[] b = {c};
            CompletableFuture.runAsync(()->{
                b[0] +=100;
                System.out.println(b[0]);
            });
        }

    }
    public void demo() throws InterruptedException, ExecutionException, TimeoutException {
        // 1、自定义线程池
        ExecutorService executorService = new ThreadPoolExecutor(5, 10,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100));

        // 2、集合保存future对象
        List<CompletableFuture<Integer>> futures = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            CompletableFuture<Integer> future = CompletableFuture
                    // 提交任务到指定线程池
                    .supplyAsync(() -> this.addValue(finalI), executorService)
                    // 第一个任务执行结果在此处进行处理
                    .thenApplyAsync(k -> this.plusValue(finalI, k), executorService)
                    .thenApply(k->{
                        System.out.println("任务"+finalI+"执行结果:"+k);
                        System.out.println("执行结束时间："+System.currentTimeMillis());
                        return k;
                    })
                    // 任务执行异常时处理异常并返回默认值
                    .exceptionally(e -> this.defaultValue(finalI, e));
            // future对象添加到集合中
            futures.add(future);
        }

        // 3、等待所有任务执行完成，此处最好加超时时间
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).get(5, TimeUnit.MINUTES);
        for (CompletableFuture<Integer> future : futures) {
            Integer num = future.get();
            System.out.println("任务执行结果为：" + num);
        }
        System.out.println("任务全部执行完成！");
    }

    private Integer addValue(Integer index) {
        System.out.println("第" + index + "个任务第一次执行");
        if (index == 3) {
            int value = index / 0;
        }
        return index + 3;
    }

    private Integer plusValue(Integer index, Integer num) {
        System.out.println("第" + index + "个任务第二次执行，上次执行结果：" + num);
        return num * 10;
    }

    private Integer defaultValue(Integer index, Throwable e) {
        System.out.println("第" + index + "个任务执行异常！" + e.getMessage());
        e.printStackTrace();
        return 10;
    }

}
