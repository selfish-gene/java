package com.example.java.thread.book.b01_图解Java多线程设计模式.sample6.v1;

import java.util.Random;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 19:52<br>
 */
public class WriterThread extends Thread {
    private static final Random random = new Random();
    private final DataV1 data;
    private final String filter;
    private int index = 0;

    public WriterThread(DataV1 data, String filter) {
        this.data = data;
        this.filter = filter;
    }

    @Override
    public void run() {
        try {
            while (true){
                char c = nextChar();
                data.write(c);
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() {
        char c = filter.charAt(index);
        index = (index + 1) % filter.length();
        return c;
    }
}
