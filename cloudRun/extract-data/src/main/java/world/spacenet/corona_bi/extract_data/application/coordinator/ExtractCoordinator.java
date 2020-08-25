package world.spacenet.corona_bi.extract_data.application.coordinator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import world.spacenet.corona_bi.extract_data.application.service.CoronaApiService;
import world.spacenet.corona_bi.extract_data.application.service.GcsService;
import world.spacenet.corona_bi.extract_data.domain.configuration.GcsConfiguration;

@ApplicationScoped
public class ExtractCoordinator {

    @Inject CoronaApiService coronaApiService;
    @Inject GcsService gcsService;

    @Inject GcsConfiguration gcsConfig;

	public Response extractData() {

        String jagJapanJsonData = coronaApiService.getJagjapanData();
        gcsService.uploadBlob(jagJapanJsonData, gcsConfig.bucketname(), gcsConfig.blobname());

        return Response.ok(jagJapanJsonData.substring(0,10000)).build();
	}

}
