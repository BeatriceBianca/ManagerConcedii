/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.model;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bogdan-Andrei
 */
public class PanouConcediiAprobate extends JFrame
{
    List<Concediu> list;
    
    public PanouConcediiAprobate(List<Concediu> list)
    {
        this.list = list;
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Start date");
        model.addColumn("End date");
        model.addColumn("Stare");
        JTable table = new JTable(model);
        
        for ( int i = 0; i <= list.size() - 1; i++ ) {
            String stare;
            if (list.get(i).stare == 1)
                stare = "Acceptat";
            else if (list.get(i).stare == -1) 
                stare = "Refuzat";
            else stare = "In asteptare";
            //System.out.println(list.get(i).data_start);
            model.addRow(new Object[]{ list.get(i).data_start.substring(0,10), list.get(i).data_sfarsit.substring(0,10), stare});
    }
         
        //add the table to the frame
        this.add(new JScrollPane(table));
        this.setBounds(450,200,300,350);
        this.setTitle("Concedii");
        setMinimumSize(new Dimension(300, 200)); 
        this.setVisible(true);
        
//        setVisible(true);
    }
    
    
}
