// ****************************************************** 
// File Name:Homework2.java 
// AUTHOR:Matthew Tait 3460396
// Original Date:Jan.18/13
// Last Edited: Jan. 20/13
// ****************************************************** 
// Type: class
// ****************************************************** 
// PURPOSE: reads a file and gives how mny of an input
//				character there are
// ****************************************************** 
// Attributes: Scanner key
//					int index
//					String line
//					String compare
//					File book
// ****************************************************** 
// Methods: main method 
// ****************************************************** 
import java.util.Scanner;
import java.io.*;

public class homework2
{

	public static void main(String[]args)  throws FileNotFoundException
	{
	//makes a new scanner to read keyboard input
	Scanner key = new Scanner(System.in);
	String user;
	int index=0;
	String line;
	String compare;
	//opens the book file
	File book = new File("book.txt");
	//gets the character the user wants to find
	System.out.println("enter the character(letter, symbol, etc.,) you want to find: ");
	//assigns a string for the users input
	user = key.nextLine();
	//scanner meant to scan the file	
	Scanner find = new Scanner(book);
	
	//while the file has a line, enter loop
	while(find.hasNextLine())
	 {
	 //sets the line string equal to whatever line the Scanner is currently reading
	 line=find.nextLine();
	  //sets compare string equal to the next character in the line.
	  for(int i=0; i<=(line.length()-1); i++)
	  {
	  //compares the user input to each character in the line 
	  compare=(line.substring(i, (i+1)));
	  //if the compare string is the same as what the user input, ignoring cases, it increments index.
	  if(compare.equalsIgnoreCase(user))
	  {
	   index++;
	  }//end if
	 	
	  }//end for
	 }//end while
	 //tells the user how many there are of his selection
	 System.out.println("There are " +index + " occurences of " + user + ", including capitals and lowercase.");
		
	//closes the file
	find.close();
	}//end main	
}//end class	