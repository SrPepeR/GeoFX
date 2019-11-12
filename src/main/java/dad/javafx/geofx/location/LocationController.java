package dad.javafx.geofx.location;

import java.io.IOException;

import dad.javafx.geofx.client.GeoFXservice;
import dad.javafx.geofx.client.GeoFXserviceException;
import dad.javafx.geofx.client.LocationMessage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class LocationController {
	
	LocationModel model = new LocationModel();
	
	@FXML
	GridPane contenedor;
		@FXML
		Label latitudLabel;
		@FXML
		Label longitudLabel;
			@FXML
			ImageView banderaImage;
			@FXML
			Label paisLabel;
		@FXML
		Label postalLabel;
		@FXML
		Label idiomaLabel;
		@FXML
		Label ciudadLabel;
		@FXML
		Label zHorariaLabel;
		@FXML
		Label prefijoLabel;
		@FXML
		Label monedaLabel;
	
	GeoFXservice service;
	LocationMessage devuelto;
	
	
	public LocationController(String ip) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/LocationView.fxml"));
		loader.setController(this);
		loader.load();
		
		service = new GeoFXservice();
		
		model.setIp(ip);
		
//		newDevuelto();
		
		//BINDEOS
		
		latitudLabel.textProperty().bind(model.latitudeProperty());
		longitudLabel.textProperty().bind(model.longitudeProperty());
		postalLabel.textProperty().bind(model.zipProperty());
		idiomaLabel.textProperty().bind(model.idiomaProperty());
		prefijoLabel.textProperty().bind(model.callingCodeProperty());
		paisLabel.textProperty().bind(model.countryNameProperty());
		ciudadLabel.textProperty().bind(model.cityProperty());
		
	}
	
	public void newDevuelto() {
		try {
			this.devuelto = service.consulta(model.getIp());
		} catch (GeoFXserviceException e) {
			e.printStackTrace();
		}
	}
	
	public LocationModel getModel() {
		return this.model;
	}
	
	public GridPane getRoot() {
		return this.contenedor;
	}
	
	public LocationMessage getMessage() {
		return this.devuelto;
	}
	
	public void setImage(String countryCode) {
		banderaImage.setImage(new Image(getClass().getResource("/imagenes/banderas/96x64/"+ countryCode + ".png").toString()));
	}

}
