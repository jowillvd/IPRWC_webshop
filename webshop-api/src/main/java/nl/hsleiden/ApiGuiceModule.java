/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hsleiden;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.dropwizard.hibernate.HibernateBundle;
import nl.hsleiden.model.Filmtype;
import nl.hsleiden.persistence.*;

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
    public FilmgenreDAO filmgenreDAO() {
        return new FilmgenreDAO(hibernateBundle.getSessionFactory());
    }

    @Provides
    public FilmticketDAO filmticketDAO() {
        return new FilmticketDAO(hibernateBundle.getSessionFactory());
    }

    @Provides
    public FilmtypeDAO filmtypeDAO() {
        return new FilmtypeDAO(hibernateBundle.getSessionFactory());
    }

    @Provides
    public FilmvertoningDAO filmvertoningDAO() {
        return new FilmvertoningDAO(hibernateBundle.getSessionFactory());
    }

    @Provides
    public GebruikerDAO gebruikerDAO() {
        return new GebruikerDAO(hibernateBundle.getSessionFactory());
    }

    @Provides
    public GenreDAO genreDAO() {
        return new GenreDAO(hibernateBundle.getSessionFactory());
    }

    @Provides
    public OrganisatieDAO organisatieDAO() {
        return new OrganisatieDAO(hibernateBundle.getSessionFactory());
    }

    @Provides
    public PersoonDAO persoonDAO() {
        return new PersoonDAO(hibernateBundle.getSessionFactory());
    }

    @Provides
    public TariefDAO tariefDAO() {
        return new TariefDAO(hibernateBundle.getSessionFactory());
    }

    @Provides
    public TheaterDAO theaterDAO() {
        return new TheaterDAO(hibernateBundle.getSessionFactory());
    }

    @Provides
    public ToegangsbewijsDAO toegangsbewijsDAO() {
        return new ToegangsbewijsDAO(hibernateBundle.getSessionFactory());
    }

    @Provides
    public ZaalDAO zaalDAO() {
        return new ZaalDAO(hibernateBundle.getSessionFactory());
    }

    @Provides
    public GekochtDAO gekochtDAO() {
        return new GekochtDAO(hibernateBundle.getSessionFactory());
    }

    @Override
    protected void configure() {
    }
}
