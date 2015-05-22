import java.util.Scanner;

public class TwentyQuestions {
    public static void main( String[] args ) {
	Scanner keyboard = new Scanner(System.in);

	System.out.println( "TWO QUESTIONS!" );
	System.out.println( "Think of an object, and I'll try to guess it." );
	System.out.println();

	System.out.println( "Question 1) Is it animal, vegetable, or mineral?" );
	System.out.print( "> " );
	String Q1Response = keyboard.next();

	System.out.println( "Question 2) Is it bigger than a breadbox? (yes or no)" );
	System.out.print( "> " );
	String Q2Response = keyboard.next();
	
	System.out.println();
	GetResponse( Q1Response, Q2Response );	
    }

    public static void GetResponse( String r1, String r2 ) {
	if ( r1.equals("animal") ) {
	    if ( r2.equals("no") )
		PrintResult( "squirrel" );
	    else
		PrintResult( "moose" );
	}
	else if ( r1.equals("vegetable") ) {
	    if ( r2.equals("no") )
		PrintResult( "carrot" );
	    else 
		PrintResult( "watermelon" );
	}
	else {
	    if ( r2.equals("no") )
		PrintResult( "paper clip" );
	    else 
		PrintResult( "camaro" );
	}
    }

    public static void PrintResult( String result ) {
	System.out.println( "My guess is that you are thinking of a " + result + "." );
	System.out.println( "I would ask you if I'm right, but I don't actually care." );
    }
}
