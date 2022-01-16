package com.example.java.book.b01_图解Java多线程设计模式.sample8.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/22 9:23<br>
 */
public class WorkerThread extends Thread{
    private final Channel channel;

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true){
            Request request = channel.takeRequest();
            request.execute();
        }
    }
}
