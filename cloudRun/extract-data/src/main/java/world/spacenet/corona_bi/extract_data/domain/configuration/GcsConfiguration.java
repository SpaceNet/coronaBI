package world.spacenet.corona_bi.extract_data.domain.configuration;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix = "gcs")
public interface GcsConfiguration {

    @ConfigProperty(name="blobname") String blobname();
    @ConfigProperty(name="bucketname") String bucketname();

}
