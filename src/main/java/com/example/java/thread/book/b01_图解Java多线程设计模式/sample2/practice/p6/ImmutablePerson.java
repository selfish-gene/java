package com.example.java.thread.book.b01_图解Java多线程设计模式.sample2.practice.p6;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 19:18<br>
 */
public final class ImmutablePerson {
    private final String name;
    private final String address;

    public ImmutablePerson(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public ImmutablePerson(MutablePerson mutablePerson) {
        synchronized (mutablePerson) {
            // tip 这里存在安全性问题，必须要加同步代码块
            this.name = mutablePerson.getName();
            this.address = mutablePerson.getAddress();
        }
    }

    public MutablePerson getMutablePerson(){
        return new MutablePerson(this);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
