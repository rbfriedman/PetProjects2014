package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CookieClicker {
	private int numTests;
	private Scanner read;
	private PrintWriter print;

	public CookieClicker(File file) throws FileNotFoundException {
		long milli = System.currentTimeMillis();
		read = new Scanner(file);
		numTests = read.nextInt();
		read.nextLine();
		print = new PrintWriter(new File("results.txt"));
		for (int i = 0; i < numTests && read.hasNextLine(); i++) {
			
			print.write("Case #" + (i + 1) + ": " + cookiesUnspentOnFarm(read.nextLine())
					+ "\n");
		}
		
		print.close();
		read.close();
		System.out.println(System.currentTimeMillis() - milli);
	}

	private double cookiesUnspentOnFarm(String read) {
		// TODO Auto-generated method stub
		String[] g = read.split(" ");
		double cookieProductionRate = 2;
		double total = 0;
		double myCookies =0;
		double cookies = Double.parseDouble(g[0]);
		double rateOfIncrease = Double.parseDouble(g[1]);
		double X = Double.parseDouble(g[2]);
			while (myCookies != X) {
				if (total + X / cookieProductionRate > total + cookies
						/ cookieProductionRate + X
						/ (cookieProductionRate + rateOfIncrease)){
					total += cookies / cookieProductionRate;
					cookieProductionRate += rateOfIncrease;
				}else{
					myCookies =X;
					total+= X/cookieProductionRate;
				}
			
		}
			return total;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		CookieClicker b = new CookieClicker(new File("B-large.in"));
	}

}
