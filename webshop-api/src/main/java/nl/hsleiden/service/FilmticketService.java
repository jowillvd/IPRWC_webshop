package nl.hsleiden.service;

import com.google.inject.Inject;
import nl.hsleiden.model.Filmticket;
import nl.hsleiden.persistence.FilmticketDAO;

import java.util.List;

public class FilmticketService {
    FilmticketDAO filmticketDAO;

    @Inject
    public FilmticketService(FilmticketDAO filmticketDAO) {
        this.filmticketDAO = filmticketDAO;
    }

    public Filmticket get(long id) {
        Filmticket filmticket = filmticketDAO.findById(id).orElse(null);
        return filmticket;
    }

    public List<Filmticket> get() {
        List<Filmticket> filmtickets = filmticketDAO.getAll();
        return filmtickets.size() > 0 ? filmtickets : null;
    }

    public List<Filmticket> getByFilmvertoning(int id) {
        List<Filmticket> filmtickets = filmticketDAO.findByFilmvertoningId(id);
        return filmtickets.size() > 0 ? filmtickets : null;
    }

    public void update(long id, Filmticket filmticket) {
        filmticket.setId(id);
        if (get(id).getId() == filmticket.getId()) {
            filmticketDAO.update(filmticket);
        }
    }

    public Filmticket set(Filmticket filmticket) {
        return filmticketDAO.set(filmticket).orElse(null);
    }

    public void delete(long id) {
        Filmticket filmticket = get(id);
        if (filmticket != null) {
            filmticketDAO.delete(filmticket);
        }
    }
}
