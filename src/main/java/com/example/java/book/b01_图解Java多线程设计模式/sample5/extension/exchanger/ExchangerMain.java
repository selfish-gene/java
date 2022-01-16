package com.example.java.book.b01_图解Java多线程设计模式.sample5.extension.exchanger;

import java.util.concurrent.Exchanger;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 12:29<br>
 */
public class ExchangerMain {
    public static void main(String[] args) {
        Exchanger<char[]> exchanger = new Exchanger<>();
        char[] buffer1 = new char[10];
        char[] buffer2 = new char[10];
        new ProducerThread(exchanger, buffer1, 314159).start();
        new ConsumerThread(exchanger, buffer2, 314159).start();
    }
}
