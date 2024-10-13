/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactslist.db;

import dto.Contact;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.derby.jdbc.ClientDriver;
/**
 *
 * @author lenovo
 */
public class DAO {
    public static int newContact (Contact contact) throws SQLException{
    int insertionStatus = 0 ;
    DriverManager.registerDriver(new ClientDriver());
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ContactsList","root","root");
        PreparedStatement statement = con.prepareStatement("INSERT INTO CONTACTS VALUES (?, ? , ? , ?)");
        statement.setInt(1, contact.getId());
        statement.setString(2, contact.getfName());
        statement.setString(4, contact.getlName());
        statement.setString(3, contact.getPhone());
        insertionStatus = statement.executeUpdate();
        con.close();
        statement.close();
    return insertionStatus;
    }
   public static int updateContact (Contact contact) throws SQLException{
    int insertionStatus = 0 ;
    DriverManager.registerDriver(new ClientDriver());
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ContactsList","root","root");
        PreparedStatement statement = con.prepareStatement("UPDATE CONTACTS SET  FNAME = ? , PHONE = ? , LNAME = ? WHERE ID = ? ");
        statement.setInt(4, contact.getId());
        statement.setString(1, contact.getfName());
        statement.setString(3, contact.getlName());
        statement.setString(2, contact.getPhone());
        insertionStatus = statement.executeUpdate();
        con.close();
        statement.close();
    return insertionStatus;
    } 
      public static int deleteContact (Contact contact) throws SQLException{
    int insertionStatus = 0 ;
    DriverManager.registerDriver(new ClientDriver());
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ContactsList","root","root");
        PreparedStatement statement = con.prepareStatement("DELETE FROM CONTACTS WHERE ID = ? ");
        statement.setInt(1, contact.getId());

        insertionStatus = statement.executeUpdate();
        con.close();
        statement.close();
    return insertionStatus;
    } 
      
     public static Contact showContact ( ) throws SQLException{
    int insertionStatus = 0 ;
    Contact contact = new Contact(0,"","",""); 
    DriverManager.registerDriver(new ClientDriver());
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ContactsList","root","root");
        PreparedStatement statement = con.prepareStatement("SELECT * FROM CONTACTS ");
       

         ResultSet rs = statement.executeQuery();
        if ( rs.next())
        contactInteger.
                valueOf(rs.getString(1)),rs.getS);
        con.close();
        statement.close();
    return insertionStatus;
    }

}
