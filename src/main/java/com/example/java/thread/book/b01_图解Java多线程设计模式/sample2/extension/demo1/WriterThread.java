package com.example.java.thread.book.b01_图解Java多线程设计模式.sample2.extension.demo1;

import java.util.List;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 23:18<br>
 */
public class WriterThread extends Thread{
    private final List<Integer> list;

    public WriterThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; true; i++) {
            list.add(i);
            list.remove(0);
        }
    }
}
