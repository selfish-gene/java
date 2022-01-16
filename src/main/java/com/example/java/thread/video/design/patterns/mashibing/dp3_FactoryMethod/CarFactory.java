package com.example.java.thread.video.design.patterns.mashibing.dp3_FactoryMethod;

/**
 * 工厂方法
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/15 19:07<br>
 */
public class CarFactory {
    public Moveable create(){
        System.out.println("A car is created.");
        return new Car();
    }
}
