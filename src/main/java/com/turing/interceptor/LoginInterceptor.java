package com.turing.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("emp")==null){
            //没登录，进行拦截,跳转到登录页
            response.sendRedirect(request.getContextPath()+"/emp/");
            log.warn("拦截，登陆失败！");
            return false;
        }else {
            log.warn("放行，登陆成功！");
            return true;
        }
    }
}
