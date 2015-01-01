package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MagicTrick {
	private int numTests;
	private Scanner read;
	private PrintWriter print;
	public MagicTrick(File file) throws FileNotFoundException {
		long milli = System.currentTimeMillis();
		read = new Scanner(file);
		print = new PrintWriter(new File("results.txt"));
		numTests = read.nextInt();
		read.nextLine();
		for(int i =0; i <numTests; i++){
			print.write("Case #" +  (i+1) +": " +getResponse(read) + "\n");
		}
		print.close();
		read.close();
		System.out.println(System.currentTimeMillis()-milli);
	}
	private String getResponse(Scanner reader) {
			return readCards(reader);
		
	}
	private String readCards(Scanner reader) {
		// TODO Auto-generated method stub
		int guess =read.nextInt();
		read.nextLine();
		int[] arrOfNums = new int[4];
		int[] secondArrOfNums = new int[4];
		for(int i =1; i <5;i++){
			if(i== guess){
				for(int j =0; j<4;j++){
					arrOfNums[j] = read.nextInt();
				}
				read.nextLine();
			}else{
				read.nextLine();
			}
		}
		guess = read.nextInt();
		read.nextLine();
		for(int i =1; i <5;i++){
			if(i== guess){
				for(int j =0; j<4;j++){
					secondArrOfNums[j] = read.nextInt();
				}
				read.nextLine();
			}else{
				read.nextLine();
			}
		}
		String y ="Volunteer cheated!";
		for(int i =0; i <arrOfNums.length;i++){
			if(arrOfNums[i] == secondArrOfNums[0] || 
					arrOfNums[i] ==secondArrOfNums[1] ||
					arrOfNums[i] ==secondArrOfNums[2] ||
					arrOfNums[i] ==secondArrOfNums[3]){
				if( y.equals("Volunteer cheated!")){
					y = String.valueOf(arrOfNums[i]);
					
				}else{
					y ="Bad magician!";
				}
				
			}
		}
		return y;
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		MagicTrick b = new MagicTrick(new File("A-small-attempt1.in"));
	}


}
