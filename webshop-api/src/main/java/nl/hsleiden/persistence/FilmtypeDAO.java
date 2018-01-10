package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Filmtype;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class FilmtypeDAO extends AbstractDAO<Filmtype> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public FilmtypeDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Filmtype> getAll() {
        return list(namedQuery("Filmtype.getAll"));
    }

    public List<Filmtype> findByType(String type) {
        return list(namedQuery("Filmtype.findType")
                .setParameter("type", "%" + type + "%")
        );
    }

    public Optional<Filmtype> findById(long id) {
        return Optional.ofNullable(get(id));
    }

    public void delete(Filmtype filmtype) {
        currentSession().delete(filmtype);
    }

    public void update(Filmtype filmtype) {
        currentSession().saveOrUpdate(filmtype);
    }

    public Optional<Filmtype> set(Filmtype filmtype) {
        return Optional.ofNullable(persist(filmtype));
    }

}
