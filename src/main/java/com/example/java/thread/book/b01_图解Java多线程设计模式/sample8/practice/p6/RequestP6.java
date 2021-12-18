package com.example.java.thread.book.b01_图解Java多线程设计模式.sample8.practice.p6;

import java.util.Random;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/22 9:16<br>
 */
public class RequestP6 {
    private final String name;
    private final int number;
    private static final Random random = new Random();

    public RequestP6(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute(){
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
