import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class TriangleArea
{
public static void main(String[]args)
{
Scanner keyboard = new Scanner (System.in);
//declare variables
double a, b, c, p;
double halfper;
double A, B, C;
double area;
DecimalFormat fmt = new DecimalFormat ("0.###");
//get values for the triangle sides
System.out.print ("input the length of the first side of the triangle in centimeters: ");
a = keyboard.nextFloat();
System.out.print ("input the length of the second side of the triangle in centimeters: ");
b = keyboard.nextFloat();
System.out.print ("input the length of the third side of the triangle in centimeters: ");
c = keyboard.nextFloat();
//calculate half the perimeter
p = (a + b + c)/2;
//area equals the square root of p*A*B*C
A = (p-a);
B = (p-b);
C = (p-c);
area = Math.sqrt(p * A * B * C);
//output of the area with format to 3 decimals
System.out.println ("The area of the triangle is: " + fmt.format(area) +"cm square");

}
}