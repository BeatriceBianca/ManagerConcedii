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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class PanouListaCereri extends JFrame
{
    List<Cerere> list;
    //public ButtonColumn [] accept;
    //public JButton [] refuz;
    JTextField cod_concediu;
    JButton buton_ok;

    public PanouListaCereri(List<Cerere> lista) 
    {
        this.list = lista;
       // JFrame frame = new JFrame();
        this.setTitle("Lista cereri");
        
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Concediu");
        model.addColumn("Nume");
        model.addColumn("Prenume");
        model.addColumn("Start date");
        model.addColumn("End date");
        model.addColumn("Accepta");
        //model.addColumn("Accept");
        //model.addColumn("Refuz");
        JTable table = new JTable(model);
        
        System.out.println(list.size());
        /*accept = new JButton[list.size()];
        refuz = new JButton[list.size()];
        for(int i=0; i< 4; i++)
        {
            accept[i].setText("Accept");
            refuz[i] = new JButton("Refuz");
        }*/
        GridBagConstraints constraints;
        constraints = new GridBagConstraints();
        JButton accept = new JButton("accept");
        constraints.ipadx = 30;  //dimensiune
        constraints.ipady = 20;  //dimensiune
        super.add(accept, constraints);
        
        for ( int i = 0; i < list.size(); i++ )
            model.addRow(new Object[]{ list.get(i).concediu_id, 
                                       list.get(i).nume,
                                       list.get(i).prenume,
                                       list.get(i).start.substring(0,10),
                                       list.get(i).end.substring(0,10),
                                       accept
                                    });
          
        
        this.add(new JScrollPane(table));
//        cod_concediu = new JTextField("Salut");
//        buton_ok = new JButton("Seteaza");
        //this.setLayout(new GridBagLayout());
        //GridBagConstraints constraints;
        //constraints = new GridBagConstraints();
//        this.add(cod_concediu,BorderLayout.SOUTH);
        //constraints.gridy =1;
        //this.add(buton_ok,constraints);
        this.setBounds(470, 220, 460, 350);
        this.setMinimumSize(new Dimension(350, 300));
        //this.setLayout(new GridBagLayout());
       /*GridBagConstraints constraints;
        constraints = new GridBagConstraints();
        */
        
        this.setVisible(true);
    }
    
}
