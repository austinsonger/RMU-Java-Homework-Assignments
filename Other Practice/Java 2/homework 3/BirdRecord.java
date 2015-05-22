
/**
 *****************************************************
 File Name: BirdRecord.Java
 AUTHOR: Matthew Tait 3460396
 Original Date: Feb.19/13 
 Last Edited: Feb.20/13
 ******************************************************
 Type: Class
 ******************************************************
 PURPOSE: extends the record class to inherit its
          methods
 
 ******************************************************
 Attributes:
            Shape bird
 ******************************************************
 *Methods:
 *          print()
 ******************************************************
 */
public abstract class BirdRecord extends Record
{
    
    private Shape birdshape;
     

    /**
     * Constructor for objects of class BirdRecord
     */
    public BirdRecord(String desig, int id, Date[] dates, String[]descript ,Shape birdshape)
    {
      super(desig, id, dates, descript);
      this.birdshape = birdshape;
    
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
    
    public void print()
    {
        super.print();
        System.out.println(birdshape);
    }
}
