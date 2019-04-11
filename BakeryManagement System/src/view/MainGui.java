package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalTheme;

import Controller.Databaseconnect;
import Model.Receivedproductinfo;
import Settings.GetColorParent;
import Settings.MetalThemeMenu;
import Settings.Theme1;
import Settings.Theme2;
import Settings.Theme3;
import Settings.Theme4;
import Settings.Theme5;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class MainGui extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int counter, mehedi, mehedi1;
	int counter_expiredate;
	Date date = new Date();
	String f = String.format("%tB %<te, %<tY", date);
	JDesktopPane desktop = new JDesktopPane();
	String sMSGBOX_TITLE = "Sweets Management System System V. 1.0";
	JPanel panel_Bottom = new JPanel();
	JPanel panel_Top = new JPanel();
	JLabel lblUsername = new JLabel("User Name:");
	JLabel lblLogDetails = new JLabel("Time Login :");
	JTextField username = new JTextField();
	JTextField logtime = new JTextField();
	Connection conn;
	static Date td = new Date();
	static Statement stmtLogin;
	static String sUser = "";
	static String sLogin = DateFormat.getDateTimeInstance().format(td);
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	Dimension screen_slash = Toolkit.getDefaultToolkit().getScreenSize();

	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	SettingManu settings = new SettingManu();
	JMenuBar menubar = new JMenuBar();
	JMenu menuFile = new JMenu("File");
	JMenu menuEmployee = new JMenu("Employee");
	JMenu menuCustomer = new JMenu("Customer");
	JMenu menuOrder = new JMenu("Order");// new feature
	JMenu menuProduct = new JMenu("Product");
	JMenu menuSetting = new JMenu("Settings");
	JMenu menu_windowsettins = new JMenu("Windows");

	JMenu menuTools = new JMenu("Tools");
	JMenu menuReports = new JMenu("Reports");
	JMenu menuHelp = new JMenu("Help");
	JButton btn_left = new JButton(new ImageIcon("images/urmi.png"));
	JButton btn_right = new JButton(new ImageIcon("images/urmi2.png"));

	JPanel pan_right = new JPanel();
	JPanel next_panel = new JPanel();

	// Menu Item
	JMenuItem itemExit = new JMenuItem();
	JMenuItem itemEdit = new JMenuItem();
	JMenuItem itemAddC = new JMenuItem();
	JMenuItem itemEditC = new JMenuItem();

	JMenuItem itemempattendence = new JMenuItem();// employee attendence
	JMenuItem itemSettings = new JMenuItem();
	JMenuItem itemCalculator = new JMenuItem();
	JMenuItem itemNotePad = new JMenuItem();
	JMenuItem itemAuthor = new JMenuItem();
	JMenuItem itemHelp = new JMenuItem();
	// JMenuItem for the order prduct
	JMenuItem itemCustomerOrder = new JMenuItem();

	// product
	JMenuItem itemAddproduct = new JMenuItem();

	// setting
	JMenuItem itemSallarySettings = new JMenuItem();
	JMenuItem itemReport = new JMenuItem();

	// Report
	JMenuItem itemMonthly = new JMenuItem();
	JMenuItem itemYearly = new JMenuItem();
	JMenuItem itemEmprpt = new JMenuItem();

	// Decler teh class variable
	//
	JMenuItem item_backgroundcolor = new JMenuItem();
	JMenuItem item_theme = new JMenuItem();
	JMenuItem item_closeallwindow = new JMenuItem();
	JMenuItem item_trackuser = new JMenuItem();
	JMenuItem item_addfile = new JMenuItem();
	JMenuItem item_stocknotification = new JMenuItem();
	JMenuItem item_attendencsetting = new JMenuItem();

	//

	Editemployee editemployee;
	SearchEmployee searchemployee;
	SettingEmployee settingemployee;
	CustomerDetails customerdetails;
	DeleteCustomer deletecustomer;
	loginframe login;
	UserDetails user_details;
	SearchCustomer search_Customer;
	EditUser editprofile;
	Attendence attendence;
	ReportSallary sallary_Report;
	productDetails productstock;
	MonthlyReport monthlyreport;
	yearly_report year_report;
	CustomerOrder order;
	SettingRepor settingreport;
	GraphReports graphreports;
	MonthGraphReport monthgraph;
	FileSearch filesearch;
	SendingMail sendemail;
	TrakingView tackingview;
	DatabaseBackup databasebackup;
	AttandenceSetting attendencesetting;

	// new features

	JPanel pan_golam = new JPanel();
	Timer tm1, tm2;
	Timer first, second, third, forth, time_5, time_6, time_7, time_8;
	Timer second_last, first_last;

	// new featues

	JButton btn_close = new JButton(new ImageIcon("images/exit.png"));
	// side menue
	JButton btn_profile = new JButton("Account");
	JButton btn_email = new JButton("Email");
	JButton btn_backup = new JButton("BackUp");
	JButton btn_exit_all = new JButton("Exit");
	JButton btn_logout_all = new JButton("Log out");
	// sidemenue
	String description = " Database backup is the process of backing " + "\n"
			+ " up the operational state, architecture and " + "\n" + " stored data of database software. It enables "
			+ "\n" + " the creation of a duplicate instance or  " + "\n" + " copy of a database in case the primary "
			+ "\n" + " database crashes, is corrupted or is lost" + "\n" + "\n" + "\n" + "\n"
			+ " Do you want to Back_up your Database???";
	String description1 = " This option Will be used for " + "\n" + " order other bakery onwer for emergency" + "\n"
			+ " service" + "\n" + " Do you want to Email other onwer???";

	//
	JButton btn_minimize = new JButton(new ImageIcon("images/can.png"));
	JButton btn_minimize1 = new JButton(new ImageIcon("images/can.png"));
	JButton btn_minimize2 = new JButton(new ImageIcon("images/can.png"));
	JButton btn_minimize3 = new JButton(new ImageIcon("images/can.png"));
	//

	JPanel pan_left = new JPanel();
	JTextField username_user = new JTextField();
	//
	JButton btn_profile_pic = new JButton("Profile");
	Databaseconnect connect = new Databaseconnect();
	//
	String fullname, fullimage;

	//

	JLabel lbl_image1 = new JLabel(new ImageIcon("images/man.png"));
	JTextField lbl_uername = new JTextField("MD. ");
	Border thick_sager_Border = new LineBorder(Color.white, 7);

	// desing whith panel show main gui

	String stocknotification = "<html><u>Stock Notification</u></html>";
	String stockexpiredate = "<html><u>Stock ExpireDate</u></html>";
	String calender = "<html><u>View Calender</u></html>";

	JButton btn_show1 = new JButton(new ImageIcon("images/barchart.png"));
	JButton btn_second = new JButton(new ImageIcon("images/file.png"));
	JButton btn_thired = new JButton(new ImageIcon("images/file.png"));
	JButton btn_fourth = new JButton(new ImageIcon("images/file.png"));
	JButton btn_fifth = new JButton(new ImageIcon("images/file.png"));
	JButton btn_six = new JButton(new ImageIcon("images/file.png"));

	JLabel lbl_title = new JLabel(new ImageIcon("images/title.png"));
	JLabel lbl_notification = new JLabel(stocknotification);

	JLabel lbl_expiredate = new JLabel(stockexpiredate);
	JLabel lbl_expiredatenum = new JLabel("num");

	JLabel lbl_numofnotifiation = new JLabel("num");
	JPanel pan_notification = new JPanel();
	JPanel pan_stock_notification = new JPanel();
	// notificaton

	JLabel lbl_comment = new JLabel("Please Check the following product");
	JLabel lbl_dangerousicon = new JLabel(new ImageIcon("images/dan.png"));
	JButton btn_showproduct = new JButton(new ImageIcon("images/left.png"));
	JButton btn_remindlater = new JButton("Ask me later");
	JLabel lbl_product = new JLabel("Product");
	JComboBox<String> cmb_productstockno = new JComboBox<String>();

	// notification
	JLabel lbl_itemname = new JLabel("Item Name");
	JLabel lbl_subitemname = new JLabel("SubItem Name");
	JLabel lbl_itemvalue = new JLabel("value");
	JLabel lbl_subitemvalue = new JLabel("value");
	JButton btn_okfornotification = new JButton("Ok");

	// new expire date is over so what

	JLabel lbl_itemname_ex = new JLabel("Item Name");
	JLabel lbl_subitemname_ex = new JLabel("SubItem Name");
	JLabel lbl_itemvalue_ex = new JLabel("value");
	JLabel lbl_subitemvalue_ex = new JLabel("value");
	JButton btn_okfornotification_ex = new JButton("Ok");

	JLabel lbl_comment_ex = new JLabel("Please Check the following product");
	JLabel lbl_dangerousicon_ex = new JLabel(new ImageIcon("images/dan.png"));
	JButton btn_showproduct_ex = new JButton(new ImageIcon("images/left.png"));
	JButton btn_remindlater_ex = new JButton("Ask me later");
	JLabel lbl_product_ex = new JLabel("Product");
	JComboBox<String> cmb_productstockno_ex = new JComboBox<String>();

	// new expire date is over so what

	JButton btn_upperkey = new JButton(new ImageIcon("images/upper.png"));
	JButton btn_downkey = new JButton(new ImageIcon("images/down.png"));

	JButton btn_yes_mail = new JButton("Yes");
	JButton btn_no_mail = new JButton("No");
	String lointype;

	//
	String firstname = "";
	String lastname = "";
	String email_e = "";
	String contactno = "";
	String username_e = "";
	String password = "";
	String image_user = "";
	//
	JButton btn_yes_backup = new JButton("Yes");
	JButton btn_no_backup = new JButton("No");
	JFrame frm;

	// Stock reminder setting

	Border thickBorder = new LineBorder(Color.WHITE, 23);
	private JButton btn_change = new JButton("Ok");
	public JTextField txt_change = new JTextField();
	private JButton btn_change1 = new JButton("Ok");
	private JTextField txt_change1 = new JTextField();
	JRadioButton btn_rnd = new JRadioButton("Default");
	JRadioButton btn_off = new JRadioButton("Off");
	JTextField txt_changeid = new JTextField();

	// stock reminder setting
	public static int record;
	Databaseconnect connect_retrive = new Databaseconnect();
	Connection conn_retrive;
	int style = Font.BOLD;
	Font font = new Font("Garamond", style, 20);

	public MainGui(String user, Date date, String logintype) {
		super("Bakery Management System");
		try {

			this.setSize(screen_slash);

			// this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width
			// - getWidth()) / 2,
			// (Toolkit.getDefaultToolkit().getScreenSize().height -
			// getHeight()) / 2);
			sUser = user;
			td = date;
			lointype = logintype;

			JTextField logtime = new JTextField();
			logtime.setEditable(false);

			logtime.setText(sLogin);

			panel_Bottom.setLayout(new FlowLayout());
			panel_Bottom.setPreferredSize(new Dimension(10, 25));
			panel_Bottom.add(lblUsername);
			panel_Bottom.add(username);
			panel_Bottom.add(lblLogDetails);
			panel_Bottom.add(logtime);
			panel_Top.setLayout(new BorderLayout());
			panel_Top.setPreferredSize(new Dimension(10, 65));
			panel_Top.add(createJToolBar(), BorderLayout.PAGE_START);
			pan_left.setBackground(Color.decode("#4D2713"));
			pan_left.setBounds(0, 0, 0, 0);

			tm1 = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (pan_left.getWidth() != 150) {

						pan_left.setBounds(0, 0, pan_left.getWidth() + 5, 600);
						if (pan_left.getWidth() == 150) {
							tm1.stop();
							// up.setEnabled(true);
							// down.setEnabled(true);
						}

					}

				}

			});

			tm2 = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//
					if (pan_left.getWidth() != 0) {
						pan_left.setBounds(0, 0, pan_left.getWidth() - 5, 600);
						if (pan_left.getWidth() == 0) {
							tm2.stop();

						}
					}

				}

			});

			Border thickBorder = new LineBorder(Color.decode("#394B58"), 12);
			btn_profile.setBorder(thickBorder);//
			btn_profile.setBounds(30, 100, 80, 80);
			btn_backup.setBounds(30, 190, 80, 80);
			btn_email.setBounds(30, 280, 80, 80);
			btn_exit_all.setBounds(30, 370, 80, 80);
			btn_logout_all.setBounds(30, 500, 80, 80);

			btn_backup.setBorder(thickBorder);
			btn_email.setBorder(thickBorder);
			btn_exit_all.setBorder(thickBorder);
			btn_logout_all.setBorder(thickBorder);

			btn_profile.setBackground(Color.decode("#250800"));
			btn_email.setBackground(Color.decode("#250800"));
			btn_backup.setBackground(Color.decode("#250800"));
			btn_exit_all.setBackground(Color.decode("#250800"));
			btn_logout_all.setBackground(Color.decode("#250800"));
			btn_left.setEnabled(false);
			btn_profile.addActionListener(this);
			btn_email.addActionListener(this);
			btn_backup.addActionListener(this);
			btn_exit_all.addActionListener(this);
			btn_logout_all.addActionListener(this);

			btn_profile.setForeground(Color.WHITE);
			btn_email.setForeground(Color.WHITE);
			btn_backup.setForeground(Color.WHITE);
			btn_exit_all.setForeground(Color.WHITE);
			btn_logout_all.setForeground(Color.WHITE);

			// notification false

			lbl_product.setVisible(false);
			lbl_itemname.setVisible(false);
			lbl_subitemname.setVisible(false);
			lbl_itemvalue.setVisible(false);

			lbl_product_ex.setVisible(false);
			lbl_itemname_ex.setVisible(false);
			lbl_subitemname_ex.setVisible(false);
			lbl_itemvalue_ex.setVisible(false);
			lbl_subitemvalue_ex.setVisible(false);
			btn_okfornotification_ex.setVisible(false);
			cmb_productstockno_ex.setVisible(false);

			btn_remindlater_ex.setBackground(Color.ORANGE);
			btn_showproduct_ex.setBackground(Color.ORANGE);

			// notification false
			//
			JPanel panimage = new JPanel();
			panimage.setBounds(0, 10, 150, 80);
			panimage.setBackground(Color.decode("#4D2713"));
			panimage.setLayout(new GridLayout(0, 1));
			JLabel lbl_image = new JLabel(new ImageIcon("images/biskut.png"));
			panimage.add(lbl_image);
			pan_left.add(panimage);
			pan_left.add(btn_backup);
			pan_left.add(btn_exit_all);
			pan_left.add(btn_logout_all);
			pan_left.add(btn_email);
			pan_left.add(btn_profile);
			pan_left.setLayout(null);

			desktop.add(pan_left);

			TitledBorder reg_Border1 = BorderFactory.createTitledBorder("");
			reg_Border1.setTitleJustification(TitledBorder.LEFT);
			pan_right.setBorder(reg_Border1);
			pan_right.setBackground(Color.red);
			pan_right.setBounds(1330, 5, 40, 40);
			desktop.add(pan_right);
			pan_right.setLayout(new GridLayout(0, 1));

			pan_right.add(btn_left);
			btn_left.setBackground(Color.decode("#394B58"));
			pan_right.setVisible(true);

			TitledBorder reg_Border2 = BorderFactory.createTitledBorder("");
			reg_Border1.setTitleJustification(TitledBorder.LEFT);
			next_panel.setBorder(reg_Border2);
			next_panel.setBackground(Color.red);
			next_panel.setBounds(1330, 5, 40, 40);

			btn_close.addActionListener(this);

			desktop.add(next_panel);
			next_panel.setLayout(new GridLayout(0, 1));
			btn_right.addActionListener(this);
			btn_left.addActionListener(this);
			next_panel.add(btn_right);
			btn_right.setBackground(Color.decode("#394B58"));
			next_panel.setVisible(false);
			desktop.setAutoscrolls(true);
			// hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh

			pan_golam.setBounds(1250, 0, 130, 100);
			pan_golam.setBackground(Color.decode("#C88E8E"));
			pan_golam.setLayout(null);
			desktop.add(pan_golam);
			pan_golam.setVisible(false);

			JPanel pan_sidebaraccount = new JPanel();
			Border thickBorder1 = new LineBorder(Color.WHITE, 12);
			pan_sidebaraccount.setBounds(0, 0, 0, 0);
			pan_sidebaraccount.setLayout(null);
			pan_sidebaraccount.setBackground(Color.decode("#F5F5DC"));
			pan_sidebaraccount.setBorder(thickBorder1);
			btn_minimize.setBounds(230, 3, 24, 24);
			btn_minimize.setBackground(Color.white);
			pan_sidebaraccount.add(btn_minimize);
			lbl_image1.setBounds(70, 60, 120, 120);

			lbl_uername.setBounds(30, 200, 200, 30);
			lbl_uername.addActionListener(this);
			lbl_uername.setBackground(Color.decode("#F5F5DC"));
			lbl_uername.setEnabled(false);
			lbl_uername.setForeground(Color.green);
			lbl_uername.setFont(font);
			lbl_uername.setText(sUser.toUpperCase());
			String sr = (String) lbl_uername.getText();
			fill_form(sr);

			lbl_uername.setFont(font);
			lbl_uername.setHorizontalAlignment(JLabel.CENTER);
			lbl_uername.setBorder(BorderFactory.createLineBorder(Color.black));
			btn_profile_pic.setBounds(30, 260, 90, 20);
			btn_profile_pic.setBackground(Color.decode("#250800"));
			btn_profile_pic.setForeground(Color.WHITE);
			pan_sidebaraccount.add(btn_profile_pic);
			btn_profile_pic.addActionListener(this);
			// lbl_image1.setBorder(BorderFactory.createLineBorder(Color.black));
			lbl_image1.setBorder(thick_sager_Border);

			pan_sidebaraccount.add(lbl_uername);
			pan_sidebaraccount.add(lbl_image1);

			JPanel pan_sidebaraccount1 = new JPanel();
			pan_sidebaraccount1.setBounds(0, 0, 0, 0);
			pan_sidebaraccount1.setLayout(null);
			pan_sidebaraccount1.setBackground(Color.decode("#F5F5DC"));
			pan_sidebaraccount1.setBorder(thickBorder1);
			btn_minimize1.setBounds(230, 3, 24, 24);
			btn_minimize1.setBackground(Color.white);
			JTextArea lbl_image11 = new JTextArea(description);
			lbl_image11.setBounds(15, 60, 230, 180);
			lbl_image11.setBackground(Color.decode("#F5F5DC"));

			// lbl_image11.setBorder(BorderFactory.createLineBorder(Color.black));
			pan_sidebaraccount1.add(lbl_image11);
			pan_sidebaraccount1.add(btn_minimize1);

			JButton btn_logout = new JButton("Log Out");

			//
			btn_yes_backup.addActionListener(this);
			btn_no_backup.addActionListener(this);

			btn_yes_backup.setBackground(Color.decode("#250800"));
			btn_no_backup.setBackground(Color.decode("#250800"));
			btn_yes_backup.setForeground(Color.WHITE);
			btn_no_backup.setForeground(Color.WHITE);
			btn_yes_backup.setBounds(15, 260, 65, 25);
			btn_no_backup.setBounds(88, 260, 65, 25);
			pan_sidebaraccount1.add(btn_yes_backup);
			pan_sidebaraccount1.add(btn_no_backup);

			JPanel pan_sidebaraccount2 = new JPanel();
			pan_sidebaraccount2.setBounds(0, 0, 0, 0);
			pan_sidebaraccount2.setLayout(null);
			pan_sidebaraccount2.setBackground(Color.decode("#F5F5DC"));
			pan_sidebaraccount2.setBorder(thickBorder1);

			btn_minimize2.setBounds(230, 3, 24, 24);
			btn_minimize2.setBackground(Color.white);
			btn_minimize2.addActionListener(this);
			btn_minimize1.addActionListener(this);
			btn_minimize.addActionListener(this);
			btn_minimize3.addActionListener(this);
			pan_sidebaraccount2.add(btn_minimize2);
			JLabel lbl_image111 = new JLabel();
			lbl_image111.setBounds(70, 60, 120, 120);
			lbl_image111.setBorder(BorderFactory.createLineBorder(Color.black));
			JLabel lbl_uername111 = new JLabel();

			lbl_uername111.setBounds(30, 200, 200, 30);
			lbl_uername111.setHorizontalAlignment(JLabel.CENTER);
			lbl_uername111.setBorder(BorderFactory.createLineBorder(Color.black));

			btn_logout.setBounds(30, 260, 90, 25);
			btn_logout.setBackground(Color.decode("#250800"));
			btn_logout.setForeground(Color.white);
			pan_sidebaraccount2.add(btn_logout);
			pan_sidebaraccount2.add(lbl_uername111);
			pan_sidebaraccount2.add(lbl_image111);

			JPanel pan_sidebaraccount4 = new JPanel();
			pan_sidebaraccount4.setBounds(0, 0, 0, 0);
			pan_sidebaraccount4.setLayout(null);
			pan_sidebaraccount4.setBackground(Color.decode("#F5F5DC"));
			pan_sidebaraccount4.setBorder(thickBorder1);

			btn_minimize3.setBounds(230, 3, 24, 24);
			btn_minimize3.setBackground(Color.white);
			pan_sidebaraccount4.add(btn_minimize3);
			JTextArea lbl_description = new JTextArea(description1);
			lbl_description.setBounds(15, 60, 230, 180);
			lbl_description.setBackground(Color.decode("#F5F5DC"));
			// lbl_image11.setBorder(BorderFactory.createLineBorder(Color.black));
			pan_sidebaraccount4.add(lbl_description);
			pan_sidebaraccount4.add(btn_minimize3);

			btn_yes_mail.setBackground(Color.decode("#250800"));
			btn_no_mail.setBackground(Color.decode("#250800"));
			btn_yes_mail.setForeground(Color.WHITE);
			btn_no_mail.setForeground(Color.WHITE);
			btn_yes_mail.setBounds(15, 260, 65, 20);
			btn_no_mail.setBounds(88, 260, 65, 20);

			btn_yes_mail.addActionListener(this);
			btn_no_mail.addActionListener(this);

			pan_sidebaraccount4.add(btn_yes_mail);
			pan_sidebaraccount4.add(btn_no_mail);

			//
			// third

			time_7 = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (pan_sidebaraccount4.getWidth() != 260) {
						pan_sidebaraccount4.setBounds(150, 0, pan_sidebaraccount4.getWidth() + 5, 600);
						if (pan_sidebaraccount4.getWidth() == 260) {
							time_7.stop();
						}

					}

				}

			});

			time_8 = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//
					if (pan_sidebaraccount4.getWidth() != 0) {
						pan_sidebaraccount4.setBounds(150, 0, pan_sidebaraccount4.getWidth() - 5, 600);
						if (pan_sidebaraccount4.getWidth() == 0) {
							time_8.stop();

						}
					}

				}

			});

			time_5 = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (pan_sidebaraccount.getWidth() != 260) {
						pan_sidebaraccount.setBounds(150, 0, pan_sidebaraccount.getWidth() + 5, 600);
						if (pan_sidebaraccount.getWidth() == 260) {
							time_5.stop();
						}

					}

				}

			});

			time_6 = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//
					if (pan_sidebaraccount.getWidth() != 0) {
						pan_sidebaraccount.setBounds(150, 0, pan_sidebaraccount.getWidth() - 5, 600);
						if (pan_sidebaraccount.getWidth() == 0) {
							time_6.stop();

						}
					}

				}

			});

			third = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (pan_sidebaraccount1.getWidth() != 260) {
						pan_sidebaraccount1.setBounds(150, 0, pan_sidebaraccount1.getWidth() + 5, 600);
						if (pan_sidebaraccount1.getWidth() == 260) {
							third.stop();
						}

					}

				}

			});

			forth = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//
					if (pan_sidebaraccount1.getWidth() != 0) {
						pan_sidebaraccount1.setBounds(150, 0, pan_sidebaraccount1.getWidth() - 5, 600);
						if (pan_sidebaraccount1.getWidth() == 0) {
							forth.stop();

						}
					}

				}

			});

			first = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (pan_sidebaraccount2.getWidth() != 260) {
						pan_sidebaraccount2.setBounds(150, 0, pan_sidebaraccount2.getWidth() + 5, 600);
						if (pan_sidebaraccount2.getWidth() == 260) {
							first.stop();

						}

					}

				}

			});

			second = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//
					if (pan_sidebaraccount2.getWidth() != 0) {
						pan_sidebaraccount2.setBounds(150, 0, pan_sidebaraccount2.getWidth() - 5, 600);
						if (pan_sidebaraccount2.getWidth() == 0) {
							second.stop();

						}
					}

				}

			});

			JPanel pan_mainbody = new JPanel();

			first_last = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (pan_mainbody.getHeight() != 610) {
						pan_mainbody.setBounds(0, 0, 1368, pan_mainbody.getHeight() + 5);
						if (pan_mainbody.getHeight() == 610) {
							first_last.stop();

						}

					}

				}

			});

			second_last = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (pan_mainbody.getHeight() != 0) {
						pan_mainbody.setBounds(0, 0, 1368, pan_mainbody.getHeight() - 5);
						if (pan_mainbody.getHeight() == 0) {
							second_last.stop();

						}

					}

				}

			});

			btn_show1.setToolTipText("Yearly ChartReport");
			btn_second.setToolTipText("Yearly ChartReport");
			btn_thired.setToolTipText("Yearly Total Cost");
			btn_fourth.setToolTipText("Monthly Total Cost");
			btn_fifth.setToolTipText("Yearly Attendence");
			btn_six.setToolTipText("Monthly Attendence");

			// min_bodytimer

			Border thick_main = new LineBorder(Color.decode("#4D2713"), 52);

			pan_mainbody.setBounds(0, 0, 1368, 610);

			pan_mainbody.setBackground(Color.decode("#FFE4B5"));
			pan_mainbody.setBorder(thick_main);
			pan_mainbody.setLayout(null);

			lbl_notification.setToolTipText("Stock Notification");
			lbl_notification.addMouseListener(this);
			Action mouse = new Action();
			lbl_expiredate.addMouseListener(mouse);
			lbl_notification.setForeground(Color.WHITE);
			lbl_expiredate.setForeground(Color.WHITE);

			Font font2 = new Font("Verdana", Font.BOLD, 10);
			lbl_notification.setFont(font2);
			lbl_expiredate.setFont(font2);

			lbl_expiredate.setBounds(930, 15, 100, 35);
			lbl_expiredatenum.setBounds(1050, 15, 30, 35);

			lbl_notification.setBounds(770, 15, 180, 35);
			Border thick_notification = new LineBorder(Color.decode("#3D3D3D"), 3);
			pan_notification.setBounds(810, 42, 250, 200);
			pan_notification.setLayout(null);
			pan_notification.setBorder(thick_notification);
			pan_notification.setBackground(Color.decode("#96A5FF"));
			pan_notification.setVisible(false);

			pan_stock_notification.setBounds(930, 42, 250, 200);
			pan_stock_notification.setLayout(null);
			pan_stock_notification.setBorder(thick_notification);
			pan_stock_notification.setBackground(Color.decode("#96A5FF"));
			pan_stock_notification.setVisible(false);

			Font font = new Font("Verdana", Font.BOLD, 12);
			lbl_comment.setFont(font);
			lbl_comment_ex.setFont(font);
			lbl_comment.setForeground(Color.RED);
			lbl_comment_ex.setForeground(Color.RED);
			lbl_comment.setBounds(5, 5, 260, 30);
			lbl_product.setBounds(10, 45, 50, 30);
			cmb_productstockno.setBounds(70, 45, 160, 30);

			lbl_comment_ex.setBounds(5, 5, 260, 30);

			lbl_product_ex.setBounds(10, 45, 50, 30);
			cmb_productstockno_ex.setBounds(70, 45, 160, 30);

			String product_service = (String) cmb_productstockno.getSelectedItem();
			fill_form2(product_service);

			String product_service1 = (String) cmb_productstockno_ex.getSelectedItem();
			fill_form3(product_service1);

			lbl_itemname.setBounds(10, 85, 100, 30);
			lbl_itemvalue.setBounds(100, 85, 160, 30);
			lbl_subitemname.setBounds(10, 125, 100, 30);
			lbl_subitemvalue.setBounds(100, 125, 50, 30);
			btn_okfornotification.setBounds(180, 155, 50, 25);
			btn_okfornotification.setBackground(Color.ORANGE);

			// lbl_comment_ex
			// lbl_dangerousicon_ex
			// btn_showproduct_ex
			// btn_remindlater_ex
			// lbl_product_ex
			cmb_productstockno_ex.setBounds(70, 45, 160, 30);

			lbl_itemname_ex.setBounds(10, 85, 100, 30);
			lbl_subitemname_ex.setBounds(10, 125, 100, 30);
			lbl_itemvalue_ex.setBounds(100, 85, 160, 30);
			lbl_subitemvalue_ex.setBounds(100, 125, 50, 30);
			btn_okfornotification_ex.setBounds(180, 155, 50, 25);
			btn_okfornotification_ex.setBackground(Color.ORANGE);

			lbl_product.setVisible(false);
			cmb_productstockno.setVisible(false);
			lbl_itemname.setVisible(false);
			lbl_itemvalue.setVisible(false);
			lbl_subitemname.setVisible(false);
			lbl_subitemvalue.setVisible(false);
			btn_okfornotification.setVisible(false);

			pan_notification.add(lbl_itemname);
			pan_notification.add(lbl_itemvalue);
			pan_notification.add(lbl_subitemname);
			pan_notification.add(lbl_subitemvalue);
			pan_notification.add(btn_okfornotification);

			pan_stock_notification.add(lbl_itemname_ex);
			pan_stock_notification.add(lbl_itemvalue_ex);
			pan_stock_notification.add(lbl_subitemname_ex);
			pan_stock_notification.add(lbl_subitemvalue_ex);
			pan_stock_notification.add(btn_okfornotification_ex);

			lbl_dangerousicon.setBounds(40, 35, 180, 80);
			btn_showproduct.setBounds(80, 115, 100, 25);
			btn_remindlater.setBounds(80, 155, 100, 25);
			btn_showproduct.setBackground(Color.orange);
			btn_remindlater.setBackground(Color.orange);

			lbl_dangerousicon_ex.setBounds(40, 35, 180, 80);
			btn_showproduct_ex.setBounds(80, 115, 100, 25);
			btn_remindlater_ex.setBounds(80, 155, 100, 25);

			Innerclass innerclass = new Innerclass();
			btn_showproduct.addActionListener(innerclass);
			btn_remindlater.addActionListener(innerclass);
			btn_okfornotification.addActionListener(innerclass);
			btn_showproduct_ex.addActionListener(innerclass);
			btn_remindlater_ex.addActionListener(innerclass);
			btn_okfornotification_ex.addActionListener(innerclass);

			pan_notification.add(lbl_product);
			pan_notification.add(cmb_productstockno);
			pan_notification.add(btn_remindlater);
			pan_notification.add(lbl_comment);
			pan_notification.add(lbl_dangerousicon);
			pan_notification.add(btn_showproduct);

			pan_stock_notification.add(lbl_comment_ex);
			pan_stock_notification.add(lbl_dangerousicon_ex);
			pan_stock_notification.add(btn_showproduct_ex);
			pan_stock_notification.add(btn_remindlater_ex);

			pan_stock_notification.add(lbl_product_ex);
			pan_stock_notification.add(cmb_productstockno_ex);

			pan_stock_notification.add(lbl_comment_ex);
			pan_stock_notification.add(lbl_dangerousicon_ex);
			pan_stock_notification.add(btn_showproduct_ex);
			pan_stock_notification.add(btn_remindlater_ex);
			pan_stock_notification.add(cmb_productstockno_ex);

			pan_mainbody.add(pan_notification);
			pan_mainbody.add(pan_stock_notification);

			cmb_productstockno.addActionListener(this);
			cmb_productstockno_ex.addActionListener(this);

			lbl_notification.setBackground(Color.decode("#4D2713"));
			lbl_numofnotifiation.setBounds(890, 18, 50, 30);

			lbl_numofnotifiation.setForeground(Color.RED);
			lbl_expiredatenum.setForeground(Color.RED);

			pan_mainbody.add(lbl_expiredatenum);
			pan_mainbody.add(lbl_notification);
			pan_mainbody.add(lbl_numofnotifiation);
			pan_mainbody.add(lbl_expiredate);

			lbl_title.setBounds(190, 60, 1000, 260);

			Border thick_button = new LineBorder(Color.decode("#4D2713"), 20);
			btn_show1.setBounds(110, 370, 170, 150);
			btn_second.setBounds(510, 370, 170, 150);
			btn_thired.setBounds(310, 370, 170, 150);
			btn_fourth.setBounds(700, 370, 170, 150);
			btn_fifth.setBounds(890, 370, 170, 150);
			btn_six.setBounds(1080, 370, 170, 150);

			Border thickBorder5 = new LineBorder(Color.ORANGE, 4);
			JPanel pan_upperstar67 = new JPanel();
			pan_upperstar67.setBounds(1080, 330, 170, 40);
			pan_upperstar67.setBorder(thickBorder5);
			pan_upperstar67.setLayout(new GridLayout(0, 1));
			JLabel lbl_pan3 = new JLabel(new ImageIcon("images/5star.png"));
			pan_upperstar67.add(lbl_pan3);

			// B0E0E6.

			JPanel pan_upperstar = new JPanel();
			pan_upperstar.setBounds(110, 330, 170, 40);

			pan_upperstar.setBorder(thickBorder5);
			pan_upperstar.setLayout(new GridLayout(0, 1));
			JLabel lbl_pan1 = new JLabel(new ImageIcon("images/5star.png"));
			pan_upperstar.add(lbl_pan1);

			JPanel pan_upperstar1 = new JPanel();
			pan_upperstar1.setBounds(310, 330, 170, 40);
			pan_upperstar1.setBorder(thickBorder5);
			pan_upperstar1.setLayout(new GridLayout(0, 1));
			JLabel lbl_pan2 = new JLabel(new ImageIcon("images/5star.png"));
			pan_upperstar1.add(lbl_pan2);

			JPanel pan_upperstar2 = new JPanel();
			pan_upperstar2.setBounds(510, 330, 170, 40);
			pan_upperstar2.setBorder(thickBorder5);
			pan_upperstar2.setLayout(new GridLayout(0, 1));
			JLabel lbl_pan31 = new JLabel(new ImageIcon("images/5star.png"));
			pan_upperstar2.add(lbl_pan31);

			JPanel pan_upperstar3 = new JPanel();
			pan_upperstar3.setBounds(700, 330, 170, 40);
			pan_upperstar3.setBorder(thickBorder5);
			pan_upperstar3.setLayout(new GridLayout(0, 1));
			JLabel lbl_pan4 = new JLabel(new ImageIcon("images/5star.png"));
			pan_upperstar3.add(lbl_pan4);

			JPanel pan_upperstar4 = new JPanel();
			pan_upperstar4.setBounds(890, 330, 170, 40);
			pan_upperstar4.setBorder(thickBorder5);
			pan_upperstar4.setLayout(new GridLayout(0, 1));
			JLabel lbl_pan5 = new JLabel(new ImageIcon("images/5star.png"));
			pan_upperstar4.add(lbl_pan5);

			pan_mainbody.add(pan_upperstar4);
			pan_mainbody.add(pan_upperstar3);
			pan_mainbody.add(pan_upperstar2);
			pan_mainbody.add(pan_upperstar1);
			pan_mainbody.add(pan_upperstar);
			pan_mainbody.add(pan_upperstar67);

			btn_show1.setBackground(Color.GRAY);
			btn_second.setBackground(Color.GRAY);
			btn_thired.setBackground(Color.GRAY);
			btn_fourth.setBackground(Color.GRAY);
			btn_fifth.setBackground(Color.GRAY);
			btn_six.setBackground(Color.GRAY);
			btn_show1.addActionListener(this);
			btn_second.addActionListener(this);
			btn_thired.addActionListener(this);
			btn_fourth.addActionListener(this);
			btn_fifth.addActionListener(this);
			btn_six.addActionListener(this);

			btn_fourth.setBorder(thick_button);
			btn_show1.setBorder(thick_button);
			btn_second.setBorder(thick_button);
			btn_thired.setBorder(thick_button);
			btn_fifth.setBorder(thick_button);
			btn_six.setBorder(thick_button);

			Border thick_down = new LineBorder(Color.decode("#4D2713"), 2);
			btn_upperkey.setBackground(Color.decode("#3D3D3D"));
			btn_upperkey.addActionListener(innerclass);
			btn_upperkey.setBounds(1330, 566, 32, 32);
			btn_upperkey.setBorder(thick_down);

			btn_downkey.setBackground(Color.decode("#3D3D3D"));
			btn_downkey.addActionListener(innerclass);
			btn_downkey.setBorder(thick_down);
			btn_downkey.setBounds(1330, 566, 32, 32);
			btn_downkey.setVisible(false);
			desktop.add(btn_downkey);

			if (!(logintype.equals("Onwer"))) {

				itemMonthly.setEnabled(false);
				itemYearly.setEnabled(false);
				itemEmprpt.setEnabled(false);
				itemEdit.setEnabled(false);
				itemAddC.setEnabled(false);
				itemEditC.setEnabled(false);
				itemempattendence.setEnabled(false);
				itemSettings.setEnabled(false);
				itemAddproduct.setEnabled(false);
				itemSallarySettings.setEnabled(false);
				itemEmprpt.setEnabled(false);
				item_trackuser.setEnabled(false);
				item_addfile.setEnabled(false);
				item_stocknotification.setEnabled(false);
				btn_email.setEnabled(false);
				btn_backup.setEnabled(false);

				btn_show1.setEnabled(false);
				btn_second.setEnabled(false);

				btn_thired.setEnabled(false);
				btn_fourth.setEnabled(false);
				btn_fifth.setEnabled(false);
				btn_six.setEnabled(false);

				itemReport.setEnabled(false);
				item_attendencsetting.setEnabled(false);

			}

			pan_mainbody.add(btn_upperkey);
			pan_mainbody.add(btn_fifth);
			pan_mainbody.add(btn_six);
			pan_mainbody.add(btn_thired);
			pan_mainbody.add(btn_fourth);
			pan_mainbody.add(btn_show1);
			pan_mainbody.add(btn_second);
			pan_mainbody.add(lbl_title);

			desktop.add(pan_mainbody);
			desktop.add(pan_sidebaraccount2);
			desktop.add(pan_sidebaraccount4);
			desktop.add(pan_sidebaraccount1);
			desktop.add(pan_sidebaraccount);
			desktop.setBackground(Color.decode("#D9B675"));

			// ddddddddddddddddddddddddddddddddddddddddddd

			JLabel lbl_imag1 = new JLabel(new ImageIcon("images/title.png"));
			lbl_imag1.setBounds(190, 30, 1000, 260);
			desktop.add(lbl_imag1);
			JLabel lbl_imag2 = new JLabel();
			desktop.setBorder(BorderFactory.createLoweredBevelBorder());
			desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
			this.getContentPane().add(panel_Top, BorderLayout.PAGE_START);

			this.getContentPane().add(desktop, BorderLayout.CENTER);
			this.getContentPane().add(panel_Bottom, BorderLayout.PAGE_END);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					UnloadWindow();
				}
			});

			this.setJMenuBar(CreateJMenuBar());
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.setIconImage(new ImageIcon("/eye1.png").getImage());
			receivedproductinfo();
			this.show();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error the Mainmenu Gui" + ex.toString());

		}

	}

	protected JMenuBar CreateJMenuBar() {
		try {
			menuFile.add(settings.setJMenuItem(itemExit, "Quit", "images/k.png"));
			menuFile.add(settings.setJMenuItem(item_trackuser, "History", "images/setting.png"));
			menuFile.add(settings.setJMenuItem(item_addfile, "Add File", "images/add.png"));

			menuFile.setMnemonic((int) 'F');
			itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
			itemExit.setMnemonic((int) 'X');

			item_trackuser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, Event.CTRL_MASK));
			item_trackuser.setMnemonic((int) 'K');

			item_addfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
			item_addfile.setMnemonic((int) 'N');

			item_addfile.addActionListener(this);
			item_trackuser.addActionListener(this);
			itemExit.addActionListener(this);

			menuEmployee.add(settings.setJMenuItem(itemEdit, "Employee Management", "images/edit.png"));
			menuEmployee.setMnemonic((int) 'E');
			menuEmployee.addSeparator();
			menuEmployee.add(settings.setJMenuItem(itemempattendence, "Employee Attendence", "images/atten.png"));
			itemEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.CTRL_MASK));
			itemEdit.setMnemonic((int) 'E');
			itemEdit.addActionListener(this);
			itemempattendence.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
			itemempattendence.setMnemonic((int) 'A');
			itemempattendence.addActionListener(this);

			menuCustomer.add(settings.setJMenuItem(itemAddC, "Customer Details", "images/labour.png"));
			menuCustomer.setMnemonic((int) 'C');
			menuCustomer.add(settings.setJMenuItem(itemEditC, "Others Info", "images/edit.png"));
			menuCustomer.addSeparator();
			itemAddC.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
			itemAddC.setMnemonic((int) 'C');
			itemAddC.addActionListener(this);
			itemEditC.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.CTRL_MASK));
			itemEditC.setMnemonic((int) 'I');
			itemEditC.addActionListener(this);

			menuOrder.add(settings.setJMenuItem(itemCustomerOrder, "Customer Order", "images/order.png"));
			menuOrder.setMnemonic((int) 'O');
			menuOrder.addSeparator();
			menuOrder.addSeparator();
			menuOrder.addSeparator();
			itemCustomerOrder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK));
			itemCustomerOrder.setMnemonic((int) 'O');
			itemCustomerOrder.addActionListener(this);

			// here product
			menuProduct.add(settings.setJMenuItem(itemAddproduct, "Product Details", "images/addproduct.png"));
			menuProduct.setMnemonic((int) 'P');
			menuProduct.addSeparator();
			itemAddproduct.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));
			itemAddproduct.setMnemonic((int) 'P');
			itemAddproduct.addActionListener(this);

			// setting option
			menuReports.add(settings.setJMenuItem(itemEmprpt, "Employee Report", "images/report.png"));
			menuReports.setMnemonic((int) 'R');
			menuReports.addSeparator();
			menuReports.add(settings.setJMenuItem(itemMonthly, "Monthly Report", "images/report.png"));
			menuReports.addSeparator();
			menuReports.add(settings.setJMenuItem(itemYearly, "Yearly Report", "images/report.png"));
			menuReports.addSeparator();
			menuReports.addSeparator();
			itemEmprpt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK));
			itemEmprpt.setMnemonic((int) 'L');
			itemMonthly.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, Event.CTRL_MASK));
			itemMonthly.setMnemonic((int) 'M');
			itemYearly.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Event.CTRL_MASK));
			itemYearly.setMnemonic((int) 'Y');
			itemEmprpt.addActionListener(this);
			itemMonthly.addActionListener(this);
			itemYearly.addActionListener(this);
			menuSetting.add(settings.setJMenuItem(itemSallarySettings, "Sallary Settings", "images/setting.png"));
			menuSetting.setMnemonic((int) 'S');
			menuSetting.add(settings.setJMenuItem(itemReport, "Report Settings", "images/setting.png"));

			menuSetting.add(settings.setJMenuItem(item_attendencsetting, "Attendence Settings", "images/setting.png"));

			item_attendencsetting.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, Event.CTRL_MASK));
			item_attendencsetting.setMnemonic((int) 'K');

			itemSallarySettings.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.CTRL_MASK));
			itemSallarySettings.setMnemonic((int) 'R');
			itemReport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK));
			itemReport.setMnemonic((int) 'D');
			itemSallarySettings.addActionListener(this);
			itemReport.addActionListener(this);
			item_attendencsetting.addActionListener(this);

			// window setting

			menu_windowsettins
					.add(settings.setJMenuItem(item_backgroundcolor, "Change Background Color", "images/setting.png"));
			menu_windowsettins.add(settings.setJMenuItem(item_closeallwindow, "Close allwindow", "images/setting.png"));

			menu_windowsettins
					.add(settings.setJMenuItem(item_stocknotification, "Stock Notification", "images/setting.png"));

			item_backgroundcolor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.CTRL_MASK));
			item_backgroundcolor.setMnemonic((int) 'B');
			item_closeallwindow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, Event.CTRL_MASK));
			item_closeallwindow.setMnemonic((int) 'W');

			item_stocknotification.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK));
			item_stocknotification.setMnemonic((int) 'V');

			item_stocknotification.addActionListener(this);
			item_closeallwindow.addActionListener(this);

			menu_windowsettins.setMnemonic((int) 'W');
			item_backgroundcolor.addActionListener(this);
			item_theme.addActionListener(this);
			item_closeallwindow.addActionListener(this);

			// windows settins

			// setting tool bar
			menuTools.add(settings.setJMenuItem(itemCalculator, "Calculator", "images/cal.png"));
			menuTools.setMnemonic((int) 'T');
			menuTools.addSeparator();
			menuTools.add(settings.setJMenuItem(itemNotePad, "NotePad", "images/notepad.png"));
			itemCalculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
			itemCalculator.setMnemonic((int) 'Q');
			itemNotePad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
			itemNotePad.setMnemonic((int) 'N');
			itemCalculator.addActionListener(this);
			itemNotePad.addActionListener(this);
			menuHelp.add(settings.setJMenuItem(itemAuthor, "About Author", "images/about.png"));
			menuHelp.add(settings.setJMenuItem(itemHelp, "Help", "images/help.png"));
			menuHelp.setMnemonic((int) 'H');

			itemAuthor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, Event.CTRL_MASK));
			itemAuthor.setMnemonic((int) 'U');
			itemHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, Event.CTRL_MASK));
			itemHelp.setMnemonic((int) 'H');

			itemAuthor.addActionListener(this);
			itemHelp.addActionListener(this);
			// adding menuitem to menubar

			UIManager.addPropertyChangeListener(new GetColorParent((JComponent) getRootPane()));
			MetalTheme[] themes = { new DefaultMetalTheme(), new Theme1(), new Theme2(), new Theme3(), new Theme4(),
					new Theme5() };
			item_theme = new MetalThemeMenu("Apply Theme", themes);
			item_theme.setMnemonic((int) 'T');
			menu_windowsettins.add(item_theme);

			menubar.add(settings.setJMenu(menuFile));
			menubar.add(settings.setJMenu(menuEmployee));
			menubar.add(settings.setJMenu(menuCustomer));
			menubar.add(settings.setJMenu(menuOrder));
			menubar.add(settings.setJMenu(menuProduct));
			menubar.add(settings.setJMenu(menuReports));
			menubar.add(settings.setJMenu(menuSetting));
			menubar.add(settings.setJMenu(menu_windowsettins));
			menubar.add(settings.setJMenu(menuTools));
			menubar.add(settings.setJMenu(menuHelp));

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error the Manubar" + ex.toString());

		}
		return menubar;

	}

	protected JToolBar createJToolBar() {
		JToolBar toolbar = new JToolBar("Toolbar");

		toolbar.add(settings.CreateJToolbarButton("Exit", "images/exit.png", "File_Exit", JToolBarActionListener));
		toolbar.addSeparator();
		toolbar.addSeparator();

		toolbar.add(
				settings.CreateJToolbarButton("Add - Employee", "images/add.png", "Emp_Add", JToolBarActionListener));

		toolbar.add(settings.CreateJToolbarButton("Edit - Employee", "images/edit.png", "Emp_Edit",
				JToolBarActionListener));

		toolbar.add(settings.CreateJToolbarButton("Search - Employee", "images/search.png", "Emp_Search",
				JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("Delete - Employee", "images/delete.png", "Emp_Delete",
				JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("Attendence - Employee", "images/atten.png", "Emp_Attendence",
				JToolBarActionListener));
		toolbar.addSeparator();

		// add the customer
		toolbar.add(
				settings.CreateJToolbarButton("Add -Customer", "images/labour.png", "Cus_Add", JToolBarActionListener));
		toolbar.add(
				settings.CreateJToolbarButton("Edit -Customer", "images/edit.png", "Cus_edit", JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("Delete -Customer", "images/delete.png", "Cus_delete",
				JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("Search -Customer", "images/search.png", "Cus_view",
				JToolBarActionListener));
		toolbar.addSeparator();

		// ADD ORDER
		toolbar.add(settings.CreateJToolbarButton("Customer_Order", "images/order.png", "Cus_order",
				JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("View_Order", "images/view.png", "Cus_view", JToolBarActionListener));
		toolbar.addSeparator();

		// add product
		toolbar.add(settings.CreateJToolbarButton("Add_product", "images/addproduct.png", "add_product",
				JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("Update_product", "images/edit.png", "update_product",
				JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("Delete_product", "images/delete.png", "delete_product",
				JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("View_product", "images/view.png", "view_product",
				JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("Storewarehouse_product", "images/house.png", "store_product",
				JToolBarActionListener));
		toolbar.addSeparator();

		// Report
		toolbar.add(settings.CreateJToolbarButton("sallary_Report", "images/report.png", "sall_report",
				JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("Monthly_Report", "images/report.png", "monthly_report",
				JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("Yearly_Report", "images/report.png", "yearly_report",
				JToolBarActionListener));
		toolbar.addSeparator();
		/// setting
		toolbar.add(settings.CreateJToolbarButton("Setting_Sallary", "images/setting.png", "setting_sallary",
				JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("Setting_Profile", "images/edit.png", "setting_profile",
				JToolBarActionListener));
		toolbar.addSeparator();
		// Tools
		toolbar.add(settings.CreateJToolbarButton("Tools_cal", "images/cal.png", "cal", JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("Tools_Notepad", "images/notepad.png", "tools_notepad",
				JToolBarActionListener));
		toolbar.addSeparator();
		// Help
		toolbar.add(settings.CreateJToolbarButton("About_Me", "images/about.png", "about_me", JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("Help", "images/help.png", "help", JToolBarActionListener));
		toolbar.addSeparator();
		return toolbar;

	}

	public void stockreminder() {// stock reminder
		frm = new JFrame();
		frm.setTitle("Stock Reminder Setting");
		frm.setSize(450, 250);
		frm.setLayout(new GridLayout());
		frm.setResizable(false);
		frm.setLocation(screenheith / 2, screedwidth / 12);
		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = createImageIcon("");
		JComponent panel1 = makeTextPanel("");
		panel1.setBackground(Color.decode("#875A3C"));
		panel1.setLayout(null);
		JPanel pan_autoreminder = new JPanel();
		pan_autoreminder.setBounds(20, 20, 395, 155);
		pan_autoreminder.setLayout(null);
		pan_autoreminder.setBackground(Color.decode("#C8A064"));
		pan_autoreminder.setBorder(thickBorder);
		pan_autoreminder.setLayout(null);
		JLabel lbl_change = new JLabel("Restock level quantity");
		lbl_change.setBounds(30, 60, 130, 30);
		txt_change.setBounds(160, 60, 140, 30);
		retrive_customer(txt_change, txt_changeid);

		btn_change.setBounds(305, 60, 56, 30);
		btn_change.setBackground(Color.ORANGE);
		pan_autoreminder.add(lbl_change);

		txt_changeid.setBounds(160, 5, 140, 30);
		pan_autoreminder.add(txt_changeid);
		pan_autoreminder.add(txt_change);
		pan_autoreminder.add(btn_change);
		btn_change.addActionListener(this);
		panel1.add(pan_autoreminder);
		tabbedPane.addTab("Auto Reminder Stock", icon, panel1, "Stock Setting");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		JComponent panel2 = makeTextPanel("");
		panel2.setBackground(Color.decode("#875A3C"));
		panel2.setLayout(null);
		JPanel pan_autoreminder2 = new JPanel();
		pan_autoreminder2.setBounds(20, 20, 395, 155);
		pan_autoreminder2.setLayout(null);
		pan_autoreminder2.setBackground(Color.decode("#C8A064"));
		pan_autoreminder2.setBorder(thickBorder);
		pan_autoreminder2.setLayout(null);
		JLabel lbl_change1 = new JLabel("Gui Screen Capture");
		lbl_change1.setBounds(30, 40, 130, 30);
		pan_autoreminder2.add(lbl_change1);
		ButtonGroup btn_group = new ButtonGroup();
		btn_group.add(btn_rnd);
		btn_group.add(btn_off);

		txt_change1.setBounds(160, 40, 140, 30);
		btn_change1.setBounds(305, 40, 56, 70);
		btn_rnd.setBounds(160, 85, 76, 30);
		btn_off.setBounds(240, 85, 56, 30);
		btn_rnd.setBackground(Color.decode("#C8A064"));
		btn_off.setBackground(Color.decode("#C8A064"));
		btn_change1.setBackground(Color.ORANGE);
		btn_change1.setForeground(Color.black);
		btn_change1.addActionListener(this);
		btn_change.addActionListener(this);
		btn_rnd.addActionListener(this);
		btn_off.addActionListener(this);
		pan_autoreminder2.add(btn_rnd);
		pan_autoreminder2.add(btn_off);
		pan_autoreminder2.add(txt_change1);
		pan_autoreminder2.add(btn_change1);
		panel2.add(pan_autoreminder2);
		tabbedPane.addTab("Screen Capture", icon, panel2, "Setting Screen Capture");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
		frm.add(tabbedPane);
		frm.setVisible(true);

	}

	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.add(filler);
		return panel;
	}

	public void retrive_customer(JTextField cmb, JTextField cmb1) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM Auto_stockreminder";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String id = rs.getString(1).trim();
				String txt_id = rs.getString(2).trim();
				cmb.setText(txt_id);
				cmb1.setText(id);

			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = MainGui.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	protected void UnloadWindow() {
		try {
			int reply = JOptionPane.showConfirmDialog(this, "Are you sure to exit?", sMSGBOX_TITLE,
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (reply == JOptionPane.YES_OPTION) {
				setVisible(false);
				System.exit(0);
			}
		} catch (Exception e) {
		}

	}// Close the Windows

	public Connection getConnection() {
		try {
			conn = connect.setConnection(conn);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	// protected void loadSplashScreen() {
	// // Start the thread
	// ThFormSplash.start();
	// while (!FormSplash.isShowing()) {
	// try {
	// // Display the FormSplash for 10 seconds
	// Thread.sleep(10000);
	// } catch (InterruptedException e) {
	// }
	// }
	// }
	// Thread ThFormSplash = new Thread();

	private boolean openChildWindow(String title) {

		JInternalFrame[] childs = desktop.getAllFrames(); // Get All Open Child
															// Windows.
		for (int i = 0; i < childs.length; i++) {
			if (childs[i].getTitle().equalsIgnoreCase(title)) { // Getting the
																// Title of
																// Child Window.
				childs[i].show(); // Setting Focus on the Child Window.
				return true;
			}
		}
		return false;

	}

	public ArrayList<Receivedproductinfo> receivedproductinfo() {
		ArrayList<Receivedproductinfo> usersList = new ArrayList<Receivedproductinfo>();
		Connection connection = getConnection();
		String query = "SELECT * FROM  `Rec_product` ";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Receivedproductinfo user;
			while (rs.next()) {
				user = new Receivedproductinfo(rs.getInt("receivedId"), rs.getInt("product_no"),
						rs.getString("productname"), rs.getString("sub_productname"), rs.getString("catagory"),
						rs.getString("expiredate"), rs.getInt("quantity"), rs.getDouble("price"),
						rs.getDouble("sellingprice"), rs.getString("date"), rs.getDouble("totalamount"));

				int quen = rs.getInt("quantity");
				String expired = rs.getString("expiredate");
				if (quen != 0) {
					try {
						conn_retrive = connect_retrive.setConnection(conn_retrive);
					} catch (Exception e) {
					}
					try {
						Statement stmt = conn_retrive.createStatement();
						String query1 = "SELECT * FROM Auto_stockreminder";
						ResultSet rs1 = stmt.executeQuery(query1);
						while (rs1.next()) {
							String txt_id = rs1.getString(2).trim();
							int so_had = Integer.parseInt(txt_id);
							if (quen <= so_had) {
								counter += 1;
								mehedi = rs.getInt("receivedId");
								String sager = Integer.toString(mehedi);
								cmb_productstockno.addItem(sager);

							} else if (expired.contentEquals(f) == true) {
								counter_expiredate += 1;
								mehedi1 = rs.getInt("receivedId");
								String sager1 = Integer.toString(mehedi1);
								cmb_productstockno_ex.addItem(sager1);

								// lbl_expiredatenum
							}

						}
						conn_retrive.close();
					}

					catch (Exception ex) {

					}

				} else {

				}

				usersList.add(user);

			}

			lbl_numofnotifiation.setText("" + counter);
			lbl_expiredatenum.setText("" + counter_expiredate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	protected void loadForm(String Title, JInternalFrame clsForm) {

		boolean xForm = isLoaded(Title);
		if (xForm == false) {
			desktop.add(clsForm);
			clsForm.setVisible(true);
			clsForm.show();
		} else {
			try {
				clsForm.setIcon(false);
				clsForm.setSelected(true);

			} catch (PropertyVetoException e) {
			}
		}
	} // Complete Load Form methoded

	protected boolean isLoaded(String FormTitle) {
		JInternalFrame Form[] = desktop.getAllFrames();
		for (int i = 0; i < Form.length; i++) {
			if (Form[i].getTitle().equalsIgnoreCase(FormTitle)) {
				Form[i].show();
				try {
					Form[i].setIcon(false);
					Form[i].setSelected(true);

				} catch (PropertyVetoException e) {

				}
				return true;
			}
		}
		return false;
	} // Complete to Verify Form loaded or not

	protected void runApps(String utilitysoftware) {// run the exe file form web
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec(utilitysoftware);
		} catch (IOException evt) {
			JOptionPane.showMessageDialog(null, evt.getMessage(), "Error Found", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void executeSQlQuery_history(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {
				JOptionPane.showMessageDialog(null, "Update Succefully");
			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	ActionListener JToolBarActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String source = e.getActionCommand();

			if (source == "File_Exit") {
				loadJInternalFrame(2);
			} else if (source == "Emp_Add") {
				loadJInternalFrame(3);
			} else if (source == "Emp_Edit") {
				loadJInternalFrame(4);
			} else if (source == "Emp_Delete") {
				loadJInternalFrame(5);
			} else if (source == "Settings") {
				loadJInternalFrame(6);
			} else if (source == "Tools_Calculator") {
				loadJInternalFrame(7);
			} else if (source == "Tools_NotePad") {
				loadJInternalFrame(8);
			} else if (source == "Reports_Employee") {
				loadJInternalFrame(9);
			} else if (source == "Help_Author") {
				loadJInternalFrame(100);
			} else if (source == "Help_Help") {
				loadJInternalFrame(12);
			} else if (source == "logout") {
				loadJInternalFrame(14);
			}
		}

	};

	@Override
	public void actionPerformed(ActionEvent event) {
		Object object = event.getSource();
		if (object == itemEdit) {
			loadJInternalFrame(2);
		} else if (object == itemExit) {
			loadJInternalFrame(5);

		} else if (object == item_addfile) {
			try {
				String file = JOptionPane.showInputDialog(null, "Please Enter File Name");
				String file_name, file_idd;
				file_name = "";
				file_idd = "";
				record += 1;
				file_name = file;
				file_idd = "" + record;

				if (!file_name.equals("")) {
					Statement stmt = conn.createStatement();
					String query = "SELECT * FROM File WHERE filename='" + file_name + "'";
					ResultSet rs = stmt.executeQuery(query);
					int foundrec = 0;
					while (rs.next()) {
						String dialogmessage = "Record Already Exists in DataBase!!!";
						int dialogtype = JOptionPane.WARNING_MESSAGE;
						JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);
						foundrec = 1;

					}
					if (foundrec == 0) {
						String temp = "INSERT INTO File(filename) VALUES ('" + file_name + "')";
						int result = stmt.executeUpdate(temp);
						if (result == 1) {
							String dialogmessage = "File  Added!!";
							int dialogtype = JOptionPane.INFORMATION_MESSAGE;
							JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);

						} else {
							String dialogmessage = "Failed To Insert";
							JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!",
									JOptionPane.WARNING_MESSAGE);

						}
					}

				} else {
					String dialogmessage = "EMPTY VALUE FOUND";
					JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!", JOptionPane.WARNING_MESSAGE);

				}

			} catch (Exception ex) {

				System.out.println("Unknown Error" + ex);

			}

		} else if (object == itemSallarySettings)

		{
			loadJInternalFrame(6);

		} else if (object == itemAddC) {
			loadJInternalFrame(7);
		} else if (object == itemEditC) {
			loadJInternalFrame(9);

		} else if (object == itemempattendence) {
			loadJInternalFrame(12);
		} else if (object == itemEmprpt) {
			loadJInternalFrame(15);

		} else if (object == itemAddproduct) {
			loadJInternalFrame(16);

		} else if (object == itemMonthly) {
			loadJInternalFrame(17);
		} else if (object == itemCustomerOrder) {
			loadJInternalFrame(18);

		} else if (object == itemAddC) {
			loadJInternalFrame(19);
		} else if (object == itemCalculator) {
			loadJInternalFrame(22);

		} else if (object == itemNotePad) {
			loadJInternalFrame(23);
		} else if (object == itemReport) {
			loadJInternalFrame(24);

		} else if (object == itemYearly) {
			loadJInternalFrame(25);

		} else if (object == btn_profile_pic) {// add new
			time_6.start();
			btn_backup.setBackground(Color.decode("#250800"));
			btn_profile.setBackground(Color.decode("#250800"));
			btn_logout_all.setBackground(Color.decode("#250800"));
			btn_left.setEnabled(true);
			btn_right.setEnabled(true);
			editprofile = new EditUser(this, sUser);
			loadForm("EditProfile", editprofile);

		} else if (object == btn_logout_all) {// add new

			int i = JOptionPane.showConfirmDialog(null, "Do you want to Exit!!!");
			if (i == 0) {
				dispose();
				this.setVisible(false);
				login = new loginframe();
			}

		} else if (object.equals(btn_left)) {
			btn_downkey.setEnabled(false);
			pan_right.setVisible(false);
			next_panel.setVisible(true);
			tm1.start();
		} else if (object.equals(btn_right)) {
			btn_downkey.setEnabled(true);
			pan_right.setVisible(true);
			next_panel.setVisible(false);
			tm2.start();

		} else if (object.equals(btn_profile)) {
			time_5.start();
			btn_profile.setBackground(Color.RED);
			btn_logout_all.setBackground(Color.decode("#250800"));
			btn_backup.setBackground(Color.decode("#250800"));
			btn_left.setEnabled(false);
			btn_right.setEnabled(false);

		} else if (object.equals(btn_minimize)) {
			time_6.start();
			btn_backup.setBackground(Color.decode("#250800"));
			btn_profile.setBackground(Color.decode("#250800"));
			btn_logout_all.setBackground(Color.decode("#250800"));
			btn_left.setEnabled(true);
			btn_right.setEnabled(true);
		} else if (object.equals(btn_email)) {
			time_7.start();
			btn_email.setBackground(Color.red);
			btn_logout_all.setBackground(Color.decode("#250800"));
			btn_backup.setBackground(Color.decode("#250800"));
			btn_profile.setBackground(Color.decode("#250800"));
			btn_left.setEnabled(false);
			btn_right.setEnabled(false);

		} else if (object.equals(btn_minimize3)) {
			time_8.start();
			btn_email.setBackground(Color.decode("#250800"));
			btn_left.setEnabled(true);
			btn_right.setEnabled(true);

		} else if (object.equals(btn_backup)) {
			btn_logout_all.setBackground(Color.decode("#250800"));
			third.start();
			btn_backup.setBackground(Color.RED);
			btn_left.setEnabled(false);
			btn_right.setEnabled(false);

		} else if (object.equals(btn_minimize1)) {
			forth.start();
			btn_logout_all.setBackground(Color.decode("#250800"));
			btn_backup.setBackground(Color.decode("#250800"));
			btn_left.setEnabled(true);
			btn_right.setEnabled(true);

		} else if (object.equals(btn_exit_all)) {
			tm2.start();

		} else if (object.equals(btn_logout_all)) {
			first.start();
			btn_logout_all.setBackground(Color.RED);
			btn_left.setEnabled(false);
			btn_right.setEnabled(false);
			btn_backup.setBackground(Color.decode("#250800"));

		} else if (object.equals(btn_minimize2)) {
			second.start();
			btn_logout_all.setBackground(Color.decode("#250800"));
			btn_left.setEnabled(true);
			btn_right.setEnabled(true);

		} else if (object.equals(item_backgroundcolor)) {
			Color getcolor = desktop.getBackground();
			getcolor = JColorChooser.showDialog(this, "Choose Background Color", getcolor);
			if (getcolor == null) {
			} else {
				desktop.setBackground(getcolor);
				desktop.repaint();
			}

		} else if (object.equals(item_closeallwindow)) {
			JInternalFrame allframs[] = desktop.getAllFrames();
			for (int i = 0; i < allframs.length; i++) {
				try {
					allframs[i].setClosed(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error the closing the window" + ex.toString());

				}
			}

		} else if (object.equals(itemAuthor)) {
			String str = "Golam BakeryManagement System.\n\n" + "Created & Designed By:\n" + "Md. Golam Nobi Sheikh\n\n"
					+ "E-mail me:\n 1000363@daffodil.ac";
			JOptionPane.showMessageDialog(this, str, "About BakeryManagement System", JOptionPane.PLAIN_MESSAGE);

		} else if (object.equals(itemHelp)) {
			boolean b = openChildWindow("Help Contents");
			if (b == false) {
				HelpMenue help = new HelpMenue("Golam BakeryManagement System Help Contents", "Help/index.html");
				desktop.add(help);
				help.show();
			}

		} else if (object.equals(btn_show1)) {
			graphreports = new GraphReports();

			// halk

		} else if (object.equals(btn_second)) {

			try {

				conn = connect.setConnection(conn);
				JasperDesign jd = JRXmlLoader
						.load("C:\\Users\\golam\\workspace\\BakeryManagementSystem\\Report\\yearlycost.jrxml");
				JasperReport jr = JasperCompileManager.compileReport(jd);
				JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
				JasperViewer.viewReport(jp, false);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Exception" + ex.toString());

			}

		} else if (object.equals(btn_thired)) {

			filesearch = new FileSearch();

		} else if (object.equals(btn_fourth)) {
			try {

				conn = connect.setConnection(conn);
				JasperDesign jd = JRXmlLoader
						.load("C:\\Users\\golam\\workspace\\BakeryManagementSystem\\Report\\Monthbakery.jrxml");
				JasperReport jr = JasperCompileManager.compileReport(jd);
				JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
				JasperViewer.viewReport(jp, false);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Exception" + ex.toString());

			}

		} else if (object.equals(btn_fifth)) {
			try {

				conn = connect.setConnection(conn);
				JasperDesign jd = JRXmlLoader
						.load("C:\\Users\\golam\\workspace\\BakeryManagementSystem\\Report\\yearlyattendance.jrxml");
				JasperReport jr = JasperCompileManager.compileReport(jd);
				JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
				JasperViewer.viewReport(jp, false);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Exception" + ex.toString());

			}

		} else if (object.equals(btn_six)) {

			try {

				conn = connect.setConnection(conn);
				JasperDesign jd = JRXmlLoader
						.load("C:\\Users\\golam\\workspace\\BakeryManagementSystem\\Report\\monthlyatt.jrxml");
				JasperReport jr = JasperCompileManager.compileReport(jd);
				JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
				JasperViewer.viewReport(jp, false);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Exception" + ex.toString());

			}

			// df

		} else if (object.equals(btn_yes_mail)) {
			time_8.start();
			btn_email.setBackground(Color.decode("#250800"));
			btn_left.setEnabled(true);
			btn_right.setEnabled(true);
			loadJInternalFrame(26);

		} else if (object.equals(btn_no_mail)) {
			time_8.start();
			btn_email.setBackground(Color.decode("#250800"));
			btn_left.setEnabled(true);
			btn_right.setEnabled(true);

		} else if (object.equals(cmb_productstockno)) {
			String product_service = (String) cmb_productstockno.getSelectedItem();

			fill_form2(product_service);
			lbl_product.setVisible(true);
			lbl_itemname.setVisible(true);
			lbl_subitemname.setVisible(true);
			lbl_itemvalue.setVisible(true);
			lbl_subitemvalue.setVisible(true);

		} else if (object.equals(cmb_productstockno_ex)) {
			String product_service1 = (String) cmb_productstockno_ex.getSelectedItem();
			fill_form3(product_service1);
			lbl_product_ex.setVisible(true);
			lbl_itemname_ex.setVisible(true);
			lbl_subitemname_ex.setVisible(true);
			lbl_itemvalue_ex.setVisible(true);
			lbl_subitemvalue_ex.setVisible(true);

		} else if (object.equals(item_trackuser)) {
			loadJInternalFrame(27);

		} else if (object.equals(item_stocknotification)) {
			stockreminder();

		} else if (object.equals(btn_yes_backup)) {
			loadJInternalFrame(28);

		} else if (object.equals(item_attendencsetting)) {
			loadJInternalFrame(29);

		} else if (object.equals(btn_no_backup)) {
			btn_backup.setBackground(Color.decode("#250800"));
			btn_left.setEnabled(true);
			btn_right.setEnabled(true);
			forth.start();
		} else if (object.equals(btn_change)) {
			int str, str1;
			str = Integer.parseInt(txt_changeid.getText());
			str1 = Integer.parseInt(txt_change.getText());

			String temp = "UPDATE auto_stockreminder SET " + " autoId ='" + str + "', auto_amount = '" + str1 + "'"
					+ "WHERE autoId = '" + str + "'";
			executeSQlQuery_history(temp, "Updated");

		} else if (object.equals(lbl_uername)) {

			String sr = (String) lbl_uername.getText().toUpperCase();
			fill_form(sr);
		}

	}

	private void loadJInternalFrame(int postion) {
		switch (postion) {
		case 1:
			try {
				// addemployee = new AddEmployee(this);
				// loadForm("Add Employee", addemployee);
			} catch (Exception e) {
				System.out.println("\nError");
			}
			break;
		case 2:
			try {
				editemployee = new Editemployee(this, sUser);
				loadForm("Edit Employee", editemployee);
			} catch (Exception e) {
				System.out.println("\nError");
			}
			break;
		case 3:
			try {
				// searchemployee = new SearchEmployee(this);
				loadForm("Edit Employee", editemployee);
			} catch (Exception e) {
				System.out.println("\nError");
			}
			break;
		case 4:
			try {
				// deleteemployee = new DeleteEmployee(this);
				// loadForm("Delete Employee", deleteemployee);
			} catch (Exception e) {
				System.out.println("\nError");
			}
			break;

		case 5:
			dispose();
			break;
		case 6:
			try {
				settingemployee = new SettingEmployee(this);
				loadForm("Setting Employee", settingemployee);
			} catch (Exception e) {
				System.out.println("\nError");
			}

			break;
		case 7:
			try {
				customerdetails = new CustomerDetails(this);
				loadForm("AddCustomer", customerdetails);
			} catch (Exception e) {
				System.out.println("\nError");
			}

			break;
		case 8:
			deletecustomer = new DeleteCustomer(this);
			loadForm("DeleteCustomer", deletecustomer);
			break;
		case 9:
			user_details = new UserDetails(this);
			loadForm("updateCustomer", user_details);
			break;
		case 10:
			search_Customer = new SearchCustomer(this);
			loadForm("searchcustomer", search_Customer);
			break;

		case 12:
			attendence = new Attendence(this);
			loadForm("Attendence Employee", attendence);
			break;

		case 14:
			// dispose();
			pan_golam.setVisible(true);
			// this.setVisible(false);
			//
			break;
		case 15:
			sallary_Report = new ReportSallary(this);
			loadForm("Report_empSallary", sallary_Report);
			break;

		case 16:
			productstock = new productDetails(this);
			loadForm("product_details", productstock);
			break;

		case 17:
			monthlyreport = new MonthlyReport(this);
			loadForm("monthlyreport", monthlyreport);
			break;
		case 18:
			order = new CustomerOrder(this, sUser, lointype);
			loadForm("CustomerOrder", order);
			break;

		case 22:
			runApps("Calc.exe");
			break;
		case 23:
			runApps("Notepad.exe");
			break;

		case 24:
			settingreport = new SettingRepor(this);
			loadForm("Report", settingreport);
			break;

		case 25:
			year_report = new yearly_report(this);
			loadForm("Report", year_report);
			break;
		case 26:
			sendemail = new SendingMail(this);
			loadForm("Sending Mail", sendemail);
			break;

		case 27:
			tackingview = new TrakingView(this);
			loadForm("tackingview Customer", tackingview);
			break;
		case 28:
			forth.start();
			btn_backup.setBackground(Color.decode("#250800"));
			btn_left.setEnabled(true);
			btn_right.setEnabled(true);
			databasebackup = new DatabaseBackup(this);
			loadForm("Database Backup", databasebackup);
			break;

		case 29:
			attendencesetting = new AttandenceSetting(this);
			loadForm("Attandence Setting", attendencesetting);
			break;

		}
	}

	@SuppressWarnings("resource")
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
				// byte[] img = rs.getBytes("image");
				byte[] img = rs.getBytes("image");
				ImageIcon image = new ImageIcon(img);
				Image im = image.getImage();
				Image myimg = im.getScaledInstance(lbl_image1.getWidth(), lbl_image1.getHeight(),
						Image.SCALE_AREA_AVERAGING);
				ImageIcon imagegolam = new ImageIcon(myimg);
				firstname = "";
				firstname = rs.getString(1).trim();
				lblUsername.setText(firstname);
				lbl_image1.setIcon(imagegolam);

				rs = null;

			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		pan_stock_notification.setVisible(false);
		pan_notification.setVisible(true);
		lbl_notification.setForeground(Color.GREEN);
		lbl_numofnotifiation.setVisible(false);

		lbl_product.setVisible(false);
		lbl_itemname.setVisible(false);
		lbl_subitemvalue.setVisible(false);
		lbl_subitemname.setVisible(false);
		lbl_itemvalue.setVisible(false);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void fill_form2(String name) {

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM rec_product WHERE receivedId='" + name + "'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				String product_name = rs.getString(3).trim();
				String product_subname = rs.getString(4).trim();
				lbl_itemvalue.setText(product_name);
				lbl_subitemvalue.setText(product_subname);

				rs = null;

			}

			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void fill_form3(String name) {

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM rec_product WHERE receivedId='" + name + "'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				String product_name = rs.getString(3).trim();
				String product_subname = rs.getString(4).trim();
				System.out.println(product_name);
				System.out.println(product_subname);
				lbl_itemvalue_ex.setText(product_name);
				lbl_subitemvalue_ex.setText(product_subname);
				rs = null;

			}

			conn.close();
		}

		catch (Exception ex) {

		}

	}

	class Innerclass implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source.equals(btn_showproduct)) {
				lbl_comment.setText("Please Check the following product");
				lbl_dangerousicon.setVisible(false);
				btn_showproduct.setVisible(false);
				btn_remindlater.setVisible(false);
				lbl_notification.setForeground(Color.white);
				lbl_itemname.setVisible(false);
				lbl_subitemname.setVisible(false);
				lbl_itemvalue.setVisible(false);
				lbl_subitemvalue.setVisible(false);
				btn_okfornotification.setVisible(true);
				lbl_product.setVisible(true);
				cmb_productstockno.setVisible(true);

			} else if (source.equals(btn_remindlater)) {
				pan_notification.setVisible(false);
				lbl_notification.setForeground(Color.white);

			} else if (source.equals(btn_showproduct_ex)) {
				//
				lbl_comment_ex.setText("Please Check the following product");
				lbl_dangerousicon_ex.setVisible(false);
				btn_showproduct_ex.setVisible(false);
				btn_remindlater_ex.setVisible(false);
				lbl_numofnotifiation.setForeground(Color.white);
				lbl_itemname_ex.setVisible(false);
				lbl_subitemname_ex.setVisible(false);
				lbl_itemvalue_ex.setVisible(false);
				lbl_subitemvalue_ex.setVisible(false);
				btn_okfornotification_ex.setVisible(true);
				lbl_product_ex.setVisible(true);
				cmb_productstockno_ex.setVisible(true);

			} else if (source.equals(btn_okfornotification_ex)) {

				lbl_expiredate.setForeground(Color.WHITE);

				pan_stock_notification.setVisible(false);
				lbl_numofnotifiation.setForeground(Color.white);
				lbl_comment_ex.setText("Please check the folling product into stock");
				lbl_dangerousicon_ex.setVisible(true);
				btn_showproduct_ex.setVisible(true);
				btn_remindlater_ex.setVisible(true);
				lbl_numofnotifiation.setForeground(Color.white);
				lbl_itemname_ex.setVisible(false);
				lbl_subitemname_ex.setVisible(false);
				lbl_itemvalue_ex.setVisible(false);
				lbl_subitemvalue_ex.setVisible(false);
				btn_okfornotification_ex.setVisible(false);
				lbl_product_ex.setVisible(false);
				cmb_productstockno_ex.setVisible(false);

				//
				lbl_product_ex.setVisible(false);
				lbl_itemname_ex.setVisible(false);
				lbl_subitemname_ex.setVisible(false);
				lbl_itemvalue_ex.setVisible(false);

			} else if (source.equals(btn_remindlater_ex)) {
				pan_stock_notification.setVisible(false);
				lbl_expiredate.setForeground(Color.WHITE);

			} else if (source.equals(btn_okfornotification)) {
				pan_notification.setVisible(false);
				lbl_notification.setForeground(Color.white);
				lbl_comment.setText("Please check the folling product into stock");
				lbl_dangerousicon.setVisible(true);
				btn_showproduct.setVisible(true);
				btn_remindlater.setVisible(true);
				lbl_notification.setForeground(Color.white);
				lbl_itemname.setVisible(false);
				lbl_subitemname.setVisible(false);
				lbl_itemvalue.setVisible(false);
				lbl_subitemvalue.setVisible(false);
				btn_okfornotification.setVisible(false);
				lbl_product.setVisible(false);
				cmb_productstockno.setVisible(false);

				//
				lbl_product.setVisible(false);
				lbl_itemname.setVisible(false);
				lbl_subitemname.setVisible(false);
				lbl_itemvalue.setVisible(false);
				//

			} else if (source.equals(btn_upperkey)) {
				btn_downkey.setVisible(true);
				btn_left.setEnabled(true);
				second_last.start();

			} else if (source.equals(btn_downkey)) {
				first_last.start();
				btn_downkey.setVisible(false);
				btn_left.setEnabled(false);

			}

		}

	}

	class Action implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {

			lbl_expiredate.setForeground(Color.GREEN);
			pan_stock_notification.setVisible(true);
			pan_notification.setVisible(false);
			lbl_expiredatenum.setVisible(false);

			lbl_itemname_ex.setVisible(false);
			lbl_subitemname_ex.setVisible(false);
			lbl_itemvalue_ex.setVisible(false);
			lbl_subitemvalue_ex.setVisible(false);
			lbl_product_ex.setVisible(false);

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}
