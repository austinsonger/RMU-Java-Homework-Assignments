import java.util.Scanner;

public class Conversion
{
static double input;
public static void main(String[]args){
Scanner key = new Scanner (System.in);

System.out.println("Enter a distance in meters");
input = key.nextDouble();
//check if input is positive
while (input<0)
{System.out.println("Distance must be positive. Please try again.");
input = key.nextDouble();
}//end while

menu();

}//end main
//convert meters to Kilometers
public static void showKM(double meters){
System.out.println(meters*0.001);
menu();
}//end showKM

public static void showInches(double meters){
System.out.println(meters*39.37);
menu();
}//end showInches

public static void showFeet(double meters){
System.out.println(meters*3.281);
menu();
}//end showFeet

public static void menu(){
System.out.println("Please make a selection" + "\n");
System.out.println("1. Convert to kilometers.");
System.out.println("2. Convert to inches.");
System.out.println("3. Convert to feet.");
System.out.println("4. Quit the program.");

Scanner choice = new Scanner(System.in);

int pick = choice.nextInt();
while (pick !=1 || pick != 2 || pick != 3 || pick != 4)
{System.out.println("Make a valid selection");
pick = choice.nextInt();
}
if (pick == 1)
showKM(input);
if (pick == 2)
showInches(input);
if (pick == 3)
showFeet(input);
if (pick == 4)
System.out.println("Thank you, see you later."); 

}//end menu


}//end class