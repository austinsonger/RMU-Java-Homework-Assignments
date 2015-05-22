
/**
 ******************************
 *InvalidInputException1.java
 *Matthew Tait 3460396
 *Created: Mar.17/13
 *Last edited: Mar.
 ******************************
 *Type: Exception

 ******************************
 *Purpose:
 *Tells the user that the first number is not a valid number
 ******************************
 */
public class InvalidInputException1 extends Exception
{

    /**
     * Constructor for objects of class InvalidInputException1
     */
    public InvalidInputException1()
    {
           System.err.println("I'm sorry Dave, I'm afraid I can't do that.");
           System.err.println("a is a negative number.");
    }
}
