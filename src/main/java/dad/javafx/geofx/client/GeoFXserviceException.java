package dad.javafx.geofx.client;

@SuppressWarnings("serial")
public class GeoFXserviceException extends Exception {

	public GeoFXserviceException() {
	}

	public GeoFXserviceException(String message) {
		super(message);
	}

	public GeoFXserviceException(Throwable cause) {
		super(cause);
	}

	public GeoFXserviceException(String message, Throwable cause) {
		super(message, cause);
	}

	public GeoFXserviceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
