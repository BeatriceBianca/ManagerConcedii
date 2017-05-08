/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.text.DateFormat;
import java.text.ParseException;
import javax.swing.JTextField;
import library.model.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Bogdan-Andrei
 */
public class AscultatorButonTrimiteSolicitare implements ActionListener
{
    JTextField zi_start = new JTextField();
    JComboBox luna_start = new JComboBox();
    JTextField zi_sfarsit = new JTextField();
    JComboBox luna_sfarsit = new JComboBox();
    User user = new User();
 
    public AscultatorButonTrimiteSolicitare(JTextField zi_start, JComboBox luna_start, JTextField zi_sfarsit, 
                        JComboBox luna_sfarsit, User user)
    {
        this.zi_start = zi_start;
        this.luna_start = luna_start;
        this.zi_sfarsit = zi_sfarsit;
        this.luna_sfarsit = luna_sfarsit;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        
        String startDateString = new String();
        String endDateString = new String();
        
        startDateString = zi_start.getText() + "-" + luna_start.getSelectedItem() + "-2017";
        endDateString = zi_sfarsit.getText() + "-" + luna_sfarsit.getSelectedItem() + "-2017";
        System.out.println(startDateString);
        System.out.println(endDateString);
        try {
            Date startDate = df.parse(startDateString);
            Date endDate = df.parse(endDateString);
            
            if( startDate.before(endDate) )
                System.out.println("Date corecte!!");
            else System.out.println("Date incorecte!!");
        } catch (ParseException ex) {
            System.out.println("Date gresite!!");
            Logger.getLogger(AscultatorButonTrimiteSolicitare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
