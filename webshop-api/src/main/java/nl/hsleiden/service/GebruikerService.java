package nl.hsleiden.service;

import com.google.inject.Inject;
import nl.hsleiden.model.Gebruiker;
import nl.hsleiden.persistence.GebruikerDAO;

import javax.inject.Singleton;

@Singleton
public class GebruikerService extends BaseService<Gebruiker> {

    GebruikerDAO gebruikerDAO;

    @Inject
    public GebruikerService(GebruikerDAO dao) {
        gebruikerDAO = dao;
    }

    public Gebruiker get(long id) {
        Gebruiker gebruiker = gebruikerDAO.findById(id).orElse(null);
        return gebruiker;
    }

//    public int add(Gebruiker gebruiker) {
//        return gebruikerDAO.add(gebruiker);
//    }
//
//    public void update(Gebruiker authenticator, long id, Gebruiker gebruiker) {
//        if (get(id) != null && authenticator.getId() == id) {
//            gebruikerDAO.update(gebruiker, id);
//        }
//    }
//
//    public void delete(Gebruiker authenticator, long id) {
//        if (get(id) != null && (authenticator.getId() == id || authenticator.hasRole("ADMIN"))) {
//            gebruikerDAO.delete(id);
//        }
//    }

}