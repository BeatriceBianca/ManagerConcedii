/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.model.Concediu;
import library.model.User;
import server.DBcontroller;

/**
 *
 * @author Bogdan-Andrei
 */
public class SolicitListaConcediiAprobate extends Command
{
    User user;
    
    public SolicitListaConcediiAprobate(User user)
    {
        this.user = user;
    }
    
    @Override
    public Object execute()
    {
        try {
            //String sql = "select * from concedii where ANGAJAT_ID=" + this.user.id + " and STARE=" + 1 + "";
            String sql = "select * from CONCEDII where angajat_id = " + this.user.id;
            Statement st = DBcontroller.getI().getSt(); //cand vreau sa fac rost de statement
            ResultSet rs = st.executeQuery(sql);
            System.out.println(sql);
            List<Concediu> lista_con = new ArrayList<Concediu>();

            while (rs.next()) 
            {
                Concediu concediu = new Concediu();
                concediu.data_start = rs.getString("START_DATE");
                concediu.data_sfarsit = rs.getString("END_DATE");
                concediu.stare = rs.getInt("STARE");
                lista_con.add(concediu);
            }
            return lista_con;

        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(LogCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
