// ************************************************************
// PlusTest.java
//
// Demonstrate the different behaviors of the + operator
// ************************************************************
public class PlusTest
{
// -------------------------------------------------
// main prints some expressions using the + operator
// -------------------------------------------------
public static void main (String[] args)
{
System.out.println ("This is a long string that is the " +
"concatenation of two shorter strings.");
System.out.println ("The first computer was invented about" + 55 +
"years ago.");
//this should be "8 plus 5 is 85"
System.out.println ("8  plus  5 is " + 8 + 5);
//this should be "8 plus 5 is 13"
System.out.println ("8 plus 5 is " + (8 + 5)) ;
//this should be "13 equals 8 + 5
System.out.println (8 + 5 + " equals 8 plus 5.");
}
}
