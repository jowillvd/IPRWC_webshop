/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hsleiden;

import com.github.arteam.jdbi3.JdbiFactory;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import io.dropwizard.setup.Environment;
import nl.hsleiden.persistence.FilmDAO;
import nl.hsleiden.persistence.GebruikerDAO;
import nl.hsleiden.persistence.PersoonDAO;
import org.jdbi.v3.core.Jdbi;

/**
 *
 * @author Jordy van Dijk
 */
public class ApiGuiceModule extends AbstractModule {

    private Jdbi jdbi;

    @Provides
    public Jdbi prepareJdbi(Environment environment,
                           ApiConfiguration configuration) throws ClassNotFoundException {
        // setup DB access including DAOs
        // implementing a singleton pattern here but avoiding
        // Guice to initialize DB connection too early
        if (jdbi == null) {
            final JdbiFactory factory = new JdbiFactory();
            jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        }
        return jdbi;
    }

    @Provides
    public GebruikerDAO gebruikerDAO(Jdbi jdbi) {
        return jdbi.onDemand(GebruikerDAO.class);
    }

    @Provides
    public PersoonDAO persoonDAO(Jdbi jdbi) {
        return jdbi.onDemand(PersoonDAO.class);
    }

    @Provides
    public FilmDAO filmDAO(Jdbi jdbi) {
        return jdbi.onDemand(FilmDAO.class);
    }

    @Override
    protected void configure() {
//        bind(DataSourceLocator.class).to(DefaultDataSourceLocator.class).in(Scopes.SINGLETON);
//        bind(DBI.class).toProvider(DBIProvider.class).in(Scopes.SINGLETON);
//
//        bindDao(binder(), BranchDao.class);
//        bindDao(binder(), ModuleDao.class);
//        bindDao(binder(), StateDao.class);
//        bindDao(binder(), RepositoryBuildDao.class);
//        bindDao(binder(), ModuleBuildDao.class);
//        bindDao(binder(), DependenciesDao.class);
//        bindDao(binder(), MalformedFileDao.class);
//        bindDao(binder(), InstantMessageConfigurationDao.class);
//        bindDao(binder(), InterProjectBuildDao.class);
//        bindDao(binder(), InterProjectBuildMappingDao.class);
//        bindDao(binder(), BranchSettingsDao.class);
//        bindDao(binder(), MetricsDao.class);
//        bindDao(binder(), QueueItemDao.class);
    }
}
