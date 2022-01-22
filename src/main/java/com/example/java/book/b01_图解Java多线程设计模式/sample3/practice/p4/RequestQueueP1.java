package com.example.java.book.b01_图解Java多线程设计模式.sample3.practice.p4;

import com.example.java.book.b01_图解Java多线程设计模式.sample3.v1.Request;

import java.util.LinkedList;
import java.util.Queue;

/**
 * tip while -> if
 *  本示例中没有问题，但一般情况情况下还会发生问题 todo 举例
 *  假设多个线程都在 wait()，则第一个线程之后的线程都不会再判断守护条件是否成立
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/03 23:41<br>
 */
public class RequestQueueP1 {
    private final Queue<Request> queue = new LinkedList<>();
    public synchronized Request getRequest(){
        // tip while -> if
        if (queue.peek() == null){
            try {
                wait();
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
