package dad.javafx.geofx.root;

import java.io.IOException;

import dad.javafx.geofx.client.GeoFXservice;
import dad.javafx.geofx.client.GeoFXserviceException;
import dad.javafx.geofx.client.LocationMessage;
import dad.javafx.geofx.location.LocationController;
import dad.javafx.geofx.location.LocationModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RootController {
	
	//VIEW
	@FXML
	VBox contenedorBox;
		@FXML
		HBox busquedaBox;
			@FXML
			ImageView wifiImage;
			@FXML
			TextField ipText;
			@FXML
			Button checkButton;
		@FXML
		TabPane pestañas;
		
	//CONTROLLERS
	LocationController location;
	LocationModel model;
	
	LocationMessage devuelto;
	
	GeoFXservice service = new GeoFXservice();
	
	String ip = "";

	public RootController() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ContenedorView.fxml"));
		loader.setController(this);
		loader.load();
		
		try {
			this.ip = service.ip();
		} catch (GeoFXserviceException e1) {
			e1.printStackTrace();
		}
		
		ipText.setText(ip);
		
		location = new LocationController(ipText.getText());
		model = location.getModel();
		
		setTabs();
		
		wifiImage.setImage(new Image(getClass().getResource("/imagenes/Wifi-icon.png").toString()));
		onCheckAction();
		
		//ACTIONS
		checkButton.setOnAction(e -> onCheckAction());
		
	}
	
	private void onCheckAction() {
		
		//TODO
		//POR ALGUNA EXTRAÑA RAZÓN NO VA
		model.setIp(ipText.getText());
		
		location.newDevuelto();
		devuelto = location.getMessage();
		
		model.setLatitude(devuelto.getLatitude().toString());
		model.setLongitude(devuelto.getLongitude().toString());
		model.setCountryName(devuelto.getCountry_name());
		model.setCity(devuelto.getCity());
		model.setZip(devuelto.getZip());
		model.setIdioma(devuelto.getLocation().getLanguages()[0].getNativE());
		
		model.setCallingCode(devuelto.getLocation().getCalling_code());
		
		location.setImage(devuelto.getCountry_code());
	}

	public VBox getRoot() {
		return this.contenedorBox;
	}
	
	public void setTabs() {
		Tab locationTab = new Tab("LOCATION");
		locationTab.setContent(location.getRoot());
		pestañas.getTabs().add(locationTab);
	}

}
