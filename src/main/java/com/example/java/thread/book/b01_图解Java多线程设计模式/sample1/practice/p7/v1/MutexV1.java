package com.example.java.thread.book.b01_图解Java多线程设计模式.sample1.practice.p7.v1;

/**
 * tip 有两个限制
 * 1.不可重入
 * 2.任何人都可以 unlock
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 21:03<br>
 */
public final class MutexV1 {
    private boolean busy = false;
    public synchronized void lock(){
        while (busy){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        busy = true;
    }
    public void unlock(){
        busy = false;
        notifyAll();
    }
}
