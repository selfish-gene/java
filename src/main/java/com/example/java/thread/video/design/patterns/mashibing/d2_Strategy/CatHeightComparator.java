package com.example.java.thread.video.design.patterns.mashibing.d2_strategy;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/15 9:42<br>
 */
public class CatHeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        return Integer.compare(o2.height, o1.height);
    }
}
