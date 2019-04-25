package se.joel.coredev.backend.exception.exceptionMapper;

import se.joel.coredev.backend.exception.NotFoundException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Provider
public final class NotFoundMapper implements ExceptionMapper<NotFoundException> {

    @Context
    private HttpServletResponse servletResponse;

    @Override
    public Response toResponse(NotFoundException e) {
        return Response.status(NOT_FOUND).entity(e.getMessage()).build();
    }
}
