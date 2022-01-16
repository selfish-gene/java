package com.example.java.book.b01_图解Java多线程设计模式.sample2.practice.p5;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 19:00<br>
 */
public class ImmutableLine {
    private final Point startPoint;
    private final Point endPoint;

    public ImmutableLine(Point startPoint, Point endPoint) {
        // tip 修改这里
        this.startPoint = new Point(startPoint.x, startPoint.y);
        this.endPoint = new Point(endPoint.x, endPoint.y);
    }
    public ImmutableLine(int startX, int startY, int endX, int endY){
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
        return "ImmutableLine{" +
                "startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                '}';
    }
}
