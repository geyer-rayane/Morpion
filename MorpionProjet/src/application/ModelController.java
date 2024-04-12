package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ModelController implements Initializable {

	@FXML
	private ListView<String> modelList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Spécifiez le chemin du dossier contenant les fichiers
		String folderPath = "/home/nas-wks01/users/uapv2200060/eclipse-workspace/MorpionProjet/model";
		loadFilesNames(folderPath);

		// Configurer la cellule personnalisée pour la liste
		modelList.setCellFactory(param -> new FileListCell());
	}

	private void loadFilesNames(String folderPath) {
		File folder = new File(folderPath);
		File[] files = folder.listFiles();
		if (files != null) {
			ObservableList<String> fileNames = FXCollections.observableArrayList();
			for (File file : files) {
				if (file.isFile()) {
					// Ajouter le nom du fichier à la liste
					fileNames.add(file.getName());
				}
			}
			// Charger la liste des noms de fichiers dans le ListView
			modelList.setItems(fileNames);
		}
	}
}
