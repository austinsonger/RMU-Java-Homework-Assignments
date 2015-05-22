public class MethodOverload1 
{
    
      void add(int a, int b, int c)       {
        int sum = a + b + c;
        System.out.println("Sum of a+b+c is "+sum);
      }
     void add(double a, double b)             {
        double sum = a + b;
        System.out.println("Sum of a+b is "+sum);
      }
     void add(String s1, String s2)
      {
       String s = s1+s2;
       System.out.println(s);
     }
}
 