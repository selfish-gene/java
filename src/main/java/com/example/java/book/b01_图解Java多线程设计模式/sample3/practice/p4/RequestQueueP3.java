package com.example.java.book.b01_图解Java多线程设计模式.sample3.practice.p4;

import com.example.java.book.b01_图解Java多线程设计模式.sample3.v1.Request;

import java.util.LinkedList;
import java.util.Queue;

/**
 * tip 将try...catch 移到 while 外面
 * 本实例没有问题，但一般情况还是会发生问题
 * 线程wait时，其他线程调用 interrupt 方法。守护条件不成立，也会跳出while循环，进入catch语句块。然后执行remove
 * 欠缺安全性
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/03 23:41<br>
 */
public class RequestQueueP3 {
    private final Queue<Request> queue = new LinkedList<>();
    public synchronized Request getRequest(){
        try {
            while (queue.peek() == null){
                    wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return queue.remove();
    }
    public synchronized void putRequest(Request request){
        // tip 这两句调换顺序没有关系，因为在执行完该方法后，才会释放this的锁
        queue.offer(request);
        notifyAll();
    }
}
