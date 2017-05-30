/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import library.SolicitListaConcediiAprobate;
import library.model.Concediu;
import library.model.PanouConcediiAprobate;
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
            cc.getOut().flush();
            ArrayList<Concediu> lista = (ArrayList<Concediu>) cc.getIn().readObject();
            
            //if (!lista.isEmpty()) {
                PanouConcediiAprobate pca = new PanouConcediiAprobate(lista);
            //} else {
             //   JOptionPane.showMessageDialog(null,"Nu exista concedii!");
            //}
        } 
        catch ( IOException ex ) 
        {
            //Logger.getLogger(AscultatorVeziConcediiAprobate.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Eroare la AscultatorVeziConcediiAprobate");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AscultatorVeziConcediiAprobate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
    
}
