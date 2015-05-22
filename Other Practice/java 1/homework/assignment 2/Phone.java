import java.util.Random;
import java.text.Format;
public class Phone
{
public static void main(String[]args)
{
Random num = new Random();

//generate the area code
int a = num.nextInt(8);
int b = num.nextInt(8);
int c = num.nextInt(8);
//change the integers to strings
String A = new String ("" + a);
String B = new String ("" + b);
String C = new String ("" + c);
//concatenate the strings
String area = new String (A + B + C);

//generate the exchange number
int exchange = num.nextInt(643)+100;
//change the integer to a string
String ex = new String ("" + exchange);

//generate last four digits
int d = num.nextInt(10);
int e = num.nextInt(10);
int f = num.nextInt(10);
int g = num.nextInt(10);
//change the integers to strings
String D = new String ("" + d);
String E = new String ("" + e);
String F = new String ("" + f);
String G = new String ("" + g);
//concatenate the strings
String last = new String ("" + d + e + f + g);

//display new phone number
System.out.println ( "Your phone number is: " + area + "-" + exchange + "-" + last); 


}
}