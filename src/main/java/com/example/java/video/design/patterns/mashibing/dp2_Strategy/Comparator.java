package com.example.java.video.design.patterns.mashibing.dp2_Strategy;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/15 9:40<br>
 */
@FunctionalInterface
public interface Comparator<T> {

    /**
     * a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     * @param o1 o1
     * @param o2 o2
     * @return int
     */
    int compare(T o1, T o2);

    default void m() {
        System.out.println("m");
    }
}
