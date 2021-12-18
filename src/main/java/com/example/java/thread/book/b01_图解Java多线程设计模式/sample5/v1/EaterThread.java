package com.example.java.thread.book.b01_图解Java多线程设计模式.sample5.v1;

import java.util.Random;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/07 0:49<br>
 */
public class EaterThread extends Thread{
    private final Random random;
    private final Table table;
    public EaterThread(String name, Table table, long seed) {
        super(name);
        this.random = new Random(seed);
        this.table = table;
    }

    @Override
    public void run() {
        try {
            while (true){
                String take = table.take();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
