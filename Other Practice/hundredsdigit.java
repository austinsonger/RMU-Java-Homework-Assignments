import java.util.Scanner;


public class hundredsdigit {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		
		hundredsdigit hundreddigit = new hundredsdigit();
		
		int result = hundreddigit.getdigit(a);
		
		System.out.print(result);
		in.close();
	}

	public int getdigit(int a) {
		int temp =  a/100;
		return temp%10;
	}
}
