/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactslist;

import contactslist.db.DAO;
import dto.Contact;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author lenovo
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Text IDtxt;
    @FXML
    private Text FNAMEtxt;
    @FXML
    private Text LNAMEtxt;
    @FXML
    private Text PHONEtxt;
    @FXML
    private TextField IDtxtfield;
    @FXML
    private TextField FNAMEtxtfield;
    @FXML
    private TextField LNAMEtxtfield;
    @FXML
    private TextField PHONEtxtfield;
    @FXML
    private Button NewButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    
     private Alert alert = new Alert(AlertType.INFORMATION);
       
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void newAction(ActionEvent event) {
                try {
            // TODO
            Contact contact = new Contact (Integer.valueOf(IDtxtfield.getText()),FNAMEtxtfield.getText(),LNAMEtxtfield.getText(),PHONEtxtfield.getText());
            DAO.newContact(contact);
             alert.setTitle("adding person");
        alert.setHeaderText("adding person");
        alert.setContentText("person added successfully");

        // Show the alert and wait for a user response
        alert.showAndWait();
        } catch (SQLException ex) {
alert.setTitle("adding person");
        alert.setHeaderText("adding person");
        alert.setContentText("ID must unique : this id " + IDtxtfield.getText() + "is used " );
       alert.showAndWait();
        }        
                
    }

    @FXML
    private void updateButtonAction(ActionEvent event) {
         try {
            // TODO
            Contact contact = new Contact (Integer.valueOf(IDtxtfield.getText()),FNAMEtxtfield.getText(),LNAMEtxtfield.getText(),PHONEtxtfield.getText());
            DAO.updateContact(contact);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteButtonAction(ActionEvent event) {
           try {
            // TODO
            Contact contact = new Contact (Integer.valueOf(IDtxtfield.getText()),FNAMEtxtfield.getText(),LNAMEtxtfield.getText(),PHONEtxtfield.getText());
            DAO.deleteContact(contact);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
