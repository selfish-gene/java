package com.example.java.thread.book.b01_图解Java多线程设计模式.sample8.practice.p3;

/**
 * 对比 Thread-Per-Message 与 Worker 的吞吐量
 *          Thread-Per-Message      Worker
 * Alice	55736                   494303
 * Bobby	44285                   478520
 * Chris	55261                   480702
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/22 9:14<br>
 */
public class WorkerThreadP3Main {
    public static void main(String[] args) {
        ChannelP3 channelP3 = new ChannelP3(5);
        channelP3.startWorkers();
        new ClientThreadP3("Alice", channelP3).start();
        new ClientThreadP3("Bobby", channelP3).start();
        new ClientThreadP3("Chris", channelP3).start();
        try {
            Thread.sleep(15 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
