package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
@Entity
@Table(name = "personen")
@NamedQueries({
        @NamedQuery(name = "Persoon.getAll",
                query = "SELECT p FROM Persoon p"),
        @NamedQuery(name = "Persoon.findByName",
                query = "SELECT p FROM Persoon p "
                        + "WHERE voornaam LIKE :naam"
                        + " OR achternaam LIKE :naam")
})
public class Persoon {

    /**
     * Entity's unique identifier.
     */
    @Id
    @JsonView(View.Public.class)
    private long id;

    @NotEmpty
    @Length(min = 1, max = 255)
    @JsonView(View.Public.class)
    private String voornaam;

    @NotEmpty
    @Length(min = 1, max = 255)
    @JsonView(View.Public.class)
    private String achternaam;

    private Persoon() {
    }

    @JsonCreator
    public Persoon(@JsonProperty("voornaam") String voornaam,
                   @JsonProperty("achternaam") String achternaam) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }
}
