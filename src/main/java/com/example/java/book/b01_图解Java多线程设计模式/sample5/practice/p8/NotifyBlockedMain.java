package com.example.java.book.b01_图解Java多线程设计模式.sample5.practice.p8;

import com.example.java.book.b01_图解Java多线程设计模式.sample5.v1.EaterThread;
import com.example.java.book.b01_图解Java多线程设计模式.sample5.v1.MakerThread;
import com.example.java.book.b01_图解Java多线程设计模式.sample5.v1.Table;

/**
 * 不相关的线程进入等待队列时，如果 notify 恰巧唤醒了该线程，那么就会造成 notify 通知失灵的情况
 * 因此，建议 tip 隐藏获取锁的对象（即隐藏table类，将其保存在局部变量或者private变量中）
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 14:13<br>
 */
public class NotifyBlockedMain {
    public static void main(String[] args) {
        Table table = new Table(3);
        Thread[] threads = {
                new MakerThread("MakerThread-1", table, 31415),
                new MakerThread("MakerThread-2", table, 92653),
                new MakerThread("MakerThread-3", table, 58979),
                new EaterThread("EaterThread-1", table, 32384),
                new EaterThread("EaterThread-2", table, 62643),
                new EaterThread("EaterThread-3", table, 38327),
                new LazyThread("LazyThread-1", table),
                new LazyThread("LazyThread-2", table),
                new LazyThread("LazyThread-3", table),
                new LazyThread("LazyThread-4", table),
                new LazyThread("LazyThread-5", table),
                new LazyThread("LazyThread-6", table),
        };
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
