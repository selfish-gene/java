package com.example.java.book.b02_CoreJavaVolume_Fundamentals.chapter5.code2;

public class HashCodeTest {
    public static void main(String[] args) {
        var s = "ok";
        var sb = new StringBuilder(s);
        System.out.println(s.hashCode() + " " + sb.hashCode()); // 3548 769287236
        var t = new String("ok");
        var tb = new StringBuilder(t);
        System.out.println(t.hashCode() + " " + tb.hashCode()); // 3548 205797316
    }
}
