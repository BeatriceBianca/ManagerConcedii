
package library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.DBcontroller;

public class SolicitAprobareCommand extends Command
{
    int id, response;
    
    public SolicitAprobareCommand(int id, int response) 
    {
        this.id = id;
        this.response = response;
    }
    
    @Override
    public Object execute() 
    {
        Statement st = DBcontroller.getI().getSt();
        String sql;
        ResultSet rs=null;
        sql = "select start_date, end_date, angajat_id from concedii where concediu_id = " + id; 
        try {
             rs = st.executeQuery(sql);
            if (rs.next()) {
                Date startDate = rs.getDate("start_date");
                Date endDate = rs.getDate("end_date");
                int angajat = rs.getInt("angajat_id");

                long diff = TimeUnit.DAYS.convert(endDate.getTime() - startDate.getTime(),TimeUnit.MILLISECONDS) + 1;
                
                sql = "update ANGAJAT set zile_concediu_ramase = zile_concediu_ramase - " + diff + " where angajat_id ='" + angajat + "'";
                st.executeUpdate(sql);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SolicitAprobareCommand.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally
        {
            if(rs!=null)
                try {
                    rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(SolicitAprobareCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        sql = "update CONCEDII set stare = " + response + " where concediu_id = " + id; 
        try 
        {  
            st.executeUpdate(sql);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(SolicitAprobareCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
