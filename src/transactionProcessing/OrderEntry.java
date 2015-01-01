package transactionProcessing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OrderEntry extends JFrame{
	   private final int WINDOW_WIDTH = 800;
	   private final int WINDOW_HEIGHT = 800;
       private OrderPanel orderPanel;
       private OrderLine orderLinePanel;
       private ButtonPanel buttonPanel;
       
	   public OrderEntry(){
		//display message in the title bar   
    	setTitle("Premiere Order Entry Form");
    	//set window size
    	setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set up layout of the window 
        setLayout(new BorderLayout());
    	
        orderPanel = new OrderPanel();
        add(orderPanel,BorderLayout.WEST);
        orderLinePanel = new OrderLine();
        add(orderLinePanel,BorderLayout.CENTER);
        buttonPanel = new ButtonPanel(orderPanel,orderLinePanel);
        add(buttonPanel,BorderLayout.SOUTH);
        pack();
        setVisible(true);
        System.out.println(this.getClass());
    	
    }

	public OrderPanel getOrderPanel() {
		return orderPanel;
	}

	

	public OrderLine getOrderLinePanel() {
		return orderLinePanel;
	}

	
	   
}