package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
public class Toegangsbewijs {

    @JsonView(View.Protected.class)
    private long barcode;

    @JsonView(View.Protected.class)
    private Filmticket filmticket;

    @JsonView(View.Protected.class)
    private Gebruiker gebruiker;

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public Filmticket getFilmticket() {
        return filmticket;
    }

    public void setFilmticket(Filmticket filmticket) {
        this.filmticket = filmticket;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }
}
