/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hsleiden;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.dropwizard.hibernate.HibernateBundle;
import nl.hsleiden.persistence.FilmDAO;
import nl.hsleiden.persistence.GebruikerDAO;
import nl.hsleiden.persistence.PersoonDAO;

/**
 *
 * @author Jordy van Dijk
 */
public class ApiGuiceModule extends AbstractModule {

    private final HibernateBundle<ApiConfiguration> hibernateBundle;

    public ApiGuiceModule(HibernateBundle<ApiConfiguration> hibernateBundle) {
        this.hibernateBundle = hibernateBundle;
    }

    @Provides
    public FilmDAO filmDAO() {
        return new FilmDAO(hibernateBundle.getSessionFactory());
    }

    @Provides
    public GebruikerDAO gebruikerDAO() {
        return new GebruikerDAO(hibernateBundle.getSessionFactory());
    }

    @Provides
    public PersoonDAO persoonDAO() {
        return new PersoonDAO(hibernateBundle.getSessionFactory());
    }

    @Override
    protected void configure() {
    }
}
