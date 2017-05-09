/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.text.DateFormat;
import java.text.ParseException;
import javax.swing.JTextField;
import library.model.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.DAYS;
import library.LogCommand;
import library.SolicitConcediuCommand;


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
            {
                System.out.println("Date corecte!!");
                // to do scriu in baza de date
               ConnectionController cc = ConnectionController.getInstance(); //?
                cc.getOut().writeObject(new SolicitConcediuCommand(user,zi_start, zi_sfarsit,luna_start,luna_sfarsit));

            
            }
            else System.out.println("Date incorecte!!");
            
            //long diff = endDate.getTime() - startDate.getTime();
            //System.out.println(diff/864000000);
            long diff = TimeUnit.DAYS.convert(endDate.getTime() - startDate.getTime(),TimeUnit.MILLISECONDS);
            System.out.println(diff);
            //System.out.println(parseLong(startDateString));
            //System.out.println(parseLong(endDateString)-parseLong(startDateString));
            
        } catch (ParseException ex) {
            System.out.println("Date gresite!!");
            Logger.getLogger(AscultatorButonTrimiteSolicitare.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AscultatorButonTrimiteSolicitare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
