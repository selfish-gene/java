package com.example.java.basic.juc.mashibing.c_026_01_ThreadPool;

import java.util.concurrent.Callable;

public class T03_Callable {
    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("Created by Callable");
            return 1;
        }
    }

    public static void main(String[] args) throws Exception {
        Integer call = new MyCallable().call();
        System.out.println(call);
    }
}
