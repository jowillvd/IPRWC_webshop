package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.Film;
import nl.hsleiden.model.Gebruiker;
import nl.hsleiden.service.FilmService;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/films")
@Produces(MediaType.APPLICATION_JSON)
public class FilmResource {

    private final FilmService service;

    @Inject
    public FilmResource(FilmService service)
    {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Protected.class)
    @UnitOfWork
    public Film retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }

    @GET
    @JsonView(View.Public.class)
    @UnitOfWork
    public List<Film> get() {
        return service.get();
    }

    @GET
    @Path("/search/{titel}")
    @JsonView(View.Public.class)
    @UnitOfWork
    public List<Film> search(@PathParam("titel") String name) {
        return service.search(name);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("ADMIN")
    @UnitOfWork
    public Film create(@Valid Film film) {
        return service.set(film);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("ADMIN")
    @UnitOfWork
    public void update(@PathParam("id") int id, @Auth Gebruiker authenticator, Film film) {
        service.update(authenticator, id, film);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("ADMIN")
    @UnitOfWork
    public void delete(@PathParam("id") int id, @Auth Gebruiker authenticator) {
        service.delete(authenticator, id);
    }

}
