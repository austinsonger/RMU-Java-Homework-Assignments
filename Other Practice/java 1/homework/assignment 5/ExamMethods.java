import java.util.Scanner;
import java.util.ArrayList;

public class ExamMethods

{
String Answers[] = new String[] {"B", "D", "A", "A", "C", "A", "B", "A", "C", "D", "B", "C", "D", "A", "D", "C", "C", "B", "D", "A"};
Scanner key = new Scanner(System.in);
String StudAnswers[] = new String[20];
int missedanswers[] = new int[20];

public boolean PassedorFailed(int incorrect)
{
 if (incorrect < 15){
		System.out.println ( "You failed the exam.");
 	 return false;
	 }
 else{
 System.out.println ("You passed the exam.");
  return true;
  }
}//end PassedorFailed

public int wrongAnswers()
{
int wrong = 0;
for (int i = 0; i < Answers.length;i++)
{
if (StudAnswers[i].compareTo(Answers[i]) != 0)
{
wrong++;
}
}
System.out.println ("Incorrect Answers: " + wrong);
return wrong;
}//end WrongAnswers


public int correctAnswers()
{
int correct = 0;
for (int i = 0; i< Answers.length;i++)
{
if (StudAnswers[i].compareTo(Answers[i]) == 0)
{
correct++;
}//end if
}//end for
System.out.println("Correct Answers: " + correct);
return correct;
}//end CorrectAnswers

public  String[] getAnswers ()
{
System.out.println ("Enter your answers to the exam questions.");
for (int index = 0; index<StudAnswers.length;index++)
{		System.out.println("Question"
		+ (index+1)+": " );
	StudAnswers[index] =	key.nextLine();
	if (( StudAnswers[index].compareTo("A")== 0 || StudAnswers[index].compareTo("B")== 0 || StudAnswers[index].compareTo("C")== 0 || StudAnswers[index].compareTo("D") == 0))
	;//end if
	else {
	System.out.println("Please enter a upper-case A, B, C, or D");
	index--;
	}//end else
}//end for
return StudAnswers;
}//end getAnswers

public String[] missedQuestions()
{
ArrayList<String> missed = new ArrayList<String>();
for (int index = 0; index < StudAnswers.length;index++)
{		
	if ( StudAnswers[index].compareTo(Answers[index])!= 0)
	{
	missed.add((index + 1) + " ");
	}//end if
}String missedquestions[] = missed.toArray(new String[missed.size()]);
System.out.println ("You missed the following questions: "); 
for (int i = 0; i < missedquestions.length; i++){
System.out.print(missedquestions[i] + " ");
}//end for
return missedquestions;
}//end missedQuestions

}//end class
