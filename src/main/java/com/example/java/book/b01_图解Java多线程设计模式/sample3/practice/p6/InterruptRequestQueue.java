package com.example.java.book.b01_图解Java多线程设计模式.sample3.practice.p6;

import com.example.java.book.b01_图解Java多线程设计模式.sample3.v1.Request;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/03 19:22<br>
 */
public class InterruptRequestQueue {
    private final Queue<Request> queue = new LinkedList<>();
    public synchronized Request getRequest() throws InterruptedException {
        while (queue.peek() == null){
            wait();
        }
        return queue.remove();
    }
    public synchronized void putRequest(Request request){
        // tip 这两句调换顺序没有关系，因为在执行完该方法后，才会释放this的锁
        queue.offer(request);
        notifyAll();
    }
}
