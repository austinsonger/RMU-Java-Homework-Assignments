/**
 * Command.java
 *
 * Version:
 *     $1.0$
 *
 * Author:
 * 	  Shivkumar Dudhani
 * Revisions:
 *     $New$
 * Description
 * 	  Simulate Grep command
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.PrintWriter;

/*
 * Find the 
 */
class Find {
	String search_string;

	Find(String search_string) {
		this.search_string = search_string;
	}

	/*
	 * Read Directories
	 */
	void list_directories(File dir_path) {
		/*
		 * Get the list of files
		 */
		File[] file_list = dir_path.listFiles();

		for (File file : file_list) {
			/*
			 * If file then search for the string
			 */
			if (file.isFile()) {
				Grep(file, search_string);
			} else if (file.isDirectory()) {
				/*
				 * List the files in the directory
				 */
				list_directories(file);
			}
		}
	}

	/*
	 * Check if file name is empty before
	 */
	void Grep(File file, String search_line) {
		LineNumberReader input;
		// PrintWriter output = null;
		String line;
		boolean found = false;
		boolean binary = false;
		// if (check_binary(file)) {
		try {
			input = new LineNumberReader(new BufferedReader(
					new FileReader(file)));
			/*
			 * Set the output stream to default system screen
			 */
			// output = new PrintWriter(System.out);
			// output = new PrintWriter(new FileWriter("test.txt", true));
			if (file.getName().contains(".class")) {
				binary = true;
			}

			while ((line = input.readLine()) != null) {
				/*
				 * Search for the line
				 */
				if (line.indexOf(search_line) >= 0) {
					if (binary == true) {
						System.out.println("Binary file " + file + " matches");
						input.close();
						return;
					}
					System.out.println(input.getLineNumber() + ": " + line);
					found = true;
				}
			}
			if (found == true) {
				System.out.println("file " + file + " matches");
				/*
				 * output.flush(); output.close();
				 */
				input.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("ExceptionType occurred: " + e.getMessage());
		}
	}

	/*
	 * Check for binary
	 */
	boolean check_binary(File file) {
		try {
			FileInputStream in = new FileInputStream(file);
			byte[] bytes = new byte[500];
			short bin = 0;
			in.read(bytes, 0, bytes.length);
			for (byte thisByte : bytes) {
				if (thisByte < 32 || thisByte > 127)
					bin++;
				if (bin >= 5) {
					in.close();
					return false;
				}
			}

			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}

public class Command {

	public static void main(String[] args) {

		// Check the arguments for find
		if (args.length > 0) {
			if (!args[0].equals("find"))
				System.out
						.println("Format : find file_path -type -f -exec Hello {} \\;");
			else {
				// Check the file path is valid
				// String workingDir = System.getProperty("user.dir");
				File file = new File(args[1]);
				// File file = new File(workingDir);

				if (file.isDirectory() || file.isFile()) {

					/*
					 * Read the files specified at the path and perform the grep
					 * command
					 */
					/*
					 * Check the grep is valid format or not
					 */
					if (args[2].equals("-type") && args[3].equals("f")
							&& args[4].equals("-exec")
							&& args[5].equals("grep")) {
						if (args[7].equals("{}") && args[8].equals(";")) {
							/*
							 * Check if single word is used or quotes are used
							 * String to the searched for is args[6]
							 */
							/*
							 * Read the path mentioned and then perform the grep
							 */
							if (args[6].length() >= 0) {
								Find search = new Find(args[6]);
								search.list_directories(file);
							}
						} else {
							/*
							 * Check for quotes for the pattern
							 */
							int start = 6;
							int counter = 6;
							if (args[6].contains("\"")
									&& args[7].contains("\"")
									&& args[8].equals("{}")
									&& args[9].equals(";")) {

							} else {
								/*
								 * Format Error
								 */
								System.err.println("Format Error");
							}
						}
					} else
						/*
						 * Format Error
						 */
						System.err.println("Format Error");

				} else
					System.out.println("File Path not found ::  " + args[1]);

			}

		} else
			System.out.println("No command line arguments");

	}

}
