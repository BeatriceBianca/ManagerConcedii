
package library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.model.Concediu;
import library.model.User;
import server.DBcontroller;

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
        ResultSet rs = null;
        try {
            //String sql = "select * from concedii where ANGAJAT_ID=" + this.user.id + " and STARE=" + 1 + "";
            String sql = "select * from CONCEDII where angajat_id = " + this.user.id;
            Statement st = DBcontroller.getI().getSt(); //cand vreau sa fac rost de statement
             rs = st.executeQuery(sql);
            System.out.println(sql);
            ArrayList<Concediu> lista_con = new ArrayList<>();

            while (rs.next()) 
            {
                Concediu concediu = new Concediu();
                concediu.data_start = rs.getString("START_DATE");
                concediu.data_sfarsit = rs.getString("END_DATE");
                concediu.stare = rs.getInt("STARE");
                lista_con.add(concediu);
            }
            rs.close();
            return lista_con;

        } 
        catch (SQLException ex) 
        {
            System.out.println("Eroare la: SolicitListaConcediiAprobateCommand");
        }
        finally
        {
            if(rs!=null)
                try {
                    rs.close();
            } catch (SQLException ex) 
            {
                Logger.getLogger(SolicitAprobareCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
}
