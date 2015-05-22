import java.util.Scanner;

//Given three booleans as input, return the and of the all three booleans

public class bolenthree {
	
	public static void main(String[] args) {
		
	 Scanner in = new Scanner(System.in);
		
		boolean a = in.nextBoolean();
		boolean b = in.nextBoolean();
		boolean c = in.nextBoolean();
		
		bolenthree bo = new bolenthree();
		
		boolean result = bo.getresult(a,b,c);
		System.out.print(result);
		in.close();
	}
	
	public boolean getresult(boolean a, boolean b, boolean c){
		
		return a && b && c;
		
	}
}
