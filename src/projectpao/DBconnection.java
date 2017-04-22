/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            //pas 1
            connection = DriverManager.getConnection("jdbc:oracle:thin:@193.226.51.37:1521:o11g", "petras_bogdan", "parola");// te conectezi la baza de date (jdbc:oracle:thin:@ + ip + : + port + : + o11g)
            //pas 2
            /*
            Statement statement = connection.createStatement();//faci rost de un statement (cu el executi query-uri)
            
            //pas 3
            ResultSet result = statement.executeQuery("select * from users");//trimiti un query si memorezi ResultSet-ul
*/
            //connection.close();//inchizi conexiunea
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    
    
     public static void main(String[] args) {
        //pas 0
        // testezi daca ai importat bine bilbioteca!
        /*
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);//asta se executa daca nu ai importat bine biblioteca
            System.exit(0);
        }

        try {
            //pas 1
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@193.226.51.37:1521:o11g", "petras_bogdan", "parola");// te conectezi la baza de date (jdbc:oracle:thin:@ + ip + : + port + : + o11g)
            //pas 2
            Statement statement = connection.createStatement();//faci rost de un statement (cu el executi query-uri)
            
            //pas 3
            ResultSet result = statement.executeQuery("select * from users");//trimiti un query si memorezi ResultSet-ul
            
            //pas 4
            while (result.next()) {//cat timp mai e un rand in result set
                System.out.print(result.getString("username") + " ");//daca acel camp este  reprezentat de un int
                System.out.println(result.getString("password") + " ");//daca acel camp este  reprezentat de un string
                //System.out.println(result.getString("last_name"));
            }
            
            connection.close();//inchizi conexiunea
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }
}
