package com.programacion.distribuida.rest;

import com.programacion.distribuida.db.Authors;
import com.programacion.distribuida.servicios.AuthorRepository;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@ApplicationScoped
@Path("/authors")
@Tag(name = "Authors Rest", description = "API Author")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorRest {
    @Inject AuthorRepository repository;
    //@ConfigProperty(name = "quarkus.http.port", defaultValue = "8080")

    @GET
    @Path("/{id}")
    @Operation(
            operationId = "Obtener un Author",
            summary = "Author",
            description = "Obtiene un author"

    )
    @APIResponse(
            responseCode = "200",
            description = "Completada",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "400",
            description = "Metodo invalido",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Authors findById(@PathParam("id") Long id) {
        return repository.findById(id);
    }

    @GET
    @Operation(
            operationId = "Obtener todos los autores",
            summary = "Lista de authores",
                description = "Obtiene los authors"

    )
    @APIResponse(
            responseCode = "200",
            description = "Completada",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "400",
            description = "Método invalido",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public List<Authors> findAll() {
        return repository
                .findAll()
                .list();
    }

    @POST
    @Operation(
            operationId = "Insertar Author",
            summary = "Se inserta un author",
            description = "Se ingresa un nuevo author"
    )
    @APIResponse(
            responseCode = "204",
            description = "Author Insertado",
            content = @Content(mediaType=MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "400",
            description = "Método invalido",
            content = @Content(mediaType=MediaType.APPLICATION_JSON)
    )
    public void insert(Authors obj) {
        repository.persist(obj);
    }

    @PUT
    @Path("/{id}")
    @Operation(
            operationId = "Actualizar author",
            summary = "Actualiza el author",
            description = "Se actualiza un author"

    )
    @APIResponse(
            responseCode = "204",
            description = "Author Actualizado",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "400",
            description = "Metodo innvalido",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @Transactional
    public void update(Authors obj, @PathParam("id") Long id) {

        var author = repository.findById(id);

        author.setFirtName(obj.getFirtName());
        author.setLastName(obj.getLastName());
    }

    @DELETE
    @Path("/{id}")
    @Operation(
            operationId = "Borrar Author",
            summary = "Borrar un author",
            description = "Se a borrado un author"

    )
    @APIResponse(
            responseCode = "204",
            description = "Author Borrado",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "400",
            description = "Metodo invalido",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @Transactional
    public void delete( @PathParam("id") Long id ) {
        repository.deleteById(id);
    }
}