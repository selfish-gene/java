package com.example.java.thread.book.b01_图解Java多线程设计模式.sample7.extension.v6;

import com.example.java.thread.book.b01_图解Java多线程设计模式.sample7.v1.Helper;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/15 17:25<br>
 */
public class HostV6 {
    private final Helper helper = new Helper();
    private final ScheduledExecutorService scheduledExecutorService;

    public HostV6(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
    }

    public void request(final int count, final char c){
        System.out.println(" request(" + count + ", " + c + ") Begin");
        // Executor
        scheduledExecutorService.schedule(() -> helper.handle(count, c), 3L, TimeUnit.SECONDS);
        System.out.println(" request(" + count + ", " + c + ") End");
    }
}
