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
@Table(name = "theaters")
@NamedQueries({
        @NamedQuery(name = "Theater.getAll",
                    query = "SELECT t FROM Theater t"),

        @NamedQuery(name = "Theater.findByName",
                    query = "SELECT t FROM Theater t " +
                            "WHERE naam like :name")
})
public class Theater {

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organisatie")
    @JsonView(View.Public.class)
    private Organisatie organisatie;

    @NotEmpty
    @Length(max = 255)
    @JsonView(View.Public.class)
    private String straat;

    @NotEmpty
    @Length(max = 255)
    @JsonView(View.Public.class)
    private String plaats;

    @NotEmpty
    @Length(max = 255)
    @JsonView(View.Public.class)
    private String postcode;

    /**
     * A no-argument constructor.
     */
    public Theater(){
    }

    @JsonCreator
    public Theater(@JsonProperty("naam") String naam,
                   @JsonProperty("organisatie") Organisatie organisatie,
                   @JsonProperty("straat") String straat,
                   @JsonProperty("plaats") String plaats,
                   @JsonProperty("postcode") String postcode){
        this.naam = naam;
        this.organisatie = organisatie;
        this.straat = straat;
        this.plaats = plaats;
        this.postcode = postcode;
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

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Organisatie getOrganisatie() {
        return organisatie;
    }

    public void setOrganisatie(Organisatie organisatie) {
        this.organisatie = organisatie;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
