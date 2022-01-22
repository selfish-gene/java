package com.example.java.book.b01_图解Java多线程设计模式.sample2.extension.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 23:17<br>
 */
public class ArrayListMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
/*
运行结果如下：
Exception in thread "Thread-1" java.util.ConcurrentModificationException
	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1043)
	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:997)
	at com.example.java.thread.book.sample2.extension.demo1.ReaderThread.run(ReaderThread.java:21)
 */
