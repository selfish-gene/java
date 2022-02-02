package com.example.java.book.b02_CoreJavaVolume_Fundamentals.chapter3;

public class C01_JavaDataType {
    public static void main(String[] args) {
        testInt();
        testFloat();

    }

    public static void testInt() {
        // 八进制前缀为 0，由于八进制容易与十进制混淆，最好不要使用
        int eight = 010;
        System.out.println(eight);
        // 十六进制前缀 0x 或 0X
        int sixteen = 0xCAFE;
        System.out.println(sixteen);
        // Java7 开始，加上前缀 0b 或 0B 就可以写成二进制数。
        int two = 0b1001; // 0b1001 代表 9
        System.out.println(two);
        // Java7 开始，还可以为数字字面量加下划线
        int num = 1000_000;
        System.out.println(num);
        // 长整型数组有一个后缀 L 或 l
        long l = 1000L;
        System.out.println(l);
    }

    public static void testFloat() {
        // 浮点类型
        double positiveInfinity = Double.POSITIVE_INFINITY;
        System.out.println(positiveInfinity);
        double negativeInfinity = Double.NEGATIVE_INFINITY;
        System.out.println(negativeInfinity);
        double naN = Double.NaN;
        System.out.println(naN);
    }
}
