package com.example.java.thread.video.design.patterns.mashibing.d2_Strategy;

import java.util.Arrays;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/15 9:53<br>
 */
public class Main {
    public static void main(String[] args) {
        Cat[] cats = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
        Sorter<Cat> sorter = new Sorter<>();
        sorter.sort(cats, (o1, o2) -> Integer.compare(o1.weight, o2.weight));
        System.out.println(Arrays.toString(cats));

        Dog[] dogs = {new Dog(3),new Dog(5),new Dog(1)};
        Sorter<Dog> dogSorter = new Sorter<>();
        dogSorter.sort(dogs, (d1, d2) -> Integer.compare(d1.food, d2.food));
        System.out.println(Arrays.toString(dogs));

    }
}
