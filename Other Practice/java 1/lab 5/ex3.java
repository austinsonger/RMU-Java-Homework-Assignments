   import java.util.Scanner;

   public class ex3
   {
   
   
      public static void main(String[]args)
      {
      String output = new String (getname());
      System.out.println ("Your name is " + output);
      //System.out.println (getname());
      }
      
      private static String getname()
      {
         Scanner key =new Scanner (System.in);
         String name = new String();
      
         System.out.println ("What is your name?: ");
         name = key.nextLine();
         return name;
      }
    	
   	
   }