package nl.hsleiden.service;

import com.google.inject.Inject;
import nl.hsleiden.model.Film;
import nl.hsleiden.model.Gebruiker;
import nl.hsleiden.model.Gekocht;
import nl.hsleiden.persistence.FilmDAO;
import nl.hsleiden.persistence.GekochtDAO;

import java.util.List;

public class GekochtService {
    GekochtDAO gekochtDAO;
    FilmDAO filmDAO;

    @Inject
    public GekochtService(GekochtDAO gekochtDAO, FilmDAO filmDAO) {
        this.gekochtDAO = gekochtDAO;
        this.filmDAO = filmDAO;
    }

    public Gekocht get(long id, Gebruiker authenticator) {
        Gekocht gekocht = gekochtDAO.findById(id)
                .filter(gekocht1 -> gekocht1.getGebruiker().getId() == authenticator.getId())
                .orElse(null);

        return gekocht;
    }

    public List<Gekocht> get(Gebruiker authenticator) {
        List<Gekocht> filmtickets = gekochtDAO.getAll(authenticator.getId());
        return filmtickets.size() > 0 ? filmtickets : null;
    }

    public void update(long id, Gekocht gekocht, Gebruiker authenticator) {
        gekocht.setId(id);
        if (get(id, authenticator).getId() == gekocht.getId()) {
            gekochtDAO.update(gekocht);
        }
    }

    public Gekocht set(Gekocht gekocht, Gebruiker authenticator) {
        Film film = filmDAO.findById(gekocht.getFilm().getId()).orElse(null);
        if (film != null && !exists(authenticator, film.getId())) {
            gekocht.setFilm(film);
            gekocht.setGebruiker(authenticator);
            return gekochtDAO.set(gekocht).orElse(null);
        }
        return null;
    }

    public void delete(long id, Gebruiker authenticator) {
        Gekocht filmticket = get(id, authenticator);
        if (filmticket != null) {
            gekochtDAO.delete(filmticket);
        }
    }

    public boolean exists(Gebruiker authenticator, long filmId) {
        return gekochtDAO.exists(filmId, authenticator.getId());
    }
}
