package se.joel.coredev.backend.resource;

import org.springframework.stereotype.Component;
import se.joel.coredev.backend.repository.model.Geofence;
import se.joel.coredev.backend.repository.model.User;
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
    @Path("{id}")
    public Response addGeofence(@PathParam("id") Long userId, Geofence geofence){
        return Response.created(locationOf(geofenceService.addGeofence(userId, geofence))).build();
    }

    private URI locationOf(Geofence geofence) {
        return uriInfo.getBaseUriBuilder().path(uriInfo.getPathSegments().get(0).toString())
                .segment(geofence.getId().toString()).build();
    }
}
