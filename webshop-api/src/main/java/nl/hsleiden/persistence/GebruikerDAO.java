package nl.hsleiden.persistence;

import nl.hsleiden.model.Gebruiker;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.BindMethods;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

/**
 * @author Jordy van Dijk
 */
public interface GebruikerDAO {

    @SqlQuery("SELECT * FROM gebruikers")
    List<Gebruiker> getAll();

    @SqlQuery("SELECT * FROM gebruikers WHERE email = :email")
    Optional<Gebruiker> getByEmail(@Bind String email);

    @SqlQuery("SELECT * FROM gebruikers WHERE id = :id")
    Gebruiker getById(@Bind long id);

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO gebruikers (email, wachtwoord, voornaam, achternaam)" +
            "VALUES (:email, :wachtwoord, :voornaam, :achternaam)")
    int add(@BindBean Gebruiker gebruiker);

    @SqlUpdate("UPDATE gebruikers " +
            "SET email = :u.email," +
            "    wachtwoord = :u.wachtwoord," +
            "    voornaam = :u.voornaam," +
            "    achternaam = :u.achternaam" +
            "WHERE id = :id")
    void update(@BindBean("u") Gebruiker gebruiker, @Bind long id);

    @SqlUpdate("DELETE FROM gebruikers WHERE id = :id")
    void delete(@Bind long id);
}
