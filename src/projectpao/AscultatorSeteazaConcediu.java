/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import library.SolicitListaCereri;
import library.model.Cerere;
import library.model.PanouListaCereri;
import library.model.User;

/**
 *
 * @author Bogdan-Andrei
 */
public class AscultatorSeteazaConcediu implements ActionListener
{
    User user;
    
    public AscultatorSeteazaConcediu(User user)
    {
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        try
        {
            ConnectionController cc = ConnectionController.getInstance();
            cc.getOut().writeObject(new SolicitListaCereri(this.user)); //this.user
            
            List<Cerere> lista = (List<Cerere>) cc.getIn().readObject();
            
            if (!lista.isEmpty()) 
            {
                PanouListaCereri pca = new PanouListaCereri(lista);
            } 
            else 
            {
                JOptionPane.showMessageDialog(null,"Nu exista concedii!");
            }
        }
        catch(IOException e)
        {
            
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(AscultatorSeteazaConcediu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
