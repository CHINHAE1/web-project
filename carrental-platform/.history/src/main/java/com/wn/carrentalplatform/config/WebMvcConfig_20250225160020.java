package com.wn.carrentalplatform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;


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
        
        // 添加静态资源映射
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view/system/", ".jsp");
    }

    @ModelAttribute(name = "yeqifu")
    public String getContextPath(HttpServletRequest request) {
        return request.getContextPath();
    }
}
