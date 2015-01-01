package transactionProcessing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{
	private JButton calcButton;
	private JButton exitButton;
	private OrderPanel orderPanel;
	private OrderLine orderLine;
	public ButtonPanel(OrderPanel orderPanel,OrderLine orderLine){
		setLayout(new FlowLayout());
		calcButton = new JButton("Insert Order");
		exitButton = new JButton("Exit");
		//get references to text field on the user interface
		this.orderPanel = orderPanel;
		this.orderLine = orderLine;
		
		add(calcButton);
		add(exitButton);
		System.out.println(this.getClass());
		
		calcButton.addActionListener(new ButtonListener());
		
		
	}
  private class ButtonListener implements ActionListener{
	       private String orderID;
	       private String custID;
	       private Calendar orderDate;
	       private String partID;
	       private int qty;
	       private double price;
	       private double total;
	       
	       //private Date orderDate;
	       private PreparedStatement insertOrder;
	       private PreparedStatement insertOrderLine;
	       
	  public ButtonListener(){
		    orderDate =null;
	  }     
	  public void actionPerformed(ActionEvent e){
		   System.out.println("ready to process the button");
		 //get the frame in which the button panel was placed
		   
		   final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;" +
			     "databaseName=Premiere";
		 //localhost;integratedSecurity=true;jdbc:sqlserver://localhost;databaseName=AdventureWorks;integratedSecurity=true;
		  Connection connection = null;  //manages the connection
	      insertOrder = null;   //query statement
	      insertOrderLine = null;
	      ResultSet resultSet = null;   //manages results
	       try{
	    	   
	    	   //establish connection to database
	    	   //for computer SQL Server 2008
	    	   System.out.println("connecting to database");
	    	   connection = DriverManager.getConnection(DATABASE_URL,"practice","12345");
	    	   //for computer SQL Server 2005
	    	   //connection = DriverManager.getConnection(DATABASE_URL,"touro","Touro123");
	    	   
	    	   //to enable transaction processing do not
	    	   //automatically commit
	    	   connection.setAutoCommit(false);
	    	   insertOrder = connection.prepareStatement("Insert into Orders (Order_Num, Order_Date,Cust_Num) "+
	    	        "VALUES (?,?,? )");
	           insertOrderLine = connection.prepareStatement("Insert into Order_Line (Order_Num,Part_Num,QTY_Ordered,Quoted_Price)" +
	        		"VALUES (?,?,?,?)");   
	       }
	       catch(SQLException sqlException){
	    	   sqlException.printStackTrace();
	    	   
	       }
		
	      System.out.println("connected to database");
		  //collect data from the user interface
	      
	      OrderPanel orderInfo = ButtonPanel.this.orderPanel;
	      //data about parts that were ordered
	      OrderLine orderLineInfo = ButtonPanel.this.orderLine;
	      
		  System.out.println("access to order panel");
		  String orderNum;
		  //get orderid that user enter in the JTextField on the order entry form
		  orderID = orderInfo.getOrderID().getText();
		  //orderID = Integer.parseInt(orderNum);
		  System.out.println("Order " + orderID);
		  //get date that user entered on order entry form
		  String date = orderInfo.getDate().getText();
		  java.sql.Date sqlDate= null;
		  String[] dateParts = date.split("/");
		  if (dateParts.length !=3){
			  //user made an error entering the date
			  JOptionPane.showMessageDialog(null,"incorrect date format");
			  return;
		  }
		  else
		  { int month;
		    int day;
		    int year;
			month = Integer.parseInt(dateParts[0]);
			day = Integer.parseInt(dateParts[1]);
			year = Integer.parseInt(dateParts[2]);
			System.out.println(month + " " + day + " " + year);
			orderDate = GregorianCalendar.getInstance();
			orderDate.set(year, month-1,day,0,0,0);
			
			sqlDate = new java.sql.Date(orderDate.getTimeInMillis());
			
		
			
			
			//get custid from order entry form
			custID = orderInfo.getCustID().getText();
			
			//now we have all the data necessary to add a new order record
			//create Statement for querying database
	    	  try{ 
			  insertOrder.setString(1, orderID);
			  
			  insertOrder.setDate(2,sqlDate);
			  insertOrder.setString(3,custID);
	    	  
	    	   //query database
	    	   int result = insertOrder.executeUpdate();
	    	   System.out.println("executed insert statement");
	    	   
	    	   
	    	  }
	    	  catch(SQLException sqlExcept){
	    		  sqlExcept.printStackTrace();
	    		  try{
	   	    	   connection.rollback();}
	   	    	   catch(SQLException sqlEx){
	   	    		   sqlEx.printStackTrace();
	   	    		   
	   	    	   }
	   	    	   
	    		  
	    	  }
	    	  //now proceed to insert parts of the order
	    	  try{
	    		  System.out.println("enter part order to order line table ");
	    		 //loop through orderline information
	    		  for (int i=0;i<orderLineInfo.partData.length;i++) //number of rows in the grid
	    		   //retrieve data from one row at a time
	    		  { 
	    			  OrderLineData rowData = orderLineInfo.getOrderLineData(i);
	    			   //now prepare record to insert 
	    			  System.out.println("part order " +
	    					  orderID +
		    				  rowData.getPartID() + " " +
		    				  rowData.getQty() + " " +
		    				  rowData.getPrice());
	    			  
	    			insertOrderLine.setString(1, orderID);
	    		    insertOrderLine.setString(2,rowData.getPartID());
	    		    insertOrderLine.setInt(3, rowData.getQty());
	    		    insertOrderLine.setDouble(4, rowData.getPrice());
	    		    //now execute the statement to insert into database
	    		    int result = insertOrderLine.executeUpdate();
	    	               
	    		   }
	    			   
	    		   }
	    	 
	    	  catch(SQLException ex){
	    		  ex.printStackTrace();
	    		  try{
	    		  connection.rollback();}
	    		  catch(SQLException sqlE){
	    			  sqlE.printStackTrace();
	    			  
	    		  }
	    	  }
	    	  try{
	    	  connection.commit();}
	    	  catch(SQLException except){
	    		  except.printStackTrace();
	    		  try{
	    			  connection.rollback();
	    			  
	    		  }
	    		  catch(SQLException sqle){
	    			  sqle.printStackTrace();
	    			  
	    		  }
	    	  }
			  
		  }
	  }
	  
  }
}