package dad.javafx.geofx.location;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LocationModel {
	
	StringProperty ip = new SimpleStringProperty();
	StringProperty countryName = new SimpleStringProperty();
	StringProperty countryCode = new SimpleStringProperty();
	StringProperty city = new SimpleStringProperty();
	StringProperty zip = new SimpleStringProperty();
	
	StringProperty latitude = new SimpleStringProperty();
	StringProperty longitude = new SimpleStringProperty();
	
	StringProperty idioma = new SimpleStringProperty();
	
	StringProperty callingCode = new SimpleStringProperty();

	
	public final StringProperty ipProperty() {
		return this.ip;
	}
	

	public final String getIp() {
		return this.ipProperty().get();
	}
	

	public final void setIp(final String ip) {
		this.ipProperty().set(ip);
	}
	

	public final StringProperty countryNameProperty() {
		return this.countryName;
	}
	

	public final String getCountryName() {
		return this.countryNameProperty().get();
	}
	

	public final void setCountryName(final String countryName) {
		this.countryNameProperty().set(countryName);
	}
	

	public final StringProperty countryCodeProperty() {
		return this.countryCode;
	}
	

	public final String getCountryCode() {
		return this.countryCodeProperty().get();
	}
	

	public final void setCountryCode(final String regionCode) {
		this.countryCodeProperty().set(regionCode);
	}
	

	public final StringProperty cityProperty() {
		return this.city;
	}
	

	public final String getCity() {
		return this.cityProperty().get();
	}
	

	public final void setCity(final String city) {
		this.cityProperty().set(city);
	}
	

	public final StringProperty zipProperty() {
		return this.zip;
	}
	

	public final String getZip() {
		return this.zipProperty().get();
	}
	

	public final void setZip(final String zip) {
		this.zipProperty().set(zip);
	}
	

	public final StringProperty latitudeProperty() {
		return this.latitude;
	}
	

	public final String getLatitude() {
		return this.latitudeProperty().get();
	}
	

	public final void setLatitude(final String latitude) {
		this.latitudeProperty().set(latitude);
	}
	

	public final StringProperty longitudeProperty() {
		return this.longitude;
	}
	

	public final String getLongitude() {
		return this.longitudeProperty().get();
	}
	

	public final void setLongitude(final String longitude) {
		this.longitudeProperty().set(longitude);
	}
	

	public final StringProperty idiomaProperty() {
		return this.idioma;
	}
	

	public final String getIdioma() {
		return this.idiomaProperty().get();
	}
	

	public final void setIdioma(final String idioma) {
		this.idiomaProperty().set(idioma);
	}
	
	public final StringProperty callingCodeProperty() {
		return this.callingCode;
	}
	
	public final String getCallingCode() {
		return this.callingCodeProperty().get();
	}
	
	public final void setCallingCode(final String callingCode) {
		this.callingCodeProperty().set(callingCode);
	}
	
}
