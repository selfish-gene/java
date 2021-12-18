package com.example.java.thread.book.b01_图解Java多线程设计模式.sample8.practice.p6;

import java.util.Random;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/22 9:15<br>
 */
public class ClientThreadP6 extends Thread{
    private final ChannelP6 channel;
    private static final Random random = new Random();
    private volatile boolean terminated = false;
    public ClientThreadP6(String name, ChannelP6 channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; !terminated; i++) {
                try {
                    RequestP6 request = new RequestP6(getName(), i);
                    channel.putRequest(request);
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    terminated = true;
                    e.printStackTrace();
                }
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + " is terminated.");
        }
    }

    public void stopThread() {
        terminated = true;
        // tip 确保线程在 wait or sleep 时可响应打断
        interrupt();
    }
}
