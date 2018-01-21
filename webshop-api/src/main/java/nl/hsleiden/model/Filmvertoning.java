package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;

import javax.persistence.*;
import java.util.Date;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
@Entity
@Table(name = "filmvertoningen")
@NamedQueries({
        @NamedQuery(name = "Filmvertoning.getAll",
                    query = "SELECT fv FROM Filmvertoning fv"),

        @NamedQuery(name = "Filmvertoning.findByFilmId",
                    query = "SELECT fv FROM Filmvertoning fv " +
                            "WHERE film = :filmId")
})
public class Filmvertoning {

    /**
     * Entity's unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private long id;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "film")
//    @JsonView(View.Public.class)
//    private Film film;

    @JsonView(View.Public.class)
    private long film;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zaal")
    @JsonView(View.Protected.class)
    private Zaal zaal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tarief")
    @JsonView(View.Public.class)
    private Tarief tarief;

    @Temporal(TemporalType.DATE)
    @JsonView(View.Public.class)
    private Date tijd;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "filmtype")
    @JsonView(View.Public.class)
    private Filmtype filmtype;

    /**
     * A no-argument constructor.
     */
    public Filmvertoning(){
    }

    @JsonCreator
    public Filmvertoning(@JsonProperty("film") long film,
//            @JsonProperty("film") Film film,
                @JsonProperty("zaal") Zaal zaal,
                @JsonProperty("tarief") Tarief tarief,
                @JsonProperty("tijd") Date tijd,
                @JsonProperty("filmtype") Filmtype filmtype){
        this.film = film;
        this.zaal = zaal;
        this.tarief = tarief;
        this.tijd = tijd;
        this.filmtype = filmtype;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    @OneToOne(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    public Film getFilm() {
//        return film;
//    }
//
//    public void setFilm(Film film) {
//        this.film = film;
//    }


    public long getFilm() {
        return film;
    }

    public void setFilm(long film) {
        this.film = film;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Zaal getZaal() {
        return zaal;
    }

    public void setZaal(Zaal zaal) {
        this.zaal = zaal;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
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

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Filmtype getFilmtype() {
        return filmtype;
    }

    public void setFilmtype(Filmtype filmtype) {
        this.filmtype = filmtype;
    }
}
