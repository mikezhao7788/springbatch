package com.manulife.guli.config;

import com.manulife.guli.filter.MyFilter;
import com.manulife.guli.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 * 对请求进行拦截
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private MyFilter myFilter;
    @Autowired
    private MyInterceptor myInterceptor;
    @Bean
    public FilterRegistrationBean initFilter()
    {
       FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        registrationBean.setFilter(myFilter);
        registrationBean.setName("myFilter");
        registrationBean.addUrlPatterns("/*");
        return  registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }
}
