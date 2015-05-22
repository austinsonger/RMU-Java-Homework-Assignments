import java.text.DecimalFormat;
/**
 * Penny.Java
 * Matthew Tait 3460396
 * created Feb.14/13
 * last modified Feb 14/13
 * ********************
 * Type: application
 * 
 * ********************
 * attributes
 * double price
 * int costup
 * int costdown
 * int costsame
 * int total
 * ********************
   methods
        main
 *********************
 purpose: to calculate the different tax rates from 0% to 15% at which
 the amount from .01 to 20.00 is rounded up or down, and what percentage
 thereof.
 
 *********************
*/

public class Penny
{


    public static void main (String[]args)
    {
        
        double price;
        int costup;
        int costdown;
        int costsame;
        int total;
       
        System.out.println("tax  | same  |  up   |  down ");
            for (double tax=0.0; tax<=0.15; tax = tax+0.01)
            {
                
                costup = 0;
                costdown = 0;
                costsame = 0;
                total = 0;
                
                for (double i=0.01; i<=20.0; i=i+0.01)
                {
                    price = i * (1+tax);
                    int aftertax = (int)(price*100);
                    int remain = (aftertax%10);
                    
                    switch (remain)
                    {
                        case 0: 
                        case 5: 
                                costsame++;
                                break;
                        case 1:
                        case 2:
                        case 6:
                        case 7:
                                costdown++;
                                break;
                        case 8:
                        case 9:
                                costup++;
                                break;
                       
                    }//end switch
                   
                    total++;
 
                    }//end for
                
                double costsamepercent = ((double)costsame/total)*100;
                double costuppercent = ((double)costup/total)*100;
                double costdownpercent = ((double)costdown/total)*100;
                
                DecimalFormat df = new DecimalFormat("##0.00");
                
                System.out.println(df.format(tax) + " | " + df.format(costsamepercent) + "% | " + df.format(costuppercent) + "% | " + df.format(costdownpercent) + "%");
                
            }//end for
            
               
    }//end main
}//end penny
