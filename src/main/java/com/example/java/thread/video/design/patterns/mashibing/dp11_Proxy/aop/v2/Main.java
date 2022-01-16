package com.example.java.thread.video.design.patterns.mashibing.dp11_Proxy.aop.v2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/16 8:40<br>
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app_auto.xml");
        TankV2 tank = (TankV2)context.getBean("tank");
        tank.move();
    }
}
