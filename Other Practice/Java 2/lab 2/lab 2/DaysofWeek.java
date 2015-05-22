
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
public enum DaysofWeek
{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    
    
    
    
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


    
    
}


/*

 */