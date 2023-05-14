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
import models.Vehicule;
import models.VehiculeCrud;

public class HomeProduitController implements Initializable {

    @FXML
    private TableColumn<Vehicule, String> Model;

    @FXML
    private TableColumn<Vehicule, String> Couleur;

    @FXML
    private TableColumn<Vehicule, Integer> id;

    @FXML
    private TableColumn<Vehicule, Integer> categ;

    @FXML
    private TableView<Vehicule> tableProduit;
    
    
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtMod;

    @FXML
    private TextField txtCoul;
    @FXML
    private TextField txtCat;
    
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
    		Vehicule p=tableProduit.getSelectionModel().getSelectedItem();
    		txtId.setText(String.valueOf(p.getId()));
    		txtMod.setText(p.getModel());
    		txtCoul.setText(p.getCouleur());
    		txtCat.setText(String.valueOf(p.getCateg()));
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
    	String mod=txtMod.getText();
    	String coul=txtCoul.getText();
    	int cat=Integer.parseInt(txtCat.getText());
    	Vehicule p=new Vehicule(id,mod,coul,cat);
    	VehiculeCrud pc=new VehiculeCrud();
    	int i=pc.update(p);
    	
    		
    	
    	loadData();
		}
    	

    }

    @FXML
    void addProduit(ActionEvent event) {
    	
    	String mod=txtMod.getText();
    	String coul=txtCoul.getText();
    	int cat=Integer.parseInt(txtCat.getText());
    	Vehicule p=new Vehicule(mod,coul,cat);
    	VehiculeCrud pc=new VehiculeCrud();
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
		txtMod.setText("");
		txtCoul.setText("");
		txtCat.setText("");
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
    	Vehicule p=new Vehicule(id);
    	VehiculeCrud pc=new VehiculeCrud();
    	int i=pc.delete(p);   	
    	loadData();
    	txtId.setText("");
		txtMod.setText("");
		txtCoul.setText("");
		txtCat.setText("");
    	
		}
    }
    @FXML
    public void loadData() {
    	id.setCellValueFactory(new PropertyValueFactory<>("id"));
		Model.setCellValueFactory(new PropertyValueFactory<>("model"));
		Couleur.setCellValueFactory(new PropertyValueFactory<>("couleur"));
		categ.setCellValueFactory(new PropertyValueFactory<>("categ"));
		VehiculeCrud pc=new VehiculeCrud();
		ObservableList<Vehicule> produits= pc.getAll();
		tableProduit.setItems(produits);
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadData();
		
	}

}
