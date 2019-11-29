package dad.javafx.geofx.root;

import java.io.IOException;

import dad.javafx.geofx.client.GeoFXservice;
import dad.javafx.geofx.client.LocationMessage;
import dad.javafx.geofx.location.LocationController;
import dad.javafx.geofx.location.LocationModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
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
	Task<String> tarea;
	Task<LocationMessage> tarea2;
	
	StringProperty ip = new SimpleStringProperty();
	
	BooleanProperty devueltoProperty = new SimpleBooleanProperty();

	public RootController() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ContenedorView.fxml"));
		loader.setController(this);
		loader.load();
		
		ipText.textProperty().bindBidirectional(ip);
		
		iniciaTaskTarea();
		
		location = new LocationController(ipText.getText());
		model = location.getModel();
		
		setTabs();
		
		wifiImage.setImage(new Image(getClass().getResource("/imagenes/Wifi-icon.png").toString()));
		
		
		
		//ACTIONS
		checkButton.setOnAction(e -> onCheckAction());
		
	}
	
	private void iniciaTaskTarea() {
		tarea = new Task<String>() {
			
			@Override
			protected String call() throws Exception {
				String ip = service.ip();
				return ip;
			}
		};
		
		tarea.setOnSucceeded(e -> {
			ip.set((String)tarea.getValue());
			System.out.println("IP: " + ip.get());
			iniciaTaskTarea2();
		});
		
		new Thread(tarea).start();
	}
	
	private void iniciaTaskTarea2() {
		tarea2 = new Task<LocationMessage>() {
			
			@Override
			protected LocationMessage call() throws Exception {
				location.newDevuelto();
				LocationMessage message = location.getMessage();
				return message;
			}
		};
		
		tarea2.setOnSucceeded(e -> {
			devuelto = tarea2.getValue();
			onCheckAction();
		});
		
		new Thread(tarea2).start();
	}
	
	private void onCheckAction() {
		
		model.setIp(ip.get());
		
		if (devuelto == null) {
			return;
		}
		
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
