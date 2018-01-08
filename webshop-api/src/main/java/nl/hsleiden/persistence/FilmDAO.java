package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Film;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class FilmDAO extends AbstractDAO<Film> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public FilmDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Film> getAll() {
        return list(namedQuery("Film.getAll"));
    }

    public List<Film> findByName(String name) {
        return list(namedQuery("Film.findByName")
                .setParameter("titel", "%" + name + "%")
        );
    }

    public Optional<Film> findById(long id) {
        return Optional.ofNullable(get(id));
    }
}
