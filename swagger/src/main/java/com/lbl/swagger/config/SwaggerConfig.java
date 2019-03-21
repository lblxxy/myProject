package com.lbl.swagger.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket buildDocket() {
        return  new Docket(DocumentationType.SWAGGER_2)
                //调用下面apiInfo()方法
                .apiInfo(apiInfo())
                .select()
                //Controller所在路径
                .apis(RequestHandlerSelectors.basePackage("com.lbl.swagger.controller"))
                .paths(PathSelectors.any())
                .build();

    }

    public ApiInfo apiInfo() {
        return  new ApiInfoBuilder()
                .title("美漫卡劵 API")
                .description("这是一个swagger2小型demo")
                .termsOfServiceUrl("www.baidu.com")
                .contact("bacyang")
                .version("0.0.1")
                .build();

    }
}