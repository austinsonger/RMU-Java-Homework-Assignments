import java.util.Scanner;

//   Given a 2 digit number as input, compute the sum of its digits. Assume that the number has 2 digits.
//		sum2Digits(12) = 3 (1+2 = 3)
//		sum2Digits(10) = 1 (1+0 = 0)
//		sum2Digits(96) = 15 (9+6 = 15) 


public class sumdigit {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		
		sumdigit s = new sumdigit();
		
		int result = s.getsum(a);
		
		System.out.print(result);
		
		in.close();

	}
	
	public int getsum(int a)
	{
		int temp = a%10;
		a =a/10;
		return temp+a;
	}

}
