package com.example.java.book.b01_图解Java多线程设计模式.sample4.extension;

import java.util.concurrent.TimeoutException;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/05 21:15<br>
 */
public class TimeoutExceptionMain {
    public static void main(String[] args) {
        Host host = new Host(10000);
        try {
            System.out.println("execute BEGIN");
            host.execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
