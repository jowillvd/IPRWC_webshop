package nl.hsleiden.persistence;

import nl.hsleiden.model.Persoon;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

public interface PersoonDAO {

    @SqlQuery("SELECT * FROM films")
    @RegisterBeanMapper(Persoon.class)
    List<Persoon> getAll();

    @SqlQuery("SELECT * FROM persoon WHERE id = :id")
    Optional<Persoon> getById(@Bind int id);

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO personen (voornaam, achternaam)" +
            "VALUES (:voornaam, :achternaam)")
    int add(@BindBean Persoon persoon);
}
