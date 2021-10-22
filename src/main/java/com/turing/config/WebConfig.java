package com.turing.config;

import com.turing.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                //要拦截的路径
                .addPathPatterns("/emp/**")
                //这些路径不拦截
                .excludePathPatterns("/emp/","/emp/checkLogin","/emp/checkLogin2","/emp/page","/emp/insert","/emp/delete","/emp/update","/easyui","/css/**","/images/**","/js/**");
    }

    //批量设置控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/emp/").setViewName("login");
        registry.addViewController("/easyui").setViewName("easyui");
        registry.addViewController("/login2").setViewName("login2");
        registry.addViewController("/Registration").setViewName("Registration");
        registry.addViewController("/nav").setViewName("nav");
        registry.addViewController("/index2").setViewName("index2");
        registry.addViewController("/index3").setViewName("index3");
    }
}
