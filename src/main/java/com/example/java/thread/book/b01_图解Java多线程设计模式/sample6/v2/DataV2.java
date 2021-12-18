package com.example.java.thread.book.b01_图解Java多线程设计模式.sample6.v2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 19:00<br>
 */
public class DataV2 {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public DataV2(int size){
        this.buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException{
        readLock.lock();
        try {
            return doRead();
        } finally {
            // tip 程序在返回之前，会执行 finally 中的语句
            readLock.unlock();
        }
    }

    public void write(char c) throws InterruptedException{
        writeLock.lock();
        try {
            doWrite(c);
        } finally {
            writeLock.unlock();
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
