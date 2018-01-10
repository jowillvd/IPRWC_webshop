package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
@Entity
@Table(name = "filmcrew")
@NamedQueries({
        @NamedQuery(name = "Filmcrew.getAll",
                query = "SELECT fc FROM Filmcrew fc")
})
public class Filmcrew {

    @JsonView(View.Public.class)
    private Film film;

    @JsonView(View.Public.class)
    private Persoon crew;

    @JsonView(View.Public.class)
    private String functie;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Persoon getCrew() {
        return crew;
    }

    public void setCrew(Persoon crew) {
        this.crew = crew;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }
}
