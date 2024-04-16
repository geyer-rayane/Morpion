package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class ChoixDifficulteIa implements Initializable {

	@FXML
	private Menu IA;

	@FXML
	private Button retourVersChoixModeJeu;

	@FXML
	private Button jeuFacile;
	@FXML
	private Button jeuMoyen;
	@FXML
	private Button jeuDifficile;

	public static String[] readConfig(char character) throws IOException {
		String[] values = new String[3];
		BufferedReader reader;

		reader = new BufferedReader(new FileReader(
				"/home/nas-wks01/users/uapv2200060/eclipse-workspace/MorpionProjet/src/application/config.txt"));
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.startsWith(Character.toString(character) + ":")) {
				String[] parts = line.split(":");
				if (parts.length == 4 && parts[0].charAt(0) == character) {
					values[0] = parts[1];
					values[1] = parts[2];
					values[2] = parts[3];
					break;
				}
			}
		}
		reader.close();

		return values;
	}

	@FXML
	void retourVersAccueil(ActionEvent event) {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	@FXML
	void playFacile(ActionEvent event) throws IOException {
		String[] configList = readConfig('F');
		// Convertir les valeurs de la liste en types appropriés si nécessaire
		int h = Integer.parseInt(configList[1]);
		double lr = Double.parseDouble(configList[2]);
		int l = Integer.parseInt(configList[0]);

		// Récupération de la scène actuelle
		Scene currentScene = ((Node) event.getSource()).getScene();

		// Création de l'instance de Learn.fxml
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Learn.fxml"));
		Parent root = loader.load();

		// Appel de la fonction play de Learn.fxml avec les valeurs récupérées
		Learn learnController = loader.getController();
		learnController.play(h, lr, l);

		// Redirection vers la scène Learn.fxml
		currentScene.setRoot(root);
	}

	@FXML
	void playMoyen(ActionEvent event) throws IOException {
		String[] configList = readConfig('M');
		// Convertir les valeurs de la liste en types appropriés si nécessaire
		int h = Integer.parseInt(configList[1]);
		double lr = Double.parseDouble(configList[2]);
		int l = Integer.parseInt(configList[0]);

		// Récupération de la scène actuelle
		Scene currentScene = ((Node) event.getSource()).getScene();

		// Création de l'instance de Learn.fxml
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Learn.fxml"));
		Parent root = loader.load();

		// Appel de la fonction play de Learn.fxml avec les valeurs récupérées
		Learn learnController = loader.getController();
		learnController.play(h, lr, l);

		// Redirection vers la scène Learn.fxml
		currentScene.setRoot(root);
	}

	@FXML
	void playDifficile(ActionEvent event) throws IOException {
		String[] configList = readConfig('D');
		// Convertir les valeurs de la liste en types appropriés si nécessaire
		int h = Integer.parseInt(configList[1]);
		double lr = Double.parseDouble(configList[2]);
		int l = Integer.parseInt(configList[0]);

		// Récupération de la scène actuelle
		Scene currentScene = ((Node) event.getSource()).getScene();

		// Création de l'instance de Learn.fxml
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Learn.fxml"));
		Parent root = loader.load();

		// Appel de la fonction play de Learn.fxml avec les valeurs récupérées
		Learn learnController = loader.getController();
		learnController.play(h, lr, l);

		// Redirection vers la scène Learn.fxml
		currentScene.setRoot(root);
	}

	@FXML
	void retourVersChoixModeJeu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
		Scene currentScene = ((Node) event.getSource()).getScene();
		currentScene.setRoot(root);
	}
}
