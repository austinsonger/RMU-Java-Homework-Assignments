import java.util.Calendar;
import java.util.Scanner;
/**
 *****************************************************
 File Name: MammalRecord.Java
 AUTHOR: Matthew Tait 3460396
 Original Date: Feb.20/13 
 Last Edited: Feb.20/13
 ******************************************************
 Type: Class
 ******************************************************
 PURPOSE: extends the record class to inherit its
          methods
 
 ******************************************************
 Attributes:
            Date birthdate
            Date t
            int age
            int day
            int month
            int year
 ******************************************************
 *Methods:
 *        getBirthDate
 *        getAge
 *        print
 *        setAge
 *        today
 *        getDay
 *        getMonth
 *        getYear
 ******************************************************
 */
public abstract class MammalRecord extends Record
{
    
    Date birthdate;
    Date t;
    int age;
    int day;
    int month;
    int year;
    /**
     * Constructor for objects of class MammalRecord
     */
    public MammalRecord(String desig, int id, Date[] dates, String[]descript, Date birthdate)
    {
        super(desig, id, dates, descript);
        this.birthdate = birthdate;

    }//end constructor
    
    /**
     * returns how many variables are used in the object
     */
    public int varCount()
    {
        super.varCount();  
        var = var+2;
        return var;
    }//end varcount
     
    
     //returns a new Date object based off the system clock 
    public Date today()
  {
    Calendar today = Calendar.getInstance();
    
    Date t = new Date(today.get(today.MONTH)+1, today.get(today.DATE), today.get(today.YEAR));
    
    day =  today.get(today.DATE);
    month = today.get(today.MONTH)+1;
    year = today.get(today.YEAR);
    
    return t;
    
  }//end today
       
    public Date getBirthDate()
    {
        return birthdate;
    }//end getBirthDate
        
    public void setAge()
    {
        
        int d;
        int m;
        int y;
        int yeardif;
        int monthdif;
        int daydif;
        d = birthdate.getDay();
        m = birthdate.getMonth();   
        y = birthdate.getYear();
        yeardif = year - y;
        monthdif = month - m;
        daydif = day - d;
        
        if(yeardif>0)
        age = yeardif;
        else
        if(monthdif>0)
        age = monthdif;
        else
        if(daydif>0)
        age = daydif;
       
        
    }//end setAge
    
    public int getAge()
    {
        return age;
    }//end getAge
    
    public void print()
    {
       super.print(); 
       System.out.println(birthdate);
       System.out.println(age);
    }//end print
    
    public int getDay()
  {
      return day;
  }//end getDay
    
  public int getMonth()
  {
   return month;   
  }//end getMonth
    
  public int getYear()
  {
      return year;
  }//end getYear
  
    
    
    
    
}//end class
