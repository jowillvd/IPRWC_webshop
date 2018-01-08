package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Gebruiker;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

/**
 * @author Jordy van Dijk
 */
public class GebruikerDAO extends AbstractDAO<Gebruiker> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public GebruikerDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Gebruiker> getAll() {
        return list(namedQuery("Gebruiker.getAll"));
    }

    public List<Gebruiker> findByName(String name) {
        return list(namedQuery("Gebruiker.findByName")
                .setParameter("naam", "%" + name + "%")
        );
    }

    public Optional<Gebruiker> findById(long id) {
        return Optional.ofNullable(get(id));
    }

    public Optional<Gebruiker> findByEmail(String email) {

        return Optional.ofNullable(uniqueResult(namedQuery("Gebruiker.findByEmail")
                .setParameter("mail", email))
        );

    }
}
