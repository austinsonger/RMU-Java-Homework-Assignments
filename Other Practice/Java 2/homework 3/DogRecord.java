
/**
 *****************************************************
 File Name: DogRecord.Java
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
            int weight
            boolean active
 ******************************************************
 *Methods:
 *        getWeight
 *        getActive
 *          
 ******************************************************
 */
public class DogRecord extends MammalRecord
{
    int weight;
    boolean active;

    /**
     * Constructor for objects of class DogRecord
     */
    public DogRecord(String desig, int id, Date[] dates, String[]descript, Date birthdate)
    {
           super(desig, id, dates, descript, birthdate);
           
    }
    
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    /**
     * returns how many variables are used in the object
     */
    public int varCount()
    {
        super.varCount();  
        var = var+2;
        return var;
    }//end varcount
    
    
    public void setActive(char act)
    {
        char x;
        x = Character.toUpperCase(act);
        
        if(x=='Y')
        {
        active = true;
        }
        else
        {
        active = false;
        }    
    }//end SetActive
    
    public boolean getActive()
    {
        return active;
    }

    
    public void print()
    {
        
        super.print();
        System.out.println("weight: "+ weight);
        if (active == true)
        {
            System.out.println("activity: active");
        }//end if   
        else
        {
           System.out.println("activity: not active"); 
        }//end else
      
    }
    
    
      public int compareTo(Object y)
    {
       return 0; 
    }
    
}
