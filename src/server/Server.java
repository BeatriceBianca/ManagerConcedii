package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    public static void main(String[] args) {
        DBcontroller.getI();

        try {
            ServerSocket ss = new ServerSocket(4321);
            while (true) {
                Socket s = ss.accept();
                ClientConnection cc = new ClientConnection(s);
                new Thread(cc).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
