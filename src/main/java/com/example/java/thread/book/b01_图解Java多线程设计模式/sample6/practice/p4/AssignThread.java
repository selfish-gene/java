package com.example.java.thread.book.b01_图解Java多线程设计模式.sample6.practice.p4;

import java.util.Random;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 21:59<br>
 */
public class AssignThread extends Thread {
    public static final Random random = new Random(314159);
    private final Database<String, String> database;
    private final String key;
    private final String value;

    public AssignThread(Database<String, String> database, String key, String value) {
        this.database = database;
        this.key = key;
        this.value = value;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName() + ":assign(" + key + ", " + value + ")");
            database.assign(key, value);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
