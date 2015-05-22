
/**
 *************************************
  DaysofWeek.Enum
  Matthew Tait  3460396
  created: Jan 28/13
  last modified: Jan 29/13
 *************************************
 Type: Enumerated data Class
 *************************************
  attributes
            DaysofWeek
            
 *************************************
 purpose: 
         an enum data table of the days of the week
 *************************************
 methods:
          none
 ************************
 */
import java.util.Random;
public enum DaysofWeek
{
    MONDAY("dies Solis"), 
    TUESDAY("dies Lunae"), 
    WEDNESDAY("dies Martis"), 
    THURSDAY("dies Mercurii"), 
    FRIDAY("dies Iovis"), 
    SATURDAY("dies Veneris"), 
    SUNDAY("dies Saturni");

    private String latin;
    
//constructor sets each value an associated string
DaysofWeek (String day)
    {
        latin=day;
    }

public String getLatin()
    {
        return latin;
    }


 public DaysofWeek increment()
    {
      switch (this)
      {
            case MONDAY:
                 return TUESDAY;
                 
            case TUESDAY:
                         return WEDNESDAY;
                        
            case WEDNESDAY:
                        return THURSDAY;
               
            case THURSDAY:
                        return FRIDAY;
                        
            case FRIDAY:
                       return SATURDAY;
                      
            case SATURDAY:
                        return SUNDAY;
                        
            case SUNDAY:
                        return MONDAY;
        }//end switch  
       return this;
    }


    
    
     public DaysofWeek decrement()
    {
      switch (this)
      {
            case MONDAY:
                 return SUNDAY;
                 
            case TUESDAY:
                         return MONDAY;
                        
            case WEDNESDAY:
                        return TUESDAY;
               
            case THURSDAY:
                        return WEDNESDAY;
                        
            case FRIDAY:
                       return THURSDAY;
                      
            case SATURDAY:
                        return FRIDAY;
                        
            case SUNDAY:
                        return SATURDAY;
        }//end switch  
       return this;
    }

    //returns a random day of the week
    public static DaysofWeek random()
    {
        int pick = new Random().nextInt(DaysofWeek.values().length);
        
        
        return DaysofWeek.values()[pick];
    }

}


