package com.example.java.thread.video.design.patterns.mashibing.singleton;

/**
 * double check
 * 俗称双重检查锁
 */
public class SingletonV6 {

    private static volatile SingletonV6 INSTANCE;

    private SingletonV6(){}

    public static SingletonV6 getInstance(){
        if(INSTANCE == null){
            // tip 双重检查
            synchronized (SingletonV6.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new SingletonV6();
                }
            }
        }
        return INSTANCE;
    }

    public void test(){
        System.out.println("test");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(SingletonV6.getInstance().hashCode())).start();
        }
    }
}
