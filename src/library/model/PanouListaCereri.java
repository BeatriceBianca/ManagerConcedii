/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class PanouListaCereri extends JFrame
{
    List<Cerere> list;

    public PanouListaCereri(List<Cerere> lista) 
    {
        this.list = lista;
        this.setTitle("Lista cereri");
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Concediu");
        model.addColumn("Nume");
        model.addColumn("Prenume");
        model.addColumn("Start date");
        model.addColumn("End date");
        JTable table = new JTable(model);
        
        System.out.println(list.size());
        
        for ( int i = 0; i < list.size(); i++ )
            model.addRow(new Object[]{ list.get(i).concediu_id, 
                                       list.get(i).nume,
                                       list.get(i).prenume,
                                       list.get(i).start.substring(0,10),
                                       list.get(i).end.substring(0,10)
                                    });
          
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints constraints;
        
        constraints = new GridBagConstraints();
        constraints.gridy = 0; 
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        add(table, constraints);
        
        JLabel cod = new JLabel("Id concediu:");
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 1; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 40;
        constraints.ipadx = 40; //il incadrez intr un patrat
        constraints.insets = new Insets(10, 0, 5, 0);
        this.add(cod, constraints);
        
        JTextField cod_concediu = new JTextField();
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 
        constraints.gridy = 1; //pe linia 
        constraints.ipadx = 35;  //dimensiune
        constraints.insets = new Insets(10, 0, 5, 0);
        add(cod_concediu, constraints);
        
        
        JRadioButton acceptButton = new JRadioButton("Accepta");
        acceptButton.setSelected(true);
       
        JRadioButton refuseButton = new JRadioButton("Refuza");
        refuseButton.setSelected(true);
        
        ButtonGroup group = new ButtonGroup();
        group.add(acceptButton);
        group.add(refuseButton);
        
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 2; //pe linia 
        constraints.insets = new Insets(10, 0, 5, 0);
        add(acceptButton, constraints);
        
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 
        constraints.gridy = 2; //pe linia 
        constraints.insets = new Insets(10, 0, 5, 0);
        add(refuseButton, constraints);
        
        JButton submit = new JButton("Submit");
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 3; //pe linia
//        constraints.ipadx = 15;  //dimensiune
//        constraints.ipady = 10;  //dimensiune
        this.add(submit, constraints);
        
        this.setBounds(470, 220, 460, 350);
        this.setMinimumSize(new Dimension(350, 300));
        
        this.setVisible(true);
    }
    
}
