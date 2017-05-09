/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import library.LogCommand;
import library.SolicitListaConcediiAprobate;
import library.model.Concediu;
import library.model.PanouConcediiAprobate;
import library.model.PanouPrincipal;
import library.model.User;

public class AscultatorVeziConcediiAprobate implements ActionListener
{
    User user;

    public AscultatorVeziConcediiAprobate(User user) 
    {
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        //to do
        
        try
        {
            
            ConnectionController cc = ConnectionController.getInstance(); //?
            cc.getOut().writeObject(new SolicitListaConcediiAprobate(this.user));
            
            LinkedList<Concediu> lista_con = (LinkedList<Concediu>) cc.getIn().readObject();
            
            if( lista_con != null )
            {
                System.out.print("a intrat SI aici!");
                //JOptionPane.showMessageDialog(null,"Felicitari : "+user.username+", ai reusit sa te loghezi!");
                PanouConcediiAprobate pca = new PanouConcediiAprobate(user);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Nu exista concedii!");
            }
        }
        catch(IOException | ClassNotFoundException e)
        {
            System.out.print("EXCEPTIE"+e);
        }
        
    }
    
}
