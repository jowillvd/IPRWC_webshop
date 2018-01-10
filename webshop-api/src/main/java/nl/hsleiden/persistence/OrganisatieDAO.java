package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Organisatie;
import org.hibernate.SessionFactory;

public class OrganisatieDAO extends AbstractDAO<Organisatie> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public OrganisatieDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
