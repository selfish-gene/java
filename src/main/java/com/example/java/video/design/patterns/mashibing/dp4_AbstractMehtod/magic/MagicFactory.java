package com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod.magic;

import com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod.AbstractFactory;
import com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod.Food;
import com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod.Vehicle;
import com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod.Weapon;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/15 19:56<br>
 */
public class MagicFactory extends AbstractFactory {

    @Override
    public Food createFood() {
        return new MushRoom();
    }

    @Override
    public Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    public Weapon createWeapon() {
        return new MagicStick();
    }
}
