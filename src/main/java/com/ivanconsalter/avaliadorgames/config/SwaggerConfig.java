package com.ivanconsalter.avaliadorgames.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Model;
import io.swagger.models.properties.Property;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ivanconsalter.avaliadorgames"))
                .paths(PathSelectors.any())
                .build()
                .directModelSubstitute(Object.class, Json.class)
                .directModelSubstitute(Model.class, Json.class)
                .directModelSubstitute(Property.class, Json.class);
    }
	
}
