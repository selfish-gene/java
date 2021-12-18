package com.example.java.thread.book.b01_图解Java多线程设计模式.sample2.practice.p6;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/02 19:31<br>
 */
public class FindBugMain {
    public static void main(String[] args) {
        MutablePerson mutablePerson = new MutablePerson("start", "start");
        new CrackerThread(mutablePerson).start();
        new CrackerThread(mutablePerson).start();
        new CrackerThread(mutablePerson).start();
        for (int i = 0; true; i++) {
            mutablePerson.setPerson("" + i, "" + i);
        }
    }
}

class CrackerThread extends Thread {
    private final MutablePerson mutable;

    public CrackerThread(MutablePerson mutable) {
        this.mutable = mutable;
    }

    @Override
    public void run() {
        while(true){
            ImmutablePerson immutable = new ImmutablePerson(mutable);
            if(!immutable.getName().equals(immutable.getAddress())){
                System.out.println(currentThread().getName() + "****** BROKEN ******" + immutable);
            }
        }
    }
}
