package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Gebruiker;
import nl.hsleiden.model.Gekocht;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class GekochtDAO extends AbstractDAO<Gekocht> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public GekochtDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Gekocht> getAll(long id) {
        return list(namedQuery("Gekocht.getAll")
                .setParameter("uId", id)
        );
    }

    public Optional<Gekocht> findById(long id) {
        return Optional.ofNullable(get(id));
    }

    public void delete(Gekocht film) {
        currentSession().delete(film);
    }

    public void update(Gekocht film) {
        currentSession().saveOrUpdate(film);
    }

    public Optional<Gekocht> set(Gekocht gekocht) {
        return Optional.ofNullable(persist(gekocht));
    }

    public boolean exists(long filmId, long gebruikerId) {
        boolean exists = (Long) currentSession().createQuery(
                "SELECT COUNT(1) " +
                        "FROM Gekocht " +
                        "WHERE film.id = :fId " +
                        "AND gebruiker.id = :gId")
                .setParameter("fId", filmId)
                .setParameter("gId", gebruikerId)
                .uniqueResult() > 0;
        return exists;
    }
}
