import java.util.*;
/************************************************************************************************************
File name: Driver.java
Author: Matthew Tait 3460396
Date created: March 18/13
Last edited: March 19/13
*************************************************************************************************************
Type: Class
*************************************************************************************************************
Purpose: to implement and test the methods of the G3Calc.java

*************************************************************************************************************
Methods:
        main
*************************************************************************************************************
                                                     
*/
public class Driver
{
    public static void main(String[]args)
    {
       Scanner key = new Scanner(System.in);
       int x;
       int y;
       String operator;
       String keepgoing;
       G3Calc Bob = new G3Calc();
       
       do{
       try
       {
       System.out.println("enter the first number: ");
       x=key.nextInt();
       //clears the scanner
       key.nextLine();
       System.out.println("enter an operator: +, -, *, / ");
       operator=key.nextLine();
        
       while((operator.compareTo("+")!=0) && (operator.compareTo("-")!=0) && (operator.compareTo("*")!=0) && (operator.compareTo("/")!=0))
       {
            System.out.println("That's not a valid operator. Try again ");
            operator = key.nextLine();
       }//end while
       System.out.println("enter the second number: ");
       y = key.nextInt();
     
            switch (operator)
            {
                case "+":
                         Bob.add(x, y);
                         System.out.println(x+"+"+y+"="+ Bob.answer);
                         break;
                case "-":
                         Bob.subtract(x, y);
                         System.out.println(x+"-"+y+"="+ Bob.answer);
                         break;         
                case "*":
                         Bob.multiply(x, y);
                         System.out.println(x+"*"+y+"="+ Bob.answer);
                         break;
                case "/":
                         Bob.divide(x, y);
                         System.out.println(x+"/"+y+"="+ Bob.answer);
                      
            }//end switch case
            
            
      }//end try
      
      catch(InvalidInputException1 first)
      {
          System.out.println("Error"); 
          first.printStackTrace();
      }//end catch
     
      catch(InvalidInputException2 second)
      {
          System.out.println("Error"); 
          second.printStackTrace();
      }//end catch
      
      catch(BadSubtractionException subtract)
      {
          System.out.println("Error");  
          subtract.printStackTrace();  
      }//end catch
      
      catch(BadDivisionException div)
      {
          System.out.println("Error"); 
          div.printStackTrace();  
      }//end catch
      
      catch(InputMismatchException a)
      {
           System.out.println("Error"); 
           System.out.println("that's not a number.");
           a.printStackTrace();
      }//end catch
      
      catch(Exception flagrant)
      {
           System.out.println("Error"); 
           System.out.println("Flagrant system error. You found soemething I missed.");
           flagrant.printStackTrace();
      }//end catch
      
      finally
      {
          key.nextLine();
          System.out.println("do you want to do another? ");
          keepgoing=key.nextLine(); 
      }//end finally
    }while((keepgoing.compareTo("y")==0) || (keepgoing.compareTo("Y")==0));
    
    }//end main
   
}//end class
