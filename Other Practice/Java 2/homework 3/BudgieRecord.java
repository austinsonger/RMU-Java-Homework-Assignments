/**
 *****************************************************
 File Name: BudgieRecord.Java
 AUTHOR: Matthew Tait 3460396
 Original Date: Feb.20/13 
 Last Edited: Feb.2x/13
 ******************************************************
 Type: Class
 ******************************************************
 PURPOSE: 
         extends the BirdRecord class into a BudgieRecord
 ******************************************************
 Attributes:
            String colours
 ******************************************************
 *Methods
 *          print
 *          compareTo
 ******************************************************
 */
public class BudgieRecord extends BirdRecord
{
    String colours;

    /**
     * Constructor for objects of class BudgieRecord
     */
    public BudgieRecord(String desig, int id, Date[] dates, String[]descript ,Shape birdshape, String colours)
    {
        super(desig, id, dates, descript, birdshape); 
        this.colours = colours;
    }//end constructor

    /**
     * returns how many variables are used in the object
     */
    public int varCount()
    {
        super.varCount();  
        var = var+1;
        return var;
    }//end varcount
    
    //prints the current record
    public  void print()
    {
        super.print();
        System.out.println(colours);
        
    }//end print
    
    
    public int compareTo(Object x)
    {
       return 0; 
    }//end compareTo
}//end class
