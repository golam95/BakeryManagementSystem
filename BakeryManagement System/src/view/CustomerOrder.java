package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import Controller.Databaseconnect;
import Model.OrderInformation;

@SuppressWarnings("serial")
public class CustomerOrder extends JInternalFrame implements ActionListener, MouseListener {
	Connection conn;
	Databaseconnect connect = new Databaseconnect();

	SettingManu settings = new SettingManu();

	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	private JComboBox<String> cmb_customerId = new JComboBox<String>();
	//
	private JButton btn_daily = new JButton("Order");
	private JButton btn_emergencyorder = new JButton("Argent");
	private JButton btn_sellsreport = new JButton("Sells Report");
	private JButton btn_home = new JButton("Home");

	JDateChooser date = new JDateChooser();
	JLabel lbl_date = new JLabel("Date: ");
	private JButton btn_clear = new JButton("Clear");
	JPanel pan_details = new JPanel();
	JPanel pan_left = new JPanel();
	JPanel pan_right55 = new JPanel();
	JPanel pan_bottom = new JPanel();

	// for emergency form stock
	JPanel pan_emergencycombo = new JPanel();
	JPanel pan_erergencysearch = new JPanel();

	// for emergency order from stock

	JPanel pan_view_search = new JPanel();
	JPanel pan_viewinner1 = new JPanel();
	JPanel pan_viewinner2 = new JPanel();
	JPanel pan_viewinner3 = new JPanel();
	JPanel pan_viewinner4 = new JPanel();
	// fist shop id

	JLabel lbl_shopid = new JLabel("Search ShopID:");
	JLabel lbl_stock = new JLabel("Search product");
	JLabel lbl_serviceprovider = new JLabel("Search ServiceProvider");
	JLabel lbl_product = new JLabel("Product");
	JComboBox<String> cmb_stock = new JComboBox<String>();
	JComboBox<String> cmb_serviceprovider = new JComboBox<String>();
	private JComboBox<String> cmb_shopid = new JComboBox<String>();
	private JComboBox<String> cmb_productid = new JComboBox<String>();

	private JList<String> list_list = new JList<String>();
	private JList<String> list_list1 = new JList<String>();
	private JList<String> product_list = new JList<String>();

	// two

	JLabel lbl_shopkeppername = new JLabel("Shop keperName");
	JLabel lbl_suppliername = new JLabel("Supplier Name");
	JLabel lbl_productdes = new JLabel("product");
	JLabel lbl_quantitydes = new JLabel("Quantity");
	JLabel lbl_pricedes = new JLabel("price");
	JLabel lbl_discount = new JLabel("Discount");
	JLabel lbl_totalamount = new JLabel("Total Amount");
	JLabel lbl_paidamount = new JLabel("Paid Amount");
	JLabel lbl_monthid = new JLabel("MonthId");
	JLabel lbl_status = new JLabel("Status");
	JLabel lbl_employeetype = new JLabel("Type");
	JLabel lbl_productid = new JLabel("Order Id");
	JTextField txt_productid = new JTextField();

	JTextField txt_shopkeppername = new JTextField();
	JTextField txt_suppliername = new JTextField();
	JTextField txt_productdes = new JTextField();
	JTextField txt_quantitydes = new JTextField();
	JTextField txt_pricedes = new JTextField();
	JTextField txt_discount = new JTextField();
	JTextField txt_totalamount = new JTextField();
	JTextField txt_paidamount = new JTextField();
	JTextField txt_monthid = new JTextField();
	JComboBox<String> txt_status = new JComboBox<String>();

	JTextField txt_employeetype = new JTextField();

	//
	JButton btn_add = new JButton("Add");
	JButton btn_update = new JButton("Update");
	JButton btn_delete = new JButton("Delete");
	JTable tbl_order = new JTable();
	JScrollPane scroll_panel = new JScrollPane();
	//
	String shopname;

	String Servicename, type, shopid, serviceid, quantity, discount;
	String date_name, product, mounthid, status;
	String product_name, subproduct_name, expiredate, quantity_product, sellingprice, orderid;
	public static int record;

	String price, totalamount, painamount, product_id = "";

	//
	// view salses report// search
	JLabel lbl_search = new JLabel("Search By Date");
	JTextField txt_search = new JTextField();
	JButton btn_search = new JButton("Search");
	JLabel lbl_search1 = new JLabel("Search By Name");
	JTextField txt_search1 = new JTextField("sager");
	JButton btn_search1 = new JButton("Search");
	JLabel lbl_search3 = new JLabel("Search By Name");
	JTextField txt_search3 = new JTextField();
	JButton btn_search3 = new JButton("Search");

	// search
	JTextField txt_totalamount5 = new JTextField("T");
	JTextField txt_paidamount5 = new JTextField();
	JButton btn_addstock = new JButton("Add");
	JButton btn_calculate = new JButton("Save");
	JTextField txt_stock = new JTextField();
	JTextField txt_product = new JTextField();
	JTextField txt_month = new JTextField();
	@SuppressWarnings("rawtypes")
	JComboBox txt_stuts = new JComboBox();
	JTextField txt_orderid = new JTextField();
	JTextField txt_shoname = new JTextField();
	JTextField txt_servicename = new JTextField();
	JTextField txt_sptype = new JTextField();
	JTextField txt_subproductname = new JTextField();
	JTextField txt_missure = new JTextField();
	JTextField txt_price = new JTextField();
	JTextField txt_discount5 = new JTextField();
	JLabel lbl_totalamount5 = new JLabel("Total Amount");
	JLabel lbl_paidamount5 = new JLabel("Paid Amount");
	double i = 0.0, j = 0.0, k = 0.0;
	double x = 0.0, y = 0.0, z = 0.0, l = 0.0, m = 0.0, substruct = 0.0;
	String strdis = "", strdis1 = "", strdis2 = "";

	static Date td = new Date();
	static String sDate = DateFormat.getDateTimeInstance().format(td);

	//
	public static int track_counter1 = 0;
	public static int increment;
	String passingname;
	String logintype_track = "";

