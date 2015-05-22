/**
 * abc.java
 *
 * Version:
 *     $1.0$
 *
 * Author:
 * 	  Shivkumar Dudhani
 * Revisions:
 *     $New$
 * Description
 * Print abc with a thread for each character
 * 
 */

/**
 * Classes : Pattern Thread to create threads for printing 'a','b'&'c'
 * 
 * @author sdudhani
 * 
 */

class pattern_thread implements Runnable {
	/*
	 * Object for locks
	 */
	static Object o1 = new Object();
	static Object o2 = new Object();
	static Object o3 = new Object();
	static boolean flaga = false;
	static boolean flagb = false;
	static boolean flagc = false;
	String info;

	/*
	 * Constructor
	 */
	pattern_thread(String info) {
		this.info = info;
	}

	/*
	 * Run Method
	 */
	public void run() {
		/*
		 * Logic for thread 'a'
		 */
		if (info == "a") {
			while (true) {
				synchronized (o1) {
					System.out.print(info);
					if (flaga == false) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						new Thread(new pattern_thread("b")).start();
						flaga = true;
					}
					synchronized (o2) {
						o2.notify();
					}
					try {
						o1.wait();
					} catch (Exception e) {
						System.out.println("1---");
						e.printStackTrace();
					}
				}
			}
		} else if (info == "b") {
			/*
			 * Logic for thread 'b'
			 */
			while (true) {
				synchronized (o2) {
					System.out.print(info);
					if (flagb == false) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						new Thread(new pattern_thread("c")).start();
						flagb = true;
					}
					synchronized (o3) {
						o3.notify();
					}
					try {
						Thread.sleep(1000);
						o2.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else if (info == "c") {
			/*
			 * Logic for thread 'a'
			 */
			while (true) {
				synchronized (o3) {
					System.out.print(info);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (o1) {
						o1.notify();
					}
					try {
						o3.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}

public class abc {

	public static void main(String[] args) {
		/*
		 * Thread logic start 'a'->'b'->'c'
		 */
		new Thread(new pattern_thread("a")).start();
	}

}
