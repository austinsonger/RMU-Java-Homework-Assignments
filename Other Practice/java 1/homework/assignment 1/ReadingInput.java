//*****************************************************
//ReadingInput.java
//
//displays the first and last name and age of the user
//*****************************************************
import java.util.Scanner;
public class ReadingInput
{
public static void main(String[] args)
{
String first; //first name of user
String last; //last name of user
int age; //age of user

Scanner keyboard = new Scanner (System.in);

System.out.print ("Enter your first name: ");
first = keyboard.nextLine();

System.out.print ("Enter your last name: ");
last = keyboard.nextLine();

System.out.print ("Enter your age: ");
age = keyboard.nextInt();


System.out.println ("You are : " + last + ", " + first + ", and you are " + (age *365) + " days old.");

}
}