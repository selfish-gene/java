package com.example.java.book.b01_图解Java多线程设计模式.sample1.extension.samephore;

import java.util.Random;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 11:22<br>
 */
public class UserThread extends Thread{
    private final static Random random = new Random(26535);
    private final BoundedResource resource;
    public UserThread(BoundedResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            while (true){
                resource.use();
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
