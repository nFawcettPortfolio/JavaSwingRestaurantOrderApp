package wk2;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;

public class JacksApp {

	static final String LOCALZIP = "30115";
	static final String EXTRAZIP = "30114";
	static final String EXTRAZIP2 = "30142";
	
	static final double BURGER = 4.50;
	static final double DRINK = 1.50;
	static final double FRIES = 2.50;
	static final double DESSERT = 3.00;
	
	static Boolean isPickUp=true;
	private JFrame frmJacks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JacksApp window = new JacksApp();
					window.frmJacks.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	/**
	 * Create the application.
	 */
	public JacksApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJacks = new JFrame();
		frmJacks.setTitle("Jack's Dinner");
		frmJacks.setBounds(300, 200, 550, 700);
		frmJacks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		NumberFormat dollar = new DecimalFormat("#0.00");     
		
		JRadioButton rb_pickUp = new JRadioButton("Pick-Up",true);
		JRadioButton rb_delivery = new JRadioButton("Delivery",false);
		ButtonGroup G = new ButtonGroup();
		G.add(rb_pickUp);
		G.add(rb_delivery);
		rb_pickUp.setBounds(120, 30, 100, 50); 
		rb_delivery.setBounds(250, 30, 100, 50);
		
		frmJacks.getContentPane().add(rb_pickUp); 
		frmJacks.getContentPane().add(rb_delivery);
		
		JLabel jl_subTotalTEXT =new JLabel("Sub-Total: $");
		jl_subTotalTEXT.setBounds(400, 500, 100, 20);
		frmJacks.getContentPane().add(jl_subTotalTEXT);
		JLabel jl_subTotal =new JLabel("0.00");
		jl_subTotal.setBounds(480, 500, 100, 20);
		frmJacks.getContentPane().add(jl_subTotal);
		
		JLabel jl_taxTEXT =new JLabel("Tax: $" );
		jl_taxTEXT.setBounds(400, 520, 100, 20);
		frmJacks.getContentPane().add(jl_taxTEXT);
		JLabel jl_tax =new JLabel("0.00" );
		jl_tax.setBounds(480, 520, 100, 20);
		frmJacks.getContentPane().add(jl_tax);
		
		JLabel jl_deliveryTEXT =new JLabel("Delivery: $");
		jl_deliveryTEXT.setBounds(400, 540, 100, 20);
		frmJacks.getContentPane().add(jl_deliveryTEXT);
		JLabel jl_delivery =new JLabel("0.00");
		jl_delivery.setBounds(480, 540, 100, 20);
		frmJacks.getContentPane().add(jl_delivery);
		
		JLabel jl_totalTEXT =new JLabel("Total: $");
		jl_totalTEXT.setBounds(400, 560, 100, 20);
		frmJacks.getContentPane().add(jl_totalTEXT);
		JLabel jl_total =new JLabel("0.00");
		jl_total.setBounds(480, 560, 100, 20);
		frmJacks.getContentPane().add(jl_total);
		
		
		
		
		
		// btn constraints
		int qX = 300;
		int menuX = 20;
		int btnW = 45;
		int btnH = 20;
		int upX = 210;
		int downX = 160;
		
		JLabel jl_menu =new JLabel("Menu:");
		jl_menu.setBounds(menuX, 250, 100, 20);
		frmJacks.getContentPane().add(jl_menu);
		JLabel jl_quanitity =new JLabel("Quantity:");
		jl_quanitity.setBounds(qX, 250, 100, 20);
		frmJacks.getContentPane().add(jl_quanitity);
		
		JLabel jl_BurgerQuantity =new JLabel("0");
		JLabel jl_FriesQuantity =new JLabel("0");
		JLabel jl_DrinkQuantity =new JLabel("0");
		JLabel jl_DessertQuantity =new JLabel("0");
		
		JLabel jl_Status =new JLabel("Welcome to Jack's!");
		jl_Status.setBounds(20, 600, 400, 30);
		frmJacks.getContentPane().add(jl_Status);

		JButton btn_Submit = new JButton("Submit");
		btn_Submit.setBounds(400, 600, 100, 30);
		frmJacks.getContentPane().add(btn_Submit);
		
