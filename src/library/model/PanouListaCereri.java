
package library.model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import library.SolicitAprobareCommand;
import projectpao.ConnectionController;


public class PanouListaCereri extends JFrame
{
    ArrayList<Cerere> list;

    public PanouListaCereri(ArrayList<Cerere> lista) 
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
        
        try{
            
        for ( int i = 0; i < list.size(); i++ )
            model.addRow(new Object[]{ list.get(i).concediu_id, 
                                       list.get(i).nume,
                                       list.get(i).prenume,
                                       list.get(i).start.substring(0,10),
                                       list.get(i).end.substring(0,10)
                                    });
        
        setLayout(new GridBagLayout());
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
        constraints.ipadx = 40; 
        constraints.insets = new Insets(10, 0, 5, 0);
        this.add(cod, constraints);
        
        JTextField cod_concediu = new JTextField();
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 
        constraints.gridy = 1; //pe linia 
        constraints.ipadx = 35; 
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
        this.add(submit, constraints);
        
        this.setBounds(520, 270, 510, 400);
        this.setMinimumSize(new Dimension(350, 300));
        this.setVisible(true);
        
        submit.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String cod_con = cod_concediu.getText();
                int response = 1;
                if (acceptButton.isSelected())
                    response = 1;
                if (refuseButton.isSelected())
                    response = -1;
                
                if (cod_con.equals("")){
                    JOptionPane.showMessageDialog(null,"Nu ai ales id-ul concediului!");
                    //return;
                } else {
                    try 
                    {
                        int id = Integer.parseInt(cod_con);
                        
                        boolean existaCerere = false;
                        for (Cerere c: list) {
                            if (c.concediu_id == id){
                                existaCerere = true;
                                break;
                            }
                        }

                        if (!existaCerere){
                            JOptionPane.showMessageDialog(null,"Nu exista cerere cu acest id!");
                        } else {
                            ConnectionController cc = ConnectionController.getInstance();
                            try {
                                cc.getOut().writeObject(new SolicitAprobareCommand(id,response));
                                JOptionPane.showMessageDialog(null,"Solicitare modificata cu succes!");
                                
                            } catch (IOException ex) {
                                Logger.getLogger(PanouListaCereri.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } catch(Exception ex) {
                        JOptionPane.showMessageDialog(null,"Format id gresit!");
                        //return;
                    }
                }
            }
        });
        
        
        }
        catch(ClassCastException e)
        {
            
        }
    }
    
}
