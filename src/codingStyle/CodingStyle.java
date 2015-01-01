package codingStyle;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class CodingStyle extends JFrame implements Runnable
{
	public static final String webPage = "http://google-styleguide.googlecode.com/svn/trunk/javaguide.html";
	private LinkedList<Section> sectionCollection;
	private JPanel cards;
	private CardLayout cardLayout;
	private NextCardThread thread2;
	private static final long serialVersionUID = -6486208909390680635L;
	public CodingStyle(){
		sectionCollection = new LinkedList<Section>();
		 cards = new JPanel(new CardLayout());
		cards.setPreferredSize(new Dimension(700, 700));
		this.setTitle("Coding Style");
		this.setSize(800,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Thread thread = new Thread(this);
		thread.start();
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			
			Document jsoupDoc = Jsoup.connect(webPage).userAgent("Google").get();
			Elements png = jsoupDoc.select("img[src$=.png]");
			for(Element p:png){
				p.before("<img height='21' width='21' src='http://google-styleguide.googlecode.com/svn/trunk/javaguidelink.png' //>");
				p.remove();
			}
			Elements headers = jsoupDoc.getElementsByTag("h2");
			for (Element h : headers) {
				
				cards.add(new Section(h));
				
			}
			add(cards); 
			cardLayout = (CardLayout) cards.getLayout();
			cardLayout.first(cards);
			thread2 = new NextCardThread(cardLayout,cards);
			thread2.start();
			
		}catch(IOException e){
			
		}
	}
	
	public static void main(String[] args){
		CodingStyle main = new CodingStyle();
	}

}
