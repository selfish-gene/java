package com.example.java.book.b01_图解Java多线程设计模式.sample6.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 19:00<br>
 */
public class DataV1 {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public DataV1(int size){
        this.buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException{
        lock.readLock();
        try {
            // tip 为何不放在这里？（6-5）
            // tip 答：readLock 方法发生 InterruptedException 异常时，readingReaders 不会递增，但放这里会调用 readUnlock 方法，导致 readingReaders 比正常值小
//            lock.readLock();
            return doRead();
        } finally {
            // tip 程序在返回之前，会执行 finally 中的语句
            lock.readUnlock();
        }
    }

    public void write(char c) throws InterruptedException{
        lock.writeLock();
        try {
            // tip 为何不放在这里？（6-5）答：同上
//            lock.writeLock();
            doWrite(c);
        } finally {
            lock.writeUnlock();
        }
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
