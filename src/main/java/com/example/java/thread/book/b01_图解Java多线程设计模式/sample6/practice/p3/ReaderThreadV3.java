package com.example.java.thread.book.b01_图解Java多线程设计模式.sample6.practice.p3;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 19:59<br>
 */
public class ReaderThreadV3 extends Thread {
    private final DataV3 data;

    public ReaderThreadV3(DataV3 data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                long start = System.currentTimeMillis();
                char[] read = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(read));
                long time = System.currentTimeMillis() - start;
                System.out.println(Thread.currentThread().getName() + ": time = " + time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
