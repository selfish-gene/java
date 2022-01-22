package com.example.java.video.design.patterns.mashibing.dp11_Proxy.v1;

/**
 * 问题：想记录坦克的移动时间
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/16 16:47<br>
 */
public class Tank implements Movable {

    /**
     * 模拟坦克移动了一段儿时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving cla cla cla ...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

interface Movable{
    void move();
}
