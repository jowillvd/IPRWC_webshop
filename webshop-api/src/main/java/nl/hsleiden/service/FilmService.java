package nl.hsleiden.service;

import com.google.inject.Inject;
import nl.hsleiden.model.Film;
import nl.hsleiden.model.Gebruiker;
import nl.hsleiden.persistence.FilmDAO;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class FilmService {

    FilmDAO filmDAO;

    @Inject
    public FilmService(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    /**
     * Get single film by unique id
     *
     * @param id
     * @return
     */
    public Film get(long id) {
        Film film = filmDAO.findById(id).orElse(null);
        return film;
    }

    /**
     * Get all films
     *
     * @return
     */
    public List<Film> get() {
        List<Film> films = filmDAO.getAll();
        return films.size() > 0 ? films : null;
    }

    /**
     * Search films by given titel
     *
     * @param titel search value
     * @return List of users if found
     */
    public List<Film> search(String titel) {
        List<Film> films = filmDAO.findByName(titel);
        return films.size() > 0 ? films : null;
    }

    /**
     * @param authenticator
     * @param id
     * @param film
     */
    public void update(Gebruiker authenticator, long id, Film film) {
        film.setId(id);
        if (get(id).getId() == film.getId()) {
            filmDAO.update(film);
        }
    }

    /**
     * @param film
     * @return
     */
    public Film set(Film film) {
        return filmDAO.set(film).orElse(null);
    }

    /**
     * @param authenticator
     * @param id
     */
    public void delete(Gebruiker authenticator, long id) {
        Film film = get(id);
        if (film != null) {
            filmDAO.delete(film);
        }
    }

}
