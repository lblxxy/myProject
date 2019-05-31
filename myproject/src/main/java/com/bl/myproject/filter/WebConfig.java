package com.bl.myproject.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author bl
 * @date 2019/5/30
 */
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //用于拦截静态资源
        registry.addResourceHandler("/api/doc/**").addResourceLocations("classpath:/swagger/dist/");
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
    }

    /**
     * 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
     * @param registry 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有/api下的用户请求，过滤未登录用户
        registry.addInterceptor(new FrontLoginIntercepter()).addPathPatterns("/admin/api/*","/admin/toIndex","/api/*");

        //拦截所有/pay下的用户请求，每个用户每三秒只能调用一次支付接口
/*        registry.addInterceptor(new PayIntercepter()).addPathPatterns("/api/user/pay/*");*/
    }


}
