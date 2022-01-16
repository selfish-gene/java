package com.example.java.book.b01_图解Java多线程设计模式.sample4.practice.p5;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/05 22:05<br>
 */
public class TestThreadMain {
    public static void main(String[] args) {
        Thread thread = new TestThread();
        while (true){
            thread.start();
        }
    }
}
/*
************* 运行结果 **************：
Exception in thread "main" java.lang.IllegalThreadStateException
	at java.base/java.lang.Thread.start(Thread.java:794)
	at com.example.java.thread.book.sample4.practice.p5.TestThreadMain.main(TestThreadMain.java:13)
BEGIN..................................................END
*************   原因   **************：
Thread 的 threadStatus != 0 , A zero status value corresponds to state "NEW".
 也就是Thread类的start方法使用了Balking模式
 *
 */
