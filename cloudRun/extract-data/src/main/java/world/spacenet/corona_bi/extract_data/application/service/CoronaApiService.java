package world.spacenet.corona_bi.extract_data.application.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import world.spacenet.corona_bi.extract_data.domain.JagJapanJsonData;
import world.spacenet.corona_bi.extract_data.infrastructure.api.CoronaAPIClient;

@ApplicationScoped
public class CoronaApiService {

  private final Logger log = LoggerFactory.getLogger(CoronaApiService.class);

  @Inject @RestClient CoronaAPIClient client;

    public String getJagjapanData() {

      log.info("extractData");
      String geoStringData = client.getGeoJSon("通し>-1", "false", "false", "pgeojson", "*", "通し");

      Gson gson = new GsonBuilder().setPrettyPrinting().create();

      JagJapanJsonData convertedObject = gson.fromJson(geoStringData, JagJapanJsonData.class);
      log.info(convertedObject.type);

      String jsonString = gson.toJson(convertedObject);
      log.info(jsonString.substring(0,10000));

  		return jsonString;
	}

}
