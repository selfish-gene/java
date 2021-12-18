package com.example.java.thread.book.b01_图解Java多线程设计模式.sample8.v2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/22 9:15<br>
 */
public class ClientThreadV2 extends Thread{
    private final ExecutorService executorService;
    private static final Random random = new Random();

    public ClientThreadV2(String name, ExecutorService executorService) {
        super(name);
        this.executorService = executorService;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                RequestV2 requestV2 = new RequestV2(getName(), i);
                executorService.execute(requestV2);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RejectedExecutionException e) {
            System.out.println(getName() + " : " + e);
        }
    }
}
