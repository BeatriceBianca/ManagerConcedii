/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import library.model.User;
import server.DBcontroller;


public class SolicitConcediuCommand extends Command
{
    User user;
    String zi_start;
    String zi_sfarsit;
    String luna_start;
    String luna_sfarsit;

    public SolicitConcediuCommand(User user,JTextField zi_start,JTextField zi_sfarsit,JComboBox luna_start
            ,JComboBox luna_sfarsit) 
    {
        this.user = user;
        this.zi_start = zi_start.getText();
        this.luna_start = (String) luna_start.getSelectedItem();
        this.zi_sfarsit = zi_sfarsit.getText();
        this.luna_sfarsit =(String) luna_sfarsit.getSelectedItem();
        
    }
    
    @Override
    public Object execute()
    {
        try {
            String sql = "insert into concedii values(" + null+ "," + null + ","+null+"'0',"+user.id+");";
            Statement st = DBcontroller.getI().getSt(); //cand vreau sa fac rost de statement
            ResultSet rs = st.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(LogCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
