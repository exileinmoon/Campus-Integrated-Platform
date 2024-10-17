/*
package com.tradeservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许所有路径
                .allowedOrigins("http://localhost:9527") // 允许的前端地址
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("x-token", "Content-Type", "Authorization") // 允许的请求头
                .exposedHeaders("Authorization") // 如果需要暴露某些响应头
                .allowCredentials(true) // 如果需要支持Cookie跨域
                .maxAge(3600); // 预检请求的有效时间
    }
}
*/
