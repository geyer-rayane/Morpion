package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;

public class MorpionControler implements Initializable {

	ConfigFileLoader configLoader = new ConfigFileLoader();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	@FXML
	private Menu IA;

	@FXML
	void lireFile(ActionEvent event) {
		configLoader.loadConfigFile("config.txt");
	}

}
