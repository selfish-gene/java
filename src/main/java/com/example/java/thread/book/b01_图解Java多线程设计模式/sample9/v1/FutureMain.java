package com.example.java.thread.book.b01_图解Java多线程设计模式.sample9.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/09/02 22:01<br>
 */
public class FutureMain {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host();
        Data data1 = host.request(10, 'A');
        Data data2 = host.request(20, 'B');
        Data data3 = host.request(30, 'C');

        System.out.println("main otherJob BEGIN");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main otherJob END");

        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("data3 = " + data3.getContent());
        System.out.println("main END");
    }
}
