package com.example.java.book.b01_图解Java多线程设计模式.sample7.practice.p5;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/21 20:12<br>
 */
public class MyFrameService {
    public static void service() {
        System.out.println("service");
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("done.");
    }
}
