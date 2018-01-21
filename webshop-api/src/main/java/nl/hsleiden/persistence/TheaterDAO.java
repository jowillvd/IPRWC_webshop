package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Theater;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class TheaterDAO extends AbstractDAO<Theater> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public TheaterDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Theater> getAll() {
        return list(namedQuery("Tarief.getAll"));
    }

    public List<Theater> findByName(String name) {
        return list(namedQuery("Tarief.findByName")
                .setParameter("naam", "%" + name + "%")
        );
    }

    public Optional<Theater> findById(long id) {
        return Optional.ofNullable(get(id));
    }

    public void delete(Theater theater) {
        currentSession().delete(theater);
    }

    public void update(Theater theater) {
        currentSession().saveOrUpdate(theater);
    }

    public Optional<Theater> set(Theater theater) {
        return Optional.ofNullable(persist(theater));
    }

}
