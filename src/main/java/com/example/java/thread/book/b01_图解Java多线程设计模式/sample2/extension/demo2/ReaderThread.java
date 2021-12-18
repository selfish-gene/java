package com.example.java.thread.book.b01_图解Java多线程设计模式.sample2.extension.demo2;

import java.util.List;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 23:20<br>
 */
public class ReaderThread extends Thread{
    private final List<Integer> list;

    public ReaderThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            synchronized (list) {
                for (int n : list) {
                    System.out.println(n);
                }
            }
        }
    }
}
