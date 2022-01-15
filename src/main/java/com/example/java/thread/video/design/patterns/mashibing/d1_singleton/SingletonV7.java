package com.example.java.thread.video.design.patterns.mashibing.d1_singleton;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class SingletonV7 {

    private SingletonV7(){}

    private static class SingletonV7Holder{
        public static final SingletonV7 INSTANCE = new SingletonV7();
    }

    public static SingletonV7 getInstance(){
        return SingletonV7Holder.INSTANCE;
    }

    public void test(){
        System.out.println("test");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(SingletonV7.getInstance().hashCode())).start();
        }
    }
}
