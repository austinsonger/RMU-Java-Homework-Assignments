import java.util.Scanner;

/**the scores of a batsman in the five matches of a one day international 
 * series have been provided. 
 * Calculate the total number of runs the batsman scored in the series **/

public class Runinaseries {

	public static void main(String[] args) {
		int a, b, c, d, e;
		
		Scanner in = new Scanner(System.in);
		
		a = in.nextInt();
		b=in.nextInt();
		c=in.nextInt();
		d=in.nextInt();
		e=in.nextInt();
		in.close();
		Runinaseries totalScore = new Runinaseries();
		int result = totalScore.runTotal(a,b,c,d,e);
		System.out.print(result);

	}
	 
	 public int runTotal(int a,int b,int c,int d, int e){
		 return a+b+c+d+e;
	 }

}
