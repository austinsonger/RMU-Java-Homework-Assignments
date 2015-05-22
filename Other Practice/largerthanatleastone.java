import java.util.Scanner;

//Larger than at least one    
//Given three numbers as input, num, num1 and num2, return true if num is greater than atleast one of num1 and num2. Do not use if statement to solve this problem.
//largerThanOne(24,10,36) = true
//largerThanOne(50,60,76) = false
//largerThanOne(20,10,0) = true

public class largerthanatleastone {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		largerthanatleastone larger = new largerthanatleastone();
		
		boolean result = larger.getresult(a,b,c);
		System.out.print(result);
		in.close();
	}
	
	public boolean getresult(int a, int b, int c){
		return (a>b) || (a>c);
		
	}

}
