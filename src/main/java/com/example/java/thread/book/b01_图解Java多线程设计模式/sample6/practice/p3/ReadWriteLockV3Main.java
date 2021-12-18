package com.example.java.thread.book.b01_图解Java多线程设计模式.sample6.practice.p3;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 19:00<br>
 */
public class ReadWriteLockV3Main {
    public static void main(String[] args) {
        DataV3 data = new DataV3(10);
        new ReaderThreadV3(data).start();
        new ReaderThreadV3(data).start();
        new ReaderThreadV3(data).start();
        new ReaderThreadV3(data).start();
        new ReaderThreadV3(data).start();
        new ReaderThreadV3(data).start();
        new WriterThreadV3(data, "abcdefghijklmn").start();
        new WriterThreadV3(data, "ABCDEFGHIJKLMN").start();
    }
}
