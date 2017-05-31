
package library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.model.User;
import server.DBcontroller;

public class LogCommand extends Command {

    String username;
    String password;
    //int tip;

    public LogCommand(String username, String password) {
        this.username = username;
        this.password = password;
        //this.manager_id = id;
    }

    public LogCommand() 
    {
        
    }

    @Override
    public Object execute() {
        try {
            String sql = "select * from ANGAJAT where USERNAME='" + this.username + "' and PAROLA='" + this.password + "'";
            Statement st = DBcontroller.getI().getSt(); //cand vreau sa fac rost de statement
            ResultSet rs = st.executeQuery(sql);

            User res = new User();

            if (rs.next()) {
                res.username = rs.getString("USERNAME");
                res.password = rs.getString("PAROLA");
                res.zile_concediu_ramase = rs.getInt("ZILE_CONCEDIU_RAMASE");
                res.nume = rs.getString("NUME");
                res.prenume = rs.getString("PRENUME");
                res.id = rs.getInt("ANGAJAT_ID");
                res.tip = rs.getInt("TIP");
                rs.close();
                return res;
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(LogCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
