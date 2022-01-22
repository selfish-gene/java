package com.example.java.book.b01_图解Java多线程设计模式.sample2.practice.p2;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 18:23<br>
 */
public class P2Main {
    public static void main(String[] args) {
        String s = "BAT";
        // 如何说明 String 类符合immutable模式
        System.out.println(s.replace('B', 'C'));
        // 以下为参考答案
        String t = s.replace('B', 'C');
        System.out.println("s = " + s); // s的值依然为BAT
        System.out.println("t = " + t); // 新的返回值为CAT
        if(s == t){
            System.out.println("s == t");
        } else {
            System.out.println("s != t"); // 两个实例不一样
        }
    }
}
