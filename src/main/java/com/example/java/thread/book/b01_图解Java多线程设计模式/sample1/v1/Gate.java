package com.example.java.thread.book.b01_图解Java多线程设计模式.sample1.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 10:50<br>
 */
public class Gate {

    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public void pass(String name, String address){
        this.counter++;
        this.name = name;
        // tip 这里sleep，更容易是错误出现
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.address = address;
        check();
    }

    private void check(){
        if(name.charAt(0) != address.charAt(0)){
            System.out.println("****** Broken ******" + this);
        }
    }

    @Override
    public String toString() {
        return "No." + counter + ": " + name + ", " + address;
    }
}
