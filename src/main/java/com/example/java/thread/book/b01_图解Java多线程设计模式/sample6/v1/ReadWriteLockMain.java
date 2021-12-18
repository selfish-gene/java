package com.example.java.thread.book.b01_图解Java多线程设计模式.sample6.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 19:00<br>
 */
public class ReadWriteLockMain {
    public static void main(String[] args) {
        DataV1 data = new DataV1(10);
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new WriterThread(data, "abcdefghijklmn").start();
        new WriterThread(data, "ABCDEFGHIJKLMN").start();
    }
}
