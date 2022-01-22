package com.example.java.book.b01_图解Java多线程设计模式.sample6.practice.p3;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 19:01<br>
 */
public class ReadWriteLockV3 {
    // (A)...实际正在读取中的线程个数
    private int readingReaders = 0;
    // (B)...正在等待写入的线程个数
    private int waitingWriters = 0;
    // (A)...实际正在写入中的线程个数
    private int writingWriters = 0;
    // 若写入优先，则为true
    private boolean preferWriter = true;

    public synchronized void readLock() throws InterruptedException{
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)){
            wait();
        }
        // tip (A)...正在读取的线程数加1
        readingReaders++;
    }

    public synchronized void readUnlock(){
        // tip (A)...正在读取的线程数减1
        readingReaders--;
        preferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException{
        // tip (B)...正在等待写入的线程数加1
        waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0){
                wait();
            }
        } finally {
            // tip (B)...正在等待写入的线程数减1
            waitingWriters--;
        }
        // tip (C)...正在写入的线程数加1
        writingWriters++;
    }

    public synchronized void writeUnlock(){
        // tip (C)...正在写入的线程数减1
        writingWriters--;
        preferWriter = false;
        notifyAll();
    }

}
