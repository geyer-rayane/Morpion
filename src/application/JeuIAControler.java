package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public class JeuIAControler implements Initializable{

	private MultiLayerPerceptron net;

	public JeuIAControler() {
	}

	// Méthode pour recevoir l'objet net

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


	@FXML
	public void play(ActionEvent event) throws IOException {
	
	}

	@FXML
	void propositionRejouer(ActionEvent event) throws IOException {

	}
	
	@FXML
	void jeuIA() {
		double[] tab = { 1.0, 1.0, 0.0, -1.0, -1.0, 0.0, 0.0, 0.0, 0.0 };
		Coup coup = new Coup(9, "test");
	    coup.addInBoard(tab);
	    double[] res = Test.play(Learn.netJeu, coup);
	
	        double max = 0;
	        int indice = 0;
	        for (int i = 0; i < 9; i++) {
	        	if (tab[indice] != 0.0) {
	    	        max=0;
	        		res[indice] = -1;   
	            }
	            if ((res[i] > max)) {
	            	 max = res[i];
	                 indice = i;
	            
	        }
	           
	    
	            
	            
	        } 
	        System.out.println("L'IA a choisi la case : " + indice);
            
            System.out.println("Tableau des coups après le coup de l'IA : " + Arrays.toString(tab));
            System.out.println("T: " +Arrays.toString(res));
	    
	}

		
	
	
	
	private Button getButtonByIndex(int index) {
	    // Rechercher le bouton correspondant à l'indice dans la scène
	    switch (index) {
	        case 0:
	            return button00;
	        case 1:
	            return button01;
	        case 2:
	            return button02;
	        case 3:
	            return button10;
	        case 4:
	            return button11;
	        case 5:
	            return button12;
	        case 6:
	            return button20;
	        case 7:
	            return button21;
	        case 8:
	            return button22;
	        default:
	            return null;
	    }
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("HELLO");
		// TODO Auto-generated method stub
		jeuIA();
	}
	

}