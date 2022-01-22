package com.example.java.book.b01_图解Java多线程设计模式.sample5.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/08 13:38<br>
 */
public class ClearThread extends Thread {
    private final Table table;

    public ClearThread(String name, Table table) {
        super(name);
        this.table = table;
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(1000);
                System.out.println("======" + getName() + " clears ======");
                table.clear();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
