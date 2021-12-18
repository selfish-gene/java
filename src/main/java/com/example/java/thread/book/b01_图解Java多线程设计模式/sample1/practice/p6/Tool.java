package com.example.java.thread.book.b01_图解Java多线程设计模式.sample1.practice.p6;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 20:45<br>
 */
public class Tool {
    private final String name;

    public Tool(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "name='" + name + '\'' +
                '}';
    }
}
