package com.example.java.video.design.patterns.mashibing.dp8_Observer.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * 有很多时候，观察者需要根据事件的具体情况来进行处理
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

        WakeUpEvent wakeUpEvent = new WakeUpEvent(System.currentTimeMillis(), "bed");

        for (Observer o : observerList) {
            o.actionOnWakeUP(wakeUpEvent);
        }
    }
}

// 事件类 fire Event
class WakeUpEvent {
    long timestamp;
    String loc;

    public WakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
    }
}

interface Observer {
    void actionOnWakeUP(WakeUpEvent wakeUpEvent);
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding ...");
    }

    @Override
    public void actionOnWakeUP(WakeUpEvent wakeUpEvent) {
        feed();
    }
}

class Mum implements Observer {
    public void hug() {
        System.out.println("mum hugging ...");
    }

    @Override
    public void actionOnWakeUP(WakeUpEvent wakeUpEvent) {
        hug();
    }
}

class Dog implements Observer {
    public void bark() {
        System.out.println("dog barking ...");
    }

    @Override
    public void actionOnWakeUP(WakeUpEvent wakeUpEvent) {
        bark();
    }
}
