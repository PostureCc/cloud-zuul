package com.chan.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
public class MyZuulFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        //执行顺序 值越小 越先执行 可以为负数
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        System.err.println("Zuul Filter...");
        //决定过滤器是否执行 return true执行本类的run方法 return false则不执行
        return true;
    }

    @Override
    public Object run() {
        System.err.println("MyZuulFilter run...");
        return null;
    }
}
