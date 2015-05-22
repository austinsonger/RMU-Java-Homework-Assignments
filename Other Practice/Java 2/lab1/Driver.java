import java.util.Scanner;

public class Driver

{
public static void main(String[]args)
	{
	Scanner key = new Scanner(System.in);
	DooHicky[]doo=new DooHicky [10];
		//creates the first 5 elements of the array
		for(int i=0; i<5;i++)
		{
		doo[i] = new DooHicky();
		doo[i].setIndex(i);
		}//end for	
		//creates the last 5 elements of the array
		for(int i = 5; i<10; i++)
		{
		
		String name = new String (args[i-5]);
		System.out.println("What is " + args [i-5] +"'s gender(as a letter)?");
		char gender =key.nextLine().charAt(0);
		 System.out.println("What is "+ args [i-5] +"'s age?");
		 int age =key.nextInt();
		 key.nextLine();
		doo[i] = new DooHicky(name, age, gender);
		doo[i].setIndex(i);
		}//end for
		
		for(int i=0; i<10;i++)
		{
		doo[i].setTotal(doo.length);
		System.out.println(doo[i].toString());
		}
	}
}