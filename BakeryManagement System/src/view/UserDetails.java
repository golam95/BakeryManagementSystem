package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import Controller.Databaseconnect;

@SuppressWarnings("serial")
public class UserDetails extends JInternalFrame implements ActionListener, KeyListener {
	JFrame JFParentFrame;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	Databaseconnect connect = new Databaseconnect();
	Connection conn;
	public static int record;
	public static int record1;
	public static int record2;
	String img_path = "";

	// main
	private JButton btn_newuser = new JButton("User");
	private JButton btn_updateuser = new JButton("View All");
	private JButton btn_vandetails = new JButton("VanDetails");
	private JButton btn_emergency = new JButton("Argent");
	private JButton btn_mainmenu = new JButton("Home");
	// first
	JLabel lbl_firstName = new JLabel("First Name");
	JLabel lbl_lastName = new JLabel("Last Name");
	JLabel lbl_nic = new JLabel("NIC");
	JLabel lbl_Email = new JLabel("Email");
	JLabel lbl_contact = new JLabel("Contact No");
	JLabel lbl_logintype = new JLabel("LogIn Type");
	JLabel lbl_username = new JLabel("User Name");
	JLabel lbl_password = new JLabel("Password");

	JLabel lbl_message = new JLabel();
	JLabel lbl_messagenew = new JLabel("");
	private JButton btn_clear = new JButton("Clear");
	JDateChooser date = new JDateChooser();
	JLabel lbl_date = new JLabel("Date: ");

	private JButton btn_confirt = new JButton("Confirm");
	JLabel lbl_imageuser = new JLabel("User Image");// image image image image
	private JButton btn_confirmimage = new JButton("Browse");

	JTextField txt_username = new JTextField();
	JPasswordField txt_password = new JPasswordField();
	JTextField txt_firstName = new JTextField();
	JTextField txt_lastName = new JTextField();
	JTextField txt_nic = new JTextField();
	JTextField txt_Email = new JTextField();
	JTextField txt_contact = new JTextField();

	JComboBox<String> txt_logintype = new JComboBox<String>();

	JTextField txt_firstName1 = new JTextField();
	JTextField txt_lastName1 = new JTextField();
	JTextField txt_nic1 = new JTextField();
	JTextField txt_Email1 = new JTextField();
	JTextField txt_contact1 = new JTextField();

	JComboBox<String> txt_logintype1 = new JComboBox<String>();
	JTextField txt_username1 = new JTextField();
	JPasswordField txt_password1 = new JPasswordField();
	JPanel pan_details = new JPanel();
	JPanel pan_right = new JPanel();
	JPanel pan_left = new JPanel();
	/// update
	private JButton btn_update = new JButton("Update");

	private JComboBox<Object> cmb_id = new JComboBox<Object>();
	JLabel lbl_id = new JLabel("Select");
	JLabel lbl_old = new JLabel("Old Password");
	JLabel lbl_new = new JLabel("New Password");
	JPasswordField txt_old = new JPasswordField();
	private JCheckBox btncheck = new JCheckBox(new ImageIcon("images/see.png"));
	JPasswordField txt_new = new JPasswordField();

	/// vandetails

	private JLabel lbl_vanid = new JLabel("Van Number");
	private JLabel lbl_description = new JLabel("Description");
	private JLabel lbl_amount = new JLabel("Total Amount");
	private JLabel lbl_frome = new JLabel("From");
	private JTextField txt_frome = new JTextField();

	private JTextField txt_vanid = new JTextField();// here is the textbox
	private JTextArea txt_description = new JTextArea();
	private JTextField txt_amount = new JTextField();

	private JLabel lbl_searchbyvanid = new JLabel("Search By ID");
	private JComboBox<Object> cmb_vanid = new JComboBox<Object>();
	private JButton btn_vanadd = new JButton("Add");
	private JButton btn_vandelete = new JButton("Delete");
	JPanel pan_vanleft = new JPanel();
	JPanel pan_vanright = new JPanel();

	/// vandetails

	// Emegency service
	private JLabel lbl_contackID = new JLabel("Contact ID");
	private JLabel lbl_name = new JLabel("Name");
	private JLabel lbl_NIC = new JLabel("NIC");
	private JLabel lbl_contactno = new JLabel("Contact No");
	private JLabel lbl_email = new JLabel("Email");
	private JLabel lbl_location = new JLabel("Location");
	private JLabel lbl_stock = new JLabel("Stock");

	private JTextField txt_contackID = new JTextField();
	private JTextField txt_name = new JTextField();
	private JTextField txt_NIC = new JTextField();
	private JTextField txt_contactno = new JTextField();
	private JTextField txt_email = new JTextField();
	private JTextField txt_location = new JTextField();
	private JTextField txt_stock = new JTextField();

	private JLabel lbl_orderID = new JLabel("Order ID");
	private JLabel lbl_ordername = new JLabel("Name");
	private JLabel lbl_ordernic = new JLabel("Phone");
	private JLabel lbl_ordercontact = new JLabel("Product Name");
	private JLabel lbl_quantity = new JLabel("Quantity");
	private JLabel lbl_amo = new JLabel("Total Amount");

	private JTextField txt_orderID = new JTextField();
	private JTextField txt_ordername = new JTextField();
	private JTextField txt_orderphone = new JTextField();
	private JTextField txt_ordercontact = new JTextField();
	private JTextField txt_quantity = new JTextField();
	private JTextField txt_amo = new JTextField();

	private JButton btn_empadd = new JButton("save");
	private JButton btn_empupdate = new JButton("Update");
	private JButton btn_empdelete = new JButton("Delete");
	private JComboBox<String> cmb_searchemp = new JComboBox<String>();

	JLabel lbl_empsearch = new JLabel("Search");

	private JButton btn_orderadd = new JButton("save");
	private JButton btn_orderupdate = new JButton("Update");
	private JButton btn_orderdelte = new JButton("Delete");

	private JComboBox cmb_searchorder = new JComboBox();
	JLabel lbl_ordersearch = new JLabel("Search");

	private JTable talble = new JTable();
	private JScrollPane scrollpane = new JScrollPane();
	JPanel pan_order1 = new JPanel();
	JPanel pan_order2 = new JPanel();
	JPanel pan_order3 = new JPanel();

	String firstname, lastname, nic, email, contactno, logintype, username, password, submitdate;
	String vanid, vandes, vanfrom, vanamount, vandate;
	String old_password, new_password;
	String dialogmessage;
	int dialogtype;
	String contact_id, contact_name, contact_nic, contact_phone, contact_email, contact_location, contact_stock,
			contact_date;
	String order_id, order_productname, order_quantity, order_totalamont, order_date;

	// emergencey service

	SettingManu settings = new SettingManu();

