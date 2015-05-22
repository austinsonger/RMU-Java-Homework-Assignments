//********************************************************************
//  Student.java         Represents a college student
//********************************************************************
import java.util.Scanner;
import java.io.*;
public class Student
{
   private String firstName, lastName;
   private Address homeAddress, schoolAddress;
	private int testScore1, testScore2, testScore3;
	

   //-----------------------------------------------------------------
   //  Constructor: Sets up this student with the specified values.
   //-----------------------------------------------------------------
   public Student (String first, String last, Address home,
                   Address school)
   {
      firstName = first;
      lastName = last;
      homeAddress = home;
      schoolAddress = school;
  		testScore1 = 0;
		testScore2 = 0;
		testScore3 = 0;
	}
	
	public void setTestScore(File testScores) throws FileNotFoundException
	{
		Scanner scan = new Scanner(testScores);
		int line = (scan.nextLine().hashCode());
		while (this.firstName.hashCode() != line)
		{
		 line = scan.nextLine().hashCode();
		}
		for (int i =1; i<=3; i++)
		{
		int testNumber = (scan.nextInt());
		if (testNumber == 1)
			testScore1= scan.nextInt();
		if (testNumber == 2)
			testScore2= scan.nextInt();
		if (testNumber == 3)
			testScore3= scan.nextInt();
		}		  
				  
	}//end setTestScore
	
	public int getTestScore(int test)
	{
	if(test == 1){
		return testScore1;}
	if(test == 2){
		return testScore2;}
	if(test == 3){
		return testScore3;}
	else return 0;
	}//end getTestScore
	
	public int average()
	{
	return ((testScore1 + testScore2 + testScore3)/3);
	}//end average
	




   //-----------------------------------------------------------------
   //  Returns a string description of this Student object.
   //-----------------------------------------------------------------
   public String toString()
   {
      String result;

      result = firstName + " " + lastName + "\n";
      result += "Home Address:\n" + homeAddress + "\n";
      result += "School Address:\n" + schoolAddress + "\n";
		result += "Test Scores: " + testScore1+ " " + testScore2 + " "+ testScore3 +"\n";
		result += "Test Average: " + average();
      return result;
   }
}
