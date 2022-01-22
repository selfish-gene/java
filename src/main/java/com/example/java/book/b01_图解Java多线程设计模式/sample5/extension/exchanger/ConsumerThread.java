package com.example.java.book.b01_图解Java多线程设计模式.sample5.extension.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * 使用 exchange 方法将空的缓冲区传递给 ProducerThread
 * 传递空的缓冲区后，作为交换，接收被填满字符的缓冲区
 * 使用缓冲区的字符（显示）
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 12:32<br>
 */
public class ConsumerThread extends Thread{
    private final Exchanger<char[]> exchanger;
    private char[] buffer = null;
    private final Random random;
    public ConsumerThread(Exchanger<char[]> exchanger, char[] buffer, long seed) {
        super("ConsumerThread");
        this.exchanger = exchanger;
        this.buffer = buffer;
        this.random = new Random(seed);
    }
    @Override
    public void run() {
        try {
            while (true){
                // 交换缓冲区
                System.out.println(Thread.currentThread().getName() + ": BEFORE exchange");
                buffer = exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName() + ": AFTER exchange");
                // 从缓冲区中取出字符
                for (int i = 0; i < buffer.length; i++) {
                    System.out.println(Thread.currentThread().getName() + ": -> " + buffer[i]);
                    Thread.sleep(random.nextInt(1000));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
