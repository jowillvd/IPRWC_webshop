package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Filmticket;
import org.hibernate.SessionFactory;

public class FilmticketDAO extends AbstractDAO<Filmticket> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public FilmticketDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
