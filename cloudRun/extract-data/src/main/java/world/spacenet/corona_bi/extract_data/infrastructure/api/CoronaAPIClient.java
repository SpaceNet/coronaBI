package world.spacenet.corona_bi.extract_data.infrastructure.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey="jag-japan")
public interface CoronaAPIClient {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String getGeoJSon(@QueryParam("where") String where
                    ,@QueryParam("returnIdsOnly") String returnIdsOnly
                    ,@QueryParam("returnCountOnly") String returnCountOnly
                    ,@QueryParam("f") String f
                    ,@QueryParam("outFields") String outFields
                    ,@QueryParam("orderByFields") String orderByFields
                    );

}
