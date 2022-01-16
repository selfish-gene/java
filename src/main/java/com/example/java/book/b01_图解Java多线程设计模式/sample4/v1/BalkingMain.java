package com.example.java.book.b01_图解Java多线程设计模式.sample4.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/05 20:03<br>
 */
public class BalkingMain {
    public static void main(String[] args) {
        Data data = new Data("D:\\data.txt", "nothing");
        new ChangerThread("ChangerThread", data).start();
        new ServerThread("ServerThread", data).start();
    }
}
