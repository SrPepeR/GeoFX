package dad.javafx.geofx;

import dad.javafx.geofx.root.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	RootController root;
	//TODO
	
	public void start(Stage primaryStage) throws Exception {
		
		root = new RootController();
		
		Scene scene = new Scene(root.getRoot());
		primaryStage.setTitle("GeoFX");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
