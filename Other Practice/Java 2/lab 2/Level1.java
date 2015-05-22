public class Level1
{
    private int level1_X;

    public Level1( int x)
    {
        level1_X = x + 1;
        // initialise instance variables
        System.out.println("Printing from Level 1");
        System.out.println("the value of level1_X is " + level1_X);
    }

    public void level1Method()
    {
        // put your code here
        System.out.println("Printing from Level 1 Method");
    }
}
