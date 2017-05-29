/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.model;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import projectpao.AscultatorSeteazaConcediu;

/**
 *
 * @author Bogdan-Andrei
 */
public class PanouPrincipalM extends PanouPrincipal
{
    
    public PanouPrincipalM(User user) 
    {
        super(user);
        JButton buton3 = new JButton("Vezi concedii solicitate!");
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.ipadx = 45;  //dimensiune
        constraints.ipady = 20;
        constraints.insets = new Insets(10, 0, 5, 0);
        super.add(buton3,constraints);//ultima linie in pp este 3, deci incep de la gridy =4;
        buton3.addActionListener(new AscultatorSeteazaConcediu(user));
    }
    
}