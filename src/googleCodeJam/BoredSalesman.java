package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BoredSalesman {
	private int numTests;
	private Scanner read;
	private PrintWriter print;
	public BoredSalesman(File file) throws FileNotFoundException {
		long milli = System.currentTimeMillis();
		read = new Scanner(file);
		print = new PrintWriter(new File("results.txt"));
		numTests = read.nextInt();
		for(int i =0; i <numTests;i++){
			process(read);
		}
		print.close();
		read.close();
		System.out.println(System.currentTimeMillis()-milli);
	}
	private void process(Scanner read) {
		read.nextLine();
		int numZips = read.nextInt();
		int numFlights = read.nextInt();
		read.nextLine();
		for(int i =0; i <numZips;i++){
			
		}
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		BoredSalesman b = new BoredSalesman(new File("A-small-practice.in"));
	}


}
