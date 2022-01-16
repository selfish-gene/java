package com.example.java.book.b01_图解Java多线程设计模式.sample1.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 10:58<br>
 */
public class SingleThreadedExecutionMain {
    public static void main(String[] args) {
        System.out.println("Begin ");
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}
/*
 * 部分执行结果：
 * ****** Broken ******No.465997000: Alice, Alaska
 * ****** Broken ******No.465998461: Alice, Alaska
 * ****** Broken ******No.465999195: Alice, Alaska
 * ****** Broken ******No.465999881: Alice, Alaska
 * ****** Broken ******No.466000541: Alice, Alaska
 * ****** Broken ******No.466001224: Alice, Alaska
 * ****** Broken ******No.466001989: Alice, Alaska
 * ****** Broken ******No.466002714: Alice, Alaska
 * ****** Broken ******No.465994826: Alice, Alaska
 * ****** Broken ******No.466003623: Alice, Alaska
 * ****** Broken ******No.466005149: Alice, Alaska
 * ****** Broken ******No.466008282: Alice, Alaska
 * ****** Broken ******No.466010693: Chris, Alaska
 * ****** Broken ******No.466009552: Alice, Alaska
 * ****** Broken ******No.466010693: Chris, Alaska
 * ****** Broken ******No.466012414: Bobby, Brazil
 *
 * 两种现象：
 * 1.不一致的输出Broken
 * 2.一致的也输出Broken
 *      在调用check方法执行判断的过程，不一致，但执行打印的过程中，gate中的值被重新赋值
 *      常用的分析方法：多线程的时序图
 */