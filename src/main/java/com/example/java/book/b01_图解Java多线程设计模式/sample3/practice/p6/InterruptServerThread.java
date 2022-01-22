package com.example.java.book.b01_图解Java多线程设计模式.sample3.practice.p6;

import com.example.java.book.b01_图解Java多线程设计模式.sample3.v1.Request;

import java.util.Random;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/03 19:29<br>
 */
public class InterruptServerThread extends Thread {
    private final Random random;
    private final InterruptRequestQueue requestQueue;

    public InterruptServerThread(InterruptRequestQueue requestQueue, String name, long seed) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                Request request = requestQueue.getRequest();
                System.out.println(Thread.currentThread().getName() + " handles " + request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
