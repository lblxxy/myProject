package com.meiman.meimanwallet.filter;

import com.meiman.meimanwallet.constant.Constant;
import com.meiman.meimanwallet.utils.PropertiesUtils;
import com.meiman.meimanwallet.utils.RequestCounter;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author zeng_
 * @Date 2018/11/29
 */
@Component
@WebFilter(urlPatterns = "/meiman",filterName = "loginFilter")
public class RequestCountFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String ip = servletRequest.getRemoteHost();
        int count = 0;
        try {
            count = RequestCounter.increment(ip);
        } catch (ExecutionException e) {
            System.out.println("累计访问次数错误");
        }
        //如果已经超过了最大允许访问限制，就禁止访问，否则，就可以直接访问
        if(count < Integer.valueOf(PropertiesUtils.readProperty(Constant.REQUEST_FREQUENCY, Constant.DEFAULT_REQUEST_FREQUENCY))) {
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            System.out.println("ip:"+ip+"访问超限");
        }
    }

    @Override
    public void destroy() {
        System.out.println("destory");
    }
}
