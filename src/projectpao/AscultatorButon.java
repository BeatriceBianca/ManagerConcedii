/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpao;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AscultatorButon implements ActionListener
{
    JButton b;
    JTextField nume, pass;
    JFrame login;

    AscultatorButon(JTextField username, JPasswordField password, JButton buton,JFrame frame) 
    {
        this.nume = username;
        this.pass = password;
        this.login = frame;
    }


    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        //JFrame frame = new JFrame("Platforma concedii");
        //Connection conn = new DBconnection().connect();
        String sql = "select * from USERS where USERNAME='" + this.nume.getText() + "' and PASSWORD='" + this.pass.getText() +"'";
        System.out.print(this.nume.getText()+" "+this.pass.getText());
        try
        {
            //Statement statement = conn.createStatement();
            Statement st = DBcontroller.getI().getSt(); //cand vreau sa fac rost de statement
            ResultSet rs = st.executeQuery(sql);
            
            
            if( rs.next() )
            {
                System.out.print("a intrat aici!");
                JOptionPane.showMessageDialog(null,"Felicitari : "+this.nume.getText()+", ai reusit sa te loghezi!");
                JFrame panou = new JFrame("Panou principal");
                panou.setVisible(true);
                login.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Username & pass invalid!");
            }
        }
        catch(SQLException | HeadlessException e)
        {
            System.out.print("EXCEPTIE"+e);
        }
        
    }
    
}
