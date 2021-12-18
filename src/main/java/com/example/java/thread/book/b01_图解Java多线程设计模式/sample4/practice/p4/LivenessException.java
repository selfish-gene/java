package com.example.java.thread.book.b01_图解Java多线程设计模式.sample4.practice.p4;

/**
 * 使用超时检查死锁
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/05 22:11<br>
 */
public class LivenessException extends RuntimeException{
    public LivenessException(String message) {
        super(message);
    }
}
