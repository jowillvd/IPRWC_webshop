package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
public class Filmticket {

    @JsonView(View.Public.class)
    private int id;

    @NotEmpty
    @JsonView(View.Public.class)
    private int zitplaats;

    @JsonView(View.Public.class)
    private Filmvertoning filmvertoning;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZitplaats() {
        return zitplaats;
    }

    public void setZitplaats(int zitplaats) {
        this.zitplaats = zitplaats;
    }

    public Filmvertoning getFilmvertooning() {
        return filmvertoning;
    }

    public void setFilmlocatie(Filmvertoning filmvertoning) {
        this.filmvertoning = filmvertoning;
    }
}
