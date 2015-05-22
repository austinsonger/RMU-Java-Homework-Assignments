/**
 * Integral.java
 *
 * Version:
 *     $1.0$
 *
 * Author:
 * 	  Shivkumar Dudhani
 * Revisions:
 *     $New$
 * Description
 * 	  double integral of a function using threads
 */

/**
 * 
 * @author sdudhani
 * 
 */
class Graph {
	/*
	 * Number of slices along X axis
	 */
	private int div = 100;
	/*
	 * Range for the function
	 */
	static int count=0;
	double xmin = -1;
	double xmax = 1;
	double ymin = -2;
	double ymax = 2;
	double zmin;
	double zmax;
	double thread_area = 0.1;
	double error_delta = 0.01;
	private double vol = 0;
	double dx;

	synchronized void addcount()
	{
		count++;
	}
	synchronized void subcount()
	{
		count--;
	}
	/**
	 * Determine the Range of Z
	 */
	void zRange() {
		zmax = Math.max(Math.max(function(xmin, ymin), function(xmin, ymax)),
				Math.max(function(xmax, ymin), function(xmax, ymax)));
		zmin = Math.max(Math.min(function(xmin, ymin), function(xmin, ymax)),
				Math.min(function(xmax, ymin), function(xmax, ymax)));
	}

	/**
	 * Synchronized addition of volume
	 * 
	 * @param vol
	 */
	synchronized void add_volume(double vol) {
		subcount();
		this.vol = this.vol + vol;
	}

	/**
	 * Function
	 * 
	 * @param x
	 * @param y
	 * @return z
	 */
	double function(double x, double y) {
		return ((x * x) + (2 * y));
	}

	/**
	 * Compute the double Integral
	 */
	void double_integral() {
		/*
		 * get range of z
		 */
		zRange();
		zmax = Math.abs(zmax);
		zmin = Math.abs(zmin);

		/*
		 * As the area would be symetrical lets get
		 * 
		 * the abolute value of all and compute for positive axis only
		 */
		/*
		 * The function would give a 3-D surface and
		 * 
		 * the area under the curve has to be computed We take a slice along
		 * 
		 * the x-axis to get a 2-D surface which is single integral with for
		 * 
		 * a function of y where x is fixed for each slice
		 */
		/*
		 * dx is the width of the slice, the smaller
		 * 
		 * the value the closer we are to the actual value
		 */
		dx = (xmax - xmin) / div;
		for (double x = xmin; x < xmax; x = x + dx) {
			/*
			 * for each value of x determine the
			 * 
			 * area under the curve
			 */
			single_integral(x);
		}
	}

	/**
	 * Compute the single integral
	 * 
	 * @param x
	 */
	void single_integral(double x) {
		/*
		 * for the given X, determine the surface
		 * 
		 * using the function and range of y thread_area
		 */

		for (double y = ymin; y < ymax; y += thread_area) {
			for (double z = 0; z < zmax; z += thread_area) {
/**
 * Create threads
 */
				new Thread(new Area(y,z,x)).start();
			}
		}
	}

	class Area implements Runnable {
		double y0;
		double z0;
		double x;

		/**
		 * Constructor for area
		 * 
		 * @param ymin
		 * @param zmin
		 * @param xmin
		 */
		Area(double ymin, double zmin, double xmin) {
			y0 = ymin;
			z0 = zmin;
			x = xmin;
		}

		/**
		 * Triger method
		 */
		public void run() {
			computeArea1();
		}

		/**
		 * Compute the area under the curve
		 * 
		 * @param y0
		 * @param z0
		 * @param x
		 */
		void computeArea1() {
			addcount();
			/*
			 * Green Area - < integral using inner limits
			 * 
			 * Yellow Area - <integral using outer limits
			 */
			double greenArea = 0;
			double yellowArea = 0;
			int div = 2;
			double z = 0;
			double z1 = z0 + thread_area;
			double gap;
			gap = Math.abs(thread_area);
			do {
				gap = gap / div;
				greenArea = 0;
				yellowArea = 0;
				/*
				 * Compute Green Area
				 */
				for (double y = y0; y < y0 + thread_area; y = y + gap) {
					z = Math.abs(function(x, y));
					if ((z >= z0) && (z < z1)) {
						greenArea += (function(x, y) * gap);
					}
				}
				/*
				 * Compute for Yellow Area
				 */
				for (double y = y0 + gap; y <= y0 + thread_area; y = y + gap) {
					z = Math.abs(function(x, y));
					if ((z >= z0) && (z < z1)) {
						yellowArea += (function(x, y) * gap);
					}
				}
			} while ((Math.abs((greenArea) - (yellowArea))) > 0.001);
			/*
			 * As the error is area computed above goes
			 * 
			 * less than error_delta add the area to total area
			 */
			add_volume((greenArea * dx));
		}

	}

	void computeArea(double y0, double z0, double x) {
		/*
		 * Green Area - < integral using inner limits
		 * 
		 * Yellow Area - <integral using outer limits
		 */
		double greenArea = 0;
		double yellowArea = 0;
		int div = 2;
		double gap = 0;
		gap = (ymax - ymin);
		do {
			gap = gap / div;
			greenArea = 0;
			yellowArea = 0;
			/*
			 * Compute Green Area
			 */
			for (double y = y0; y < ymax; y = y + gap) {
				greenArea += (function(x, y) * gap);
			}
			for (double y = y0 + gap; y <= ymax; y = y + gap) {
				yellowArea += (function(x, y) * gap);
			}
		} while ((Math.abs((greenArea) - (yellowArea))) > 0.001);
		/*
		 * As the error is area computed above goes
		 * 
		 * less than error_delta add the area to total area
		 */
		add_volume(Math.abs(greenArea * dx));
	}

	/**
	 * Get the Double Integral
	 */
	void getDoubleIntegral() {
		while(count!=0)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out
				.println("The double integral of the function/ Volume under the curve is : "
						+ vol);
	}
}

/**
 * Compute the double integral for the give function
 * 
 * @author sdudhani
 * 
 */
public class Integral {
	public static void main(String[] args) {
		/*
		 * Get the double integral of the function f
		 * 
		 * (x,y)
		 */
		Graph sol = new Graph();
		sol.double_integral();
		/*
		 * Display the double Integral
		 */
		sol.getDoubleIntegral();
	}
}