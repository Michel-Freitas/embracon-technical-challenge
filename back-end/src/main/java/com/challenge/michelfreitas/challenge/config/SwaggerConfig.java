package com.challenge.michelfreitas.challenge.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SwaggerConfig {

    @Autowired
    private Environment env;

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("challenge-api")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenApi() {
        String apiVersion = env.getProperty("api.version");

        Contact contact = new Contact()
                .name("Michel Freitas Santos")
                .email("michelfreitas85@outlook.com");

        Info info = new Info()
                .title("Consult Zip Code")
                .description("This API was developed to facilitate the search for ZIP codes and maintain a log of queries made.")
                .contact(contact)
                .version(apiVersion);

        return new OpenAPI()
                .info(info);
    }
}
