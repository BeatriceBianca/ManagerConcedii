/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.model;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import projectpao.AscultatorButon;
import projectpao.AscultatorSolicitaConcediu;

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
        setTitle("Panou principal");
        JLabel nume = new JLabel("Nume utilizator: "+user.nume+" "+user.prenume+" ");
        JLabel zile_concediu = new JLabel ("Zile concediu ramase: "+user.zile_concediu_ramase);
        super.setBounds(450, 200, 300, 350);
        super.setMinimumSize(new Dimension(350, 300));
        //add(nume);
        //add(zile_concediu);
        //super.pack();
        //super.setLocationRelativeTo();
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints constraints;
        
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 0; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        //constraints.insets = new Insets(-100, -50, 0, 0);
        add(nume, constraints); //adaug componenta
        
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 1; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        //constraints.ipadx = 40;
        //constraints.ipadx = 40; //il incadrez intr un patrat
        add(zile_concediu, constraints); //adaug componenta

        
        JButton buton1 = new JButton("Solicita concediu!");
        //constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 2; //pe linia 
        constraints.ipadx = 30;  //dimensiune
        constraints.ipady = 20;  //dimensiune
        constraints.insets = new Insets(5, 0, 5, 0);
        super.add(buton1, constraints);
        
        JButton buton2 = new JButton("Vezi concedii aprobate!");
        //constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 3; //pe linia 
        constraints.ipadx = 30;  //dimensiune
        constraints.ipady = 20;  //dimensiune
        constraints.insets = new Insets(5, 0, 5, 0);
        super.add(buton2, constraints);
        
        JButton buton3 = new JButton("Vezi concedii in asteptare!");
        //constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 4; //pe linia 
        constraints.ipadx = 30;  //dimensiune
        constraints.ipady = 20;  //dimensiune
        constraints.insets = new Insets(5, 0, 5, 0);
        super.add(buton3, constraints);
        
        buton1.addActionListener(new AscultatorSolicitaConcediu(user));
        
        setVisible(true);
    }
    
}
