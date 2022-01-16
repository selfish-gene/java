package com.example.java.book.b01_图解Java多线程设计模式.sample5.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/07 0:43<br>
 */
public class ProducerConsumerMain {
    public static void main(String[] args) {
        Table table = new Table(3);
        Thread[] threads = {
                new MakerThread("MakerThread-1", table, 31415),
                new MakerThread("MakerThread-2", table, 92653),
                new MakerThread("MakerThread-3", table, 58979),
                new EaterThread("EaterThread-1", table, 32384),
                new EaterThread("EaterThread-2", table, 62643),
                new EaterThread("EaterThread-3", table, 38327)
        };
        for (Thread thread : threads) {
            thread.start();
        }
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // practice 5-6
        System.out.println(" ***** interrupt *****");
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
