package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.Filmvertoning;
import nl.hsleiden.model.Gebruiker;
import nl.hsleiden.service.FilmvertoningService;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/filmvertoningen")
@Produces(MediaType.APPLICATION_JSON)
public class FilmvertoningResource {

    private final FilmvertoningService service;

    @Inject
    public FilmvertoningResource(FilmvertoningService service)
    {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Protected.class)
    @UnitOfWork
    public Filmvertoning retrieve(@PathParam("id") long id)
    {
        return service.get(id);
    }

    @GET
    @JsonView(View.Public.class)
    @UnitOfWork
    public List<Filmvertoning> get() {
        return service.get();
    }

    @GET
    @Path("/search/{id}")
    @JsonView(View.Public.class)
    @UnitOfWork
    public List<Filmvertoning> search(@PathParam("id") long id) {
        return service.findByFilm(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("ADMIN")
    @UnitOfWork
    public Filmvertoning create(@Valid Filmvertoning filmvertoning) {
        return service.set(filmvertoning);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("ADMIN")
    @UnitOfWork
    public void update(@PathParam("id") long id, @Auth Gebruiker authenticator, Filmvertoning filmvertoning) {
        service.update(id, filmvertoning);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("ADMIN")
    @UnitOfWork
    public void delete(@PathParam("id") long id, @Auth Gebruiker authenticator) {
        service.delete(id);
    }

}
