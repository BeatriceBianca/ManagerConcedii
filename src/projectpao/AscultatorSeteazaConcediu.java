
package projectpao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import library.SolicitListaCereri;
import library.model.Cerere;
import library.model.PanouListaCereri;
import library.model.User;

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
            cc.getOut().flush();
            ArrayList<Cerere> lista = (ArrayList<Cerere>) cc.getIn().readObject();
            
            if (!lista.isEmpty()) 
            {
                PanouListaCereri pca = new PanouListaCereri(lista);
            } 
            else 
            {
                JOptionPane.showMessageDialog(null,"Nu exista concedii!");
            }
        }
        catch(NullPointerException ef)
        {
            
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
