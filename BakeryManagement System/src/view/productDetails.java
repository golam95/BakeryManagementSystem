package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import com.toedter.calendar.JDateChooser;

import Controller.Databaseconnect;
import Model.Receivedproductinfo;
import Model.productinformation;
import Model.warehouseInfo;

public class productDetails extends JInternalFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame JFParentFrame;
	JDesktopPane desktop;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	public static int counter = 0;
	public static int mehedi;

	// new golam after edit
	JButton btn_clear = new JButton("Clear");

	//

	// main button side bar
	private JButton btn_additem = new JButton("Stock");
	private JButton btn_addsubitem = new JButton("Product");
	private JButton btn_addwarehouse = new JButton("warehouse");
	private JButton btn_addexit = new JButton("Home");

	//

	JPanel pan_left = new JPanel();

	//

	private JButton btn_wareadd = new JButton("Add");
	private JButton btn_wareupdate = new JButton("Update");
	private JButton btn_waredelete = new JButton("Delete");
	private JButton btn_waresearcg = new JButton("Search");

	// warehouse hs ha ffffffffffffffffffffffffffffffffffffffffffffffffffff
	private JTextArea area = new JTextArea();
	private JTextField txt_field = new JTextField();
	private JTextField txt_year = new JTextField();
	private JTextField txt_search = new JTextField();
	private JTextField txt_receivedproductid = new JTextField();

	private JComboBox cmb_month = new JComboBox();
	protected String array[] = new String[] { "January", "February", "March", "April", "May", "June", "July", "Aguest",
			"September", "Octobor", "November", "December" };
	private JComboBox cmb_status = new JComboBox();
	private JTable tbl_warehouse = new JTable();
	private JScrollPane srp_warehouse = new JScrollPane();
	JDateChooser date_chooser_warehouse = new JDateChooser();
	private JLabel lbl_status = new JLabel("Status");
	private JLabel lbl_productwith = new JLabel("Product with Description");
	private JLabel lbl_date = new JLabel("Date");
	private JLabel lbl_Moth = new JLabel("Month");
	private JLabel lbl_Year = new JLabel("Year");
	private JLabel lbl_totalamount = new JLabel("Total Amount");

	// add item

	Databaseconnect connect = new Databaseconnect();
	Connection conn;
	public static int increment;

	private JButton btn_add = new JButton("Add");// golam
	private JButton btn_update = new JButton("update");
	private JButton btn_delete = new JButton("Delete");
	private JButton btn_reproduct = new JButton("Return Product");

	JPanel pan_table = new JPanel();
	private JButton btn_search5;
	private JTextField lbl_search;// serarch

	JLabel lbl_product_no = new JLabel("Product No");
	JLabel lbl_product_name = new JLabel("Product Name");
	JLabel lbl_subproduc_tname = new JLabel("Subproduct Name");
	JLabel lbl_catagory = new JLabel("Catagory");
	JLabel lbl_expire_date = new JLabel("Expire Date");
	JLabel lbl_quantity = new JLabel("Quantity");
	JLabel lbl_price = new JLabel("Price");
	JLabel lbl_sellprice = new JLabel("Sell Price");
	JLabel lbl_submitdate = new JLabel("Submit Date");
	JLabel lbl_total_amount = new JLabel("Total Amount");
	JLabel lbl_product = new JLabel("Product No");
	private JButton btnsubmit = new JButton("Save");
	JLabel lbl_receivedproductid = new JLabel("Received ProductId");

	JTextField txt_total_discount = new JTextField();
	JLabel lbl_total_discount = new JLabel("Discount %");
	JTextField txt_product_no = new JTextField();
	JTextField txt_product_name = new JTextField();
	JTextField txt_subproduc_tname = new JTextField();
	JTextField txt_catagory = new JTextField();
	JTextField txt_quantity = new JTextField();
	JTextField txt_price = new JTextField();
	JTextField txt_sellprice = new JTextField();
	JTextField txt_total_amount = new JTextField();

	JDateChooser txt_expire_date = new JDateChooser();

	JDateChooser txt_submitdate = new JDateChooser();

	JLabel lbl_productpack = new JLabel("Packet");// new new new new
	JLabel lbl_productweight = new JLabel("Retail");
	JLabel lbl_subproduct = new JLabel("Product");
	private JTextField txt_prductdespack = new JTextField();
	private JTextField txt_prductdeswe = new JTextField();
	private JComboBox list = new JComboBox();
	private JList list1 = new JList();
	private JTable table = new JTable();
	private JScrollPane scrollpane = new JScrollPane();

	// ------------------------------------------------------------ // end the

	// suitem///////////////////////////////////////////////////
	private JPanel pan_first = new JPanel();
	private JButton btn_add1 = new JButton("Add");
	private JButton btn_update1 = new JButton("update");
	private JButton btn_deletepro = new JButton("Delete");
	private JButton btn_searchpro = new JButton("Search");
	private JButton btn_reset = new JButton("Clear");
	JTextField txt_productserch = new JTextField();
	JLabel lbl_productno = new JLabel("Prouduct No");
	JLabel lbl_productname = new JLabel("product Name");
	JLabel lbl_subproductname = new JLabel("Sub_product Name");
	JLabel lbl_subproductcatagory = new JLabel("Product Catagory");
	JLabel lbl_bakeryname = new JLabel("Bakery");
	JLabel lbl_despacket = new JLabel("Des with packet");
	JLabel lbl_deswithweight = new JLabel("Des with weight");
	JLabel lbl_statu = new JLabel("Status");
	JLabel lbl_proadddate = new JLabel("Pro/add Date");

	JTextField txt_productno = new JTextField();
	JTextField txt_productname = new JTextField();
	JTextField txt_subproductname = new JTextField();
	JTextField txt_subproductcatagory = new JTextField();
	JTextField txt_bakeryname = new JTextField();
	JTextField txt_despacket = new JTextField();
	JTextField txt_deswithweight = new JTextField();
	JTextField txt_statu = new JTextField();

	JDateChooser date_proadddate = new JDateChooser();
	JTable product_table = new JTable();
	JScrollPane product_scrollpane = new JScrollPane();
	JLabel lbl_productnolist = new JLabel("Product");
	JLabel lbl_subproductnamelist = new JLabel("SubProduct");
	// end subite
	private JList list5 = new JList();
	private JList list55 = new JList();
	//
	String str1;
	String str2;
	String str3;
	String str4;
	String str5;
	String str6;
	String str7;
	String str8;
	String str9;
	String str10;
	String productid;
	String strfirst;
	String str11;
	String str12;
	String str13;
	String str14;
	String str15;
	String str16;
	String str17;
	String str18;
	String sr = "";
	String sr1 = "";
	// warehouse
	Object ware_status;
	String ware_date;
	String ware_year;
	String ware_month;
	String ware_amount;
	String ware_description;
	// new panel

	JPanel pan_internal_panel = new JPanel();
	JPanel pan_details = new JPanel();
	JPanel pan_subproduct_details = new JPanel();
	JPanel pan_warehouse_details = new JPanel();
	// new panel
	SettingManu settings = new SettingManu();
	//

	@SuppressWarnings("unchecked")
	public productDetails(JFrame getParentFrame) {
		super("Product Details", true, true, true, true);
		this.setSize(1150, 580);
		this.setLayout(null);
		//
		pan_left.setBounds(0, 0, 130, 850);
		pan_left.setBackground(Color.decode("#D2DDF1"));
		pan_left.setLayout(null);

		Border thickBorder = new LineBorder(Color.decode("#394B58"), 12);
		btn_additem.setBounds(20, 60, 80, 80);
		btn_additem.setBorder(thickBorder);
		btn_additem.setBackground(Color.decode("#250800"));
		btn_additem.setForeground(Color.WHITE);

		btn_addsubitem.setBounds(20, 170, 80, 80);
		btn_addsubitem.setBorder(thickBorder);
		btn_addsubitem.setBackground(Color.decode("#250800"));
		btn_addsubitem.setForeground(Color.WHITE);

		btn_addexit.setBounds(20, 390, 80, 80);
		btn_addwarehouse.setBorder(thickBorder);
		btn_addwarehouse.setBackground(Color.decode("#250800"));
		btn_addwarehouse.setForeground(Color.WHITE);

		btn_addwarehouse.setBounds(20, 280, 80, 80);
		btn_addexit.setBorder(thickBorder);
		btn_addexit.setBackground(Color.decode("#250800"));
		btn_addexit.setForeground(Color.WHITE);

		//

		pan_left.add(btn_additem);
		pan_left.add(btn_addsubitem);
		pan_left.add(btn_addwarehouse);
		pan_left.add(btn_addexit);
		btn_additem.addActionListener(this);
		btn_addsubitem.addActionListener(this);
		btn_addwarehouse.addActionListener(this);
		btn_addexit.addActionListener(this);
		btnsubmit.addActionListener(this);
		btn_waresearcg.addActionListener(this);
		pan_first.setBounds(140, 380, 785, 170);
		pan_first.setLayout(new GridLayout());

		product_table.setModel(
				new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "ProductNo", "Pro/Name",
						"Sub_P_Name", "Subp_cata", "BakeryName", "Des/packet", "Des/Weight", "Status", "SubmitDate" }));
		product_scrollpane.setViewportView(product_table);

		Mouse listenr = new Mouse();
		product_table.addMouseListener(listenr);
		scrollpane.setBounds(0, 0, 800, 200);
		pan_first.add(product_scrollpane);
		lbl_subproduct.setBounds(975, 5, 150, 30);
		String cat_empName = (String) list.getSelectedItem();// name
		fill_formcomb(cat_empName);
		list.addActionListener(this);
		btnsubmit.setBounds(770, 200, 150, 25);

		sager s = new sager();
		tbl_warehouse.addMouseListener(s);
		//

		//
		pan_subproduct_details.setVisible(false);// eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee

		btn_add.addActionListener(this);
		btn_update.addActionListener(this);
		btn_delete.addActionListener(this);
		btn_reproduct.addActionListener(this);
		table.addMouseListener(this);
		btn_add1.addActionListener(this);
		btn_reset.addActionListener(this);
		btn_searchpro.addActionListener(this);
		btn_deletepro.addActionListener(this);
		btn_update1.addActionListener(this);

		// start

		Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		pan_details.setBorder(raisedetched);
		pan_details.setBounds(200, 50, 1100, 480);
		pan_details.setLayout(null);

		btn_add.setBounds(570, 543, 80, 20);
		btn_update.setBounds(670, 543, 80, 20);
		btn_delete.setBounds(770, 543, 80, 20);
		btnsubmit.setBounds(870, 543, 80, 20);
		btn_reproduct.setBounds(970, 543, 140, 20);

		btn_clear.setBounds(690, 15, 140, 25);
		this.add(btn_clear);
		btn_clear.addActionListener(this);

		Border raisedetched_internal = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		pan_internal_panel.setBorder(raisedetched_internal);
		pan_internal_panel.setBounds(20, 20, 1060, 185);
		pan_internal_panel.setLayout(null);

		lbl_product_no.setBounds(20, 10, 80, 25);
		lbl_product_name.setBounds(20, 44, 80, 25);
		lbl_subproduc_tname.setBounds(20, 78, 80, 25);
		lbl_catagory.setBounds(20, 112, 80, 30);
		lbl_expire_date.setBounds(20, 146, 80, 25);
		txt_product_no.setBounds(110, 10, 150, 25);
		txt_product_name.setBounds(110, 44, 150, 25);
		txt_subproduc_tname.setBounds(110, 78, 150, 25);
		txt_catagory.setBounds(110, 112, 150, 25);
		txt_expire_date.setBounds(110, 146, 150, 25);

		lbl_product.setBounds(290, 10, 80, 25);
		lbl_quantity.setBounds(290, 44, 80, 25);
		lbl_price.setBounds(290, 78, 80, 25);
		lbl_sellprice.setBounds(290, 112, 80, 25);
		lbl_submitdate.setBounds(290, 146, 80, 25);

		list.setBounds(380, 10, 150, 25);
		txt_quantity.setBounds(380, 44, 150, 25);
		txt_price.setBounds(380, 78, 150, 25);
		txt_sellprice.setBounds(380, 112, 150, 25);
		txt_submitdate.setBounds(380, 146, 150, 25);

		lbl_receivedproductid.setBounds(560, 10, 120, 25);
		lbl_productpack.setBounds(560, 44, 100, 25);
		lbl_productweight.setBounds(560, 78, 100, 25);
		lbl_total_amount.setBounds(560, 112, 100, 25);
		lbl_total_discount.setBounds(560, 146, 100, 25);

		txt_receivedproductid.setBounds(665, 10, 150, 25);
		txt_prductdespack.setBounds(665, 44, 150, 25);
		txt_prductdeswe.setBounds(665, 78, 150, 25);
		txt_total_amount.setBounds(665, 112, 150, 25);
		txt_total_discount.setBounds(665, 146, 150, 25);

		list1.setBounds(855, 10, 180, 160);
		list1.setBackground(Color.lightGray);

		pan_internal_panel.add(list1);
		pan_internal_panel.add(txt_receivedproductid);
		pan_internal_panel.add(txt_prductdespack);
		pan_internal_panel.add(txt_prductdeswe);
		pan_internal_panel.add(txt_total_amount);
		pan_internal_panel.add(txt_total_discount);

		pan_internal_panel.add(lbl_receivedproductid);
		pan_internal_panel.add(lbl_productpack);
		pan_internal_panel.add(lbl_productweight);
		pan_internal_panel.add(lbl_total_amount);
		pan_internal_panel.add(lbl_total_discount);

		pan_internal_panel.add(lbl_product);
		pan_internal_panel.add(lbl_quantity);
		pan_internal_panel.add(lbl_price);
		pan_internal_panel.add(lbl_sellprice);
		pan_internal_panel.add(lbl_submitdate);

		pan_internal_panel.add(list);
		pan_internal_panel.add(txt_quantity);
		pan_internal_panel.add(txt_price);
		pan_internal_panel.add(txt_sellprice);
		pan_internal_panel.add(txt_submitdate);

		pan_internal_panel.add(lbl_product_no);
		pan_internal_panel.add(lbl_product_name);
		pan_internal_panel.add(lbl_subproduc_tname);
		pan_internal_panel.add(lbl_catagory);
		pan_internal_panel.add(lbl_expire_date);
		pan_internal_panel.add(txt_product_no);
		pan_internal_panel.add(txt_product_name);
		pan_internal_panel.add(txt_subproduc_tname);
		pan_internal_panel.add(txt_catagory);
		pan_internal_panel.add(txt_expire_date);

		pan_table.setLayout(new GridLayout());
		pan_table.setBounds(20, 260, 1060, 200);// ggggggggggggggggggggggggggg
		pan_table.setBackground(Color.red);
		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "ReceivedId", "ProductNo", "ProductName", "sub_Name", "Catagory", "Expiredate",
						"Quantity", "Price", "SellPrice", "submitedate", "Total" }));
		scrollpane.setViewportView(table);
		scrollpane.setBounds(0, 0, 800, 200);
		pan_table.add(scrollpane);

		lbl_search = new JTextField();
		lbl_search.setBounds(450, 220, 130, 25);
		btn_search5 = new JButton("search");
		btn_search5.setBounds(590, 220, 80, 25);
		btn_search5.addActionListener(this);

		pan_details.add(btn_search5);
		pan_details.add(lbl_search);

		pan_details.add(pan_table);
		pan_details.add(pan_internal_panel);
		this.add(pan_details);
		this.add(btnsubmit);
		this.add(btn_reproduct);
		this.add(btn_add);
		this.add(btn_update);
		this.add(btn_delete);

		//

		Border raised_subproduct = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		pan_subproduct_details.setBorder(raised_subproduct);
		pan_subproduct_details.setBounds(200, 50, 1100, 480);
		pan_subproduct_details.setLayout(null);

		JPanel pan_subitem_table = new JPanel();
		pan_subitem_table.setLayout(new GridLayout());
		pan_subitem_table.setBounds(20, 260, 1060, 200);// ggggggggggggggggggggggggggg
		pan_subitem_table.setBackground(Color.red);
		pan_subitem_table.add(pan_first);

		JPanel pan_internalsubitem_panel = new JPanel();
		Border raisedetched_internal_subproduct = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		pan_internalsubitem_panel.setBorder(raisedetched_internal_subproduct);
		pan_internalsubitem_panel.setBounds(20, 20, 1060, 185);
		pan_internalsubitem_panel.setLayout(null);

		lbl_productno.setBounds(20, 10, 100, 30);
		lbl_productname.setBounds(20, 45, 100, 30);
		lbl_subproductname.setBounds(20, 80, 140, 30);
		lbl_subproductcatagory.setBounds(20, 115, 100, 30);
		lbl_bakeryname.setBounds(20, 150, 100, 30);
		lbl_despacket.setBounds(320, 10, 100, 30);
		lbl_deswithweight.setBounds(320, 45, 100, 30);
		lbl_statu.setBounds(320, 80, 100, 30);
		lbl_proadddate.setBounds(320, 115, 100, 30);

		txt_productno.setBounds(140, 10, 150, 30);
		txt_productname.setBounds(140, 45, 150, 30);
		txt_subproductname.setBounds(140, 80, 150, 30);
		txt_subproductcatagory.setBounds(140, 115, 150, 30);
		txt_bakeryname.setBounds(140, 150, 150, 30);

		txt_despacket.setBounds(440, 10, 150, 30);
		txt_deswithweight.setBounds(440, 45, 150, 30);
		txt_statu.setBounds(440, 80, 150, 30);
		date_proadddate.setBounds(440, 115, 150, 30);

		list5.setBounds(650, 45, 150, 130);
		list55.setBounds(850, 45, 150, 130);
		lbl_subproductnamelist.setBounds(900, 10, 150, 30);
		lbl_productnolist.setBounds(700, 10, 150, 30);
		list5.setBackground(Color.GRAY);
		list55.setBackground(Color.gray);

		pan_internalsubitem_panel.add(lbl_subproductnamelist);
		pan_internalsubitem_panel.add(lbl_productnolist);
		pan_internalsubitem_panel.add(list5);
		pan_internalsubitem_panel.add(list55);
		pan_internalsubitem_panel.add(lbl_despacket);
		pan_internalsubitem_panel.add(lbl_deswithweight);
		pan_internalsubitem_panel.add(lbl_statu);
		pan_internalsubitem_panel.add(lbl_proadddate);
		pan_internalsubitem_panel.add(lbl_productno);
		pan_internalsubitem_panel.add(lbl_productname);
		pan_internalsubitem_panel.add(lbl_subproductname);
		pan_internalsubitem_panel.add(lbl_subproductcatagory);
		pan_internalsubitem_panel.add(lbl_bakeryname);
		pan_internalsubitem_panel.add(txt_productno);
		pan_internalsubitem_panel.add(txt_productname);
		pan_internalsubitem_panel.add(txt_subproductname);
		pan_internalsubitem_panel.add(txt_subproductcatagory);
		pan_internalsubitem_panel.add(txt_bakeryname);
		pan_internalsubitem_panel.add(txt_despacket);
		pan_internalsubitem_panel.add(txt_deswithweight);
		pan_internalsubitem_panel.add(txt_statu);
		pan_internalsubitem_panel.add(date_proadddate);
		btn_searchpro.setBounds(590, 220, 80, 25);
		txt_productserch.setBounds(450, 220, 130, 25);

		btn_add1.setBounds(570, 543, 80, 20);
		btn_reset.setBounds(670, 543, 80, 20);
		btn_update1.setBounds(770, 543, 80, 20);
		btn_deletepro.setBounds(870, 543, 80, 20);

		this.add(btn_add1);
		this.add(btn_reset);
		this.add(btn_update1);
		this.add(btn_deletepro);

		pan_subproduct_details.add(txt_productserch);
		pan_subproduct_details.add(btn_searchpro);
		pan_subproduct_details.add(pan_internalsubitem_panel);
		pan_subproduct_details.add(pan_subitem_table);
		this.add(pan_subproduct_details);
		lbl_status.setBounds(70, 15, 100, 30);
		cmb_status.setBounds(30, 55, 100, 25);
		cmb_status.addItem("Owner");

		lbl_date.setBounds(860, 15, 100, 30);
		date_chooser_warehouse.setBounds(930, 15, 150, 25);
		lbl_Moth.setBounds(860, 45, 100, 30);
		cmb_month.setBounds(930, 45, 150, 25);

		for (int i = 0; i < array.length; i++) {
			cmb_month.addItem(array[i]);

		}

		lbl_Year.setBounds(860, 80, 100, 30);
		txt_year.setBounds(930, 75, 150, 25);

		lbl_totalamount.setBounds(860, 110, 140, 30);
		txt_field.setBounds(930, 105, 150, 25);

		btn_waredelete.addActionListener(this);
		btn_wareupdate.addActionListener(this);

		//
		JPanel panelware_table = new JPanel();
		panelware_table.setBounds(150, 340, 770, 200);
		panelware_table.setLayout(new GridLayout());
		tbl_warehouse.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Month", "Year", "Date", "Amount", "Description", "Status" }));
		srp_warehouse.setViewportView(tbl_warehouse);

		pan_table.add(srp_warehouse);
		panelware_table.add(srp_warehouse);
		btn_wareadd.addActionListener(this);
		lbl_productwith.setBounds(430, 10, 140, 30);
		area.setBounds(350, 50, 350, 90);
		area.setBackground(Color.GRAY);
		pan_warehouse_details.add(lbl_productwith);
		pan_warehouse_details.add(area);

		JPanel pan_warehouse_table = new JPanel();
		pan_warehouse_table.setLayout(new GridLayout());
		pan_warehouse_table.setBounds(20, 260, 1060, 200);// ggggggggggggggggggggggggggg
		pan_warehouse_table.setBackground(Color.red);
		pan_warehouse_table.add(panelware_table);

		pan_warehouse_details.add(lbl_date);
		pan_warehouse_details.add(lbl_Moth);
		pan_warehouse_details.add(cmb_month);
		pan_warehouse_details.add(lbl_Year);
		pan_warehouse_details.add(txt_year);
		pan_warehouse_details.add(date_chooser_warehouse);
		pan_warehouse_details.add(lbl_status);
		pan_warehouse_details.add(cmb_status);
		pan_warehouse_details.add(txt_field);
		pan_warehouse_details.add(lbl_totalamount);

		pan_warehouse_details.add(pan_warehouse_table);

		pan_warehouse_details.setBorder(raised_subproduct);
		pan_warehouse_details.setBounds(200, 50, 1100, 480);
		pan_warehouse_details.setLayout(null);
		btn_wareadd.setBounds(570, 543, 80, 20);
		btn_wareupdate.setBounds(670, 543, 80, 20);
		btn_waredelete.setBounds(770, 543, 80, 20);
		btn_waresearcg.setBounds(565, 195, 100, 25);
		txt_search.setBounds(420, 195, 125, 25);
		pan_warehouse_details.add(btn_waresearcg);
		pan_warehouse_details.add(txt_search);

		//

		//
		this.add(btn_wareupdate);
		this.add(btn_wareadd);
		this.add(btn_waredelete);
		this.add(pan_warehouse_details);
		this.add(pan_left);
		this.setLocation(screenheith / 7, screedwidth / 27);
		Show_productreceivemod();
		Show_Users_In_JTable_warehouse();
		Show_product_table();
		retrive_productid(list, list1, list5);
		settings.Numvalidator(txt_total_discount);
		settings.Numvalidator(txt_quantity);
		settings.Numvalidator(txt_total_discount);
		settings.Numvalidator(txt_price);
		settings.Numvalidator(txt_sellprice);
		settings.Numvalidator(txt_total_amount);
		settings.Numvalidator(txt_catagory);
		settings.Numvalidator1(txt_product_name);
		settings.Numvalidator1(txt_subproduc_tname);
		settings.Numvalidator1(txt_productname);
		settings.Numvalidator1(txt_subproductname);
		settings.Numvalidator1(txt_bakeryname);
		settings.Numvalidator(txt_subproductcatagory);
		settings.Numvalidator(txt_field);
		settings.Numvalidator(txt_year);
		settings.Numvalidator(txt_receivedproductid);
		this.setVisible(true);

	}

	// connection
	public Connection getConnection() {
		try {
			conn = connect.setConnection(conn);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//
	// ===================================================================================additem

	// ===================================================================================warehouse

	public void executeSQlQuery_warehouse(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {
				// refresh jtable data
				DefaultTableModel model = (DefaultTableModel) tbl_warehouse.getModel();
				model.setRowCount(0);
				Show_Users_In_JTable_warehouse();
				resetText();

				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// get a list of users from mysql database
	public ArrayList<warehouseInfo> getUsersList_warehouse() {
		ArrayList<warehouseInfo> usersList = new ArrayList<warehouseInfo>();
		Connection connection = getConnection();
		String query = "SELECT * FROM  `warehouse`";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			warehouseInfo user;
			while (rs.next()) {
				user = new warehouseInfo(rs.getString("wa_month"), rs.getString("wa_year"), rs.getString("wa_date"),
						rs.getDouble("wa_amount"), rs.getString("wa_decription"), rs.getString("wa_status"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	// Display Data In JTable

	public void Show_Users_In_JTable_warehouse() {
		ArrayList<warehouseInfo> list = getUsersList_warehouse();
		DefaultTableModel model = (DefaultTableModel) tbl_warehouse.getModel();
		Object[] row = new Object[6];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getMonth();
			row[1] = list.get(i).getYear();
			row[2] = list.get(i).getDate();
			row[3] = list.get(i).getAmount();
			row[4] = list.get(i).getDecription();
			row[5] = list.get(i).getStatus();
			model.addRow(row);
		}
	}

	public ArrayList<warehouseInfo> List_wa_employee(String searchemp_regine) {// warehouse
																				// emp
		ArrayList<warehouseInfo> usersList = new ArrayList<warehouseInfo>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `warehouse` WHERE CONCAT(`wa_month`, `wa_year`, `wa_date`, `wa_amount`,`wa_decription`,`wa_status`) LIKE '%"
					+ searchemp_regine + "%'";
			rs = st.executeQuery(searchQuery);

			warehouseInfo user;

			while (rs.next()) {
				user = new warehouseInfo(rs.getString("wa_month"), rs.getString("wa_year"), rs.getString("wa_date"),
						rs.getDouble("wa_amount"), rs.getString("wa_decription"), rs.getString("wa_status"));
				usersList.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	public void find_warehouseproduct() {
		ArrayList<warehouseInfo> list = List_wa_employee(txt_search.getText());// asdjflasjdf;lja;lkdsfjl;k
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "Month", "Year", "Date", "Amount", "Description", "Status" });
		Object[] row = new Object[6];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getMonth();
			row[1] = list.get(i).getYear();
			row[2] = list.get(i).getDate();
			row[3] = list.get(i).getAmount();
			row[4] = list.get(i).getDecription();
			row[5] = list.get(i).getStatus();
			model.addRow(row);
		}
		tbl_warehouse.setModel(model);

	}

	// ===================================================================================
	// -------------------------------------------------------------------------------------

	public void executeSQlQuery_productinfo(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {
				// refresh jtable data
				DefaultTableModel model = (DefaultTableModel) product_table.getModel();
				model.setRowCount(0);
				Show_product_table();// get the tabel
				resetText();

				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// get a list of users from mysql database
	public ArrayList<productinformation> getproduct_info() {
		ArrayList<productinformation> usersList = new ArrayList<productinformation>();
		Connection connection = getConnection();
		String query = "SELECT * FROM  `product` ";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			productinformation user;
			while (rs.next()) {
				user = new productinformation(rs.getInt("pro_no"), rs.getString("pro_name"),
						rs.getString("subpro_name"), rs.getString("subpro_catagory"), rs.getString("bakery"),
						rs.getString("des_pack"), rs.getString("des_weight"), rs.getString("status"),
						rs.getString("date"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	// Display Data In JTable

	public void Show_product_table() {
		ArrayList<productinformation> list = getproduct_info();
		DefaultTableModel model = (DefaultTableModel) product_table.getModel();
		Object[] row = new Object[9];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getProudctno();
			row[1] = list.get(i).getProductname();
			row[2] = list.get(i).getSubproductname();
			row[3] = list.get(i).getSubproductcatagory();
			row[4] = list.get(i).getBakery();
			row[5] = list.get(i).getDes_pack();
			row[6] = list.get(i).getDes_weight();
			row[7] = list.get(i).getStatus();
			row[8] = list.get(i).getDate();

			model.addRow(row);
		}
	}

	public ArrayList<productinformation> product_list(String serarchproduct) {
		ArrayList<productinformation> usersList = new ArrayList<productinformation>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `product` WHERE CONCAT(`pro_no`, `pro_name`, `subpro_name`, `subpro_catagory`,`bakery`,`des_pack`,`des_weight`,`status`,`date`) LIKE '%"
					+ serarchproduct + "%'";
			rs = st.executeQuery(searchQuery);

			productinformation user;

			while (rs.next()) {
				user = new productinformation(rs.getInt("pro_no"), rs.getString("pro_name"),
						rs.getString("subpro_name"), rs.getString("subpro_catagory"), rs.getString("bakery"),
						rs.getString("des_pack"), rs.getString("des_weight"), rs.getString("status"),
						rs.getString("date"));
				usersList.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	public void find_productno() {
		ArrayList<productinformation> list = product_list(txt_productserch.getText());// asdjflasjdf;lja;lkdsfjl;k
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "ProductNo", "Pro/Name", "Sub_P_Name", "Subp_cata", "BakeryName",
				"Des/packet", "Des/Weight", "Status", "SubmitDate" });
		Object[] row = new Object[9];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getProudctno();
			row[1] = list.get(i).getProductname();
			row[2] = list.get(i).getSubproductname();
			row[3] = list.get(i).getSubproductcatagory();
			row[4] = list.get(i).getBakery();
			row[5] = list.get(i).getDes_pack();
			row[6] = list.get(i).getDes_weight();
			row[7] = list.get(i).getStatus();
			row[8] = list.get(i).getDate();

			model.addRow(row);
		}
		product_table.setModel(model);

	}

	// -======================================================================================

	// ===================================================================================subite

	// ===================================================================================

	public void retrive_productid(JComboBox<String> id, JList<String> name, JList<String> list) {
		DefaultListModel<String> m = new DefaultListModel<String>();
		DefaultListModel<String> m1 = new DefaultListModel<String>();

		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM product";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String emptype = rs.getString(1).trim();
				String pro_sub = rs.getString(2).trim();
				String pro_name = rs.getString(3).trim();
				id.addItem(emptype);
				id.addItem(pro_name);
				m.addElement(pro_sub);
				m1.addElement(pro_sub);

			}
			name.setModel(m);
			list.setModel(m1);
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	@SuppressWarnings("resource")
	public void fill_formcomb(String productno) {// get the two id and

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {

			Statement stmt = conn.createStatement();

			String query = "SELECT * FROM product WHERE pro_no='" + productno + "'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String product_no = rs.getString(1).trim();
				String product_name = rs.getString(2).trim();
				String product_subproduct = rs.getString(3).trim();
				String catagory = rs.getString(4).trim();
				String packet = rs.getString(6).trim();
				String weight = rs.getString(7).trim();
				txt_product_no.setText(product_no);
				txt_product_name.setText(product_name);
				txt_subproduc_tname.setText(product_subproduct);
				txt_catagory.setText(catagory);
				txt_prductdespack.setText(packet);
				txt_prductdeswe.setText(weight);

				// txt_total_amount
				// txt_total_discount

				rs = null;
			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	// :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::new
	// new
	public void executeSQlQuery_receiveproduct(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {
				// refresh jtable data
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				Show_productreceivemod();// get the tabel
				resetText();

				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// get a list of users from mysql database
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
				if (quen <= 6) {
					counter += 1;
					mehedi = rs.getInt("receivedId");
					System.out.println("fetchid " + mehedi);

				}

				usersList.add(user);

			}

			System.out.println("counter " + counter);
			System.out.println("set " + counter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	// Display Data In JTable

	public void Show_productreceivemod() {
		ArrayList<Receivedproductinfo> list = receivedproductinfo();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[11];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getReceiveId();
			row[1] = list.get(i).getProduct_no();
			row[2] = list.get(i).getProduct_name();
			row[3] = list.get(i).getSub_productname();
			row[4] = list.get(i).getCatagory();
			row[5] = list.get(i).getExpiredate();
			row[6] = list.get(i).getQuantity();
			row[7] = list.get(i).getPrice();
			row[8] = list.get(i).getSellingprice();
			row[9] = list.get(i).getSubmitdate();
			row[10] = list.get(i).getTotal();
			model.addRow(row);
		}
	}

	public ArrayList<Receivedproductinfo> product_Received(String serarchproduct) {
		ArrayList<Receivedproductinfo> usersList = new ArrayList<Receivedproductinfo>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `Rec_product` WHERE CONCAT(`receivedId`, `product_no`, `productname`, `sub_productname`,`catagory`,`expiredate`,`quantity`,`price`,`sellingprice`,`date`,`totalamount`) LIKE '%"
					+ serarchproduct + "%'";
			rs = st.executeQuery(searchQuery);
			Receivedproductinfo user;

			while (rs.next()) {
				user = new Receivedproductinfo(rs.getInt("receivedId"), rs.getInt("product_no"),
						rs.getString("productname"), rs.getString("sub_productname"), rs.getString("catagory"),
						rs.getString("expiredate"), rs.getInt("quantity"), rs.getDouble("price"),
						rs.getDouble("sellingprice"), rs.getString("date"), rs.getDouble("totalamount"));
				usersList.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	public void find_Receiveproduct() {
		ArrayList<Receivedproductinfo> list = product_Received(lbl_search.getText());// asdjflasjdf;lja;lkdsfjl;k
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "ReceiveId", "ProductNo", "ProductName", "sub_Name", "Catagory",
				"Expiredate", "Quantity", "Price", "SellPrice", "submitedate", "Total" });
		Object[] row = new Object[11];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getReceiveId();
			row[1] = list.get(i).getProduct_no();
			row[2] = list.get(i).getProduct_name();
			row[3] = list.get(i).getSub_productname();
			row[4] = list.get(i).getCatagory();
			row[5] = list.get(i).getExpiredate();
			row[6] = list.get(i).getQuantity();
			row[7] = list.get(i).getPrice();
			row[8] = list.get(i).getSellingprice();
			row[9] = list.get(i).getSubmitdate();
			row[10] = list.get(i).getTotal();

			model.addRow(row);
		}
		table.setModel(model);

	}

	public void receive_productadd() {// recode is add receive product
		DateFormat dateformate = DateFormat.getDateInstance(DateFormat.LONG);
		str1 = "";
		str2 = "";
		str3 = "";
		str4 = "";
		str5 = "";
		str6 = "";
		str7 = "";
		str8 = "";
		str9 = "";
		increment = increment + 1;
		productid = "" + increment;
		str1 = txt_product_no.getText().trim();
		str2 = txt_product_name.getText().trim();
		str3 = txt_subproduc_tname.getText().trim();
		str4 = txt_catagory.getText().trim();
		if (txt_expire_date.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Field must Not Empty!!");
		} else {
			str5 = dateformate.format(txt_expire_date.getDate());
		}

		str6 = txt_quantity.getText().trim();
		str7 = txt_price.getText().trim();
		str8 = txt_sellprice.getText().trim();
		if (txt_submitdate.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Field must Not Empty!!");
		} else {
			str9 = dateformate.format(txt_submitdate.getDate());
		}
		strfirst = txt_total_amount.getText().trim();

		if (str1.equals("") || str2.equals("") || str3.equals("") || str4.equals("") || str6.equals("")
				|| str7.equals("") || str8.equals("") || strfirst.equals("")) {
			JOptionPane.showMessageDialog(null, "Field must Not Empty!!");

		}

		Statement stmt;
		try {
			stmt = conn.createStatement();

			String query = "SELECT * FROM rec_product WHERE sub_productname='" + txt_subproduc_tname + "'";
			ResultSet rs = stmt.executeQuery(query);

			int foundrec = 0;
			while (rs.next()) {
				String dialogmessage = "Record Already Exists in DataBase!!!";
				int dialogtype = JOptionPane.WARNING_MESSAGE;
				JOptionPane.showMessageDialog((Component) null, dialogmessage, "sager", dialogtype);
				foundrec = 1;

			}

			if (foundrec == 0) {

				String querey = "INSERT INTO Rec_product(product_no,productname,sub_productname,catagory,expiredate,quantity,price,sellingprice,date,totalamount) VALUES ('"
						+ str1 + "','" + str2 + "','" + str3 + "','" + str4 + "','" + str5 + "','" + str6 + "','" + str7
						+ "','" + str8 + "','" + str9 + "','" + strfirst + "')";
				executeSQlQuery_receiveproduct(querey, "Add");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void receive_productupate() {
		DateFormat dateformate = DateFormat.getDateInstance(DateFormat.LONG);
		str1 = "";
		str2 = "";
		str3 = "";
		str4 = "";
		str5 = "";
		str6 = "";
		str7 = "";
		str8 = "";
		str9 = "";
		strfirst = "";
		productid = "";

		productid = txt_receivedproductid.getText().trim();
		str1 = txt_product_no.getText().trim();
		str2 = txt_product_name.getText().trim();
		str3 = txt_subproduc_tname.getText().trim();
		str4 = txt_catagory.getText().trim();
		if (txt_expire_date.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Field must Not Empty!!");
		} else {
			str5 = dateformate.format(txt_expire_date.getDate());
		}

		str6 = txt_quantity.getText().trim();
		str7 = txt_price.getText().trim();
		str8 = txt_sellprice.getText().trim();
		if (txt_submitdate.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Field must Not Empty!!");
		} else {
			str9 = dateformate.format(txt_submitdate.getDate());
		}
		strfirst = txt_total_amount.getText().trim();

		if (str1.equals("") || str2.equals("") || str3.equals("") || str4.equals("") || str6.equals("")
				|| str7.equals("") || str8.equals("") || strfirst.equals("")) {
			JOptionPane.showMessageDialog(null, "Field must Not Empty!!");

		} else {

			String temp = "UPDATE Rec_product SET " + "receivedId = '" + productid + "',product_no = '" + str1
					+ "',productname = '" + str2 + "',sub_productname = '" + str3 + "',catagory = '" + str4
					+ "',expiredate = '" + str5 + "',quantity = '" + str6 + "',price = '" + str7 + "',sellingprice = '"
					+ str8 + "',date = '" + str9 + "',totalamount = '" + strfirst + "'" + "WHERE receivedId = '"
					+ productid + "'";
			executeSQlQuery_receiveproduct(temp, "Updated");

		}

	}

	// """""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(btn_additem)) {
			additem();

		} else if (source.equals(btn_addsubitem)) {
			addsubitem();

		} else if (source.equals(btn_addwarehouse)) {
			warehouse();

		} else if (source.equals(btn_addexit)) {
			try {
				addexit();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Eror the main ben_exit" + ex.toString());

			}
		} else if (source.equals(list)) {

			String cat_empthirdName = (String) list.getSelectedItem();
			fill_formcomb(cat_empthirdName);

		} else if (source.equals(btn_add)) {// product is add
			receive_productadd();
		} else if (source.equals(btn_clear)) {
			resetText();

		} else if (source.equals(btn_update)) {
			receive_productupate();

		} else if (source.equals(btn_delete)) {
			JOptionPane.showMessageDialog(null, "golam");
			productid = "";
			productid = txt_receivedproductid.getText().trim();
			String query = "DELETE FROM `Rec_product` WHERE receivedId = " + productid;
			executeSQlQuery_receiveproduct(query, "Deleted Product");

		} else if (source.equals(btn_reproduct)) {
			JOptionPane.showMessageDialog(null, "golam");
		} else if (source.equals("")) {
			JOptionPane.showMessageDialog(null, "golam");

		} else if (source.equals(btnsubmit)) {
			double discount = 0;
			double sager = 0;
			double num = 0;
			double num1 = 0;
			String h = "";
			if (txt_total_discount.getText().equals("")) {
				num = Double.parseDouble(txt_quantity.getText());
				num1 = Double.parseDouble(txt_price.getText());
				sager = num * num1;
				h = Double.toString(sager);
				txt_total_amount.setText(h);
				txt_total_discount.setText("0.0");

			} else {
				double X = Double.parseDouble(txt_total_discount.getText());
				num = Double.parseDouble(txt_quantity.getText());
				num1 = Double.parseDouble(txt_price.getText());
				sager = num * num1;
				discount = sager / X;
				h = Double.toString(discount);
				txt_total_amount.setText(h);

			}
			txt_total_discount.setText("0.0");

		} else if (source.equals(btn_search5)) {
			find_Receiveproduct();
		} else if (source.equals(btn_add1)) {
			DateFormat f3 = DateFormat.getDateInstance(DateFormat.LONG);
			str10 = txt_productno.getText().trim();
			str11 = txt_productname.getText().trim();
			str12 = txt_subproductname.getText().trim();
			str13 = txt_subproductcatagory.getText().trim();
			str14 = txt_bakeryname.getText().trim();
			str15 = txt_despacket.getText().trim();
			str16 = txt_deswithweight.getText().trim();
			str17 = txt_statu.getText().trim();

			if (date_proadddate.getDate() == null) {
				JOptionPane.showMessageDialog(null, "The date field id Blank!!");

			} else {
				str18 = f3.format(date_proadddate.getDate());
			}

			if (str10.equals("") || str11.equals("") || str12.equals("") || str13.equals("") || str14.equals("")
					|| str15.equals("") || str16.equals("") || str17.equals("")) {
				JOptionPane.showMessageDialog(null, "The Record Field is Empty!!");

			} else {
				String query = "INSERT INTO product VALUES ('" + str10 + "','" + str11 + "','" + str12 + "','" + str13
						+ "','" + str14 + "','" + str15 + "','" + str16 + "','" + str17 + "','" + str18 + "')";
				executeSQlQuery_productinfo(query, "Add");

			}
		} else if (source.equals(btn_searchpro)) {
			find_productno();

		} else if (source.equals(btn_update1)) {

			DateFormat f3 = DateFormat.getDateInstance(DateFormat.LONG);
			str10 = txt_productno.getText().trim();
			str11 = txt_productname.getText().trim();
			str12 = txt_subproductname.getText().trim();
			str13 = txt_subproductcatagory.getText().trim();
			str14 = txt_bakeryname.getText().trim();
			str15 = txt_despacket.getText().trim();
			str16 = txt_deswithweight.getText().trim();
			str17 = txt_statu.getText().trim();

			if (date_proadddate.getDate() == null) {
				JOptionPane.showMessageDialog(null, "The date field id Blank!!");

			} else {
				str18 = f3.format(date_proadddate.getDate());
			}

			if (str10.equals("") || str11.equals("") || str12.equals("") || str13.equals("") || str14.equals("")
					|| str15.equals("") || str16.equals("") || str17.equals("")) {
				JOptionPane.showMessageDialog(null, "The Record Field is Empty!!");

			} else {

				String temp = "UPDATE product SET " + "pro_no = '" + str10 + "',pro_name = '" + str11
						+ "',subpro_name = '" + str12 + "',subpro_catagory = '" + str13 + "',bakery = '" + str14
						+ "',des_pack = '" + str15 + "',des_weight = '" + str16 + "',status = '" + str17 + "',date = '"
						+ str18 + "'" + "WHERE pro_no = '" + str10 + "'";
				executeSQlQuery_productinfo(temp, "Updated");

			}

		} else if (source.equals(btn_deletepro)) {

			str10 = "";
			str10 = txt_productno.getText().trim();
			String query = "DELETE FROM `product` WHERE pro_no = " + str10;
			executeSQlQuery_productinfo(query, "Deleted Product");

		} else if (source.equals(btn_reset)) {
			resetText();

		} else if (source.equals(btn_wareadd)) {

			ware_status = "";
			ware_date = "";
			ware_year = "";
			ware_month = "";
			ware_amount = "";
			ware_description = "";
			ware_status = cmb_status.getSelectedItem();
			DateFormat f5 = DateFormat.getDateInstance(DateFormat.LONG);
			if (date_chooser_warehouse.getDate() == null) {
				JOptionPane.showMessageDialog(null, "The Recor field is Empty!!");

			} else {
				ware_date = f5.format(date_chooser_warehouse.getDate());
			}

			ware_year = txt_year.getText().trim();
			ware_month = cmb_month.getSelectedItem().toString();
			ware_amount = txt_field.getText().trim();
			ware_description = area.getText().trim();

			if (ware_status.equals("") || ware_year.equals("") || ware_month.equals("") || ware_amount.equals("")
					|| ware_description.equals("")) {
				JOptionPane.showMessageDialog(null, "The Record Field is Empty!!");

			} else {

				// private JTextField txt_search = new JTextField();
				String query = "INSERT INTO warehouse VALUES ('" + ware_month + "','" + ware_year + "','" + ware_date
						+ "','" + ware_amount + "','" + ware_description + "','" + ware_status + "')";

				executeSQlQuery_warehouse(query, "Add");
			}
			//
		} else if (source.equals(btn_wareupdate)) {
			ware_status = "";
			ware_date = "";
			ware_year = "";
			ware_month = "";
			ware_amount = "";
			ware_description = "";
			ware_status = cmb_status.getSelectedItem();
			DateFormat f5 = DateFormat.getDateInstance(DateFormat.LONG);
			if (date_chooser_warehouse.getDate() == null) {
				JOptionPane.showMessageDialog(null, "The Recor field is Empty!!");

			} else {
				ware_date = f5.format(date_chooser_warehouse.getDate());
			}

			ware_year = txt_year.getText().trim();
			ware_month = cmb_month.getSelectedItem().toString();
			ware_amount = txt_field.getText().trim();
			ware_description = area.getText().trim();

			if (ware_status.equals("") || ware_year.equals("") || ware_month.equals("") || ware_amount.equals("")
					|| ware_description.equals("")) {
				JOptionPane.showMessageDialog(null, "The Record Field is Empty!!");

			} else {
				String temp = "UPDATE warehouse SET " + "wa_month = '" + ware_month + "',wa_year = '" + ware_year
						+ "',wa_date = '" + ware_date + "',wa_amount = '" + ware_amount + "',wa_decription = '"
						+ ware_description + "',wa_status = '" + ware_status + "'" + "WHERE wa_date = '" + ware_date
						+ "'";

				executeSQlQuery_warehouse(temp, "Updated");

			}

		} else if (source.equals(btn_waredelete)) {
			String query = "DELETE FROM `warehouse` WHERE wa_date = " + date_chooser_warehouse.getDate();
			executeSQlQuery_warehouse(query, "Deleted Record!!");

		} else if (source.equals(btn_waresearcg)) {

			find_warehouseproduct();

		}

	}

	public void additem() {
		try {

			pan_warehouse_details.setVisible(false);

			pan_subproduct_details.setVisible(false);
			pan_details.setVisible(true);
			pan_internal_panel.setVisible(true);

			lbl_product.setVisible(true);
			lbl_productpack.setVisible(true);
			lbl_productweight.setVisible(true);
			lbl_subproduct.setVisible(true);
			txt_prductdespack.setVisible(true);
			txt_prductdeswe.setVisible(true);
			lbl_product_no.setVisible(true);
			lbl_product_name.setVisible(true);
			lbl_subproduc_tname.setVisible(true);
			lbl_catagory.setVisible(true);
			lbl_expire_date.setVisible(true);
			lbl_quantity.setVisible(true);
			lbl_price.setVisible(true);
			lbl_sellprice.setVisible(true);
			lbl_submitdate.setVisible(true);

			lbl_total_amount.setVisible(true);
			txt_product_no.setVisible(true);
			txt_product_name.setVisible(true);
			txt_subproduc_tname.setVisible(true);
			txt_catagory.setVisible(true);
			txt_subproduc_tname.setVisible(true);
			txt_subproduc_tname.setVisible(true);
			txt_expire_date.setVisible(true);
			txt_quantity.setVisible(true);
			txt_price.setVisible(true);
			txt_sellprice.setVisible(true);
			txt_submitdate.setVisible(true);
			txt_total_amount.setVisible(true);
			btn_add.setVisible(true);
			btn_update.setVisible(true);
			btn_delete.setVisible(true);
			btn_reproduct.setVisible(true);
			list.setVisible(true);
			list1.setVisible(true);
			txt_total_discount.setVisible(true);
			lbl_total_discount.setVisible(true);
			btnsubmit.setVisible(true);
			lbl_receivedproductid.setVisible(true);
			txt_receivedproductid.setVisible(true);
			table.setVisible(true);
			scrollpane.setVisible(true);
			lbl_search.setVisible(true);
			btn_search5.setVisible(true);
			pan_table.setVisible(true);
			lbl_subproduct.setVisible(true);

			//
			// // subitem
			pan_first.setVisible(false);
			btn_add1.setVisible(false);
			btn_update1.setVisible(false);
			btn_deletepro.setVisible(false);

			btn_reset.setVisible(false);

			btn_searchpro.setVisible(false);
			txt_productserch.setVisible(false);
			lbl_productno.setVisible(false);
			lbl_productname.setVisible(false);
			lbl_subproductname.setVisible(false);
			lbl_subproductcatagory.setVisible(false);
			lbl_bakeryname.setVisible(false);
			lbl_despacket.setVisible(false);
			lbl_deswithweight.setVisible(false);
			lbl_statu.setVisible(false);
			lbl_proadddate.setVisible(false);
			txt_productno.setVisible(false);
			txt_productname.setVisible(false);
			txt_subproductname.setVisible(false);
			txt_subproductcatagory.setVisible(false);
			txt_bakeryname.setVisible(false);
			txt_despacket.setVisible(false);
			txt_deswithweight.setVisible(false);
			txt_statu.setVisible(false);
			date_proadddate.setVisible(false);
			product_table.setVisible(false);
			product_scrollpane.setVisible(false);
			lbl_productnolist.setVisible(false);
			lbl_subproductnamelist.setVisible(false);
			list5.setVisible(false);
			list55.setVisible(false);
			String cat_subitem = (String) list55.getSelectedValue();// name
			list5.addMouseListener(this);

			// warehouse

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Eroror the maing gui addtem" + ex.toString());

		}
	}

	public void addsubitem() {
		try {
			pan_warehouse_details.setVisible(false);
			pan_subproduct_details.setVisible(true);

			// item product
			pan_internal_panel.setVisible(false);
			pan_details.setVisible(false);

			// item product

			lbl_product_no.setVisible(false);
			lbl_product.setVisible(false);
			lbl_productpack.setVisible(false);
			lbl_productweight.setVisible(false);
			lbl_subproduct.setVisible(false);
			txt_prductdespack.setVisible(false);
			txt_prductdeswe.setVisible(false);
			lbl_product_no.setVisible(false);
			lbl_product_name.setVisible(false);
			lbl_subproduc_tname.setVisible(false);
			lbl_catagory.setVisible(false);
			lbl_expire_date.setVisible(false);
			lbl_quantity.setVisible(false);
			lbl_price.setVisible(false);
			lbl_sellprice.setVisible(false);
			lbl_submitdate.setVisible(false);
			lbl_total_amount.setVisible(false);
			txt_product_no.setVisible(false);
			txt_product_name.setVisible(false);
			txt_subproduc_tname.setVisible(false);
			txt_catagory.setVisible(false);
			txt_subproduc_tname.setVisible(false);
			txt_subproduc_tname.setVisible(false);
			txt_expire_date.setVisible(false);
			txt_quantity.setVisible(false);
			txt_price.setVisible(false);
			txt_sellprice.setVisible(false);
			txt_submitdate.setVisible(false);
			txt_total_amount.setVisible(false);

			btn_add.setVisible(false);
			btn_update.setVisible(false);
			txt_total_discount.setVisible(false);
			lbl_total_discount.setVisible(false);
			btnsubmit.setVisible(false);
			lbl_receivedproductid.setVisible(false);
			txt_receivedproductid.setVisible(false);
			btn_delete.setVisible(false);
			btn_reproduct.setVisible(false);
			// btn_search.setVisible(false);
			list.setVisible(false);
			list1.setVisible(false);
			table.setVisible(false);
			scrollpane.setVisible(false);
			lbl_search.setVisible(false);
			btn_search5.setVisible(false);
			pan_table.setVisible(false);
			lbl_subproduct.setVisible(false);
			txt_total_discount.setVisible(false);
			lbl_total_discount.setVisible(false);

			//
			// /// subproduct
			//
			// // sub product

			pan_first.setVisible(true);
			btn_add1.setVisible(true);
			btn_update1.setVisible(true);
			btn_deletepro.setVisible(true);
			btn_reset.setVisible(true);

			btnsubmit.setVisible(false);
			btn_searchpro.setVisible(true);
			txt_productserch.setVisible(true);
			lbl_productno.setVisible(true);
			lbl_productname.setVisible(true);
			lbl_subproductname.setVisible(true);
			lbl_subproductcatagory.setVisible(true);
			lbl_bakeryname.setVisible(true);
			lbl_despacket.setVisible(true);
			lbl_deswithweight.setVisible(true);
			lbl_statu.setVisible(true);
			lbl_proadddate.setVisible(true);
			txt_productno.setVisible(true);
			txt_productname.setVisible(true);
			txt_subproductname.setVisible(true);
			txt_subproductcatagory.setVisible(true);
			txt_bakeryname.setVisible(true);
			txt_despacket.setVisible(true);
			txt_deswithweight.setVisible(true);
			txt_statu.setVisible(true);
			date_proadddate.setVisible(true);
			product_table.setVisible(true);
			product_scrollpane.setVisible(true);
			lbl_productnolist.setVisible(true);
			lbl_subproductnamelist.setVisible(true);
			list5.setVisible(true);
			list55.setVisible(true);

			// warehouse

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Eroror the maing gui subitem" + ex.toString());

		}
	}

	public void warehouse() {
		try {

			pan_warehouse_details.setVisible(true);
			pan_subproduct_details.setVisible(false);
			pan_details.setVisible(false);
			lbl_product.setVisible(false);
			///////////////////////////////////////////////////////////////////////// prduct
			pan_first.setVisible(false);
			btn_add1.setVisible(false);
			btn_update1.setVisible(false);

			txt_total_discount.setVisible(false);
			lbl_total_discount.setVisible(false);
			btnsubmit.setVisible(false);
			lbl_receivedproductid.setVisible(false);
			txt_receivedproductid.setVisible(false);
			btn_deletepro.setVisible(false);
			btn_reset.setVisible(false);
			btn_searchpro.setVisible(false);
			txt_productserch.setVisible(false);
			lbl_productno.setVisible(false);
			lbl_productname.setVisible(false);
			lbl_subproductname.setVisible(false);
			lbl_subproductcatagory.setVisible(false);
			lbl_bakeryname.setVisible(false);
			lbl_despacket.setVisible(false);
			lbl_deswithweight.setVisible(false);
			lbl_statu.setVisible(false);
			lbl_proadddate.setVisible(false);
			txt_productno.setVisible(false);
			txt_productname.setVisible(false);
			txt_subproductname.setVisible(false);
			txt_subproductcatagory.setVisible(false);
			txt_bakeryname.setVisible(false);
			txt_despacket.setVisible(false);
			txt_deswithweight.setVisible(false);
			txt_statu.setVisible(false);
			date_proadddate.setVisible(false);
			product_table.setVisible(false);
			product_scrollpane.setVisible(false);
			lbl_productnolist.setVisible(false);
			lbl_subproductnamelist.setVisible(false);
			list5.setVisible(false);
			list55.setVisible(false);

			///////////////////////////////////////////////////////////////////////// prduct
			lbl_productpack.setVisible(false);
			lbl_productweight.setVisible(false);
			lbl_subproduct.setVisible(false);
			txt_prductdespack.setVisible(false);
			txt_prductdeswe.setVisible(false);
			lbl_product_no.setVisible(false);
			lbl_product_name.setVisible(false);
			lbl_subproduc_tname.setVisible(false);
			lbl_catagory.setVisible(false);
			lbl_expire_date.setVisible(false);
			lbl_quantity.setVisible(false);
			lbl_price.setVisible(false);
			lbl_sellprice.setVisible(false);
			lbl_submitdate.setVisible(false);
			lbl_total_amount.setVisible(false);
			txt_product_no.setVisible(false);
			txt_product_name.setVisible(false);
			txt_subproduc_tname.setVisible(false);
			txt_catagory.setVisible(false);
			txt_subproduc_tname.setVisible(false);
			txt_subproduc_tname.setVisible(false);
			txt_expire_date.setVisible(false);
			txt_quantity.setVisible(false);
			txt_price.setVisible(false);
			txt_sellprice.setVisible(false);
			txt_submitdate.setVisible(false);
			txt_total_amount.setVisible(false);
			btn_add.setVisible(false);
			btn_update.setVisible(false);
			txt_total_discount.setVisible(false);
			lbl_total_discount.setVisible(false);
			lbl_receivedproductid.setVisible(false);
			txt_receivedproductid.setVisible(false);
			btnsubmit.setVisible(false);
			btn_delete.setVisible(false);
			btn_reproduct.setVisible(false);
			// btn_search.setVisible(false);
			list.setVisible(false);
			list1.setVisible(false);
			table.setVisible(false);
			scrollpane.setVisible(false);
			lbl_search.setVisible(false);
			btn_search5.setVisible(false);
			pan_table.setVisible(false);
			lbl_subproduct.setVisible(false);

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "errorr teh warehouse" + ex.toString());

		}
	}

	public void addexit() {
		try {
			dispose();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Eroror the maing gui exit" + ex.toString());

		}
	}

	public void resetText() {

		area.setText("");
		txt_field.setText("");
		txt_year.setText("");
		txt_search.setText("");
		cmb_month.setSelectedItem("");
		cmb_status.setSelectedItem("");
		date_chooser_warehouse.setDate(null);
		txt_statu.setText("");
		date_proadddate.setDate(null);
		txt_productserch.setText("");
		txt_productno.setText("");
		txt_productname.setText("");
		txt_subproductname.setText("");
		txt_subproductcatagory.setText("");
		txt_bakeryname.setText("");
		txt_despacket.setText("");
		txt_deswithweight.setText("");
		txt_product_no.setText("");
		txt_product_name.setText("");
		txt_subproduc_tname.setText("");
		txt_catagory.setText("");
		txt_subproduc_tname.setText("");
		txt_subproduc_tname.setText("");
		txt_expire_date.setDate(null);
		txt_quantity.setText("");
		txt_price.setText("");
		txt_sellprice.setText("");
		txt_submitdate.setDate(null);
		txt_total_amount.setText("");
		txt_receivedproductid.setText("");

	}

	@Override
	public void mouseClicked(MouseEvent event) {
		int i = table.getSelectedRow();
		TableModel model = table.getModel();
		txt_receivedproductid.setText(model.getValueAt(i, 0).toString());
		txt_product_no.setText(model.getValueAt(i, 1).toString());
		txt_product_name.setText(model.getValueAt(i, 2).toString());
		txt_subproduc_tname.setText(model.getValueAt(i, 3).toString());
		txt_catagory.setText(model.getValueAt(i, 4).toString());
		txt_subproduc_tname.setText(model.getValueAt(i, 5).toString());
		txt_quantity.setText(model.getValueAt(i, 6).toString());
		txt_price.setText(model.getValueAt(i, 7).toString());
		txt_sellprice.setText(model.getValueAt(i, 8).toString());
		txt_total_amount.setText(model.getValueAt(i, 10).toString());

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
	public void mousePressed(MouseEvent event) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	class sager implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {
			int j = tbl_warehouse.getSelectedRow();
			TableModel model1 = tbl_warehouse.getModel();
			cmb_month.setSelectedItem(model1.getValueAt(j, 0).toString());
			txt_year.setText(model1.getValueAt(j, 1).toString());
			txt_field.setText(model1.getValueAt(j, 3).toString());
			area.setText(model1.getValueAt(j, 4).toString());
			cmb_status.setSelectedItem(model1.getValueAt(j, 5).toString());
			
			
			

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class Mouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {
			int j = product_table.getSelectedRow();
			TableModel model = product_table.getModel();
			txt_productno.setText(model.getValueAt(j, 0).toString());
			txt_productname.setText(model.getValueAt(j, 1).toString());
			txt_subproductname.setText(model.getValueAt(j, 2).toString());
			txt_subproductcatagory.setText(model.getValueAt(j, 3).toString());
			txt_bakeryname.setText(model.getValueAt(j, 4).toString());
			txt_despacket.setText(model.getValueAt(j, 5).toString());
			txt_deswithweight.setText(model.getValueAt(j, 6).toString());
			txt_statu.setText(model.getValueAt(j, 7).toString());
			date_proadddate.setDateFormatString((String) model.getValueAt(j, 8));

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