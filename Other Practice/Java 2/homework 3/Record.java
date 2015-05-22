 import java.util.Scanner;
 
/**
 * Record.Java
 * author Matthew Tait 3460396 
 * created Feb.17/13
 * last edited: Feb.20/13
 ************************************* 
 * Type: Class
 *************************************
 * Purpose
 * 
 *************************************
 * Attributes
 * String name
 * int fileID
 * Date[] ptdates
 * String[] ptdescript
 * int var
 *************************************
 *Methods
 *        print
 *        varCount
 *        addTreatment
 *************************************
*/

public abstract class Record implements Printable, Comparable
{
       private String name;
       private String fileID;
       private Date[] ptdates;
       private String[] ptdescript;
       int var;

    /**
     * Constructor for objects of class Record
     */
    public Record(String desig, int id, Date[] dates, String[]descript)
    {
        name = desig;
        fileID= ("" + 10001 + "" + id);
        ptdates = dates;
        ptdescript = descript;
    
    }//end constructor

    /**
     * prints out what is contained in the Record object
     */
    public void print()
    {
        System.out.println("Name: " + name);
        System.out.println("ID #: " + fileID);
        System.out.println("Past treatments:");
            for(int i=0; i<ptdates.length; i++) 
            {
            System.out.println(ptdates[i] + ": " + (ptdescript[i]));    
            }//end for
      
    }//end print
    
    /**
     * returns how many variables are used in the object
     */
    public int varCount()
    {
        var = 4;  
        return var;
    }//end varcount
    
    /**
     * when needed, will add another treatment time to the array of previous treatment dates
     * will also prompt user to enter a description of the treatment.
     * the array of descriptions will never exceed the array of times.
     */
    public void addTreatment()
    {
        for(int i=ptdates.length; i<ptdates.length; i++)
        {
           
           
           Scanner key = new Scanner(System.in);
           System.out.println("enter a description for today's treatment: ");
           ptdescript[i] = key.nextLine();
        }
    }//end addTreatment
  
}//end class
