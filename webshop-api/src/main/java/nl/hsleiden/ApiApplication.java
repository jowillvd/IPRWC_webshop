
package nl.hsleiden;

import com.google.inject.Module;
import com.hubspot.dropwizard.guice.GuiceBundle.Builder;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.UnitOfWorkAwareProxyFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.util.EnumSet;
import javax.servlet.DispatcherType;

import nl.hsleiden.model.*;
import nl.hsleiden.persistence.GebruikerDAO;
import nl.hsleiden.service.AuthenticationService;
import org.eclipse.jetty.servlet.FilterHolder;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Peter van Vliet
 */
public class ApiApplication extends Application<ApiConfiguration>
{
    private final Logger logger = LoggerFactory.getLogger(ApiApplication.class);

    private final HibernateBundle<ApiConfiguration> hibernateBundle = new HibernateBundle<ApiConfiguration>(
            Film.class,
            Filmgenre.class,
            Filmticket.class,
            Filmtype.class,
            Filmvertoning.class,
            Gebruiker.class,
            Genre.class,
            Organisatie.class,
            Persoon.class,
            Tarief.class,
            Theater.class,
            Toegangsbewijs.class,
            Zaal.class,
            Gekocht.class
    ) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(ApiConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };
    
    private ConfiguredBundle assetsBundle;
    private GuiceBundle guiceBundle;
    
    private String name;
    
    @Override
    public String getName()
    {
        return name;
    }
    
    @Override
    public void initialize(Bootstrap<ApiConfiguration> bootstrap)
    {
        assetsBundle = (ConfiguredBundle) new ConfiguredAssetsBundle("/assets/", "/client", "index.html");
        guiceBundle = createGuiceBundle(ApiConfiguration.class, new ApiGuiceModule(hibernateBundle));
        
        bootstrap.addBundle(assetsBundle);
        bootstrap.addBundle(guiceBundle);
        bootstrap.addBundle(hibernateBundle);
    }
    
    @Override
    public void run(ApiConfiguration configuration, Environment environment) throws Exception
    {
        name = configuration.getApiName();
        
        logger.info(String.format("Set API name to %s", name));

        setupAuthentication(environment);
        configureClientFilter(environment);
    }
    
    private GuiceBundle createGuiceBundle(Class<ApiConfiguration> configurationClass, Module module)
    {
        Builder guiceBuilder = GuiceBundle.<ApiConfiguration>newBuilder()
                .addModule(module)
                .enableAutoConfig(new String[] { "nl.hsleiden" })
                .setConfigClass(configurationClass);

        return guiceBuilder.build();
    }
    
    private void setupAuthentication(Environment environment)
    {

        AuthenticationService authenticationService = new UnitOfWorkAwareProxyFactory(hibernateBundle)
                .create(AuthenticationService.class, GebruikerDAO.class, new GebruikerDAO(hibernateBundle.getSessionFactory()));
        //AuthenticationService authenticationService = guiceBundle.getInjector().getInstance(AuthenticationService.class);
        ApiUnauthorizedHandler unauthorizedHandler = guiceBundle.getInjector().getInstance(ApiUnauthorizedHandler.class);
        
        environment.jersey().register(new AuthDynamicFeature(
            new BasicCredentialAuthFilter.Builder<Gebruiker>()
                .setAuthenticator(authenticationService)
                .setAuthorizer(authenticationService)
                .setRealm("SUPER SECRET STUFF")
                .setUnauthorizedHandler(unauthorizedHandler)
                .buildAuthFilter())
        );
        
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(Gebruiker.class));
    }
    
    private void configureClientFilter(Environment environment)
    {
        environment.getApplicationContext().addFilter(
            new FilterHolder(new ClientFilter()),
            "/*",
            EnumSet.allOf(DispatcherType.class)
        );
    }
    
    public static void main(String[] args) throws Exception
    {
        new ApiApplication().run(args);
    }
}
