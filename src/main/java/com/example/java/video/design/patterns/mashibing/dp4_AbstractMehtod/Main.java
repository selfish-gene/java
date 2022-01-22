package com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod;

import com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod.magic.MagicFactory;
import com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod.modern.ModerFactory;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/15 19:58<br>
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory f = new ModerFactory();
        Food food = f.createFood();
        food.printName();
        Vehicle vehicle = f.createVehicle();
        vehicle.go();
        Weapon weapon = f.createWeapon();
        weapon.shoot();
        System.out.println("------------------------");
        f = new MagicFactory();
        food = f.createFood();
        food.printName();
        vehicle = f.createVehicle();
        vehicle.go();
        weapon = f.createWeapon();
        weapon.shoot();
    }
}
