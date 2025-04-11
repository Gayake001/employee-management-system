package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    JButton view, add, update, remove;

    Home() {
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(40, 0, 1020, 630);
        add(imageLabel);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(650, 20, 400, 40);
        heading.setFont(new Font("Serif", Font.BOLD, 25));
        imageLabel.add(heading);

        add = new JButton("Add Employee");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        imageLabel.add(add);

        view = new JButton("View Employees");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        imageLabel.add(view);

        update = new JButton("Update Employee");
        update.setBounds(650, 140, 150, 40);
        update.addActionListener(this);
        imageLabel.add(update);

        remove = new JButton("Remove Employee");
        remove.setBounds(820, 140, 150, 40);
        remove.addActionListener(this);
        imageLabel.add(remove);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
            JOptionPane.showMessageDialog(null, "Add Employee clicked");
        } else if (ae.getSource() == view) {
            JOptionPane.showMessageDialog(null, "View Employee clicked");
        } else if (ae.getSource() == update) {
            JOptionPane.showMessageDialog(null, "Update Employee clicked");
        } else if (ae.getSource() == remove) {
            JOptionPane.showMessageDialog(null, "Remove Employee clicked");
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
