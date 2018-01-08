package nl.hsleiden;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.bundles.assets.AssetsBundleConfiguration;
import io.dropwizard.bundles.assets.AssetsConfiguration;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Jordy van Dijk
 */
public class ApiConfiguration extends Configuration implements AssetsBundleConfiguration
{
    @NotEmpty
    @JsonProperty
    private String apiName;

    @Valid
    @NotNull
    @JsonProperty
    private final AssetsConfiguration assets = new AssetsConfiguration();

    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
    
    public String getApiName()
    {
        return apiName;
    }

    public void setApiName(String apiName)
    {
        this.apiName = apiName;
    }

    @Override
    public AssetsConfiguration getAssetsConfiguration()
    {
        return assets;
    }
}
