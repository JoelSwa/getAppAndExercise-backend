package se.joel.coredev.backend.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Cross-Origin Resource Sharing (CORS).
 *
 * Allows requests from other IP-addresses and ports, including
 * different ports on localhost that don't coincide with the port used
 * by the application.
 *
 * However, if the script(s) calling the Resource methods always share
 * the same origin and port as the application itself, this can be annulled.
 */
@Provider
public class CORSFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext request,
                       ContainerResponseContext response) throws IOException {
        response.getStringHeaders().add("Access-Control-Allow-Origin", "*");
        response.getStringHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        response.getStringHeaders().add("Access-Control-Allow-Credentials", "true");
        response.getStringHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        response.getStringHeaders().add("Access-Control-Max-Age", "1");
    }
}
