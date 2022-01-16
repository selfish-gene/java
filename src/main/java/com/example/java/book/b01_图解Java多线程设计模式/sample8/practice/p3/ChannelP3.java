package com.example.java.book.b01_图解Java多线程设计模式.sample8.practice.p3;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/22 9:16<br>
 */
public class ChannelP3 {
    private static final int MAX_REQUEST = 100;
    private final RequestP3[] requestP3Queue;
    private int head;
    private int tail;
    private int count;

    private final WorkerThreadP3[] threadPool;

    public ChannelP3(int threads){
        this.requestP3Queue = new RequestP3[MAX_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        threadPool = new WorkerThreadP3[threads];
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i] = new WorkerThreadP3("Worker-" + i, this);
        }
    }

    public void startWorkers(){
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i].start();
        }
    }

    public synchronized void putRequest(RequestP3 requestP3){
        while (count >= requestP3Queue.length){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requestP3Queue[tail] = requestP3;
        tail = (tail + 1) % requestP3Queue.length;
        count++;
        notifyAll();
    }

    /**
     * Thread-Per-Message
     * @param requestP3 requestP3
     */
    public synchronized void putRequestV2(RequestP3 requestP3){
        new Thread(requestP3::execute).start();
    }

    public synchronized RequestP3 takeRequest() {
        while (count <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        RequestP3 requestP3 = requestP3Queue[head];
        head = (head + 1) % requestP3Queue.length;
        count--;
        notifyAll();
        return requestP3;
    }

}
