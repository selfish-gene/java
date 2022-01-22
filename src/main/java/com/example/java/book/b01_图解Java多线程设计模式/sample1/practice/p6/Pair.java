package com.example.java.book.b01_图解Java多线程设计模式.sample1.practice.p6;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 20:53<br>
 */
public class Pair {
    private final Tool lefthand;
    private final Tool righthand;

    public Pair(Tool lefthand, Tool righthand) {
        this.lefthand = lefthand;
        this.righthand = righthand;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "lefthand=" + lefthand +
                ", righthand=" + righthand +
                '}';
    }
}
