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
import library.model.Cerere;
import library.model.Concediu;
import library.model.User;
import server.DBcontroller;

/**
 *
 * @author Bogdan-Andrei
 */
public class SolicitListaCereri extends Command
{
    User user;

    public SolicitListaCereri(User user) 
    {
        this.user = user;
    }
    @Override
    public Object execute()
    {
        try
        {
            String sql = "select * from concedii c , angajat a  where c.angajat_id = a.angajat_id "
                    + "and a.angajat_id is not null and manager_id is not null and stare=0";
            //in sql iau o lista de concedii care asteapta sa fie aprobate/refuzate dar trb sa am si nume/prenume din tabela angajat
            Statement st = DBcontroller.getI().getSt(); //cand vreau sa fac rost de statement
            ResultSet rs = st.executeQuery(sql);
            List<Cerere> lista_cereri = new ArrayList<>();
            while(rs.next())
            {
                Cerere cer = new Cerere();
                cer.angajat_id = rs.getInt("ANGAJAT_ID");
                cer.concediu_id = rs.getInt("CONCEDIU_ID");
                cer.start = rs.getString("START_DATE");
                cer.end = rs.getString("END_DATE");
                cer.nume = rs.getString("NUME");
                cer.prenume = rs.getString("PRENUME");
                lista_cereri.add(cer);
            }
            return lista_cereri;
        }
        catch(SQLException ex)
        {
            Logger.getLogger(LogCommand.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return null;
    }
    
}
