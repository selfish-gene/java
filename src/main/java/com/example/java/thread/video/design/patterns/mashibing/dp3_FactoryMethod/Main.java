package com.example.java.thread.video.design.patterns.mashibing.dp3_FactoryMethod;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/15 19:12<br>
 */
public class Main {
    public static void main(String[] args) {
        Moveable moveable = new CarFactory().create();
        moveable.go();
    }
}
