package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.IOException;

import javafx.event.ActionEvent;

public class JeuMultijoueurControler {

	public JeuMultijoueurControler() {
	}
    @FXML
    private AnchorPane rootPane;
	@FXML
	private Button buttontest;

	@FXML
	private Button button00;

	@FXML
	private Button button01;

	@FXML
	private Button button02;

	@FXML
	private Button button10;

	@FXML
	private Button button11;

	@FXML
	private Button button12;

	@FXML
	private Button button20;

	@FXML
	private Button button21;

	@FXML
	private Button button22;

	@FXML
	private Text joueur1;

	@FXML
	private Text joueur2;

	@FXML
	private ImageView grilleId;

	private String pseudoJoueur1;
	private String pseudoJoueur2;

	Image croix = new Image("file:///home/nas-wks01/users/uapv2307467/eclipse-workspace/XO/img/croix.png");
	Image rond = new Image("file:///home/nas-wks01/users/uapv2307467/eclipse-workspace/XO/img/rond.png");
	Image grille = new Image("file:///home/nas-wks01/users/uapv2307467/eclipse-workspace/XO/img/grille.png");
	
	//ImageView grileView = new ImageView(grille);

	public void setPseudoJoueur1(String pseudoJoueur1) {
		this.pseudoJoueur1 = pseudoJoueur1;
	}

	public void setPseudoJoueur2(String pseudoJoueur2) {
		this.pseudoJoueur2 = pseudoJoueur2;
	}

	@FXML
	void buttontestfunction(ActionEvent event) {
		System.out.println("Test reussi");
	}

	private boolean tourX = true;

	@FXML
	void configurationPseudo() {
		joueur1.setText(pseudoJoueur1);
		joueur2.setText(pseudoJoueur2);
	}

	@FXML
	void affichageGrille() {
		grilleId.setFitWidth(450);
		grilleId.setFitHeight(450);
		grilleId.setLayoutX(160);
		grilleId.setLayoutY(20);
		grilleId.setImage(grille);
		
	}

	@FXML
	public void play(ActionEvent event) throws IOException {
		Button buttonClicked = (Button) event.getSource();

		if (buttonClicked.getText().isEmpty()) {
			if (tourX) {
				buttonClicked.setText("X");
				buttonClicked.setStyle("-fx-text-fill: transparent;");
				buttonClicked.setStyle("-fx-background-color: transparent;");
				buttonClicked.setTextFill(Color.WHITE); 
				ImageView croixView = new ImageView(croix);
				croixView.setFitWidth(80);
				croixView.setFitHeight(80);
				buttonClicked.setGraphic(croixView);
			} else {
				buttonClicked.setText("O");
				buttonClicked.setStyle("-fx-text-fill: transparent;");
				buttonClicked.setStyle("-fx-background-color: transparent;");
				buttonClicked.setTextFill(Color.WHITE); 

				ImageView rondView = new ImageView(rond);
				rondView.setFitWidth(80);
				rondView.setFitHeight(80);
				buttonClicked.setGraphic(rondView);

			}

			if (checkVictory()) {
				if (tourX == true) {
					System.out.println("Victoire pour " + " " + pseudoJoueur1);
				} else {
					System.out.println("Victoire pour " + " " + pseudoJoueur2);
				}
				propositionRejouer(event);
				resetGame();

			} else {
				tourX = !tourX;
			}
			if (!checkVictory()) {
				System.out.println("Jeu en cours");
			}
			if (checkVictory() == false && matchNul() == true) {
				System.out.println("Match nul");
				propositionRejouer(event);
				resetGame();

			}
		}
	}

	private boolean matchNul() {
		if (!button00.getText().isEmpty() && !button01.getText().isEmpty() && !button02.getText().isEmpty()
				&& !button10.getText().isEmpty() && !button11.getText().isEmpty() && !button12.getText().isEmpty()
				&& !button20.getText().isEmpty() && !button21.getText().isEmpty() && !button22.getText().isEmpty()) {
			return true;
		}

		return false;
	}

	private boolean checkVictory() {
		// Vérifier les lignes
		for (int i = 0; i < 3; i++) {
			if (!getButton(i, 0).getText().isEmpty() && getButton(i, 0).getText().equals(getButton(i, 1).getText())
					&& getButton(i, 0).getText().equals(getButton(i, 2).getText())) {
				return true;
			}
		}
		// Vérifier les colonnes
		for (int i = 0; i < 3; i++) {
			if (!getButton(0, i).getText().isEmpty() && getButton(0, i).getText().equals(getButton(1, i).getText())
					&& getButton(0, i).getText().equals(getButton(2, i).getText())) {
				return true;
			}
		}
		// Vérifier les diagonales
		if (!getButton(0, 0).getText().isEmpty() && getButton(0, 0).getText().equals(getButton(1, 1).getText())
				&& getButton(0, 0).getText().equals(getButton(2, 2).getText())) {
			return true;
		}
		if (!getButton(0, 2).getText().isEmpty() && getButton(0, 2).getText().equals(getButton(1, 1).getText())
				&& getButton(0, 2).getText().equals(getButton(2, 0).getText())) {
			return true;
		}
		return false;
	}

	private void resetGame() {
		button00.setText("");
		button01.setText("");
		button02.setText("");
		button10.setText("");
		button11.setText("");
		button12.setText("");
		button20.setText("");
		button21.setText("");
		button22.setText("");
		button00.setGraphic(null);
		button01.setGraphic(null);
		button02.setGraphic(null);
		button10.setGraphic(null);
		button11.setGraphic(null);
		button12.setGraphic(null);
		button20.setGraphic(null);
		button21.setGraphic(null);
		button22.setGraphic(null);
		tourX = true;
	}

	private Button getButton(int row, int col) {
		switch (row) {
		case 0:
			switch (col) {
			case 0:
				return button00;
			case 1:
				return button01;
			case 2:
				return button02;
			}
		case 1:
			switch (col) {
			case 0:
				return button10;
			case 1:
				return button11;
			case 2:
				return button12;
			}
		case 2:
			switch (col) {
			case 0:
				return button20;
			case 1:
				return button21;
			case 2:
				return button22;
			}
		}
		return null;
	}

	@FXML
	void propositionRejouer(ActionEvent event) throws IOException {

	}

}
