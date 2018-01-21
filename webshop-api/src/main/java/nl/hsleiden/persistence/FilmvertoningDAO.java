package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Filmvertoning;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class FilmvertoningDAO extends AbstractDAO<Filmvertoning> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public FilmvertoningDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Filmvertoning> getAll() {
        return list(namedQuery("Filmvertoning.getAll"));
    }

    public List<Filmvertoning> findByFilmId(long filmId) {
        return list(
                namedQuery("Filmvertoning.findByFilmId")
                        .setParameter("filmId", filmId)
        );
    }

    public Optional<Filmvertoning> findById(long id) {
        return Optional.ofNullable(get(id));
    }

    public void delete(Filmvertoning film) {
        currentSession().delete(film);
    }

    public void update(Filmvertoning filmvertoning) {
        currentSession().saveOrUpdate(filmvertoning);
    }

    public Optional<Filmvertoning> set(Filmvertoning filmvertoning) {
        return Optional.ofNullable(persist(filmvertoning));
    }

}
