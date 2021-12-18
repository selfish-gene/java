package com.example.java.thread.book.b01_图解Java多线程设计模式.sample1.extension.samephore;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 11:25<br>
 */
public class SemaphoreMain {
    public static void main(String[] args) {
        BoundedResource resource = new BoundedResource(3);
        for (int i = 0; i < 10; i++) {
            new UserThread(resource).start();
        }
    }
}
