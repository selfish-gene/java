package com.example.java.thread.video.design.patterns.mashibing.dp2_Strategy;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/15 9:46<br>
 */
public class DogComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.food - o2.food;
    }
}
