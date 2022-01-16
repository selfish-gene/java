package com.example.java.thread.video.design.patterns.mashibing.dp8_Observer.v2;

/**
 * 面向对象的傻等
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/16 14:23<br>
 */
public class Main {

    public static void main(String[] args) {
        Child child = new Child();
        while(!child.isCry()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" observing ...");
        }
    }
}

class Child{
    private boolean cry = false;

    public boolean isCry() {
        return cry;
    }

    public void wakeUp(){
        System.out.println("Waked up! wu wu wu ...");
        cry = true;
    }
}
