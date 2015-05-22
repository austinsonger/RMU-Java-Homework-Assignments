
/**
 *************************************
  Name.Java
  Matthew Tait  3460396
  created: Jan 28/13
  last modified: 
 *************************************
 Type: Constructor Class
 *************************************
  attributes
            String first
            int mid
            string[] middle
            string last
            int suff
            string[] suffix
            string prefix
            scanner key
 *************************************
 purpose: builds a Name object
          asking for all variables
          as the object is being built
 *************************************
 methods:
            correctFirst
            correctMiddle
            correctLast
            correctPrefix
            correctSuffix
            getFirst
            getMiddle
            getLast
            getPrefix
            getSuffix
 ************************
*/
 
import java.util.Scanner;
public class Name implements Printable
                               
{
   String first;
   int mid;
   String[] middle;
   String last;
   int suff;
   String[] suffix;
   String prefix;
   Scanner key = new Scanner(System.in);

public Name ()
{
    //sets first to the user input
    System.out.println("Enter your first name:");
    first = key.nextLine();
    correctFirst();  
        
    //asks for and sets the number of middle names
    System.out.println("Enter the number of middle names you have");
    mid = key.nextInt();
    key.nextLine();
    middle=new String[mid];
    //creates an array of middle names based on the user input   
        for(int i=0; i<mid; i++)
        {
          System.out.println("Enter your " + (i+1) + " middle name: ");  
          middle[i] = key.nextLine(); 
        }//end for
    correctMiddle();
    //sets last to the user input
    System.out.println("Enter your last name: ");
    last = key.nextLine();
    correctLast();
    
    //sets prefix to the user input
    System.out.println("Enter any prefix to your name, i.e. dr., reverend, etc. ");
    prefix = key.nextLine();
    correctPrefix();
    
    //asks for and sets the number of suffixes the user has
    System.out.println("Enter the number of suffixes to your name: ");
    suff = key.nextInt();
    key.nextLine();
    suffix = new String[suff];
        //creates an array of suffixes based on user input
        for(int i =0; i<suff; i++)
        {
            System.out.println("Enter your " + (i+1) + " suffix(i.e. phd, md, etc.): ");
            suffix[i] = key.nextLine();
        }//end for    
    correctSuffix();    
}//end Name constructor

//returns first as a string 
public String getFirst()
    {
       return first;
    }//end getFirst
    
//returns middle as an array of strings
public String[] getMiddle()
    {
        return middle;    
    }//end getMiddle
    
//returns last as a string    
public String getLast()
    {
        return last;
    }//end getLast
    
//returns suffix as an array of strings
public String[] getSuffix()
    {
        return suffix;
    }//end getSuffix
    
//returns prefix as a string
public String getPrefix()
    {
        return prefix;    
    }//end getPrefix   

//asks if the entered name is correct, then asks for a new input if not correct    
public void correctFirst()
    {
      String yesno = new String ();
      System.out.println("Is this correct?: " + first);
      yesno = key.nextLine();
        while (yesno.compareToIgnoreCase("no")==0)
        {
            System.out.println("Enter your first name:");
            first = key.nextLine();
            System.out.println("Is this correct?: " + first);
            yesno = key.nextLine();
        }//end while
    }//end correctFirst

//asks if the entered name(s) is correct, then asks for a new input if not correct 
public void correctMiddle()
    {
        String yesno = new String();
        for (int i = 0; i<mid; i++)
        {
            System.out.println("Is this correct?: " + middle[i]);
            yesno = key.nextLine();
                while (yesno.compareToIgnoreCase("no")==0)
                {  
                    System.out.println("Enter your " + (i+1) + " middle name: ");  
                    middle[i] = key.nextLine();
                    System.out.println("Is this correct?: " + middle[i]);
                    yesno = key.nextLine();
                }//end while
        }//end for
    }//end correctMiddle
    
//asks if the entered name is correct, then asks for a new input if not correct       
public void correctLast()
{
      String yesno = new String ();
      System.out.println("Is this correct?: " + last);
      yesno = key.nextLine();
        while (yesno.compareToIgnoreCase("no")==0)
        {
            System.out.println("Enter your last name:");
            last = key.nextLine();
            System.out.println("Is this correct?: " + last);
            yesno = key.nextLine();
        }//end while
    }//end correctLast
    
//asks if the entered suffix(s) is correct, then asks for a new input if not correct   
public void correctSuffix()
{
     String yesno = new String();
        for (int i = 0; i<suff; i++)
        {
            System.out.println("Is this correct?: " + suffix[i]);
            yesno = key.nextLine();
                while (yesno.compareToIgnoreCase("no")==0)
                {  
                    System.out.println("Enter your " + (i+1) + " suffix: ");  
                    suffix[i] = key.nextLine();
                    System.out.println("Is this correct?: " + suffix[i]);
                    yesno = key.nextLine();
                }//end while
        }//end for  
}//end correctSuffix

//asks if the entered prefix is correct, then asks for a new input if not correct
public void correctPrefix()
{
      String yesno = new String ();
      System.out.println("Is this correct?: " + prefix);
      yesno = key.nextLine();
        while (yesno.compareToIgnoreCase("no")==0)
        {
            System.out.println("Enter any prefix to your name, i.e. dr., reverend, etc. ");
            last = key.nextLine();
            System.out.println("Is this correct?: " + suffix);
            yesno = key.nextLine();
        }//end while
    }//end correctPrefix  

public void printClass()
{
  System.out.print(prefix + " ");  
  System.out.print(first + " "); 
  for (int i=0; i<mid;i++)
  {
      System.out.print (middle[i] + " ");
  }//end for
  
  System.out.print (last + " ");
  for(int i=0; i<suff;i++)
  {
      System.out.print(suffix[i] + " ");
  }//end for
}//end printClass

public int varCount()
{
    int var = 10;
    return var;
}//end varCount

}//end class