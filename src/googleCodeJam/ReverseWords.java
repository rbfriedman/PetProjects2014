package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseWords {
	private Scanner read;
	private int numCases;
	private PrintWriter pw;
	private StringBuilder builder;
	public ReverseWords(File file) throws FileNotFoundException{
		read = new Scanner(file);
		pw = new PrintWriter(new File("results.txt"));
		builder = new StringBuilder();
		int numCases =read.nextInt();
		read.nextLine();
		for(int i=0; i <numCases;i++){
			pw.write("Case #" + (i+1) +":");
			reverse(read.nextLine());
		}
		read.close();
		pw.close();
	}
	
	private void reverse(String line) {
		// TODO Auto-generated method stub
		String[] c = line.split(" ");;
		Stack<String> stackOfStrings = new Stack<String>();
		for(int i =0; i <c.length;i++){
			stackOfStrings.push(c[i]);
		}
	
		while(!stackOfStrings.isEmpty()){
		builder.append(" " +stackOfStrings.pop());
		}
		pw.write(builder.toString() + "\n");
		builder.setLength(0);
		
	}

	public static void main(String[] args) throws FileNotFoundException{
		ReverseWords r = new ReverseWords(new File("B-small-practice.in"));
		
	}
}
