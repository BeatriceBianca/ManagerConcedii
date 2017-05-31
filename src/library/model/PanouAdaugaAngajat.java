
package library.model;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import library.SolicitAdaugareAngajatCommand;
import library.SolicitConcediuCommand;
import projectpao.AscultatorSeteazaConcediu;
import projectpao.ConnectionController;


public class PanouAdaugaAngajat extends JFrame
{
    
    User user;
    
    public PanouAdaugaAngajat(User user)
    {
        this.user = user;
        
        super.setBounds(480, 230, 300, 350);
        super.setMinimumSize(new Dimension(350, 300));
        setTitle("Panou adaugare angajat");
        setLayout(new GridBagLayout());
        GridBagConstraints constraints;
        
        JLabel nume = new JLabel("Nume: ");
        constraints=new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(nume,constraints);
        
        JTextField nume_ang = new JTextField();
        constraints=new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.ipadx = 80;
        constraints.ipadx = 90;
        add(nume_ang,constraints);
        
        JLabel prenume = new JLabel("Prenume: ");
        constraints=new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(prenume,constraints);
        
        JTextField prenume_ang = new JTextField();
        constraints=new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.ipadx = 80;
        constraints.ipadx = 90;
        add(prenume_ang,constraints);
        
        JLabel username = new JLabel("Username: ");
        constraints=new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(username,constraints);
        
        JTextField username_ang = new JTextField();
        constraints=new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.ipadx = 80;
        constraints.ipadx = 90;
        add(username_ang,constraints);
        
        JLabel parola = new JLabel("Parola: ");
        constraints=new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(parola,constraints);
        
        JPasswordField parola_ang = new JPasswordField();
        constraints=new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.ipadx = 80;
        constraints.ipadx = 90;
        add(parola_ang,constraints);
        
        JButton adauga = new JButton("Adauga");
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.ipadx = 25;  
        constraints.ipady = 10;
        constraints.insets = new Insets(10, 0, 5, 0);
        super.add(adauga,constraints);//ultima linie in pp este 3, deci incep de la gridy =4;
        adauga.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                    
                    if (nume_ang.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Nu ai setat numele!");
                        return;
                    }
                    
                    if (prenume_ang.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Nu ai setat prenumele!");
                        return;
                    }
                
                    if (username_ang.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Nu ai setat username-ul!");
                        return;
                    }
                    
                    if (parola_ang.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Nu ai setat parola!");
                        return;
                    }
                    
                    ConnectionController cc = ConnectionController.getInstance();
                try 
                {
                    cc.getOut().writeObject(new SolicitAdaugareAngajatCommand(nume_ang.getText(), prenume_ang.getText(), username_ang.getText(), parola_ang.getText(), user.id));
                    nume_ang.setText("");
                    prenume_ang.setText("");
                    username_ang.setText("");
                    parola_ang.setText("");
                    JOptionPane.showMessageDialog(null,"Angajat adaugat cu succes!");
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(PanouAdaugaAngajat.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            
        });
        
        setVisible(true);
        
    };
    
}
