/**
 * Center.java
 *
 * Version:
 *     $1.0$
 *
 * Author:
 * 	  Shivkumar Dudhani
 * Revisions:
 *     $New$
 * Description
 * 	  Find the Center of all points
 */
import java.io.File;
import java.util.Scanner;

/**
 * Class : Process the center of all the points 1>Read the points from the file
 * 2>Determine the distance between the points to determine the point at min
 * distance to all
 * 
 * @param delta
 *            delta for calculations
 */
class CenterOfSystem {
	Scanner scan;
	double coordinates[][];
	int count;
	double minDist;

	/*
	 * Method : Constructor Read the file for the coordinates of the points
	 */
	CenterOfSystem(String file) {
		// Get the coordinate count
		try {
			count = getCoordinatesCount(file);
			initCoordinateArray(count);

			getCoordinates(file); // Load the coordinates

			computeDistance();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/*
	 * Method : getCenterObjects
	 */
	void getCenterObjects() {
		if (count > 0) {
			System.out.println();
			System.out
					.println("Points to be considered as Center of objects : ");
			for (int i = 0; i < count; i++) {
				if (minDist == coordinates[i][3]) {
					System.out.println(coordinates[i][3]);

					System.out.println(coordinates[i][0] + " - "
							+ coordinates[i][1] + " - " + coordinates[i][2]);
				}
			}
		} else {
			System.out.println("No Points");
		}
	}

	/*
	 * Method : computeDistance
	 */
	void computeDistance() {
		double dist;
		minDist = 0;
		for (int i = 0; i < count; i++) {
			dist = 0;
			for (int j = 0; j < count; j++) {
				if (j != i) {
					dist = dist
							+ getDistance(coordinates[i][0], coordinates[i][1],
									coordinates[i][2], coordinates[j][0],
									coordinates[j][1], coordinates[j][2]);

				}
			}
			if (i == 0) {
				minDist = dist;
			} else {
				if (minDist > dist) {
					minDist = dist;
				}
			}
			coordinates[i][3]=dist;
		}
	}

	/*
	 * Method : getDistance
	 * 
	 * @param x1 coordinate-x pt1
	 * 
	 * @param y1 coordinate-y pt1
	 * 
	 * @param z1 coordinate-z pt1
	 * 
	 * @param x2 coordinate-x pt2
	 * 
	 * @param y2 coordinate-y pt2
	 * 
	 * @param z2 coordinate-z pt2
	 * 
	 * @return distance
	 */
	double getDistance(double x1, double y1, double z1, double x2, double y2,
			double z2) {
			double x;
		x= Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)
				+ Math.pow(z1 - z2, 2));
		return x;
	}

	/*
	 * Method : Get coordinate count
	 * 
	 * @param file Filename
	 * 
	 * @return count
	 */
	int getCoordinatesCount(String file) {
		String float_pattern = "[-+]?\\d+.?\\d*";
		String pattern = float_pattern + "\\s" + float_pattern + "\\s"
				+ float_pattern;
		int index = 0;
		try {
			scan = new Scanner(new File(file));// Init the scanner
			while (scan.hasNextLine()) { // Check the scanner to read the file
				if (scan.nextLine().matches(pattern)) {
					index++;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
		scan.close();
		return index;
	}

	/*
	 * Method : Init the coordinate array
	 * 
	 * @param size array size
	 */
	void initCoordinateArray(int size) throws Exception {
		if (size > 0) {
			coordinates = new double[size][4];
		} else
			throw new Exception("No points to read from");
	}

	/*
	 * Method : Get Coordinates
	 * 
	 * @param file Filename
	 */
	int getCoordinates(String file) {
		String float_pattern = "[-+]?\\d+.?\\d*";
		String coordinates_ref[];
		String pattern = float_pattern + "\\s" + float_pattern + "\\s"
				+ float_pattern;
		int index = 0;
		String word = null;
		try {

			scan = new Scanner(new File(file));// Init the scanner
			while (scan.hasNextLine()) {
				word = null;
				word = scan.nextLine();
				if (word.matches(pattern)) {
					coordinates_ref = word.split("\\s");
					coordinates[index][0] = Double
							.parseDouble(coordinates_ref[0]);
					coordinates[index][1] = Double
							.parseDouble(coordinates_ref[1]);
					coordinates[index][2] = Double
							.parseDouble(coordinates_ref[2]);
					index++;
				}
			}
		} catch (Exception e) {

			return 0;
		}
		scan.close();
		return index;
	}

}

/**
 * Determine the center of objects
 */
public class Center {

	public static void main(String[] args) {
		CenterOfSystem gravity = new CenterOfSystem("cor.txt"); // Create
																// instance of
																// class
		gravity.getCenterObjects(); // Get Center of objects
	}
}
