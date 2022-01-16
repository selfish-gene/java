package com.example.java.thread.video.design.patterns.mashibing.dp3_FactoryMethod;

/**
 * 简单工厂
 * 可扩展性不好
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/15 19:11<br>
 */
public class SimpleVehicleFactory {
    public Car createCar() {
        return new Car();
    }

    public Broom createBroom() {
        return new Broom();
    }
}
