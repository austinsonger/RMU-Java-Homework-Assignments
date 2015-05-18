/*
--Java--
--Austin Vern Songer--
--
--Robert Morris University--
*/
package GradeBook;

/**
 *
 * @author songer
 */
public class GradeBook
	{
private String courseName; // course name for this GradeBook
private String instructorName; // name of course's instructor

// constructor initializes courseName with String supplied as argument
      public GradeBook( String course, String instructor )
	{
courseName = course; // initializes courseName
instructorName = instructor; // initializes instructorName
} // end constructor

// method to set the course name
public void setCourseName( String name )
	{
courseName = name; // store the course name
} // end method setCourseName

// method to retrieve the course name
public String getCourseName()
	{
return courseName;
} // end method getCourseName

// method to set the instructor name
public void setInstructorName( String name )
	{
instructorName = name; // store the course name
} // end method setInstructorName

// method to retrieve the instructor name
public String getInstructorName()
	{
return instructorName;
} // end method getInstructorName

// display a welcome message to the GradeBook user
public void displayMessage()
	{
// this statement calls getCourseName to get the
// name of the course this GradeBook represents
System.out.printf( "Welcome to the grade book for\n%s!\n",
getCourseName() );
System.out.printf( "This course is presented by: %s\n",
	getInstructorName() );
	} // end method displayMessage
} // end class GradeBook


//=============================================================================================//

public class GradeBookTest
 {
 // main method begins program execution
 public static void main( String args[] )
 {
GradeBook gradeBook1;
     gradeBook1 = new GradeBook(
             "CS101 Introduction to Java Programming","Sam Smith" );
     
     gradeBook1.displayMessage(); // display welcome message
     
     System.out.println( "\nChanging instructor name to Judy Jones\n" );
     gradeBook1.setInstructorName( "Judy Jones" );
     
     gradeBook1.displayMessage(); // display welcome message

 } // end main

 } // end class GradeBookTest