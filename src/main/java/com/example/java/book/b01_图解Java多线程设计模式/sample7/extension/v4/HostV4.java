package com.example.java.book.b01_图解Java多线程设计模式.sample7.extension.v4;

import com.example.java.book.b01_图解Java多线程设计模式.sample7.v1.Helper;

import java.util.concurrent.Executor;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/15 17:25<br>
 */
public class HostV4 {
    private final Helper helper = new Helper();
    private final Executor executor;

    public HostV4(Executor executor) {
        this.executor = executor;
    }

    public void request(final int count, final char c){
        System.out.println(" request(" + count + ", " + c + ") Begin");
        // Executor
        executor.execute(() -> helper.handle(count, c));
        System.out.println(" request(" + count + ", " + c + ") End");
    }
}
