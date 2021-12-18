package com.example.java.thread.book.b01_图解Java多线程设计模式.sample1.practice.p5;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 20:30<br>
 */
public class CrackerThread extends Thread{
    private final SecurityGateV2 gateV2;

    public CrackerThread(SecurityGateV2 gateV2) {
        this.gateV2 = gateV2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            gateV2.enter();
            gateV2.exit();
        }
    }
}
