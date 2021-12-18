package com.example.java.thread.book.b01_图解Java多线程设计模式.sample4.practice.p4.v1;

import com.example.java.thread.book.b01_图解Java多线程设计模式.sample3.v1.Request;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/04 21:58<br>
 */
public class CheckDeadlockV3TaskThread extends Thread{
    private final RequestQueueV3 input;
    private final RequestQueueV3 output;

    public CheckDeadlockV3TaskThread(RequestQueueV3 input, RequestQueueV3 output, String name) {
        super(name);
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":BEGIN");
        for (int i = 0; i < 20; i++) {
            // 接收对方的请求
            Request request1 = input.getRequest();
            System.out.println(Thread.currentThread().getName() + " gets " + request1);
            // 加上一个感叹号（！）再返回给对方
            Request request2 = new Request(request1.getName() + "!");
            System.out.println(Thread.currentThread().getName() + " puts " + request1);
            output.putRequest(request2);
        }
        System.out.println(Thread.currentThread().getName() + ":END");
    }
}
