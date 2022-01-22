package com.example.java.book.b01_图解Java多线程设计模式.sample8.practice.p3;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/22 9:23<br>
 */
public class WorkerThreadP3 extends Thread{
    private final ChannelP3 channel;

    public WorkerThreadP3(String name, ChannelP3 channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true){
            RequestP3 requestP3 = channel.takeRequest();
            requestP3.execute();
        }
    }
}
