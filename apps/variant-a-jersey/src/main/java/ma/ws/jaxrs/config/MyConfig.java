package ma.ws.jaxrs.config;

import ma.ws.jaxrs.controllers.CompteRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public ResourceConfig jerseyConfig() {
        ResourceConfig config = new ResourceConfig();
        // Ressource REST
        config.register(CompteRestJaxRSAPI.class);

        // Modules JSON & XML pour Jersey
        config.packages("org.glassfish.jersey.jackson");
        config.packages("org.glassfish.jersey.jaxb");

        return config;
    }
}
