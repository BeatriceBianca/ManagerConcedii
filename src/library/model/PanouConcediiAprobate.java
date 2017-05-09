/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.model;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import projectpao.AscultatorSolicitaConcediu;

/**
 *
 * @author Bogdan-Andrei
 */
public class PanouConcediiAprobate extends JFrame
{
    User user;
    
    public PanouConcediiAprobate(User user)
    {
        
        super("Concedii aprobate");
        this.user = user;
        setBounds(450, 200, 300, 350); 
        setMinimumSize(new Dimension(300, 200)); 
        setLayout(new GridBagLayout());
        JLabel lista = new JLabel("Ai intrat aici");
        setVisible(true);

    }
    
    
}
