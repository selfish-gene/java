package com.example.java.video.design.patterns.mashibing.dp8_Observer.v4;

/**
 * 加入多个观察者
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
    private Dad dad = new Dad();
    private Mum mum = new Mum();
    private Dog dog = new Dog();

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        dad.feed();
        mum.hug();
        dog.bark();
    }
}

class Dad {
    public void feed() {
        System.out.println("dad feeding ...");
    }
}

class Mum {
    public void hug() {
        System.out.println("mum hugging ...");
    }
}

class Dog {
    public void bark() {
        System.out.println("dog barking ...");
    }
}
