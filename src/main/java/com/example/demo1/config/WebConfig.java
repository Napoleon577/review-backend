package com.example.demo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**") // 对所有路径启用CORS
                .allowedOrigins("http://127.0.0.1:5500","http://127.0.0.1:5501","http://localhost:5173","http://localhost:7777") // 允许来自此源的请求
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的HTTP方法
                .allowedHeaders("*") // 允许所有头部
                .allowCredentials(true); // 允许携带凭证（如cookies）
    }
}

