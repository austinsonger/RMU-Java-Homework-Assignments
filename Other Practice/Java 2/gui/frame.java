import javax.swing.JFrame;
import java.awt.*;
/**
 * Write a description of class frame here.
 * 
 * Matt Tait
 * May 19/13
 */


public class frame
{
      
    public static void main(String[] args)
    {
        JFrame window = new JFrame("window");  
        window.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        //frame.getContentPane().add(panel);
        
        window.pack();
        window.setVisible(true);
        
        
    }//end main

}//end class
