package com.example.java.book.b01_图解Java多线程设计模式.sample7.extension.v2;

import com.example.java.book.b01_图解Java多线程设计模式.sample7.v1.Helper;

import java.util.concurrent.ThreadFactory;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/15 17:25<br>
 */
public class HostV2 {
    private final Helper helper = new Helper();
    private final ThreadFactory threadFactory;

    public HostV2(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public void request(final int count, final char c){
        System.out.println(" request(" + count + ", " + c + ") Begin");
        // ThreadFactory
        threadFactory.newThread(() -> helper.handle(count, c)).start();
        System.out.println(" request(" + count + ", " + c + ") End");
    }
}
