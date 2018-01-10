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
                            "WHERE soort LIKE :soort")
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
    private String soort;

    @JsonView(View.Public.class)
    private Double prijs;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theater")
    @JsonView(View.Public.class)
    private Theater theater;

    /**
     * A no-argument constructor.
     */
    public Tarief(){
    }

    @JsonCreator
    public Tarief(@JsonProperty("soort") String soort,
                @JsonProperty("prijs") Double prijs,
                @JsonProperty("theater") Theater theater){
        this.soort = soort;
        this.prijs = prijs;
        this.theater = theater;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public Double getPrijs() {
        return prijs;
    }

    public void setPrijs(Double prijs) {
        this.prijs = prijs;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
