
/**
 *****************************************************
 File Name: CatRecord.Java
 AUTHOR: Matthew Tait 3460396
 Original Date: Feb.20/13 
 Last Edited: Feb.21/13
 ******************************************************
 Type: Class
 ******************************************************
 PURPOSE: extends the record class to inherit its
          methods
 
 ******************************************************
 Attributes:
            boolean gender
            boolean declawed

 ******************************************************
 *Methods:
 *        setGender
 *        getGender
 *        setDeclawed
 *        getDeclawed
 *        varCount
 *        print
 *        compareTo
 *          
 ******************************************************
 */
public class CatRecord extends MammalRecord
{
    boolean gender;
    boolean declawed;
    
    /**
     * Constructor for objects of class CatRecord
     */
    public CatRecord(String desig, int id, Date[] dates, String[]descript, Date birthdate)
    {
       super(desig, id, dates, descript, birthdate);
       
    }//end constructor

    public void setGender(char x)
    {
        char gen;
        gen = Character.toUpperCase(x);
        
        if (gen=='F')
        {
            gender = false;
        }//end if
        else
        {
            gender = true;
        }//end else
    }//end setGender
    
    public boolean getGender()
    {
        return gender;
    }//end getGender
    
    public void setDeclawed(char x)
    {
        char claw;
        claw = Character.toUpperCase(x);
        
        if (claw=='N')
        {
            declawed = false;
        }
        else
        {
            declawed = true;
        }
    }//end setDeclawed
    
    public boolean getDeclawed()
    {
        return declawed;
    }
    
    
    public int varCount()
    {
        super.varCount();  
        var = var+2;
        return var;
    }//end varcount
    
    
    
     public void print()
    {
        
        super.print();
        if (declawed == true)
        {
            System.out.println("not declawed");
        }//end if   
        else
        {
           System.out.println("declawed"); 
        }//end else
        
        if (gender == true)
        {
            System.out.println("male");
        }//end if   
        else
        {
           System.out.println("female"); 
        }//end else
    }//end print
    
    
    public int compareTo(Object x)
    {
       return 0; 
    }//end compareTo
}
