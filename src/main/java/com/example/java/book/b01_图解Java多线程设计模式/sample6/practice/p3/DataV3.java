package com.example.java.book.b01_图解Java多线程设计模式.sample6.practice.p3;

import com.example.java.book.b01_图解Java多线程设计模式.sample6.v1.ReadWriteLock;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 19:00<br>
 */
public class DataV3 {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public DataV3(int size){
        this.buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public synchronized char[] read() throws InterruptedException{
        return doRead();
    }

    public synchronized void write(char c) throws InterruptedException{
        doWrite(c);
    }

    private char[] doRead() {
        char[] newBuf = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newBuf[i] = buffer[i];
        }
        slowly();
        return newBuf;
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly();
        }
    }

    private void slowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
