package com.example.java.book.b01_图解Java多线程设计模式.sample3.v2;

import com.example.java.book.b01_图解Java多线程设计模式.sample3.v1.Request;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/03 23:41<br>
 */
public class RequestQueue {
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<>();
    public Request getRequest(){
        Request req = null;
        try {
            req = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return req;
    }
    public void putRequest(Request request){
        try {
            queue.put(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
