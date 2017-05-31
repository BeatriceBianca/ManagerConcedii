/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBconnection
{
    private Connection DBconnection;
    
    public Connection connect()
    {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);//asta se executa daca nu ai importat bine biblioteca
            System.exit(0);
        }

        try {
      
            connection = DriverManager.getConnection("jdbc:oracle:thin:@193.226.51.37:1521:o11g", "petras_bogdan", "parola");// te conectezi la baza de date (jdbc:oracle:thin:@ + ip + : + port + : + o11g)

        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
    }
    
    
    
     public static void main(String[] args) 
     {
     
    }
}
