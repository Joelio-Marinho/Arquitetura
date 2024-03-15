package com.arquitetura.common;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API - Arquitetura")
                        .description("API criada um gerenciamento de projetos para um escritorio de arquitetura")
                        .version("1.0")
                        .termsOfService("Termo de uso: Open Source")
                ).externalDocs(
                        new ExternalDocumentation()
                                .description("Joelio Marinho")
                                .url("www.linkedin.com/in/joélio-marinho"));
    }

}
