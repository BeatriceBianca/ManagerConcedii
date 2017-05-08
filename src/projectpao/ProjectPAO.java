/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpao;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import library.LogCommand;
import library.model.User;

/**
 *
 * @author Bogdan-Andrei
 */
public class ProjectPAO {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        
        ConnectionController.getInstance().connect("localhost", 4321);
        
        Login frame = new Login();
        Socket s = new Socket("localhost",4321);
        s.getInputStream();
        s.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        LogCommand logc = new LogCommand();
        oos.writeObject(logc);
        User nume = (User)ois.readObject();
        //System.out.print(nume);
        
        //buton.addActionListener(new AscultatorButon(username.getText());
        frame.setVisible(true); //ca sa fie vizibila fereastra 
    }

}
