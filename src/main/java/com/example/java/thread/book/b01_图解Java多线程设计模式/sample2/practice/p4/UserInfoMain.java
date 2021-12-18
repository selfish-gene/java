package com.example.java.thread.book.b01_图解Java多线程设计模式.sample2.practice.p4;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 18:53<br>
 */
public class UserInfoMain {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("Alice", "Alaska");
        System.out.println("Userinfo = " + userInfo);
        // 修改状态
        StringBuffer info = userInfo.getInfo();
        info.replace(12, 17, "Bobby");
        System.out.println("Userinfo = " + userInfo);
    }
}
