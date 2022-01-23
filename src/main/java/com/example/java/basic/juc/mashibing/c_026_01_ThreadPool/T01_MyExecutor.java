package com.example.java.basic.juc.mashibing.c_026_01_ThreadPool;

import java.util.concurrent.Executor;

public class T01_MyExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String[] args) {
        new T01_MyExecutor().execute(() -> System.out.println("T01_MyExecutor"));
    }
}
