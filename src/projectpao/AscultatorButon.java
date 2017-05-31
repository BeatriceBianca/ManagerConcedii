
package projectpao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import library.LogCommand;
import library.model.PanouPrincipal;
import library.model.PanouPrincipalM;
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
        try
        {
            
            ConnectionController cc = ConnectionController.getInstance(); //?
            cc.getOut().writeObject(new LogCommand(this.nume.getText(), this.pass.getText()));
            
            User user = (User) cc.getIn().readObject();
            
            if( user != null)
            {
                if(user.tip == 2)//angajat
                {
                    PanouPrincipal panou = new PanouPrincipal(user);
                    login.dispose();
                }
                if(user.tip == 1)//manager
                {
                    PanouPrincipalM ppm = new PanouPrincipalM(user);
                    login.dispose();
                }
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
