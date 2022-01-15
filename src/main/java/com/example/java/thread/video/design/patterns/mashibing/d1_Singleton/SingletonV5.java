package com.example.java.thread.video.design.patterns.mashibing.d1_Singleton;

/**
 * lazy loading
 * 俗称懒汉式
 * 达到了按需初始化的目的，但带来了线程安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 */
@Deprecated
public class SingletonV5 {

    private static SingletonV5 INSTANCE;

    private SingletonV5(){}

    public static SingletonV5 getInstance(){
        if(INSTANCE == null){
            // tip 试图通过减小同步代码块的方式提高效率，然后不可行（又会出现线程安全的问题）
            synchronized (SingletonV5.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new SingletonV5();
            }
        }
        return INSTANCE;
    }

    public void test(){
        System.out.println("test");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(SingletonV5.getInstance().hashCode())).start();
        }
    }
}
