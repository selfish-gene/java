package com.example.java.video.design.patterns.mashibing.dp7_ChainOfResponsibility.servlet.v3;

import java.util.ArrayList;
import java.util.List;

/**
 * 在filterChain中处理加入位置的记录
 * 同时在filter中加入第三个参数
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/16 10:21<br>
 */
public class ServletV3Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好:)，<script>，欢迎访问 mashibing.com ，大家都是996 ";
        Response response = new Response();
        response.str = "response";

        FilterChain filterChain = new FilterChain();
        filterChain.add(new HTMLFilter()).add(new SensitiveFilter());

        filterChain.doFilter(request, response, filterChain);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}

class Request {
    String str;
}

class Response {
    String str;
}

interface Filter {
    boolean doFilter(Request request, Response response, FilterChain filterChain);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]") + " HTMLFilter()";
        filterChain.doFilter(request, response, filterChain);
        response.str += "--HTMLFilter()";
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("996", "955") + " SensitiveFilter()";
        filterChain.doFilter(request, response, filterChain);
        response.str += "--SensitiveFilter()";
        return true;
    }
}

class FilterChain implements Filter {

    private final List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        if (index == filters.size()) {
            return false;
        }
        Filter filter = filters.get(index);
        index++;
        return filter.doFilter(request, response, filterChain);
    }
}

