package se.joel.coredev.backend.resource;

import org.springframework.stereotype.Component;
import se.joel.coredev.backend.repository.dto.UserDTO;
import se.joel.coredev.backend.repository.dto.WalkDTO;
import se.joel.coredev.backend.repository.model.Walk;
import se.joel.coredev.backend.service.WalkService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("walks")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public final class WalkResource {

    private final WalkService walkService;
    @Context
    private UriInfo uriInfo;

    public WalkResource(WalkService walkService){
        this.walkService = walkService;
    }

    @POST
    public Response addWalk(WalkDTO walkDTO){
        return Response.created(locationOf(walkService.addWalk(walkDTO))).build();
    }

    @POST
    @Path("all")
    public Response getAllWalksForUser(UserDTO userDTO){
        return Response.ok(walkService.getWalksForUser(userDTO)).build();
    }

    @PUT
    public Response updateWalk(WalkDTO walkDTO){
        return Response.ok(walkService.updateWalk(walkDTO)).build();
    }

    private URI locationOf(Walk walk) {
        return uriInfo.getBaseUriBuilder().path(uriInfo.getPathSegments().get(0).toString())
                .segment(walk.getId().toString()).build();
    }
}
