package com.example.java.book.b01_图解Java多线程设计模式.sample1.practice.p7.v2;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 21:07<br>
 */
public final class MutexV2 {
    private long locks = 0L;
    private Thread owner = null;
    public synchronized void lock(){
        Thread me = Thread.currentThread();
        while (locks > 0 && owner != me){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assert locks == 0 || owner == me;
        owner = me;
        locks++;
    }
    public synchronized void unlock(){
        Thread me = Thread.currentThread();
        if(locks == 0 || owner != me){
            return;
        }
        assert locks > 0 && owner == me;
        locks--;
        if(locks == 0){
            owner = null;
            notifyAll();
        }
    }
}
