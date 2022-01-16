package com.example.java.video.design.patterns.mashibing.dp6_decoratpr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/16 9:27<br>
 */
public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File(System.getProperty("user.dir") + "\\docs\\decorator.txt");
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("Test for decorator ");
        bw.flush();
        bw.close();
    }
}
