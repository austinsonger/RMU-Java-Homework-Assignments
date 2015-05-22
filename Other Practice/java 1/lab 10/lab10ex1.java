import java.util.Scanner;

public class lab10ex1
{
public static void main(String[]args)
{

double [] numbers = new double[10];
Scanner key = new Scanner(System.in);

//prompts user to enter 10 numbers, and stores them in an array
for (int index = 0; index<numbers.length;index++)
{		System.out.println("enter 10 positive numbers "
		+ (index+1)+": " );
	numbers[index] =	key.nextDouble();
	}//end for
double total = 0;
for(int i = 0;i < numbers.length	;i++)
 total +=numbers[i]; 


System.out.println("the sum of the numbers is: " + total);
	
	




}
}