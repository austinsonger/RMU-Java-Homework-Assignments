/**
 * Sort.java
 *
 * Version:
 *     $1.0$
 *
 * Author:
 * 	  Shivkumar Dudhani && Vishal Dsouza
 * Revisions:
 *     $New$
 * Description
 * Implement Generic Bubble Sort
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/**
 * Implementation for bubble sort
 *
 * @param <T> Generic Type
 */

class BubbleSort<T>{
	ArrayList<T> list;
	
	//Constructor
	BubbleSort()
	{
		/*
		 * Instantiate the list
		 */
		list = new ArrayList<T>();
	}

	/**
	 * Add Elements to the list
	 * @param e Element
	 */
	void addToList(T e)
	{
		list.add(e);
	}
	/**
	 * Get the list
	 * @return list
	 */
	public List<T> getList()
	{
		return list; 
	}
/**
 * Sort the list using the comparator
 * @param list list
 * @param c Comparator
 */
	public void sort(List<T> list,Comparator<T> c)
	{
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 0; i < list.size()-1; i++) {
            	if(c.compare(list.get(i), list.get(i+1))>0)
            	{            	swap(list,i,i+1);
                    swapped = true;
            	}}  
        } while (swapped);
	}		

	/**
	 * Swap left and right element in the list
	 * @param list list
	 * @param left element
	 * @param right element
	 */
	public void swap(List<T> list,int left,int right)
	{
		T temp = list.get(left);
		list.set(left, list.get(right));
		list.set(right, temp);
	}

	/**
	 * Display the list
	 * @param list list
	 */
	public void display(List<Integer> list)
	{
		Iterator<Integer> itr = list.iterator();
		System.out.println("Sort : ");
		while(itr.hasNext())
		{
			System.out.println(itr.next().toString());
		}
		
	}

/**
 * Define Generic Comparator
 * the generic type <T> must have implemented interface Comparable
 */
	public Comparator<T> c = new Comparator<T>(){
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public int compare(T arg0, T arg1) {
			return ((Comparable)arg0).compareTo((Comparable)arg1);}
	};
	

}

/**
 * Sort the list
 * @author sdudhani
 *
 */
public class Sort{

	public static void main(String[] args) {		

		/*
		 * Instantiate the sort class for type <Integer>
		 */
		BubbleSort<Integer> sort = new BubbleSort<Integer>();
		//Add Elements to List of type specified while instantiate the class
		sort.addToList(8);		
		sort.addToList(4);		
		sort.addToList(2);		
		sort.addToList(1);		
		sort.addToList(7);		
		sort.addToList(11);		
		sort.addToList(3);		
		sort.addToList(44);

		List<Integer> list ;//List to hold the details for temp
		list = sort.getList();
		//Calling the sort using comparator
			sort.sort(list, sort.c);
			//Display the sorted array
			sort.display(list);			
	}

}
