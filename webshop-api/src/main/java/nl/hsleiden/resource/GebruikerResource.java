package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.Gebruiker;
import nl.hsleiden.service.GebruikerService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/gebruikers")
@Produces(MediaType.APPLICATION_JSON)
public class GebruikerResource {

    private final GebruikerService service;

    @Inject
    public GebruikerResource(GebruikerService service) {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    @UnitOfWork
    public Gebruiker get(@PathParam("id") int id) {
        return service.get(id);
    }

    @GET
    @JsonView(View.Public.class)
    @UnitOfWork
    public List<Gebruiker> get() {
        return service.get();
    }

    @GET
    @Path("/search/{name}")
    @JsonView(View.Public.class)
    @UnitOfWork
    public List<Gebruiker> search(@PathParam("name") String name) {
        return service.search(name);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @UnitOfWork
    public Gebruiker create(@Valid Gebruiker gebruiker) {
        return service.set(gebruiker);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @UnitOfWork
    public void update(@PathParam("id") int id, @Auth Gebruiker authenticator, Gebruiker gebruiker) {
        service.update(authenticator, id, gebruiker);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @UnitOfWork
    public void delete(@PathParam("id") int id, @Auth Gebruiker authenticator) {
        service.delete(authenticator, id);
    }

    @GET
    @Path("/me")
    @JsonView(View.Private.class)
    public Gebruiker authenticate(@Auth Gebruiker authenticator) {
        return authenticator;
    }

}
