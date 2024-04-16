package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class AccueilControler implements Initializable {

	ConfigFileLoader configLoader = new ConfigFileLoader();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ImageView robotView= new ImageView(robot);
		robotView.setFitHeight(40);
		robotView.setFitWidth(40);
		jeuVsIa.setGraphic(robotView);
		
		ImageView multiView= new ImageView(multi);
		multiView.setFitHeight(40);
		multiView.setFitWidth(40);
		jeuEnMulti.setGraphic(multiView);
	}

	@FXML
	private Menu IA;
    
	@FXML
    private MenuItem Model;
    
	@FXML
    private ListView<String> listView;
	@FXML
	private MenuItem lireFichier;

	@FXML
	private Button jeuVsIa;

	@FXML
	private Button jeuEnMulti;
	
	@FXML
	private Button retourVersAccueil ;
	
	
	
	Image robot = new Image("file:///home/nas-wks01/users/uapv2200060/eclipse-workspace/MorpionProjet/img/robot.png");
	Image multi = new Image("file:///home/nas-wks01/users/uapv2200060/eclipse-workspace/MorpionProjet/img/multijoueur.png");

	@FXML
	void lireFile(ActionEvent event) throws IOException {
	
		configLoader.loadConfigFile("config.txt");
		System.out.println("Fichier Lu avec succes");
		Parent root = FXMLLoader.load(getClass().getResource("ConfigurationDifficulte.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("JavaFX App");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	void jouerContreIa(ActionEvent event) throws IOException {
	    Parent root = FXMLLoader.load(getClass().getResource("ChoixDifficulteIa.fxml"));
	    Scene currentScene = ((Node) event.getSource()).getScene();
	    currentScene.setRoot(root);
	}
	
	
	@FXML
	void jeuEnMulti(ActionEvent event) throws IOException {
	    Parent root = FXMLLoader.load(getClass().getResource("ChoixGameplayMultijoueur.fxml"));
	    Scene currentScene = ((Node) event.getSource()).getScene();
	    currentScene.setRoot(root);
	}

	
	   @FXML
	   public void voirModels() throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("Models.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("JavaFX App");
			primaryStage.setScene(scene);
			primaryStage.show();
	    }
	


}
