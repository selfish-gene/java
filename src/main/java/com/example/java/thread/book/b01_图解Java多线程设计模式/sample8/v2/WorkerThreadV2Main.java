package com.example.java.thread.book.b01_图解Java多线程设计模式.sample8.v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/22 9:14<br>
 */
public class WorkerThreadV2Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            new ClientThreadV2("Alice", executorService).start();
            new ClientThreadV2("Bobby", executorService).start();
            new ClientThreadV2("Chris", executorService).start();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
