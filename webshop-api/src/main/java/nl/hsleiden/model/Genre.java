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
public class Genre {

    @JsonView(View.Public.class)
    private int id;

    @NotEmpty
    @Length(min = 1, max = 255)
    @JsonView(View.Public.class)
    private String naam;

    @Length(max = 750)
    @JsonView(View.Public.class)
    private String beschrijving;

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

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
}
