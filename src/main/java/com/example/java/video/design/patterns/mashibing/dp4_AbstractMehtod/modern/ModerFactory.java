package com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod.modern;

import com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod.AbstractFactory;
import com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod.Food;
import com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod.Vehicle;
import com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod.Weapon;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/15 19:57<br>
 */
public class ModerFactory extends AbstractFactory {
    @Override
    public Food createFood() {
        return new Bread();
    }

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }
}
