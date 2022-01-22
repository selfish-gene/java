package com.example.java.book.b01_图解Java多线程设计模式.sample3.practice.p6;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/04 22:08<br>
 */
public class InterruptMain {
    public static void main(String[] args) {
        InterruptRequestQueue requestQueue = new InterruptRequestQueue();
        Thread alice = new InterruptClientThread(requestQueue, "Alice", 314159L);
        Thread bobby = new InterruptServerThread(requestQueue, "Bobby", 265358L);
        alice.start();
        bobby.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 调用 Interrupt 方法
        System.out.println(" ****** calling interrupt ******");
        alice.interrupt();
        bobby.interrupt();
    }
}
