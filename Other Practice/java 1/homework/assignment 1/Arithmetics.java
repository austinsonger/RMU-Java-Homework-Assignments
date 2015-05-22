//******************************************************
//Arithmetics.java
//
//demonstrates the operators used in Java
//******************************************************
import java.util.Scanner;
public class Arithmetics
{
public static void main(String[] args)
{
int a; // first number in equation
int b; // second number in equation

Scanner keyboard = new Scanner (System.in);

System.out.print ("Enter the value of a: ");
a = keyboard.nextInt();

System.out.print ("Enter the value of b: ");
b = keyboard.nextInt();

System.out.println (a + " * " + b + " = " + (a * b));
System.out.println (a + " / " + b + " = " + (a / b));
System.out.println (a + " % " + b + " = " + (a % b));
System.out.println (a + " = " + (a / b) + " * " + b + " + " + (a % b));

}
}