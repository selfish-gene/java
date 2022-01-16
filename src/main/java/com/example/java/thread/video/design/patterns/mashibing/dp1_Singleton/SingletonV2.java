package com.example.java.thread.video.design.patterns.mashibing.dp1_Singleton;

/**
 * @see SingletonV1
 */
public class SingletonV2 {

    private final static SingletonV2 INSTANCE;
    static{
        INSTANCE = new SingletonV2();
    }

    private SingletonV2(){}
    
    public static SingletonV2 getInstance(){
        return INSTANCE;
    }

    public void test(){
        System.out.println("test");
    }

    public static void main(String[] args) {
        SingletonV2 singletonV1 = SingletonV2.getInstance();
        SingletonV2 singletonV2 = SingletonV2.getInstance();
        System.out.println(singletonV1 == singletonV2);
    }
}
