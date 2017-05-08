/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.JTextField;
import library.model.User;
import java.text.SimpleDateFormat;

/**
 *
 * @author Bogdan-Andrei
 */
public class AscultatorButonTrimiteSolicitare implements ActionListener
{
    JTextField zi_start = new JTextField();
    JTextField luna_start = new JTextField();
    JTextField an_start = new JTextField();
    JTextField zi_sfarsit = new JTextField();
    JTextField luna_sfarsit = new JTextField();
    JTextField an_sfarsit = new JTextField();
    User user = new User();

    public AscultatorButonTrimiteSolicitare(JTextField zi_start, JTextField luna_start,
            JTextField an_start,JTextField zi_sfarsit,JTextField luna_sfarsit,JTextField an_sfarsit,User user) 
    {
        this.zi_start = zi_start;
        this.luna_start = luna_start;
        this.an_start = an_start;
        this.zi_sfarsit = zi_sfarsit;
        this.luna_sfarsit = luna_sfarsit;
        this.an_sfarsit = an_sfarsit;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        //if(parseInt(zi_start.getText()) < 28 && parseInt(luna_sfarsit.getText()) < 12)
        //TO DO 
          // System.out.print("Data corecta");
    }
    
}
