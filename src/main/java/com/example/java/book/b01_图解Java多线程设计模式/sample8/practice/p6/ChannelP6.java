package com.example.java.book.b01_图解Java多线程设计模式.sample8.practice.p6;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/22 9:16<br>
 */
public class ChannelP6 {
    private static final int MAX_REQUEST = 100;
    private final RequestP6[] requestQueue;
    private int head;
    private int tail;
    private int count;

    private final WorkerThreadP6[] threadPool;

    public ChannelP6(int threads){
        this.requestQueue = new RequestP6[MAX_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        threadPool = new WorkerThreadP6[threads];
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i] = new WorkerThreadP6("Worker-" + i, this);
        }
    }

    public void startWorkers(){
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i].start();
        }
    }

    public synchronized void putRequest(RequestP6 request) throws InterruptedException {
        while (count >= requestQueue.length){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized RequestP6 takeRequest() throws InterruptedException{
        while (count <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        RequestP6 request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        return request;
    }

    public void stopAllWorkers(){
        for (WorkerThreadP6 workerThreadP6 : threadPool) {
            workerThreadP6.stopThread();
        }
    }
}
