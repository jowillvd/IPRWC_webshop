package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Tarief;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class TariefDAO extends AbstractDAO<Tarief> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public TariefDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Tarief> getAll() {
        return list(namedQuery("Tarief.getAll"));
    }

    public List<Tarief> findByName(String name) {
        return list(namedQuery("Tarief.findByName")
                .setParameter("soort", "%" + name + "%")
        );
    }

    public Optional<Tarief> findById(long id) {
        return Optional.ofNullable(get(id));
    }

    public void delete(Tarief tarief) {
        currentSession().delete(tarief);
    }

    public void update(Tarief tarief) {
        currentSession().saveOrUpdate(tarief);
    }

    public Optional<Tarief> set(Tarief tarief) {
        return Optional.ofNullable(persist(tarief));
    }

}
