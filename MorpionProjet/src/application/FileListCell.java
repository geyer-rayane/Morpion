package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import java.io.File;

public class FileListCell extends ListCell<String> {

	private HBox content;
	private Button deleteButton;

	public FileListCell() {
		super();

		content = new HBox();
		content.setAlignment(Pos.CENTER_LEFT);

		deleteButton = new Button("Supprimer");
		deleteButton.setOnAction(event -> {
			// Action à effectuer lorsque le bouton est cliqué
			String fileName = "/home/nas-wks01/users/uapv2200060/eclipse-workspace/MorpionProjet/model/" + getItem(); // Obtenir
																														// le
																														// nom
																														// du
																														// fichier
																														// de
																														// cette
																														// cellule
			File fileToDelete = new File(fileName); // Créer un objet File avec le nom du fichier
			if (fileToDelete.exists()) { // Vérifier si le fichier existe
				if (fileToDelete.delete()) { // Supprimer le fichier
					System.out.println("Fichier supprimé avec succès: " + fileName);
					getListView().getItems().remove(getItem());
				} else {
					System.out.println("Impossible de supprimer le fichier: " + fileName);
				}
			}
		});

		content.getChildren().add(deleteButton);
	}

	@Override
	protected void updateItem(String item, boolean empty) {
		super.updateItem(item, empty);

		if (empty || item == null) {
			setText(null);
			setGraphic(null);
		} else {
			setText(item);
			setGraphic(content);
		}
	}
}
