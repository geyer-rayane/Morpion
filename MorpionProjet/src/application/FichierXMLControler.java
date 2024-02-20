package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class FichierXMLControler implements Initializable{

    @FXML
    private Button Button1;

    @FXML
    private Rectangle Bloc;

    @FXML
    void deplacerBloc(ActionEvent event) {
    	 TranslateTransition translate = new TranslateTransition();  
    	   translate.setByX(500);
    	   translate.setByY(100);
    	   translate.setDuration(Duration.millis(1000)); 
    	   //setting cycle count for the Translate transition   
           translate.setCycleCount(2);  
             
           //the transition will set to be auto reversed by setting this to true   
           translate.setAutoReverse(true);  
             
           //setting Circle as the node onto which the transition will be applied  
           translate.setNode(Bloc);  
       
           //playing the transition   
           translate.play();
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	

}
