/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.model;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Bogdan-Andrei
 */
public class PanouPrincipal extends JFrame
{
    private User user;
    

    public PanouPrincipal(User user) 
    {
        this.user = user;
        super.setTitle("Panou principal");
        JLabel nume = new JLabel("Nume utilizator: "+user.username);
        super.setBounds(450, 200, 300, 350);
        add(nume);
        //super.pack();
        //super.setLocationRelativeTo(null);
        super.setLayout(new GridBagLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints constraints;
        JButton buton = new JButton("Solicita concediu!");
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 
        constraints.gridy = 1; //pe linia 
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.ipadx = 40;  //dimensiune
        constraints.ipady = 20;  //dimensiune
        super.add(buton, constraints);
        super.setVisible(true);
    }
    
}
