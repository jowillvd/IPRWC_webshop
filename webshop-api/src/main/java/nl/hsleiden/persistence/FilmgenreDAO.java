package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Filmgenre;
import org.hibernate.SessionFactory;

public class FilmgenreDAO extends AbstractDAO<Filmgenre> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public FilmgenreDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
