package com.example.java.thread.book.b01_图解Java多线程设计模式.sample7.practice.p7;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/21 21:12<br>
 */
public class BlackHole {
    public static void enter(Object obj){
        System.out.println("Step 1");
        magicV2(obj);
        System.out.println("Step 2");
        synchronized (obj) {
            System.out.println("Step 3 (never reached hare)");
        }
    }

    /**
     * 启动新的线程，并保证新的线程获取到 obj 的锁
     * @param obj obj
     */
    private static void magicV1(Object obj) {
        // tip 线程 thread 用来获取 obj 的锁并执行无限循环
        // tip 线程 thread 的名称用作守护条件
        Thread thread = new Thread(){ // inner class
            public void run(){
                synchronized (obj){ // 在此处获取 obj 的锁
                    synchronized (this){
                        this.setName("Locked"); // 改变守护条件
                        this.notify(); // 通知已经获取了 obj 的锁
                    }
                    while (true){} // 无限循环，不释放 obj 的锁
                }
            }
        };
        synchronized (thread){
            thread.setName("");
            thread.start();
            // tip Guarded Suspension 模式
            while (thread.getName().equals("")){
                try {
                    // tip 等待新的线程获取 obj 的锁
                    thread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void magicV2(Object obj) {
        // tip 线程 thread 用来获取 obj 的锁后一直等待自身终止
        Thread thread = new Thread(){ // inner class
            public void run(){
                synchronized (obj){ // 在此处获取 obj 的锁
                    synchronized (this){
                        this.notifyAll();
                    }
                    try {
                        // 一直等待
                        this.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        synchronized (thread){
            thread.start();
            try {
                // tip 等待新的线程获取 obj 的锁
                thread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
