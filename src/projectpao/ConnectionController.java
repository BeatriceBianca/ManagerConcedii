
package projectpao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionController {

    private static final ConnectionController instance = new ConnectionController();
    Socket s;
    ObjectOutputStream out;
    ObjectInputStream in;

    private ConnectionController() {
    }

    public void connect(String ip, int port) {
        try 
        {
            this.s = new Socket(ip, 4321);
            this.out = new ObjectOutputStream(s.getOutputStream());
            out.flush();
            this.in = new ObjectInputStream(s.getInputStream());
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public static ConnectionController getInstance() {
        return instance;
    }
}
