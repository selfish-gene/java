package com.example.java.thread.book.b01_图解Java多线程设计模式.sample4.practice.p5;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/05 22:03<br>
 */
public class TestThread extends Thread{

    @Override
    public void run() {
        System.out.print("BEGIN");
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("END");
    }
}
