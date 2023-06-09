package com.bright.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot Rest API Documentation",
                description = "Spring boot restful webservices",
                version = "v1.0.0",
                contact = @Contact(
                        name = "Okechukwu Bright Onwumere",
                        email = "onwumere.bright@gmail.com",
                        url = "coming soon"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "coming soon"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot User Management Documentation",
                url="coming soon"
        )
)
public class SpringbootRestfulWebservicesApplication {


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
    }

}
