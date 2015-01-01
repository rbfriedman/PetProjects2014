package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.attribute.AclEntry.Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class AlienLanguage {
	private Scanner read;
	private PrintWriter print;
	private int numWords,lenWord,numTests;
	private List<String> words;
	
	public AlienLanguage(File file) throws FileNotFoundException {
		long milli = System.currentTimeMillis();
		read = new Scanner(file);
		print = new PrintWriter(new File("results.txt"));
		lenWord =read.nextInt();
		numWords = read.nextInt();
		numTests = read.nextInt();
		words = new ArrayList<String>();
		read.nextLine();
		for(int i =0; i <numWords; i++){
			words.add(read.nextLine().trim());
		}
		for(int i =0; i <numTests; i++){
			print.write("Case #" + (i+1) +": " +searchDictionary(read.nextLine().trim())+ "\n");
		}
		print.close();
		read.close();
		System.out.println(System.currentTimeMillis()-milli);
	}
	public int searchDictionary(String s){
		//Stack<String> matches = new Stack<String>();
		int count =0;
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i<s.length() ;i++){
			char c= s.charAt(i);
			if(c == '('){
				int index = s.indexOf(')',i);
				builder.append("[");
				builder.append(s.subSequence(i,index +1));
				builder.append("]");
				
				i=index;
			}else if(Character.isAlphabetic(c)){
				builder.append("[");
				builder.append(c);
				builder.append("]");
			}
		}
		for(String word:words){
			if(word.matches(builder.toString())){
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		AlienLanguage b = new AlienLanguage(new File("A-small-practice.in"));
	}

}
