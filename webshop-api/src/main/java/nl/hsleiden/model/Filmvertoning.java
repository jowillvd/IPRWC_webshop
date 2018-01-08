package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;

import java.util.Date;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
public class Filmvertoning {

    @JsonView(View.Public.class)
    private int id;

    @JsonView(View.Public.class)
    private Film film;

    @JsonView(View.Public.class)
    private Zaal zaal;

    @JsonView(View.Public.class)
    private Tarief tarief;

    @JsonView(View.Public.class)
    private Date tijd;

    @JsonView(View.Public.class)
    private String filmtype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Zaal getZaal() {
        return zaal;
    }

    public void setZaal(Zaal zaal) {
        this.zaal = zaal;
    }

    public Tarief getTarief() {
        return tarief;
    }

    public void setTarief(Tarief tarief) {
        this.tarief = tarief;
    }

    public Date getTijd() {
        return tijd;
    }

    public void setTijd(Date tijd) {
        this.tijd = tijd;
    }

    public String getFilmtype() {
        return filmtype;
    }

    public void setFilmtype(String filmtype) {
        this.filmtype = filmtype;
    }
}
