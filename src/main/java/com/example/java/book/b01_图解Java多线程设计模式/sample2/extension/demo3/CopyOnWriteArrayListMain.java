package com.example.java.book.b01_图解Java多线程设计模式.sample2.extension.demo3;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 23:17<br>
 */
public class CopyOnWriteArrayListMain {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}