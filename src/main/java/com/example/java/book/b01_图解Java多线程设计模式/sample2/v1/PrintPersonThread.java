package com.example.java.book.b01_图解Java多线程设计模式.sample2.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 23:06<br>
 */
public class PrintPersonThread extends Thread {
    private Person person;

    public PrintPersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName() + " prints " + person);
        }
    }
}
