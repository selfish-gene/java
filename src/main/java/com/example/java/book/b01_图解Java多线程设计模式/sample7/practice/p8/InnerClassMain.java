package com.example.java.book.b01_图解Java多线程设计模式.sample7.practice.p8;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/21 21:39<br>
 */
public class InnerClassMain {
    public static void main(String[] args) {
        // tip 
        Thread.currentThread().setName("InnerClassMain");
        Log.println("main:begin");
        new Executor(){
            @Override
            public void execute(Runnable command) {
                Log.println("execute:begin");
                new ThreadFactory(){
                    @Override
                    public Thread newThread(Runnable r) {
                        Log.println("newThread:begin");
                        Thread t = new Thread(r, "QuizThread");
                        Log.println("newThread:end");
                        return t;
                    }
                }.newThread(command).start();
                Log.println("execute:end");
            }
        }.execute(
                (Runnable) () -> {
                    Log.println("run:begin");
                    Log.println("run:hello!");
                    Log.println("run:end");
                }
        );
        Log.println("main:end");
    }
}
