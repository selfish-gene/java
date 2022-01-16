package com.example.java.thread.video.design.patterns.mashibing.dp5_spring.v2;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/16 8:40<br>
 */
public class Tank {

    public void move(){
        System.out.println("Tank move cla cla cla ...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
