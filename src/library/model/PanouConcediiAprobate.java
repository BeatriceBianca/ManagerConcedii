/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.model;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;
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
    //List<Concediu> list;
    
    public PanouConcediiAprobate(ArrayList<Concediu> list)
    {
        //this.list = list;
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Start date");
        model.addColumn("End date");
        model.addColumn("Stare");
        JTable table = new JTable(model);
        try
        {
        for ( int i = 0; i < list.size(); i++ ) {
            String star;
            if (list.get(i).stare == 1)
                star = "Acceptat";
            else if (list.get(i).stare == -1) 
                star = "Refuzat";
            else star = "In asteptare";
            model.addRow(new Object[]{ list.get(i).data_start.substring(0,10), list.get(i).data_sfarsit.substring(0,10), star});
    }
         
        //add the table to the frame
        this.add(new JScrollPane(table));
        this.setBounds(450,200,300,350);
        this.setTitle("Concedii");
        this.setMinimumSize(new Dimension(300, 200)); 
        this.setVisible(true);
        
//        setVisible(true);
        }
        catch(NullPointerException e )
        {
            System.out.println("NULL POINTER EXCEPTION IN PCA");
        }
        catch(ClassCastException e)
        {
            System.out.println("Class cast  EXCEPTION IN PCA");
        }
    }
    
    
}
