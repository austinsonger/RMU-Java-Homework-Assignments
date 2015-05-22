import java.util.Scanner;

public class Homework1
{
public static void main(String[]args)
{
Scanner key = new Scanner(System.in);
//creates new scanner class that reads keyboard input

double input = 0;
//creates new double for the user input
double high = 0;
//creates new double for the highest number
double low = 0;
//creates new double for the lowest number
double sum = 0;
//creates new double for the sum of all number inputs
double index = 0;
//creates new double to keep track of how many valid numbers are input

System.out.println("enter any series of positive numbers, one at a time, to build a list. Enter a negative number to stop.");

while(input>=0)
{
input = key.nextDouble();
if(index==0)
{
 high=input;
 low=input;
}
//end if
if(input>=0)
{
 if(input>=high)
 {
  high=input;
 }
 //end if
 if(input<=low)
 {
  low=input;
 }
 //end if
 sum+=input;
 //adds the number to the sum of all input numbers
 index=(index+1);
 }
 //end if
 }
 //end while
 System.out.println("The highest number input was: " + high);
 //prints the highest number
 System.out.println("The average of the numbers is: " + (sum/index));
//prints the average of the numbers
System.out.println("The lowest number input was: " + low);
//prints the lowest number 



}
//end main
}
//end class
