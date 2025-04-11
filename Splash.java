package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // Import for Color and Font

public class Splash extends JFrame implements ActionListener {

    Splash() {
       
        getContentPane().setBackground(Color.white);
        setLayout(null);

        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");

        heading.setBounds(80, 30, 1200, 60);

        heading.setFont(new Font("Serif", Font.PLAIN, 60));

     
        add(heading);

      
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));

       
        JLabel imageLabel = new JLabel(imageIcon);

        imageLabel.setBounds(50, 100, 1050, 500);  
        add(imageLabel);

        JButton clickHere = new JButton("CLICK HERE TO CONTINUE");
        clickHere.setBounds(400, 400, 300, 70);
        clickHere.setBackground(Color.BLACK);
        clickHere.setForeground(Color.WHITE);
        clickHere.addActionListener(this);

        add(clickHere);
        setSize(1170, 650);

        setVisible(true);
        setLocation(200, 50);

        Timer timer = new Timer(500, e -> heading.setVisible(!heading.isVisible()));
        timer.start();
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();  
    }

    public static void main(String[] args) {
        new Splash();  
    }
}
