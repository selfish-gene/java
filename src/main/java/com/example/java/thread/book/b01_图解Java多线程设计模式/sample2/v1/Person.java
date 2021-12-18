package com.example.java.thread.book.b01_图解Java多线程设计模式.sample2.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/01 22:57<br>
 */
public final class Person {
    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String toString () {
        return "[ Person: name = " + name + ", address = " + address + " ]";
    }
}
