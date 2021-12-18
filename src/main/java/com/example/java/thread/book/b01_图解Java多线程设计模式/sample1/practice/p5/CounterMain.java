package com.example.java.thread.book.b01_图解Java多线程设计模式.sample1.practice.p5;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 20:30<br>
 */
public class CounterMain {
    public static void main(String[] args) {
        System.out.println("Begin ...");
        for (int i = 0; true; i++) {
            SecurityGateV2 gateV2 = new SecurityGateV2();
            CrackerThread[] t = new CrackerThread[5];
            // 启动
            for (int j = 0; j < t.length; j++) {
                t[j] = new CrackerThread(gateV2);
                t[j].start();
            }
            // join
            for (CrackerThread crackerThread : t) {
                try {
                    crackerThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // confirm
            if (gateV2.getCounter() == 0) {
                System.out.println("......");
            } else {
                System.out.println("Not safe");
                System.out.println("getCounter() = " + gateV2.getCounter());
                System.out.println("i = " + i);
                break;
            }
        }
    }
}
