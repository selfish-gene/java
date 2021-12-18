package com.example.java.thread.book.b01_图解Java多线程设计模式.sample1.extension.samephore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 11:14<br>
 */
public class BoundedResource {
    private final Semaphore semaphore;
    private final int permits;
    private final static Random random = new Random(314159);

    public BoundedResource(int permits){
        this.semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    public void use() throws InterruptedException {
        semaphore.acquire();
        try {
            doUse();
        } finally {
            semaphore.release();
        }
    }
    protected void doUse() throws InterruptedException {
        Log.println("Begin : used = " + (permits - semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("End : used = " + (permits - semaphore.availablePermits()));
    }
}
