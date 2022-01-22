package com.example.java.book.b01_图解Java多线程设计模式.sample7.extension.v2;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/15 17:25<br>
 */
public class ThreadPerMessageV2Main {
    public static void main(String[] args) {
        System.out.println("main Begin ...");
        HostV2 host = new HostV2(Thread::new);
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main End ...");
    }
}
