package com.example.java.thread.book.b01_图解Java多线程设计模式.sample2.practice.p5;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 19:04<br>
 */
public class LineMain {
    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(100, 0);
        Line line = new Line(p1, p2);
        ImmutableLine immutableLine = new ImmutableLine(p1, p2);
        System.out.println("line = " + line);
        System.out.println("immutableLine = " + immutableLine);
        p1.x = 150;
        p2.x = 150;
        p2.y = 250;
        System.out.println("line = " + line);
        System.out.println("immutableLine = " + immutableLine);
    }
}
