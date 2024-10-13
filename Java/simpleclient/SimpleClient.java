/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class SimpleClient {

Socket mySocket;
DataInputStream ear ;
PrintStream mouth;

    public static void main(String[] args) {
       new SimpleClient();
    }
    public SimpleClient (){
    try {
        mySocket = new Socket("127.0.0.1",5005);
        ear = new DataInputStream(mySocket.getInputStream());
        mouth = new PrintStream(mySocket.getOutputStream());
        mouth.println("hello server");
        String response = ear.readLine();
        System.out.println(response);
    } catch (IOException ex) {
        Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
    }finally {
        try {
            mySocket.close();
            mouth.close();
            ear.close();
        } catch (IOException ex) {
            Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
}
