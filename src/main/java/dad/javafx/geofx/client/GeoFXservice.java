package dad.javafx.geofx.client;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class GeoFXservice {

	public GeoFXservice() {
		Unirest.setObjectMapper(new UnirestObjectMapper());
	}

	public LocationMessage consulta(String ip) throws GeoFXserviceException {

		try {
			LocationMessage location = Unirest
					.get("http://api.ipapi.com/api/" + ip + "?access_key=3e52ccd1f7209b03be90f741830f0609")
					.asObject(LocationMessage.class).getBody();

			return location;

		} catch (UnirestException e) {
			throw new GeoFXserviceException(e);
		}

	}

	public String ip() throws GeoFXserviceException {

		try {
			LocationMessage location = Unirest
					.get("http://api.ipapi.com/api/check?access_key=3e52ccd1f7209b03be90f741830f0609")
					.asObject(LocationMessage.class).getBody();

			return location.getIp();

		} catch (UnirestException e) {
			throw new GeoFXserviceException(e);
		}

	}

}
