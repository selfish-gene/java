package com.example.java.thread.book.b01_图解Java多线程设计模式.sample1.practice.p5;

/**
 * tip 该类不是线程安全的，但证明其非安全的代码不好实现
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 20:26<br>
 */
public class SecurityGateV2 {
    private int counter = 0;
    public void enter(){
        int currentCounter = counter;
        Thread.yield();
        counter = currentCounter + 1;
    }
    public void exit(){
        int currentCounter = counter;
        Thread.yield();
        counter = currentCounter - 1;
    }

    public int getCounter() {
        return counter;
    }
}
