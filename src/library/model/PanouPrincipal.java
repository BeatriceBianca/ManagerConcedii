
package library.model;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import projectpao.AscultatorButon;
import projectpao.AscultatorSolicitaConcediu;
import projectpao.AscultatorVeziConcediiAprobate;


public class PanouPrincipal extends JFrame
{
    private User user;
    
    public PanouPrincipal(User user) 
    {
        this.user = user;
        setTitle("Panou principal");
        JLabel nume = new JLabel("Nume utilizator: "+user.nume+" "+user.prenume+" ");
        JLabel zile_concediu = new JLabel ("Zile concediu ramase: "+user.zile_concediu_ramase);
        super.setBounds(450, 200, 300, 350);
        super.setMinimumSize(new Dimension(350, 300));
;
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints constraints;
        
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 0; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        add(nume, constraints); //adaug componenta
        
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 1; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        add(zile_concediu, constraints); //adaug componenta

        
        JButton buton1 = new JButton("Solicita concediu!");
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 2; //pe linia 
        constraints.ipadx = 30;  //dimensiune
        constraints.ipady = 20;  //dimensiune
        constraints.insets = new Insets(10, 0, 5, 0);
        super.add(buton1, constraints);
        
        JButton buton2 = new JButton("Vezi concedii!");
        constraints.gridx = 0; // pe coloana 
        constraints.gridy = 3; //pe linia 
        constraints.ipadx = 30;  //dimensiune
        constraints.ipady = 20;  //dimensiune
        constraints.insets = new Insets(10, 0, 5, 0);
        super.add(buton2, constraints);
        
        buton1.addActionListener(new AscultatorSolicitaConcediu(user));
        buton2.addActionListener(new AscultatorVeziConcediiAprobate(user));
        
        setVisible(true);
    }
    
}
