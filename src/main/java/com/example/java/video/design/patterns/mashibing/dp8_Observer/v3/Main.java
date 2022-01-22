package com.example.java.video.design.patterns.mashibing.dp8_Observer.v3;

/**
 * 加入观察者
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/16 14:27<br>
 */
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}

class Child {
    private boolean cry = false;
    private Dad d = new Dad();

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        d.feed();
    }
}

class Dad {
    public void feed() {
        System.out.println("dad feeding ...");
    }
}
