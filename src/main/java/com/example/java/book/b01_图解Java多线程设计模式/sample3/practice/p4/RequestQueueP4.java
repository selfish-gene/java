package com.example.java.book.b01_图解Java多线程设计模式.sample3.practice.p4;

import com.example.java.book.b01_图解Java多线程设计模式.sample3.v1.Request;

import java.util.LinkedList;
import java.util.Queue;

/**
 * tip 将 wait 替换为 sleep
 * sleep不会释放锁，导致程序一直空转，缺乏安全性，这种现象被称为活锁（livelock）
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/03 23:41<br>
 */
public class RequestQueueP4 {
    private final Queue<Request> queue = new LinkedList<>();
    public synchronized Request getRequest(){
        while (queue.peek() == null){
            try {
                Thread.sleep(1000);
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
