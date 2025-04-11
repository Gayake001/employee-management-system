package employee.management.system;
import java.awt.*;
import javax.swing.*;


     
public class ViewEmployee extends JFrame {
    JTable table;
    ViewEmployee() {
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        table= new JTable();
        try{
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);

}   
    
    public static void main(String [] args){
        new ViewEmployee();
    }
    
}
