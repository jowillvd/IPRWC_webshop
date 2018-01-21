package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;

import javax.persistence.*;
import java.util.Date;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Toegangsbewijs.findByUserId",
                query = "SELECT tb FROM Toegangsbewijs tb " +
                        "WHERE gebruiker = :uId")
})
@Table(name = "toegangsbewijzen")
public class Toegangsbewijs {

    /**
     * Entity's unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket")
    @JsonView(View.Public.class)
    private Filmticket ticket;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gebruiker")
    @JsonView(View.Public.class)
    private Gebruiker gebruiker;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(View.Public.class)
    private Date aangemaakt;

    /**
     * A no-argument constructor.
     */
    public Toegangsbewijs(){
    }

    @JsonCreator
    public Toegangsbewijs(@JsonProperty("filmticket") Filmticket ticket,
                @JsonProperty("gebruiker") Gebruiker gebruiker,
                @JsonProperty("aangemaakt") Date aangemaakt){
        this.ticket = ticket;
        this.gebruiker = gebruiker;
        this.aangemaakt = aangemaakt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Filmticket getTicket() {
        return ticket;
    }

    public void setTicket(Filmticket ticket) {
        this.ticket = ticket;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public Date getAangemaakt() {
        return aangemaakt;
    }

    public void setAangemaakt(Date aangemaakt) {
        this.aangemaakt = aangemaakt;
    }
}
