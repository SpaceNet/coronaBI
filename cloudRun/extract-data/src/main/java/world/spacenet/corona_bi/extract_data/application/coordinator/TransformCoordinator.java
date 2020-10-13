package world.spacenet.corona_bi.extract_data.application.coordinator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Body;

import world.spacenet.corona_bi.extract_data.application.service.TransformService;

@ApplicationScoped
public class TransformCoordinator {

    @Inject TransformService transformService;

	public Response separateData(Body gcsNotification) {
        try {
            return transformService.separateData(gcsNotification);
        } catch (Exception exception) {
            exception.printStackTrace();
            return Response.ok(exception.getMessage()).type(MediaType.TEXT_PLAIN_TYPE).build();
        }

	}

}
