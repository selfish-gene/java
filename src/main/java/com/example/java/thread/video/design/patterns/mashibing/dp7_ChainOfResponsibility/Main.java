package com.example.java.thread.video.design.patterns.mashibing.dp7_ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Description</b>:<br>
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/16 9:54<br>
 */
public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)，<script>，欢迎访问 mashibing.com ，大家都是996 ");

        FilterChain filterChain1 = new FilterChain();
        // true and false
        filterChain1.add(new HTMLFilter()).add(new SensitiveFilter());

        FilterChain filterChain2 = new FilterChain();
        // true and true
        filterChain2.add(new FaceFilter()).add(new URLFilter());

        filterChain1.add(filterChain2);

        filterChain1.doFilter(msg);
        System.out.println(msg);
    }
}

class Msg {
    String name;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}

interface Filter {
    /**
     * 判断链条是否继续往下进行
     *
     * @param m m
     * @return true 继续进行
     * false 不继续进行
     */
    boolean doFilter(Msg m);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String msg = m.getMsg();
        msg = msg.replace('<', '[');
        msg = msg.replace('>', ']');
        m.setMsg(msg);
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String msg = m.getMsg();
        msg = msg.replaceAll("996", "955");
        m.setMsg(msg);
        // tip 这里为false，会导致检验链【提前退出】
        return false;
    }
}

class FaceFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String msg = m.getMsg();
        msg = msg.replace(":)", "'V'");
        m.setMsg(msg);
        return true;
    }
}

class URLFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String msg = m.getMsg();
        msg = msg.replace("mashibing.com", "http://www.mashibing.com");
        m.setMsg(msg);
        return true;
    }
}

class FilterChain implements Filter {

    private final List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Msg m) {
        for (Filter f : filters) {
            if (!f.doFilter(m)) {
                return false;
            }
        }
        return true;
    }
}
