package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;

public class Winkelwagen {

    @JsonView(View.Protected.class)
    private int id;

    @JsonView(View.Protected.class)
    private Gebruiker gebruiker;

    @JsonView(View.Protected.class)
    private Filmticket filmticket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public Filmticket getFilmticket() {
        return filmticket;
    }

    public void setFilmticket(Filmticket filmticket) {
        this.filmticket = filmticket;
    }
}
