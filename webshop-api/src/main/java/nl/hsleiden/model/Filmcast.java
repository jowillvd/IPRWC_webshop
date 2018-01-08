package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
public class Filmcast {

    @JsonView(View.Public.class)
    private Film film;

    @JsonView(View.Public.class)
    private Persoon cast;

    @JsonView(View.Public.class)
    private String rol;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Persoon getCast() {
        return cast;
    }

    public void setCast(Persoon cast) {
        this.cast = cast;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
