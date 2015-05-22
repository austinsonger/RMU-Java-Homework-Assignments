import java.util.Scanner;


public class requiredrunrate {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 float target = in.nextFloat();
		 float maxOvers = in.nextFloat();
		 float currentScore = in.nextFloat();
		 float oversBowled = in.nextFloat();
		 
		 requiredrunrate reqrunrate = new requiredrunrate();
		 
		 float result = reqrunrate.getrunrate(target, maxOvers, currentScore, oversBowled);
		 
		 System.out.print(result);
		 
		 in.close();

	}
	
	public float getrunrate(float target,float maxOvers, float currentScore, float oversBowled) {
		
		float remScore = target - currentScore;
		float remOvers = maxOvers - oversBowled;
		
		return remScore/remOvers;
		
	}
}
