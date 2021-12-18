package com.example.java.thread.book.b01_图解Java多线程设计模式.sample5.practice.p8;

import com.example.java.thread.book.b01_图解Java多线程设计模式.sample5.v1.Table;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 14:13<br>
 */
public class LazyThread extends Thread {
    private final Table table;

    public LazyThread(String name, Table table) {
        super(name);
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (table){
                    table.wait();
                }
                System.out.println(getName() + ": notified!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
