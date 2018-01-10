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
@Table(name = "organisaties")
@NamedQueries({
        @NamedQuery(name = "Organisatie.getAll",
                    query = "SELECT f FROM Organisatie f"),

        @NamedQuery(name = "Organisatie.findByName",
                    query = "SELECT o FROM Organisatie o " +
                            "WHERE naam LIKE :name")
})
public class Organisatie {

    /**
     * Entity's unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private int id;

    @NotEmpty
    @Length(min = 1, max = 255)
    @JsonView(View.Public.class)
    private String naam;

    /**
     * A no-argument constructor.
     */
    public Organisatie(){
    }

    @JsonCreator
    public Organisatie(@JsonProperty("naam") String naam){
        this.naam = naam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

}
