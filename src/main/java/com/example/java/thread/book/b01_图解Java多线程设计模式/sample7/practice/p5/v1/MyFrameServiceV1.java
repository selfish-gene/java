package com.example.java.thread.book.b01_图解Java多线程设计模式.sample7.practice.p5.v1;

/**
 * 用户连续按下按钮几次，就会执行几次，输出会混乱
 * Thread-Per-Message
 * Single Threaded Execution
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/21 20:12<br>
 */
public class MyFrameServiceV1 {
    public static void service() {
        new Thread(MyFrameServiceV1::doService).start();
    }

    /**
     * 加 synchronized 防止多次点击，造成的线程不安全
     */
    public static void doService() {
        System.out.println("MyFrameServiceV1");
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
