public class Level2 extends Level1
{
   
    private DaysofWeek day;
    /**
     * Constructor for objects of class Level2
     */
    public Level2(DaysofWeek day)
    {
        super(day.increment());
         this.day = day;
        System.out.println("Printing from Level 2");
        System.out.println("the value of day is " + day);

    }

    
    
    
    public void level2Method()
    {
        System.out.println("Printing from Level 2 Method");
    }



}
