package application;

import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.control.ProgressBar;

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
import java.sql.Time;
import java.util.ArrayList;

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

    @FXML
    private ImageView premiereLigneVictoire;

    @FXML
    private ImageView deuxiemeLigneVictoire;

    @FXML
    private ImageView troisiemeLigneVictoire;

    @FXML
    private ImageView premiereColonneVictoire;

    @FXML
    private ImageView deuxiemeColonneVictoire;

    @FXML
    private ImageView troisiemeColonneVictoire;

    @FXML
    private ImageView premiereDiagonaleVictoire;

    @FXML
    private ImageView deuxiemeDiagonaleVictoire;

    @FXML
    private ProgressBar progressScoreX;

    @FXML
    private ProgressBar progressScoreO;

    private String pseudoJoueur1;
    private String pseudoJoueur2;

    Image croix = new Image("file:///home/nas-wks01/users/uapv2307467/eclipse-workspace/XO/img/croix.png");
    Image rond = new Image("file:///home/nas-wks01/users/uapv2307467/eclipse-workspace/XO/img/rond.png");
    Image grille = new Image("file:///home/nas-wks01/users/uapv2307467/eclipse-workspace/XO/img/grille.png");
    Image ligneVerteVictoire = new Image(
            "file:///home/nas-wks01/users/uapv2307467/eclipse-workspace/XO/img/ligneVerteVictoire.png");
    Image ligneRougeVictoire = new Image(
            "file:///home/nas-wks01/users/uapv2307467/eclipse-workspace/XO/img/ligneRougeVictoire.png");

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

        premiereLigneVictoire.setLayoutX(125);
        premiereLigneVictoire.setLayoutY(-30);
        premiereLigneVictoire.setFitWidth(500);
        premiereLigneVictoire.setFitHeight(300);

        deuxiemeLigneVictoire.setLayoutX(125);
        deuxiemeLigneVictoire.setLayoutY(100);
        deuxiemeLigneVictoire.setFitWidth(500);
        deuxiemeLigneVictoire.setFitHeight(300);

        troisiemeLigneVictoire.setLayoutX(125);
        troisiemeLigneVictoire.setLayoutY(230);
        troisiemeLigneVictoire.setFitWidth(500);
        troisiemeLigneVictoire.setFitHeight(300);

        premiereColonneVictoire.setLayoutX(0);
        premiereColonneVictoire.setLayoutY(90);
        premiereColonneVictoire.setFitWidth(500);
        premiereColonneVictoire.setFitHeight(300);

        deuxiemeColonneVictoire.setLayoutX(140);
        deuxiemeColonneVictoire.setLayoutY(90);
        deuxiemeColonneVictoire.setFitWidth(500);
        deuxiemeColonneVictoire.setFitHeight(300);

        troisiemeColonneVictoire.setLayoutX(280);
        troisiemeColonneVictoire.setLayoutY(90);
        troisiemeColonneVictoire.setFitWidth(500);
        troisiemeColonneVictoire.setFitHeight(300);

        premiereDiagonaleVictoire.setLayoutX(140);
        premiereDiagonaleVictoire.setLayoutY(90);
        premiereDiagonaleVictoire.setFitWidth(500);
        premiereDiagonaleVictoire.setFitHeight(300);

        deuxiemeDiagonaleVictoire.setLayoutX(140);
        deuxiemeDiagonaleVictoire.setLayoutY(90);
        deuxiemeDiagonaleVictoire.setFitWidth(500);
        deuxiemeDiagonaleVictoire.setFitHeight(300);

        premiereLigneVictoire.setMouseTransparent(true);
        deuxiemeLigneVictoire.setMouseTransparent(true);
        troisiemeLigneVictoire.setMouseTransparent(true);
        premiereColonneVictoire.setMouseTransparent(true);
        deuxiemeColonneVictoire.setMouseTransparent(true);
        troisiemeColonneVictoire.setMouseTransparent(true);
        premiereDiagonaleVictoire.setMouseTransparent(true);
        deuxiemeDiagonaleVictoire.setMouseTransparent(true);

        progressScoreX.setPrefHeight(20);
        progressScoreX.setProgress(0);
        progressScoreX.toFront();

        progressScoreO.setPrefHeight(20);
        progressScoreO.setProgress(0);
        progressScoreO.toFront();
    }

    @FXML
    public void play(ActionEvent event) throws IOException, InterruptedException {
        Button buttonClicked = (Button) event.getSource();

        if (buttonClicked.getText().isEmpty()) {
            if (tourX) {
                buttonClicked.setText("X");
                buttonClicked.setStyle("-fx-text-fill: transparent;");
                buttonClicked.setStyle("-fx-background-color: transparent;");
                buttonClicked.setTextFill(Color.BLACK);
                ImageView croixView = new ImageView(croix);
                croixView.setFitWidth(80);
                croixView.setFitHeight(80);
                buttonClicked.setGraphic(croixView);
            } else {
                buttonClicked.setText("O");
                buttonClicked.setStyle("-fx-text-fill: transparent;");
                buttonClicked.setStyle("-fx-background-color: transparent;");
                buttonClicked.setTextFill(Color.BLACK);

                ImageView rondView = new ImageView(rond);
                rondView.setFitWidth(80);
                rondView.setFitHeight(80);
                buttonClicked.setGraphic(rondView);

            }

            if (checkVictory() != null) {
                ArrayList<String> combinaisonGagnante = checkVictory();
                if (tourX == true) {
                    // Victoire horizontal
                    System.out.println("Victoire pour " + " " + pseudoJoueur1);
                    augmentationScore(tourX);
                    if (combinaisonGagnante.get(0).equals("00") && combinaisonGagnante.get(1).equals("01")
                            && combinaisonGagnante.get(2).equals("02")) {
                        premiereLigneVictoire.setImage(ligneVerteVictoire);
                        premiereLigneVictoire.toFront();
                    }
                    if (combinaisonGagnante.get(0).equals("10") && combinaisonGagnante.get(1).equals("11")
                            && combinaisonGagnante.get(2).equals("12")) {
                        deuxiemeLigneVictoire.setImage(ligneVerteVictoire);
                        deuxiemeLigneVictoire.toFront();
                    }
                    if (combinaisonGagnante.get(0).equals("20") && combinaisonGagnante.get(1).equals("21")
                            && combinaisonGagnante.get(2).equals("22")) {
                        troisiemeLigneVictoire.setImage(ligneVerteVictoire);
                        troisiemeLigneVictoire.toFront();
                    }

                    // Victoire verticale
                    if (combinaisonGagnante.get(0).equals("00") && combinaisonGagnante.get(1).equals("10")
                            && combinaisonGagnante.get(2).equals("20")) {
                        premiereColonneVictoire.setImage(ligneVerteVictoire);
                        premiereColonneVictoire.toFront();
                    }
                    if (combinaisonGagnante.get(0).equals("01") && combinaisonGagnante.get(1).equals("11")
                            && combinaisonGagnante.get(2).equals("21")) {
                        deuxiemeColonneVictoire.setImage(ligneVerteVictoire);
                        deuxiemeColonneVictoire.toFront();
                    }
                    if (combinaisonGagnante.get(0).equals("02") && combinaisonGagnante.get(1).equals("12")
                            && combinaisonGagnante.get(2).equals("22")) {
                        troisiemeColonneVictoire.setImage(ligneVerteVictoire);
                        troisiemeColonneVictoire.toFront();
                    }

                    // Victoire diagonale
                    if (combinaisonGagnante.get(0).equals("00") && combinaisonGagnante.get(1).equals("11")
                            && combinaisonGagnante.get(2).equals("22")) {
                        premiereDiagonaleVictoire.setImage(ligneVerteVictoire);
                        premiereDiagonaleVictoire.toFront();
                    }
                    if (combinaisonGagnante.get(0).equals("02") && combinaisonGagnante.get(1).equals("11")
                            && combinaisonGagnante.get(2).equals("20")) {
                        deuxiemeDiagonaleVictoire.setImage(ligneVerteVictoire);
                        deuxiemeDiagonaleVictoire.toFront();
                    }
                    resetGame() ;

                } else {
                    // Victoire horizontal
                    System.out.println("Victoire pour " + " " + pseudoJoueur2);
                    augmentationScore(tourX);
                    if (combinaisonGagnante.get(0).equals("00") && combinaisonGagnante.get(1).equals("01")
                            && combinaisonGagnante.get(2).equals("02")) {
                        premiereLigneVictoire.setImage(ligneRougeVictoire);
                        premiereLigneVictoire.toFront();
                    }
                    if (combinaisonGagnante.get(0).equals("10") && combinaisonGagnante.get(1).equals("11")
                            && combinaisonGagnante.get(2).equals("12")) {
                        deuxiemeLigneVictoire.setImage(ligneRougeVictoire);
                        deuxiemeLigneVictoire.toFront();
                    }
                    if (combinaisonGagnante.get(0).equals("20") && combinaisonGagnante.get(1).equals("21")
                            && combinaisonGagnante.get(2).equals("22")) {
                        troisiemeLigneVictoire.setImage(ligneRougeVictoire);
                        troisiemeLigneVictoire.toFront();
                    }

                    // Victoire verticale
                    if (combinaisonGagnante.get(0).equals("00") && combinaisonGagnante.get(1).equals("10")
                            && combinaisonGagnante.get(2).equals("20")) {
                        premiereColonneVictoire.setImage(ligneRougeVictoire);
                        premiereColonneVictoire.toFront();
                    }
                    if (combinaisonGagnante.get(0).equals("01") && combinaisonGagnante.get(1).equals("11")
                            && combinaisonGagnante.get(2).equals("21")) {
                        deuxiemeColonneVictoire.setImage(ligneRougeVictoire);
                        deuxiemeColonneVictoire.toFront();
                    }
                    if (combinaisonGagnante.get(0).equals("02") && combinaisonGagnante.get(1).equals("12")
                            && combinaisonGagnante.get(2).equals("22")) {
                        troisiemeColonneVictoire.setImage(ligneRougeVictoire);
                        troisiemeColonneVictoire.toFront();
                    }

                    // Victoire diagonale
                    if (combinaisonGagnante.get(0).equals("00") && combinaisonGagnante.get(1).equals("11")
                            && combinaisonGagnante.get(2).equals("22")) {
                        premiereDiagonaleVictoire.setImage(ligneRougeVictoire);
                        premiereDiagonaleVictoire.toFront();
                    }
                    if (combinaisonGagnante.get(0).equals("02") && combinaisonGagnante.get(1).equals("11")
                            && combinaisonGagnante.get(2).equals("20")) {
                        deuxiemeDiagonaleVictoire.setImage(ligneRougeVictoire);
                        deuxiemeDiagonaleVictoire.toFront();
                    }
                    resetGame() ;

                }

            } else {
                tourX = !tourX;
            }
            if (checkVictory() == null && matchNul() == true) {
                System.out.println("Match nul voulez vous rejouer ?");
            }
           
        }
       
       
    }

    private void augmentationScore(boolean joueur) {
        // Joueur X a gagné
        double augmentation = 0.25;
        if (joueur) {
            progressScoreX.setProgress(progressScoreX.getProgress() + augmentation);
        }
        // Joueur O a gagné
        else {
            progressScoreO.setProgress(progressScoreO.getProgress() + augmentation);
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

    public ArrayList<String> checkVictory() {
        ArrayList<String> winningButtons = new ArrayList<>();
        // Vérifier les lignes
        for (int i = 0; i < 3; i++) {
            if (!getButton(i, 0).getText().isEmpty() && getButton(i, 0).getText().equals(getButton(i, 1).getText())
                    && getButton(i, 0).getText().equals(getButton(i, 2).getText())) {
                winningButtons.add(i + "0");
                winningButtons.add(i + "1");
                winningButtons.add(i + "2");
                return winningButtons;
            }
        }
        // Vérifier les colonnes
        for (int i = 0; i < 3; i++) {
            if (!getButton(0, i).getText().isEmpty() && getButton(0, i).getText().equals(getButton(1, i).getText())
                    && getButton(0, i).getText().equals(getButton(2, i).getText())) {
                winningButtons.add("0" + i);
                winningButtons.add("1" + i);
                winningButtons.add("2" + i);
                return winningButtons;
            }
        }
        // Vérifier les diagonales
        if (!getButton(0, 0).getText().isEmpty() && getButton(0, 0).getText().equals(getButton(1, 1).getText())
                && getButton(0, 0).getText().equals(getButton(2, 2).getText())) {
            winningButtons.add("00");
            winningButtons.add("11");
            winningButtons.add("22");
            return winningButtons;
        }
        if (!getButton(0, 2).getText().isEmpty() && getButton(0, 2).getText().equals(getButton(1, 1).getText())
                && getButton(0, 2).getText().equals(getButton(2, 0).getText())) {
            winningButtons.add("02");
            winningButtons.add("11");
            winningButtons.add("20");
            return winningButtons;
        }
        return null;
    }

    private void resetGame() throws InterruptedException {
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

        premiereLigneVictoire.setImage(null);
        deuxiemeLigneVictoire.setImage(null);
        troisiemeLigneVictoire.setImage(null);
        premiereColonneVictoire.setImage(null);
        deuxiemeColonneVictoire.setImage(null);
        troisiemeColonneVictoire.setImage(null);
        premiereDiagonaleVictoire.setImage(null);
        deuxiemeDiagonaleVictoire.setImage(null);

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
    boolean propositionRejouer(ActionEvent event) throws IOException, InterruptedException {
        return true;
    }

}
