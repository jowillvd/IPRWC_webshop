package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import nl.hsleiden.model.Genre;
import nl.hsleiden.persistence.GenreDAO;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/genres")
@Produces(MediaType.APPLICATION_JSON)
public class GenreResource {

    private final GenreDAO dao;

    public GenreResource(GenreDAO dao) {
        this.dao = dao;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    public void create(@Valid Genre genre)
    {
        dao.insert(genre);
    }
}
