package com.example.java.book.b01_图解Java多线程设计模式.sample6.practice.p4;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 21:49<br>
 */
public class Database<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    /**
     * 全部清除
     */
    public void clear(){
        writeLock.lock();
        try {
            verSlowly();
            map.clear();
        } finally {
            writeLock.unlock();
        }
    }

    public void assign(K key, V value){
        writeLock.lock();
        try {
            verSlowly();
            map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public V retrieve(K key){
        readLock.lock();
        try {
            slowly();
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 模拟耗时的操作
     */
    private void slowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 模拟非常耗时的操作
     */
    private void verSlowly() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
