package com.example.java.book.b01_图解Java多线程设计模式.sample3.practice.p5;

import com.example.java.book.b01_图解Java多线程设计模式.sample3.v1.Request;
import com.example.java.book.b01_图解Java多线程设计模式.sample3.v1.RequestQueue;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/04 0:18<br>
 */
public class SeedMain {
    public static void main(String[] args) {
        RequestQueue requestQueue1 = new RequestQueue();
        RequestQueue requestQueue2 = new RequestQueue();
        // tip seed
        requestQueue1.putRequest(new Request("Hello"));
        new TaskThread(requestQueue1, requestQueue2, "Alice").start();
        new TaskThread(requestQueue2, requestQueue1, "Bobby").start();
    }
}
