package com.ed.filter;

import javax.servlet.*;
import java.io.IOException;

public class AutoFilter implements javax.servlet.Filter {
    private static final String ENCODING = "UTF-8";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // initialization 初始化\ [ɪ,nɪʃəlaɪ'zeɪʃən]
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //设置接受和响应的格式为UTF-8
        request.setCharacterEncoding(ENCODING);
        response.setCharacterEncoding(ENCODING);
        //放行
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        // destroy 销毁
    }
}
