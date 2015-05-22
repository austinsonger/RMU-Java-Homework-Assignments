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
 * 	  Predefined Pattern Recognition
 * Keyword file required in current folder : keywords.txt
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Scan {
	FileReader filereader;
	int pattern_count = 5;
	ArrayList<String> keywords = new ArrayList<String>();

	Pattern scan_pattern[] = new Pattern[pattern_count];
	Matcher scan_matcher[] = new Matcher[pattern_count];
	String pattern[] = new String[pattern_count];
	public static String vowels = "[aeiou]";
	public static String consonents = "[^aeiou]";
	BufferedReader input;

	/*
	 * Constructor to get the file details
	 */
	Scan(String file) {
		if (file.length() <= 0) {
			System.out.println("Format Error : " + "<file to ber sccanned >");
			return;
		}
		/*
		 * Load the reserved keywords from the file
		 */

		load_keywords();
		// File reader created
		try {
			filereader = new FileReader(file);

		} catch (FileNotFoundException e) {
			System.out.println("File not found ");
			e.printStackTrace();
		}
		int count = 0;
		/*
		 * Set the pattern 0
		 */
		scan_pattern[count] = Pattern.compile("//.*");
		pattern[count++] = "Java single line comment";
		/*
		 * Set the pattern 1
		 */
		scan_pattern[count] = Pattern
				.compile("\\b[a-zA-Z[_$]&&[^0-9]][a-zA-Z[_$][0-9]]*\\b");
		pattern[count++] = "legal Java variable names";

		/*
		 * Set the pattern 2
		 */
		scan_pattern[count] = Pattern.compile("\\ba\\w+e\\b");
		pattern[count++] = "words that start with a 'a' and end with a 'e'";

		/*
		 * Set the pattern 3
		 */
		scan_pattern[count] = Pattern.compile("\\b\\w+" + vowels + "\\b\\s\\b"
				+ consonents + "\\w+\\b");
		pattern[count++] = "word combinations of two words where the first words ends with a vowel and the next words starts with consonant";
		/*
		 * Set the pattern 4
		 */
		scan_pattern[count] = Pattern.compile("\\b\\w+t\\b\\s\\b\\w+\\b\\s\\b"
				+ consonents + "\\w+\\b");
		pattern[count++] = "word combinations of three words where the first words ends with 't' and the third word in the sequence starts with a consonant";

		/*
		 * Scan the file
		 */
		scan_file();
	}

	/*
	 * Load the reserved keywords
	 */
	void load_keywords() {
		String line;
		try {
			filereader = new FileReader("keywords.txt");
			// Instantiate he BufferedReader
			input = new BufferedReader(filereader);
			while ((line = input.readLine()) != null) {
				// Scan the words from the file
				String[] result = line.split("\\s");
				for (int x = 0; x < result.length; x++)
					keywords.add(result[x]);
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to load keywords ");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Scan the file for pattern
	 */
	void scan_file() {
		String line;
		Matcher scan_matcher;
		boolean found = false;
		String word;
		boolean legal = true;
		boolean comment = false;
		try {
			// Instantiate he BufferedReader
			input = new BufferedReader(filereader);
			// Read the line from the file
			while ((line = input.readLine()) != null) {
				comment = false;

				/*
				 * Scan against the pattern
				 */
				for (int i = 0; i < pattern_count; i++) {
					/*
					 * For pattern 3 & 4 Compute this way
					 */
					if (i == 3 || i == 4) {
						if (comment != true) { /*
												 * Compare against the java
												 * reserved keywords
												 */
							/*
							 * Use the pattern to split the words
							 */
							Pattern pattern1 = Pattern.compile("\\w+");
							Matcher matcher1 = pattern1.matcher(line);

							scan_matcher = scan_pattern[i].matcher(line);
							/*
							 * For every word split into substring and pass the
							 * substring to the pattern for matching
							 */
							while (matcher1.find()) {
								if (scan_matcher.find(matcher1.start())) {
									System.out.println(i + "<= Pattern found "
											+ scan_matcher.group());
								}
							}
						}

					} else {

						/*
						 * Check against the line
						 */
						scan_matcher = scan_pattern[i].matcher(line);
						while (scan_matcher.find()) {
							/*
							 * If there is a comment do not perform pattern
							 * matching on it
							 */
							if (comment != true) { /*
													 * Compare against the java
													 * reserved keywords
													 */
								if (i == 1) {
									word = scan_matcher.group();
									legal = true;
									for (String string : keywords) {
										if (string.matches(word))
											legal = false;
									}
									if (legal == true)
										System.out.println(i
												+ "<= Pattern found "
												+ scan_matcher.group());

								} else
									System.out.println(i + "<= Pattern found "
											+ scan_matcher.group());
								found = true;
								/*
								 * Set a flag if comment is there
								 */
								if (i == 0)
									comment = true;
							}
						}
					}
				}
			}
			input.close();
			/*
			 * If not match found
			 */
			if (found == false)
				System.out.println("No match found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class HW13_1 {

	public static void main(String[] args) {
		 new Scan(args[0]);
		// new Scan("test.txt");
	}
}
