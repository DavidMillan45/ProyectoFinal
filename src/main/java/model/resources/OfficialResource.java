package model.resources;

import co.edu.unbosque.model.resources.filters.Logged;
import co.edu.unbosque.model.resources.pojos.OfficialPojo;
import co.edu.unbosque.model.services.OfficialService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/vets")
public class OfficialResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(OfficialPojo official) {

        Optional<OfficialPojo> persistedOfficial = new OfficialService().saveOfficial(official);

        if (persistedOfficial.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedOfficial.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("Owner user could not be created")
                    .build();
        }

    }

    @Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("role") String role) {

        // If role doesn't match
        if (!"vet".equals(role))
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();

        return Response.ok()
                .entity("Hello, World, " + role + "!")
                .build();

    }

}
