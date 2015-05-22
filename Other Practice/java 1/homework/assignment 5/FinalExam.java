import java.util.Scanner;

public class FinalExam
{
String Answers[] = new String[] {"B", "D", "A", "A", "C", "A", "B", "A", "C", "D", "B", "C", "D", "A", "D", "C", "C", "B", "D", "A"};
String inputanswers[] = new String[20];
int MissedAnswers[] = new int[20];

Scanner key = new Scanner(System.in);

public static void main(String[]args)
{
ExamMethods exam = new ExamMethods();
exam.getAnswers();
exam.correctAnswers();
int correct = exam.wrongAnswers();
exam.PassedorFailed(correct);
exam.missedQuestions();	
}//end main

}//end class