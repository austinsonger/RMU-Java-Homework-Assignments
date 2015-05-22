
/**
 **********************************************************
 *BadDivisonException.java
 *Matthew Tait 3460396
 *Created: Mar.17/13
 *Last edited: Mar.19/13
 **********************************************************
 *Type: Exception

 **********************************************************
 *Purpose:
 *shows up when the division is not perfect
 **********************************************************
 */
public class BadDivisionException extends Exception
{
    

    /**
     * Constructor for objects of class BadDivisionException
     */
    public BadDivisionException()
    {
       System.err.println("I'm sorry Dave, I'm afraid I can't do that.");
       System.err.println("Division is not possible with these numbers.");
    }
}
