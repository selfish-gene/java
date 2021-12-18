package com.example.java.thread.book.b01_图解Java多线程设计模式.sample8.practice.p3;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/22 9:15<br>
 */
public class ClientThreadP3 extends Thread{
    private final ChannelP3 channelP3;
    public ClientThreadP3(String name, ChannelP3 channelP3) {
        super(name);
        this.channelP3 = channelP3;
    }

    @Override
    public void run() {
        for (int i = 0; true; i++) {
            RequestP3 requestP3 = new RequestP3(getName(), i);
            // tip Worker
            channelP3.putRequest(requestP3);
            // tip Thread-Per-Message
//            channelP3.putRequestV2(requestP3);
        }
    }
}
