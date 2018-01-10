package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
@Entity
@Table(name = "zalen")
@NamedQueries({
        @NamedQuery(name = "Zaal.getAll",
                   query = "SELECT z FROM Zaal z"),

        @NamedQuery(name = "Zaal.findByName",
                    query = "SELECT z FROM Zaal z " +
                            "WHERE zaalnaam LIKE :zaal"),

        @NamedQuery(name = "Zaal.findByTheater",
                    query = "SELECT z FROM Zaal z " +
                            "WHERE theater = :theater")
})
public class Zaal {

    /**
     * Entity's unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private int id;

    @NotNull
    @JsonView(View.Public.class)
    private String zaalnaam;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theater")
    @JsonView(View.Public.class)
    private Theater theater;

    @JsonView(View.Public.class)
    private int zitplaatsen;

    @Length(max = 750)
    @JsonView(View.Public.class)
    private String beschrijving;

    /**
     * A no-argument constructor.
     */
    public Zaal(){
    }

    @JsonCreator
    public Zaal(@JsonProperty("zaalnaam") String zaalnaam,
                @JsonProperty("theater") Theater theater,
                @JsonProperty("zitplaatsen") int zitplaatsen,
                @JsonProperty("beschrijving") String beschrijving){
        this.zaalnaam = zaalnaam;
        this.theater = theater;
        this.zitplaatsen = zitplaatsen;
        this.beschrijving = beschrijving;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZaalnaam() {
        return zaalnaam;
    }

    public void setZaalnaam(String zaalnaam) {
        this.zaalnaam = zaalnaam;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public int getZitplaatsen() {
        return zitplaatsen;
    }

    public void setZitplaatsen(int zitplaatsen) {
        this.zitplaatsen = zitplaatsen;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
}
