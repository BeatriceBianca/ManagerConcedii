/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import javax.swing.JTextField;
import library.model.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.DAYS;
import library.LogCommand;
import javax.swing.JOptionPane;
import library.SolicitConcediuCommand;
import server.DBcontroller;


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
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        
        String startDateString;
        String endDateString;
        
        Object lunaStart = luna_start.getSelectedItem();
        int ziStart = Integer.parseInt(zi_start.getText());
        if (lunaStart == "01" || lunaStart == "03" || lunaStart == "05" || lunaStart == "07"
                || lunaStart == "08" || lunaStart == "10" || lunaStart == "12") {
            if ( ziStart < 1 || ziStart > 31 ) {
                JOptionPane.showMessageDialog(null,"Data start incorecta!");
                return;
            }
        } else if ( lunaStart == "04" || lunaStart == "06" || lunaStart == "09" || lunaStart == "11" ) {
            if ( ziStart < 1 || ziStart > 30 ) {
                JOptionPane.showMessageDialog(null,"Data start incorecta!");
                return;
            }
        } else if ( lunaStart == "02" ) {
            if ( ziStart < 1 || ziStart > 28 ) {
                JOptionPane.showMessageDialog(null,"Data start incorecta!");
                return;
            }
        }
        
        Object lunaSfarsit = luna_sfarsit.getSelectedItem();
        int ziSfarsit = Integer.parseInt(zi_sfarsit.getText());
        if (lunaSfarsit == "01" || lunaSfarsit == "03" || lunaSfarsit == "05" || lunaSfarsit == "07"
                || lunaSfarsit == "08" || lunaSfarsit == "10" || lunaSfarsit == "12") {
            if ( ziSfarsit < 1 || ziSfarsit > 31 ) {
                JOptionPane.showMessageDialog(null,"Data sfarsit incorecta!");
                return;
            }
        } else if ( lunaSfarsit == "04" || lunaSfarsit == "06" || lunaSfarsit == "09" || lunaSfarsit == "11" ) {
            if ( ziSfarsit < 1 || ziSfarsit > 30 ) {
                JOptionPane.showMessageDialog(null,"Data sfarsit incorecta!");
                return;
            }
        } else if ( lunaSfarsit == "02" ) {
            if ( ziSfarsit < 1 || ziSfarsit > 28 ) {
                JOptionPane.showMessageDialog(null,"Data sfarsit incorecta!");
                return;
            }
        }
        
        startDateString = zi_start.getText() + "-" + luna_start.getSelectedItem() + "-2017";
        endDateString = zi_sfarsit.getText() + "-" + luna_sfarsit.getSelectedItem() + "-2017";
        
        try {
            Date startDate = df.parse(startDateString);
            Date endDate = df.parse(endDateString);
            
            if( startDate.before(endDate) )
            {
                long diff = TimeUnit.DAYS.convert(endDate.getTime() - startDate.getTime(),TimeUnit.MILLISECONDS) + 1;
            
                ConnectionController cc = ConnectionController.getInstance(); //?
                cc.getOut().writeObject(new SolicitConcediuCommand(user, startDateString, endDateString, diff));
            } else if ( startDate.equals(endDate) ) {
                long diff = TimeUnit.DAYS.convert(endDate.getTime() - startDate.getTime(),TimeUnit.MILLISECONDS) + 1;
            
                ConnectionController cc = ConnectionController.getInstance(); //?
                cc.getOut().writeObject(new SolicitConcediuCommand(user, startDateString, endDateString, diff));
            } else {
                JOptionPane.showMessageDialog(null,"Data sfarsit mai recenta decat cea de inceput!");
                return;
            }
            
        } catch (ParseException ex) {
            System.out.println("Date gresite!!");
            Logger.getLogger(AscultatorButonTrimiteSolicitare.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AscultatorButonTrimiteSolicitare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
