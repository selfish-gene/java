package com.example.java.thread.video.design.patterns.mashibing.d1_Singleton;

/**
 * lazy loading
 * 俗称懒汉式
 * 达到了按需初始化的目的，但带来了线程安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 */
public class SingletonV4 {

    private static SingletonV4 INSTANCE;

    private SingletonV4(){}

    /**
     * tip 加 synchronized 解决线程安全问题
     * @return singletonV4
     */
    public synchronized static SingletonV4 getInstance(){
        if(INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new SingletonV4();
        }
        return INSTANCE;
    }

    public void test(){
        System.out.println("test");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(SingletonV4.getInstance().hashCode())).start();
        }
    }
}
