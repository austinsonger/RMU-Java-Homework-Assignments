public class Student   
{
    // data Members
    private String name;
    private  int  age;
	 private String email;
    //Constructor is a special method executed when a new instance
     // of the class  is created

    public Student ( )    // constructor has the same name as the class
    { 
          System.out.println("in Constructors"); 
          name = "Unassigned";
          age = 0;
          email = "Unassigned"; 
    }
          //Assigns the name of this students
          public void setName(String stdname)
          { 
               System.out.println("in setName Method ");
               name = stdname;
          }

          //Assigns the age of the student
          public void setAge(int num)
          {
                  System.out.println("in setAge Method ");
                  age = num;
						
          }
           // Returns the name of the student
          public String getName( )
         {
            	System.out.println("in getName Method ");
             	return name;
          }
         // Returns the age of the student
           public int getAge( )
		   {
            	System.out.println("in getAge Method ");
             	return age;
          }
			  

}

