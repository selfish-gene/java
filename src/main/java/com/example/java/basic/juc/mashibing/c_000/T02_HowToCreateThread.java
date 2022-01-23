package com.example.java.basic.juc.mashibing.c_000;

import java.util.concurrent.Callable;

public class T02_HowToCreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Created by Thread");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Created by Runnable");
        }
    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("Created by Callable");
            return 1;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyThread().start();
        new Thread(new MyRun()).start();
        Integer call = new MyCallable().call();
        System.out.println(call);
    }
}
