//*********************************************************************************
//ConvSeconds.java
//
//converts the number of seconds input to hours, minutes, and remaining seconds.
//*********************************************************************************
import java.util.Scanner;
public class ConvSeconds
{
public static void main(String[] args)
{
int seconds; //the seconds input from the user
int hours; // the number of hours
int minutes; // the number of minutes
int secs; // the number of remaining seconds
Scanner keyboard = new Scanner (System.in);

System.out.print ("enter the number of seconds: ");
seconds = keyboard.nextInt();
hours = (seconds / 3600);
minutes = (seconds / 60 - (hours * 60));
secs = (seconds % 60);
System.out.println ("there are " + hours + " hours, " + minutes + " minutes, " + secs + " seconds in " + seconds + " seconds.");


}
}