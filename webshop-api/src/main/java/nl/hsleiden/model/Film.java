package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.format.ISODateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
@Entity
@Table(name = "films")
@NamedQueries({
        @NamedQuery(name = "Film.getAll",
                    query = "SELECT f FROM Film f"),

        @NamedQuery(name = "Film.findByName",
                    query = "SELECT f FROM Film f " +
                            "WHERE titel like :titel")
})
public class Film {

    /**
     * Entity's unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private long id;

    @NotEmpty
    @Length(min = 1, max = 255)
    @JsonView(View.Public.class)
    private String titel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regisseur")
    @JsonView(View.Protected.class)
    private Persoon regisseur;

    @Temporal(TemporalType.DATE)
    @Column(name = "`release`")
    @JsonView(View.Public.class)
    private Date release;

    @JsonView(View.Protected.class)
    private String beschrijving;

    @JsonView(View.Protected.class)
    private String filmtrailer;

    /**
     * A no-argument constructor.
     */
    public Film(){
    }

    @JsonCreator
    public Film(@JsonProperty("titel") String titel,
            @JsonProperty("regisseur") Persoon regisseur,
            @JsonProperty("release") Date release,
            @JsonProperty("beschrijving") String beschrijving,
            @JsonProperty("filmtrailer") String filmtrailer){
        this.titel = titel;
        this.regisseur = regisseur;
        this.release = release;
        this.beschrijving = beschrijving;
        this.filmtrailer = filmtrailer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Persoon getRegisseur() {
        return regisseur;
    }

    public void setRegisseur(Persoon regisseur) {
        this.regisseur = regisseur;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = ISODateTimeFormat.date().parseDateTime(release).toDate();
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getFilmtrailer() {
        return filmtrailer;
    }

    public void setFilmtrailer(String filmtrailer) {
        this.filmtrailer = filmtrailer;
    }
}
