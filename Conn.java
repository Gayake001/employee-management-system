package employee.management.system;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {  // Constructor name should match the class name
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "root");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


