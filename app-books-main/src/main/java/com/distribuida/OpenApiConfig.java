package com.distribuida;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Application;
@ApplicationScoped
@OpenAPIDefinition(info = @Info(title = "Books API", version = "1.0.0"))
public class OpenApiConfig extends Application {
}
