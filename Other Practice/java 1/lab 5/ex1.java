public class ex1
{
	public static void main(String[] args){
	
	displayValue (100);
	displayValue(7);
	addValue(7);
	displayValue(4332);
	displayValue((int)7.5);
	}// end main()
	
	public static void addValue(int num)
	{System.out.println("Twice the value displayed is: " + (num+num)); 
	}
	public static void displayValue(int num)
	{System.out.println("The value displayed is: " + num);  
	
	}//end displayValue()
	
	
	/*
	//a
	

		//compiles
	//b
		displayValue(6.0);
		System.out.println("The value displayed is: " + num); 
		//doesn't compile because the given value is a double, but displayValue is an integer
			
	//c
		short s =5;
		displayValue(s);
		System.out.println("The value displayed is: " + num); 
		//compiles
		
	//d
		double num = 1;
		displayValue(num);
		System.out.println("The value displayed is: " + num); 
		//doesn't compile because num is already defined in the method as an int.
		
	//e
		displayValue((int)7.5);	
		System.out.println("The value displayed is: " + num); 
		//compiles
		
}

*/



} //end ex1 class