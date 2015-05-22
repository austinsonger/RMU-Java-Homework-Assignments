import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Graphical {
    public static void main(String[] args) {
        String firstName;
        String lastName;
        // Get First Name
        firstName = JOptionPane.showInputDialog ("Enter your first Name");
        lastName = JOptionPane.showInputDialog ("Enter your last Name");
        //Display Message
        JOptionPane.showMessageDialog(null, " See You Next Lab "+
                firstName + " " + lastName );
}  
} 
