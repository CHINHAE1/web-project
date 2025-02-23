package com.wn.carrentalplatform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/22 13:09
 * @version: 1.0
 */
//@Configuration
public class WebConfig {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/system/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
