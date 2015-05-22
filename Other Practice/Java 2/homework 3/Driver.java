import java.util.Calendar;
/**
 *****************************************************
 File Name: Driver.Java
 AUTHOR: Matthew Tait 3460396
 Original Date: Feb.22/13 
 Last Edited: Feb.2x/13
 ******************************************************
 Type: Class
 ******************************************************
 PURPOSE: creates an array of the different record objects
          and tests methods in them
 
 ******************************************************
 Attributes:
            
 ******************************************************
 *Methods: main
 *          
 ******************************************************
 */
public class Driver
{
    public static void main(String[]args)
    {
        //creates and populates a test array of dates
        Date[]test1 = new Date[4];
        Date a = new Date(1,1,1984);
        Date b = new Date(4, 14, 1983);
        Date c = new Date(5, 13, 1973);
        test1[0] = a;
        test1[1] = b;
        test1[2] = c;
        
        //creates and populates a test array of dates
        Date[]test2 = new Date[4];
        Date d = new Date(1, 2, 1999);
        Date e = new Date(3, 4, 1921);
        Date f = new Date(4, 6, 1888); 
        test2[0] = d;
        test2[1] = e;
        test2[2] = f;
        
        //creates a test array of Strings
        String[]testa = new String[4];
        testa[0] = ("stuff");
        testa[1] = ("more stuff"); 
        testa[2] = ("even more stuff");
        
        //creates a test array of strings
        String[]testb = new String[4];
        testb[0] = ("other");
        testb[1] = ("description");
        testb[2] = ("other description");
        
        Date testalpha = new Date(3, 2, 1990);
        Date testBeta = new Date(4,6, 1989);
        
        Record[]records = new Record[4];
        
                
        DogRecord Alpha = new DogRecord("Mickey", 1, test1, testa, testalpha);
        CatRecord Beta = new CatRecord("Minnie", 2, test2, testb, testBeta);
        ParrotRecord Gamma = new ParrotRecord("Donald", 3, test1, testa, Shape.WACKY, "NoPantsLand");
        BudgieRecord Delta = new BudgieRecord("Daisy", 4, test2, testb, Shape.WACKY, "white, pink, blue");
      
        records[0] = Alpha;
        records[1] = Beta;
        records[2] = Gamma;
        records[3] = Delta;
        
        
        
        for (int i=0; i<records.length; i++)
        {
           records[i].addTreatment();
           records[i].print(); 
        }//end for
        
    }//end main
    
}
