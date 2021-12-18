package com.example.java.thread.book.b01_图解Java多线程设计模式.sample8.practice.p6;

/**
 * ChannelP6 增加 stopAllWorkers
 * ClientThreadP6 增加 stopThread
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/22 9:14<br>
 */
public class WorkerThreadP6Main {
    public static void main(String[] args) {
        ChannelP6 channel = new ChannelP6(5);
        channel.startWorkers();
        ClientThreadP6 alice = new ClientThreadP6("Alice", channel);
        ClientThreadP6 bobby = new ClientThreadP6("Bobby", channel);
        ClientThreadP6 chris = new ClientThreadP6("Chris", channel);
        alice.start();
        bobby.start();
        chris.start();
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alice.stopThread();
        bobby.stopThread();
        chris.stopThread();
        channel.stopAllWorkers();
    }
}
