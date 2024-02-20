package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import java.io.IOException;
public class MorpionControler implements Initializable {

	ConfigFileLoader configLoader = new ConfigFileLoader();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		


	}

	@FXML
	private MenuItem lireFichier;
	@FXML
	private Menu IA;

	@FXML
	void lireFile(ActionEvent event) throws IOException {
		configLoader.loadConfigFile("config.txt");
		System.out.println("Fichier Lu avec succes");
		Parent root = FXMLLoader.load(getClass().getResource("ChoixDifficulteXML.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
		primaryStage.setTitle("JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}

}
