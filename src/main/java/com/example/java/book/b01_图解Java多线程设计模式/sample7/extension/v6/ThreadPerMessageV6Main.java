package com.example.java.book.b01_图解Java多线程设计模式.sample7.extension.v6;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/15 17:25<br>
 */
public class ThreadPerMessageV6Main {
    public static void main(String[] args) {
        System.out.println("main Begin ...");
        // ScheduledExecutorService
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        HostV6 host = new HostV6(scheduledExecutorService);
        try {
            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');
        } finally {
            scheduledExecutorService.shutdown();
            System.out.println("main End ...");
        }
    }
}
