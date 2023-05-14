package controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable {
	
	@FXML
    private AnchorPane Login;

    @FXML
    private Button btnConnecter;

    @FXML
    private Label lblLog;

    @FXML
    private Label lblPass;

    @FXML
    private TextField txtLog;

    @FXML
    private PasswordField txtPass;

    @FXML
    void seConnecter(ActionEvent event) {
    	if(txtLog.getText().equals("aziz")&&txtPass.getText().equals(""))
    	{
    		Alert dialog=new Alert(AlertType.INFORMATION);
    		dialog.setTitle("Connexion");
    		dialog.setContentText("Connexion effectuée avec succès");
    		dialog.showAndWait();
    		Login.getChildren().removeAll();
    		try {
				Parent hp=FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
				Login.getChildren().setAll(hp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    	}
    	else
    	{
    		Alert dialog=new Alert(AlertType.ERROR);
    		dialog.setTitle("Erreur");
    		dialog.setContentText("Vous n'avez pas d'accées.");
    		dialog.showAndWait();
    		Login.getChildren().removeAll();
    		
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		txtLog.setText("aziz");
		
	}


	

}
