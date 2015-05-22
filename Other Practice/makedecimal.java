import java.util.Scanner;


public class makedecimal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String a = in.next();
		String b = in.next();
		String c = in.next();
		
		makedecimal ind = new makedecimal();
		
		String result = ind.getnum(a,b,c);
		
		System.out.print(result);
		in.close();
	}
	public String getnum(String a, String b, String c){
		return a + "." +b +c;
	}
}