		// *************************************************************************************************************************************************
		// 																				 MENU
		// *************************************************************************************************************************************************
		// BURGER 
		JLabel jl_Burger =new JLabel("Jack's Burger: $4.50");
		jl_Burger.setBounds(menuX, 280, 200, 20);
		frmJacks.getContentPane().add(jl_Burger);
		JButton btn_BurglerUp = new JButton("+");
		btn_BurglerUp.setBounds(upX, 280, btnW, btnH);
		frmJacks.getContentPane().add(btn_BurglerUp);
		jl_BurgerQuantity.setBounds(qX, 280, 200, 20);
		frmJacks.getContentPane().add(jl_BurgerQuantity);
		btn_BurglerUp.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				int i =  Integer.parseInt(jl_BurgerQuantity.getText());
				i++;
				jl_BurgerQuantity.setText(String.valueOf(i));
				double subTotal = CalculateTotal(Double.parseDouble(jl_BurgerQuantity.getText()), Double.parseDouble(jl_DrinkQuantity.getText()),
						Double.parseDouble(jl_FriesQuantity.getText()), Double.parseDouble(jl_DessertQuantity.getText()));
				jl_subTotal.setText(String.valueOf(dollar.format(subTotal)));
				double taxes = subTotal*.05;
				jl_tax.setText(String.valueOf(dollar.format(taxes)));
				
