package com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod;

/**
 * 抽象工厂
 * https://www.processon.com/diagraming/61e2b77d1e085306c96dbf7d
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/15 19:43<br>
 */
public abstract class AbstractFactory {
    public abstract Food createFood();
    public abstract Vehicle createVehicle();
    public abstract Weapon createWeapon();
}
