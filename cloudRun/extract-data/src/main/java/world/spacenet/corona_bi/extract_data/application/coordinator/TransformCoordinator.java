package world.spacenet.corona_bi.extract_data.application.coordinator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Body;

@ApplicationScoped
public class TransformCoordinator {

    @Inject TransformCoordinator transformCoordinator;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/coronabi/gcsnotification")
	public Response transformData(Body gcsNotification) {
        try {
            return transformCoordinator.retrieveOrder(gcsNotification);
        } catch (JAXBException jaxbException) {
            jaxbException.printStackTrace();
            return Response.ok(jaxbException.getMessage()).type(MediaType.TEXT_PLAIN_TYPE).build();
        } catch (IOException | InterruptedException pubsubException) {
            pubsubException.printStackTrace();
            return Response.ok(pubsubException.getMessage()).type(MediaType.TEXT_PLAIN_TYPE).build();
        } catch (ExecutionException executionException) {
            executionException.printStackTrace();
            return Response.ok(executionException.getMessage()).type(MediaType.TEXT_PLAIN_TYPE).build();
        } catch (Exception exception) {
            exception.printStackTrace();
            return Response.ok(exception.getMessage()).type(MediaType.TEXT_PLAIN_TYPE).build();
        }

	}

}
