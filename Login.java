
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField tfusername;
    JPasswordField tfpassword; // Using JPasswordField for password input
    JButton login;

    Login() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(40, 20, 100, 30);
    add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password:");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);

        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            String password = new String(tfpassword.getPassword()); // Retrieve password securely

            Conn c = new Conn(); // Initialize connection to the database

            String query = "SELECT * FROM login WHERE username = ? AND password = ?";
            PreparedStatement ps = c.c.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                setVisible(false); // Close login window
                new Home(); // Redirect to the Home screen
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
