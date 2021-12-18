package com.example.java.thread.book.b01_图解Java多线程设计模式.sample2.extension.demo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 23:17<br>
 */
public class SynchronizedListMain {
    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}