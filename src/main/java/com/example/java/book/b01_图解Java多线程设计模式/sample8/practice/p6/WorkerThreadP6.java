package com.example.java.book.b01_图解Java多线程设计模式.sample8.practice.p6;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/22 9:23<br>
 */
public class WorkerThreadP6 extends Thread{
    private final ChannelP6 channel;
    private volatile boolean terminated = false;
    public WorkerThreadP6(String name, ChannelP6 channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            while (!terminated){
                try {
                    RequestP6 request = channel.takeRequest();
                    request.execute();
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
