package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.Gebruiker;
import nl.hsleiden.model.Gekocht;
import nl.hsleiden.service.GekochtService;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/filmsgekocht")
@Produces(MediaType.APPLICATION_JSON)
public class GekochtResource {

    private final GekochtService service;

    @Inject
    public GekochtResource(GekochtService service)
    {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Protected.class)
    @UnitOfWork
    public Gekocht retrieve(@PathParam("id") long id, @Auth Gebruiker authenticator) {
        return service.get(id, authenticator);
    }

    @GET
    @JsonView(View.Public.class)
    @UnitOfWork
    public List<Gekocht> get(@Auth Gebruiker authenticator) {
        return service.get(authenticator);
    }

    @GET
    @Path("/contains/{id}")
    @JsonView(View.Public.class)
    @UnitOfWork
    public boolean exists(@PathParam("id") long id, @Auth Gebruiker authenticator) {
        return service.exists(authenticator, id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @UnitOfWork
    public Gekocht create(@Valid Gekocht gekocht, @Auth Gebruiker authenticator) {
        return service.set(gekocht, authenticator);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @UnitOfWork
    public void update(@PathParam("id") long id, @Auth Gebruiker authenticator, Gekocht filmvertoning) {
        service.update(id, filmvertoning, authenticator);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("ADMIN")
    @UnitOfWork
    public void delete(@PathParam("id") long id, @Auth Gebruiker authenticator) {
        service.delete(id, authenticator);
    }

}
