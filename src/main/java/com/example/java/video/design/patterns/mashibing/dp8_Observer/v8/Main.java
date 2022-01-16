package com.example.java.video.design.patterns.mashibing.dp8_Observer.v8;

import java.util.ArrayList;
import java.util.List;

/**
 * 有很多时候，观察者需要根据事件的具体情况来进行处理
 * 大多数时候，我们处理事件的时候，需要事件源对象
 * 事件也可以形成继承体系
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
        observerList.add((event) -> {
            System.out.println("ppp");
        });
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;

        WakeUpEvent wakeUpEvent = new WakeUpEvent(System.currentTimeMillis(), "bed", this);

        for (Observer o : observerList) {
            o.actionOnWakeUP(wakeUpEvent);
        }
    }
}

abstract class Event<T> {
    abstract T getSource();
}

// 事件类 fire Event
class WakeUpEvent extends Event<Child> {
    long timestamp;
    String loc;
    Child source;

    public WakeUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
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
