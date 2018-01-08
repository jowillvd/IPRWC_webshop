package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;
import nl.hsleiden.View;
import nl.hsleiden.model.Gebruiker;
import nl.hsleiden.service.GebruikerService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/gebruikers")
@Produces(MediaType.APPLICATION_JSON)
public class GebruikerResource {

    private final GebruikerService service;

    @Inject
    public GebruikerResource(GebruikerService service)
    {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Gebruiker retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    public int create(@Valid Gebruiker gebruiker)
    {
        return service.add(gebruiker);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    public void update(@PathParam("id") int id, @Auth Gebruiker authenticator, Gebruiker gebruiker) {
        service.update(authenticator, id, gebruiker);
    }
}
