import java.util.Scanner;


public class secondstohours {

	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			
			int a = in.nextInt();
			
			secondstohours total = new secondstohours();
			
			int result = total.gethours(a);
			
			System.out.print(result);
			in.close();
	}

	public int gethours(int a){
		return a/3600;
	}
}
