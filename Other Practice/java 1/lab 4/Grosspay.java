import javax.swing.*;

public class Grosspay
{
public static void main(String[] args)
{
String name;
int hours;
String hou;
float rate;
String rte;
float gross;

//get user's full name
name = JOptionPane.showInputDialog("What is your full name?");
//get user's hours for the week
hou = JOptionPane.showInputDialog("How many hours did you work this week?");
hours = Integer.parseInt(hou);
//get user's pay rate
rte = JOptionPane.showInputDialog("What is your hourly pay rate?");
rate = Float.parseFloat(rte);
//calculate gross pay
gross = ((rate) * (hours));
//display results
JOptionPane.showMessageDialog(null, "Hello " + name + ". Your gross pay is $" + gross); 


}
}