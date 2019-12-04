package com.bookmarketsys.databasejob.config;

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
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/**").excludePathPatterns("/login","/register");
    }
}
