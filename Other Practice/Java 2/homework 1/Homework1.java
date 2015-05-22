// ****************************************************** 
// File Name:Homework1.java 
// AUTHOR:Matthew Tait 3460396
// Original Date:Jan.18/13
// Last Edited: Jan. 20/13
// ****************************************************** 
// Type: class
// ****************************************************** 
// PURPOSE: calculates highest number, lowest number and 
//				the average of all numbers given by the user
// ****************************************************** 
// Attributes: Scanner key
//					double input
//					double high
//					double low
//					double sum
//					double index
// ****************************************************** 
// Methods: main method 
// ****************************************************** 
import java.util.Scanner;

public class Homework1
{
public static void main(String[]args)
{
//creates new scanner class that reads keyboard input
Scanner key = new Scanner(System.in);
//creates new double for the user input
double input = 0;
//creates new double for the highest number
double high = 0;
//creates new double for the lowest number
double low = 0;
//creates new double for the sum of all number inputs
double sum = 0;
//creates new double to keep track of how many valid numbers are input
double index = 0;
//asks user for the series of numbers
System.out.println("enter any series of positive numbers, one at a time, to build a list. Enter a negative number to stop.");
//if number is positive, enter while
while(input>=0)
{
input = key.nextDouble();
	//sets first number to the high and low variable
	if(index==0)
	{
	 high=input;
	 low=input;
	}//end if
	 if(input>=0)
	 {
	 //sets nth number to high if it's greater than current high
	  if(input>=high)
 	  {
 	  high=input;
	  }//end if
	  //sets nth number to low if less than current low
 		if(input<=low)
 		{
 		low=input;
 		}//end if
 		//adds the number to the sum of all input numbers
		sum+=input;
 	index=(index+1);
 	}//end if
}//end while
//prints the highest number
System.out.println("The highest number input was: " + high);
//prints the average of the numbers
System.out.println("The average of the numbers is: " + (sum/index));
//prints the lowest number 
System.out.println("The lowest number input was: " + low);

}//end main
}//end class