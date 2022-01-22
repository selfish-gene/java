package com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod.magic;

import com.example.java.video.design.patterns.mashibing.dp4_AbstractMehtod.Weapon;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/15 19:55<br>
 */
public class MagicStick extends Weapon {
    @Override
    public void shoot() {
        System.out.println("diu diu diu ...");
    }
}
