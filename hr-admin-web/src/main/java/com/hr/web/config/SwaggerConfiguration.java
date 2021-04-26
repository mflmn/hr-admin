package com.hr.web.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
 * @author yuelimin
 * @software IntelliJ IDEA
 * @description swagger 配置类
 * @since JDK 8
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger", value = {"enable"}, havingValue = "true")
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hr.web.controller"))
                .paths(PathSelectors.any())
                .build();
        // .securitySchemes(securitySchemes())
        // .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("hr-admin后台接口文档 v1.0.0")
                .description("hr-admin后台接口文档")
                .termsOfServiceUrl("https://github.com/mikuhuyo")
                .version("1.0.0")
                .contact(new Contact("岳立民", "https://github.com/mikuhuyo", "yueliminvc@outlook.com"))
                .build();
    }

    // private List<ApiKey> securitySchemes() {
    //     List<ApiKey> result = new ArrayList<>();
    //     ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
    //     result.add(apiKey);
    //     return result;
    // }
    //
    // private List<SecurityContext> securityContexts() {
    //     List<SecurityContext> result = new ArrayList<>();
    //     result.add(getContextByPath("/*/.*"));
    //     return result;
    // }
    //
    // private SecurityContext getContextByPath(String pathRegex) {
    //     return SecurityContext.builder()
    //             .securityReferences(defaultAuth())
    //             .forPaths(PathSelectors.regex(pathRegex))
    //             .build();
    // }
    //
    // private List<SecurityReference> defaultAuth() {
    //     List<SecurityReference> result = new ArrayList<>();
    //     AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    //     AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    //     authorizationScopes[0] = authorizationScope;
    //     result.add(new SecurityReference("Authorization", authorizationScopes));
    //     return result;
    // }
}
