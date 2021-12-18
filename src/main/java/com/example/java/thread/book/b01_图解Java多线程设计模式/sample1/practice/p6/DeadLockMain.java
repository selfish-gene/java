package com.example.java.thread.book.b01_图解Java多线程设计模式.sample1.practice.p6;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 20:45<br>
 */
public class DeadLockMain {
    public static void main(String[] args) {
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");
//        new EaterThread("Alice", spoon, fork).start();
//        new EaterThread("Bobby", fork, spoon).start();
        // tip 解决方法1 以相同的顺序拿餐具
//        new EaterThread("Alice", spoon, fork).start();
//        new EaterThread("Bobby", spoon, fork).start();
        // tip 解决方法2 成对拿取
        Pair pair = new Pair(spoon, fork);
        new EaterPairThread("Alice", pair).start();
        new EaterPairThread("Bobby", pair).start();
    }
}
