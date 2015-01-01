package codingStyle;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class Section extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4491231223600109381L;
	private Element headerElement;

	public Section(Element h) {
		// Initialize fields
		this.headerElement = h;
		// create components
		JTextPane pane = new JTextPane();
		pane.setContentType("text/html");
		pane.setText(getInfo());
		pane.setEditable(false);
		JScrollPane paneScrollPane = new JScrollPane(pane);
		paneScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		// set size of components
		paneScrollPane.setPreferredSize(new Dimension(700, 600));
		// set layout
		JLabel jl = new JLabel(this.headerElement.text());
		jl.setPreferredSize(new Dimension(200, 100));
		add(jl);
		add(paneScrollPane);

	}

	public String getInfo() {
		StringBuilder build = new StringBuilder(this.headerElement.text()+"\n");
		
		
		Node e = this.headerElement.nextSibling();
		String s ="";
		String targetString ="javaguidelink.png";
		String replacement ="http://google-styleguide.googlecode.com/svn/trunk/javaguidelink.png";
		while ((e = e.nextSibling()) != null && !e.nodeName().equals("h2")) {
			s = e.toString();
				
			build.append(s);
			System.out.println(s);
		}

		return build.toString();
	}

}
