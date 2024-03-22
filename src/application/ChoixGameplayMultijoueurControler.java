package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChoixGameplayMultijoueurControler {

    @FXML
    private Button retourVersChoixModeJeu;

    @FXML
    private TextField pseudoJoueur2;

    @FXML
    private TextField pseudoJoueur1;

	@FXML
	void retourVersChoixModeJeu(ActionEvent event) throws IOException {
	    Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
	    Scene currentScene = ((Node) event.getSource()).getScene();
	    currentScene.setRoot(root);
	}
}
