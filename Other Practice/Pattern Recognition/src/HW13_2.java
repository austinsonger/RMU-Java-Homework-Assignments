/**
 * HW13_2.java
 *
 * Version:
 *     $1.0$
 *
 * Author:
 * 	  Shivkumar Dudhani && Vishal Dsouza
 * Revisions:
 *     $New$
 * Description
 * 	  Pattern Recognition
 */
/*
 * Reference : Java Docs
 * https://docs.oracle.com/javase/tutorial/essential/regex/test_harness.html
 */

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HW13_2 {
	public static void main(String[] args) {
		FileReader filereader;
		BufferedReader input;
		String line;
		Matcher matcher;
		Console console = System.console();
		if (console == null) {
			System.err.println("No console.");
			System.exit(1);
		}

		/*
		 * Get the regular expression
		 */
		Pattern pattern = Pattern.compile(console
				.readLine("%nEnter your regex: "));

		/*
		 * Enter the file to be checked
		 */
		System.out.print("Enter the file to be scanned :: ");
		String file = System.console().readLine();

		/*
		 * Read the file and scan for the specified pattern
		 */
		try {
			filereader = new FileReader(file);
			input = new BufferedReader(filereader);
			while ((line = input.readLine()) != null) {
				matcher = pattern.matcher(line);
				while (matcher.find()) {
					
					//Print line
					System.console().writer().println(line);					
					System.console().writer()
							.println("Pattern found :: " + matcher.group());
					
					
					// System.out.println("Pattern found :: " +
					// matcher.group());
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Check the file
		 * 
		 * String line;
		 * 
		 * 
		 * Matcher matcher = pattern.matcher(console
		 * .readLine("Enter input string to search: "));
		 * 
		 * boolean found = false; while (matcher.find()) {
		 * console.format("I found the text" + " \"%s\" starting at " +
		 * "index %d and ending at index %d.%n", matcher.group(),
		 * matcher.start(), matcher.end()); found = true; } if (!found) {
		 * console.format("No match found.%n"); }
		 */
	}
}