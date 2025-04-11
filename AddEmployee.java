package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tfname, tffname, tfaddress, tfphone, tfaadhar, tfEmail, tfsalary, tfDesignation;
    JDateChooser dcdob;
    JComboBox<String> cbeducation;
    JLabel labelempId;
    JButton add, back;

    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        JLabel labefname = new JLabel("Father's Name");
        labefname.setBounds(400, 150, 150, 30);
        labefname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labefname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        JLabel labedob = new JLabel("Date of Birth");
        labedob.setBounds(50, 200, 150, 30);
        labedob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labedob);

        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);

        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);

        JLabel labeaddress = new JLabel("Address");
        labeaddress.setBounds(50, 250, 150, 30);
        labeaddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeaddress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel labefphone = new JLabel("Mobile Number");
        labefphone.setBounds(400, 250, 150, 30);
        labefphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labefphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel labeemail = new JLabel("Email Address");
        labeemail.setBounds(50, 300, 150, 30);
        labeemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeemail);

        tfEmail = new JTextField();
        tfEmail.setBounds(200, 300, 150, 30);
        add(tfEmail);

        JLabel labeeducation = new JLabel("Highest Education");
        labeeducation.setBounds(400, 300, 150, 30);
        labeeducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeeducation);

        String[] courses = {"B.TECH", "BSC", "BCA", "M.TECH", "MBA", "M.COM", "B.COM"};
        cbeducation = new JComboBox<>(courses);
        cbeducation.setBackground(Color.white);
        cbeducation.setBounds(600, 300, 150, 30);
        add(cbeducation);

        JLabel labeDesignation = new JLabel("Designation");
        labeDesignation.setBounds(50, 350, 150, 30);
        labeDesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeDesignation);

        tfDesignation = new JTextField();
        tfDesignation.setBounds(200, 350, 150, 30);
        add(tfDesignation);

        JLabel labeaadhar = new JLabel("Aadhar Number");
        labeaadhar.setBounds(400, 350, 150, 30);
        labeaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);

        JLabel labelempid = new JLabel("Employee Id");
        labelempid.setBounds(50, 400, 150, 30);
        labelempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempid);

        labelempId = new JLabel("" + number);
        labelempId.setBounds(200, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);

        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);

        setSize(900, 700);
        setLocation(30, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfEmail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfDesignation.getText();
            String aadhar = tfaadhar.getText();
            String empId = labelempId.getText();

            try {
                Conn conn = new Conn();
                String query = "INSERT INTO employee (name, fname, dob, salary, address, phone, email, education, designation, aadhar, empId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.c.prepareStatement(query);
                pstmt.setString(1, name);
                pstmt.setString(2, fname);
                pstmt.setString(3, dob);
                pstmt.setString(4, salary);
                pstmt.setString(5, address);
                pstmt.setString(6, phone);
                pstmt.setString(7, email);
                pstmt.setString(8, education);
                pstmt.setString(9, designation);
                pstmt.setString(10, aadhar);
                pstmt.setString(11, empId);

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Detail Added Successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
