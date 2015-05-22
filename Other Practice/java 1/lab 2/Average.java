// *****************************************************************
// Average.java
//
// Read three integers from the user and print their average
// *****************************************************************
import java.util.Scanner;
public class Average
{
public static void main(String[] args)
{
int A, B, C;
double average;

Scanner scan = new Scanner(System.in) ;
// get three values from user

System.out.println("Please enter three integers and " +
"I will compute their average");

System.out.print ("first integer: ");
A = scan.nextInt(); 

System.out.print ("second integer: ");
B = scan.nextInt();

System.out.print ("third integer: ");
C = scan.nextInt();

//compute the average
average = (A + B + C) / 3 ;

//print the average
System.out.println ("the average is :" + average);
}
}
