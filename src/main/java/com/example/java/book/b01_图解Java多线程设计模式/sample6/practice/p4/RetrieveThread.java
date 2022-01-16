package com.example.java.book.b01_图解Java多线程设计模式.sample6.practice.p4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 21:59<br>
 */
public class RetrieveThread extends Thread {
    private final Database<String, String> database;
    private final String key;
    public static final AtomicInteger counter = new AtomicInteger(0);

    public RetrieveThread(Database<String, String> database, String key) {
        this.database = database;
        this.key = key;
    }

    @Override
    public void run() {
        while (true){
            int count = counter.incrementAndGet();
            String value = database.retrieve(key);
            System.out.println(count + ":" + key + " => " + value);
        }
    }
}
