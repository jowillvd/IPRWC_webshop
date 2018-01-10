package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;

import javax.persistence.*;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
@Entity
@Table(name = "filmgenres")
@NamedQueries({
        @NamedQuery(name = "Filmgenre.getAll",
                    query = "SELECT fg FROM Filmgenre fg")
})
public class Filmgenre {

    @Id
    @JsonView(View.Public.class)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film")
    @JsonView(View.Public.class)
    private Film film;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre")
    @JsonView(View.Public.class)
    private Genre genre;

    /**
     * A no-argument constructor.
     */
    public Filmgenre(){

    }

    @JsonCreator
    public Filmgenre(@JsonProperty("film") Film film,
                     @JsonProperty("genre") Genre genre){
        this.film = film;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

}
