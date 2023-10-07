package com.demo.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;

@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                description = "Zoo Management Swagger API Portal",
                title = "Zoo Management System"
        )
)
public class OpenAPIConfiguration {

}