	@SuppressWarnings("unchecked")
	public UserDetails(JFrame getParentFrame) {
		super("Customer Details", true, true, true, true);
		this.setSize(1010, 550);
		this.setLayout(null);
		JPanel pan = new JPanel();
		pan.setLayout(null);
		pan.setBounds(0, 0, 130, 850);

		btn_newuser.setBounds(20, 40, 80, 80);
		btn_updateuser.setBounds(20, 150, 80, 80);
		btn_vandetails.setBounds(20, 260, 80, 80);
		btn_emergency.setBounds(20, 370, 80, 80);
		btn_mainmenu.setBounds(20, 480, 80, 80);

		Border thickBorder = new LineBorder(Color.decode("#394B58"), 12);

		btn_newuser.setBorder(thickBorder);
		btn_newuser.setBackground(Color.decode("#250800"));
		btn_newuser.setForeground(Color.WHITE);
		btn_updateuser.setBorder(thickBorder);
		btn_updateuser.setBackground(Color.decode("#250800"));
		btn_updateuser.setForeground(Color.WHITE);
		btn_vandetails.setBorder(thickBorder);
		btn_vandetails.setBackground(Color.decode("#250800"));
		btn_vandetails.setForeground(Color.WHITE);
		btn_emergency.setBorder(thickBorder);
		btn_emergency.setBackground(Color.decode("#250800"));
		btn_emergency.setForeground(Color.WHITE);
		btn_mainmenu.setBorder(thickBorder);
		btn_mainmenu.setBackground(Color.decode("#250800"));
		btn_mainmenu.setForeground(Color.WHITE);

		pan.add(btn_newuser);
		pan.add(btn_vandetails);
		pan.add(btn_emergency);
		pan.add(btn_mainmenu);
		btn_newuser.addActionListener(this);
		btn_updateuser.addActionListener(this);
		btn_vandetails.addActionListener(this);
		btn_emergency.addActionListener(this);
		btn_mainmenu.addActionListener(this);
		btn_confirt.addActionListener(this);
		btn_confirmimage.addActionListener(this);
		txt_password.addKeyListener(this);
		txt_new.addKeyListener(this);
		btn_vanadd.addActionListener(this);
		btn_update.addActionListener(this);
		btn_vandelete.addActionListener(this);
		btn_empadd.addActionListener(this);
		btn_empupdate.addActionListener(this);
		btn_empdelete.addActionListener(this);

		txt_logintype.setBackground(Color.WHITE);
		btn_clear.setBackground(Color.ORANGE);
		btn_confirt.setBackground(Color.ORANGE);
		btn_confirmimage.setBackground(Color.ORANGE);

		pan.add(btn_updateuser);
		pan.setBackground(Color.decode("#D2DDF1"));

		Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		pan_details.setBorder(raisedetched);
		pan_details.setBounds(200, 50, 1100, 480);
		pan_details.setLayout(null);
		TitledBorder reg_Border = BorderFactory.createTitledBorder("User Information");
		reg_Border.setTitleJustification(TitledBorder.LEFT);
		pan_left.setBorder(reg_Border);
		pan_left.setBounds(20, 20, 550, 440);
		pan_left.setLayout(null);
		pan_left.setBackground(Color.WHITE);
		// pan_left.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		lbl_firstName.setBounds(20, 70, 100, 30);
		lbl_lastName.setBounds(20, 130, 100, 30);
		lbl_nic.setBounds(20, 180, 100, 30);
		lbl_Email.setBounds(20, 230, 100, 30);
		lbl_contact.setBounds(20, 280, 100, 30);
		lbl_logintype.setBounds(20, 330, 100, 30);

		txt_firstName.setBounds(130, 70, 180, 30);
		txt_lastName.setBounds(130, 130, 180, 30);
		txt_nic.setBounds(130, 180, 180, 30);
		txt_Email.setBounds(130, 230, 180, 30);
		txt_contact.setBounds(130, 280, 180, 30);
		txt_logintype.setBounds(130, 330, 180, 30);

		lbl_date.setBounds(1080, 10, 100, 30);

		date.setBounds(1140, 15, 160, 25);
		btn_clear.setBounds(690, 15, 140, 25);
		btn_clear.addActionListener(this);

		lbl_id.setBounds(200, 15, 100, 25);
		cmb_id.setBounds(290, 15, 160, 25);
		String cat_empName = (String) cmb_id.getSelectedItem();
		cmb_id.addActionListener(this);
		txt_logintype.addItem("Select Type");
		txt_logintype.addItem("Onwer");
		txt_logintype.addItem("Employee");
		txt_logintype1.addItem("Select Type");
		txt_logintype1.addItem("Onwer");
		txt_logintype1.addItem("Employee");

		this.add(lbl_date);
		this.add(date);
		this.add(btn_clear);
		this.add(lbl_id);
		this.add(cmb_id);

		txt_firstName1.setBounds(130, 70, 180, 30);
		txt_lastName1.setBounds(130, 130, 180, 30);
		txt_nic1.setBounds(130, 180, 180, 30);
		txt_Email1.setBounds(130, 230, 180, 30);
		txt_contact1.setBounds(130, 280, 180, 30);
		txt_logintype1.setBounds(130, 330, 180, 30);

		pan_left.add(txt_firstName1);
		pan_left.add(txt_lastName1);
		pan_left.add(txt_nic1);
		pan_left.add(txt_Email1);
		pan_left.add(txt_contact1);
		pan_left.add(txt_logintype1);

		pan_left.add(txt_firstName);
		pan_left.add(lbl_firstName);
		pan_left.add(lbl_lastName);
		pan_left.add(lbl_nic);
		pan_left.add(lbl_Email);
		pan_left.add(lbl_contact);
		pan_left.add(lbl_logintype);
		pan_left.add(txt_logintype);

		pan_left.add(txt_lastName);
		pan_left.add(txt_nic);
		pan_left.add(txt_Email);
		pan_left.add(txt_contact);
		TitledBorder reg_Border1 = BorderFactory.createTitledBorder("User LogIn");
		reg_Border1.setTitleJustification(TitledBorder.LEFT);
		pan_right.setBorder(reg_Border);
		pan_right.setBackground(Color.WHITE);
		pan_right.setLayout(null);
		pan_right.setBounds(600, 20, 480, 440);
		lbl_username.setBounds(20, 70, 100, 30);
		lbl_password.setBounds(20, 130, 100, 30);
		txt_username.setBounds(130, 70, 180, 30);
		lbl_imageuser.setBounds(335, 70, 120, 120);
		lbl_imageuser.setBorder(BorderFactory.createLineBorder(Color.black));
		txt_password.setBounds(130, 130, 180, 30);

		txt_username1.setBounds(130, 70, 180, 30);
		txt_password1.setBounds(130, 130, 180, 30);
		pan_right.add(txt_username1);
		pan_right.add(txt_password1);
		pan_right.add(lbl_imageuser);

		lbl_message.setBounds(130, 170, 180, 30);
		lbl_message.setText("");
		pan_right.add(lbl_message);
		btn_confirt.setBounds(130, 210, 180, 20);
		btn_confirmimage.setBounds(335, 210, 120, 20);

		lbl_old.setBounds(20, 240, 100, 20);
		lbl_new.setBounds(20, 300, 100, 20);
		txt_old.setBounds(130, 240, 180, 30);
		btncheck.setBounds(360, 240, 180, 30);
		btncheck.setBackground(Color.WHITE);
		pan_right.add(btncheck);
		btncheck.addActionListener(this);
		lbl_messagenew.setBounds(360, 300, 180, 30);
		txt_new.setBounds(130, 300, 180, 30);
		btn_update.setBounds(130, 350, 180, 20);
		pan_right.add(btn_confirmimage);
		pan_right.add(lbl_messagenew);
		pan_right.add(lbl_old);
		pan_right.add(lbl_new);
		pan_right.add(txt_old);
		pan_right.add(txt_new);
		pan_right.add(btn_update);
		pan_right.add(lbl_username);
		pan_right.add(lbl_password);
		pan_right.add(btn_confirt);
		pan_right.add(txt_username);
		pan_right.add(txt_password);
		pan_details.add(pan_left);
		pan_details.add(pan_right);
		pan_details.setBackground(Color.WHITE);
		this.add(pan_details);
		TitledBorder van_border = BorderFactory.createTitledBorder("Van Details");
		van_border.setTitleJustification(TitledBorder.LEFT);
		pan_vanleft.setBorder(van_border);
		pan_vanleft.setBounds(20, 20, 550, 430);
		pan_vanleft.setLayout(null);

		lbl_vanid.setBounds(20, 70, 100, 30);
		lbl_description.setBounds(20, 130, 100, 100);

		lbl_frome.setBounds(20, 250, 100, 30);
		lbl_amount.setBounds(20, 310, 100, 30);
		Border thick_sager_Border = new LineBorder(Color.GRAY, 1);
		txt_description.setBorder(thick_sager_Border);

		txt_vanid.setBounds(130, 70, 180, 30);
		txt_description.setBounds(130, 130, 180, 100);
		txt_frome.setBounds(130, 250, 180, 30);
		txt_amount.setBounds(130, 310, 180, 30);

		pan_vanleft.add(lbl_frome);

		pan_vanleft.add(txt_frome);

		pan_vanleft.add(txt_vanid);
		pan_vanleft.add(txt_description);
		pan_vanleft.add(txt_amount);

		pan_vanleft.add(lbl_vanid);
		pan_vanleft.add(lbl_description);
		pan_vanleft.add(lbl_amount);

		pan_details.add(pan_vanleft);
		TitledBorder van_border1 = BorderFactory.createTitledBorder("Search Details");
		van_border1.setTitleJustification(TitledBorder.LEFT);
		pan_vanright.setBorder(van_border1);
		pan_vanright.setLayout(null);
		pan_vanright.setBounds(600, 20, 480, 430);
		lbl_searchbyvanid.setBounds(20, 70, 100, 30);
		cmb_vanid.setBounds(130, 70, 190, 30);
		pan_vanright.add(lbl_searchbyvanid);
		pan_vanright.add(cmb_vanid);

		btn_vanadd.setBounds(130, 350, 190, 20);
		btn_vandelete.setBounds(130, 390, 190, 20);
		pan_vanright.add(btn_vanadd);
		pan_vanright.add(btn_vandelete);

		TitledBorder emergency_order = BorderFactory.createTitledBorder("Others bakery Onwers INFO");
		emergency_order.setTitleJustification(TitledBorder.LEFT);
		pan_order1.setBorder(van_border);
		pan_order1.setBounds(20, 20, 550, 430);
		pan_order1.setLayout(null);
		lbl_contackID.setBounds(20, 40, 100, 30);
		lbl_name.setBounds(20, 100, 100, 30);
		lbl_NIC.setBounds(20, 150, 100, 30);
		lbl_contactno.setBounds(20, 200, 100, 30);
		lbl_email.setBounds(20, 250, 100, 30);
		lbl_location.setBounds(20, 300, 100, 30);
		lbl_stock.setBounds(20, 350, 100, 30);
		txt_contackID.setBounds(130, 40, 180, 30);
		txt_name.setBounds(130, 100, 180, 30);
		txt_NIC.setBounds(130, 150, 180, 30);
		txt_contactno.setBounds(130, 200, 180, 30);
		txt_email.setBounds(130, 250, 180, 30);
		txt_location.setBounds(130, 300, 180, 30);
		txt_stock.setBounds(130, 350, 180, 30);

		lbl_empsearch.setBounds(410, 10, 50, 30);
		cmb_searchemp.setBounds(350, 40, 180, 30);
		van_cmb_otheronwer(cmb_searchemp);
		cmb_searchemp.addActionListener(this);
		String inforation = (String) cmb_searchemp.getSelectedItem();
		action_othe_onwer(inforation);

		btn_empadd.setBounds(350, 300, 180, 20);
		btn_empupdate.setBounds(350, 330, 180, 20);
		btn_empdelete.setBounds(350, 360, 180, 20);
		pan_order1.add(btn_empadd);
		pan_order1.add(btn_empupdate);
		pan_order1.add(btn_empdelete);

		pan_order1.add(lbl_empsearch);
		pan_order1.add(cmb_searchemp);

		pan_order3.setBackground(Color.WHITE);
		pan_order2.setBackground(Color.WHITE);
		pan_vanleft.setBackground(Color.WHITE);
		pan_vanright.setBackground(Color.WHITE);
		cmb_searchorder.setBackground(Color.WHITE);
		pan_order1.setBackground(Color.WHITE);
		cmb_id.setBackground(Color.WHITE);
		cmb_vanid.setBackground(Color.WHITE);
		btn_vanadd.setBackground(Color.ORANGE);
		btn_vandelete.setBackground(Color.ORANGE);
		btn_orderadd.setBackground(Color.ORANGE);
		btn_orderupdate.setBackground(Color.ORANGE);
		btn_orderdelte.setBackground(Color.ORANGE);
		txt_logintype.setBackground(Color.WHITE);
		txt_logintype1.setBackground(Color.WHITE);
		btn_empadd.setBackground(Color.ORANGE);
		btn_empupdate.setBackground(Color.ORANGE);
		btn_empdelete.setBackground(Color.ORANGE);
		cmb_searchemp.setBackground(Color.WHITE);
		btn_update.setBackground(Color.ORANGE);
		pan_order1.add(txt_contackID);
		pan_order1.add(txt_name);
		pan_order1.add(txt_NIC);
		pan_order1.add(txt_contactno);
		pan_order1.add(txt_email);
		pan_order1.add(txt_location);
		pan_order1.add(txt_stock);

		pan_order1.add(lbl_contackID);
		pan_order1.add(lbl_name);
		pan_order1.add(lbl_NIC);
		pan_order1.add(lbl_contactno);
		pan_order1.add(lbl_email);
		pan_order1.add(lbl_location);
		pan_order1.add(lbl_stock);

		TitledBorder emgency_right = BorderFactory.createTitledBorder("Order Details");
		emgency_right.setTitleJustification(TitledBorder.LEFT);
		pan_order2.setBorder(van_border1);
		pan_order2.setLayout(null);
		pan_order2.setBounds(600, 20, 480, 430);

		lbl_orderID.setBounds(20, 70, 100, 30);
		lbl_ordername.setBounds(20, 130, 100, 30);
		lbl_ordernic.setBounds(20, 180, 100, 30);
		lbl_ordercontact.setBounds(20, 230, 100, 30);
		lbl_quantity.setBounds(20, 280, 100, 30);
		lbl_amo.setBounds(20, 330, 100, 30);

		txt_orderID.setBounds(130, 70, 180, 30);
		txt_ordername.setBounds(130, 130, 180, 30);
		txt_orderphone.setBounds(130, 180, 180, 30);
		txt_ordercontact.setBounds(130, 230, 180, 30);
		txt_quantity.setBounds(130, 280, 180, 30);
		txt_amo.setBounds(130, 330, 180, 30);

		lbl_ordersearch.setBounds(350, 40, 50, 30);
		cmb_searchorder.setBounds(340, 70, 120, 30);

		btn_orderadd.setBounds(130, 380, 100, 20);
		btn_orderupdate.setBounds(240, 380, 100, 20);
		btn_orderdelte.setBounds(350, 380, 100, 20);

		btn_orderadd.addActionListener(this);
		btn_orderupdate.addActionListener(this);
		btn_orderdelte.addActionListener(this);
		cmb_searchorder.addActionListener(this);
		order_retive(cmb_searchorder);
		String retrive = (String) cmb_searchorder.getSelectedItem();
		search_order(retrive);

		pan_order2.add(lbl_ordersearch);
		pan_order2.add(cmb_searchorder);
		pan_order2.add(btn_orderadd);
		pan_order2.add(btn_orderupdate);
		pan_order2.add(btn_orderdelte);

		pan_order2.add(lbl_orderID);
		pan_order2.add(lbl_ordername);
		pan_order2.add(lbl_ordernic);
		pan_order2.add(lbl_ordercontact);
		pan_order2.add(lbl_quantity);
		pan_order2.add(lbl_amo);

		pan_order2.add(txt_orderID);
		pan_order2.add(txt_ordername);
		pan_order2.add(txt_orderphone);
		pan_order2.add(txt_ordercontact);
		pan_order2.add(txt_quantity);
		pan_order2.add(txt_amo);
		van_cmb(cmb_vanid);
		pan_details.add(pan_order2);
		pan_details.add(pan_order1);
		pan_details.add(pan_vanright);
		cmb_vanid.addActionListener(this);
		String action = (String) cmb_vanid.getSelectedItem();
		this.add(pan);
		this.setLocation(screenheith / 7, screedwidth / 27);
		adduser();
		retrive_userlogin(cmb_id);
		fill_form(cat_empName);

		settings.Numvalidator(txt_nic);
		settings.Numvalidator(txt_contact);
		settings.Numvalidator1(txt_username);
		settings.Numvalidator1(txt_firstName);
		settings.Numvalidator1(txt_lastName);
		settings.Numvalidator(txt_contact1);
		settings.Numvalidator(txt_old);
		settings.Numvalidator(txt_password1);
		settings.Numvalidator(txt_nic1);
		settings.Numvalidator1(txt_lastName1);
		settings.Numvalidator1(txt_username1);
		settings.Numvalidator1(txt_firstName1);
		settings.Numvalidator(txt_vanid);
		settings.Numvalidator(txt_amount);
		settings.Numvalidator(txt_orderID);
		settings.Numvalidator(txt_orderphone);
		settings.Numvalidator(txt_quantity);
		settings.Numvalidator(txt_NIC);
		settings.Numvalidator(txt_contackID);
		settings.Numvalidator(txt_contactno);
		settings.Numvalidator(txt_amo);
		settings.Numvalidator1(txt_name);
		this.setVisible(true);

	}

