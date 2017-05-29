package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.Command;

public class ClientConnection implements Runnable {

    private final Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public ClientConnection(Socket socket) {
        this.socket = socket;
        try {
            this.in = new ObjectInputStream(socket.getInputStream());
            this.out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Command c = (Command) this.in.readObject();
                Object result = c.execute();
                this.out.writeObject(result);
            }
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                this.socket.close();
            } catch (IOException e) {
            }
        }
    }
}
