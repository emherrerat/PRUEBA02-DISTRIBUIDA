package com.distribuida;


import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;


@OpenAPIDefinition(info = @Info(title = "Books API", version = "1.0"))
@ApplicationPath("/")
public class RestApp extends Application {
}
