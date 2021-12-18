package com.example.java.thread.book.b01_图解Java多线程设计模式.sample3.practice.p4;

import com.example.java.thread.book.b01_图解Java多线程设计模式.sample3.v1.Request;

import java.util.LinkedList;
import java.util.Queue;

/**
 * tip synchronized 范围只包含 wait()
 * 守护条件判断 synchronized 外边，线程不安全，如下：
 * |------------------------------------
 * |    线程1          线程2
 * |    检查条件
 * |                   检查条件
 * |                   调用remove
 * |    调用remove
 * |------------------------------------
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/03 23:41<br>
 */
public class RequestQueueP2 {
    private final Queue<Request> queue = new LinkedList<>();
    public Request getRequest(){
        while (queue.peek() == null){
            try {
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }
    public synchronized void putRequest(Request request){
        // tip 这两句调换顺序没有关系，因为在执行完该方法后，才会释放this的锁
        queue.offer(request);
        notifyAll();
    }
}
