package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Toegangsbewijs;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class ToegangsbewijsDAO extends AbstractDAO<Toegangsbewijs> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public ToegangsbewijsDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Toegangsbewijs> findById(long id) {
        return Optional.ofNullable(get(id));
    }

    public void delete(Toegangsbewijs toegangsbewijs) {
        currentSession().delete(toegangsbewijs);
    }

    public void update(Toegangsbewijs toegangsbewijs) {
        currentSession().saveOrUpdate(toegangsbewijs);
    }

    public Optional<Toegangsbewijs> set(Toegangsbewijs toegangsbewijs) {
        return Optional.ofNullable(persist(toegangsbewijs));
    }

}
