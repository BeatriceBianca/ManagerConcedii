
package library.model;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import projectpao.AscultatorSeteazaConcediu;


public class PanouPrincipalM extends PanouPrincipal
{
    
    public PanouPrincipalM(User user) 
    {
        super(user);
        
        JButton buton3 = new JButton("Vezi concedii solicitate!");
        GridBagConstraints constraints;
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.ipadx = 45; 
        constraints.ipady = 20;
        constraints.insets = new Insets(10, 0, 5, 0);
        super.add(buton3,constraints);
        buton3.addActionListener(new AscultatorSeteazaConcediu(user));
        
        JButton buton4 = new JButton("Adauga angajati!");
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.ipadx = 85; 
        constraints.ipady = 20;
        constraints.insets = new Insets(10, 0, 5, 0);
        super.add(buton4,constraints);
        buton4.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                PanouAdaugaAngajat paa = new PanouAdaugaAngajat(user);
            }
            
        });
    }
    
}
