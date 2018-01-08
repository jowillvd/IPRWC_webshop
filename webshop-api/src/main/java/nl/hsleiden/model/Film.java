package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.jdbi.v3.core.mapper.Nested;
import org.joda.time.format.ISODateTimeFormat;

import java.util.Date;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
public class Film {

    @JsonView(View.Public.class)
    private long id;

    @NotEmpty
    @Length(min = 1, max = 255)
    @JsonView(View.Public.class)
    private String titel;

    @JsonView(View.Protected.class)
    private Persoon regisseur;

    @JsonView(View.Protected.class)
    private Date release;

    @JsonView(View.Protected.class)
    private String beschrijving;

    @JsonView(View.Protected.class)
    private String filmtrailer;

    public Film(long id,
            String titel,
            @Nested("regisseur") Persoon regisseur,
            String release,
            String beschrijving,
            String filmtrailer) {
        this.id = id;
        this.titel = titel;
        this.regisseur = regisseur;
        this.release = ISODateTimeFormat.date().parseDateTime(release).toDate();
        this.beschrijving = beschrijving;
        this.filmtrailer = filmtrailer;
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

    @Nested("regisseur")
    public Persoon getRegisseur() {
        return regisseur;
    }

    @Nested("regisseur")
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
