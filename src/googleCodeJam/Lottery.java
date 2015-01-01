package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lottery {
	private int numTests;
	private Scanner read;
	private PrintWriter print;

	public Lottery(File file) throws FileNotFoundException {
		long milli = System.currentTimeMillis();
		read = new Scanner(file);
		print = new PrintWriter(new File("results.txt"));
		numTests = read.nextInt();
		read.nextLine();
		for (int j = 0; j <numTests; j++) {
			System.out.println("Case #" + (j + 1) + ": " + getInstanceOfLottery(read) +"\n");
		}
		print.close();
		read.close();
		System.out.println(System.currentTimeMillis() - milli);
	}

	private int getInstanceOfLottery(Scanner read) {
		// Read information from the file
		int A = read.nextInt();
		int B = read.nextInt();
		int K = read.nextInt();
		read.nextLine();

		// Process Information
		int target = 0;
		int count =0;
		int larger;
		int smaller;
		if(A<= K && B<=K){
			return A*B;
		}else if(A >K && B<K){
			for (int a = K; a < A  ; a++) {
				for (int b = 0; b < B; b++) {
					
					count=  (a & b) < K?count+1:count ;
				}

			}
			return (K-1) * B +count;
		}else if(B>K && A <K){
			for (int b = K; b < B  ; b++) {
				for (int a = 0; b < A; a++) {
					
					count=  (a & b) < K?count+1:count ;
				}

			}
			return (K-1) * B +count;
		}else{
			for (int b = K; b < B  ; b++) {
				for (int a = K; a < A; a++) {
					
					count=  (a & b) < K?count+1:count ;
				}

			}
			return (K-1) *(K-1)  +count;
		}
		
		

	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Lottery b = new Lottery(new File("B-large-practice.in"));
	}

}
