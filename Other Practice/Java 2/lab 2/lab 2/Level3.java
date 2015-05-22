public class Level3 extends Level2
{
    
    private DaysofWeek day;
    public Level3(DaysofWeek day)
    {
        super(day.increment());
        this.day = day;
        System.out.println("Printing from Level 3");
        System.out.println("the value of day is " + day);
    }

    public void level3Method()
    {
        System.out.println("Printing from Level 3 Method");
    }
    
    



}
