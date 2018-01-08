package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import nl.hsleiden.View;
import nl.hsleiden.model.Film;
import nl.hsleiden.service.FilmService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
    @JsonView(View.Public.class)
    public Film retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    public int create(@Valid Film film)
    {
        return service.add(film);
    }
}
