package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConfigurationDifficulteControler implements Initializable{

	@FXML
	private TextField f1;

	@FXML
	private TextField f3;

	@FXML
	private TextField f2;

	@FXML
	private TextField m1;

	@FXML
	private TextField m3;

	@FXML
	private TextField m2;

	@FXML
	private TextField d1;

	@FXML
	private TextField d3;

	@FXML
	private TextField d2;

	@FXML
	private Button ButtonValider;

	private static final String CONFIG_FILE_PATH = "/home/nas-wks01/users/uapv2200060/eclipse-workspace/MorpionProjet/src/application/config.txt";

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	    try (BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE_PATH))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(":");
	            if (parts.length >= 4) {
	                String type = parts[0];
	                switch (type) {
	                    case "F":
	                        f1.setText(parts[1]);
	                        f2.setText(parts[2]);
	                        f3.setText(parts[3]);
	                        break;
	                    case "M":
	                        m1.setText(parts[1]);
	                        m2.setText(parts[2]);
	                        m3.setText(parts[3]);
	                        break;
	                    case "D":
	                        d1.setText(parts[1]);
	                        d2.setText(parts[2]);
	                        d3.setText(parts[3]);
	                        break;
	                    default:
	                        System.out.println("Catégorie non reconnue : " + type);
	                        break;
	                }
	            }
	        }
	    } catch (IOException e) {
	        System.err.println("Erreur lors de la lecture du fichier config.txt: " + e.getMessage());
	        e.printStackTrace();
	    }
	}




	@FXML
	void modifierFichier(ActionEvent event) {
		if (event.getSource() instanceof Button) {
			System.out.println("Le bouton Valider a été cliqué.");

			// Obtenir le texte de chaque champ de texte
			String newValueF1 = f1.getText();
			String newValueF2 = f2.getText();
			String newValueF3 = f3.getText();
			String newValueM1 = m1.getText();
			String newValueM2 = m2.getText();
			String newValueM3 = m3.getText();
			String newValueD1 = d1.getText();
			String newValueD2 = d2.getText();
			String newValueD3 = d3.getText();

			// Écrire le contenu des champs de texte dans le fichier config.txt
			try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File(CONFIG_FILE_PATH)))) {
				// Écrire le contenu dans le fichier
				writer.println("F:" + newValueF1 + ":" + newValueF2 + ":" + newValueF3);
				writer.println("M:" + newValueM1 + ":" + newValueM2 + ":" + newValueM3);
				writer.println("D:" + newValueD1 + ":" + newValueD2 + ":" + newValueD3);

				System.out.println("Les valeurs des champs ont été écrites dans le fichier config.txt avec succès.");
			} catch (IOException e) {
				System.err.println("Erreur lors de l'écriture des valeurs des champs dans le fichier config.txt: "
						+ e.getMessage());
				e.printStackTrace();
			}
		}
	}

}
