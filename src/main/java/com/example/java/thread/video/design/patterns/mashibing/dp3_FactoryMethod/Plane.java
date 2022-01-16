package com.example.java.thread.video.design.patterns.mashibing.dp3_FactoryMethod;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/15 19:10<br>
 */
public class Plane implements Moveable{
    @Override
    public void go() {
        System.out.println("Plane flies shua shua shua ...");
    }
}
