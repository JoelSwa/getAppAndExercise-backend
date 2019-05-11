package se.joel.coredev.backend.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import se.joel.coredev.backend.exception.exceptionMapper.BadInputMapper;
import se.joel.coredev.backend.exception.exceptionMapper.NotFoundMapper;
import se.joel.coredev.backend.repository.dto.GeofenceDTO;
import se.joel.coredev.backend.repository.model.Geofence;
import se.joel.coredev.backend.repository.model.User;
import se.joel.coredev.backend.repository.model.Walk;
import se.joel.coredev.backend.resource.GeofenceResource;
import se.joel.coredev.backend.resource.UserResource;
import se.joel.coredev.backend.resource.WalkResource;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(User.class);
        register(Geofence.class);
        register(GeofenceDTO.class);
        register(Walk.class);
        register(WalkResource.class);
        register(UserResource.class);
        register(GeofenceResource.class);
        register(NotFoundMapper.class);
        register(BadInputMapper.class);
    }
}
