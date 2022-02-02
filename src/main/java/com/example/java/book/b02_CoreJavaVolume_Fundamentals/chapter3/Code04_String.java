package com.example.java.book.b02_CoreJavaVolume_Fundamentals.chapter3;

public class Code04_String {
    public static void main(String[] args) {
//        testImmutable();
//        testEqual();
        testStringSplice();
    }

    public static void testImmutable() {
        String a = "abc";
        String newA = a.replace('a', 'd');
        // 结果为 false ，说明地址已经发生变化了
        System.out.println(a == newA); // false
    }

    public static void testEqual() {
        // demo1
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        System.out.println(a.equals(b)); // true
        System.out.println(a == b); // true
        System.out.println(a.equals(c)); // true
        System.out.println(a == c); // false
        // demo2
        String h = "hello";
        System.out.println(h.substring(0, 3) == "hel"); // false
        System.out.println(h.substring(0, 3).equals("hel")); // true
    }

    public static void testStringSplice() {
        // 线程不安全  单线程使用
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append("a");
        }
        System.out.println(stringBuilder);
        // 线程安全 synchronized  多线程使用
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            stringBuffer.append("b");
        }
        System.out.println(stringBuffer);
    }
}
