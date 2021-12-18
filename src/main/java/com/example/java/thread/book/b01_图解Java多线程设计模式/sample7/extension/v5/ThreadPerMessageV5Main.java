package com.example.java.thread.book.b01_图解Java多线程设计模式.sample7.extension.v5;

import com.example.java.thread.book.b01_图解Java多线程设计模式.sample7.extension.v4.HostV4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/15 17:25<br>
 */
public class ThreadPerMessageV5Main {
    public static void main(String[] args) {
        System.out.println("main Begin ...");
        // ExecutorService
        ExecutorService executorService = Executors.newCachedThreadPool();
        HostV4 host = new HostV4(executorService);
        try {
            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');
        } finally {
            executorService.shutdown();
            System.out.println("main End ...");
        }
    }
}
