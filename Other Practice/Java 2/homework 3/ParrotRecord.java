
/**
 *****************************************************
 File Name: ParrotRecord.Java
 AUTHOR: Matthew Tait 3460396
 Original Date: Feb.20/13 
 Last Edited: Feb.2x/13
 ******************************************************
 Type: Class
 ******************************************************
 PURPOSE: 
         extends the BirdRecord class into a ParrotRecord
 ******************************************************
 Attributes:
            String originalcountry
 ******************************************************
 *Methods
 *          print
 *          compareTo
 ******************************************************
 */
public class ParrotRecord extends BirdRecord 
{
    String originalcountry;
 
    /**
     * Constructor for objects of class ParrotRecord
     */
    public ParrotRecord(String desig, int id, Date[] dates, String[]descript ,Shape birdshape, String origcountry)
    {
     super(desig, id, dates, descript, birdshape);   
     originalcountry = origcountry;
    }
    
    /**
     * returns how many variables are used in the object
     */
    public int varCount()
    {
        super.varCount();
        var = var+1;
        return var;
    }//end varcount
    
    
    public int compareTo(Object x)
    {
       return 0; 
    }
    
    
    public  void print()
    {
        super.print();
        System.out.println("Originally from: " + originalcountry);
        
    }
    

}
