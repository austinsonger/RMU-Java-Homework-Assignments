public class Level2 extends Level1
{
    private int level2_X = 2;

    /**
     * Constructor for objects of class Level2
     */
    public Level2(int y)
    {
        super(y);
        level2_X = y + 2;
        System.out.println("Printing from Level 2");
        System.out.println("the value of level2_X is " + level2_X);

    }

    public void level2Method()
    {
        System.out.println("Printing from Level 2 Method");
    }
}
