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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import projectpao.AscultatorButon;
import projectpao.AscultatorButonTrimiteSolicitare;

public class PanouSolicitaConcediu extends JFrame
{
    JTextField zi_start = new JTextField();
    JTextField zi_sfarsit = new JTextField();
    JComboBox luna_start = new JComboBox();
    JComboBox luna_sfarsit = new JComboBox();
    JTextField v[] = new JTextField[10];
    JLabel w[] = new JLabel[10];
    User user = new User();
    
    public PanouSolicitaConcediu(User user)
    {
        this.user = user;
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
        
        
        w[0] = new JLabel("Data start:");
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 1; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 40;
        constraints.ipadx = 40; //il incadrez intr un patrat
        super.add(w[0], constraints); //adaug componenta
        //configurez textfiled
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 
        constraints.gridy = 1; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.1; //ocupa tot, 100%
        super.add(zi_start, constraints);
        
        
        String[] months = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };

        luna_start = new JComboBox(months);
        constraints = new GridBagConstraints();
        constraints.gridx = 2; // pe coloana 
        constraints.gridy = 1; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.1; //ocupa tot, 100%
        super.add(luna_start, constraints);
       
        
        w[1] = new JLabel("Data sfarsit:");
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 2; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 40;
        constraints.ipadx = 40; //il incadrez intr un patrat
        super.add(w[1], constraints); //adaug componenta
        //configurez textfiled 
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 
        constraints.gridy = 2; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.1; //ocupa tot, 100%
        super.add(zi_sfarsit, constraints);
     
        
        luna_sfarsit = new JComboBox(months);
        constraints = new GridBagConstraints();
        constraints.gridx = 2; // pe coloana 
        constraints.gridy = 2; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.1; //ocupa tot, 100%
        super.add(luna_sfarsit, constraints); //adaug componenta
        
        
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
        
        buton.addActionListener(new AscultatorButonTrimiteSolicitare(zi_start, luna_start,
                zi_sfarsit, luna_sfarsit, user));
        
        setVisible(true);
    }
}
