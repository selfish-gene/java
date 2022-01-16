package com.example.java.thread.video.design.patterns.mashibing.dp5_spring.v2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/16 8:41<br>
 */
@Aspect
public class TimeProxy {

    @Before("execution(void com.example.java.thread.video.design.patterns.mashibing.dp5_spring.v2.TankV2.move())")
    public void before() {
        System.out.println("method start .. " + System.currentTimeMillis());
    }

    @After("execution(void com.example.java.thread.video.design.patterns.mashibing.dp5_spring.v2.TankV2.move())")
    public void after() {
        System.out.println("method stop .. " + System.currentTimeMillis());
    }
}
