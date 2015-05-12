/*
--Java--
--Austin Vern Songer--
--8MAY2015
--Robert Morris University--
*/

import java.util.Scanner;

public class AgeIn5
{
	public static void main( String[] args )
	{
		String name;
		int age;
		Scanner keyboard = new Scanner(System.in);

		System.out.print( "Hello. What is your name? " );
		name = keyboard.next();
		System.out.print( "Hi, " + name + "! How old are you? " );
		age = keyboard.nextInt();
		System.out.println( "Did you know that in five years you will be " + (age + 5) + " years old?" );
		System.out.println( "And five years ago you were " + (age - 5) + "! Imagine that!" );
	}
}
