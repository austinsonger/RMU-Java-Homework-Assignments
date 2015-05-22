import java.util.Scanner;

public class FreezeBoilDemo{
 public static void main(String [] args){
 Scanner key = new Scanner(System.in);
 //get temperature in Fahrenheit 
 System.out.println("what is the temperature in Fahrenheit? ");  
 int temp = key.nextInt();
 //creates a new FreezeBoil object
 FreezeBoil Temp1 = new FreezeBoil();
 //calls method and prints line if condition is true
 if(Temp1.isEthylFreezing(temp) == true )
 	System.out.println ("Ethyl Alcohol is freezing");
 
 if(Temp1.isEthylBoiling(temp) == true)
  	System.out.println ("Ethyl Alcohol is boiling");

	if(Temp1.isOxygenFreezing(temp) == true)
	 	System.out.println ("Oxygen is freezing");

	if(Temp1.isOxygenBoiling(temp) ==true)
	 	System.out.println ("Oxygen is boiling");

	if(Temp1.isWaterFreezing(temp) == true)
	 	System.out.println ("Water is freezing");

	if(Temp1.isWaterBoiling(temp) == true)
	 	System.out.println ("Water is boiling");

 }//end main
}//end class 