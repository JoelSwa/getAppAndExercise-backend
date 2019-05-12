package se.joel.coredev.backend.resource;

import org.springframework.stereotype.Component;
import se.joel.coredev.backend.repository.dto.GeofenceDTO;
import se.joel.coredev.backend.repository.dto.UserDTO;
import se.joel.coredev.backend.repository.dto.WalkDTO;
import se.joel.coredev.backend.repository.model.Geofence;
import se.joel.coredev.backend.service.GeofenceService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("geofences")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public final class GeofenceResource {

    private final GeofenceService geofenceService;
    @Context
    private UriInfo uriInfo;

    public GeofenceResource(GeofenceService geofenceService){
        this.geofenceService = geofenceService;
    }

    @POST
    public Response addGeofence(GeofenceDTO geofenceDTO){
        return Response.created(locationOf(geofenceService.addGeofence(geofenceDTO))).build();
    }

    @POST
    @Path("test")
    public Response addGeofenceTest(GeofenceDTO geofenceDTO){
        System.out.println(geofenceDTO.getUsername());
        return Response.ok().build();
    }

    @POST
    @Path("all")
    public Response getGeofencesForUser(UserDTO userDTO){
        return Response.ok(geofenceService.getGeofencesForUser(userDTO)).build();
    }

    @POST
    @Path("walk")
    public Response getGeofencesForWalk(WalkDTO walkDTO){
        return Response.ok(geofenceService.getGeofencesForWalk(walkDTO)).build();
    }

    private URI locationOf(Geofence geofence) {
        return uriInfo.getBaseUriBuilder().path(uriInfo.getPathSegments().get(0).toString())
                .segment(geofence.getId().toString()).build();
    }
}
