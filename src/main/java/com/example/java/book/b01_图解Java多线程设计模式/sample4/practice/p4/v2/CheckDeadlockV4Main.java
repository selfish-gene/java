package com.example.java.book.b01_图解Java多线程设计模式.sample4.practice.p4.v2;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/04 0:18<br>
 */
public class CheckDeadlockV4Main {
    public static void main(String[] args) {
        RequestQueueV4 requestQueue1 = new RequestQueueV4();
        RequestQueueV4 requestQueue2 = new RequestQueueV4();
        new CheckDeadlockV4TaskThread(requestQueue1, requestQueue2, "Alice").start();
        new CheckDeadlockV4TaskThread(requestQueue2, requestQueue1, "Bobby").start();
    }
}
