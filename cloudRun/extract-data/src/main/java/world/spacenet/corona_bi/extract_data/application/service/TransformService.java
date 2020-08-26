package world.spacenet.corona_bi.extract_data.application.service;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Body;

@ApplicationScoped
public class TransformService {

	public Response separateData(Body gcsNotification) {
		return null;
	}

}
