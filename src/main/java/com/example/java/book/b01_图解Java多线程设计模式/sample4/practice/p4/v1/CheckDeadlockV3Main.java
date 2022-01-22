package com.example.java.book.b01_图解Java多线程设计模式.sample4.practice.p4.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/04 0:18<br>
 */
public class CheckDeadlockV3Main {
    public static void main(String[] args) {
        RequestQueueV3 requestQueue1 = new RequestQueueV3();
        RequestQueueV3 requestQueue2 = new RequestQueueV3();
        new CheckDeadlockV3TaskThread(requestQueue1, requestQueue2, "Alice").start();
        new CheckDeadlockV3TaskThread(requestQueue2, requestQueue1, "Bobby").start();
    }
}
