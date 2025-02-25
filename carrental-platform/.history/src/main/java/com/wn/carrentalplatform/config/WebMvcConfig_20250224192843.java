package com.wn.carrentalplatform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 19:27
 * @version: 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置图片访问路径
        registry.addResourceHandler("/upload/**")  // 访问路径
                .addResourceLocations("file:" + uploadPath + "/");  // 实际路径
    }
}
