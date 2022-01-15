package com.example.java.thread.video.design.patterns.mashibing.d1_singleton;

/**
 * lazy loading
 * 俗称懒汉式
 * 达到了按需初始化的目的，但带来了线程安全的问题
 */
@Deprecated
public class SingletonV3 {

    private static SingletonV3 INSTANCE;

    private SingletonV3(){}
    
    public static SingletonV3 getInstance(){
        // tip 此处有线程安全的问题
        if(INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new SingletonV3();
        }
        return INSTANCE;
    }

    public void test(){
        System.out.println("test");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(SingletonV3.getInstance().hashCode())).start();
        }
    }
}
