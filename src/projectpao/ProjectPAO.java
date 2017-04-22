/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpao;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Bogdan-Andrei
 */
public class ProjectPAO 
{
    
    public static void main(String[] args) throws SQLException 
    {
        GridBagConstraints constraints;
        JFrame frame = new JFrame("Platforma concedii");
        frame.setBounds(450,200,300,350); // x=100, y=100, fata de coltul ferestrei, 200-latime, 250-inaltime
        frame.setMinimumSize(new Dimension(300, 200)); //dimensiunea minima acceptata
        frame.setLayout(new GridBagLayout() );
        JTextField username = new JTextField(); //creez textfield ul
        JPasswordField password = new JPasswordField();
        //password.setColumns(12);
        
        JLabel user = new JLabel("Username: ",SwingConstants.RIGHT); 
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 
        constraints.gridy = 1; //pe linia 
        constraints.fill = GridBagConstraints.BOTH; 
        constraints.ipadx = 40;
        constraints.ipadx = 40; //il incadrez intr un patrat
        frame.add(user,constraints); //adaug componenta
        //configurez textfiled user
        constraints = new GridBagConstraints();
        constraints.gridx = 2; // pe coloana 
        constraints.gridy = 1; //pe linia 
        constraints.fill = GridBagConstraints.BOTH; 
        constraints.insets = new Insets(5,0,0,50);
        constraints.weightx = 0.5; //ocupa tot, 100%
        frame.add(username,constraints);
       
        //configurez Parola
        JLabel parola = new JLabel("Parola: ",SwingConstants.RIGHT);
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 1
        constraints.gridy = 2; //pe linia 0
        constraints.fill = GridBagConstraints.BOTH; 
        frame.add(parola,constraints); 
        //configurez textfiled parola
        constraints = new GridBagConstraints();
        constraints.gridx = 2; // pe coloana 
        constraints.gridy = 2; //pe linia 
        constraints.fill = GridBagConstraints.BOTH; 
        constraints.insets = new Insets(5,0,0,50);
        frame.add(password,constraints);
        
        JButton buton = new JButton("Login"); 
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 
        constraints.gridy = 3; //pe linia 
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        constraints.ipadx = 40;  //dimensiune
        constraints.ipady = 20;  //dimensiune
        constraints.insets = new Insets(40,0,0,0);  //top padding
        frame.add(buton,constraints); 
        
        DBcontroller.getI();
        
        buton.addActionListener(new AscultatorButon(username,password,buton,frame) );
        //buton.addActionListener(new AscultatorButon(username.getText());
        
        frame.setVisible(true); //ca sa fie vizibila fereastra 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
}
