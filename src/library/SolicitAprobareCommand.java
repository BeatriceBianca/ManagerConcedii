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
import server.DBcontroller;

/**
 *
 * @author Beatrice Bianca
 */
public class SolicitAprobareCommand extends Command{
    int id, response;
    
    public SolicitAprobareCommand(int id, int response) {
        this.id = id;
        this.response = response;
    }
    
    @Override
    public Object execute() {
        String sql = "update CONCEDII set stare = " + response + " where concediu_id = " + id;
        Statement st = DBcontroller.getI().getSt(); //cand vreau sa fac rost de statement
        try {  
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SolicitAprobareCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
