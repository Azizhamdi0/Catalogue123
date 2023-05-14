package controllers;


import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Categorie;
import models.CategorieCrud;

public class HomeCategorie implements Initializable {

    @FXML
    private TableColumn<Categorie, String> Nom;



    @FXML
    private TableColumn<Categorie, Integer> id;

 

    @FXML
    private TableView<Categorie> tableProduit;
    
    
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNom;


    
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;


    @FXML
    void editProduit(MouseEvent event) {
    		Categorie p=tableProduit.getSelectionModel().getSelectedItem();
    		txtId.setText(String.valueOf(p.getId()));
    		txtNom.setText(p.getNom());
    }
    
    @FXML
    void updateProduit(ActionEvent event) {
    	Alert d=new Alert(AlertType.CONFIRMATION);
		d.setTitle("MAJ");
		d.setHeaderText(null);
		d.setContentText("Voulez vous confirmez la MAJ?");
		Optional<ButtonType> rep=d.showAndWait();
		if(rep.get()==ButtonType.OK) {
    	int id=Integer.parseInt(txtId.getText());
    	String nom=txtNom.getText();
    	Categorie p=new Categorie(id,nom);
    	CategorieCrud pc=new CategorieCrud();
    	int i=pc.update(p);
    	
    		
    	
    	loadData();
		}
    	

    }

    @FXML
    void addProduit(ActionEvent event) {
    	
    	String nom=txtNom.getText();
    	Categorie p=new Categorie(nom);
    	CategorieCrud pc=new CategorieCrud();
    	int i=pc.add(p);
    	Alert d=new Alert(AlertType.INFORMATION) 	;
    	d.setHeaderText(null);
    	d.setTitle("Insertion nouveau produit");
    	d.setContentText("Insertion éffectuée avec succès");
    	d.showAndWait();
    	
    	loadData();
    }

    @FXML
    void clearProduit(ActionEvent event) {
    	txtId.setText("");
		txtNom.setText("");

    }

    @FXML
    void deleteProduit(ActionEvent event) {
    	Alert d=new Alert(AlertType.CONFIRMATION);
		d.setTitle("Suppression Produit");
		d.setHeaderText(null);
		d.setContentText("Voulez vous confirmez la suppression du produit sélectionné?");
		Optional<ButtonType> rep=d.showAndWait();
		if(rep.get()==ButtonType.OK) {
    	int id=Integer.parseInt(txtId.getText());
    	/*String lib=txtLib.getText();
    	double pr=Double.parseDouble(txtPrix.getText());
    	int q=Integer.parseInt(txtQte.getText());*/
    	Categorie p=new Categorie(id);
    	CategorieCrud pc=new CategorieCrud();
    	int i=pc.delete(p);   	
    	loadData();
    	txtId.setText("");
		txtNom.setText("");

    	
		}
    }
    @FXML
    public void loadData() {
    	id.setCellValueFactory(new PropertyValueFactory<>("id"));
		Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		CategorieCrud pc=new CategorieCrud();
		ObservableList<Categorie> vehicule= pc.getAll();
		tableProduit.setItems(vehicule);
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadData();
		
	}

}
