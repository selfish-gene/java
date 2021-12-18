package com.example.java.thread.book.b01_图解Java多线程设计模式.sample4.practice.p4.v1;

import com.example.java.thread.book.b01_图解Java多线程设计模式.sample3.v1.Request;
import com.example.java.thread.book.b01_图解Java多线程设计模式.sample4.practice.p4.LivenessException;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/03 19:22<br>
 */
public class RequestQueueV3 {
    // 超时时间
    private static final long TIMEOUT = 10000L;
    private final Queue<Request> queue = new LinkedList<>();
    public synchronized Request getRequest(){
        // 开始时间
        long start = System.currentTimeMillis();
        while (queue.peek() == null){
            // 当前时间
            long now = System.currentTimeMillis();
            // 剩余时间
            long rest = TIMEOUT - (now - start);
            if(rest <= 0){
                throw new LivenessException("thrown by " + Thread.currentThread().getName());
            }
            try {
                wait(rest);
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
