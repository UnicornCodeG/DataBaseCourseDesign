package com.bookmarketsys.databasejob.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MvcConfig
 * @Description 配置拦截器
 * @Author 龚佳民
 * @Date 2019/11/29
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    FilterConfig filterConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(filterConfig).addPathPatterns("/**");
        //registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/**").excludePathPatterns("/login","/register");
    }
}
