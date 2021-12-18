package com.example.java.thread.book.b01_图解Java多线程设计模式.sample2.practice.p3;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 18:31<br>
 */
public class ImmutablePerformanceMain {

    public static void main(String[] args) {
        trial("NotSynch", CALL_COUNT, new NotSynch());
        trial("Synch", CALL_COUNT, new Synch());
    }

    /*
Elapsed time = 466msec.     Elapsed time = 1618msec.
Elapsed time = 454msec.     Elapsed time = 1625msec.
Elapsed time = 479msec.     Elapsed time = 1606msec.
Elapsed time = 451msec.     Elapsed time = 1607msec.
     */

    private static final long CALL_COUNT = 1000 * 1000 * 1000L;
    private static void trial(String msg, long count, Object obj){
        System.out.println(msg + ": BEGIN");
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            obj.toString();
        }
        System.out.println(msg + ": END");
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start) + "msec.");
    }
}

class NotSynch{
    private final String name = "NotSynch";
    public String toString(){
        return "[" + name + "]";
    }
}
class Synch{
    private final String name = "Synch";
    public synchronized String toString(){
        return "[" + name + "]";
    }
}