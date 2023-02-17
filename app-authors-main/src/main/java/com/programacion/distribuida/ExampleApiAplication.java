package com.programacion.distribuida;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {
                @Tag(name="AUTHORS", description="authors"),
        },
        info = @Info(
                title="API AUTHORS",
                version = "1.0.1",
                contact = @Contact(
                        name = "Example API Support",
                        email = "techsupport@example.com"),
                license = @License(
                        name = "API",
                        url = "http://localhost:3000"))

)
@ApplicationPath("/")
public class ExampleApiAplication extends Application {
}
