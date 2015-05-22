

/**
 **********************************************************
 *BadSubtractionException.java
 *Matthew Tait 3460396
 *Created: Mar.17/13
 *Last edited: Mar.19/13
 **********************************************************
 *Type: Exception

 **********************************************************
 *Purpose:
 *tells the user that the result will be less than zero
 **********************************************************
 */
public class BadSubtractionException extends Exception
{
    

    /**
     * Constructor for objects of class BadSubtractionException
     */
    public BadSubtractionException()
    {
       System.err.println("I'm sorry Dave, I'm afraid I can't do that.");
       System.err.println("Result of subtraction is less than 0.");
    }//end exception
}
