package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class AllYourBase {
	private Scanner read;
	private PrintWriter print;
	private int numTests;
	
	public AllYourBase(File file) throws FileNotFoundException{
		// TODO Auto-generated constructor stub
		read = new Scanner(file);
		print = new PrintWriter(new File("results.txt"));
		numTests =read.nextInt();
		read.nextLine();
		String encodedWord;
		for(int i=0; i <numTests; i++){
			encodedWord =read.nextLine().trim();
			print.write("Case #" +  (i+1) +": " +getMinSecondsBeforeWar(encodedWord).toString() + "\n");
			
		}
		print.close();
	}
	private BigInteger getMinSecondsBeforeWar(String encodedWord) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> hm  =new HashMap<String, Integer>();
		
		int value =1;
		int base =1;
		for(int i =0; i <encodedWord.length();i++){
			if(i==0){
				hm.put("" +encodedWord.charAt(0), 1);
			}else{
			if(!hm.containsKey("" +encodedWord.charAt(i))){
				
				if(value == 1){
					value = 0;
				}else if(value== 0){
					value = 2;
				}else{
					value +=1;
				}
				
				base++;
				hm.put("" +encodedWord.charAt(i), value);
			}
			
			}
		}
		if(hm.size() ==1){
			base =2;
		}
		BigInteger worth =new BigInteger("0");
		for(int i =0; i <encodedWord.length();i++){
			String letter = "" +encodedWord.charAt(i);
			worth =worth.add( new BigInteger("" +hm.get(letter)).multiply(new BigInteger(""+base).pow(encodedWord.length()-1-i)));
		}
		return worth;
	}
	public static void main(String[] args) throws FileNotFoundException{
		AllYourBase a = new AllYourBase(new File("A-large-practice.in"));
	}

}
