// ****************************************************** 
// File Name:Driver.Java 
// AUTHOR:Matthew Tait 3460396
// Original Date:Jan.18/13
// Last Edited: Jan. 20/13
// ****************************************************** 
// Type: Driver 
// ****************************************************** 
// PURPOSE: A Driver for the Quadratic class and it's methods
//
// ****************************************************** 
// Attributes: poly1: a quadratic object 
// 				poly2: a quadratic object 
//					poly3: a quadratic object 
//					poly4: a quadratic object 
//					double[]X: an array of x values
// ****************************************************** 
// Methods: 
// main method 
// ****************************************************** 


import java.lang.Math;



public class Driver
{
public static void main (String[]args)
{
//creates array of x values
double X[]= {-3.0, -2.0, -1.0, 0.0, 1.0, 2.0, 3.0};
//makes quadratic objects with X elements as the arguments
Quadratic poly1 = new Quadratic(1.0, 2.0, -3.0);
Quadratic poly2 = new Quadratic(-2.0, -3.0, -4.0);
Quadratic poly3 = new Quadratic(0.0, 0.0, 3.0);
Quadratic poly4 = new Quadratic(2.0, 0.0, -2.0);
//print poly1 in standard form
System.out.println("poly = " + poly1.toString());
//print # of roots for poly1
System.out.println("the num of roots is  " + poly1.numRoots());
	//prints the roots of poly1
	for(int i=0; i<poly1.getRoots().length;i++)
	{ 
	System.out.println("root = " + poly1.getRoots()[i]);
	}//end for
System.out.println("x  |  y");
System.out.println("_______");
	//prints a table of values for poly1
	for(int i=0; i<poly1.dispValTable(X).length;i++)
	{
	System.out.println (X[i] + " | " + (poly1.dispValTable(X)[i]));
	}//end for
//print a blank line for spacing
System.out.println(" ");

//print poly2 in standard form
System.out.println("poly = " + poly2.toString());
//print # of roots for poly2
System.out.println("the num of roots is  " + poly2.numRoots());
	//prints the roots of poly2
	for(int i=0; i<poly2.getRoots().length;i++)
	{ 
	System.out.println("root = " + poly2.getRoots()[i]);
	}//end for
//prints a table of values for poly2
System.out.println("x  |  y");
System.out.println("_______");
for(int i=0; i<poly2.dispValTable(X).length;i++)
{
System.out.println (X[i] + " | " + (poly2.dispValTable(X)[i]));
}//end for

System.out.println(" ");
//print poly3 in standard form
System.out.println("poly = " + poly3.toString());
//print # of roots for poly3
System.out.println("the num of roots is  " + poly3.numRoots());
	//prints the roots of poly3
	for(int i=0; i<poly3.getRoots().length;i++)
	{ 
	System.out.println("root = " + poly3.getRoots()[i]);
	}//end for
//prints a table of values for poly3
System.out.println("x  |  y");
System.out.println("_______");
for(int i=0; i<poly3.dispValTable(X).length;i++)
{
System.out.println (X[i] + " | " + (poly3.dispValTable(X)[i]));
}//end for

System.out.println(" ");
//print poly4 in standard form
System.out.println("poly = " + poly4.toString());
//print # of roots for poly4
System.out.println("the num of roots is  " + poly4.numRoots());
	//prints the roots of poly4
	for(int i=0; i<poly4.getRoots().length;i++)
	{ 
	System.out.println("root = " + poly4.getRoots()[i]);
	}//end for
//prints a table of values for poly4
System.out.println("x  |  y");
System.out.println("_______");
for(int i=0; i<poly4.dispValTable(X).length;i++)
{
System.out.println (X[i] + " | " + (poly4.dispValTable(X)[i]));
}//end for



}//end main



}//end Driver