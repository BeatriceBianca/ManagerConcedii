/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import library.model.User;
import server.DBcontroller;


public class SolicitConcediuCommand extends Command
{
    User user;
    String startDate;
    String endDate;
    long diff;

    public SolicitConcediuCommand(User user, String startDate, String endDate, long diff) 
    {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.diff = diff;
        
    }
    
    @Override
    public Object execute()
    {
        try {
            
            String sql = "update ANGAJAT set zile_concediu_ramase = zile_concediu_ramase - " + diff + " where USERNAME='" + user.username + "'";
            Statement st = DBcontroller.getI().getSt(); //cand vreau sa fac rost de statement
            st.executeUpdate(sql);
//                
                
            String sql1 = "INSERT INTO Concedii (start_date, end_date, stare, angajat_id) VALUES ( to_date('" +
                    startDate + "', 'dd-mm-yyyy'), to_date(' " + endDate + "','dd-mm-yyyy'), 0 ," + user.id + ")";
 
            System.out.println(sql1);
            Statement st1 = DBcontroller.getI().getSt(); //cand vreau sa fac rost de statement
            st1.executeUpdate(sql1);

        } catch (SQLException ex) {
            Logger.getLogger(LogCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
