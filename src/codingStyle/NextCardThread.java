package codingStyle;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class NextCardThread extends Thread {
	private JPanel jp;
	private CardLayout cl;
	public NextCardThread(CardLayout cardLayout,JPanel jp) {
		this.jp = jp;
		this.cl= cardLayout;
	}

	public void run(){
		try {
		while(true){
			cl.next(jp);
			jp.repaint();
			this.jp.repaint();
			
				this.sleep(2000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
