package world.spacenet.corona_bi.extract_data.presentation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import world.spacenet.corona_bi.extract_data.application.coordinator.ExtractCoordinator;

@Path("/extract")
public class ExtractResource {

    @Inject ExtractCoordinator extractCoordinator;

    @GET
    public Response extract() {

        return extractCoordinator.extractData();

    }
}