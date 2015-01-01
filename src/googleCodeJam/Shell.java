package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Shell {
	private int numTests;
	private Scanner read;
	private PrintWriter print;
	public Shell(File file) throws FileNotFoundException {
		long milli = System.currentTimeMillis();
		read = new Scanner(file);
		print = new PrintWriter(new File("results.txt"));
		print.close();
		read.close();
		System.out.println(System.currentTimeMillis()-milli);
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Shell b = new Shell(new File("A-small-practice.in"));
	}


}
