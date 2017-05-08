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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import projectpao.AscultatorButon;
import projectpao.AscultatorButonTrimiteSolicitare;

/**
 *
 * @author Bogdan-Andrei
 */
public class PanouSolicitaConcediu extends JFrame
{
    JTextField zi_start = new JTextField();
    JTextField luna_start = new JTextField();
    JTextField an_start = new JTextField();
    JTextField zi_sfarsit = new JTextField();
    JTextField luna_sfarsit = new JTextField();
    JTextField an_sfarsit = new JTextField();
    JTextField v[] = new JTextField[10];
    JLabel w[] = new JLabel[10];
    
    public PanouSolicitaConcediu(User user)
    {
        super.setBounds(480, 230, 300, 350);
        super.setMinimumSize(new Dimension(350, 300));
        setTitle("Panou solicita concediu");
        setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();
        JLabel nume = new JLabel("Nume utilizator: "+user.nume+" "+user.prenume+" ");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        add(nume,constraints);
        
        constraints = new GridBagConstraints();
        JLabel data_start = new JLabel ("Data start:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;
        add(data_start,constraints);
        
        w[0] = new JLabel("Zi:");
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 2; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 40;
        constraints.ipadx = 40; //il incadrez intr un patrat
        super.add(w[0], constraints); //adaug componenta
        //configurez textfiled
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 
        constraints.gridy = 2; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(2, 0, 0, 130);
        constraints.weightx = 0.5; //ocupa tot, 100%
        super.add(zi_start, constraints);
        
        w[1] = new JLabel("Luna:");
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 3; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 40;
        constraints.ipadx = 40; //il incadrez intr un patrat
        super.add(w[1], constraints); //adaug componenta
        //
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 
        constraints.gridy = 3; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(2, 0, 0, 130);
        constraints.weightx = 0.5; //ocupa tot, 100%
        super.add(luna_start, constraints);
        
        w[2] = new JLabel("An:");
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 4; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 40;
        constraints.ipadx = 40; //il incadrez intr un patrat
        super.add(w[2], constraints); //adaug componenta
        //configurez textfiled 
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 
        constraints.gridy = 4; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(2, 0, 0, 130);
        constraints.weightx = 0.5; //ocupa tot, 100%
        super.add(an_start, constraints);
        
        constraints = new GridBagConstraints();
        JLabel data_sf = new JLabel ("Data sfarsit:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.fill = GridBagConstraints.BOTH;
        add(data_sf,constraints);
        
        w[3] = new JLabel("Zi:");
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 6; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 40;
        constraints.ipadx = 40; //il incadrez intr un patrat
        super.add(w[3], constraints); //adaug componenta
        //configurez textfiled 
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 
        constraints.gridy = 6; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(2, 0, 0, 130);
        constraints.weightx = 0.5; //ocupa tot, 100%
        super.add(zi_sfarsit, constraints);
        
        w[4] = new JLabel("Luna:");
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 7; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 40;
        constraints.ipadx = 40; //il incadrez intr un patrat
        super.add(w[4], constraints); //adaug componenta
        //configurez textfiled 
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 
        constraints.gridy = 7; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(2, 0, 0, 130);
        constraints.weightx = 0.5; //ocupa tot, 100%
        super.add(luna_sfarsit, constraints);
        
        w[5] = new JLabel("An:");
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 8; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 40;
        constraints.ipadx = 40; //il incadrez intr un patrat
        super.add(w[5], constraints); //adaug componenta
        //configurez textfiled 
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 
        constraints.gridy = 8; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(2, 0, 0, 130);
        constraints.weightx = 0.5; //ocupa tot, 100%
        super.add(an_sfarsit, constraints);
        
        JButton buton = new JButton("Trimite");
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 9; //pe linia 
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        constraints.ipadx = 40;  //dimensiune
        constraints.ipady = 20;  //dimensiune
        constraints.insets = new Insets(40, 0, 0, 0);  //top padding
        add(buton, constraints);
        buton.addActionListener(new AscultatorButonTrimiteSolicitare(zi_start,
                luna_start,an_start,zi_sfarsit,luna_sfarsit,an_sfarsit,user));
        
        setVisible(true);
    }
}
