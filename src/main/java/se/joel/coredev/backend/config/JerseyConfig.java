package se.joel.coredev.backend.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import se.joel.coredev.backend.exception.exceptionMapper.BadInputMapper;
import se.joel.coredev.backend.exception.exceptionMapper.NotFoundMapper;
import se.joel.coredev.backend.repository.data.User;
import se.joel.coredev.backend.resource.UserResource;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(User.class);
        register(UserResource.class);
        register(NotFoundMapper.class);
        register(BadInputMapper.class);
    }
}
