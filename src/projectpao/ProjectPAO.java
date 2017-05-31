
package projectpao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;


public class ProjectPAO 
{

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException 
    {
        
        ConnectionController.getInstance().connect("localhost", 4321);
        
        Login frame = new Login();
        Socket s = new Socket("localhost",4321);
        s.getInputStream();
        s.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        oos.close();
        ois.close();
        frame.setVisible(true);
    }

}
