package com.example.java.thread.book.b01_图解Java多线程设计模式.sample7.extension.v4;

import java.util.concurrent.Executor;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/15 17:25<br>
 */
public class ThreadPerMessageV4Main {
    public static void main(String[] args) {
        System.out.println("main Begin ...");
        // Executor
        Executor executor = command -> new Thread(command).start();
        HostV4 host = new HostV4(executor);
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main End ...");
    }
}
