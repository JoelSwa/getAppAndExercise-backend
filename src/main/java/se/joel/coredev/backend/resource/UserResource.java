package se.joel.coredev.backend.resource;

import org.springframework.stereotype.Component;
import se.joel.coredev.backend.repository.model.User;
import se.joel.coredev.backend.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.security.NoSuchAlgorithmException;


@Path("users")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public final class UserResource {

    private final UserService userService;
    @Context
    private UriInfo uriInfo;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @POST
    public Response postUser(User user) throws NoSuchAlgorithmException {
        return Response.created(locationOf(userService.addUser(user))).build();
    }

    @POST
    @Path("/login")
    public Response login(User user) {
        return Response.accepted(userService.login(user)).build();
    }

    private URI locationOf(User user) {
        return uriInfo.getBaseUriBuilder().path(uriInfo.getPathSegments().get(0).toString())
                .segment(user.getId().toString()).build();
    }
}
