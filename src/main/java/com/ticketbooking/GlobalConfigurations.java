package com.ticketbooking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


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
                .tags(new Tag("Ticket Booking API", "APIs for Ticket Booking "));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Ticket Booking API")
                .description("APIs for Ticket Booking ")
                .version("3.0.0")
                .contact(new Contact("Shailesh Bhattarai", "https://github.com/Shailesh148/ticket-booking", " "))
                .build();
    }

}
