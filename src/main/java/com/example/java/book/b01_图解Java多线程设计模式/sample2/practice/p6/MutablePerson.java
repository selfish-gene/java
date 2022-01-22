package com.example.java.book.b01_图解Java多线程设计模式.sample2.practice.p6;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 19:16<br>
 */
public final class MutablePerson {
    private String name;
    private String address;

    public MutablePerson(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public MutablePerson(ImmutablePerson immutablePerson){
        this.name = immutablePerson.getName();
        this.address = immutablePerson.getAddress();
    }

    public synchronized void setPerson(String newName, String newAddress){
        this.name = newName;
        this.address = newAddress;
    }

    public synchronized ImmutablePerson getImmutablePerson(){
        return new ImmutablePerson(this);
    }

    /**
     * 包访问权限
     * @return name
     */
    String getName() {
        return name;
    }
    /**
     * 包访问权限
     * @return address
     */
    String getAddress() {
        return address;
    }

    @Override
    public synchronized String toString() {
        return "MutablePerson{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
