/******************************************************
File name: G3Calc.java
Author: Matthew Tait 3460396
Date created: March 11/13
Last edited: Mar.19/13
******************************************************
Type: Class
******************************************************
Purpose:
        a simple calculator that adds, 
        subtracts, multiplies and divides
******************************************************
Attributes:
            
           protected int a
           protected int b
           protected int result
******************************************************
Methods:
       void add(a,b)
       void subtract(a,b)
       void multiply(a,b)
       void divide(a,b)
******************************************************
                                                     
*/

public class G3Calc
{
    protected int a;
    protected int b;
    protected int answer;
    
    

    public void checkValid(int a, int b)throws InvalidInputException1, InvalidInputException2
    {
        if (a<0)
            throw new InvalidInputException1();
        if (b<0)
            throw new InvalidInputException2();
    }//end checkValid
        
    public int add(int a, int b) throws InvalidInputException1, InvalidInputException2
    {
        this.checkValid(a, b);
        answer = (a+b);
        return answer;
    }//end add
    
    public int subtract(int a, int b)throws BadSubtractionException, InvalidInputException1, InvalidInputException2
    {
        this.checkValid(a, b);
        if (b>a)
        {
            throw new BadSubtractionException();
        }//end if
        else
        {
            answer = (a-b);
            return answer;
        }//end else
     
    }//end subtract
    
    public int multiply(int a, int b) throws InvalidInputException1, InvalidInputException2
    {
       this.checkValid(a, b);
       answer = (a+a*(b-1));
       return answer;
    }//end multiply
    
    public int divide(int a, int b) throws InvalidInputException1, InvalidInputException2, BadDivisionException, ArithmeticException
    {
        this.checkValid(a, b);
        if (b>a)
        {
            throw new BadDivisionException();
        }//end if
        else if(b==0)
        {
            throw new ArithmeticException("divid by zero is like crossing the streams; don't do it");
        }//end else if
        
        else if((a%b)!=0)
        {
            throw new BadDivisionException();            
        }//end else if
        else 
        {
            answer = (a/b);
            return answer;
        }//end else
        
    }//end divide
    
    
    
}
