package se.joel.coredev.backend.exception.exceptionMapper;

import se.joel.coredev.backend.exception.BadInputException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Provider
public final class BadInputMapper implements ExceptionMapper<BadInputException> {

    @Context
    private HttpServletResponse servletResponse;

    @Override
    public Response toResponse(BadInputException e) {
        return Response.status(BAD_REQUEST).entity(e.getMessage()).build();
    }
}
