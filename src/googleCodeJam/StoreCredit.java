package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreCredit {
	private int numCases;
	private int credit;
	private int numItems;
	private int[] n ={3,4};
	private Scanner read;
	private PrintWriter write;

	public StoreCredit(File file) throws FileNotFoundException {
		read = new Scanner(file);
		numCases = read.nextInt();
		write = new PrintWriter(new File("results.txt"));
		for (int j = 0; j < numCases; j++) {
			write.append("Case #" + (j+1) + ": ");
			getInstanceOfStoreCredit(file);
		}
		write.close();
		read.close();

	}

	private void getInstanceOfStoreCredit(File file) {
		credit = read.nextInt();
		numItems = read.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int tempItemPrice = 0;
		for (int i = 0; i < numItems; i++) {
			tempItemPrice = read.nextInt();
				int target = credit - tempItemPrice;
				if(list.contains(target)){
					write.append(list.indexOf(target)+1 + " " + (i+1) + "\n");
					
					read.nextLine();
					return;
				}
				list.add(tempItemPrice);
			}
		
		
	}

	public static void main(String[] args){
		long time =System.currentTimeMillis();
		try{
			StoreCredit store = new StoreCredit(new File("A-small-practice.in"));
		}catch(FileNotFoundException f){
			System.out.println(f.getMessage());
		}
		
		//System.out.println(System.currentTimeMillis()-time);
		
		
	}
}
