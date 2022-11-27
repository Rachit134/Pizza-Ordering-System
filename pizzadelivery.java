import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

class GUI2 extends JFrame 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton res, par;	
	private ButtonGroup group;
	private JLabel logo_name, delivery_type, date_time, nop, name, address, contact, toppings_label, quantity_label, extraas_label, garlicB_label, tacos_label, coke_label, calzone_label;
	private ImageIcon logo;
	private JTextField nop_tf, name_tf, address_tf, contact_tf;
	private JPanel input_panel, delivery_panel, toppings_panel, toppings2_panel, quantity_panel, extraas_panel, initial_panel, buttons_panel;
	private JPanel top1_panel, top2_panel,ext1_panel,ext2_panel;
	private JCheckBox top_onion, top_mushroom, top_broccoli, top_corn, top_capsicum, top_cheese;
	String date;
	public float rate = 80;		//base rate is Rs.80

	private JLabel quantity_op_label, quantity_op, extraas_op_label, extraas_op, garlicB_op, tacos_op, coke_op,calzone_op,rate_label, rate_op_label;
	private JButton print,clear;
	private ImageIcon print_icon, clear_icon;
	private JLabel nop_op, name_op, address_op, contact_op;
	String nop_str, name_str, address_str, contact_str;
	private JLabel nop2, name2, address2, contact2;
	private JLabel date_time2;
	private JLabel logo_name2;
	
	
	public GUI2() 
	{
		super("Pizzeria");
		setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));
		logo = new ImageIcon("pizza.png");			
		logo_name = new JLabel("Pizzeria", logo, 0);
		initial_panel = new JPanel();
		initial_panel.setLayout(new GridLayout(2, 1));		
		
		JOptionPane.showMessageDialog(new JFrame(), "Welcome to Pizzeria!", "Pizzeria", JOptionPane.PLAIN_MESSAGE, logo);
		
		//Logo Icon and Name
		logo = new ImageIcon("pizza.png");			
		logo_name = new JLabel("Pizzeria", logo, 0);		
		initial_panel.add(logo_name);
		
		//Date and Time
		date = new SimpleDateFormat("EEEE yyyy-MM-dd   hh:mm:ss a zzz").format(new Date());
		date_time = new JLabel(date);
		initial_panel.add(date_time);					
			
		add(initial_panel);	
	}
	
	
	public void Input()
	{		
		input_panel = new JPanel();
		input_panel.setLayout(new GridLayout(5, 2, 5, 5));	
					
		delivery_panel = new JPanel();
		delivery_panel.setLayout(new GridLayout(1, 3));			
		
		//Delivery Type
		delivery_type = new JLabel("Delivery Type:");
	//	delivery_panel.add(delivery_type);		
		res = new JRadioButton("In-Restaurant",true);
		res.setActionCommand("res");
		par = new JRadioButton("Parcel");
		par.setActionCommand("par");
		
				
		group = new ButtonGroup();
		group.add(res);
		group.add(par);
		delivery_panel.add(res);
		delivery_panel.add(par);
		
		
		input_panel.add(delivery_type);					
		input_panel.add(delivery_panel);		
		
		//Number of People
		nop = new JLabel("No of People");		
		nop_tf = new JTextField("", 5);
		input_panel.add(nop);
		input_panel.add(nop_tf);						
		
		//Parcel Details
		name = new JLabel("Name");
		address = new JLabel("Address");
		contact = new JLabel("Contact Number");
		name_tf = new JTextField("", 10);
		address_tf = new JTextField("", 20);
		contact_tf = new JTextField("", 10);
		input_panel.add(name);
		input_panel.add(name_tf);					
		input_panel.add(address);
		input_panel.add(address_tf);
		input_panel.add(contact);
		input_panel.add(contact_tf);
				
		add(input_panel);
		
	
		
		// Disable Extra Labels & TextFields depending on RadioButton Selected
		res.addChangeListener(new ChangeListener()
		{
			/**
			 * @param arg0
			 */
			/**
			 * @param arg0
			 */
			public void stateChanged(ChangeEvent arg0)
			{
				if(res.isSelected())
				{
					name.setEnabled(true);
					address.setEnabled(false);
					contact.setEnabled(false); 
					name_tf.setEditable(true);
					address_tf.setEditable(false);
					contact_tf.setEditable(false);	
					name_tf.setEnabled(true);
					address_tf.setEnabled(false);
					contact_tf.setEnabled(false);
					name_tf.setText("");
					address_tf.setText("");
					contact_tf.setText("");
					nop.setEnabled(true);
					nop_tf.setEnabled(true);					
					nop_tf.setEditable(true);		
				}
			}
		});
		
		par.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent arg0)
			{
				if(par.isSelected())
				{
					nop.setEnabled(false);
					nop_tf.setEnabled(false);					
					nop_tf.setEditable(false);
					nop_tf.setText("");
					name.setEnabled(true);
					address.setEnabled(true);
					contact.setEnabled(true); 
					name_tf.setEditable(true);
					address_tf.setEditable(true);
					contact_tf.setEditable(true);	
					name_tf.setEnabled(true);
					address_tf.setEnabled(true);
					contact_tf.setEnabled(true);				
				}
			}
		});								
	
	}
	
	public void Toppings()
	{
		top1_panel = new JPanel();
		top1_panel.setLayout(new GridLayout(1, 3));
		
		top2_panel = new JPanel();
		top2_panel.setLayout(new GridLayout(1, 3));
		
		toppings_panel = new JPanel();
		toppings_panel.setLayout(new GridLayout(2, 1));
		
		toppings2_panel = new JPanel();
		toppings2_panel.setLayout(new GridLayout(2, 1));
		
		toppings_label = new JLabel("Toppings:");	
		
		top_onion = new JCheckBox("Onion", false);
		top_mushroom = new JCheckBox("Mushroom", false);
		top_broccoli = new JCheckBox("Broccoli", false);
		top_corn = new JCheckBox("Corn", false);
		top_capsicum = new JCheckBox("Capsicum", false);
		top_cheese = new JCheckBox("Cheese", false);
		
		
		ItemListener itemListener = new ItemListener()
		{
			public void itemStateChanged(ItemEvent itemEvent)
			{
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED)
				{
					rate = rate + 15;
				}
			}
		};
			
		top_onion.addItemListener(itemListener);
		top_mushroom.addItemListener(itemListener);
		top_broccoli.addItemListener(itemListener);
		top_corn.addItemListener(itemListener);
		top_capsicum.addItemListener(itemListener);
		top_cheese.addItemListener(itemListener);	
		
		top1_panel.add(top_onion);
		top1_panel.add(top_mushroom);
		top1_panel.add(top_broccoli);	
		top2_panel.add(top_corn);
		top2_panel.add(top_capsicum);	
		top2_panel.add(top_cheese);					
	
		toppings_panel.add(top1_panel);
		toppings_panel.add(top2_panel);
					
		toppings2_panel.add(toppings_label);
		toppings2_panel.add(toppings_panel);
		add(toppings2_panel);
		
	}
	
	
	public void Quantity() 
	{
		quantity_label = new JLabel("Quantity: ");
		quantity_op_label = new JLabel("Quantity: ");
		quantity_op = new JLabel();
		quantity_panel = new JPanel();
		quantity_panel.setLayout(new GridLayout(2, 2));
		String[] quantity = {"1", "2", "3", "4", "5"};
		
		JComboBox<String>quantity_box = new JComboBox<String>();
		for(int i = 0; i < quantity.length; i++)		
			quantity_box.addItem(quantity[i]);
		
		quantity_box.setSelectedIndex(0);
						
		quantity_panel.add(quantity_label);
		quantity_panel.add(quantity_box);
		
		
		quantity_box.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				quantity_op.setText((String)((JComboBox<?>)e.getSource()).getSelectedItem());
			}	
		});
		

		add(quantity_panel);
	} 
	
	public void Extraas() 
	{
		extraas_label = new JLabel("Extraas: ");
		extraas_op_label = new JLabel("Extraas");
		extraas_op = new JLabel();
		extraas_panel = new JPanel();
		extraas_panel.setLayout(new GridLayout(3, 1 , 15, 10));
		
		ext1_panel = new JPanel();
		ext1_panel.setLayout(new GridLayout(1, 4));
		ext2_panel = new JPanel();
		ext2_panel.setLayout(new GridLayout(1, 4));
		
		garlicB_op = new JLabel();
		tacos_op = new JLabel();
		coke_op = new JLabel();
		calzone_op = new JLabel();
		
		garlicB_label = new JLabel("   Garlic Bread ");
		tacos_label = new JLabel("   Tacos ");
		coke_label = new JLabel("   Coke ");
		calzone_label = new JLabel("   Calzone ");
		
		String[] garlicB = {"0","1", "2", "3", "4", "5"};
		String[] tacos = {"0","1", "2", "3", "4", "5"};
		String[] coke = {"0","1", "2", "3", "4", "5"};
		String[] calzone = {"0","1", "2", "3", "4", "5"};
		
		JComboBox<String>garlicB_box = new JComboBox<String>();
		for(int i = 0; i < garlicB.length; i++)		
			garlicB_box.addItem(garlicB[i]);
		
		garlicB_box.setSelectedIndex(0);		
		
		garlicB_box.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
			garlicB_op.setText((String)((JComboBox<?>)e.getSource()).getSelectedItem());
			}	
		});
		
		JComboBox<String>tacos_box = new JComboBox<String>();
		for(int i = 0; i < tacos.length; i++)		
			tacos_box.addItem(tacos[i]);
		
		tacos_box.setSelectedIndex(0);		
		
		tacos_box.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
			tacos_op.setText((String)((JComboBox<?>)e.getSource()).getSelectedItem());
			}	
		});
		
		JComboBox<String>coke_box = new JComboBox<String>();
		for(int i = 0; i < coke.length; i++)		
			coke_box.addItem(coke[i]);
		
		coke_box.setSelectedIndex(0);		
		
		coke_box.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
			coke_op.setText((String)((JComboBox<?>)e.getSource()).getSelectedItem());
			}	
		});
		
		JComboBox<String>calzone_box = new JComboBox<String>();
		for(int i = 0; i < calzone.length; i++)		
			calzone_box.addItem(calzone[i]);
		
		calzone_box.setSelectedIndex(0);		
		
		calzone_box.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
			calzone_op.setText((String)((JComboBox<?>)e.getSource()).getSelectedItem());
			}	
		});
		
		ext1_panel.add(garlicB_box);
		ext1_panel.add(garlicB_label);
		ext1_panel.add(tacos_box);
		ext1_panel.add(tacos_label);
		ext2_panel.add(coke_box);
		ext2_panel.add(coke_label);
		ext2_panel.add(calzone_box);
		ext2_panel.add(calzone_label);
		extraas_panel.add(extraas_label);
		extraas_panel.add(ext1_panel);
		extraas_panel.add(ext2_panel);
		add(extraas_panel);
	}


	
	public void Output()
	{	
		print_icon = new ImageIcon("print.png");
		clear_icon= new ImageIcon("clear.png");
		
		buttons_panel = new JPanel();
		buttons_panel.setLayout(new GridLayout(1, 2, 75, 10));
					
		nop2 = new JLabel("No pf People: ");
		name2 = new JLabel("Name: ");
		address2 = new JLabel("Address: ");
		contact2= new JLabel("Contact Number: ");
		
				
				
		String rate_str;
		rate_str = Float.toString(rate);
		rate_label = new JLabel("Rate: ");
		rate_op_label = new JLabel(rate_str);	
		
		
		print = new JButton("Print");
		print.setRolloverIcon(print_icon);
		print.setRolloverEnabled(true);
		clear = new JButton("Clear");
		print.setRolloverIcon(clear_icon);
		print.setRolloverEnabled(true);
	
		
		buttons_panel.add(print);
		buttons_panel.add(clear);		
			
		add(buttons_panel);
						
				
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				nop_tf.setText("");
				name_tf.setText("");
				address_tf.setText("");
				contact_tf.setText("");
				group.clearSelection();
				name.setEnabled(true);
				address.setEnabled(true);
				contact.setEnabled(true); 
					
				name_tf.setEditable(true);
				address_tf.setEditable(true);
				contact_tf.setEditable(true);	
				name_tf.setEnabled(true);
				address_tf.setEnabled(true);
				contact_tf.setEnabled(true);
				nop.setEnabled(true);
				nop_tf.setEnabled(true);					
				nop_tf.setEditable(true);
				
				top_broccoli.setSelected(false);
				top_capsicum.setSelected(false);
				top_cheese.setSelected(false);
				top_corn.setSelected(false);
				top_mushroom.setSelected(false);
				top_onion.setSelected(false);
				
					
			}
		});
		
		print.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				String rate_str;
				rate_str = Float.toString(rate);
				rate_label = new JLabel("Rate: ");
				rate_op_label = new JLabel(rate_str);
							
				JFrame output = new JFrame();
				output.setLayout(new GridLayout(9, 2));
				
				logo_name2 = new JLabel("Pizza Palace", logo, 0);		
				output.add(logo_name2);				
				date = new SimpleDateFormat("E yyyy-MM-dd HH:mm:ss").format(new Date());							
				date_time2 = new JLabel(date);
				output.add(date_time2);										
				
				nop_str = nop_tf.getText();
				name_str = name_tf.getText();
				address_str = address_tf.getText();
				contact_str = contact_tf.getText();
				
				nop_op = new JLabel(nop_str);
				name_op = new JLabel(name_str);
				address_op = new JLabel(address_str);
				contact_op = new JLabel(contact_str);
				
				output.add(nop2);
				output.add(nop_op);
				output.add(name2);
				output.add(name_op);
				output.add(address2);
				output.add(address_op);
				output.add(contact2);
				output.add(contact_op);	
				
				output.add(rate_label);
				output.add(rate_op_label);
				output.add(quantity_op_label);				
				output.add(quantity_op);
				output.add(extraas_op_label);				
				output.add(extraas_op);
				output.pack();
				output.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				output.setLocationRelativeTo(null);
			//	output.setSize(100, 100);
				output.setVisible(true);
				
				JOptionPane.showMessageDialog(null, "Your Order Has Been Placed!");
			}
		});
		
	}
			
}


class GUI
{
	public static void main(String[] args) 
	{
		GUI2 gui_obj = new GUI2();	
		gui_obj.Input();		
		gui_obj.Toppings();
		gui_obj.Quantity();
		gui_obj.Extraas();
		gui_obj.Output();	
				
		gui_obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui_obj.setLocationByPlatform(true);
		gui_obj.setSize(575,600);
		gui_obj.setVisible(true);
		
	}