	public Connection getConnection() {
		try {
			conn = connect.setConnection(conn);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void executeSQlQuery_CustoemerDetails(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {
				cmb_vanid.removeAllItems();
				cmb_searchemp.removeAllItems();
				cmb_searchorder.removeAllItems();
				cmb_id.removeAllItems();
				van_cmb_otheronwer(cmb_searchemp);
				van_cmb(cmb_vanid);
				order_retive(cmb_searchorder);
				retrive_userlogin(cmb_id);
				resetText();
				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");

			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source.equals(btn_newuser)) {
			adduser();
		} else if (source.equals(btn_updateuser)) {
			updateuser();
		} else if (source.equals(btn_vandetails)) {
			vandetails();

		} else if (source.equals(btn_emergency)) {
			emergency_service();
		} else if (source.equals(btn_mainmenu)) {
			dispose();
			this.setVisible(false);

		} else if (source.equals(btn_confirt)) {
			confirm_button();

		} else if (source.equals(cmb_id)) {
			String cat_empthirdName = (String) cmb_id.getSelectedItem();
			fill_form(cat_empthirdName);
		} else if (source.equals(cmb_vanid)) {
			String cat_empthirdName = (String) cmb_vanid.getSelectedItem();
			action_van(cat_empthirdName);

		} else if (source.equals(btn_update)) {

			update_userlog();

		} else if (source.equals(btn_vanadd)) {
			add_record();

		} else if (source.equals(btn_vandelete)) {
			vanid = "";
			vanid = txt_vanid.getText().trim();
			String query = "DELETE FROM `vandetails` WHERE van_id = " + vanid;
			executeSQlQuery_CustoemerDetails(query, "Deleted van");

		} else if (source.equals(btn_empupdate)) {
			update_otheronwerinfo();

		} else if (source.equals(btn_empdelete)) {
			contact_id = "";
			contact_id = txt_contackID.getText().trim();
			String query = "DELETE FROM `emergency_contact` WHERE onwercontactID = " + contact_id;
			executeSQlQuery_CustoemerDetails(query, "Deleted Onwer");

		} else if (source.equals(btn_empadd)) {

			Otheowner_info_add();
		} else if (source.equals(cmb_searchemp)) {
			String cat_empthirdName = (String) cmb_searchemp.getSelectedItem();
			action_othe_onwer(cat_empthirdName);

		} else if (source.equals(btn_orderadd)) {
			orderform_onweradd();
		} else if (source.equals(btn_orderupdate)) {
			update_onwer();
		} else if (source.equals(btn_orderdelte)) {
			order_id = "";
			order_id = txt_orderID.getText().trim();
			String query = "DELETE FROM `emergency_order` WHERE emergencyorder_id = " + order_id;
			executeSQlQuery_CustoemerDetails(query, "Deleted order");

		} else if (source.equals(cmb_searchorder)) {

			String cat_empthirdName = (String) cmb_searchorder.getSelectedItem();
			search_order(cat_empthirdName);

		} else if (source.equals(btn_clear)) {
			resetText();

		} else if (source.equals(btncheck)) {
			seepassword();

		} else if (source.equals(btn_confirmimage)) {
			load_image();

		}

	}

	public void load_image() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
		fileChooser.addChoosableFileFilter(filter);
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			lbl_imageuser.setIcon(ResizeImage(path));
			img_path = path;
		} else if (result == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "No Data Found");
		}

	}

	public void update_userlog() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		firstname = "";
		lastname = "";
		nic = "";
		email = "";
		contactno = "";
		logintype = "";
		username = "";
		password = "";
		submitdate = "";
		old_password = "";
		new_password = "";
		firstname = txt_firstName1.getText().trim();
		lastname = txt_lastName1.getText().trim();
		nic = txt_nic1.getText().trim();
		email = txt_Email1.getText().trim();
		contactno = txt_contact1.getText().trim();
		logintype = txt_logintype1.getSelectedItem().toString();
		username = txt_username1.getText().trim();
		password = txt_password1.getPassword().toString();
		// old_password = txt_old.getText().trim();
		new_password = txt_old.getPassword().toString();
		Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
		Matcher mat = pattern.matcher(email);

		if (date.getDate() == null) {
			JOptionPane.showMessageDialog(null, "The Date Field Must Not Empty!!");

		} else if (firstname.equals("") || lastname.equals("") || nic.equals("") || email.equals("")
				|| contactno.equals("") || logintype.equals("") || username.equals("") || password.equals("")
				|| submitdate.equals("") || new_password.equals("")) {

			JOptionPane.showMessageDialog(null, "The Record Field Must Not Empty!!", "Error empty field",
					JOptionPane.ERROR_MESSAGE);

		} else if (txt_nic1.getText().length() < 9) {

			JOptionPane.showMessageDialog(null, "NIC is not valid !!", "Error NIC", JOptionPane.ERROR_MESSAGE);

		} else if (txt_contact1.getText().length() == 11) {

			JOptionPane.showMessageDialog(null, "Contact Number is not valid!!", "Error ContactNumber",
					JOptionPane.ERROR_MESSAGE);

		} else if (txt_username1.getText().length() < 3) {

			JOptionPane.showMessageDialog(null, "At least 3 character is allow!!", "Eorror Username",
					JOptionPane.ERROR_MESSAGE);

		} else if (!mat.matches()) {

			JOptionPane.showMessageDialog(null, "Email Address Not Correct", "Eorror Email", JOptionPane.ERROR_MESSAGE);

		} else {
			submitdate = dateFormat.format(date.getDate());

			String temp = "UPDATE userinfo SET " + "user_firstname = '" + firstname + "',user_lastname = '" + lastname
					+ "',user_nic = '" + nic + "',user_email = '" + email + "',user_contactno = '" + contactno
					+ "',userlogintype = '" + logintype + "',user_username = '" + username + "',user_password = '"
					+ new_password + "',user_date = '" + submitdate + "'" + "WHERE user_email = '" + email + "'";
			executeSQlQuery_CustoemerDetails(temp, "Updated");
		}
	}

	public void confirm_button() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		firstname = "";
		lastname = "";
		nic = "";
		email = "";
		contactno = "";
		logintype = "";
		username = "";
		password = "";
		submitdate = "";

		firstname = txt_firstName.getText().trim();
		lastname = txt_lastName.getText().trim();
		nic = txt_nic.getText().trim();
		email = txt_Email.getText().trim();
		contactno = txt_contact.getText().trim();
		logintype = txt_logintype.getSelectedItem().toString();
		username = txt_username.getText().trim();
		password = txt_password.getText().trim();

		Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
		Matcher mat = pattern.matcher(email);

		if (date.getDate() == null) {
			JOptionPane.showMessageDialog(null, "The Date Field Must Not Empty!!");

		} else {

			submitdate = dateFormat.format(date.getDate());
		}
		if (firstname.equals("") || lastname.equals("") || nic.equals("") || email.equals("") || contactno.equals("")
				|| logintype.equals("") || username.equals("") || password.equals("") || submitdate.equals("")) {

			JOptionPane.showMessageDialog(null, "The Record Field Must Not Empty!!", "Error empty field",
					JOptionPane.ERROR_MESSAGE);

		} else if (txt_nic.getText().length() < 9) {

			JOptionPane.showMessageDialog(null, "NIC is not valid !!", "Error NIC", JOptionPane.ERROR_MESSAGE);

		} else if (txt_contact.getText().length() < 10) {

			JOptionPane.showMessageDialog(null, "Contact Number is not valid!!", "Error ContactNumber",
					JOptionPane.ERROR_MESSAGE);

		} else if (txt_username.getText().length() < 3) {

			JOptionPane.showMessageDialog(null, "At least 3 character is allow!!", "Eorror Username",
					JOptionPane.ERROR_MESSAGE);

		} else if (!mat.matches()) {

			JOptionPane.showMessageDialog(null, "Email Address Not Correct", "Eorror Email", JOptionPane.ERROR_MESSAGE);

		} else {
			try {
				conn = connect.setConnection(conn);
			} catch (Exception t) {
				JOptionPane.showMessageDialog(null, "Database not connected", "WARNING!!!",
						JOptionPane.INFORMATION_MESSAGE);
			}
			try {
				Statement stmt = conn.createStatement();
				PreparedStatement myStmt = conn.prepareStatement("insert into userinfo"
						+ " (user_firstname, user_lastname, user_nic, user_email,user_contactno,userlogintype,user_username,user_password,user_date,image)"
						+ " values (?, ?, ?, ?, ?, ?,? , ?, ?, ?)");

				InputStream img = new FileInputStream(new File(img_path));
				myStmt.setString(1, txt_firstName.getText());
				myStmt.setString(2, txt_lastName.getText());
				myStmt.setString(3, txt_nic.getText());
				myStmt.setString(4, txt_Email.getText());
				myStmt.setString(5, txt_contact.getText());
				myStmt.setString(6, txt_logintype.getSelectedItem().toString());
				myStmt.setString(7, txt_username.getText());
				myStmt.setString(8, txt_password.getText());
				myStmt.setString(9, submitdate);
				myStmt.setBlob(10, img);
				int i = myStmt.executeUpdate();
				if (i == 1) {
					JOptionPane.showMessageDialog(null, "Added New Position!!!");
					resetText();
				} else {
					JOptionPane.showMessageDialog(null, "Something wrong!!!", "Error Add position",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString());

			}

		}
	}

	public void add_record() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {
			vanid = "";
			vandes = "";
			vanfrom = "";
			vanamount = "";
			vandate = "";
			record = record + 1;
			vanid = "" + record;
			vandes = txt_description.getText().trim();
			vanfrom = txt_frome.getText().trim();
			vanamount = txt_amount.getText().trim();

			if (date.getDate() == null) {
				JOptionPane.showMessageDialog(null, "The Date Field Must Not Empty!!");

			} else {

				vandate = dateFormat.format(date.getDate());
			}

			if (!vandes.equals("") && !vanfrom.equals("") && !vanamount.equals("") && !vandate.equals("")) {

				Statement stmt = conn.createStatement();

				String query = "SELECT * FROM vandetails WHERE van_id='" + vanid + "'";

				ResultSet rs = stmt.executeQuery(query);
				int foundrec = 0;
				while (rs.next()) {

					dialogmessage = "Record Already Exists in DataBase!!!";
					dialogtype = JOptionPane.WARNING_MESSAGE;
					JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);

					foundrec = 1;

				}
				if (foundrec == 0) {

					String temp = "INSERT INTO vandetails VALUES ('" + vanid + "','" + vandes + "','" + vanfrom + "','"
							+ vanamount + "','" + vandate + "')";
					//

					int result = stmt.executeUpdate(temp);
					if (result == 1) {
						dialogmessage = "New Position Added";
						dialogtype = JOptionPane.INFORMATION_MESSAGE;
						JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);
						cmb_vanid.addItem(vanid);
						resetText();

					} else {
						dialogmessage = "Failed To Insert";
						JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!", JOptionPane.WARNING_MESSAGE);

					}
				}

			} else {
				dialogmessage = "EMPTY VALUE FOUND";
				JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!", JOptionPane.WARNING_MESSAGE);

			}
			conn.close();
		}

		catch (Exception ex) {
			System.out.println("Unknown Error" + ex);

		}

	}

	public void Otheowner_info_add() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {
			contact_id = "";
			contact_name = "";
			contact_nic = "";
			contact_phone = "";
			contact_email = "";
			contact_location = "";
			contact_stock = "";
			contact_date = "";
			record1 = record1 + 1;
			contact_id = "" + record1;
			contact_name = txt_name.getText().toString();
			contact_nic = txt_NIC.getText().toString();
			contact_phone = txt_contactno.getText().toString();
			contact_email = txt_email.getText().toString();
			contact_location = txt_location.getText().toString();
			contact_stock = txt_stock.getText().toString();

			Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
			Matcher mat = pattern.matcher(contact_email);

			if (!mat.matches()) {
				JOptionPane.showMessageDialog(null, "Email is not correct!!!");

			} else if (date.getDate() == null) {
				JOptionPane.showMessageDialog(null, "The Date Field Must Not Empty!!");
			} else {
				contact_date = dateFormat.format(date.getDate());
			}

			if (!contact_name.equals("") && !contact_nic.equals("") && !contact_phone.equals("")
					&& !contact_email.equals("") && !contact_location.equals("") && !contact_stock.equals("")
					&& !contact_date.equals("")) {

				Statement stmt = conn.createStatement();

				String query = "SELECT * FROM emergency_contact WHERE onwer_email='" + contact_email + "'";

				ResultSet rs = stmt.executeQuery(query);
				int foundrec = 0;
				while (rs.next()) {

					dialogmessage = "Record Already Exists in DataBase!!!";
					dialogtype = JOptionPane.WARNING_MESSAGE;
					JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);

					foundrec = 1;

				}
				if (foundrec == 0) {

					String temp = "INSERT INTO emergency_contact VALUES ('" + contact_id + "','" + contact_name + "','"
							+ contact_nic + "','" + contact_phone + "','" + contact_email + "','" + contact_location
							+ "','" + contact_stock + "','" + contact_date + "')";
					//

					int result = stmt.executeUpdate(temp);
					if (result == 1) {
						dialogmessage = "New Position Added";
						dialogtype = JOptionPane.INFORMATION_MESSAGE;
						JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);
						cmb_searchemp.addItem(contact_id);

						resetText();

					} else {
						dialogmessage = "Failed To Insert";
						JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!", JOptionPane.WARNING_MESSAGE);

					}

				} else {
					dialogmessage = "EMPTY VALUE FOUND";
					JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!", JOptionPane.WARNING_MESSAGE);

				}

				conn.close();
			}
		} catch (Exception ex) {
			System.out.println("Unknown Error" + ex);

		}
	}

	public void orderform_onweradd() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {
			order_id = "";
			order_productname = "";
			order_quantity = "";
			order_totalamont = "";
			contact_name = "";
			contact_phone = "";
			order_date = "";
			record2 = record2 + 1;
			order_id = "" + record2;
			contact_name = txt_ordername.getText().toString();
			contact_phone = txt_orderphone.getText().toString();
			order_productname = txt_ordercontact.getText().toString();
			order_quantity = txt_quantity.getText().toString();
			order_totalamont = txt_amo.getText().toString();

			if (date.getDate() == null) {

				JOptionPane.showMessageDialog(null, "The Date Field Must Not Empty!!");

			} else {

				order_date = dateFormat.format(date.getDate());
			}

			if (!contact_name.equals("") && !contact_phone.equals("") && !order_productname.equals("")
					&& !order_quantity.equals("") && !order_totalamont.equals("") && !order_date.equals("")) {

				Statement stmt = conn.createStatement();

				String query = "SELECT * FROM emergency_order WHERE order_phone='" + contact_phone + "'";

				ResultSet rs = stmt.executeQuery(query);
				int foundrec = 0;
				while (rs.next()) {

					dialogmessage = "Record Already Exists in DataBase!!!";
					dialogtype = JOptionPane.WARNING_MESSAGE;
					JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);

					foundrec = 1;

				}
				if (foundrec == 0) {

					String temp = "INSERT INTO emergency_order VALUES ('" + order_id + "','" + contact_name + "','"
							+ contact_phone + "','" + order_productname + "','" + order_quantity + "','"
							+ order_totalamont + "','" + order_date + "')";
					//

					int result = stmt.executeUpdate(temp);
					if (result == 1) {
						dialogmessage = "New Position Added";
						dialogtype = JOptionPane.INFORMATION_MESSAGE;
						JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);

						cmb_searchorder.addItem(order_id);

						resetText();

					} else {
						dialogmessage = "Failed To Insert";
						JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!", JOptionPane.WARNING_MESSAGE);

					}

				} else {
					dialogmessage = "EMPTY VALUE FOUND";
					JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!", JOptionPane.WARNING_MESSAGE);

				}

				conn.close();
			}
		} catch (Exception ex) {
			System.out.println("Unknown Error" + ex);

		}
	}

	public void update_onwer() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		order_id = "";
		order_productname = "";
		order_quantity = "";
		order_totalamont = "";
		contact_name = "";
		contact_phone = "";
		order_date = "";

		order_id = txt_orderID.getText().toString();
		contact_name = txt_ordername.getText().toString();
		contact_phone = txt_orderphone.getText().toString();
		order_productname = txt_ordercontact.getText().toString();
		order_quantity = txt_quantity.getText().toString();
		order_totalamont = txt_amo.getText().toString();

		if (date.getDate() == null) {
			JOptionPane.showMessageDialog(null, "The Date Field Must Not Empty!!");

		} else {

			order_date = dateFormat.format(date.getDate());
		}

		String temp = "UPDATE emergency_order SET " + "emergencyorder_id = '" + order_id + "',order_name = '"
				+ contact_name + "',order_phone = '" + contact_phone + "',order_product = '" + order_productname
				+ "',order_quantity = '" + order_quantity + "',order_amount = '" + order_totalamont + "',order_date = '"
				+ order_date + "'" + "WHERE emergencyorder_id = '" + order_id + "'";
		executeSQlQuery_CustoemerDetails(temp, "Updated");

	}

	public void update_otheronwerinfo() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		contact_id = "";
		contact_name = "";
		contact_nic = "";
		contact_phone = "";
		contact_email = "";
		contact_location = "";
		contact_stock = "";
		contact_date = "";
		contact_id = txt_contackID.getText().toString();
		contact_name = txt_name.getText().toString();
		contact_nic = txt_NIC.getText().toString();
		contact_phone = txt_contactno.getText().toString();
		contact_email = txt_email.getText().toString();
		contact_location = txt_location.getText().toString();
		contact_stock = txt_stock.getText().toString();

		if (date.getDate() == null) {
			JOptionPane.showMessageDialog(null, "The Date Field Must Not Empty!!");

		} else {

			contact_date = dateFormat.format(date.getDate());
		}

		String temp = "UPDATE emergency_contact SET " + "onwercontactID = '" + contact_id + "',onwer_name = '"
				+ contact_name + "',onwer_nic = '" + contact_nic + "',onwer_contact = '" + contact_phone
				+ "',onwer_email = '" + contact_email + "',onwer_location = '" + contact_location + "',onwder_stock = '"
				+ contact_stock + "',onwer_date = '" + contact_date + "'" + "WHERE onwercontactID = '" + contact_id
				+ "'";
		executeSQlQuery_CustoemerDetails(temp, "Updated");

	}

	public void adduser() {
		lbl_message.setVisible(true);
		btncheck.setVisible(false);
		pan_details.setVisible(true);
		pan_left.setVisible(true);
		pan_right.setVisible(true);
		btn_confirt.setVisible(true);
		btn_update.setVisible(false);
		cmb_id.setVisible(false);
		lbl_id.setVisible(false);
		lbl_old.setVisible(false);
		lbl_new.setVisible(false);
		txt_old.setVisible(false);
		txt_new.setVisible(false);
		lbl_messagenew.setVisible(false);
		pan_vanleft.setVisible(false);
		pan_vanright.setVisible(false);
		pan_order1.setVisible(false);
		pan_order2.setVisible(false);

		txt_firstName.setVisible(true);
		txt_lastName.setVisible(true);
		txt_nic.setVisible(true);
		txt_Email.setVisible(true);
		txt_contact.setVisible(true);
		txt_logintype.setVisible(true);
		txt_username.setVisible(true);
		txt_password.setVisible(true);

		txt_firstName1.setVisible(false);
		txt_lastName1.setVisible(false);
		txt_nic1.setVisible(false);
		txt_Email1.setVisible(false);
		txt_contact1.setVisible(false);
		txt_logintype1.setVisible(false);
		txt_username1.setVisible(false);
		txt_password1.setVisible(false);

	}

	public void seepassword() {
		try {
			if (btncheck.isSelected()) {
				txt_password1.setEchoChar((char) 0);
				txt_old.setEchoChar((char) 0);
			} else {
				txt_password1.setEchoChar('*');
				txt_old.setEchoChar('*');
			}
		} catch (Exception ex4) {
			JOptionPane.showMessageDialog(null, "Not work seepasswordmethod", "WARNING!!!",
					JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public void updateuser() {
		lbl_message.setVisible(false);
		btncheck.setVisible(true);
		pan_left.setVisible(true);
		pan_right.setVisible(true);
		btn_confirt.setVisible(false);
		btn_update.setVisible(true);

		cmb_id.setVisible(true);
		lbl_id.setVisible(true);
		lbl_old.setVisible(true);
		lbl_new.setVisible(true);
		txt_old.setVisible(true);
		txt_new.setVisible(true);

		lbl_messagenew.setVisible(true);
		pan_vanleft.setVisible(false);
		pan_vanright.setVisible(false);
		pan_order1.setVisible(false);
		pan_order2.setVisible(false);

		txt_firstName.setVisible(false);
		txt_lastName.setVisible(false);
		txt_nic.setVisible(false);
		txt_Email.setVisible(false);
		txt_contact.setVisible(false);
		txt_logintype.setVisible(false);
		txt_username.setVisible(false);
		txt_password.setVisible(false);

		txt_firstName1.setVisible(true);
		txt_lastName1.setVisible(true);
		txt_nic1.setVisible(true);
		txt_Email1.setVisible(true);
		txt_contact1.setVisible(true);
		txt_logintype1.setVisible(true);
		txt_username1.setVisible(true);
		txt_password1.setVisible(true);
	}

	public void vandetails() {
		btncheck.setVisible(false);
		pan_order1.setVisible(false);
		pan_order2.setVisible(false);
		pan_vanleft.setVisible(true);
		pan_vanright.setVisible(true);
		lbl_vanid.setVisible(true);
		lbl_description.setVisible(true);
		lbl_amount.setVisible(true);
		lbl_searchbyvanid.setVisible(true);
		cmb_vanid.setVisible(true);
		btn_vanadd.setVisible(true);
		btn_vandelete.setVisible(true);
		//
		pan_left.setVisible(false);
		pan_right.setVisible(false);
		btn_update.setVisible(false);

		cmb_id.setVisible(false);
		lbl_id.setVisible(false);
		lbl_old.setVisible(false);
		lbl_new.setVisible(false);
		txt_old.setVisible(false);
		txt_new.setVisible(false);
		lbl_messagenew.setVisible(false);
		// update
		btn_update.setVisible(false);

	}

	public void emergency_service() {
		pan_left.setVisible(false);
		pan_right.setVisible(false);
		pan_vanleft.setVisible(false);
		pan_vanright.setVisible(false);
		cmb_id.setVisible(false);
		lbl_id.setVisible(false);
		pan_order1.setVisible(true);
		pan_order2.setVisible(true);
		pan_order3.setVisible(true);// no use

	}

	public void resetText() {
		txt_username.setText("");
		txt_password.setText("");
		date.setDate(null);
		txt_firstName.setText("");
		txt_lastName.setText("");
		txt_nic.setText("");
		txt_Email.setText("");
		txt_contact.setText("");
		txt_logintype.setSelectedItem("");
		cmb_id.setSelectedItem("");
		txt_old.setText("");
		txt_new.setText("");
		txt_frome.setText("");
		txt_vanid.setText("");
		txt_description.setText("");
		txt_amount.setText("");
		cmb_vanid.setSelectedItem("");
		txt_contackID.setText("");
		txt_name.setText("");
		txt_NIC.setText("");
		txt_contactno.setText("");
		txt_email.setText("");
		txt_location.setText("");
		txt_stock.setText("");
		txt_orderID.setText("");
		txt_ordername.setText("");
		txt_orderphone.setText("");
		txt_ordercontact.setText("");

		txt_quantity.setText("");
		txt_amo.setText("");
		lbl_message.setText("");
		txt_firstName.setText("");
		txt_lastName.setText("");
		txt_nic.setText("");
		txt_Email.setText("");
		txt_contact.setText("");
		txt_logintype.setSelectedItem(null);
		txt_username.setText("");
		txt_password.setText("");
		txt_old.setText("");
		txt_old.setText("");
		txt_firstName1.setText("");
		lbl_messagenew.setText("");
		txt_lastName1.setText("");
		txt_nic1.setText("");
		txt_Email1.setText("");
		txt_contact1.setText("");
		txt_logintype1.setSelectedItem(null);
		txt_username1.setText("");
		txt_password1.setText("");

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent event) {
		if (txt_password.getText().length() < 3) {
			lbl_message.setText("Easy To Guse!!");
			lbl_message.setForeground(Color.CYAN);
		} else if (txt_password.getText().length() <= 4) {
			lbl_message.setText("Not Strong!!");
			lbl_message.setForeground(Color.PINK);
		} else if (txt_password.getText().length() >= 8) {
			lbl_message.setText("Strong!!");
			lbl_message.setForeground(Color.GREEN);

		}
		if (txt_new.getPassword().length < 3) {
			lbl_messagenew.setText("Easy To Guse!!");
			lbl_messagenew.setForeground(Color.CYAN);
		} else if (txt_new.getPassword().length <= 5) {
			lbl_messagenew.setText("Not Strong!!");
			lbl_messagenew.setForeground(Color.PINK);
		} else if (txt_new.getPassword().length >= 8) {
			lbl_messagenew.setText("Strong!!");
			lbl_messagenew.setForeground(Color.GREEN);

		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void retrive_userlogin(JComboBox cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM userinfo";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String txt_catagoryname = rs.getString(4).trim();
				cmb.addItem(txt_catagoryname);
			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void fill_form(String name) {

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {

			Statement stmt = conn.createStatement();

			String query = "SELECT * FROM userinfo WHERE user_email='" + name + "'";

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				byte[] img = rs.getBytes("image");
				ImageIcon image = new ImageIcon(img);
				Image im = image.getImage();
				Image myimg = im.getScaledInstance(lbl_imageuser.getWidth(), lbl_imageuser.getHeight(),
						Image.SCALE_AREA_AVERAGING);
				ImageIcon newImage = new ImageIcon(myimg);
				firstname = "";
				lastname = "";
				nic = "";
				email = "";
				contactno = "";
				logintype = "";
				username = "";
				password = "";
				submitdate = "";

				String oldpassword = "";
				firstname += rs.getString(1).trim();
				lastname = rs.getString(2).trim();
				nic = rs.getString(3).trim();
				email = rs.getString(4).trim();
				contactno = rs.getString(5).trim();
				logintype = rs.getString(6).trim();
				username = rs.getString(7).trim();
				password = rs.getString(8).trim();
				submitdate = rs.getString(9).trim();
				oldpassword = rs.getString(8).trim();

				txt_firstName1.setText(firstname);
				txt_lastName1.setText(lastname);
				txt_nic1.setText(nic);
				txt_Email1.setText(email);
				txt_contact1.setText(contactno);
				txt_logintype1.setSelectedItem(logintype);
				txt_username1.setText(username);
				txt_password1.setText(password);
				txt_old.setText(oldpassword);

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date addDate = new Date();
				try {
					addDate = dateFormat.parse(submitdate);
					date.setDate(addDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				lbl_imageuser.setIcon(newImage);

				rs = null;

			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void van_cmb(JComboBox<Object> cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM vandetails";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String txt_catagoryname = rs.getString(1).trim();
				cmb.addItem(txt_catagoryname);
			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void action_van(String name) {

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {

			Statement stmt = conn.createStatement();

			String query = "SELECT * FROM vandetails WHERE van_id='" + name + "'";

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				vanid = "";
				vandes = "";
				vanfrom = "";
				vanamount = "";
				vandate = "";
				vanid += rs.getString(1).trim();
				vandes = rs.getString(2).trim();
				vanfrom = rs.getString(3).trim();
				vanamount = rs.getString(4).trim();
				vandate = rs.getString(5).trim();
				txt_vanid.setText(vanid);
				txt_description.setText(vandes);
				txt_frome.setText(vanfrom);
				txt_amount.setText(vanamount);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date addDate = new Date();
				try {
					addDate = dateFormat.parse(vandate);
					date.setDate(addDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				rs = null;

			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void van_cmb_otheronwer(JComboBox cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM emergency_contact";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String txt_catagoryname = rs.getString(1).trim();
				cmb.addItem(txt_catagoryname);
			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void action_othe_onwer(String name) {

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {

			Statement stmt = conn.createStatement();

			String query = "SELECT * FROM emergency_contact WHERE onwercontactID='" + name + "'";

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				contact_id = "";
				contact_name = "";
				contact_nic = "";
				contact_phone = "";
				contact_email = "";
				contact_location = "";
				contact_stock = "";
				contact_date = "";
				contact_id += rs.getString(1).trim();
				contact_name = rs.getString(2).trim();
				contact_nic = rs.getString(3).trim();
				contact_phone = rs.getString(4).trim();
				contact_email = rs.getString(5).trim();
				contact_location = rs.getString(6).trim();
				contact_stock = rs.getString(7).trim();
				contact_date = rs.getString(8).trim();
				txt_contackID.setText(contact_id);
				txt_name.setText(contact_name);
				txt_NIC.setText(contact_nic);
				txt_contactno.setText(contact_phone);
				txt_email.setText(contact_email);
				txt_location.setText(contact_location);
				txt_stock.setText(contact_stock);
				txt_ordername.setText(contact_name);

				txt_orderphone.setText(contact_phone);

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date addDate = new Date();
				try {
					addDate = dateFormat.parse(contact_date);
					date.setDate(addDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				rs = null;

			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void order_retive(JComboBox cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM emergency_order";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String txt_catagoryname = rs.getString(1).trim();
				cmb.addItem(txt_catagoryname);
			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void search_order(String name) {

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {

			Statement stmt = conn.createStatement();

			String query = "SELECT * FROM emergency_order WHERE emergencyorder_id='" + name + "'";

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				order_id = "";
				order_productname = "";
				order_quantity = "";
				order_totalamont = "";
				contact_name = "";
				contact_phone = "";
				order_date = "";

				order_id = rs.getString(1).trim();
				contact_name = rs.getString(2).trim();
				contact_phone = rs.getString(3).trim();
				order_productname = rs.getString(4).trim();
				order_quantity = rs.getString(5).trim();
				order_totalamont = rs.getString(6).trim();
				order_date = rs.getString(7).trim();

				txt_orderID.setText(order_id);
				txt_ordername.setText(contact_name);
				txt_orderphone.setText(contact_phone);
				txt_ordercontact.setText(order_productname);
				txt_quantity.setText(order_quantity);
				txt_amo.setText(order_totalamont);

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date addDate = new Date();
				try {
					addDate = dateFormat.parse(order_date);
					date.setDate(addDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				rs = null;

			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public ImageIcon ResizeImage(String imgPath) {
		ImageIcon MyImage = new ImageIcon(imgPath);
		Image img = MyImage.getImage();
		Image newImage = img.getScaledInstance(lbl_imageuser.getWidth(), lbl_imageuser.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImage);
		return image;
	}

}
