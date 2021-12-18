package com.example.java.thread.book.b01_图解Java多线程设计模式.sample7.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/15 17:25<br>
 */
public class HostV1 {
    private final Helper helper = new Helper();
    public void request(final int count, final char c){
        System.out.println(" request(" + count + ", " + c + ") Begin");
        new Thread(() -> helper.handle(count, c)).start();
        System.out.println(" request(" + count + ", " + c + ") End");
    }
}
