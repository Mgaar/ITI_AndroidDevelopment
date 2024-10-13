/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *10.145.19.245
 * @author lenovo
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField txtin;
    @FXML
    private Button button;
    @FXML
    private TextArea txtout;
    
    Socket invitation ;
    DataInputStream ear;
    PrintStream mouth;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            invitation = new Socket("10.145.19.245",5005);
            ear = new DataInputStream(invitation.getInputStream());
            mouth = new PrintStream(invitation.getOutputStream());
            new Thread(){
                @Override
                public void run() {
                    while(true)
                    {
                        try {
                            String msg = ear.readLine();
                            txtout.appendText(msg + "\n");
                        } catch (IOException ex) {
                            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }.start();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void sendAction(ActionEvent event) {
        String msg = txtin.getText();
        mouth.println("Elg3ar : " + msg);
        txtin.clear();
    }
    
}
