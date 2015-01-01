package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WelcomeToCodeJam {
	private int numTests;
	private Scanner read;
	private PrintWriter print;
	private String phrase;

	public WelcomeToCodeJam(File file, String phrase)
			throws FileNotFoundException {
		phrase = phrase.toLowerCase();
		long milli = System.currentTimeMillis();
		read = new Scanner(file);
		print = new PrintWriter(new File("results.txt"));
		numTests = Integer.parseInt(read.nextLine());
		for (int i = 0; i < numTests; i++) {
			print.write("Case #" + (i + 1) + ": "
					+ processParagraph(read.nextLine()));
		}
		print.close();
		read.close();
		System.out.println(System.currentTimeMillis() - milli);
	}

	private String processParagraph(String nextLine) {
		// TODO Auto-generated method stub
		for(int i =0; i <nextLine.length()-phrase.length();i++){
			
		}
		return null;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		WelcomeToCodeJam b = new WelcomeToCodeJam(new File(
				"A-small-practice.in"), "Welcome To Code Jam");
	}

}
