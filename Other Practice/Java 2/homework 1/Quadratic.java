// ****************************************************** 
// File Name:Quadratic.java
// AUTHOR:Matthew Tait 3460396
// Original Date:Jan.18/13
// Last Edited: Jan. 20/13
// ****************************************************** 
// Type: Class/constructor
// ****************************************************** 
// PURPOSE:solves polynomial equations, giving roots 
//			  and the y values of the equation
// ****************************************************** 
// Attributes: double a, b, c : variables given as arguments
//					when a new quadratic is created
// ****************************************************** 
// Methods: toString
// 			getRoots
//				numRoots
//				displayValTable
// ****************************************************** 

import java.lang.Math;


public class Quadratic
{
	double a;	
	double b;
	double c;
	
 
	public Quadratic(double qa, double qb, double qc)	
	{
		 a=qa;
 		 b=qb;
 		 c=qc;
	}

//makes a string version of the formula using the provided variables
public String toString()
{
String result=new String();
	if(a!=0)
	{
	result=("y=" + a + "x^2+" + b + "x+" + c);
	}//end if 
	else if (b!=0)
	{
	result=("y=" + b + "x+" + c);
	}//end else if
	else if (c!=0)
	{
	result=("y= " + c);
	}//end else if
return result;
}

//solves part of the equation under the square root sign
//returns the table roots
public double[] getRoots()
{
double roota=0;
double rootb=0;
double square=(Math.pow(b,2.0)-(4*a*c));

	if(square>=0)
	{
		if(a!=0)
		{
			roota= ((-b +(Math.sqrt(square)))/(2*a));
			rootb= ((-b -(Math.sqrt(square)))/(2*a));
		}//end if
	}//end if
 	else if(a==0 && b!=0)
		{
		roota=(-c/b);
		}//end else if
	else if(c!=0 && b==0)
		{
		roota=0;
		}//end else if
	if(roota!=0 && rootb!=0)
	 {
	 double[] roots = {roota, rootb};
	 return  roots;
	 } //end if
	else if(roota!=0 && rootb==0)
	{
	double[] roots = {roota};
	return  roots;
	}//end else if	
	else
	{
	 double[] roots = {};
	 return  roots;
	}//end else
}//end getRoots
//calculates and returns the number of roots for the object
public int numRoots()
{
 return this.getRoots().length;
}//end numRoots
//calculates the value for y, given the X array values from the driver
//y=ax^2+bx+c
public double[] dispValTable(double[]X)
{
double[] y = new double[7];
for(int i=0; i<X.length; i++)
{
y[i]=(a*(Math.pow(X[i],2.0))+(b*X[i])+c);
}//end for
return y;
}//end disValTable

}//end Quadratic