package com.example.java.thread.video.design.patterns.mashibing.dp8_Observer.v5;

import java.util.ArrayList;
import java.util.List;

/**
 * 分离观察者与被观察者
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
    private final List<Observer> observerList = new ArrayList<>();

    {
        observerList.add(new Dad());
        observerList.add(new Mum());
        observerList.add(new Dog());
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        for (Observer o : observerList) {
            o.actionOnWakeUP();
        }
    }
}

interface Observer {
    void actionOnWakeUP();
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding ...");
    }

    @Override
    public void actionOnWakeUP() {
        feed();
    }
}

class Mum implements Observer {
    public void hug() {
        System.out.println("mum hugging ...");
    }

    @Override
    public void actionOnWakeUP() {
        hug();
    }
}

class Dog implements Observer {
    public void bark() {
        System.out.println("dog barking ...");
    }

    @Override
    public void actionOnWakeUP() {
        bark();
    }
}
