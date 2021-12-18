package com.example.java.thread.book.b01_图解Java多线程设计模式.sample5.v1;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/07 0:44<br>
 */
public class Table {
    private final String[] buffer;
    // 表示下一次放置的位置
    private int tail;
    // 表示下一次取的位置
    private int head;
    // 表示当前桌子上放置的蛋糕个数
    private int count;

    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= buffer.length){
            wait();
        }
        buffer[tail] = cake;
        /* tip
         * tail = (tail + 1) % buffer.length;
         * 等同于:
         * tail++;
         * if(tail >= buffer.length){
         *    tail = 0;
         * }
         */
        tail = (tail + 1) % buffer.length;
        count ++;
        notifyAll();
        // practice 5-8
//        notify();
    }

    public synchronized String take() throws InterruptedException {
        while (count <= 0){
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        // practice 5-8
//        notify();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }

    /**
     * 5-5
     */
    public synchronized void clear(){
        // 该语句用来表示清除的蛋糕，也可以不写
        while(count > 0){
            String cake = buffer[head];
            System.out.println(Thread.currentThread().getName() + " clears " + cake);
            head = (head + 1) % buffer.length;
            count--;
        }
        head = 0;
        tail = 0;
        count = 0;
        notifyAll();
    }
}
