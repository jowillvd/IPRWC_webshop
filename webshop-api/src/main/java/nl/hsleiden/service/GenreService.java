package nl.hsleiden.service;

import com.google.inject.Inject;
import nl.hsleiden.model.Genre;
import nl.hsleiden.persistence.GenreDAO;

import java.util.List;

public class GenreService {

    GenreDAO genreDAO;

    @Inject
    public GenreService(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    /**
     * Get single film by unique id
     *
     * @param id
     * @return
     */
    public Genre get(long id) {
        Genre genre = genreDAO.findById(id).orElse(null);
        return genre;
    }

    /**
     * Get all users
     *
     * @return
     */
    public List<Genre> get() {
        List<Genre> genres = genreDAO.getAll();
        return genres.size() > 0 ? genres : null;
    }

    /**
     * Search films by given titel
     *
     * @param name search value
     * @return List of users if found
     */
    public List<Genre> search(String name) {
        List<Genre> genres = genreDAO.findByName(name);
        return genres.size() > 0 ? genres : null;
    }

    /**
     * @param id
     * @param genre
     */
    public void update(long id, Genre genre) {
        genre.setId(id);
        if (get(id).getId() == genre.getId()) {
            genreDAO.update(genre);
        }
    }

    /**
     * @param genre
     * @return
     */
    public Genre set(Genre genre) {
        return genreDAO.set(genre).orElse(null);
    }

    /**
     * @param id
     */
    public void delete(long id) {
        Genre genre = get(id);
        if (genre != null) {
            genreDAO.delete(genre);
        }
    }

}
