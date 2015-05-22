public class Level3 extends Level2
{
    private int level3_X = 3;

    public Level3(int y)
    {
        super(y);
        level3_X = y+3;
        System.out.println("Printing from Level 3");
        System.out.println("the value of level3_X is " + level3_X);
    }

    public void level3Method()
    {
        System.out.println("Printing from Level 3 Method");
    }
}
