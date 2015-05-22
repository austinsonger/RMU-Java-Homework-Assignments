
/**
 ************************************************************
 *InvalidInputException2.java
 *Matthew Tait 3460396
 *Created: Mar.17/13
 *Last edited: Mar.19/13
 ************************************************************
 *Type: Exception

 ************************************************************
 *Purpose:
 *Tells the user that the second number is not a valid number
 ************************************************************
 */
public class InvalidInputException2 extends Exception
{
   

    /**
     * Constructor for objects of class InvalidInputException2
     */
    public InvalidInputException2()
    {
        System.err.println("I'm sorry Dave, I'm afraid I can't do that.");
        System.err.println("b is a negative number.");
    }
}
