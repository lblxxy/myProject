package com.bl.myproject.filter;

import com.bl.myproject.constant.Constant;
import com.bl.myproject.util.RedisUtil;
import com.bl.myproject.util.StringUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义登录拦截器
 * @author bl
 * @date 2019/5/30
 */
public class FrontLoginIntercepter extends HandlerInterceptorAdapter {


    /**
     * 登录拦截
     * @param request
     * @param response
     * @param handler
     * @return 是否限制
     * @throws IOException
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //获取缓存中的key，如果没有，则返回登录界面
        String ticketKey = (String) RedisUtil.getInstance().get(Constant.WEB_NAME, Constant.USER_LOGIN);
        if(StringUtil.isBlank(ticketKey)){
            response.sendRedirect(Constant.TO_LOGIN);
            return false;
        }
        return true;
    }
}
