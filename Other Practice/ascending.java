import java.util.Scanner;

//Given 3 numbers : num1, num2 and num3 as input, return true if they are in ascending order.
//Important:Do not use if statement in solution.
//inAscendingOrder(2,4,6) = true
//inAscendingOrder(2,6,4) = false

public class ascending {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int num1 = in.nextInt();
		int num2 = in.nextInt();
		int num3 = in.nextInt();

		ascending as = new ascending();

		boolean result = as.getresult(num1, num2, num3);

		System.out.print(result);
		in.close();
	}

	public boolean getresult(int a, int b, int c){
		return (a<b) && (b<c);
	}
}
