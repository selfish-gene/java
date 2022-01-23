package com.example.java.basic.juc.mashibing.c_026_01_ThreadPool;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 提供一个服务，该服务查询各大电商网站同一类产品的价格并汇总展示
 */
public class T06_CompletableFuture {
    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        priceOfTM();
        priceOfTB();
        priceOfJD();
        end = System.currentTimeMillis();
        System.out.println("use serial method call! " + (end - start));

        start = System.currentTimeMillis();
        // 异步提交任务
        CompletableFuture<Double> futureTM = CompletableFuture.supplyAsync(T06_CompletableFuture::priceOfTM);
        CompletableFuture<Double> futureTB = CompletableFuture.supplyAsync(T06_CompletableFuture::priceOfTB);
        CompletableFuture<Double> futureJD = CompletableFuture.supplyAsync(T06_CompletableFuture::priceOfJD);
        // 汇总结果（多任务管理）  allOf  anyOf
        CompletableFuture.allOf(futureTM, futureTB, futureJD).join();

        end = System.currentTimeMillis();
        System.out.println("use completable future ! " + (end - start));

        // api demo
        CompletableFuture.supplyAsync(T06_CompletableFuture::priceOfTM)
                .thenApply(String::valueOf)
                .thenApply(str -> "price " + str)
                .thenAccept(System.out::println);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double priceOfTM() {
        delay();
        return 1.00;
    }

    private static double priceOfTB() {
        delay();
        return 2.00;
    }

    private static double priceOfJD() {
        delay();
        return 3.00;
    }

    private static void delay() {
        int time = new Random().nextInt(500);
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("After %s sleep!\n", time);
    }
}
