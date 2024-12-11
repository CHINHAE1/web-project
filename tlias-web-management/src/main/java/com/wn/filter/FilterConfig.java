package com.wn.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/11 17:45
 * @version: 1.0
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<TokenFilter> tokenFilterRegistration() {
        FilterRegistrationBean<TokenFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TokenFilter()); // 注册 TokenFilter
        registrationBean.addUrlPatterns("/*");         // 设置 URL 匹配规则
        registrationBean.setEnabled(false);            // 设置为 false，禁用过滤器
        return registrationBean;
    }
}
