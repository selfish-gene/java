package com.example.java.thread.book.b01_图解Java多线程设计模式.sample1.practice.p6;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 20:46<br>
 */
public class EaterPairThread extends Thread{
    private String name;
    private final Pair pair;

    public EaterPairThread(String name, Pair pair) {
        this.name = name;
        this.pair = pair;
    }

    @Override
    public void run() {
        while (true){
            eat();
        }
    }

    private void eat() {
        synchronized (pair){
            System.out.println(name + " takes up " + pair + ".");
            System.out.println(name + " is eating now, yum yum!");
            System.out.println(name + " puts down " + pair + ".");
        }
    }
}
