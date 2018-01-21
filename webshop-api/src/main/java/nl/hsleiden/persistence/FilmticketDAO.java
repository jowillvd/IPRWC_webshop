package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Filmticket;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class FilmticketDAO extends AbstractDAO<Filmticket> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public FilmticketDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Filmticket> getAll() {
        return list(namedQuery("Filmticket.getAll"));
    }

    public List<Filmticket> findByFilmvertoningId(int id) {
        return list(
                namedQuery("Filmticket.findByFilmvertoningId")
                        .setParameter("fvId", id)
        );
    }

    public Optional<Filmticket> findById(long id) {
        return Optional.ofNullable(get(id));
    }

    public void delete(Filmticket filmticket) {
        currentSession().delete(filmticket);
    }

    public void update(Filmticket filmticket) {
        currentSession().saveOrUpdate(filmticket);
    }

    public Optional<Filmticket> set(Filmticket filmticket) {
        return Optional.ofNullable(persist(filmticket));
    }

}
