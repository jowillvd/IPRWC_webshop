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
@Table(name = "tarieven")
@NamedQueries({
        @NamedQuery(name = "Tarief.getAll",
                    query = "SELECT t FROM Tarief t"),

        @NamedQuery(name = "Tarief.findByName",
                    query = "SELECT t FROM Tarief t " +
                            "WHERE type = :type")
})
public class Tarief {

    /**
     * Entity's unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private int id;

    @JsonView(View.Public.class)
    private long type;

    @JsonView(View.Public.class)
    private Double prijs;

    @JsonView(View.Public.class)
    private long theater;

    /**
     * A no-argument constructor.
     */
    public Tarief(){
    }

    @JsonCreator
    public Tarief(@JsonProperty("type") long type,
                @JsonProperty("prijs") Double prijs,
                @JsonProperty("theater") long theater){
        this.type = type;
        this.prijs = prijs;
        this.theater = theater;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public Double getPrijs() {
        return prijs;
    }

    public void setPrijs(Double prijs) {
        this.prijs = prijs;
    }

    public long getTheater() {
        return theater;
    }

    public void setTheater(long theater) {
        this.theater = theater;
    }
}
