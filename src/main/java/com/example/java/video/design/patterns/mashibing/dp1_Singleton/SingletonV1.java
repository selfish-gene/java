package com.example.java.video.design.patterns.mashibing.dp1_Singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 * Class.forName("")
 * （话说你不用的，你装载它干啥）
 */
public class SingletonV1 {

    private final static SingletonV1 INSTANCE = new SingletonV1();

    private SingletonV1(){}
    
    public static SingletonV1 getInstance(){
        return INSTANCE;
    }

    public void test(){
        System.out.println("test");
    }

    public static void main(String[] args) {
        SingletonV1 singletonV1 = SingletonV1.getInstance();
        SingletonV1 singletonV2 = SingletonV1.getInstance();
        System.out.println(singletonV1 == singletonV2);
    }
}
