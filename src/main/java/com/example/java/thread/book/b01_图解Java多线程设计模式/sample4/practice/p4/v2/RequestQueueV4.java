package com.example.java.thread.book.b01_图解Java多线程设计模式.sample4.practice.p4.v2;

import com.example.java.thread.book.b01_图解Java多线程设计模式.sample3.v1.Request;
import com.example.java.thread.book.b01_图解Java多线程设计模式.sample4.practice.p4.LivenessException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/03 23:41<br>
 */
public class RequestQueueV4 {
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<>();
    public Request getRequest(){
        Request req = null;
        try {
            req = queue.poll(10L, TimeUnit.SECONDS);
            if(req == null){
                throw new LivenessException("thrown by " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return req;
    }
    public void putRequest(Request request){
        try {
            boolean offered = queue.offer(request, 10L, TimeUnit.SECONDS);
            if(!offered){
                throw new LivenessException("thrown by " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
