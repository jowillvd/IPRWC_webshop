package nl.hsleiden.service;

import com.google.inject.Inject;
import nl.hsleiden.model.Gebruiker;
import nl.hsleiden.persistence.GebruikerDAO;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class GebruikerService extends BaseService<Gebruiker> {

    GebruikerDAO gebruikerDAO;

    @Inject
    public GebruikerService(GebruikerDAO dao) {
        gebruikerDAO = dao;
    }

    /**
     * Get single user by unique id
     *
     * @param id
     * @return
     */
    public Gebruiker get(long id) {
        Gebruiker gebruiker = gebruikerDAO.findById(id).orElse(null);
        return gebruiker;
    }

    /**
     * Get all users
     *
     * @return
     */
    public List<Gebruiker> get() {
        List<Gebruiker> gebruikers = gebruikerDAO.getAll();
        return gebruikers.size() > 0 ? gebruikers : null;
    }

    /**
     * Search users by given name/lastname
     *
     * @param name search value
     * @return List of users if found
     */
    public List<Gebruiker> search(String name) {
        List<Gebruiker> gebruikers = gebruikerDAO.findByName(name);
        return gebruikers.size() > 0 ? gebruikers : null;
    }

    /**
     *
     * @param authenticator
     * @param id
     * @param gebruiker
     */
    public void update(Gebruiker authenticator, long id, Gebruiker gebruiker) {
        gebruiker.setId(id);
        if (authenticator.getId() == gebruiker.getId()) {
            gebruikerDAO.update(gebruiker);
        }
    }

    /**
     *
     * @param gebruiker
     * @return
     */
    public Gebruiker set(Gebruiker gebruiker) {
        return gebruikerDAO.set(gebruiker).orElse(null);
    }

    /**
     *
     * @param authenticator
     * @param id
     */
    public void delete(Gebruiker authenticator, long id) {
        Gebruiker gebruiker = get(id);
        if (gebruiker != null && (authenticator.getId() == id || authenticator.hasRole("ADMIN"))) {
            gebruikerDAO.delete(gebruiker);
        }
    }

}