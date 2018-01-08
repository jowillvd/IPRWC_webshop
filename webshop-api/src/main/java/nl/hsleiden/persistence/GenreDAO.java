package nl.hsleiden.persistence;

import nl.hsleiden.model.Genre;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface GenreDAO {
    @SqlUpdate("INSERT INTO genre(id, naam, beschrijving) VALUES (:naam, :beschrijving)")
    @GetGeneratedKeys("id")
    void insert(@BindBean Genre genre);
}

