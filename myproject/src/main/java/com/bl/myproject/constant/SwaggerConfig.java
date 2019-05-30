package com.bl.myproject.constant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author bl
 * @date 2019/5/28
 * 加上这个@Configuration swagger才能显示出来
 * = >@PropertySource("classpath:swagger.properties") 新增对swagger.properties 的引入===暂时可以不用，应该是拿来自定义swagger页面
 */
@Configuration
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
public class SwaggerConfig {

    /**
     * 添加摘要信息(Docket)
     */
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("bl的后台模板")
                        .description("后台swagger模板, 负责人：bl_")
                        .contact(new Contact("bl_", null, null))
                        .termsOfServiceUrl("http://xxx.xxx.com")
                        .version("版本号:1.0")
                        .build())
                .select()
                // 这里扫描controller的包，就是将controller下面的所有接口全部扫描出来
                // 需要精确 到某个controller就扫描这个文件即可，也可以在 请求上面配置hidden属，隐藏需要隐藏的接口
                .apis(RequestHandlerSelectors.basePackage("com.bl.myproject.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
