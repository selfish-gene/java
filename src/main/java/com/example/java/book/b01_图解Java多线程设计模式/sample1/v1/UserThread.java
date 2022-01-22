package com.example.java.book.b01_图解Java多线程设计模式.sample1.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 10:54<br>
 */
public class UserThread extends Thread{

    private final Gate gate;
    private final String myname;
    private final String myaddress;

    public UserThread(Gate gate, String myname, String myaddress){
        this.gate = gate;
        this.myname = myname;
        this.myaddress = myaddress;
    }

    @Override
    public void run() {
        System.out.println(myaddress + " Begin");
        while (true){
            gate.pass(myname, myaddress);
        }
    }
}
