import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ChoosingWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Test Methods

		// Checks if there is no fileName
		if (args.length < 2) {
			System.out.println("You did not input enough files");
			System.exit(1);
		}

		Scanner in = wordsToScanner(args[0]);

		// Checks if fileNameis bad
		if (in == null)
			System.exit(1);

		System.out.println(in.nextLine());

		PrintWriter out = openDictionary(args[1]);
		
		
		//Writes to the RamblecsDictionary.java file
		makeHeader(out);
		writeJava(in, out);
		makeFooter(out);

		in.close();
		out.close();

	}

	/**
	 * @param fName
	 * @return
	 */
	public static Scanner wordsToScanner(String fName) {
		File fileName = new File(fName);
		Scanner words = null;

		try {
			words = new Scanner(fileName);
		} catch (FileNotFoundException ex) {
			System.out.print("Cannot open " + fName);
			return null;

		}
		return words;
	}

	/**
	 * @param fName
	 * @return
	 */
	public static PrintWriter openDictionary(String fName) {
		File fileName = new File(fName);
		
		PrintWriter output = null;
		
		try {
			output = new PrintWriter(fileName);
		} catch (FileNotFoundException ex) {
			System.out.print("Cannot open " + fName);
			return null;

		}
		
		return output;
	}

	/**
	 * @param input
	 * @param output
	 */
	public static void writeJava(Scanner input, PrintWriter output) {
		while (input.hasNextLine()) {
			String word = input.nextLine().toUpperCase();

			if (word.length() == 3 || word.length() == 4 || word.length() == 5) {
				output.println("\t\t\"" + word + "\",");
			}

		}
	}

	/**
	 * @param output
	 */
	public static void makeHeader(PrintWriter output) {
		output.println("public class RamblecsDictionary \n{");
		output.println("\tprivate String [] words = \n\t{");
	}

	/**
	 * @param output
	 */
	public static void makeFooter(PrintWriter output) {
		output.println("\t};\n}");

	}

}
