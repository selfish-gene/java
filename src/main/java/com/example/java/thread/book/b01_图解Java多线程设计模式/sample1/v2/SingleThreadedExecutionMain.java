package com.example.java.thread.book.b01_图解Java多线程设计模式.sample1.v2;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 10:58<br>
 */
public class SingleThreadedExecutionMain {
    public static void main(String[] args) {
        System.out.println("Begin ");
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}