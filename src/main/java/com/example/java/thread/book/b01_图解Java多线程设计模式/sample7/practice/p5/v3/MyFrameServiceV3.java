package com.example.java.thread.book.b01_图解Java多线程设计模式.sample7.practice.p5.v3;

/**
 * 用户连续按下按钮时，保证只有第一个线程在执行，其余的线程balk
 * Thread-Per-Message
 * Balking
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/21 20:12<br>
 */
public class MyFrameServiceV3 {
    private static volatile boolean working = false;

    /**
     * Balking
     */
    public static synchronized void service() {
        if(working){
            System.out.println(" is balked");
            return;
        }
        working = true;
        new Thread(MyFrameServiceV3::doService).start();
    }

    public static void doService() {
        try {
            System.out.println("MyFrameServiceV3");
            for (int i = 0; i < 50; i++) {
                System.out.print(".");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("done.");
        } finally {
            working = false;
        }
    }
}
