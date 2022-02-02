package com.example.java.book.b02_CoreJavaVolume_Fundamentals.chapter3;

public class Code03_Math {
    public static void main(String[] args) {
        testMath();
        testMathOverflow();
    }

    public static void testMath(){
        double sqrt = Math.sqrt(4);
        System.out.println(sqrt); // 2.0
        double pow = Math.pow(2, 3);
        System.out.println(pow); // 8.0
        int i = Math.floorMod(3, 12);
        System.out.println(i); // 3
        int i1 = Math.floorMod(-3, 12);
        System.out.println(i1); // 9

        // StrictMath  得到一个完全可预测的结果 https://www.netlib.org/fdlibm/
        double pow1 = StrictMath.pow(2, 3);
        System.out.println(pow1);
    }

    public static void testMathOverflow(){
        // 计算溢出，数学运算符只是悄悄的返回错误的结果而不做任何提醒。
        int a = 1_000_000_000 * 3;
        System.out.println(a); // -1294967296
        try {
            int i = Math.multiplyExact(1_000_000_000, 3);
            System.out.println(i);
        } catch (ArithmeticException e) {
            System.out.println("计算溢出异常！");
            e.printStackTrace();
        }
    }
}
