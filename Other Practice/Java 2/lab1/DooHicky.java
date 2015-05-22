
// ****************************************************** 
// File Name: Doohicky
// AUTHOR:Matthew Tait 3460396
// Original Date: Jan 17/13
// Last Edited: Jan 21/13
// ****************************************************** 
// Type: Constructor class 
// ****************************************************** 
// PURPOSE: create an object with a random age and gender
//				and what number it is based on order created in
// ****************************************************** 
// Attributes: 
// String name
// int age
// char gender
// int index
// int total
// ****************************************************** 
// Methods: 
// getName
// setName
// getAge
// setAge
// getGender
// setGender
// toString 
// ****************************************************** 

import java.util.Random;

public class DooHicky
{

	 private String name;
	 private int age;
	 private char gender;
	 private int index;
	 private static int total=0;
	 //makes a new random generator
	 Random gen = new Random();

	public DooHicky()
	{
	name=("Bob");
	//set the age
	age = (gen.nextInt(100)+1);
	//set the gender
	gender = randomGender();
	//get the array of index
	 index = 0;
	}//end
	
	public DooHicky(String namein, int agein, char genderin)
	{
	//set name
	name = namein;
	//assigns a random age from 1 to 100
	age = agein;
	//set gender
	gender = genderin;
	//index
	index = 0;
	}//end
	
	public void setName(String namein)
	{
	//set nmae to a user input
	name = namein;
	}//end setName
	
	public void setAge(int agein)
	{
	age = agein;

	}//end setAge
	
	public int getAge()
	{
	return age;
	}//end getAge
	
	public void setGender(char genderin)
	{
	gender = genderin;
	}//end setGender
	
	public char getGender()
	{
	return gender;
	}//end getGender
	
	public char randomGender()
	{
	int temp;
	//assigns a random number from 1 to 3 to a dummy variable
	temp = (gen.nextInt(3)+1);
		//assigns the gender character based on the random number
		 if(temp==1)
		 {
		 gender = 'M';
		 }//end if
	 	 else if(temp==2)
		 {
		 gender = 'F';
		 }//end else if
	 	 else	if(temp==3)
		 {
		 gender = 'O';
		 }//end else if
		 return gender;
	}//end setGender
	

	
	 public String toString()
	{
	String gen= new String();
	String upper= new String();
	String lower = new String(); 
		if(gender=='M')
		{
		upper =("He is");
		lower = ("he is");
		gen=("a male");
		}//end if
		if (gender=='F')
		{
		upper =("She is");
		lower = ("she is");
		gen=("a female");
		}//end if
		if (gender=='O')
		{
		upper =("They are");
		lower = ("they are");
		gen = ("an other");
		}//end if
	
	
	 return "This is " + name + ", " + lower + " " + age + " and " + gen + ". " + upper + " #" + (index+1) + " of " + total;
	
	
	}//end toString
	
	public void setIndex(int i)
	{
	index=i;
	}

	public int getIndex()
	{
	return index;
	}//end getIndex
	
	public void setTotal(int t)
	{
	total = t;
	}
	
	public int getTotal()
	{
	return total;
	}//end getTotal
	
}