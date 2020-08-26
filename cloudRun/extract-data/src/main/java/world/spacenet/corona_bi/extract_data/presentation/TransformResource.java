package world.spacenet.corona_bi.extract_data.presentation;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Body;

import world.spacenet.corona_bi.extract_data.application.coordinator.TransformCoordinator;

@Path("/transform")
public class TransformResource {

    @Inject TransformCoordinator transformCoordinator;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/coronabi/gcsnotification")
    public Response transform(Body gcsNotification) {

        return transformCoordinator.separateData(gcsNotification);

    }
}