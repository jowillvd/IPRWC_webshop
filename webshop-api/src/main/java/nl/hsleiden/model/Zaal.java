package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class Zaal {

    @JsonView(View.Public.class)
    private int id;

    @NotNull
    @JsonView(View.Public.class)
    private String zaalnaam;

    @JsonView(View.Public.class)
    private Theater theater;

    @NotNull
    @JsonView(View.Public.class)
    private int zitplaatsen;

    @Length(max = 255)
    @JsonView(View.Public.class)
    private String zaaltype;

    @Length(max = 750)
    @JsonView(View.Public.class)
    private String beschrijving;

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

    public String getZaaltype() {
        return zaaltype;
    }

    public void setZaaltype(String zaaltype) {
        this.zaaltype = zaaltype;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
}
