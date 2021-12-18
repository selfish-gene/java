package com.example.java.thread.book.b01_图解Java多线程设计模式;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 8:18<br>
 */
public class BookMain {
    public static void main(String[] args) throws Exception {
        System.out.println("This is book!");
        System.out.print("|");
        for (int i = 0; i < 20; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("| muti.thread -> ");
        System.out.println("  | design.patterns -> 图解Java多线程设计模式");
        System.out.println("| jvm -> 深入理解Java虚拟机");
    }
}
