package com.example.java.thread.book.b01_图解Java多线程设计模式.sample5.practice.p7;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 13:46<br>
 */
public class Host {
    public static void execute(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            if(Thread.interrupted()){
                throw new InterruptedException();
            }
            doHeavyJob();
        }
    }

    private static void doHeavyJob() {
        // 模拟繁重的处理（即耗时长的处理）
        System.out.println("doHeavyJob begin.");
        long start = System.currentTimeMillis();
        while (start + 10000 > System.currentTimeMillis()){
            // busy loop
        }
        System.out.println("doHeavyJob end.");
    }
}
