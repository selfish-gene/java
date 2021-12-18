package com.example.java.thread.book.b01_图解Java多线程设计模式.sample4.v1;

import java.io.IOException;
import java.util.Random;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/05 20:00<br>
 */
public class ChangerThread extends Thread{
    private final Data data;
    private final Random random = new Random();

    public ChangerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change("No." + i);
                Thread.sleep(random.nextInt(1000));
                data.save();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
