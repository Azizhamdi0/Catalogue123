package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class HomeController {

    @FXML
    private AnchorPane body;

    @FXML
    private Button btnProduitHome;
    @FXML
    private Button btnCategorieHome;
    @FXML
    void ProduitListe(ActionEvent event) {
    	
    	try {
			Parent produitPane=FXMLLoader.load(getClass().getResource("/views/HomeProduit.fxml"));
			body.getChildren().removeAll();
			body.getChildren().setAll(produitPane);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
    	
    }
    
    @FXML
    void  CategorieListe(ActionEvent event) {
    	try {
			Parent produitPane=FXMLLoader.load(getClass().getResource("/views/HomeCategorie.fxml"));
			body.getChildren().removeAll();
			body.getChildren().setAll(produitPane);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
    	
    }
    }
   



