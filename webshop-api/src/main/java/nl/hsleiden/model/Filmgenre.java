package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
public class Filmgenre {

    @JsonView(View.Public.class)
    private Film film;

    @JsonView(View.Public.class)
    private Genre genre;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
