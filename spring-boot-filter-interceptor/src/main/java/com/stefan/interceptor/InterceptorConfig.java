package com.stefan.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: ${todo}
 * @Author: Stefan
 * @Date: 2020/4/7 7:59 PM
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    public TimerInterceptor timerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timerInterceptor)
        .addPathPatterns("/**");
    }

}
