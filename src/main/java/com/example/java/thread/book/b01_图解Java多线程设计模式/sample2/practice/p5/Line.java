package com.example.java.thread.book.b01_图解Java多线程设计模式.sample2.practice.p5;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 19:00<br>
 */
public class Line {
    private final Point startPoint;
    private final Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    public Line(int startX, int startY, int endX, int endY){
        this.startPoint = new Point(startX, startY);
        this.endPoint = new Point(endX, endY);
    }
    public int getStartX(){
        return startPoint.getX();
    }
    public int getStartY(){
        return startPoint.getY();
    }
    public int getEndX(){
        return endPoint.getX();
    }
    public int getEndY(){
        return endPoint.getY();
    }

    @Override
    public String toString() {
        return "Line{" +
                "startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                '}';
    }
}
