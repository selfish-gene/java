package com.example.java.book.b01_图解Java多线程设计模式.sample7.practice.p5;

import com.example.java.book.b01_图解Java多线程设计模式.sample7.practice.p5.v4.MyFrameServiceV4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2021/08/21 20:11<br>
 */
public class MyFrame extends JFrame implements ActionListener {
    public MyFrame(){
        super("MyFrame");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(new JLabel("Thread-Per-Message Sample"));
        JButton button = new JButton("Execute");
        getContentPane().add(button);
        button.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        MyFrameService.service();
//        MyFrameServiceV1.service();
//        MyFrameServiceV2.service();
//        MyFrameServiceV3.service();
        MyFrameServiceV4.service();
    }
}
