
import java.util.Scanner;
public class lab3
{

public static void main(String[]args)
{
String cityProvince = new String("Saint John, NB"); // declares new string cityProvince as Saint John, NB
int stringLength; // declares new integer stringLength
int middleIndex; // declares new integer middleIndex
String upperCity = new String(cityProvince.toUpperCase()); // declares new string that changes cityProvince to all capitals
String lowerCity = new String(cityProvince.toLowerCase()); // declares new string that changes cityProvince to all lowercase
String subString = new String(cityProvince.substring(6,9)); // declares new string that shows the substring of cityProvince from index 6 to index 9
String replaceA = new String(cityProvince.replace('a','X')); // declares new string that replaces all of a in cityProvince with X
String replaceI = new String(replaceA.replace('i','X')); // declares new string that replaces all of i in replaceA with X
String replaceString = new String(replaceI.replace('o','X')); // declares new string that replaces all of o in replaceI with X

String city; // name of city as entered by user
String province; // name of province as entered by user
String upperprovince; // string mutation of the province string
String lowercity; // string mutation of the city string

stringLength = cityProvince.length(); // sets integer value for stringLength as the number of characters in cityProvince
middleIndex = (stringLength / 2); // sets integer value for middleIndex as stringLength divided by 2

Scanner keyboard = new Scanner (System.in);

System.out.println (cityProvince); // prints string cityProvince
System.out.println ("length of string: " + (stringLength)); // prints the length of cityProvince
System.out.println ("the middle index of the string: " + (middleIndex)); // prints the middle index of cityProvince
System.out.println (upperCity); // prints string upperCity
System.out.println (lowerCity); // prints string lowerCity
System.out.println ("the index of  the string from 6 to 9: " + (subString)); // prints string subString
System.out.println (replaceString); // prints string replaceString

System.out.print ("Enter the name of your home town: "); // prompts user to enter their home town
city = keyboard.nextLine(); // reads keyboard input

System.out.print ("Enter the name of your home province: "); // prompts user to enter their home province
province = keyboard.nextLine(); // reads keyboard input

upperprovince = (province.toUpperCase()); // changes the city string to uppercase
lowercity = (city.toLowerCase()); // changes the city string to lowercase

System.out.println ( upperprovince + " " + lowercity + " " + upperprovince ); // prints out the resultant of the mutated strings



}
}