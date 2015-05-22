import javax.swing.*;
import java.util.Scanner;
import java.util.Random;
public class UserName
{
public static void main(String[] args)
{
Scanner keyboard = new Scanner (System.in);
Random num = new Random();

int number;
String first;
String last;

//get user's first name
first = JOptionPane.showInputDialog("Enter your first name:");

//get user's last name
last = JOptionPane.showInputDialog("Enter your last name:");

//generate a random number from 100 to 999
number = num.nextInt(900)+100;

//take the first letter of the first name
String pt1 = new String (first.substring(0,1));
String pt2 = new String();

pt2 = last;
if (pt2.length()>4){
pt2 = last.substring(0,5);
}

//combine pt1 and pt2
String combo = new String (pt1.concat (pt2));
//change to lowercase
String lower = new String (combo.toLowerCase());
//create the username
String username = new String (lower + number);

//display username
JOptionPane.showMessageDialog (null ,"Your new username is: " + username);


}
}