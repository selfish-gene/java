package com.example.java.book.b01_图解Java多线程设计模式.sample7.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/15 17:28<br>
 */
public class Helper {
    public void handle(int count, char c){
        System.out.println(" handle(" + count + ", " + c + ") Begin");
        for (int i = 0; i < count; i++) {
            slowly();
            System.out.print(c);
        }
        System.out.println();
        System.out.println(" handle(" + count + ", " + c + ") End");
    }

    private void slowly() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
