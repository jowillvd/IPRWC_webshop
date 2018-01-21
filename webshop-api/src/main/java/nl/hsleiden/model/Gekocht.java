package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
@Entity
@Table(name = "filmsgekocht")
@NamedQueries({
        @NamedQuery(name = "Gekocht.getAll",
                query = "SELECT g FROM Gekocht g " +
                        "WHERE gebruiker.id = :uId")
})
public class Gekocht {

    /**
     * Entity's unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "gebruiker")
    @JsonView(View.Public.class)
    private Gebruiker gebruiker;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "film")
    @JsonView(View.Public.class)
    private Film film;

    /**
     * A no-argument constructor.
     */
    public Gekocht(){
    }

    @JsonCreator
    public Gekocht(@JsonProperty("film") Film film){
        this.film = film;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
