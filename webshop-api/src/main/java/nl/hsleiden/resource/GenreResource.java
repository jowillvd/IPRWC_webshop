package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.Gebruiker;
import nl.hsleiden.model.Genre;
import nl.hsleiden.service.GenreService;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/genres")
@Produces(MediaType.APPLICATION_JSON)
public class GenreResource {

    private final GenreService service;

    @Inject
    public GenreResource(GenreService service)
    {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Protected.class)
    @UnitOfWork
    public Genre retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }

    @GET
    @JsonView(View.Public.class)
    @UnitOfWork
    public List<Genre> get() {
        return service.get();
    }

    @GET
    @Path("/search/{name}")
    @JsonView(View.Public.class)
    @UnitOfWork
    public List<Genre> search(@PathParam("name") String name) {
        return service.search(name);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("ADMIN")
    @UnitOfWork
    public Genre create(@Valid Genre genre) {
        return service.set(genre);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("ADMIN")
    @UnitOfWork
    public void update(@PathParam("id") int id, @Auth Gebruiker authenticator, Genre genre) {
        service.update(id, genre);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("ADMIN")
    @UnitOfWork
    public void delete(@PathParam("id") int id, @Auth Gebruiker authenticator) {
        service.delete(id);
    }

}
