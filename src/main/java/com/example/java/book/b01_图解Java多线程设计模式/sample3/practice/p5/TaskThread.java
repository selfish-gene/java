package com.example.java.book.b01_图解Java多线程设计模式.sample3.practice.p5;

import com.example.java.book.b01_图解Java多线程设计模式.sample3.v1.Request;
import com.example.java.book.b01_图解Java多线程设计模式.sample3.v1.RequestQueue;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/04 21:58<br>
 */
public class TaskThread extends Thread{
    private final RequestQueue input;
    private final RequestQueue output;

    public TaskThread(RequestQueue input, RequestQueue output, String name) {
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
