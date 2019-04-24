package se.joel.coredev.backend.resource;

//import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.stereotype.Component;
import se.joel.coredev.backend.repository.data.User;
import se.joel.coredev.backend.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Path("users")
@Component
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
@Consumes(MediaType.APPLICATION_JSON)
public final class UserResource {

    private final UserService userService;
    @Context
    private UriInfo uriInfo;
    @Context
    private HttpServletResponse servletResponse;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @POST
    //@PreAuthorize("hasAuthority('ADMIN')")
    public Response postUser(User user) throws NoSuchAlgorithmException {
        return Response.created(locationOf(userService.addUser(user))).build();
    }

    @GET
    public Response loginTest(User user) {
        allowCrossDomainAccess();
        getCurrentIP();
        if(userService.login(user).isPresent()){
            return Response.ok("Logged in!").build();
        }
        return Response.ok("Wrong password").build();
    }

    private URI locationOf(User user) {
        return uriInfo.getBaseUriBuilder().path(uriInfo.getPathSegments().get(0).toString())
                .segment(user.getId().toString()).build();
    }

    private void allowCrossDomainAccess() {
        if (servletResponse != null) {
            servletResponse.setHeader("Access-Control-Allow-Origin", "*");
        }
    }

    private void getCurrentIP() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Could not obtain current IP address");
        }
    }
}
