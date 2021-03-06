package com.example.java.video.design.patterns.mashibing.dp11_Proxy.aop.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/16 8:41<br>
 */
public class TimeProxy {

    public void before() {
        System.out.println("method start .. " + System.currentTimeMillis());
    }

    public void after() {
        System.out.println("method stop .. " + System.currentTimeMillis());
    }
}
