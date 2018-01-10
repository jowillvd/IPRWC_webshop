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
@Table(name = "filmtypes")
@NamedQueries({
        @NamedQuery(name = "Filmtype.getAll",
                    query = "SELECT ft FROM Filmtype ft"),

        @NamedQuery(name = "Filmtype.findByType",
                    query = "SELECT ft FROM Filmtype ft " +
                            "WHERE titel like :titel")
})
public class Filmtype {

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
    private String type;

    @JsonView(View.Public.class)
    private String beschrijving;

    /**
     * A no-argument constructor.
     */
    public Filmtype(){
    }

    @JsonCreator
    public Filmtype(@JsonProperty("type") String type,
                @JsonProperty("beschrijving") String beschrijving){
        this.type = type;
        this.beschrijving = beschrijving;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

}
