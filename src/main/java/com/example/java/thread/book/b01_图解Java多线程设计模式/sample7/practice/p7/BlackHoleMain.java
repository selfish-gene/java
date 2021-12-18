package com.example.java.thread.book.b01_图解Java多线程设计模式.sample7.practice.p7;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/21 21:12<br>
 */
public class BlackHoleMain {
    public static void main(String[] args) {
        System.out.println("BEGIN");
        BlackHole.enter(new Object());
        System.out.println("END");
    }
}
