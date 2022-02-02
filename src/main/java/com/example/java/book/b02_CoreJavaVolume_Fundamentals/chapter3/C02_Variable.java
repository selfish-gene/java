package com.example.java.book.b02_CoreJavaVolume_Fundamentals.chapter3;

import java.util.Arrays;

public class C02_Variable {
    public static void main(String[] args) {
        checkUniCode();
        declareVariable();
        finalVariable();
        testEnum();
    }

    public static void checkUniCode() {
        // 判断哪些 Unicode 字符属于 Java 中的 “字母”
        boolean a = Character.isJavaIdentifierStart('a');
        System.out.println(a);
        boolean a1 = Character.isJavaIdentifierPart('a');
        System.out.println(a1);
        boolean javaIdentifierStart = Character.isJavaIdentifierStart('+');
        System.out.println(javaIdentifierStart);
    }

    public static void declareVariable() {
        int a = 1;
        System.out.println(a);
        // since jdk 10 对于局部变量，可以自动推断出类型，不再需要声明类型。
        var b = 10;
        System.out.println(b);
        var c = "hello";
        System.out.println(c);
    }

    public static void finalVariable() {
        // A 为常量
        final double A = 1.2;
        System.out.println(A);
        // B 为类常量 (class constant)
        System.out.println(Constant.B);
    }

    public static class Constant {
        // B 为类常量 (class constant)
        public static final double B = 2.43;
    }

    public static void testEnum() {
        Size small = Size.SMALL;
        System.out.println(small);
        System.out.println(Arrays.toString(Size.values()));
    }

    public enum Size {
        SMALL, MEDIUM, LARGE, EXTRA_LARGE
    }
}
