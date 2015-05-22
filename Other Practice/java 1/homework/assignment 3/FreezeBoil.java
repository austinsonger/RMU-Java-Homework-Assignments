import java.util.Scanner;

public class FreezeBoil
{
	//constructor
	public FreezeBoil (){
	}
	//methods
	  public boolean	isEthylFreezing(int temp)
	  { if (temp <= -173)
	  	return true;
		else return false;
		}//end isEsthylFreezing
	 
	 public boolean	isEthylBoiling(int temp)
	  { if (temp >= 172)
	  	return true;
		else return false;
		}//end isEthylBoiling
		
	 public boolean	isOxygenFreezing(int temp)
	  { if (temp <= -362)
	  	return true;
		else return false;
		}//end isOxygenFreezing
	
	 public boolean	isOxygenBoiling(int temp)
	  { if (temp >= -306)
	  	return true;
		else return false;
		}//end isOxygenBoiling
	
	 public boolean	isWaterFreezing(int temp)
	  { if (temp <= 32)
	  	return true;
		else return false;
		}//end isWaterFreezing
	
	 public boolean	isWaterBoiling(int temp)
	  { if (temp >= 212)
	  	return true;
		else return false;
		}//end isWaterBoiling
	
}//end class  