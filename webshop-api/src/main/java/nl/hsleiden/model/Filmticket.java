package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;

import javax.persistence.*;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
@Entity
@Table(name = "filmtickets")
@NamedQueries({
        @NamedQuery(name = "Filmticket.getAll",
                    query = "SELECT ft FROM Filmticket ft"),

        @NamedQuery(name = "Filmticket.findByFilmvertoningId",
                    query = "SELECT ft FROM Filmticket ft " +
                            "WHERE filmvertoning = :fvId" +
                            " AND verkocht = 0")
})
public class Filmticket {

    /**
     * Entity's unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private long id;

    @JsonView(View.Public.class)
    private int zitplaats;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "filmvertoning")
    @JsonView(View.Public.class)
    private Filmvertoning filmvertoning;

    @JsonView(View.Public.class)
    private int verkocht;

    /**
     * A no-argument constructor.
     */
    public Filmticket(){
    }

    @JsonCreator
    public Filmticket(@JsonProperty("zitplaats") int zitplaats,
                      @JsonProperty("filmvertoning") Filmvertoning filmvertoning,
                      @JsonProperty("verkocht") int verkocht){
        this.zitplaats = zitplaats;
        this.filmvertoning = filmvertoning;
        this.verkocht = verkocht;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getZitplaats() {
        return zitplaats;
    }

    public void setZitplaats(int zitplaats) {
        this.zitplaats = zitplaats;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Filmvertoning getFilmvertoning() {
        return filmvertoning;
    }

    public void setFilmvertoning(Filmvertoning filmvertoning) {
        this.filmvertoning = filmvertoning;
    }

    public int getVerkocht() {
        return verkocht;
    }

    public void setVerkocht(int verkocht) {
        this.verkocht = verkocht;
    }
}
