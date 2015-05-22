import java.util.Scanner;

public class Calculator
{
	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		
		String operator;
				
		double num1, num2;
		double total;
		
		
		
		while ( true )
		{
			System.out.print( "> " );
			

			num1 = keyboard.nextDouble();
			// program ends if user enters "0" as first value			
			if ( num1 == 0 )
				break;

			operator = keyboard.next();
			num2 = keyboard.nextDouble();
			
			total = Calculate( num1, num2, operator );
			
			
		}
		
		System.out.println( "Bye, now." );
		
			
			
			
		
	}
	
	public static double Calculate( double a, double b, String op )
	{
		double c;
		if ( op.equals("+") )
		{
			c = a + b;
			System.out.println( c );
		}
		else if ( op.equals("-") )
		{
			c = a - b;
			System.out.println( c );
		}

		else if ( op.equals("*") )
		{
			c = a * b;
			System.out.println( c );
		}

		else if ( op.equals("/") )
		{
			c = a / b;
			System.out.println( c );
		}
		
		else if ( op.equals("^") )
		{
			c = Math.pow( a, b );
			System.out.println( c );
		}
		
		else if ( op.equals("%") )
		{
			c = a % b;
			System.out.println( c );
		}
		else
		{
			System.out.println("Undefined operator: '" + op + "'.");
			c = 0;
		}
		return c;
	}

}