package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.security.Principal;
import java.util.Date;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
public class Gebruiker implements Principal {

    @JsonView(View.Private.class)
    private int id;

    @NotEmpty
    @Length(min = 8)
    @JsonView(View.Private.class)
    public String wachtwoord;

    @NotEmpty
    @Email
    @Length(min = 6, max = 255)
    @JsonView(View.Protected.class)
    public String email;

    @NotEmpty
    @Length(min = 1, max = 255)
    @JsonView(View.Public.class)
    public String voornaam;

    @NotEmpty
    @Length(min = 1, max = 255)
    @JsonView(View.Public.class)
    public String achternaam;

    @JsonView(View.Protected.class)
    private Date geboortedatum;

    @JsonView(View.Private.class)
    private Date geregistreerd;

    @JsonView(View.Public.class)
    private Rol rol;

    private enum Rol {
        STANDAARD,
        ADMIN,
        ORDELAAR,
        SCHRIJVER,
        BEHEERDER
    }

    /**
     * Returns the name of this principal.
     *
     * @return the name of this principal.
     */
    @Override
    @JsonIgnore
    public String getName() {
        return getVoornaam() + getAchternaam();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public Date getGeregistreerd() {
        return geregistreerd;
    }

    public void setGeregistreerd(Date geregistreerd) {
        this.geregistreerd = geregistreerd;
    }

    public boolean hasRole(String role) {
        return this.rol.name().equals(role);
    }
}
