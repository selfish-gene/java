package com.example.java.thread.video.design.patterns.mashibing.dp11_Proxy.v2;

/**
 * 问题：想记录坦克的移动时间
 * 最简单的办法：修改代码，记录时间
 * 问题2：如果无法改变方法源码呢？ benchmark
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/16 16:47<br>
 */
public class Tank implements Movable {

    public static void main(String[] args) {
        new Tank().move();
    }

    /**
     * 模拟坦克移动了一段儿时间
     */
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("Tank moving cla cla cla ...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

interface Movable {
    void move();
}
