package com.joker.jokerswagger2.utils;


import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/***
 *      swagger2    配置类
 */
@Configuration
//@EnableSwagger2
@EnableOpenApi
public class Swagger2 {

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * @return
     */
//    @Bean
//    public Docket createRestApi(){
//     return   new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.joker.jokerswagger2.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }

    @Bean

    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }



    /**
     * 创建API的基本信息
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Joker 使用Swagger2来构建RESTful APIs")
                .description("更多精彩相关文章请关注：纯甄酸牛奶i")
                .termsOfServiceUrl("http://www.joker.com/")
                .version("2.0.0")
                .build();
    }

}
