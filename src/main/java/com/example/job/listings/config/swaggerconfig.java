package com.example.job.listings.config;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class swaggerconfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Job Listings API")
                        .version("1.0")
                        .description("API documentation for Job Listings application")
                        .contact(new Contact()
                                .name("Your Name")
                                .url("http://yourwebsite.com")
                                .email("your.email@example.com")));
    }
}
