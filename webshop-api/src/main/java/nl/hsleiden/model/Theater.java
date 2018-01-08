package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
public class Theater {

    @JsonView(View.Public.class)
    private int id;

    @NotEmpty
    @Length(min = 1, max = 255)
    @JsonView(View.Public.class)
    private String naam;

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
