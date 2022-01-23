package com.example.java.basic.juc.mashibing.c_026_01_ThreadPool;

import java.util.concurrent.*;

public class T06_00_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 100;
        });
        new Thread(task).start();
        System.out.println(task.get());

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> future = executorService.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1;
        });
        System.out.println(future.get());
        System.out.println(future.isDone());
        executorService.shutdown();
    }
}
