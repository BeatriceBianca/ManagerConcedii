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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import library.LogCommand;
import library.model.PanouPrincipal;
import library.model.User;

public class AscultatorButon implements ActionListener
{
    JButton b;
    JTextField nume, pass;
    JFrame login;

    AscultatorButon(JTextField username, JPasswordField password,JFrame frame) 
    {
        this.nume = username;
        this.pass = password;
        this.login = frame;
    }


    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        
        //System.out.print(this.nume.getText()+" "+this.pass.getText());
        try
        {
            
            ConnectionController cc = ConnectionController.getInstance(); //?
            cc.getOut().writeObject(new LogCommand(this.nume.getText(), this.pass.getText()));
            
            User user = (User) cc.getIn().readObject();
            
            if( user != null )
            {
//                System.out.print("a intrat aici!");
                //JOptionPane.showMessageDialog(null,"Felicitari : "+user.username+", ai reusit sa te loghezi!");
                PanouPrincipal panou = new PanouPrincipal(user);
                login.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Username & pass invalid!");
            }
        }
        catch(IOException | ClassNotFoundException e)
        {
            System.out.print("EXCEPTIE"+e);
        }
        
    }
    
}
