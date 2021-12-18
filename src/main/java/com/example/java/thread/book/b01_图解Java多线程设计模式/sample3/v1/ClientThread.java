package com.example.java.thread.book.b01_图解Java多线程设计模式.sample3.v1;

import java.util.Random;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/03 19:25<br>
 */
public class ClientThread extends Thread{
    private final Random random;
    private final RequestQueue requestQueue;
    public ClientThread(RequestQueue requestQueue, String name, long seed){
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = new Request("No," + i);
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            requestQueue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
