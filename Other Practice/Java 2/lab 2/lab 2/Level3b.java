public class Level3b extends Level2
{
    
    private DaysofWeek day;
    public Level3b(DaysofWeek day)
    {
        super(day.increment());
        System.out.println("Printing from Level 3b");
    }

    public void level3Method()
    {
        System.out.println("Printing from Level 3b Method");
    }
    
    
    
}
