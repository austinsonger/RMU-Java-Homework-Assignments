// This program shows how you activate the Student class’s setName, setAge, 
//  getName, and getAge methods.

     public class StudentDemo
{
      public static void main(String [] args)
       {
           // create an instance of the class Student 
               	 Student  Stud1 = new Student ( ); 

// call methods setName and passing Zombie as an argument
                	  Stud1.setName ("Zombie");

// call methods setAge and passing 99 as an argument
                 	 Stud1.setAge (99);
						 
// call methods setEmail 
		//				 Stud1.setEmail (
						
// call methods setID 
				//		 Stud1.setID (											 

// Display  stud1’s name and age
  	  	System.out.println("Stud1’s name is "  + Stud1.getName());
   	    	 System.out.println("Stud1’s age  is "    + Stud1.getAge());
				// System.out.println("Stud1's email is "  + Stud1.getEmail());
				// System.out.println("Stud1's ID is "  +Stud1.getID());
     }
}
