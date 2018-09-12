package com.inshare.concurrency.config;

import com.inshare.concurrency.interceptor.HttpInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Guichao
 * @since 2018/9/12
 */
@Configuration
public class HttpInterceptorConfig implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor getHttpInterceptor() {
        return new HttpInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getHttpInterceptor())
                .addPathPatterns("/**");
    }
}
