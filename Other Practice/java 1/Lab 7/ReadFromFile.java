import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;
public class ReadFromFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)   throws FileNotFoundException {
      //create input optionpane
		String filename;
		filename = JOptionPane.showInputDialog("Enter a file name:");
				  
				  
         //OPEN the FILE selected by user FOR READING  4 integers
         File myfile = new File(filename);
         Scanner nextinputfile = new Scanner(myfile);

          int sum = 0;
			 int numb;
         for (int i =1; i<=4; i++)
         {
              numb = nextinputfile.nextInt();
              sum = sum + numb;
              
         }//end for
			//display result in optionpane
        JOptionPane.showMessageDialog (null ,"The summation is: "+sum);
		          
		 nextinputfile.close();  // Close file

    }//end main
  }//end class
