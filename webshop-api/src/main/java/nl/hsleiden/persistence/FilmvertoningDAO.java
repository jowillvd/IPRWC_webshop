package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Filmvertoning;
import org.hibernate.SessionFactory;

public class FilmvertoningDAO extends AbstractDAO<Filmvertoning> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public FilmvertoningDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
