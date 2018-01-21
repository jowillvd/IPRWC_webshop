package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.security.Principal;
import java.util.Date;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
@Entity
@Table(name = "gebruikers")
@NamedQueries({
        @NamedQuery(name = "Gebruiker.getAll",
                    query = "SELECT g FROM Gebruiker g"),

        @NamedQuery(name = "Gebruiker.findByName",
                    query = "SELECT g FROM Gebruiker g " +
                            "WHERE voornaam LIKE :naam" +
                            "   OR achternaam LIKE :naam"),

        @NamedQuery(name = "Gebruiker.findByEmail",
                    query = "SELECT g FROM Gebruiker g " +
                            "WHERE email = :mail")
})
public class Gebruiker implements Principal {

    /**
     * Entity's unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private long id;

    @NotEmpty
    @Length(min = 6)
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

    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(View.Private.class)
    private Date geregistreerd;

    @Temporal(TemporalType.DATE)
    @JsonView(View.Protected.class)
    private Date geboortedatum;

    @JsonView(View.Public.class)
    private String rol;

    //TODO: USING ENUMERATION FOR ROL
    private enum Rol {
        STANDAARD,
        ADMIN,
        ORDELAAR,
        SCHRIJVER,
        BEHEERDER
    }

    public Gebruiker() {
    }

    @JsonCreator
    public Gebruiker(@JsonProperty("wachtwoord") String wachtwoord,
                     @JsonProperty("email") String email,
                     @JsonProperty("voornaam") String voornaam,
                     @JsonProperty("achternaam") String achternaam,
                     @JsonProperty("geboortedatum") Date geboortedatum,
                     @JsonProperty("geregistreerd") Date geregistreerd,
                     @JsonProperty("rol") String rol){
        this.wachtwoord = wachtwoord;
        this.email = email;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.geregistreerd = geregistreerd;
        this.rol = rol;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        this.geboortedatum = new Date(geboortedatum.getTime());
    }

    public Date getGeregistreerd() {
        return geregistreerd;
    }

    public void setGeregistreerd(Date geregistreerd) {
        this.geregistreerd = new Date(geregistreerd.getTime());
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public boolean hasRole(String role) {
        return this.rol.equals(role);
    }
}
