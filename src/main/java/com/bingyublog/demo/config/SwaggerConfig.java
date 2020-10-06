package com.bingyublog.demo.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Classname SwaggerConfig
 * @Description TODO
 * @Date 2020/10/6 22:07
 * @Created by 冰羽
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //版本
    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))//错误路径不监控
                .paths(PathSelectors.any()).build().groupName("admin");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("CodeCube社区后台管理系统接口文档") //设置文档的标题
                .description("门户接口文档") // 设置文档的描述
                .description("管理中心接口 => Created by 冰羽") // 设置文档的描述
                /**设置文档的联系方式*/
                .contact(new Contact("冰羽", "http://www.bingyublog.com", "xzhxpx@qq.com"))
                /**设置文档的License信息->1.3 License information*/
                .license("CC BY-NC-SA ")
                .licenseUrl("https://creativecommons.org/licenses/by-nc-sa/4.0/")
                .version(VERSION) // 设置文档的版本信息-> 1.0.0 Version information
                .build();
    }
}
