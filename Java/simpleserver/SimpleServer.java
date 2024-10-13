/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class SimpleServer {

ServerSocket myServerSocket;
Socket waiter;
DataInputStream ear ;
PrintStream mouth;

public static void main(String[] args)
{
    new SimpleServer();
}
public SimpleServer (){
    try {
        try {
            myServerSocket = new ServerSocket(5005);
            waiter = myServerSocket.accept();
            ear = new DataInputStream(waiter.getInputStream());
            mouth = new PrintStream(waiter.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(SimpleServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = ear.readLine();
        System.out.println(s);
        mouth.println("hello client");
    } catch (IOException ex) {
        Logger.getLogger(SimpleServer.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            myServerSocket.close();
            ear.close();
            mouth.close();
            waiter.close();
        } catch (IOException ex) {
            Logger.getLogger(SimpleServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}    
}
