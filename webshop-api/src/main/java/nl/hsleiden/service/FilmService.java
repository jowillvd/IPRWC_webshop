package nl.hsleiden.service;

import com.google.inject.Inject;
import nl.hsleiden.model.Film;
import nl.hsleiden.persistence.FilmDAO;
import nl.hsleiden.persistence.PersoonDAO;

import javax.inject.Singleton;

@Singleton
public class FilmService {

    FilmDAO filmDAO;
    PersoonDAO persoonDAO;

    @Inject
    public FilmService(FilmDAO filmDAO, PersoonDAO persoonDAO) {
        this.filmDAO = filmDAO;
        this.persoonDAO = persoonDAO;
    }

    public Film get(int id) {
        Film film = filmDAO.getById(id).orElse(null);
        return film;
    }

    public int add(Film film) {
        if(film.getRegisseur() != null){
            film.getRegisseur().setId(persoonDAO.add(film.getRegisseur()));
        }

        return filmDAO.add(film, film.getRegisseur().getId());
    }
}
