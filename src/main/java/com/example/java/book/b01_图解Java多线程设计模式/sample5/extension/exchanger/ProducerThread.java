package com.example.java.book.b01_图解Java多线程设计模式.sample5.extension.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 *
 * 填充字符，直至缓冲区被填满
 * 使用 exchange 方法将填满的缓冲区传递给 ConsumerThread
 * 传递缓冲区后，作为交换，接收空的缓冲区
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 12:30<br>
 */
public class ProducerThread extends Thread{
    private final Exchanger<char[]> exchanger;
    private char[] buffer = null;
    private char index = 0;
    private final Random random;

    public ProducerThread(Exchanger<char[]> exchanger, char[] buffer, long seed) {
        super("ProducerThread");
        this.exchanger = exchanger;
        this.buffer = buffer;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            while (true){
                // 向缓冲区填充字符
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = nextChar();
                    System.out.println(Thread.currentThread().getName() + ": " + buffer[i] + " -> ");
                }
                // 交换缓冲区字符
                System.out.println(Thread.currentThread().getName() + ": BEFORE exchange");
                buffer = exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName() + ": AFTER exchange");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() throws InterruptedException {
        char c = (char)('A' + index % 26);
        index++;
        Thread.sleep(random.nextInt(1000));
        return c;
    }
}
