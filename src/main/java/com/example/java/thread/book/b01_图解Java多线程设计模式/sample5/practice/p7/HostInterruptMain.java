package com.example.java.thread.book.b01_图解Java多线程设计模式.sample5.practice.p7;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 13:50<br>
 */
public class HostInterruptMain {
    public static void main(String[] args) {
        Thread executor = new Thread(() -> {
            System.out.println("Host.execute begin,");
            try {
                Host.execute(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Host.execute end.");
        });
        executor.start();
        try {
            Thread.sleep(15 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("***** interrupt *****");
        // tip 虽然是15秒左右执行 interrupt 方法，但 InterruptedException 异常是在20秒左右才抛出的，也就是下一次执行开始时，线程才检测到中断状态。
        executor.interrupt();
    }
}
