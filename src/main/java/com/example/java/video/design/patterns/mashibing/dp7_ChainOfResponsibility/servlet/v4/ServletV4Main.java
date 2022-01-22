package com.example.java.video.design.patterns.mashibing.dp7_ChainOfResponsibility.servlet.v4;

import java.util.ArrayList;
import java.util.List;

/**
 * 完全模式Serverlet中的FilterChain
 *
 * <b>Author</b>:anlei<br>
 * <b>Date</b>:2022/01/16 10:21<br>
 */
public class ServletV4Main {
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
    void doFilter(Request request, Response response, FilterChain filterChain);
}

class HTMLFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]") + " HTMLFilter()";
        filterChain.doFilter(request, response, filterChain);
        response.str += "--HTMLFilter()";
    }
}

class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("996", "955") + " SensitiveFilter()";
        filterChain.doFilter(request, response, filterChain);
        response.str += "--SensitiveFilter()";
    }
}

class FilterChain implements Filter {

    private final List<Filter> filters = new ArrayList<>();
    /**
     * 当前执行Filter的位置
     */
    int index = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        if (index == filters.size()) {
            return;
        }
        Filter filter = filters.get(index);
        index++;
        filter.doFilter(request, response, filterChain);
    }
}

