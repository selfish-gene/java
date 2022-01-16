package com.example.java.video.design.patterns.mashibing.dp1_Singleton;

/**
 * 枚举
 * 不仅可以解决线程同步，还可以防止反序列化。
 */
public enum SingletonV8 {

    INSTANCE;

    public void test(){
        System.out.println("test");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(SingletonV8.INSTANCE.hashCode())).start();
        }
    }
}
