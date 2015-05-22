/*
 * E.java
 *
 * Version:
 *     $1.0$
 *
 * Author:
 * 	  Shivkumar Dudhani && Vishal Dsouza
 * Revisions:
 *     $New$
 * Description
 * 	  Compute the value of e using 3 methods
 */

import java.lang.Math;

/**
 * Class: Compute_e
 * Description: Computes the value of e using 3 methods
 *
 */
class Compute_e {
	double delta;
	double e = 0;
	/**
	 * Class constructor
	 * this would define the delta for the calculations
	 * @param delta delta for calculations
	 */
	Compute_e(double delta){		
		//Delta
		this.delta = delta; 
	}
	/**
	 * Method 1 
	 * Newton's Series Expansion for e
	 */
	void method_1() {
		e = 1; // Reset value of e
		double fact = 1;
		int n =1;
		while(true)
		{
			fact = fact * n;
			e = e + 1/fact;
			n++;
			if(Math.abs(e - Math.E ) < delta)// continue till the difference is less that delta
			break;
		}
	}

	
	/**
	 * Method 2
	 *  Brothers' Formulae
	 */
	void method_2(){
		e = 0; // Reset value of e
		double fact = 1;
		int n =0;
		// initial cases for the value of n = 0, and n =1
		e = 2;
		n = 1;
		fact = (2*n + 1 )*(2*n);
		e = e + ((2*n)+2)/fact;
		n++;
		
		while(true)
		{
			fact = fact*(2*n + 1 )*(2*n);
			e = e +(2*n + 2)/(fact);
			n++;
			if(Math.abs(e - Math.E ) < delta)// continue till the difference is less that delta
			break;			
		}		
	}
	/**
	 * Method 3
	 * 
	 */
	void method_3()
	{
		e = 0; // Reset value of e
		double val = 1;
		double n =1;
		e=1;
		while(true)
		{
			e =1;
			val = (1/n);
			val = val +1;
			for(int i=1;i <=n;i++)
			{	
				e = e*val;
			}
			n++;
			if(Math.abs(e - Math.E ) < delta) // continue till the difference is less that delta
			break;

		}		
	}
	/**
	 * Method 3
	 * Display the value of computed e
	 */
	void display_e()
	{
		System.out.println("Computed Value of e : " + e);
	}
}

public class E {

	public static void main(String[] args) {
		// create a class object
		Compute_e  e = new Compute_e(0.001);

		//Method 1
		e.method_1();
		e.display_e();
		
		//Method 2
		e.method_2();
		e.display_e();
	
		//Method 3
		e.method_3();
		e.display_e();

	}

}
