package com.example.java.thread.book.b01_图解Java多线程设计模式.sample9.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/09/02 21:47<br>
 */
public class Host {
    public Data request(final int count, final char c){
        System.out.println("      request(" + count + ", " + c + ") BEGIN");
        // step1.创建 FutureData 实例
        final FutureData future = new FutureData();
        // step2.启动一个新线程，用于创建 RealData 的实例
        new Thread(() -> {
            RealData realData = new RealData(count, c);
            future.setRealData(realData);
        }).start();
        System.out.println("      request(" + count + ", " + c + ") END");
        // step3.返回 FutureData 实例
        return future;
    }
}