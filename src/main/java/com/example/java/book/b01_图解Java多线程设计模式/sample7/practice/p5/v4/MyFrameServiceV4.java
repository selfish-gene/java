package com.example.java.book.b01_图解Java多线程设计模式.sample7.practice.p5.v4;

/**
 * 用户连续按下按钮时，取消执行中的处理
 * Thread-Per-Message
 * Balking
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/21 20:12<br>
 */
public class MyFrameServiceV4 {
    private static Thread worker = null;
    public static synchronized void service() {
        if(worker != null && worker.isAlive()){
            worker.interrupt();
            try {
                worker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            worker = null;
        }
        System.out.print("MyFrameServiceV4");
        worker = new Thread(MyFrameServiceV4::doService);
        worker.start();
    }

    public static void doService() {
        try {
            System.out.println("MyFrameServiceV4");
            for (int i = 0; i < 50; i++) {
                System.out.print(".");
                    Thread.sleep(100);
            }
            System.out.println("done.");
        } catch (InterruptedException e){
            System.out.println("cancelled.");
        }
    }
}
