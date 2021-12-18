package com.example.java.thread.book.b01_图解Java多线程设计模式.sample4.v1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/05 19:36<br>
 */
public class Data {
    private final String filename;
    private String content;
    private boolean changed;

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    /**
     * 修改数据内容
     * @param newContent 新内容
     */
    public synchronized void change(String newContent){
        content = newContent;
        changed = true;
    }

    public synchronized void save() throws IOException{
        if(!changed){
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
