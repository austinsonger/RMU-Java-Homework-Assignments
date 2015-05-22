/**
 * Shuffle.java
 *
 * Version:
 *     $1.0$
 *
 * Author:
 * 	  Shivkumar Dudhani
 * Revisions:
 *     $New$
 * Description
 * Shuffle implementation using Fisher Yates shuffle
 */
import java.util.*;

/**
 * 
 * Implementation for shuffle
 * 
 * @param <T>
 *            generic type
 */
class Imp<T> {
	List<T> list; // List

	Imp() // Constructor
	{
		list = new ArrayList<T>();
	}

	/**
	 * Add Elements to list
	 * 
	 * @param e
	 *            element
	 */
	void addToList(T e) {
		list.add(e);
	}

	/**
	 * get the list
	 * 
	 * @return list
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * Fisher Yates shuffle for each elements from start get a random index for
	 * replacement replace and then get random number from the list excluding
	 * the one found before
	 * 
	 * @param list
	 */
	public void shuffle(List<T> list) {
		Random rand = new Random();
		for (int i = list.size(); i > 0; i--) {
			swap(list, i - 1, rand.nextInt(i));
		}
	}

	/**
	 * Swap left and right
	 * 
	 * @param list
	 *            list
	 * @param left
	 *            element
	 * @param right
	 *            element
	 */
	public void swap(List<T> list, int left, int right) {
		T temp = list.get(left);
		list.set(left, list.get(right));
		list.set(right, temp);
	}

	/**
	 * Display list
	 * 
	 * @param list
	 *            list
	 */
	void display_list(List<Integer> list) {
		Iterator<Integer> itr = list.iterator();
		System.out.println("Shuffle : ");
		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
	}
}

/**
 * Shuffle
 * 
 * @author sdudhani
 * 
 */
public class Shuffle {

	public static void main(String[] args) {
		/*
		 * Instantiate the class using generic type as <Integer>
		 */
		Imp<Integer> imp = new Imp<Integer>();
		// Create list
		imp.addToList(1);
		imp.addToList(2);
		imp.addToList(3);
		imp.addToList(4);
		imp.addToList(5);
		imp.addToList(6);
		imp.addToList(7);
		imp.addToList(8);
		List<Integer> list;

		list = imp.getList();// Temp list
		// Shuffle
		imp.shuffle(list);
		// Display the list
		imp.display_list(list);
	}

}
