package nl.hsleiden.service;

import com.google.inject.Inject;
import nl.hsleiden.model.Filmvertoning;
import nl.hsleiden.persistence.FilmvertoningDAO;

import java.util.List;

public class FilmvertoningService {
    FilmvertoningDAO filmvertoningDAO;

    @Inject
    public FilmvertoningService(FilmvertoningDAO filmvertoningDAO) {
        this.filmvertoningDAO = filmvertoningDAO;
    }

    public Filmvertoning get(long id) {
        Filmvertoning filmticket = filmvertoningDAO.findById(id).orElse(null);
        return filmticket;
    }

    public List<Filmvertoning> get() {
        List<Filmvertoning> filmtickets = filmvertoningDAO.getAll();
        return filmtickets.size() > 0 ? filmtickets : null;
    }

    public List<Filmvertoning> findByFilm(long id) {
        List<Filmvertoning> filmtickets = filmvertoningDAO.findByFilmId(id);
        return filmtickets.size() > 0 ? filmtickets : null;
    }

    public void update(long id, Filmvertoning filmticket) {
        filmticket.setId(id);
        if (get(id).getId() == filmticket.getId()) {
            filmvertoningDAO.update(filmticket);
        }
    }

    public Filmvertoning set(Filmvertoning filmticket) {
        return filmvertoningDAO.set(filmticket).orElse(null);
    }

    public void delete(long id) {
        Filmvertoning filmticket = get(id);
        if (filmticket != null) {
            filmvertoningDAO.delete(filmticket);
        }
    }
}
