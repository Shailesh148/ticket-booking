package com.ticketbooking;

import lombok.val;
import org.modelmapper.internal.util.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.*;


@Configuration
@EnableSwagger2
public class GlobalConfigurations {
    @Bean
    public Docket streamingWarsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/booking/**"))
                .build().apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .tags(new Tag("Ticket Booking API", "APIs for Ticket Booking "))
                .securitySchemes(Arrays.asList(apiKey()));
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Ticket Booking API")
                .description("APIs for Ticket Booking ")
                .version("3.0.0")
                .contact(new Contact("Shailesh Bhattarai", "https://github.com/Shailesh148/ticket-booking", " "))
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }


    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }

}
