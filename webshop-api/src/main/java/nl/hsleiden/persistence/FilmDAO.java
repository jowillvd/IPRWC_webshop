package nl.hsleiden.persistence;

import nl.hsleiden.model.Film;
import nl.hsleiden.model.Filmcast;
import nl.hsleiden.model.Filmcrew;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

/**
 * @author Jordy van Dijk
 */
public interface FilmDAO {

    @SqlQuery("SELECT id, titel FROM films")
    @RegisterBeanMapper(Film.class)
    List<Film> getAll();

    @SqlQuery("SELECT * FROM filmcast WHERE film = :id")
    @RegisterBeanMapper(Filmcast.class)
    List<Filmcast> getFilmcastByFilm(@Bind int id);

    @SqlQuery("SELECT * FROM filmcrew WHERE film = :id")
    @RegisterBeanMapper(Filmcrew.class)
    List<Filmcrew> getFilmcrewByFilm(@Bind int id);

    @SqlQuery("SELECT * FROM films WHERE id = :id")
    Optional<Film> getById(@Bind int id);

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO films (`titel`, `regisseur`, `release`, `beschrijving`,`filmtrailer`)" +
            " VALUES (:film.titel, :regisseur, :film.release, :film.beschrijving,:film.filmtrailer)")
    int add(@BindBean("film") Film film, @Bind("regisseur") long regisseur);
}
