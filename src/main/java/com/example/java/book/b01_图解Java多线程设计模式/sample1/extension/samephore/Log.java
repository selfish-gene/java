package com.example.java.book.b01_图解Java多线程设计模式.sample1.extension.samephore;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 11:20<br>
 */
public class Log {
    public static void println(String s){
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}
