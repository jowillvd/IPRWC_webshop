package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Genre;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class GenreDAO extends AbstractDAO<Genre> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public GenreDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Genre> getAll() {
        return list(namedQuery("Genre.getAll"));
    }

    public List<Genre> findByName(String name) {
        return list(namedQuery("Genre.findByName")
                .setParameter("naam", "%" + name + "%")
        );
    }

    public Optional<Genre> findById(long id) {
        return Optional.ofNullable(get(id));
    }

    public void delete(Genre genre) {
        currentSession().delete(genre);
    }

    public void update(Genre genre) {
        currentSession().saveOrUpdate(genre);
    }

    public Optional<Genre> set(Genre genre) {
        return Optional.ofNullable(persist(genre));
    }

}
