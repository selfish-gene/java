package com.example.java.book.b01_图解Java多线程设计模式.sample4.extension;

import java.util.concurrent.TimeoutException;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/05 21:08<br>
 */
public class Host {
    // 超时时间
    private final long timeout;
    private boolean ready = false;

    public Host(long timeout) {
        this.timeout = timeout;
    }

    /**
     * 修改状态
     * @param on on
     */
    public synchronized void setExecutable(boolean on){
        ready = on;
        notifyAll();
    }

    public synchronized void execute() throws InterruptedException, TimeoutException {
        long start = System.currentTimeMillis();
        while(!ready){
            // 当前时间
            long now = System.currentTimeMillis();
            // 剩余时间
            long rest = timeout - (now - start);
            if(rest <= 0){
                throw new InterruptedException("now - start = " + (now -start) + ", timeout = " + timeout);
            }
            wait(timeout);
        }
        doExecute();
    }

    private void doExecute() {
        System.out.println(Thread.currentThread().getName() + " calls doExecute");
    }

}
