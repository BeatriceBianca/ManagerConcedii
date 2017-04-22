/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBcontroller 
{
    private static final DBcontroller i = new DBcontroller();

    public static DBcontroller getI() {
        return i;
    }
    
    Statement st ;
    private DBcontroller() 
    {
        try
        {
            Connection conn = new DBconnection().connect();
            st = conn.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

    public Statement getSt() 
    {
        return st;
    }
    
}
