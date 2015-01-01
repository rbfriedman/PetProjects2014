package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MineSweeperMaster {
	private int numTests;
	private Scanner read;
	private PrintWriter print;
	private final int MINE =9;
	public MineSweeperMaster(File file) throws FileNotFoundException {
		long milli = System.currentTimeMillis();
		read = new Scanner(file);
		numTests =read.nextInt();
		read.nextLine();
		for(int i=0; i <numTests; i++){
			print.write("Case " + (i+1)+" :" +processBoard(read));
		}
		print = new PrintWriter(new File("results.txt"));
		print.close();
		read.close();
		System.out.println(System.currentTimeMillis()-milli);
	}
	public String processBoard(Scanner read){
		
		int rows = read.nextInt();
		int cols = read.nextInt();
		int mines = read.nextInt();
		
		if(rows * cols <=8){
			if(rows ==1 && cols ==1 && mines ==1){
				return "Impossible";
			}else if(rows ==1 || cols ==1){
				int dimension=rows >cols?rows:cols;
				if(mines <=dimension-2){
					return configuration(rows,cols,mines);
				}else{
					return "Impossible";
				}
				
			}
		}
		if(rows *cols -mines <=3 || rows * cols - mines==5|| rows * cols - mines==7 ){
			return "Impossible!";
		}
		
		read.nextLine();
		return null;
		
	}
	private String configuration(int rows, int cols, int mines) {
		StringBuilder build = new StringBuilder();
		for(int i=0; i <rows; i++){
			for(int j=0; j <cols;j++){
				
			}
		}
		return null;
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		MineSweeperMaster b = new MineSweeperMaster(new File("C-small-practice.in"));
	}
	public int revealCell(){
		return MINE;
		
	}
	
	


}
