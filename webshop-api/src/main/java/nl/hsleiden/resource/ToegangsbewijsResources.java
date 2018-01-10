package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.Gebruiker;
import nl.hsleiden.model.Toegangsbewijs;
import nl.hsleiden.service.ToegangsbewijsService;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/toegangsbewijzen")
@Produces(MediaType.APPLICATION_JSON)
public class ToegangsbewijsResources {

    private final ToegangsbewijsService service;

    @Inject
    public ToegangsbewijsResources(ToegangsbewijsService service)
    {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Protected.class)
    @UnitOfWork
    public Toegangsbewijs retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("ADMIN")
    @UnitOfWork
    public Toegangsbewijs create(@Valid Toegangsbewijs toegangsbewijs) {
        return service.set(toegangsbewijs);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("ADMIN")
    @UnitOfWork
    public void update(@PathParam("id") int id, @Auth Gebruiker authenticator, Toegangsbewijs toegangsbewijs) {
        service.update(id, toegangsbewijs);
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
