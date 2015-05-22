/*
 * Palindrome.java
 *
 * Version:
 *     $1.0$
 *
 * Author:
 * 	  Shivkumar Dudhani
 * Revisions:
 *     $New$
 * Description
 * 	  Determine the palindromes in the given text file
 */

// Load the required packages
import java.util.Scanner;
import java.io.File;

/**
 * CLASS : TO perform the word operations
 */
class Word_operations {
	File txt_file;	// Object to hold file
	Scanner sc;		// Scanner 
	int palindrome_count = 0;
	int string_array_size = 50;
	String[] pal_words = new String[string_array_size];	// holds palindrome words

	/*
	 * CLASS CONSTRUCTOR : to create an object of file
	 * 
	 * @param file name of the file to be read
	 * 
	 */
	Word_operations(String file) {
		txt_file = new File(file); // Create a file object for the text file to
									// be read
	}

	/*
	 * store the unique palindomes
	 * 
	 * @param word	word to be added
	 * 
	 * @return              nothing
	 * 	 
	 */
	void add_palindrome(String word) {
		if (palindrome_count < 50) { // --Check for duplicates, if unique then
										// add
			for (int i = 0; i < palindrome_count; i++) {
				if (pal_words[i].equals(word)) {
					return;
				}
			}
			// --the word is unique
			pal_words[palindrome_count] = word;
			palindrome_count++;
		}
	}

	/*
	 * Display the palindromes and the count
	 * 
	 * @return              nothing
	 * 	 
	 */
	void display_palindromes() {
		for (int i = 0; i < palindrome_count; i++)
			System.out.println(pal_words[i]);
		// Count
		System.out
				.println("Palindromes found in the file :" + palindrome_count);
	}

	/*
	 * Read the content of the text file
	 * each line is checked for palindromes
	 * 
	 * @return              nothing
	 * @exception   e    File cannot be read
 	 */
	// -- Read from the file
	void read_file_process() {
		try {
			sc = new Scanner(txt_file);
			while (sc.hasNext()) { // Check the scanner to read the file content
				String line = sc.nextLine();// Get the next line
				//--Check the line for palindromes (convert to lower case)
				check_line_for_planidrome(line.toLowerCase());
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("File cannot be read");
		}
	}

	/*
	 * Read the line considering all possible combinations of word woth length > 2
	 * 
	 * @param line	line to be checked for palindrome
	 * 
	 * @return              nothing
	 * 	 
	 */
	// -- Read the line and then check for palindrome
	void check_line_for_planidrome(String line) {
		// --Start a reference pointer from the left to the right
		// --Start a checking pointer from left to right to check for same words
		// --if the character at the reference pointer is repeated then check
		// the word formed
		// -- in between the pointers and check if they are a palindrome

		for (int ref_ptr = 0; ref_ptr < line.length(); ref_ptr++) {
			for (int chk_ptr = ref_ptr + 1; chk_ptr < line.length(); chk_ptr++) {
				if (line.charAt(ref_ptr) == line.charAt(chk_ptr)) {

					find_palindromes(line.substring(ref_ptr, chk_ptr + 1));
				}
			}
		}

	}

	/*
	 * Check the word for palindromws
	 * 
	 * @param word	word to be checked for palindromes
	 * 
	 * @return              nothing
	 * 	 
	 */
	// --- Check the word to scan for palindrome
	void find_palindromes(String word) {
		String pal_word, ref_word;
		boolean even;
		// --Set the ref pointer from the start of word and chk pointer from end
		// --scan characters till palindrome in found in the word and display
		for (int ref_ptr = 0; ref_ptr < word.length() - 1; ref_ptr++) {
			ref_word = word.substring(ref_ptr, word.length());
			if (ref_word.length() > 2) {
				for (int chk_ptr = ref_word.length() - 1; chk_ptr > 0; chk_ptr--) {
					// initialize
					int i = 0, j = chk_ptr;
					int word_middle;
					pal_word = ref_word.substring(0, chk_ptr + 1);
					// --If word length is even ; middle = length/2
					// --If word length is odd ; middle = (length-1)/2
					// --check for words with more than 2 characters
					if (pal_word.length() > 2) {
						if (pal_word.length() % 2 == 0)// Even
						{
							even = true;
							word_middle = pal_word.length() / 2;
						} else { // Odd
							even = false;
							word_middle = (pal_word.length() - 1) / 2;
						}
						do {
							if (!(pal_word.charAt(i) == pal_word.charAt(j))) {
								break;
							}
							// --If the middle has been reached then its a
							// palindrome
							// --Display the word and increment the count
							if (even) {
								if (i == word_middle - 1) {
									add_palindrome(pal_word);
								}
							} else// odd
							{
								if (i == word_middle) {
									add_palindrome(pal_word);
								}

							}
							i++;
							j--;
						} while ((i <= word_middle)
								&& (j >= (pal_word.length() - word_middle - 1)));
					}
				}
			}
		}
	}
}

/*
 * Main Class: Palindrome
 */
public class Palindrome {

	/*
	 * Main method
	 * 
	 * @param args	Command line arguments
	 * 
	 * @return              nothing
	 * 	 
	 */
	public static void main(String[] args) {

		Word_operations pal_word = new Word_operations("palindrome.txt");
		// Read the text file and process for palindromes
		pal_word.read_file_process();
		// Display the palindromes and the count
		pal_word.display_palindromes();
	}
}