package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.Filmticket;
import nl.hsleiden.model.Gebruiker;
import nl.hsleiden.service.FilmticketService;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/filmtickets")
@Produces(MediaType.APPLICATION_JSON)
public class FilmticketResource {

    private final FilmticketService service;

    @Inject
    public FilmticketResource(FilmticketService service)
    {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Protected.class)
    @UnitOfWork
    public Filmticket retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }

    @GET
    @JsonView(View.Public.class)
    @UnitOfWork
    public List<Filmticket> get() {
        return service.get();
    }

    @GET
    @Path("/search/{id}")
    @JsonView(View.Public.class)
    @UnitOfWork
    public List<Filmticket> search(@PathParam("id") int id) {
        return service.getByFilmvertoning(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("ADMIN")
    @UnitOfWork
    public Filmticket create(@Valid Filmticket filmticket) {
        return service.set(filmticket);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("ADMIN")
    @UnitOfWork
    public void update(@PathParam("id") int id, @Auth Gebruiker authenticator, Filmticket filmticket) {
        service.update(id, filmticket);
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