	@SuppressWarnings("unchecked")
	public CustomerOrder(JFrame getParentFrame, String username, String logintype) {
		super("Add Customer", true, true, true, true);
		this.setSize(1010, 550);

		JPanel pan = new JPanel();
		pan.setLayout(null);
		pan.setBounds(0, 0, 130, 850);

		passingname = username;// here we are passing the username using
		logintype_track = logintype; // parametter

		Border thickBorder = new LineBorder(Color.decode("#394B58"), 12);
		btn_daily.setBounds(20, 60, 80, 80);
		btn_daily.setBorder(thickBorder);
		btn_daily.setBackground(Color.decode("#250800"));
		btn_daily.setForeground(Color.WHITE);

		btn_emergencyorder.setBounds(20, 170, 80, 80);
		btn_emergencyorder.setBorder(thickBorder);
		btn_emergencyorder.setBackground(Color.decode("#250800"));
		btn_emergencyorder.setForeground(Color.WHITE);

		btn_sellsreport.setBounds(20, 280, 80, 80);
		btn_sellsreport.setBorder(thickBorder);
		btn_sellsreport.setBackground(Color.decode("#250800"));
		btn_sellsreport.setForeground(Color.WHITE);

		btn_home.setBounds(20, 390, 80, 80);
		btn_home.setBorder(thickBorder);
		btn_home.setBackground(Color.decode("#250800"));
		btn_home.setForeground(Color.WHITE);

		pan.add(btn_daily);
		pan.add(btn_emergencyorder);
		pan.add(btn_sellsreport);
		pan.add(btn_home);

		btn_daily.setToolTipText("Daily Order");
		btn_emergencyorder.setToolTipText("Emergency Order");
		btn_sellsreport.setToolTipText("Daily Order Report");
		btn_home.setToolTipText("Home");
		pan.setBackground(Color.decode("#D2DDF1"));
		btn_daily.addActionListener(this);
		btn_emergencyorder.addActionListener(this);
		btn_sellsreport.addActionListener(this);
		btn_home.addActionListener(this);

		btn_emergencyorder.setForeground(Color.WHITE);

		btn_home.setForeground(Color.WHITE);

		lbl_date.setBounds(1080, 10, 100, 30);
		date.setBounds(1140, 15, 160, 25);
		btn_clear.setBounds(690, 15, 140, 25);

		btn_clear.addActionListener(this);
		this.add(lbl_date);
		this.add(date);
		this.add(btn_clear);

		Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		pan_details.setBorder(raisedetched);
		pan_details.setBounds(200, 50, 1100, 500);
		pan_details.setLayout(null);

		TitledBorder reg_Border = BorderFactory.createTitledBorder("Search By ShopId");
		reg_Border.setTitleJustification(TitledBorder.LEFT);
		pan_left.setBorder(reg_Border);
		pan_left.setBounds(20, 20, 335, 240);
		pan_left.setLayout(null);

		//

		cmb_stock.addActionListener(this);
		retrive_product(cmb_stock);
		String service_stock = (String) cmb_stock.getSelectedItem();
		fill_form2(service_stock);
		lbl_shopid.setBounds(20, 25, 100, 30);
		lbl_stock.setBounds(20, 75, 100, 30);
		lbl_serviceprovider.setBounds(20, 125, 100, 30);
		cmb_shopid.setBounds(130, 25, 180, 30);
		cmb_stock.setBounds(130, 75, 180, 30);

		lbl_product.setBounds(20, 175, 180, 30);
		cmb_productid.setBounds(130, 175, 180, 30);
		cmb_productid.addActionListener(this);
		String product_service = (String) cmb_productid.getSelectedItem();
		fill_form3(product_service);
		retrive_product3(cmb_productid);

		cmb_serviceprovider.setBounds(130, 125, 180, 30);
		retrive_serviceprovider(cmb_serviceprovider);
		cmb_serviceprovider.addActionListener(this);
		String service_provider = (String) cmb_serviceprovider.getSelectedItem();
		fill_form(service_provider);

		cmb_shopid.addActionListener(this);

		retrive_customer(cmb_shopid);
		String str = (String) cmb_shopid.getSelectedItem();
		fill_form1(str);

		pan_left.add(lbl_serviceprovider);
		pan_left.add(cmb_serviceprovider);
		pan_left.add(lbl_stock);
		pan_left.add(cmb_stock);
		pan_left.add(lbl_shopid);
		pan_left.add(cmb_shopid);
		pan_left.add(lbl_product);
		pan_left.add(cmb_productid);

		pan_details.add(pan_left);

		TitledBorder add_details = BorderFactory.createTitledBorder("Order Description");
		reg_Border.setTitleJustification(TitledBorder.LEFT);
		pan_right55.setBorder(add_details);
		pan_right55.setBounds(365, 20, 700, 240);
		pan_right55.setLayout(null);

		list_list.setBounds(15, 20, 130, 200);
		pan_right55.add(list_list);// work starting ???????????????????????
		list_list.setBackground(Color.gray);

		lbl_shopkeppername.setBounds(165, 15, 120, 40);
		lbl_suppliername.setBounds(165, 50, 120, 40);
		lbl_productdes.setBounds(165, 85, 120, 40);
		lbl_quantitydes.setBounds(165, 120, 120, 40);
		lbl_pricedes.setBounds(165, 155, 120, 40);
		lbl_discount.setBounds(165, 190, 120, 40);

		lbl_totalamount.setBounds(430, 15, 120, 40);
		lbl_paidamount.setBounds(430, 50, 120, 40);
		lbl_monthid.setBounds(430, 85, 120, 40);
		lbl_status.setBounds(430, 120, 120, 40);
		txt_employeetype.setBounds(550, 158, 120, 25);
		lbl_employeetype.setBounds(430, 153, 120, 40);
		tbl_order.addMouseListener(this);

		lbl_productid.setBounds(430, 186, 120, 40);
		txt_productid.setBounds(550, 191, 120, 25);

		pan_right55.add(lbl_productid);
		pan_right55.add(txt_productid);

		pan_right55.add(txt_employeetype);
		pan_right55.add(lbl_employeetype);

		txt_totalamount.setBounds(550, 20, 120, 25);
		txt_paidamount.setBounds(550, 55, 120, 25);
		txt_monthid.setBounds(550, 90, 120, 25);
		txt_status.setBounds(550, 125, 120, 25);

		btn_add.setBounds(600, 518, 80, 20);
		btn_update.setBounds(700, 518, 80, 20);
		btn_delete.setBounds(800, 518, 80, 20);

		this.add(btn_update);
		this.add(btn_delete);
		this.add(btn_add);

		pan_right55.add(lbl_totalamount);
		pan_right55.add(lbl_paidamount);
		pan_right55.add(lbl_monthid);
		pan_right55.add(lbl_status);

		pan_right55.add(txt_totalamount);
		pan_right55.add(txt_paidamount);
		pan_right55.add(txt_monthid);
		pan_right55.add(txt_status);

		btn_add.addActionListener(this);
		btn_update.addActionListener(this);
		btn_delete.addActionListener(this);

		txt_shopkeppername.setBounds(285, 20, 120, 25);
		txt_suppliername.setBounds(285, 55, 120, 25);
		txt_productdes.setBounds(285, 90, 120, 25);
		txt_quantitydes.setBounds(285, 125, 120, 25);
		txt_pricedes.setBounds(285, 160, 120, 25);
		txt_discount.setBounds(285, 195, 120, 25);

		pan_right55.add(txt_shopkeppername);
		pan_right55.add(txt_suppliername);
		pan_right55.add(txt_productdes);
		pan_right55.add(txt_quantitydes);
		pan_right55.add(txt_pricedes);
		pan_right55.add(txt_discount);
		txt_status.addItem("Due");
		txt_status.addItem("Full Paid");
		txt_stuts.addItem("Due");
		txt_stuts.addItem("Full Paid");

		pan_right55.add(lbl_productdes);
		pan_right55.add(lbl_quantitydes);
		pan_right55.add(lbl_pricedes);
		pan_right55.add(lbl_discount);
		pan_right55.add(lbl_suppliername);
		pan_right55.add(lbl_shopkeppername);

		pan_details.add(pan_right55);// ]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]

		TitledBorder add_table = BorderFactory.createTitledBorder("");
		add_table.setTitleJustification(TitledBorder.LEFT);
		pan_bottom.setBorder(add_table);
		pan_bottom.setBounds(20, 270, 1060, 220);
		pan_bottom.setLayout(null);

		tbl_order.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Order_Id", "Shop_Id", "Shopkeper_Name", "Service_Id", "Name", "ProductId", "products",
						"Quantity", "price", "Discount", "Total_amount", "Paid_Amount", "Month_id", "Status",
						"Date" }));
		scroll_panel.setViewportView(tbl_order);
		pan_bottom.add(scroll_panel);
		pan_bottom.setLayout(new GridLayout(0, 1));
		pan_details.add(pan_bottom);

		TitledBorder add_combo = BorderFactory.createTitledBorder("Search Product");
		add_combo.setTitleJustification(TitledBorder.LEFT);
		pan_emergencycombo.setBorder(add_combo);
		pan_emergencycombo.setBounds(380, 20, 400, 240);
		pan_emergencycombo.setLayout(null);
		JLabel lbl_shoname = new JLabel("S.K.Name");// new attribute add current
		JLabel lbl_servicename = new JLabel("S.P.Name");
		JLabel lbl_subproductname = new JLabel("Sub.P.Name");
		JLabel lbl_missure = new JLabel("Quantity");
		JLabel lbl_price = new JLabel("Price");
		JLabel lbl_discount = new JLabel("Discount");

		JLabel lbl_stock = new JLabel("Stock");
		JLabel lbl_product = new JLabel("Sub.P.Name");
		JLabel lbl_month = new JLabel("MonthId");
		JLabel lbl_sptype = new JLabel("S.P.Type");
		JLabel lbl_stuts = new JLabel("Status");
		JLabel lbl_orderid = new JLabel("OrderId");

		lbl_paidamount5.setBounds(780, 518, 100, 20);

		btn_addstock.addActionListener(this);
		btn_addstock.setBounds(985, 518, 80, 20);

		btn_calculate.setBounds(1100, 518, 80, 20);
		btn_calculate.addActionListener(this);
		lbl_totalamount5.setBounds(570, 518, 80, 20);
		this.add(btn_calculate);
		this.add(lbl_totalamount5);
		this.add(lbl_paidamount5);
		txt_totalamount5.setBounds(660, 518, 100, 20);
		txt_paidamount5.setBounds(870, 518, 100, 20);
		this.add(txt_totalamount5);
		this.add(txt_paidamount5);
		this.add(btn_addstock);

		lbl_shoname.setBounds(10, 15, 80, 30);
		lbl_servicename.setBounds(10, 50, 80, 30);
		lbl_subproductname.setBounds(10, 85, 80, 30);
		lbl_missure.setBounds(10, 120, 80, 30);
		lbl_price.setBounds(10, 155, 80, 30);
		lbl_discount.setBounds(10, 190, 80, 30);

		lbl_stock.setBounds(210, 15, 80, 30);
		lbl_product.setBounds(210, 50, 80, 30);
		lbl_month.setBounds(210, 85, 80, 30);
		lbl_sptype.setBounds(210, 120, 80, 30);
		lbl_stuts.setBounds(210, 155, 80, 30);
		lbl_orderid.setBounds(210, 190, 80, 30);

		txt_stock.setBounds(290, 20, 100, 25);
		txt_product.setBounds(290, 55, 100, 25);
		txt_month.setBounds(290, 90, 100, 25);
		txt_sptype.setBounds(290, 125, 100, 25);
		txt_stuts.setBounds(290, 160, 100, 25);
		txt_orderid.setBounds(290, 195, 100, 25);

		pan_emergencycombo.add(txt_stock);
		pan_emergencycombo.add(txt_product);
		pan_emergencycombo.add(txt_month);
		pan_emergencycombo.add(txt_sptype);
		pan_emergencycombo.add(txt_stuts);
		pan_emergencycombo.add(txt_orderid);

		pan_emergencycombo.add(lbl_stock);
		pan_emergencycombo.add(lbl_product);
		pan_emergencycombo.add(lbl_month);
		pan_emergencycombo.add(lbl_sptype);
		pan_emergencycombo.add(lbl_stuts);
		pan_emergencycombo.add(lbl_orderid);

		// lbl_stock.setBounds(10, 255, 80, 30);

		txt_shoname.setBounds(100, 20, 100, 25);
		txt_servicename.setBounds(100, 55, 100, 25);
		txt_subproductname.setBounds(100, 90, 100, 25);
		txt_missure.setBounds(100, 125, 100, 25);
		txt_price.setBounds(100, 160, 100, 25);
		txt_discount5.setBounds(100, 195, 100, 25);

		pan_emergencycombo.add(lbl_shoname);
		pan_emergencycombo.add(lbl_servicename);
		pan_emergencycombo.add(lbl_subproductname);
		pan_emergencycombo.add(lbl_missure);
		pan_emergencycombo.add(lbl_price);
		pan_emergencycombo.add(lbl_discount);
		pan_emergencycombo.add(lbl_stock);

		pan_emergencycombo.add(txt_shoname);
		pan_emergencycombo.add(txt_servicename);
		pan_emergencycombo.add(txt_subproductname);
		pan_emergencycombo.add(txt_missure);
		pan_emergencycombo.add(txt_price);
		pan_emergencycombo.add(txt_discount5);

		pan_details.add(pan_emergencycombo);

		TitledBorder add_aftersearch = BorderFactory.createTitledBorder("Product Description");
		add_aftersearch.setTitleJustification(TitledBorder.LEFT);
		pan_erergencysearch.setBorder(add_aftersearch);
		pan_erergencysearch.setBounds(790, 20, 290, 240);
		pan_erergencysearch.setLayout(null);
		JLabel lbl_s = new JLabel("Stock");
		JLabel lbl_P = new JLabel("Product");
		lbl_s.setBounds(55, 10, 50, 30);
		lbl_P.setBounds(175, 10, 50, 30);
		list_list1.setBounds(10, 40, 130, 190);

		product_list.setBounds(149, 40, 130, 190);

		product_list.setBackground(Color.gray);
		pan_erergencysearch.add(list_list1);
		pan_erergencysearch.add(product_list);
		pan_erergencysearch.add(lbl_s);
		pan_erergencysearch.add(lbl_P);

		pan_details.add(pan_erergencysearch);

		TitledBorder add_searview = BorderFactory.createTitledBorder("Search Customer Order");
		add_searview.setTitleJustification(TitledBorder.LEFT);
		pan_view_search.setBorder(add_searview);
		pan_view_search.setBounds(20, 20, 1060, 140);
		pan_view_search.setLayout(null);
		pan_details.add(pan_view_search);

		TitledBorder add_internalserarch = BorderFactory.createTitledBorder("Search By Date");
		add_internalserarch.setTitleJustification(TitledBorder.LEFT);
		pan_viewinner1.setBorder(add_internalserarch);
		pan_viewinner1.setBounds(70, 30, 300, 87);
		pan_viewinner1.setLayout(null);

		lbl_search.setBounds(10, 30, 100, 20);
		txt_search.setBounds(103, 30, 100, 25);
		btn_search.setBounds(212, 30, 80, 25);
		btn_search.addActionListener(this);
		btn_search1.addActionListener(this);
		btn_search3.addActionListener(this);

		pan_viewinner1.add(lbl_search);
		pan_viewinner1.add(txt_search);
		pan_viewinner1.add(btn_search);

		pan_view_search.add(pan_viewinner1);

		TitledBorder add_internalserarch1 = BorderFactory.createTitledBorder("Search By ID");
		add_internalserarch1.setTitleJustification(TitledBorder.LEFT);
		pan_viewinner2.setBorder(add_internalserarch1);
		pan_viewinner2.setBounds(380, 30, 300, 87);
		pan_viewinner2.setLayout(null);

		lbl_search1.setBounds(10, 30, 100, 20);
		txt_search1.setBounds(103, 30, 100, 25);
		btn_search1.setBounds(212, 30, 80, 25);

		pan_viewinner2.add(lbl_search1);
		pan_viewinner2.add(txt_search1);
		pan_viewinner2.add(btn_search1);

		pan_view_search.add(pan_viewinner2);

		TitledBorder add_internalserarch2 = BorderFactory.createTitledBorder("Search By Name");
		add_internalserarch2.setTitleJustification(TitledBorder.LEFT);
		pan_viewinner3.setBorder(add_aftersearch);
		pan_viewinner3.setBounds(690, 30, 300, 87);
		pan_viewinner3.setLayout(null);

		lbl_search3.setBounds(10, 30, 100, 20);
		txt_search3.setBounds(103, 30, 100, 25);
		btn_search3.setBounds(212, 30, 80, 25);

		pan_viewinner3.add(lbl_search3);
		pan_viewinner3.add(txt_search3);
		pan_viewinner3.add(btn_search3);

		pan_view_search.add(pan_viewinner3);
		this.add(pan_details);
		this.setLayout(null);
		this.add(pan);
		this.setLocation(screenheith / 7, screedwidth / 27);
		click_order();// create a object or method
		Show_productreceivemod();
		settings.Numvalidator1(txt_shopkeppername);
		settings.Numvalidator1(txt_suppliername);
		settings.Numvalidator(txt_pricedes);
		settings.Numvalidator(txt_discount);
		settings.Numvalidator(txt_totalamount);
		settings.Numvalidator(txt_paidamount);
		settings.Numvalidator(txt_totalamount5);
		settings.Numvalidator(txt_paidamount5);
		settings.Numvalidator(txt_stock);
		settings.Numvalidator(txt_price);
		settings.Numvalidator(txt_discount5);
		settings.Numvalidator1(txt_productdes);
		settings.Numvalidator(txt_quantitydes);
		settings.Numvalidator1(txt_servicename);
		settings.Numvalidator1(txt_subproductname);
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

	public void executeSQlQuery_customerOrder(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {

				DefaultTableModel model = (DefaultTableModel) tbl_order.getModel();
				model.setRowCount(0);
				Show_productreceivemod();// get the tabel
				click_reset();
				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");

			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void executeSQlQuery_history(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {

			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void onlyupdate(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {

			} else {
				JOptionPane.showMessageDialog(null, "Something Wrong" + message);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// get a list of users from mysql database
	public ArrayList<OrderInformation> receiveorderinfo() {
		ArrayList<OrderInformation> usersList = new ArrayList<OrderInformation>();
		Connection connection = getConnection();
		String query = "SELECT * FROM  `customerorder`";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			OrderInformation user;
			while (rs.next()) {
				user = new OrderInformation(rs.getInt("orderid"), rs.getInt("shopid"), rs.getString("shopname"),
						rs.getInt("serviceid"), rs.getString("servicename"), rs.getInt("productid"),
						rs.getString("product"), rs.getInt("quantity"), rs.getDouble("price"), rs.getInt("discount"),
						rs.getDouble("totalamount"), rs.getDouble("painamount"), rs.getString("monthid"),
						rs.getString("status"), rs.getString("date"));

				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	// Display Data In JTable

	public void Show_productreceivemod() {
		ArrayList<OrderInformation> list = receiveorderinfo();
		DefaultTableModel model = (DefaultTableModel) tbl_order.getModel();
		Object[] row = new Object[15];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getOrderid();
			row[1] = list.get(i).getShopid();
			row[2] = list.get(i).getShopname();
			row[3] = list.get(i).getServiceid();
			row[4] = list.get(i).getServicename();
			row[5] = list.get(i).getProductid();
			row[6] = list.get(i).getProduct();
			row[7] = list.get(i).getQuantity();
			row[8] = list.get(i).getPrice();
			row[9] = list.get(i).getDiscount();
			row[10] = list.get(i).getTotalamount();
			row[11] = list.get(i).getPaidamount();
			row[12] = list.get(i).getMonthid();
			row[13] = list.get(i).getStatus();
			row[14] = list.get(i).getDate();
			model.addRow(row);
		}
	}

	// ===============================

	public ArrayList<OrderInformation> List_wa_Order1(String search) {// warehouse
																		// emp
		ArrayList<OrderInformation> usersList = new ArrayList<OrderInformation>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `customerorder` WHERE CONCAT(`orderid`, `shopid`, `shopname`, `serviceid`,`servicename`,`productid`,`product`,`quantity`,`price`,`discount`,`totalamount`,`painamount`,`monthid`,`status`,`date`) LIKE '%"
					+ search + "%'";
			rs = st.executeQuery(searchQuery);

			OrderInformation user;

			while (rs.next()) {
				user = new OrderInformation(rs.getInt("orderid"), rs.getInt("shopid"), rs.getString("shopname"),
						rs.getInt("serviceid"), rs.getString("servicename"), rs.getInt("productid"),
						rs.getString("product"), rs.getInt("quantity"), rs.getDouble("price"), rs.getInt("discount"),
						rs.getDouble("totalamount"), rs.getDouble("painamount"), rs.getString("monthid"),
						rs.getString("status"), rs.getString("date"));
				usersList.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	public void find_customerorder1() {
		ArrayList<OrderInformation> list = List_wa_Order1(txt_search.getText());// asdjflasjdf;lja;lkdsfjl;k
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(
				new Object[] { "Order_Id", "Shop_Id", "Shopkeper_Name", "Service_Id", "Name", "ProductId", "products",
						"Quantity", "price", "Discount", "Total_amount", "Paid_Amount", "Month_id", "Status", "Date" });
		Object[] row = new Object[15];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getOrderid();
			row[1] = list.get(i).getShopid();
			row[2] = list.get(i).getShopname();
			row[3] = list.get(i).getServiceid();
			row[4] = list.get(i).getServicename();
			row[5] = list.get(i).getProductid();
			row[6] = list.get(i).getProduct();
			row[7] = list.get(i).getQuantity();
			row[8] = list.get(i).getPrice();
			row[9] = list.get(i).getDiscount();
			row[10] = list.get(i).getTotalamount();
			row[11] = list.get(i).getPaidamount();
			row[12] = list.get(i).getMonthid();
			row[13] = list.get(i).getStatus();
			row[14] = list.get(i).getDate();
			model.addRow(row);
		}
		tbl_order.setModel(model);

	}

	public ArrayList<OrderInformation> List_wa_Order3(String search) {// warehouse
		// emp
		ArrayList<OrderInformation> usersList = new ArrayList<OrderInformation>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `customerorder` WHERE CONCAT(`orderid`, `shopid`, `shopname`, `serviceid`,`servicename`,`productid`,`product`,`quantity`,`price`,`discount`,`totalamount`,`painamount`,`monthid`,`status`,`date`) LIKE '%"
					+ search + "%'";
			rs = st.executeQuery(searchQuery);

			OrderInformation user;

			while (rs.next()) {
				user = new OrderInformation(rs.getInt("orderid"), rs.getInt("shopid"), rs.getString("shopname"),
						rs.getInt("serviceid"), rs.getString("servicename"), rs.getInt("productid"),
						rs.getString("product"), rs.getInt("quantity"), rs.getDouble("price"), rs.getInt("discount"),
						rs.getDouble("totalamount"), rs.getDouble("painamount"), rs.getString("monthid"),
						rs.getString("status"), rs.getString("date"));
				usersList.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	public void find_customerorder3() {
		ArrayList<OrderInformation> list = List_wa_Order3(txt_search3.getText());// asdjflasjdf;lja;lkdsfjl;k
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(
				new Object[] { "Order_Id", "Shop_Id", "Shopkeper_Name", "Service_Id", "Name", "ProductId", "products",
						"Quantity", "price", "Discount", "Total_amount", "Paid_Amount", "Month_id", "Status", "Date" });
		Object[] row = new Object[15];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getOrderid();
			row[1] = list.get(i).getShopid();
			row[2] = list.get(i).getShopname();
			row[3] = list.get(i).getServiceid();
			row[4] = list.get(i).getServicename();
			row[5] = list.get(i).getProductid();
			row[6] = list.get(i).getProduct();
			row[7] = list.get(i).getQuantity();
			row[8] = list.get(i).getPrice();
			row[9] = list.get(i).getDiscount();
			row[10] = list.get(i).getTotalamount();
			row[11] = list.get(i).getPaidamount();
			row[12] = list.get(i).getMonthid();
			row[13] = list.get(i).getStatus();
			row[14] = list.get(i).getDate();
			model.addRow(row);
		}
		tbl_order.setModel(model);

	}

	public ArrayList<OrderInformation> List_wa_Order(String searchemp_regine) {// warehouse
		// emp
		ArrayList<OrderInformation> usersList = new ArrayList<OrderInformation>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `customerorder` WHERE CONCAT(`orderid`, `shopid`, `shopname`, `serviceid`,`servicename`,`productid`,`product`,`quantity`,`price`,`discount`,`totalamount`,`painamount`,`monthid`,`status`,`date`) LIKE '%"
					+ searchemp_regine + "%'";
			rs = st.executeQuery(searchQuery);

			OrderInformation user;

			while (rs.next()) {
				user = new OrderInformation(rs.getInt("orderid"), rs.getInt("shopid"), rs.getString("shopname"),
						rs.getInt("serviceid"), rs.getString("servicename"), rs.getInt("productid"),
						rs.getString("product"), rs.getInt("quantity"), rs.getDouble("price"), rs.getInt("discount"),
						rs.getDouble("totalamount"), rs.getDouble("painamount"), rs.getString("monthid"),
						rs.getString("status"), rs.getString("date"));
				usersList.add(user);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	public void find_customerorder() {
		ArrayList<OrderInformation> list = List_wa_Order(txt_search1.getText());// asdjflasjdf;lja;lkdsfjl;k
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(
				new Object[] { "Order_Id", "Shop_Id", "Shopkeper_Name", "Service_Id", "Name", "ProductId", "products",
						"Quantity", "price", "Discount", "Total_amount", "Paid_Amount", "Month_id", "Status", "Date" });
		Object[] row = new Object[15];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getOrderid();
			row[1] = list.get(i).getShopid();
			row[2] = list.get(i).getShopname();
			row[3] = list.get(i).getServiceid();
			row[4] = list.get(i).getServicename();
			row[5] = list.get(i).getProductid();
			row[6] = list.get(i).getProduct();
			row[7] = list.get(i).getQuantity();
			row[8] = list.get(i).getPrice();
			row[9] = list.get(i).getDiscount();
			row[10] = list.get(i).getTotalamount();
			row[11] = list.get(i).getPaidamount();
			row[12] = list.get(i).getMonthid();
			row[13] = list.get(i).getStatus();
			row[14] = list.get(i).getDate();
			model.addRow(row);
		}
		tbl_order.setModel(model);

	}

	// ================================

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(btn_daily)) {
			click_order();
		} else if (source.equals(btn_emergencyorder)) {
			click_emergencyorder();
		} else if (source.equals(btn_sellsreport)) {
			click_view();
		} else if (source.equals(btn_home)) {
			click_home();
		} else if (source.equals(btn_clear)) {
			click_reset();

			// } else if (source.equals(btn_sum)) {
			// try {
			// Statement stmt = conn.createStatement();
			// String sql = "Select sum(price)from customerorder where
			// status='Due'";
			// // PreparedStatement statement = con.prepareStatement("select
			// // sum(total) from orders where status='Q' AND WEEK(date) =
			// // WEEK(CURDATE()) AND YEAR(date) = YEAR(CURDATE())");
			// ResultSet rs = stmt.executeQuery(sql);
			// if (rs.next()) {
			// String sum = rs.getString("sum(price)");
			// txt_sum.setText(sum);
			//
			// }
			//
			// } catch (Exception ex) {
			// JOptionPane.showMessageDialog(null, ex);
			//
			// }

		} else if (source.equals(btn_add)) {
			add_information();
		} else if (source.equals(btn_update)) {
			update_information();
		} else if (source.equals(btn_delete)) {
			delte_information();
		} else if (source.equals(cmb_serviceprovider)) {
			String service_provider = (String) cmb_serviceprovider.getSelectedItem().toString();
			fill_form(service_provider);
		} else if (source.equals(cmb_shopid)) {
			String str = (String) cmb_shopid.getSelectedItem();
			fill_form1(str);

		} else if (source.equals(cmb_stock)) {
			String service_stock = (String) cmb_stock.getSelectedItem();
			fill_form2(service_stock);

		} else if (source.equals(btn_search)) {

			find_customerorder1();

		} else if (source.equals(btn_search1)) {
			find_customerorder();

		} else if (source.equals(btn_search3)) {
			find_customerorder3();
		} else if (source.equals(cmb_productid)) {

			String product_service = (String) cmb_productid.getSelectedItem();
			fill_form3(product_service);

		} else if (source.equals(btn_addstock)) {
			addstockinformaton();

		} else if (source.equals(btn_calculate)) {
			addstock_calculation();

		}

	}

	public void addstock_calculation() {
		if (txt_stock.getText().equals("") || txt_price.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "The Record Field Is Blank");
		} else {
			if (txt_discount5.getText().contentEquals("0") == true) {
				l = Double.parseDouble(txt_missure.getText());
				i = Double.parseDouble(txt_stock.getText());
				j = Double.parseDouble(txt_price.getText());
				if (l >= i) {
					substruct = l - i;
					strdis2 = Double.toString(substruct);
					txt_missure.setText(strdis2);

					String temp = "UPDATE rec_product SET " + "quantity = '" + txt_missure.getText().toString() + "'"
							+ "WHERE receivedId = '" + cmb_stock.getSelectedItem().toString() + "'";
					onlyupdate(temp, "Updated");

				} else {
					JOptionPane.showMessageDialog(null, "The product is out of Stock");
				}

				k = i * j;
				strdis = Double.toString(k);
				txt_totalamount5.setText(strdis);

			} else {
				x = Double.parseDouble(txt_discount5.getText());
				y = Double.parseDouble(txt_stock.getText());
				z = Double.parseDouble(txt_price.getText());
				l = (y * z) / x;
				strdis1 = Double.toString(l);
				txt_totalamount5.setText(strdis1);
			}
		}
	}

	public void addstockinformaton() {
		SimpleDateFormat f3 = new SimpleDateFormat("yyyy-MM-dd");
		if (txt_stock.getText().equals("") || txt_product.getText().equals("") || txt_orderid.getText().equals("")
				|| txt_shoname.getText().equals("") || txt_servicename.getText().equals("")
				|| txt_sptype.getText().equals("") || txt_missure.getText().equals("") || txt_price.getText().equals("")
				|| txt_discount5.getText().equals("") || txt_month.getText().equals("")
				|| txt_paidamount5.getText().equals("") || txt_totalamount.getText().equals("")) {

			orderid = "";
			shopid = "";
			shopname = "";
			serviceid = "";
			Servicename = "";
			date_name = "";
			product = "";
			quantity = "";
			price = "";
			discount = "";
			totalamount = "";
			painamount = "";
			mounthid = "";
			status = "";
			product_id = "";
			// cmb_productid
			record += 1;
			orderid = "" + record;

			shopid = cmb_shopid.getSelectedItem().toString();
			shopname = txt_shoname.getText().toString();

			String str = txt_shoname.getText().toString();// shop name brow

			serviceid = cmb_serviceprovider.getSelectedItem().toString();
			Servicename = txt_servicename.getText().toString();
			product_id = txt_productid.getText().toString();
			product = txt_subproductname.getText().toString();
			quantity = txt_missure.getText().trim();
			price = (txt_price.getText().trim());
			discount = (txt_discount5.getText().trim());
			totalamount = (txt_totalamount5.getText().trim());
			painamount = (txt_paidamount5.getText().trim());
			mounthid = txt_month.getText().toString();

			status = txt_stuts.getSelectedItem().toString();

			if (date.getDate() == null) {
				JOptionPane.showMessageDialog(null, "The date field id Blank!!");
			} else {
				date_name = f3.format(date.getDate());
			}
			//
			// String querey = "INSERT INTO customerorder VALUES ('" + orderid +
			// "','" + shopid + "','" + shopname + "','"
			// + serviceid + "','" + Servicename + "','" + product_id + "','" +
			// product + "','" + quantity + "','"
			// + price + "','" + discount + "','" + totalamount + "','" +
			// painamount + "','" + mounthid + "','"
			// + status + "','" + date_name + "')";

			String querey = "INSERT INTO customerorder(shopid,shopname,serviceid,servicename,productid,product,quantity,price,discount,totalamount,painamount,monthid,status,date) VALUES ('"
					+ shopid + "','" + shopname + "','" + serviceid + "','" + Servicename + "','" + product_id + "','"
					+ product + "','" + quantity + "','" + price + "','" + discount + "','" + totalamount + "','"
					+ painamount + "','" + mounthid + "','" + status + "','" + date_name + "')";

			executeSQlQuery_customerOrder(querey, "Add");//// here courn
			track_counter1++;
			if (track_counter1 > 0 && logintype_track.contentEquals("Onwer") == false) {
				String quer = "INSERT INTO history(track_name,issue_name,create_date,status) VALUES ('" + passingname
						+ "','" + str + "','" + sDate + "','" + "Add Emergencey Order" + "')";
				executeSQlQuery_history(quer, "Add");
				System.out.println(passingname);

			}

		} else {
			JOptionPane.showMessageDialog(null, "Not insert");

		}
	}

	public void add_information() {
		SimpleDateFormat f3 = new SimpleDateFormat("yyyy-MM-dd");
		orderid = "";
		shopid = "";
		shopname = "";
		serviceid = "";
		Servicename = "";
		date_name = "";
		product = "";
		quantity = "";
		price = "";
		discount = "";
		totalamount = "";
		painamount = "";
		mounthid = "";
		status = "";
		product_id = "";

		record += 1;
		orderid = "" + record;
		shopid = cmb_shopid.getSelectedItem().toString();

		shopname = txt_shopkeppername.getText().toString();

		String str = txt_shopkeppername.getText().toString();// so what

		serviceid = cmb_serviceprovider.getSelectedItem().toString();
		Servicename = txt_suppliername.getText().toString();
		product_id = txt_productid.getText().toString();
		product = txt_productdes.getText().toString();

		quantity = txt_quantitydes.getText().trim();
		price = (txt_pricedes.getText().trim());
		discount = (txt_discount.getText().trim());
		totalamount = (txt_totalamount.getText().trim());
		painamount = (txt_paidamount.getText().trim());
		mounthid = txt_monthid.getText().toString();
		status = txt_status.getSelectedItem().toString();
		if (date.getDate() == null) {
			JOptionPane.showMessageDialog(null, "The date field id Blank!!");
		} else {
			date_name = f3.format(date.getDate());
		}

		String querey = "INSERT INTO customerorder(shopid,shopname,serviceid,servicename,productid,product,quantity,price,discount,totalamount,painamount,monthid,status,date) VALUES ('"
				+ shopid + "','" + shopname + "','" + serviceid + "','" + Servicename + "','" + product_id + "','"
				+ product + "','" + quantity + "','" + price + "','" + discount + "','" + totalamount + "','"
				+ painamount + "','" + mounthid + "','" + status + "','" + date_name + "')";

		// String quer = "INSERT INTO
		// customerorder(shopid,shopname,serviceid,servicename,productid,product,quantity,price,discount,totalamount,painamount,monthid,status,date)
		// VALUES ('" + passingname + "','"
		// + str + "','" + sDate + "','" + "Add customer Information" + "')";

		executeSQlQuery_customerOrder(querey, "Add");
		track_counter1++;
		if (track_counter1 > 0 && logintype_track.contentEquals("Onwer") == false) {

			String quer = "INSERT INTO history(track_name,issue_name,create_date,status) VALUES ('" + passingname
					+ "','" + str + "','" + sDate + "','" + "Add customer Order" + "')";

			executeSQlQuery_history(quer, "Add");

		}

	}

	public void update_information() {// history is done
		SimpleDateFormat f3 = new SimpleDateFormat("yyyy-MM-dd");
		orderid = "";
		shopid = "";
		shopname = "";
		serviceid = "";
		Servicename = "";
		date_name = "";
		product = "";
		quantity = "";
		price = "";
		discount = "";
		totalamount = "";
		painamount = "";
		mounthid = "";
		status = "";
		product_id = "";

		orderid = txt_employeetype.getText().toString();

		String track_update = txt_employeetype.getText().toString();

		shopid = cmb_shopid.getSelectedItem().toString();
		shopname = txt_shopkeppername.getText().toString();
		serviceid = cmb_serviceprovider.getSelectedItem().toString();
		Servicename = txt_suppliername.getText().toString();
		product_id = txt_productid.getText().toString();
		product = txt_productdes.getText().toString();
		quantity = txt_quantitydes.getText().trim();
		price = (txt_pricedes.getText().trim());
		discount = (txt_discount.getText().trim());
		totalamount = (txt_totalamount.getText().trim());
		painamount = (txt_paidamount.getText().trim());
		mounthid = txt_monthid.getText().toString();
		status = txt_status.getSelectedItem().toString();
		if (date.getDate() == null) {
			JOptionPane.showMessageDialog(null, "The date field id Blank!!");
		} else {
			date_name = f3.format(date.getDate());
		}

		String temp = "UPDATE customerorder SET " + "orderid = '" + orderid + "',shopid = '" + shopid + "',shopname = '"
				+ shopname + "',serviceid = '" + serviceid + "',servicename = '" + Servicename + "',productid = '"
				+ product_id + "',product = '" + product + "',quantity = '" + quantity + "',price = '" + price
				+ "',discount = '" + discount + "',totalamount = '" + totalamount + "',painamount = '" + painamount
				+ "',monthid = '" + mounthid + "',status = '" + mounthid + "',date = '" + date_name + "'"
				+ "WHERE orderid = '" + orderid + "'";

		executeSQlQuery_customerOrder(temp, "Updated");

		track_counter1++;

		if (track_counter1 > 0 && logintype_track.contentEquals("Onwer") == false) {
			String querey = "INSERT INTO history(track_name,issue_name,create_date,status) VALUES ('" + passingname
					+ "','" + track_update + "','" + sDate + "','" + "Update Order Information" + "')";
			executeSQlQuery_history(querey, "Add");

		}

	}

	public void delte_information() {// done by history
		orderid = "";
		orderid = txt_employeetype.getText().trim();
		String str = txt_employeetype.getText().trim();
		String query = "DELETE FROM `customerorder` WHERE orderid = " + orderid;
		executeSQlQuery_customerOrder(query, "Deleted Record!!");
		track_counter1++;

		if (track_counter1 > 0 && logintype_track.contentEquals("Onwer") == false) {
			String querey = "INSERT INTO history(track_name,issue_name,create_date,status) VALUES ('" + passingname
					+ "','" + str + "','" + sDate + "','" + "Delete Order Information" + "')";
			executeSQlQuery_history(querey, "Add");

		}

	}

	public void click_order() {
		try {
			btn_calculate.setVisible(false);
			txt_totalamount5.setVisible(false);
			txt_paidamount5.setVisible(false);
			btn_addstock.setVisible(false);
			lbl_totalamount5.setVisible(false);
			lbl_paidamount5.setVisible(false);

			pan_left.setVisible(true);
			pan_bottom.setVisible(true);
			pan_right55.setVisible(true);
			pan_bottom.setBounds(20, 270, 1060, 185);
			pan_emergencycombo.setVisible(false);
			pan_erergencysearch.setVisible(false);
			pan_view_search.setVisible(false);
			btn_update.setVisible(true);
			btn_delete.setVisible(true);
			btn_add.setVisible(true);
			cmb_productid.setVisible(false);

			lbl_totalamount.setVisible(true);
			txt_totalamount.setVisible(true);

			cmb_shopid.setBounds(130, 50, 180, 30);
			cmb_stock.setBounds(130, 110, 180, 30);
			cmb_serviceprovider.setBounds(130, 170, 180, 30);
			lbl_shopid.setBounds(20, 50, 100, 30);
			lbl_stock.setBounds(20, 110, 100, 30);
			lbl_serviceprovider.setBounds(20, 170, 100, 30);
			lbl_product.setVisible(false);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error Click view" + ex.toString());

		}
	}

	public void click_emergencyorder() {
		try {
			btn_calculate.setVisible(true);
			txt_totalamount5.setVisible(true);
			txt_paidamount5.setVisible(true);
			btn_addstock.setVisible(true);
			lbl_totalamount5.setVisible(true);
			lbl_paidamount5.setVisible(true);

			pan_bottom.setBounds(20, 270, 1060, 180);
			pan_left.setVisible(true);
			pan_emergencycombo.setVisible(true);
			pan_erergencysearch.setVisible(true);
			pan_bottom.setVisible(true);
			pan_right55.setVisible(false);
			pan_view_search.setVisible(false);
			btn_update.setVisible(false);
			btn_delete.setVisible(false);
			btn_add.setVisible(false);
			//
			lbl_totalamount.setVisible(true);
			txt_totalamount.setVisible(true);
			//
			lbl_shopid.setBounds(20, 25, 100, 30);
			lbl_stock.setBounds(20, 75, 100, 30);
			lbl_serviceprovider.setBounds(20, 125, 100, 30);
			cmb_shopid.setBounds(130, 25, 180, 30);
			cmb_stock.setBounds(130, 75, 180, 30);
			lbl_product.setBounds(20, 175, 180, 30);
			cmb_productid.setBounds(130, 175, 180, 30);
			cmb_serviceprovider.setBounds(130, 125, 180, 30);
			cmb_productid.setVisible(true);
			lbl_product.setVisible(true);

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error Click view" + ex.toString());

		}
	}

	public void click_view() {
		try {
			btn_calculate.setVisible(false);
			txt_totalamount5.setVisible(false);
			txt_paidamount5.setVisible(false);
			btn_addstock.setVisible(false);
			lbl_totalamount5.setVisible(false);
			lbl_paidamount5.setVisible(false);
			pan_left.setVisible(false);
			pan_bottom.setVisible(false);
			pan_right55.setVisible(false);
			pan_emergencycombo.setVisible(false);
			pan_erergencysearch.setVisible(false);
			pan_view_search.setVisible(true);
			pan_bottom.setBounds(20, 180, 1060, 300);
			pan_bottom.setVisible(true);
			btn_update.setVisible(false);
			btn_delete.setVisible(false);
			btn_add.setVisible(false);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error Click view" + ex.toString());

		}

	}

	public void click_home() {
		try {
			this.setVisible(false);
			dispose();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error Click view" + ex.toString());

		}
	}

	public void click_reset() {
		try {

			txt_shopkeppername.setText("");
			txt_suppliername.setText("");
			txt_productdes.setText("");
			txt_quantitydes.setText("");
			txt_pricedes.setText("");
			txt_discount.setText("");
			txt_totalamount.setText("");
			txt_paidamount.setText("");
			txt_monthid.setText("");
			txt_status.setSelectedItem("");
			txt_employeetype.setText("");
			txt_productid.setText("");
			date.setDate(null);
			txt_totalamount5.setText("");
			txt_paidamount5.setText("");

			txt_stock.setText("");
			txt_product.setText("");
			txt_month.setText("");
			txt_sptype.setText("");
			txt_stuts.setSelectedItem("");
			txt_orderid.setText("");
			txt_shoname.setText("");
			txt_servicename.setText("");
			txt_subproductname.setText("");
			txt_missure.setText("");
			txt_price.setText("");
			txt_discount5.setText("");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error Click view" + ex.toString());

		}
	}

	// ========================================================================
	public void retrive_serviceprovider(JComboBox<String> cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM employee";
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

	@SuppressWarnings("resource")
	public void fill_form(String name) {

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {

			Statement stmt = conn.createStatement();

			String query = "SELECT * FROM employee WHERE emp_id='" + name + "'";

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Servicename = "";
				type = "";
				Servicename = rs.getString(2).trim();
				type = rs.getString(4).trim();
				txt_suppliername.setText(Servicename);
				txt_employeetype.setText(type);
				txt_servicename.setText(Servicename);

				txt_sptype.setText(type);

				rs = null;

			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void retrive_customer(JComboBox<String> cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM customer";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String txt_id = rs.getString(4).trim();
				cmb.addItem(txt_id);
			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	@SuppressWarnings("resource")
	public void fill_form1(String name) {

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {

			Statement stmt = conn.createStatement();

			String query = "SELECT * FROM customer WHERE shop_no='" + name + "'";

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				shopname = "";
				shopname = rs.getString(5).trim();
				txt_shopkeppername.setText(shopname);
				txt_shoname.setText(shopname);

				rs = null;

			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void retrive_product(JComboBox<String> cmb) {

		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM rec_product";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String txt_id = rs.getString(1).trim();

				cmb.addItem(txt_id);
			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	@SuppressWarnings("resource")
	public void fill_form2(String name) {
		DefaultListModel<String> m = new DefaultListModel<String>();

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM rec_product WHERE receivedId='" + name + "'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				product_name = "";
				subproduct_name = "";
				expiredate = "";
				quantity_product = "";
				sellingprice = "";
				product_id = rs.getString(2).trim();
				product_name = rs.getString(3).trim();
				subproduct_name = rs.getString(4).trim();
				expiredate = rs.getString(6).trim();
				quantity_product = rs.getString(7).trim();
				sellingprice = rs.getString(9).trim();
				m.addElement(product_name);
				m.addElement(subproduct_name);
				m.addElement(expiredate);
				m.addElement(quantity_product);
				m.addElement(sellingprice);
				txt_productid.setText(product_id);
				txt_subproductname.setText(product_name);
				txt_missure.setText(quantity_product);
				txt_price.setText(sellingprice);
				txt_orderid.setText(product_id);

				rs = null;
				list_list.setModel(m);
				list_list1.setModel(m);

			}

			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void retrive_product3(JComboBox<String> cmb) {

		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM product";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String txt_id = rs.getString(1).trim();
				cmb.addItem(txt_id);
			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	@SuppressWarnings("resource")
	public void fill_form3(String name) {
		DefaultListModel<String> m = new DefaultListModel<String>();

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM product WHERE pro_no='" + name + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				product_name = "";
				subproduct_name = "";
				expiredate = "";
				quantity_product = "";
				sellingprice = "";
				product_id = rs.getString(2).trim();
				product_name = rs.getString(3).trim();
				subproduct_name = rs.getString(4).trim();
				expiredate = rs.getString(6).trim();
				quantity_product = rs.getString(7).trim();
				sellingprice = rs.getString(9).trim();
				m.addElement(product_name);
				m.addElement(subproduct_name);
				m.addElement(expiredate);
				m.addElement(quantity_product);
				m.addElement(sellingprice);

				rs = null;
				product_list.setModel(m);

			}

			conn.close();
		}

		catch (Exception ex) {

		}

	}

	@Override
	public void mouseClicked(MouseEvent event) {
		int i = tbl_order.getSelectedRow();
		TableModel model = tbl_order.getModel();
		txt_employeetype.setText(model.getValueAt(i, 0).toString());
		cmb_shopid.setSelectedItem(model.getValueAt(i, 1).toString());
		txt_shopkeppername.setText(model.getValueAt(i, 2).toString());
		cmb_serviceprovider.setSelectedItem(model.getValueAt(i, 3));
		txt_suppliername.setText(model.getValueAt(i, 4).toString());
		txt_productid.setText(model.getValueAt(i, 5).toString());
		txt_productdes.setText(model.getValueAt(i, 6).toString());
		txt_quantitydes.setText(model.getValueAt(i, 7).toString());
		txt_pricedes.setText(model.getValueAt(i, 8).toString());
		txt_discount.setText(model.getValueAt(i, 9).toString());
		txt_totalamount.setText(model.getValueAt(i, 10).toString());
		txt_paidamount.setText(model.getValueAt(i, 11).toString());
		txt_monthid.setText(model.getValueAt(i, 12).toString());
		txt_status.setSelectedItem(model.getValueAt(i, 13).toString());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date addDate = new Date();
		try {
			addDate = dateFormat.parse((String) model.getValueAt(i, 14));
			date.setDate(addDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
