public class PassObject 
{
   public static void main(String[] args)
   {
      // Create a String object containing "Obama". The name variable references the object.
		String name = new String("Obama");
		
		// Display the String referenced by the name variable.
		System.out.println(name);
		
		// Call the changePresident method, passing the  contents of the name variable as an argument.
		changePresident(name);
      
      // Display the String referenced by the name variable.
		System.out.println(name);
   }//end main
   
// The changePresident  method accepts a String as its argument and assigns the str parameter to a new String.
   
   public static void changePresident(String str)
   {
       //Display the string received by changePresident
 
		System.out.println(str);
 		// Create a String object containing "Romney" and assign its address to the str parameter variable.
		str = ("Romney");
      // Display the String referenced by  the string name
		System.out.println(str);
   }//end method changePresident
}//end class

