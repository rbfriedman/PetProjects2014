package graph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarGraph extends JPanel {
	private int num;
	private JPanel a;
	private Bars bars;
	private JTextField jtfHeight;
	private JButton jbtAddBar;

	public BarGraph(Bars bars) throws Exception {
		this.bars = bars;
		jtfHeight = new JTextField(4);
		jbtAddBar = new JButton("Add bar");
		
		this.add(jtfHeight);
		this.add(jbtAddBar);
		jbtAddBar.addActionListener(new ButtonClick());

	}

	public void paintComponent(Graphics g) {
		paintComponents(g);
		int x = 0;
		int y = 460;
		int height = 0;
		Random generator = new Random();

		for (Bar b : bars) {
			g.setColor(new Color(generator.nextInt(256),
					generator.nextInt(256), generator.nextInt(256), generator
							.nextInt(256)));
			g.fill3DRect(x += 15, y - b.getHeight(), 20, b.getHeight(), true);
		}
	}

	public static void main(String[] args) throws Exception {
		JFrame a = new JFrame();
		Bars bars = new Bars();
		bars.add(new Bar(28));
		bars.addBar(new Bar(39));
		BarGraph b = new BarGraph(bars);
		a.add(b);
		a.setSize(600, 520);
		a.setVisible(true);
		a.setLocationRelativeTo(null);
		a.setTitle("Graph");
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	private class ButtonClick implements ActionListener{
		private String heightOfBar ="";
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			bars.addBar(new Bar( Integer.valueOf(jtfHeight.getText())));
			repaint();
		}
		
	}

}
