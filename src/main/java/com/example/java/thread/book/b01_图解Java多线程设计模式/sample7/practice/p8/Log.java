package com.example.java.thread.book.b01_图解Java多线程设计模式.sample7.practice.p8;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/21 21:38<br>
 */
public class Log {
    public static void println(String s){
        System.out.println(Thread.currentThread().getName() + ":" + s);
    }
}
