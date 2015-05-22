import java.util.Scanner;


public class threeDigitNumber {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String a = in.next();
		
		threeDigitNumber make = new threeDigitNumber();
		
		String result = make.getdigit(a);
		
		System.out.print(result);
		
		in.close();

	}
	
	public String getdigit(String a){
		return a + a +a ;
		
	}
}
