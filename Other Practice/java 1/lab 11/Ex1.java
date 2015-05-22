import java.util.ArrayList;

public class Ex1
{


public static void main(String[]args)

{
//creates 2d table
String [] [] table = new String[] []{ {"to be ", "or ", "not ", "to be "}, {"that ", "is ", "the ", "question! "}, {"who", "said", "the", "quotes?"} };
//prints table
System.out.println ("the output of Question 1. and 2. ");
	for(int i = 0; i < table.length; i++){
		for(int q = 0; q < 4; q++)
			System.out.print(table[i][q] + " ");
System.out.println();
}//end for
//creates ArrayList of row 1
System.out.println ("the output of question 3. ");
ArrayList<String> namelist = new ArrayList<String>();
		for(int i = 1; i <= 1; i++ )
		{
		for(int q = 0; q < 4; q++)
			namelist.add (table[i][q] );
			System.out.println (namelist);
		}//end for
//replaces "the" and "question" with "William" and "Shakespeare"
//and prints the result
System.out.println("The output of question 4.");
namelist.set(2, "William");
namelist.set(3, "Shakespeare");
	for(int i = 0; i < 4; i++)
	{
	System.out.println(namelist.get (i));
	}//end for



}//end main


}//end class