				double total = Double.parseDouble(jl_subTotal.getText()) +Double.parseDouble(jl_tax.getText())+ Double.parseDouble(jl_delivery.getText());
				jl_total.setText(dollar.format(total));
			}
		});
		
		JButton btn_BurglerDown = new JButton("-");
		btn_BurglerDown.setBounds(downX, 280, btnW, btnH);
		frmJacks.getContentPane().add(btn_BurglerDown);

		btn_BurglerDown.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				int i =  Integer.parseInt(jl_BurgerQuantity.getText());
				if(i>0) {
					i--;
					jl_BurgerQuantity.setText(String.valueOf(i));
					double subTotal = CalculateTotal(Double.parseDouble(jl_BurgerQuantity.getText()), Double.parseDouble(jl_DrinkQuantity.getText()),
							Double.parseDouble(jl_FriesQuantity.getText()), Double.parseDouble(jl_DessertQuantity.getText()));
					jl_subTotal.setText(String.valueOf(dollar.format(subTotal)));
					double taxes = subTotal*.05;
					jl_tax.setText(String.valueOf(dollar.format(taxes)));
					
					
					jl_total.setText(String.valueOf(dollar.format(subTotal +taxes + Double.parseDouble(jl_delivery.getText()))));
					
				}
				
			}
		});
		
		// DRINK
		int drinkY = 310;
		JLabel jl_Drink =new JLabel("Soft Drink: $1.50");
		jl_Drink.setBounds(menuX, drinkY, 200, 20);
		frmJacks.getContentPane().add(jl_Drink);
		JButton btn_DrinkUp = new JButton("+");
		btn_DrinkUp.setBounds(upX, drinkY, btnW, btnH);
		frmJacks.getContentPane().add(btn_DrinkUp);
		jl_DrinkQuantity.setBounds(qX, drinkY, 200, 20);
		frmJacks.getContentPane().add(jl_DrinkQuantity);
		btn_DrinkUp.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				int i =  Integer.parseInt(jl_DrinkQuantity.getText());
				i++;
				jl_DrinkQuantity.setText(String.valueOf(i));
				double subTotal = CalculateTotal(Double.parseDouble(jl_BurgerQuantity.getText()), Double.parseDouble(jl_DrinkQuantity.getText()),
						Double.parseDouble(jl_FriesQuantity.getText()), Double.parseDouble(jl_DessertQuantity.getText()));
				jl_subTotal.setText(String.valueOf(subTotal));
				double taxes = subTotal*.05;
				jl_tax.setText(String.valueOf(dollar.format(taxes)));
				
				
				jl_total.setText(String.valueOf(dollar.format(subTotal +taxes + Double.parseDouble(jl_delivery.getText()))));
				
				
			}
		});
		JButton btn_DrinkDown = new JButton("-");
		btn_DrinkDown.setBounds(downX, drinkY, btnW, btnH);
		frmJacks.getContentPane().add(btn_DrinkDown);

		btn_DrinkDown.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				int i =  Integer.parseInt(jl_DrinkQuantity.getText());
				if(i>0) {
					i--;
					jl_DrinkQuantity.setText(String.valueOf(i));
					double subTotal = CalculateTotal(Double.parseDouble(jl_BurgerQuantity.getText()), Double.parseDouble(jl_DrinkQuantity.getText()),
							Double.parseDouble(jl_FriesQuantity.getText()), Double.parseDouble(jl_DessertQuantity.getText()));
					jl_subTotal.setText(String.valueOf(subTotal));
					double taxes = subTotal*.05;
					jl_tax.setText(String.valueOf(dollar.format(taxes)));
					
					
					jl_total.setText(String.valueOf(dollar.format(subTotal +taxes + Double.parseDouble(jl_delivery.getText()))));
					
				}
				
			}
		});
		
		
		// FRIES
		int friesY = 340;
		JLabel jl_Fries =new JLabel("Jack's Fries: $ 2.50");
		jl_Fries.setBounds(menuX, friesY, 200, 20);
		frmJacks.getContentPane().add(jl_Fries);
		JButton btn_FriesUp = new JButton("+");
		btn_FriesUp.setBounds(upX, friesY, btnW, btnH);
		frmJacks.getContentPane().add(btn_FriesUp);
		jl_FriesQuantity.setBounds(qX, friesY, 200, 20);
		frmJacks.getContentPane().add(jl_FriesQuantity);
		btn_FriesUp.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				int i =  Integer.parseInt(jl_FriesQuantity.getText());
				i++;
				jl_FriesQuantity.setText(String.valueOf(i));
				double subTotal = CalculateTotal(Double.parseDouble(jl_BurgerQuantity.getText()), Double.parseDouble(jl_DrinkQuantity.getText()),
						Double.parseDouble(jl_FriesQuantity.getText()), Double.parseDouble(jl_DessertQuantity.getText()));
				jl_subTotal.setText(String.valueOf(subTotal));
				double taxes = subTotal*.05;
				jl_tax.setText(String.valueOf(dollar.format(taxes)));
				
				
				jl_total.setText(String.valueOf(dollar.format(subTotal +taxes + Double.parseDouble(jl_delivery.getText()))));
				
			}
		});
		JButton btn_FriesDown = new JButton("-");
		btn_FriesDown.setBounds(downX, friesY, btnW, btnH);
		frmJacks.getContentPane().add(btn_FriesDown);

		btn_FriesDown.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				int i =  Integer.parseInt(jl_FriesQuantity.getText());
				if(i>0) {
					i--;
					jl_FriesQuantity.setText(String.valueOf(i));
					double subTotal = CalculateTotal(Double.parseDouble(jl_BurgerQuantity.getText()), Double.parseDouble(jl_DrinkQuantity.getText()),
							Double.parseDouble(jl_FriesQuantity.getText()), Double.parseDouble(jl_DessertQuantity.getText()));
					jl_subTotal.setText(String.valueOf(subTotal));
					double taxes = subTotal*.05;
					jl_tax.setText(String.valueOf(dollar.format(taxes)));
					
					
					jl_total.setText(String.valueOf(dollar.format(subTotal +taxes + Double.parseDouble(jl_delivery.getText()))));
					
				}
				
			}
		});
		
		// DESSERT
		int dessertY = 370;
		JLabel jl_Dessert =new JLabel("Jack's Sundae: $ 3.00");
		jl_Dessert.setBounds(menuX, dessertY, 200, 20);
		frmJacks.getContentPane().add(jl_Dessert);
		JButton btn_DessertUp = new JButton("+");
		btn_DessertUp.setBounds(upX, dessertY, btnW, btnH);
		frmJacks.getContentPane().add(btn_DessertUp);
		jl_DessertQuantity.setBounds(qX, dessertY, 200, 20);
		frmJacks.getContentPane().add(jl_DessertQuantity);
		btn_DessertUp.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				int i =  Integer.parseInt(jl_DessertQuantity.getText());
				i++;
				jl_DessertQuantity.setText(String.valueOf(i));
				double subTotal = CalculateTotal(Double.parseDouble(jl_BurgerQuantity.getText()), Double.parseDouble(jl_DrinkQuantity.getText()),
						Double.parseDouble(jl_FriesQuantity.getText()), Double.parseDouble(jl_DessertQuantity.getText()));
				jl_subTotal.setText(String.valueOf(subTotal));
				double taxes = subTotal*.05;
				jl_tax.setText(String.valueOf(dollar.format(taxes)));
				
				
				jl_total.setText(String.valueOf(dollar.format(subTotal +taxes + Double.parseDouble(jl_delivery.getText()))));
				
				
			}
		});
		JButton btn_DessertDown = new JButton("-");
		btn_DessertDown.setBounds(downX, dessertY, btnW, btnH);
		frmJacks.getContentPane().add(btn_DessertDown);

		btn_DessertDown.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				int i = Integer.parseInt(jl_DessertQuantity.getText());
				if(i>0) {
					i--;
					jl_DessertQuantity.setText(String.valueOf(i));
					double subTotal = CalculateTotal(Double.parseDouble(jl_BurgerQuantity.getText()), Double.parseDouble(jl_DrinkQuantity.getText()),
							Double.parseDouble(jl_FriesQuantity.getText()), Double.parseDouble(jl_DessertQuantity.getText()));
					jl_subTotal.setText(String.valueOf(subTotal));
					double taxes = subTotal*.05;
					jl_tax.setText(String.valueOf(dollar.format(taxes)));
					
					
					jl_total.setText(String.valueOf(dollar.format(subTotal +taxes + Double.parseDouble(jl_delivery.getText()))));
					
				}
			}
		});
		
		
		// *************************************************************************************************************************************************
		// 																		 CUSTOMER INFO
		// *************************************************************************************************************************************************
		// NAME
		JLabel jl_customerName  =new JLabel("Name");
		jl_customerName.setBounds(20, 150, 100, 20);
		frmJacks.getContentPane().add(jl_customerName);
		JTextField tf_customerName = new JTextField(20);
		tf_customerName.setBounds(120, 150, 100, 20);
		frmJacks.getContentPane().add(tf_customerName); 
		
		// PHONE NUMBER
		JLabel jl_customerNumber =new JLabel("Number");
		jl_customerNumber.setBounds(250, 150, 100, 20);	
		frmJacks.getContentPane().add(jl_customerNumber);
		JTextField tf_customerNumber = new JTextField(20);
		tf_customerNumber.setBounds(350, 150, 150, 20);		
		frmJacks.getContentPane().add(tf_customerNumber); 
		
		// STREET
		JLabel jl_streetAddress =new JLabel("Street Address");
		jl_streetAddress.setBounds(20, 175, 100, 20);
		frmJacks.getContentPane().add(jl_streetAddress);
		JTextField tf_streetAddress = new JTextField(20);
		tf_streetAddress.setBounds(120, 175, 200, 20);
		frmJacks.getContentPane().add(tf_streetAddress); 
		
		// CITY
		JLabel jl_city =new JLabel("City");
		jl_city.setBounds(30, 200, 100, 20);
		frmJacks.getContentPane().add(jl_city);
		JTextField tf_city = new JTextField(20);
		tf_city.setBounds(60, 200, 100, 20);
		frmJacks.getContentPane().add(tf_city); 

		// STATE
		JLabel jl_state =new JLabel("State");
		jl_state.setBounds(170, 200, 100, 20);
		frmJacks.getContentPane().add(jl_state);
		JTextField tf_state = new JTextField(20);
		tf_state.setBounds(200, 200, 100, 20);
		frmJacks.getContentPane().add(tf_state);
		
		// ZIP
		JLabel jl_zipCode =new JLabel("Zip");
		jl_zipCode.setBounds(310, 200, 100, 20);
		frmJacks.getContentPane().add(jl_zipCode);
		JTextField tf_zipCode = new JTextField(20);
		tf_zipCode.setBounds(340, 200, 70, 20);
		frmJacks.getContentPane().add(tf_zipCode);
		tf_zipCode.addFocusListener(new FocusListener() {
			boolean gainFocus;
		      public void focusGained(FocusEvent e) {
		    	  gainFocus=true;
		        }

		        public void focusLost(FocusEvent e) {
					String zp = tf_zipCode.getText();
					if(!isPickUp && gainFocus) {
						if(zp.length()==5) {
							if (zp.contains(LOCALZIP)) {
								jl_Status.setText("Delivery available at normal cost.");
								jl_delivery.setText("5.00");
								jl_total.setText(String.valueOf(dollar.format(Double.parseDouble(jl_subTotal.getText()) +Double.parseDouble(jl_tax.getText()) + Double.parseDouble(jl_delivery.getText()))));
								btn_Submit.setEnabled(true);
							}else if(zp.contains(EXTRAZIP) ||zp.contains(EXTRAZIP2)) {
								jl_Status.setText("Delivery available at extra cost.");
								jl_delivery.setText("7.00");
								jl_total.setText(String.valueOf(dollar.format(Double.parseDouble(jl_subTotal.getText()) +Double.parseDouble(jl_tax.getText()) + Double.parseDouble(jl_delivery.getText()))));
								btn_Submit.setEnabled(true);
							}else {
								jl_Status.setText("Delivery unavailable. Please switch to pick-up.");
								jl_delivery.setText("0.00");
								jl_total.setText(String.valueOf(dollar.format(Double.parseDouble(jl_subTotal.getText()) +Double.parseDouble(jl_tax.getText()) + Double.parseDouble(jl_delivery.getText()))));
								btn_Submit.setEnabled(false);
							}				
							
						}else {
							jl_Status.setText("Zip code not valid.");
							jl_delivery.setText("0.00");
							jl_total.setText(String.valueOf(dollar.format(Double.parseDouble(jl_subTotal.getText()) +Double.parseDouble(jl_tax.getText()) + Double.parseDouble(jl_delivery.getText()))));
							btn_Submit.setEnabled(false);
						}
					}
					gainFocus=false;
		        }
		});
		
		
   		tf_streetAddress.setEditable(false);
		tf_city.setEditable(false);
		tf_state.setEditable(false);
		tf_zipCode.setEditable(false);
		

		// *************************************************************************************************************************************************
		// 																				Buttons
		// *************************************************************************************************************************************************
	    rb_pickUp.addItemListener(new ItemListener() {
	
	       @Override
	       public void itemStateChanged(ItemEvent e) {
	    	isPickUp= true;
	   		tf_streetAddress.setEditable(false);
			tf_city.setEditable(false);
			tf_state.setEditable(false);
			tf_zipCode.setEditable(false);
			btn_Submit.setEnabled(true);
	       }

	    });
	    rb_delivery.addItemListener(new ItemListener() {
	    	
		       @Override
		       public void itemStateChanged(ItemEvent e) {
			    	isPickUp= false;
			   		tf_streetAddress.setEditable(true);
					tf_city.setEditable(true);
					tf_state.setEditable(true);
					tf_zipCode.setEditable(true);
					btn_Submit.setEnabled(false);
		       }

		    });

	    
	    // SUBMIT BUTTON
	    btn_Submit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (isPickUp) { // Pick Up. Check name & number
					if (!tf_customerName.getText().isEmpty()
							&& !tf_customerNumber.getText().isEmpty()) {
						double total = Double.parseDouble(jl_total.getText());
						if (total>0) { 
							jl_Status.setText("Pick Up Order Completed.");
						}else {
							jl_Status.setText("Cannot submit empty order.");
						}
					}else {
						jl_Status.setText("Please fill in customer info.");
					}
				}else { // Delivery / Check all Customer info
					if (!tf_customerName.getText().isEmpty()
							&& !tf_customerNumber.getText().isEmpty()
							&& !tf_streetAddress.getText().isEmpty()
							&& !tf_state.getText().isEmpty()
							&& !tf_city.getText().isEmpty()
							&& !tf_zipCode.getText().isEmpty()) {
						double total = Double.parseDouble(jl_total.getText());
						if (total>0) {
							jl_Status.setText("Delivery Order Completed. Your order will arrive shortly.");
						}else {
							jl_Status.setText("Cannot submit empty order.");
						}
					}else {
						jl_Status.setText("Please fill in customer info.");
				}
			}
				
			}
		});
		
		JLabel jl =new JLabel();		// This needs to be at the end....
		frmJacks.getContentPane().add(jl); // The constraints will mess up otherwise
	}
	
	public double  CalculateTotal(double d, double e, double f, double g) {
		double subTotal = (d*BURGER) + (e*DRINK) + (f* FRIES) + (g*DESSERT);
		return subTotal;
	}
	



}

