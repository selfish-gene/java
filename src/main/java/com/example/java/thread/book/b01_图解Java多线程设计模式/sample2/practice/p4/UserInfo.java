package com.example.java.thread.book.b01_图解Java多线程设计模式.sample2.practice.p4;

/**
 * tip 为什么不是immutable类呢？
 * @see UserInfoMain
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 18:47<br>
 */
public final class UserInfo {
    private final StringBuffer info;

    public UserInfo(String name, String address) {
        this.info = new StringBuffer("<info name=\"" + name + "\" + address=\"" + address + "\"  />");
    }
    public StringBuffer getInfo(){
        return info;
    }
    public String toString(){
        return "[ UserInfo: " + info + " ]";
    }
}
