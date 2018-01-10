package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Zaal;
import org.hibernate.SessionFactory;

public class ZaalDAO extends AbstractDAO<Zaal> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public ZaalDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
