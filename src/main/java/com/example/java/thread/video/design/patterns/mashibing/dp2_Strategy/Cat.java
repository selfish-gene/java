package com.example.java.thread.video.design.patterns.mashibing.dp2_Strategy;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/15 9:35<br>
 */
public class Cat implements Comparable<Cat> {

    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(Cat o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
