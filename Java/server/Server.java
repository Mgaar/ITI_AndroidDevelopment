/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    ServerSocket serverSocket;
public Server()
{
        try {
            serverSocket = new ServerSocket(5005);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
while(true)
{
Socket s;
            try {
                s = serverSocket.accept();
                new ChatHandler(s);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }

}
}
public static void main(String[] args)
{
new Server();
}

}
 class ChatHandler extends Thread
{
DataInputStream dis;
PrintStream ps;
static Vector<ChatHandler> clientsVector = new Vector<ChatHandler>();
public ChatHandler(Socket cs)
{
    try {
        dis = new DataInputStream(cs.getInputStream());
        ps = new PrintStream(cs.getOutputStream());
        ChatHandler.clientsVector.add(this);
        start();
    } catch (IOException ex) {
        Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
} 

@Override
public void run()
{
while(true)
{
String str;
    try {
        str = dis.readLine();
        sendMessageToAll(str);
    } catch (IOException ex) {
        Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
    }

}
}
void sendMessageToAll(String msg)
{

for(int i=0 ; i<clientsVector.size() ; i++)
{
clientsVector.get(i).ps.println(msg);
}
//
}
}
