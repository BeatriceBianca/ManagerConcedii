/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import server.DBcontroller;


public class SolicitAdaugareAngajatCommand extends Command{
    
    String nume, prenume, username, parola;
    int manager_id;
    
    public SolicitAdaugareAngajatCommand(String nume, String prenume, String username, String parola, int manager_id) {
        this.nume = nume;
        this.prenume = prenume;
        this.username = username;
        this.parola = parola;
        this.manager_id = manager_id;
    }
    
    @Override
    public Object execute()
    {   
        try 
        {
            Statement st = DBcontroller.getI().getSt();
        
            String sql = "Insert into Angajat (nume, prenume, username, parola, manager_id, zile_concediu_ramase, tip) values" +
                "('" + nume + "','" + prenume + "','" + username + "','" + parola + "'," + manager_id + ",23,2)";
        
            
            st.executeUpdate(sql);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(SolicitAdaugareAngajatCommand.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
}
