package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
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
import Model.settingReportinfo;
import Model.yearlyReporInfo;

public class SettingRepor extends JInternalFrame implements ActionListener, MouseListener {
	private JButton btn_mainmenu = new JButton("Home");
	private JButton btn_calsallary = new JButton("Month");
	private JButton btn_viewsallary = new JButton("View");
	private JButton btn_yearsetting = new JButton("Year");
	private JButton btn_viewyear = new JButton("View");
	Connection conn;
	Databaseconnect connect = new Databaseconnect();
	JFrame JFParentFrame;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	JComboBox<String> cmb_customer = new JComboBox<String>();
	JComboBox<String> cmb_numofclient = new JComboBox<String>();
	JComboBox<String> cmb_Item = new JComboBox<String>();
	JComboBox<String> cmb_Subitem = new JComboBox<String>();
	JComboBox<String> cmb_vandetails = new JComboBox<String>();

	JComboBox<String> cmb_Order = new JComboBox<String>();
	JComboBox<String> cmb_sallaryemp = new JComboBox<String>();
	JComboBox<String> cmb_warehouse = new JComboBox<String>();

	JComboBox<String> cmb_orderfromclient = new JComboBox<String>();
	private JList<String> list = new JList<String>();
	private JList<String> list1 = new JList<String>();
	JPanel pan_details = new JPanel();

	JPanel pan_left = new JPanel();
	JPanel pan_right = new JPanel();
	JPanel pan_right_product2 = new JPanel();
	JPanel pan_so = new JPanel();
	// fo month view

	JPanel pan_viewmonth = new JPanel();
	JPanel pan_viewmontable = new JPanel();
	JPanel pan_addyearreport = new JPanel();
	JPanel pan_viewyear = new JPanel();
	JButton btn_searyear = new JButton("Search");// this view year
	JTextField txt_searyear = new JTextField();
	JTextField txt_year = new JTextField();
	JButton btn_addyear = new JButton("Add");
	JButton btn_updateyear = new JButton("Update");
	JButton btn_deleteyear = new JButton("Delete");

	// 1

	CustomerOrder order;
	JTextField txt_numofservice = new JTextField();
	JTextField txt_numofemployee = new JTextField();
	JTextField txt_servicesallary = new JTextField();
	JTextField txt_employeesallary = new JTextField();
	JTextField txt_totalcostwarehouse = new JTextField();
	JTextField txt_numberoforder = new JTextField();
	JTextField txt_totalcost = new JTextField();
	JTextField txt_fromclient = new JTextField();
	JTextField txt_fromhere = new JTextField();
	JTextField txt_fromhereamount = new JTextField();
	JTextField txt_fromclientamount = new JTextField();
	JTextField txt_Id = new JTextField();
	//

	JTextField txt_year_s_totalcost = new JTextField();
	JTextField txt_year_emp_totalcost = new JTextField();
	JTextField txt_year_warehouse_totalcost = new JTextField();
	JTextField txt_year_numberof_order = new JTextField();
	JTextField txt_year_order_totalcost = new JTextField();
	JTextField txt_year_orderfromclient = new JTextField();
	JTextField txt_year_orderfromhere = new JTextField();
	JTextField txt_year_orderfromclient_totalcost = new JTextField();
	JTextField txt_year_orderfromhere_totalcost = new JTextField();
	//
	JTextField txt_1 = new JTextField();
	JTextField txt_2 = new JTextField();
	JTextField txt_3 = new JTextField();
	JTextField txt_4 = new JTextField();
	JTextField txt_5 = new JTextField();
	JTextField txt_6 = new JTextField();
	JTextField txt_7 = new JTextField();
	JTextField txt_8 = new JTextField();
	JTextField txt_9 = new JTextField();
	//
	/**
	 * 
	 */
	//

	JLabel lbl_search = new JLabel("Search");
	JTextField txt_search = new JTextField("cow");
	JButton btn_search = new JButton("Search");
	JTable table_month = new JTable();
	JScrollPane pane_month = new JScrollPane();
	JTable table_viewyear = new JTable();
	JScrollPane pane_viewyear = new JScrollPane();

	//
	String description, amount;
	String st1, st2, st3, st4, st5, st6, st7, st8, st9;
	private JButton btn_add = new JButton("Save");
	private JButton btn_update = new JButton("Update");
	private JButton btn_delete = new JButton("Delete");
	private JButton btn_clear = new JButton("Clear");
	JDateChooser date = new JDateChooser();
	private JList<String> list3 = new JList<String>();
	private JList<String> list4 = new JList<String>();
	public static int record;

	String str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17,
			str18, str19;
	public String countroworder;
	public String sumstatus;
	public int multiply_serviceprovider, multiply_employee;
	public String year1, year2, year3, year4, year5, year6, year7, year8, year9;

	JButton btn_getorderdeatisquery = new JButton("Order");
	JButton btn_getmonthvalue = new JButton("Month Value");
	JTextField txt_statusformonthlyreport = new JTextField();

	JButton btn_senddate = new JButton("Send Data");

	private static final long serialVersionUID = 1L;

	/// new tow text for total amount date

	JTextField txt_Totalorder_cost = new JTextField();
	JTextField txt_Total_costbakery = new JTextField();

	//

	public SettingRepor(JFrame getParentFrame) {
		super("Setting Report", true, true, true, true);
		this.setSize(1010, 550);
		this.setLayout(null);
		JPanel pan = new JPanel();
		pan.setLayout(null);
		pan.setBounds(0, 0, 130, 850);

		Border thickBorder = new LineBorder(Color.decode("#394B58"), 12);
		btn_calsallary.setBounds(20, 160, 80, 80);
		btn_mainmenu.setBounds(20, 60, 80, 80);
		btn_viewsallary.setBorder(thickBorder);
		btn_viewsallary.setBounds(20, 260, 80, 80);

		btn_viewyear.setBorder(thickBorder);
		btn_yearsetting.setBorder(thickBorder);
		btn_viewyear.setBounds(20, 460, 80, 80);
		btn_yearsetting.setBounds(20, 360, 80, 80);
		btn_viewyear.setBackground(Color.decode("#250800"));
		btn_yearsetting.setBackground(Color.decode("#250800"));
		btn_viewyear.setForeground(Color.WHITE);
		btn_yearsetting.setForeground(Color.WHITE);
		btn_viewyear.addActionListener(this);
		btn_yearsetting.addActionListener(this);

		btn_viewsallary.setBackground(Color.decode("#250800"));
		btn_viewsallary.setForeground(Color.WHITE);
		btn_viewsallary.addActionListener(this);
		btn_mainmenu.setBackground(Color.decode("#250800"));
		btn_calsallary.setBackground(Color.decode("#250800"));
		btn_mainmenu.setForeground(Color.WHITE);
		btn_calsallary.setForeground(Color.WHITE);
		btn_mainmenu.setBorder(thickBorder);
		btn_calsallary.setBorder(thickBorder);
		Action action = new Action();
		btn_mainmenu.addActionListener(action);
		btn_calsallary.addActionListener(action);
		pan.add(btn_mainmenu);
		pan.add(btn_calsallary);
		pan.add(btn_viewsallary);
		pan.add(btn_viewyear);
		pan.add(btn_yearsetting);
		pan.setBackground(Color.decode("#D2DDF1"));
		Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		pan_details.setBorder(raisedetched);
		pan_details.setBounds(200, 50, 1100, 500);
		pan_details.setLayout(null);

		TitledBorder reg_Border = BorderFactory.createTitledBorder("Search By ID");
		reg_Border.setTitleJustification(TitledBorder.LEFT);
		pan_left.setBorder(reg_Border);
		pan_left.setBounds(20, 20, 350, 460);
		pan_left.setLayout(null);

		TitledBorder reg_Border_reg = BorderFactory.createTitledBorder("Products");
		reg_Border_reg.setTitleJustification(TitledBorder.LEFT);
		pan_right.setBorder(reg_Border_reg);
		pan_right.setBounds(700, 20, 375, 240);
		JLabel lbl_listwarehouse = new JLabel("Warehouse Details");
		lbl_listwarehouse.setBounds(35, 10, 150, 30);
		list.setBounds(15, 40, 170, 190);
		JLabel lbl_employee1 = new JLabel("Identify Employee");
		lbl_employee1.setBounds(210, 10, 150, 30);
		list1.setBounds(190, 40, 170, 190);
		list1.setBorder(new LineBorder(Color.gray, 1));
		list.setBorder(new LineBorder(Color.gray, 1));

		pan_right.add(list);
		pan_right.add(list1);
		pan_right.add(lbl_employee1);
		pan_right.add(lbl_listwarehouse);

		pan_right.setLayout(null);

		TitledBorder reg_Bord_product2 = BorderFactory.createTitledBorder("Products 2");
		reg_Bord_product2.setTitleJustification(TitledBorder.LEFT);
		pan_right_product2.setBorder(reg_Bord_product2);
		pan_right_product2.setBounds(700, 260, 375, 220);

		JLabel lbl_sallary = new JLabel("Identify Employee");
		JLabel lbl_clientorder = new JLabel("Number Of Order");
		lbl_sallary.setBounds(35, 10, 150, 30);
		lbl_clientorder.setBounds(210, 10, 150, 30);

		pan_right_product2.add(lbl_sallary);
		pan_right_product2.add(lbl_clientorder);

		list3.setBounds(15, 40, 170, 120);
		list4.setBounds(190, 40, 170, 120);
		list3.setBorder(new LineBorder(Color.gray, 1));
		list4.setBorder(new LineBorder(Color.gray, 1));

		btn_add.setBounds(15, 180, 100, 30);
		btn_update.setBounds(125, 180, 100, 30);
		btn_delete.setBounds(235, 180, 100, 30);

		pan_right_product2.add(btn_add);
		pan_right_product2.add(btn_update);
		pan_right_product2.add(btn_delete);

		pan_right_product2.add(list3);
		pan_right_product2.add(list4);
		pan_right_product2.setLayout(null);
		pan_details.add(pan_right_product2);

		TitledBorder reg_Border_reg1 = BorderFactory.createTitledBorder("Actions");
		reg_Border_reg1.setTitleJustification(TitledBorder.LEFT);
		pan_so.setBorder(reg_Border_reg1);
		pan_so.setBounds(375, 20, 320, 460);

		btn_add.addActionListener(action);
		btn_update.addActionListener(action);
		btn_delete.addActionListener(action);
		btn_updateyear.addActionListener(action);

		JLabel lbl_numofservice = new JLabel("Num of Service Provider");
		JLabel lbl_numofemployee = new JLabel("Num of Employee");
		JLabel lbl_servicesallary = new JLabel("Total Amount Sallary(Supplier)");
		JLabel lbl_employeesallary = new JLabel("Total Amount Sallary(Employee)");
		JLabel lbl_totalcostwarehouse = new JLabel("Total Cost Warehouse");
		JLabel lbl_numberoforder = new JLabel("Number of Order Permonth");
		JLabel lbl_totalcost = new JLabel("Total Order Amount");

		JLabel lbl_fromclient = new JLabel("Order from client");
		JLabel lbl_fromhere = new JLabel("Order form here");

		JLabel lbl_fromhereorderform = new JLabel("Total Amount Order From");
		JLabel lbl_fromherefromclint = new JLabel("Total Amount Order From Client");

		JLabel lbl_id = new JLabel("Id");

		txt_numofservice.setBounds(200, 20, 100, 30);
		txt_numofemployee.setBounds(200, 60, 100, 30);
		txt_servicesallary.setBounds(200, 100, 100, 30);
		txt_employeesallary.setBounds(200, 140, 100, 30);
		txt_totalcostwarehouse.setBounds(200, 180, 100, 30);
		txt_numberoforder.setBounds(200, 220, 100, 30);
		txt_totalcost.setBounds(200, 260, 100, 30);
		txt_fromclient.setBounds(200, 300, 100, 30);
		txt_fromhere.setBounds(200, 340, 100, 30);

		txt_fromhereamount.setBounds(200, 380, 100, 30);
		txt_fromclientamount.setBounds(200, 420, 100, 30);

		pan_so.add(txt_fromhereamount);
		pan_so.add(txt_fromclientamount);

		pan_so.add(txt_fromclient);
		pan_so.add(txt_fromhere);

		pan_so.add(txt_numofservice);
		pan_so.add(txt_numofemployee);
		pan_so.add(txt_servicesallary);
		pan_so.add(txt_employeesallary);
		pan_so.add(txt_totalcostwarehouse);
		pan_so.add(txt_numberoforder);
		pan_so.add(txt_totalcost);

		lbl_numofservice.setBounds(20, 20, 200, 30);
		lbl_numofemployee.setBounds(20, 60, 200, 30);
		lbl_servicesallary.setBounds(20, 100, 200, 30);
		lbl_employeesallary.setBounds(20, 140, 200, 30);
		lbl_totalcostwarehouse.setBounds(20, 180, 200, 30);
		lbl_numberoforder.setBounds(20, 220, 200, 30);
		lbl_totalcost.setBounds(20, 260, 200, 30);

		lbl_fromclient.setBounds(20, 300, 200, 30);
		lbl_fromhere.setBounds(20, 340, 200, 30);
		lbl_fromhereorderform.setBounds(20, 380, 200, 30);
		lbl_fromherefromclint.setBounds(20, 420, 200, 30);

		pan_so.add(lbl_fromhereorderform);
		pan_so.add(lbl_fromherefromclint);
		pan_so.add(lbl_fromclient);
		pan_so.add(lbl_fromhere);
		pan_so.add(lbl_numofservice);
		pan_so.add(lbl_numofemployee);
		pan_so.add(lbl_servicesallary);
		pan_so.add(lbl_employeesallary);
		pan_so.add(lbl_totalcostwarehouse);
		pan_so.add(lbl_numberoforder);
		pan_so.add(lbl_totalcost);
		pan_so.setLayout(null);

		// JLabel lbl_

		pan_details.add(pan_so);
		JLabel lbl_customer = new JLabel("Num Of Customer");
		JLabel lbl_Item = new JLabel("Num Of Item");
		JLabel lbl_Subitem = new JLabel("Num Of StockItem");
		JLabel lbl_employee = new JLabel("Num Of Employee");
		JLabel lbl_sallaryemp = new JLabel("Sallary Employee");
		JLabel lbl_warehouse = new JLabel("Sallary Warehouse");
		JLabel lbl_vandetails = new JLabel("Vandetails");
		JLabel lbl_numofclient = new JLabel("Num of Client");

		lbl_customer.setBounds(10, 20, 100, 30);
		lbl_Item.setBounds(10, 70, 100, 30);
		lbl_Subitem.setBounds(10, 120, 100, 30);
		lbl_employee.setBounds(10, 170, 100, 30);
		lbl_sallaryemp.setBounds(10, 220, 100, 30);
		lbl_warehouse.setBounds(10, 270, 120, 30);
		lbl_vandetails.setBounds(10, 320, 100, 30);
		lbl_numofclient.setBounds(10, 370, 100, 30);
		JLabel lbl_orderfromclient = new JLabel("Order fromclient");
		lbl_orderfromclient.setBounds(10, 415, 100, 30);
		cmb_orderfromclient.setBounds(125, 420, 185, 30);
		pan_left.add(lbl_orderfromclient);
		pan_left.add(cmb_orderfromclient);

		cmb_customer.setBounds(125, 25, 185, 25);
		cmb_Item.setBounds(125, 75, 185, 25);
		cmb_Subitem.setBounds(125, 125, 185, 25);
		cmb_Order.setBounds(125, 175, 185, 25);
		cmb_sallaryemp.setBounds(125, 225, 185, 25);
		cmb_warehouse.setBounds(125, 275, 185, 25);
		cmb_vandetails.setBounds(125, 325, 185, 25);
		cmb_numofclient.setBounds(125, 375, 185, 25);
		pan_left.add(cmb_customer);
		pan_left.add(cmb_Item);
		pan_left.add(cmb_Subitem);
		pan_left.add(cmb_Order);
		pan_left.add(cmb_sallaryemp);
		pan_left.add(cmb_warehouse);
		pan_left.add(cmb_vandetails);
		pan_left.add(cmb_numofclient);
		retrive_customer(cmb_customer);
		retrive_vandetails(cmb_vandetails);
		retrive_emergencycontact(cmb_numofclient);
		retrive_Item(cmb_Item);
		retrive_Stock(cmb_Subitem);
		retrive_warehouse(cmb_warehouse);
		retrive_sallary(cmb_sallaryemp);
		cmb_sallaryemp.addActionListener(this);
		cmb_warehouse.addActionListener(this);
		cmb_Order.addActionListener(this);
		String sallary = (String) cmb_sallaryemp.getSelectedItem();
		fill_sallary(sallary);

		String str = (String) cmb_warehouse.getSelectedItem();
		fill_upwarehouse(str);

		retrive_identifyEmployee(cmb_Order);

		String str1 = (String) cmb_Order.getSelectedItem();
		fill_upemploey(str1);

		retrive_Orderfromclient(cmb_orderfromclient);
		cmb_orderfromclient.addActionListener(this);

		String fromclient = (String) cmb_orderfromclient.getSelectedItem();
		retrive_Orderfromclient(fromclient);

		pan_left.add(lbl_customer);
		pan_left.add(lbl_Item);
		pan_left.add(lbl_Subitem);
		pan_left.add(lbl_employee);
		pan_left.add(lbl_sallaryemp);
		pan_left.add(lbl_warehouse);
		pan_left.add(lbl_vandetails);
		pan_left.add(lbl_numofclient);
		pan_details.add(pan_left);
		pan_details.add(pan_right);

		JLabel lbl_date = new JLabel("Date :");
		lbl_date.setBounds(1080, 10, 100, 30);
		date.setBounds(1140, 15, 160, 25);
		btn_clear.setBounds(690, 15, 140, 25);
		txt_Id.setBounds(250, 15, 140, 25);
		lbl_id.setBounds(200, 15, 50, 25);

		JLabel lbl_statusformonthlyreport = new JLabel("Monthly Status");
		btn_getorderdeatisquery.setBounds(400, 15, 80, 25);
		btn_getmonthvalue.setBounds(400, 15, 80, 25);
		lbl_statusformonthlyreport.setBounds(490, 15, 80, 25);
		txt_statusformonthlyreport.setBounds(570, 15, 80, 25);

		btn_getorderdeatisquery.addActionListener(action);
		btn_getmonthvalue.addActionListener(action);
		this.add(btn_getmonthvalue);
		this.add(lbl_statusformonthlyreport);
		this.add(txt_statusformonthlyreport);
		this.add(btn_getorderdeatisquery);

		// start pael send data

		/// sager sager query for your query for your for your

		JLabel lbl_year_s_totalcost = new JLabel("Total Cost Service Provider");
		JLabel lbl_year_emp_totalcost = new JLabel("Total Cost Employee");
		JLabel lbl_year_warehouse_totalcost = new JLabel("Total Cost Warehouse");
		JLabel lbl_year_numberof_order = new JLabel("Number of Order");
		JLabel lbl_year_order_totalcost = new JLabel("Total Order Cost");
		JLabel lbl_year_orderfromclient = new JLabel("Emergencey Order");
		JLabel lbl_year_orderfromhere = new JLabel("Number of Order From Here");
		JLabel lbl_year_orderfromclient_totalcost = new JLabel("Totalcost Emergencey");
		JLabel lbl_year_orderfromhere_totalcost = new JLabel("Order From Here Totalcost");

		// add year else nothing

		// add year else nothing
		pan_viewmonth.setBounds(20, 20, 1060, 150);
		pan_viewmonth.setLayout(null);
		TitledBorder value_send = BorderFactory.createTitledBorder("");
		value_send.setTitleJustification(TitledBorder.LEFT);
		pan_viewmonth.setBorder(value_send);
		lbl_year_s_totalcost.setBounds(10, 15, 200, 30);
		lbl_year_emp_totalcost.setBounds(10, 60, 200, 30);
		lbl_year_warehouse_totalcost.setBounds(10, 105, 200, 30);
		lbl_year_numberof_order.setBounds(320, 15, 200, 30);
		lbl_year_order_totalcost.setBounds(320, 60, 200, 30);
		lbl_year_orderfromclient.setBounds(320, 105, 240, 30);
		txt_year_numberof_order.setBounds(470, 15, 150, 25);
		txt_year_order_totalcost.setBounds(470, 60, 150, 25);
		txt_year_orderfromclient.setBounds(470, 105, 150, 25);
		lbl_year_orderfromhere.setBounds(630, 15, 200, 30);
		lbl_year_orderfromclient_totalcost.setBounds(630, 60, 200, 30);
		lbl_year_orderfromhere_totalcost.setBounds(630, 105, 200, 30);
		txt_year_orderfromhere.setBounds(780, 15, 150, 25);
		txt_year_orderfromclient_totalcost.setBounds(780, 60, 150, 25);
		txt_year_orderfromhere_totalcost.setBounds(780, 105, 150, 25);
		btn_senddate.setBounds(950, 105, 100, 25);
		txt_year_s_totalcost.setBounds(160, 15, 150, 25);
		txt_year_emp_totalcost.setBounds(160, 60, 150, 25);
		txt_year_warehouse_totalcost.setBounds(160, 105, 150, 25);
		btn_senddate.addActionListener(action);
		pan_viewmonth.add(btn_senddate);
		pan_viewmonth.add(txt_year_orderfromhere);
		pan_viewmonth.add(txt_year_orderfromclient_totalcost);
		pan_viewmonth.add(txt_year_orderfromhere_totalcost);
		pan_viewmonth.add(lbl_year_orderfromhere);
		pan_viewmonth.add(lbl_year_orderfromclient_totalcost);
		pan_viewmonth.add(lbl_year_orderfromhere_totalcost);
		pan_viewmonth.add(lbl_year_numberof_order);
		pan_viewmonth.add(lbl_year_order_totalcost);
		pan_viewmonth.add(lbl_year_orderfromclient);
		pan_viewmonth.add(txt_year_numberof_order);
		pan_viewmonth.add(txt_year_order_totalcost);
		pan_viewmonth.add(txt_year_orderfromclient);
		pan_viewmonth.add(txt_year_s_totalcost);
		pan_viewmonth.add(txt_year_emp_totalcost);
		pan_viewmonth.add(txt_year_warehouse_totalcost);
		pan_viewmonth.add(lbl_year_s_totalcost);
		pan_viewmonth.add(lbl_year_emp_totalcost);
		pan_viewmonth.add(lbl_year_warehouse_totalcost);
		txt_search.setBounds(460, 190, 180, 25);
		btn_search.setBounds(660, 190, 100, 25);
		btn_search.addActionListener(action);
		pan_details.add(btn_search);
		pan_details.add(txt_search);

		// another panel

		pan_viewmontable.setBounds(20, 240, 1060, 250);
		TitledBorder value_table = BorderFactory.createTitledBorder("");
		value_table.setTitleJustification(TitledBorder.LEFT);
		pan_viewmontable.setBorder(value_table);
		table_month.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "MonthId", "Customer", "Item", "Stock", "Van", "Patner", "ServiceProvider", "Employee",
						"Sallary(supplier)", "sallary(Emp)", "Warehouse(cost)", "Order", "Order(cost)",
						"Emergencyorder", "Orderfromhere", "Cost(Emergency)", "cost(Hire),", "Date", "Status" }));
		pane_month.setViewportView(table_month);
		table_month.addMouseListener(this);
		pan_viewmontable.add(pane_month);
		pan_details.add(pan_viewmontable);
		pan_viewmontable.setLayout(new GridLayout());
		btn_clear.addActionListener(this);

		TitledBorder value_addyear = BorderFactory.createTitledBorder("");
		value_addyear.setTitleJustification(TitledBorder.LEFT);
		pan_addyearreport.setBorder(value_addyear);
		pan_addyearreport.setLayout(null);
		pan_addyearreport.setBounds(70, 70, 970, 360);
		pan_addyearreport.setBackground(Color.decode("#C7CFD9"));

		JLabel lbl_1 = new JLabel("Total Cost Service Provider");
		JLabel lbl_2 = new JLabel("Total Cost Employee");
		JLabel lbl_3 = new JLabel("Total Cost Warehouse");
		JLabel lbl_4 = new JLabel("Number of Order");
		JLabel lbl_5 = new JLabel("Total Order Cost");
		JLabel lbl_6 = new JLabel("Emergencey Order");
		JLabel lbl_7 = new JLabel("Number of Order From Here");
		JLabel lbl_8 = new JLabel("Totalcost Emergencey");
		JLabel lbl_9 = new JLabel("Order From Here Totalcost");

		lbl_1.setBounds(10, 15, 200, 30);
		lbl_2.setBounds(10, 60, 200, 30);
		lbl_3.setBounds(10, 105, 200, 30);
		lbl_4.setBounds(320, 15, 200, 30);
		lbl_5.setBounds(320, 60, 200, 30);
		lbl_6.setBounds(320, 105, 240, 30);
		lbl_7.setBounds(630, 15, 200, 30);
		lbl_8.setBounds(630, 60, 200, 30);
		lbl_9.setBounds(630, 105, 200, 30);
		txt_1.setBounds(470, 15, 150, 25);
		txt_2.setBounds(470, 60, 150, 25);
		txt_3.setBounds(470, 105, 150, 25);
		//
		txt_4.setBounds(800, 15, 150, 25);
		txt_5.setBounds(800, 60, 150, 25);
		txt_6.setBounds(800, 105, 150, 25);

		txt_7.setBounds(160, 15, 150, 25);
		txt_8.setBounds(160, 60, 150, 25);
		txt_9.setBounds(160, 105, 150, 25);

		JLabel lbl_year = new JLabel("Year");
		JLabel lbl_Total_costbakery = new JLabel("Total Cost");
		JLabel lbl_Totalorder_cost = new JLabel("Total Order cost(Amount)");

		lbl_Totalorder_cost.setBounds(320, 180, 240, 30);
		txt_Totalorder_cost.setBounds(470, 180, 150, 25);

		lbl_Total_costbakery.setBounds(630, 180, 200, 30);
		txt_Total_costbakery.setBounds(800, 180, 150, 25);

		lbl_year.setBounds(20, 180, 80, 30);
		txt_year.setBounds(160, 180, 150, 25);

		///

		btn_addyear.setBounds(230, 310, 140, 25);
		btn_updateyear.setBounds(385, 310, 140, 25);
		btn_deleteyear.setBounds(540, 310, 140, 25);

		btn_addyear.addActionListener(action);
		btn_updateyear.addActionListener(action);
		btn_deleteyear.addActionListener(action);

		pan_addyearreport.add(btn_deleteyear);
		pan_addyearreport.add(btn_addyear);
		pan_addyearreport.add(btn_updateyear);

		pan_addyearreport.add(lbl_Totalorder_cost);
		pan_addyearreport.add(txt_Totalorder_cost);

		pan_addyearreport.add(lbl_Total_costbakery);
		pan_addyearreport.add(txt_Total_costbakery);

		pan_addyearreport.add(txt_year);
		pan_addyearreport.add(lbl_year);
		pan_addyearreport.add(lbl_1);
		pan_addyearreport.add(lbl_2);
		pan_addyearreport.add(lbl_3);
		pan_addyearreport.add(lbl_4);
		pan_addyearreport.add(lbl_5);
		pan_addyearreport.add(lbl_6);
		pan_addyearreport.add(lbl_7);
		pan_addyearreport.add(lbl_8);
		pan_addyearreport.add(lbl_9);
		pan_addyearreport.add(txt_1);
		pan_addyearreport.add(txt_2);
		pan_addyearreport.add(txt_3);
		pan_addyearreport.add(txt_4);
		pan_addyearreport.add(txt_5);
		pan_addyearreport.add(txt_6);
		pan_addyearreport.add(txt_7);
		pan_addyearreport.add(txt_8);
		pan_addyearreport.add(txt_9);
		txt_searyear.setBounds(470, 50, 180, 25);
		btn_searyear.setBounds(660, 50, 100, 25);
		btn_searyear.addActionListener(action);
		pan_details.add(btn_searyear);
		pan_details.add(txt_searyear);

		TitledBorder view_year = BorderFactory.createTitledBorder("");
		view_year.setTitleJustification(TitledBorder.LEFT);
		pan_viewyear.setBorder(view_year);
		pan_viewyear.setLayout(new GridLayout());
		pan_viewyear.setBounds(50, 100, 1010, 360);
		table_viewyear.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "YearId", "TotalCost(Emp)", "Totalcost(S)", "TotalCost(Ware)", "NumberofOrder",
						"TotalOrderCost", "Emer(Order)", "Order(Here)", "TotalCost(Emerg)", "TotalCost(here)", "Date",
						"Year" }));

		Operation operation = new Operation();
		table_viewyear.addMouseListener(operation);

		pane_viewyear.setViewportView(table_viewyear);
		pan_viewyear.add(pane_viewyear);
		pan_details.add(pan_viewyear);
		pan_details.add(pan_addyearreport);
		// pan_details.setBackground(Color.decode("#5678A1"));
		pan_details.add(pan_viewmonth);

		btn_getmonthvalue.setVisible(false);
		//
		this.add(lbl_date);
		this.add(date);
		this.add(btn_clear);
		this.add(txt_Id);
		this.add(pan_details);
		this.add(lbl_id);
		this.add(pan);
		visibletrue();
		Show_productreceivemod();
		Show_productreceivemodyear();
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

	public void executeSQlQuery_monthreport(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {
				DefaultTableModel model = (DefaultTableModel) table_month.getModel();
				DefaultTableModel model1 = (DefaultTableModel) table_viewyear.getModel();
				model.setRowCount(0);
				model1.setRowCount(0);
				Show_productreceivemod();
				Show_productreceivemodyear();
				reset();
				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<settingReportinfo> receiveorderinfo() {
		ArrayList<settingReportinfo> usersList = new ArrayList<settingReportinfo>();
		Connection connection = getConnection();
		String query = "SELECT * FROM  `monthly_report`";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			settingReportinfo user;
			while (rs.next()) {
				user = new settingReportinfo(rs.getInt("monthreport_id"), rs.getInt("customer_num"),
						rs.getInt("item_num"), rs.getInt("stock_num"), rs.getInt("van_num"), rs.getInt("patnter_num"),
						rs.getInt("emp_num"), rs.getInt("serviceprovider_num"), rs.getDouble("sallary_emp"),
						rs.getDouble("sallary_supplier"), rs.getDouble("warehouse_cost"), rs.getInt("order_num"),
						rs.getDouble("order_cost"), rs.getInt("emergency_order"), rs.getInt("orderfrom_here"),
						rs.getDouble("emergency_cost"), rs.getDouble("hire_cost"), rs.getString("month"),
						rs.getString("status"));

				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	// Display Data In JTable

	public void Show_productreceivemod() {
		ArrayList<settingReportinfo> list = receiveorderinfo();
		DefaultTableModel model = (DefaultTableModel) table_month.getModel();
		Object[] row = new Object[19];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getMonthreport_id();
			row[1] = list.get(i).getCustomer_num();
			row[2] = list.get(i).getItem_num();
			row[3] = list.get(i).getStock_num();
			row[4] = list.get(i).getVan_num();
			row[5] = list.get(i).getPatnter_num();
			row[6] = list.get(i).getEmp_num();
			row[7] = list.get(i).getServiceprovider_num();
			row[8] = list.get(i).getSallary_emp();
			row[9] = list.get(i).getSallary_supplier();
			row[10] = list.get(i).getWarehouse_cost();
			row[11] = list.get(i).getOrder_num();
			row[12] = list.get(i).getOrder_cost();
			row[13] = list.get(i).getEmergency_order();
			row[14] = list.get(i).getOrderfrom_here();
			row[15] = list.get(i).getEmergency_cost();
			row[16] = list.get(i).getHire_cost();
			row[17] = list.get(i).getMonth();
			row[18] = list.get(i).getStatus();
			model.addRow(row);
		}
	}

	public ArrayList<settingReportinfo> List_wa_Order1(String search) {// warehouse
		// emp
		ArrayList<settingReportinfo> usersList = new ArrayList<settingReportinfo>();

		Statement st;
		ResultSet rs;
		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `monthly_report` WHERE CONCAT(`monthreport_id`, `customer_num`, `item_num`,`stock_num`,`van_num`,`patnter_num`,`emp_num`,`serviceprovider_num`,`sallary_emp`,`sallary_supplier`,`warehouse_cost`,`order_num`,`order_cost`,`emergency_order`,`orderfrom_here`,`emergency_cost`,`hire_cost`,`month`,`status`) LIKE '%"
					+ search + "%'";
			rs = st.executeQuery(searchQuery);

			settingReportinfo user;

			while (rs.next()) {
				user = new settingReportinfo(rs.getInt("monthreport_id"), rs.getInt("customer_num"),
						rs.getInt("item_num"), rs.getInt("stock_num"), rs.getInt("van_num"), rs.getInt("patnter_num"),
						rs.getInt("emp_num"), rs.getInt("serviceprovider_num"), rs.getDouble("sallary_emp"),
						rs.getDouble("sallary_supplier"), rs.getDouble("warehouse_cost"), rs.getInt("order_num"),
						rs.getDouble("order_cost"), rs.getInt("emergency_order"), rs.getInt("orderfrom_here"),
						rs.getDouble("emergency_cost"), rs.getDouble("hire_cost"), rs.getString("month"),
						rs.getString("status"));

				usersList.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	public void find_customerorder1() {
		ArrayList<settingReportinfo> list = List_wa_Order1(txt_search.getText());// asdjflasjdf;lja;lkdsfjl;k
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "MonthId", "Customer", "Item", "Stock", "Van", "Patner",
				"ServiceProvider", "Employee", "Sallary(supplier)", "sallary(Emp)", "Warehouse(cost)", "Order",
				"Order(cost)", "Emergencyorder", "Orderfromhere", "Cost(Emergency)", "cost(Hire),", "Date", "Status" });

		Object[] row = new Object[19];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getMonthreport_id();
			row[1] = list.get(i).getCustomer_num();
			row[2] = list.get(i).getItem_num();
			row[3] = list.get(i).getStock_num();
			row[4] = list.get(i).getVan_num();
			row[5] = list.get(i).getPatnter_num();
			row[6] = list.get(i).getEmp_num();
			row[7] = list.get(i).getServiceprovider_num();
			row[8] = list.get(i).getSallary_emp();
			row[9] = list.get(i).getSallary_supplier();
			row[10] = list.get(i).getWarehouse_cost();
			row[11] = list.get(i).getOrder_num();
			row[12] = list.get(i).getOrder_cost();
			row[13] = list.get(i).getEmergency_order();
			row[14] = list.get(i).getOrderfrom_here();
			row[15] = list.get(i).getEmergency_cost();
			row[16] = list.get(i).getHire_cost();
			row[17] = list.get(i).getMonth();
			row[18] = list.get(i).getStatus();
			model.addRow(row);
		}
		table_month.setModel(model);

	}

	// yearly

	public void executeSQlQuery_yearreport(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {
				DefaultTableModel model = (DefaultTableModel) table_viewyear.getModel();
				model.setRowCount(0);
				Show_productreceivemodyear();
				reset();
				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<yearlyReporInfo> receiveorderinfoyear() {
		ArrayList<yearlyReporInfo> usersList = new ArrayList<yearlyReporInfo>();
		Connection connection = getConnection();
		String query = "SELECT * FROM  `yearly_report`";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			yearlyReporInfo user;
			while (rs.next()) {
				user = new yearlyReporInfo(rs.getInt("yearId"), rs.getDouble("totalcost_emp"),
						rs.getDouble("totalcost_serviceprovider"), rs.getDouble("totalcost_warehouse"),
						rs.getInt("numberoforder"), rs.getInt("totalordercost"), rs.getInt("numemergencey_order"),
						rs.getInt("num_orderhere"), rs.getDouble("totalcost_emergencyorder"),
						rs.getDouble("totalcost_here"), rs.getString("date"), rs.getString("yearname"));

				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public void Show_productreceivemodyear() {
		ArrayList<yearlyReporInfo> list = receiveorderinfoyear();
		DefaultTableModel model = (DefaultTableModel) table_viewyear.getModel();

		Object[] row = new Object[12];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getYearId();
			row[1] = list.get(i).getTotalcost_emp();
			row[2] = list.get(i).getTotalcost_serviceprovider();
			row[3] = list.get(i).getTotalcost_warehouse();
			row[4] = list.get(i).getNumberof_order();
			row[5] = list.get(i).getTotal_ordercost();
			row[6] = list.get(i).getNum_emergencey_order();
			row[7] = list.get(i).getNum_orderhere();
			row[8] = list.get(i).getToalcost_emergencyorder();
			row[9] = list.get(i).getTotalcost_here();
			row[10] = list.get(i).getDate();
			row[11] = list.get(i).getYear();
			model.addRow(row);
		}
	}

	public ArrayList<yearlyReporInfo> List_wa_year(String search) {// warehouse
		// emp
		ArrayList<yearlyReporInfo> usersList = new ArrayList<yearlyReporInfo>();
		Statement st;
		ResultSet rs;
		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `yearly_report` WHERE CONCAT(`yearId`,`totalcost_emp`, `totalcost_serviceprovider`,`totalcost_warehouse`,`numberoforder`,`totalordercost`,`numemergencey_order`,`num_orderhere`,`totalcost_emergencyorder`,`totalcost_here`,`date`,`yearname`) LIKE '%"
					+ search + "%'";
			rs = st.executeQuery(searchQuery);
			yearlyReporInfo user;
			while (rs.next()) {
				user = new yearlyReporInfo(rs.getInt("yearId"), rs.getDouble("totalcost_emp"),
						rs.getDouble("totalcost_serviceprovider"), rs.getDouble("totalcost_warehouse"),
						rs.getInt("numberoforder"), rs.getInt("totalordercost"), rs.getInt("numemergencey_order"),
						rs.getInt("num_orderhere"), rs.getDouble("totalcost_emergencyorder"),
						rs.getDouble("totalcost_here"), rs.getString("date"), rs.getString("yearname"));
				usersList.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	public void find_year() {
		ArrayList<yearlyReporInfo> list = List_wa_year(txt_searyear.getText());// asdjflasjdf;lja;lkdsfjl;k
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "YearId", "TotalCost(Emp)", "Totalcost(S)", "TotalCost(Ware)",
				"NumberofOrder", "TotalOrderCost", "Emer(Order)", "Order(Here)", "TotalCost(Emerg)", "TotalCost(here)",
				"Date", "Year" });

		Object[] row = new Object[12];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getYearId();
			row[1] = list.get(i).getTotalcost_emp();
			row[2] = list.get(i).getTotalcost_serviceprovider();
			row[3] = list.get(i).getTotalcost_warehouse();
			row[4] = list.get(i).getNumberof_order();
			row[5] = list.get(i).getTotal_ordercost();
			row[6] = list.get(i).getNum_emergencey_order();
			row[7] = list.get(i).getNum_orderhere();
			row[8] = list.get(i).getToalcost_emergencyorder();
			row[9] = list.get(i).getTotalcost_here();
			row[10] = list.get(i).getDate();
			row[11] = list.get(i).getYear();
			model.addRow(row);
		}
		table_viewyear.setModel(model);

	}

	//

	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();
			if (source.equals(btn_mainmenu)) {
				dispose();

			} else if (source.equals(btn_getorderdeatisquery)) {

				String j = JOptionPane.showInputDialog(null, "Please provide Status");
				try {
					countroworder = j;
					Statement stmt = conn.createStatement();
					String sql = "Select count(price)from customerorder where status='" + countroworder + "'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						String count = rs.getString("count(price)");
						txt_numberoforder.setText(count);

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}

				try {
					sumstatus = j;
					Statement stmt = conn.createStatement();
					String sql = "Select sum(price)from customerorder where status='" + sumstatus + "'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						String sum = rs.getString("sum(price)");
						txt_totalcost.setText(sum);

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}

			} else if (source.equals(btn_getmonthvalue)) {

				String j = JOptionPane.showInputDialog(null, "Please Enter Input");
				try {
					year1 = j;
					Statement stmt = conn.createStatement();
					String sql = "Select sum(sallary_emp)  from monthly_report where status='" + year1 + "'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						String sum1 = rs.getString("sum(sallary_emp)");
						txt_year_emp_totalcost.setText(sum1);

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}

				try {
					year2 = j;
					Statement stmt = conn.createStatement();
					String sql = "Select sum(sallary_supplier)  from monthly_report where status='" + year2 + "'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						String sum2 = rs.getString("sum(sallary_supplier)");
						txt_year_s_totalcost.setText(sum2);

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}

				// +==========================three
				try {
					year3 = j;
					Statement stmt = conn.createStatement();
					String sql = "Select sum(warehouse_cost)  from monthly_report where status='" + year3 + "'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						String sum3 = rs.getString("sum(warehouse_cost)");
						txt_year_warehouse_totalcost.setText(sum3);

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}

				try {
					year4 = j;
					Statement stmt = conn.createStatement();
					String sql = "Select sum(order_num)  from monthly_report where status='" + year4 + "'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						String sum4 = rs.getString("sum(order_num)");
						txt_year_numberof_order.setText(sum4);

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}

				try {
					year5 = j;
					Statement stmt = conn.createStatement();
					String sql = "Select sum(order_cost)  from monthly_report where status='" + year5 + "'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						String sum5 = rs.getString("sum(order_cost)");
						txt_year_order_totalcost.setText(sum5);

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}

				try {
					year6 = j;
					Statement stmt = conn.createStatement();
					String sql = "Select sum(emergency_order)  from monthly_report where status='" + year6 + "'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						String sum6 = rs.getString("sum(emergency_order)");
						txt_year_orderfromclient.setText(sum6);

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}

				try {
					year7 = j;
					Statement stmt = conn.createStatement();
					String sql = "Select sum(orderfrom_here)  from monthly_report where status='" + year7 + "'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						String sum7 = rs.getString("sum(orderfrom_here)");
						txt_year_orderfromhere.setText(sum7);

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}

				try {
					year8 = j;
					Statement stmt = conn.createStatement();
					String sql = "Select sum(emergency_cost)  from monthly_report where status='" + year8 + "'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						String sum8 = rs.getString("sum(emergency_cost)");
						txt_year_orderfromclient_totalcost.setText(sum8);

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}

				try {
					year9 = j;
					Statement stmt = conn.createStatement();
					String sql = "Select sum(hire_cost)  from monthly_report where status='" + year9 + "'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						String sum9 = rs.getString("sum(hire_cost)");
						txt_year_orderfromhere_totalcost.setText(sum9);

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}

			} else if (source.equals(btn_search)) {
				find_customerorder1();

			} else if (source.equals(btn_calsallary)) {
				visibletrue();
				btn_getmonthvalue.setVisible(false);
				btn_getorderdeatisquery.setVisible(true);

			} else if (source.equals(btn_add)) {

				SimpleDateFormat f3 = new SimpleDateFormat("yyyy-MM-dd");
				str1 = "";
				str2 = "";
				str3 = "";
				str4 = "";
				str5 = "";
				str6 = "";
				str7 = "";
				str8 = "";
				str9 = "";
				str10 = "";
				str11 = "";
				str12 = "";
				str13 = "";
				str14 = "";
				str15 = "";
				str16 = "";
				str17 = "";
				str18 = "";
				str19 = "";
				record = record + 1;
				str1 = "" + record;
				str2 = cmb_customer.getSelectedItem().toString();
				str3 = cmb_Item.getSelectedItem().toString();
				str4 = cmb_Subitem.getSelectedItem().toString();
				str5 = cmb_vandetails.getSelectedItem().toString();
				str6 = cmb_numofclient.getSelectedItem().toString();
				str7 = txt_numofemployee.getText().toString();
				str8 = txt_numofservice.getText().toString();
				str9 = txt_employeesallary.getText().toString();
				str10 = txt_servicesallary.getText().toString();
				str11 = txt_totalcostwarehouse.getText().toString();
				str12 = txt_numberoforder.getText().toString();
				str13 = txt_totalcost.getText().toString();
				str14 = txt_fromclient.getText().toString();
				str15 = txt_fromhere.getText().toString();
				str16 = txt_fromclientamount.getText().toString();
				str17 = txt_fromhereamount.getText().toString();
				str19 = txt_statusformonthlyreport.getText().toString();

				multiply_serviceprovider = (Integer.parseInt(str7) * (Integer.parseInt(str9)));
				multiply_employee = (Integer.parseInt(str8) * (Integer.parseInt(str10)));

				String sager = Integer.toString(multiply_serviceprovider);
				String golam = Integer.toString(multiply_employee);

				if (date.getDate() == null) {
					JOptionPane.showMessageDialog(null, "The date field id Blank!!");
				} else if (str2.equals("") || str2.equals("") || str3.equals("") || str4.equals("") || str5.equals("")
						|| str6.equals("") || str7.equals("") || str2.equals("") || str8.equals("") || str9.equals("")
						|| str10.equals("") || str11.equals("") || str12.equals("") || str13.equals("")
						|| str14.equals("") || str15.equals("") || str16.equals("") || str17.equals("")) {
					JOptionPane.showMessageDialog(null, "Field Must Not Empty");

				} else {
					str18 = f3.format(date.getDate());
					String querey = "INSERT INTO monthly_report(customer_num,item_num,stock_num,van_num,patnter_num,emp_num,serviceprovider_num,sallary_emp,sallary_supplier,warehouse_cost,order_num,order_cost,emergency_order,orderfrom_here,emergency_cost,hire_cost,month,status) VALUES ('"
							+ str2 + "','" + str3 + "','" + str4 + "','" + str5 + "','" + str6 + "','" + str7 + "','"
							+ str8 + "','" + sager + "','" + golam + "','" + str11 + "','" + str12 + "','" + str13
							+ "','" + str14 + "','" + str15 + "','" + str16 + "','" + str17 + "','" + str18 + "','"
							+ str19 + "')";

					// String temp = "INSERT INTO
					// monthly_report(customer_num,item_num,stock_num,van_num,patnter_num,emp_num,serviceprovider_num,sallary_emp,sallary_supplier,warehouse_cost,order_num,order_cost,emergency_order,orderfrom_here,emergency_cost,hire_cost,month,status)
					// VALUES ('"
					// + val + "','" + type + "','" + str1 + "','" + str2 +
					// "','" + str3 + "','" + str4
					// + "','" + str5 + "','" + str6 + "','" + strdone + "','" +
					// simpledate + "','" + sDate
					// + "','" + txt_yearwithmonth.getText() + "','" +
					// another_id.getText() + "')";
					//

					executeSQlQuery_monthreport(querey, "Add");
				}

			} else if (source.equals(btn_delete)) {
				str1 = "";
				str1 = txt_Id.getText().trim();
				String query = "DELETE FROM `monthly_report` WHERE monthreport_id = " + str1;
				executeSQlQuery_monthreport(query, "Deleted Record!!");

			} else if (source.equals(btn_senddate)) {
				txt_1.setText("");
				txt_2.setText("");
				txt_3.setText("");
				txt_4.setText("");
				txt_5.setText("");
				txt_6.setText("");
				txt_7.setText("");
				txt_8.setText("");
				txt_9.setText("");
				txt_1.setText(txt_year_emp_totalcost.getText().toString());
				txt_2.setText(txt_year_s_totalcost.getText().toString());
				txt_3.setText(txt_year_warehouse_totalcost.getText().toString());

				txt_4.setText(txt_year_numberof_order.getText().toString());

				txt_5.setText(txt_year_order_totalcost.getText().toString());

				txt_6.setText(txt_year_orderfromclient.getText().toString());
				txt_7.setText(txt_year_orderfromhere.getText().toString());
				txt_8.setText(txt_year_orderfromclient_totalcost.getText().toString());
				txt_9.setText(txt_year_orderfromhere_totalcost.getText().toString());

				double total_bakerycost = (Double.parseDouble(txt_7.getText()) + Double.parseDouble(txt_8.getText())
						+ Double.parseDouble(txt_9.getText()));
				double total_benifitorder = (Double.parseDouble(txt_2.getText()) + Double.parseDouble(txt_5.getText())
						+ Double.parseDouble(txt_6.getText()));
				txt_Totalorder_cost.setText("" + total_bakerycost);
				txt_Total_costbakery.setText("" + total_benifitorder);

				txt_year_emp_totalcost.setText("");
				txt_year_s_totalcost.setText("");
				txt_year_warehouse_totalcost.setText("");
				txt_year_numberof_order.setText("");
				txt_year_order_totalcost.setText("");
				txt_year_orderfromclient.setText("");
				txt_year_orderfromhere.setText("");
				txt_year_orderfromclient_totalcost.setText("");
				txt_year_orderfromhere_totalcost.setText("");

			} else if (source.equals(btn_searyear)) {
				find_year();

			} else if (source.equals(btn_addyear)) {
				SimpleDateFormat f3 = new SimpleDateFormat("yyyy-MM-dd");
				str1 = "";
				str2 = "";
				str3 = "";
				str4 = "";
				str5 = "";
				str6 = "";
				str7 = "";
				str8 = "";
				str9 = "";
				str10 = "";
				str11 = "";
				str12 = "";
				str13 = "";
				str14 = "";
				record += 1;
				str1 = "" + record;
				str2 = txt_1.getText().toString();
				str3 = txt_2.getText().toString();
				str4 = txt_3.getText().toString();
				str5 = txt_4.getText().toString();
				str6 = txt_5.getText().toString();
				str7 = txt_6.getText().toString();
				str8 = txt_7.getText().toString();
				str9 = txt_8.getText().toString();
				str10 = txt_9.getText().toString();
				str12 = txt_year.getText().toString();

				str13 = txt_Totalorder_cost.getText();
				str14 = txt_Total_costbakery.getText();

				if (date.getDate() == null) {
					JOptionPane.showMessageDialog(null, "The date field id Blank!!");

				} else {
					str11 = f3.format(date.getDate());
				}

				if (str2.equals("") || str3.equals("") || str4.equals("") || str5.equals("") || str6.equals("")
						|| str7.equals("") || str2.equals("") || str8.equals("") || str9.equals("") || str10.equals("")
						|| str12.equals("")) {
					JOptionPane.showMessageDialog(null, "Field Must Not Empty");

				} else {

					String querey = "INSERT INTO yearly_report(totalcost_emp,totalcost_serviceprovider,totalcost_warehouse,numberoforder,totalordercost,numemergencey_order,num_orderhere,totalcost_emergencyorder,totalcost_here,date,yearname,total_amountcost,total_amountorder) VALUES ('"
							+ str2 + "','" + str3 + "','" + str4 + "','" + str5 + "','" + str6 + "','" + str7 + "','"
							+ str8 + "','" + str9 + "','" + str10 + "','" + str11 + "','" + str12 + "','" + str13
							+ "','" + str14 + "')";

					// String querey = "INSERT INTO
					// yearly_report(totalcost_emp,totalcost_serviceprovider,totalcost_warehouse,numberoforder,totalordercost,numemergencey_order,num_orderhere,totalcost_emergencyorder,totalcost_here,date,yearname,total_amountcost,total_amountorder)
					// VALUES ('"
					// + str2 + "','" + str3 + "','" + str4 + "','" + str5 +
					// "','" + str6 + "','" + str7 + "','"
					// + str8 + "','" + sager + "','" + golam + "','" + str11 +
					// "','" + str12 + "','" + str13
					// + "','" + str14 + "','" + str15 + "','" + str16 + "','" +
					// str17 + "','" + str18 + "','"
					// + str19 + "')";
					//

					executeSQlQuery_monthreport(querey, "Add");
				}

			} else if (source.equals(btn_updateyear)) {
				SimpleDateFormat f3 = new SimpleDateFormat("yyyy-MM-dd");
				str1 = "";
				str2 = "";
				str3 = "";
				str4 = "";
				str5 = "";
				str6 = "";
				str7 = "";
				str8 = "";
				str9 = "";
				str10 = "";
				str11 = "";
				str12 = "";

				str1 = txt_Id.getText().toString();
				str2 = txt_1.getText().toString();
				str3 = txt_2.getText().toString();
				str4 = txt_3.getText().toString();
				str5 = txt_4.getText().toString();
				str6 = txt_5.getText().toString();
				str7 = txt_6.getText().toString();
				str8 = txt_7.getText().toString();
				str9 = txt_8.getText().toString();
				str10 = txt_9.getText().toString();
				str12 = txt_year.getText().toString();

				if (date.getDate() == null) {
					JOptionPane.showMessageDialog(null, "The date field id Blank!!");

				} else {
					str11 = f3.format(date.getDate());
				}

				if (str2.equals("") || str3.equals("") || str4.equals("") || str5.equals("") || str6.equals("")
						|| str7.equals("") || str2.equals("") || str8.equals("") || str9.equals("") || str10.equals("")
						|| str12.equals("")) {
					JOptionPane.showMessageDialog(null, "Field Must Not Empty");

				} else {

					String temp = "UPDATE yearly_report SET " + "yearId = '" + str1 + "',totalcost_emp = '" + str2
							+ "',totalcost_serviceprovider = '" + str3 + "',totalcost_warehouse = '" + str4
							+ "',numberoforder = '" + str5 + "',totalordercost = '" + str6 + "',numemergencey_order = '"
							+ str7 + "',num_orderhere = '" + str8 + "',totalcost_emergencyorder = '" + str9
							+ "',totalcost_here = '" + str10 + "',date = '" + str11 + "',yearname = '" + str12 + "'"
							+ "WHERE yearId = '" + str1 + "'";

					executeSQlQuery_monthreport(temp, "Updated");

				}

			} else if (source.equals(btn_update)) {

				SimpleDateFormat f3 = new SimpleDateFormat("yyyy-MM-dd");
				str1 = "";
				str2 = "";
				str3 = "";
				str4 = "";
				str5 = "";
				str6 = "";
				str7 = "";
				str8 = "";
				str9 = "";
				str10 = "";
				str11 = "";
				str12 = "";
				str13 = "";
				str14 = "";
				str15 = "";
				str16 = "";
				str17 = "";
				str18 = "";
				str19 = "";
				str1 = txt_Id.getText().toString();
				str2 = cmb_customer.getSelectedItem().toString();
				str3 = cmb_Item.getSelectedItem().toString();
				str4 = cmb_Subitem.getSelectedItem().toString();
				str5 = cmb_vandetails.getSelectedItem().toString();
				str6 = cmb_numofclient.getSelectedItem().toString();
				str7 = txt_numofemployee.getText().toString();
				str8 = txt_numofservice.getText().toString();
				str9 = txt_employeesallary.getText().toString();
				str10 = txt_servicesallary.getText().toString();
				str11 = txt_totalcostwarehouse.getText().toString();
				str12 = txt_numberoforder.getText().toString();
				str13 = txt_totalcost.getText().toString();
				str14 = txt_fromclient.getText().toString();
				str15 = txt_fromhere.getText().toString();
				str16 = txt_fromclientamount.getText().toString();
				str17 = txt_fromhereamount.getText().toString();
				str19 = txt_statusformonthlyreport.getText().toString();

				multiply_serviceprovider = (Integer.parseInt(str7) * (Integer.parseInt(str9)));
				multiply_employee = (Integer.parseInt(str8) * (Integer.parseInt(str10)));

				if (date.getDate() == null) {
					JOptionPane.showMessageDialog(null, "The date field id Blank!!");
				} else if (str2.equals("") || str2.equals("") || str3.equals("") || str4.equals("") || str5.equals("")
						|| str6.equals("") || str7.equals("") || str2.equals("") || str8.equals("") || str9.equals("")
						|| str10.equals("") || str11.equals("") || str12.equals("") || str13.equals("")
						|| str14.equals("") || str15.equals("") || str16.equals("") || str17.equals("")) {
					JOptionPane.showMessageDialog(null, "Field Must Not Empty");

				} else {

					str18 = f3.format(date.getDate());
					// String querey = "INSERT INTO monthly_report VALUES ('" +
					// str1 + "','" + str2 + "','" + str3 + "','"
					// + str4 + "','" + str5 + "','" + str6 + "','" + str7 +
					// "','" + str8 + "','"
					// + multiply_serviceprovider + "','" + multiply_employee +
					// "','" + str11 + "','" + str12
					// + "','" + str13 + "','" + str14 + "','" + str15 + "','" +
					// str16 + "','" + str17 + "','"
					// + str18 + "','" + str19 + "')";
					// executeSQlQuery_monthreport(querey, "Add");

					String temp = "UPDATE monthly_report SET " + "monthreport_id = '" + str1 + "',customer_num = '"
							+ str2 + "',item_num = '" + str3 + "',stock_num = '" + str4 + "',van_num = '" + str5
							+ "',patnter_num = '" + str6 + "',emp_num = '" + str7 + "',serviceprovider_num = '" + str8
							+ "',sallary_emp = '" + multiply_serviceprovider + "',sallary_supplier = '"
							+ multiply_employee + "',warehouse_cost = '" + str11 + "',order_num = '" + str12
							+ "',order_cost = '" + str13 + "',emergency_order = '" + str14 + "',orderfrom_here = '"
							+ str15 + "',emergency_cost = '" + str16 + "',hire_cost = '" + str17 + "',month = '" + str18
							+ "',status = '" + str19 + "'" + "WHERE monthreport_id = '" + str1 + "'";

					executeSQlQuery_monthreport(temp, "Update Record!!");
				}

			} else if (source.equals(btn_deleteyear)) {
				str1 = "";
				str1 = txt_Id.getText().trim();
				String query = "DELETE FROM `yearly_report` WHERE yearId = " + str1;
				executeSQlQuery_monthreport(query, "Deleted Record!!");

			}

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

	public void retrive_vandetails(JComboBox<String> cmb) {

		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM vandetails";
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

	public void retrive_emergencycontact(JComboBox<String> cmb) {

		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM emergency_contact";
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

	public void retrive_Item(JComboBox<String> cmb) {

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

	public void retrive_Stock(JComboBox<String> cmb) {

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

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public void retrive_warehouse(JComboBox<String> cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM warehouse";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String txt_id = rs.getString(3).trim();

				cmb.addItem(txt_id);
			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	@SuppressWarnings("resource")
	public void fill_upwarehouse(String name) {
		DefaultListModel<String> m = new DefaultListModel<String>();

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM warehouse WHERE wa_date='" + name + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				description = "";
				amount = "";
				description = rs.getString(4).trim();
				amount = rs.getString(5).trim();
				m.addElement(description);
				m.addElement(amount);
				rs = null;
				list.setModel(m);

			}

			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void retrive_identifyEmployee(JComboBox<String> cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM employee";
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
	public void fill_upemploey(String name) {
		DefaultListModel<String> m = new DefaultListModel<String>();

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM employee WHERE emp_id='" + name + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				st2 = "";
				st3 = "";
				st4 = "";
				st5 = "";
				st6 = "";
				st7 = "";
				st8 = "";
				st9 = "";
				st2 = rs.getString(2).trim();
				st3 = rs.getString(3).trim();
				st4 = rs.getString(4).trim();
				st5 = rs.getString(5).trim();
				st6 = rs.getString(6).trim();
				st7 = rs.getString(7).trim();
				st8 = rs.getString(8).trim();
				st9 = rs.getString(9).trim();
				m.addElement(st2);
				m.addElement(st3);
				m.addElement(st3);
				m.addElement(st4);
				m.addElement(st5);
				m.addElement(st6);
				m.addElement(st7);
				m.addElement(st8);
				m.addElement(st9);
				rs = null;
				list1.setModel(m);

			}

			conn.close();
		}

		catch (Exception ex) {

		}

	}
	// }}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}

	public void retrive_sallary(JComboBox<String> cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM settings";
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
	public void fill_sallary(String name) {
		DefaultListModel<String> m = new DefaultListModel<String>();

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM settings WHERE Category_type='" + name + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				st2 = "";
				st3 = "";
				st2 = rs.getString(2).trim();
				st3 = rs.getString(3).trim();
				m.addElement(st2);
				m.addElement(st3);
				rs = null;
				list3.setModel(m);
			}

			conn.close();
		}

		catch (Exception ex) {

		}

	}

	// PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(cmb_warehouse)) {

			String str = (String) cmb_warehouse.getSelectedItem();
			fill_upwarehouse(str);

		} else if (source.equals(cmb_Order)) {
			String str = (String) cmb_Order.getSelectedItem();
			fill_upemploey(str);
		} else if (source.equals(cmb_sallaryemp)) {
			String sallary = (String) cmb_sallaryemp.getSelectedItem();
			fill_sallary(sallary);

		} else if (source.equals(cmb_orderfromclient)) {
			String fromclient = (String) cmb_orderfromclient.getSelectedItem();
			retrive_Orderfromclient(fromclient);
		} else if (source.equals(btn_clear)) {
			reset();
		} else if (source.equals(btn_viewsallary)) {
			btn_getmonthvalue.setVisible(true);
			btn_getorderdeatisquery.setVisible(false);
			visiblefalse();
		} else if (source.equals(btn_yearsetting)) {
			yearvisibletrue();

		} else if (source.equals(btn_viewyear)) {
			view_year();
		}

	}

	public void visiblefalse() {
		btn_searyear.setVisible(false);
		txt_searyear.setVisible(false);
		pan_viewyear.setVisible(false);
		pan_addyearreport.setVisible(false);
		pan_viewmontable.setVisible(true);
		pan_viewmonth.setVisible(true);
		lbl_search.setVisible(true);
		txt_search.setVisible(true);
		btn_search.setVisible(true);
		pan_viewmonth.setVisible(true);
		pan_viewmontable.setVisible(true);
		pan_left.setVisible(false);
		pan_right.setVisible(false);
		pan_right_product2.setVisible(false);
		btn_add.setVisible(false);
		btn_update.setVisible(false);
		btn_delete.setVisible(false);
		pan_so.setVisible(false);
	}

	public void yearvisibletrue() {
		btn_searyear.setVisible(false);
		txt_searyear.setVisible(false);
		pan_viewyear.setVisible(false);
		pan_addyearreport.setVisible(true);
		pan_viewmontable.setVisible(false);
		pan_viewmonth.setVisible(false);
		lbl_search.setVisible(false);
		txt_search.setVisible(false);
		btn_search.setVisible(false);
		pan_viewmonth.setVisible(false);
		pan_viewmontable.setVisible(false);
		pan_left.setVisible(false);
		pan_right.setVisible(false);
		pan_right_product2.setVisible(false);
		btn_add.setVisible(false);
		btn_update.setVisible(false);
		btn_delete.setVisible(false);
		pan_so.setVisible(false);
		pan_viewmontable.setVisible(false);
		pan_viewmonth.setVisible(false);
		lbl_search.setVisible(false);
		txt_search.setVisible(false);
		btn_search.setVisible(false);
		pan_viewmonth.setVisible(false);
		pan_viewmontable.setVisible(false);
		pan_left.setVisible(false);
		pan_right.setVisible(false);
		pan_right_product2.setVisible(false);
		btn_add.setVisible(false);
		btn_update.setVisible(false);
		btn_delete.setVisible(false);
		pan_so.setVisible(false);

	}

	public void visibletrue() {
		btn_searyear.setVisible(false);
		txt_searyear.setVisible(false);
		pan_viewyear.setVisible(false);
		pan_addyearreport.setVisible(false);
		pan_viewmontable.setVisible(false);
		pan_viewmonth.setVisible(false);
		lbl_search.setVisible(false);
		txt_search.setVisible(false);
		btn_search.setVisible(false);
		pan_viewmonth.setVisible(false);
		pan_viewmontable.setVisible(false);
		pan_left.setVisible(true);
		pan_right.setVisible(true);
		pan_right_product2.setVisible(true);
		btn_add.setVisible(true);
		btn_update.setVisible(true);
		btn_delete.setVisible(true);
		pan_so.setVisible(true);
	}

	public void view_year() {
		btn_searyear.setVisible(true);
		txt_searyear.setVisible(true);
		pan_viewyear.setVisible(true);
		pan_addyearreport.setVisible(false);
		pan_viewmontable.setVisible(false);
		pan_viewmonth.setVisible(false);
		lbl_search.setVisible(false);
		txt_search.setVisible(false);
		btn_search.setVisible(false);
		pan_viewmonth.setVisible(false);
		pan_viewmontable.setVisible(false);
		pan_left.setVisible(false);
		pan_right.setVisible(false);
		pan_right_product2.setVisible(false);
		btn_add.setVisible(false);
		btn_update.setVisible(false);
		btn_delete.setVisible(false);
		pan_so.setVisible(false);
		pan_addyearreport.setVisible(false);
		pan_viewmontable.setVisible(false);
		pan_viewmonth.setVisible(false);
		lbl_search.setVisible(false);
		txt_search.setVisible(false);
		btn_search.setVisible(false);
		pan_viewmonth.setVisible(false);
		pan_viewmontable.setVisible(false);
		pan_left.setVisible(false);
		pan_right.setVisible(false);
		pan_right_product2.setVisible(false);
		btn_add.setVisible(false);
		btn_update.setVisible(false);
		btn_delete.setVisible(false);
		pan_so.setVisible(false);
		pan_addyearreport.setVisible(false);
		pan_viewmontable.setVisible(false);
		pan_viewmonth.setVisible(false);
		lbl_search.setVisible(false);
		txt_search.setVisible(false);
		btn_search.setVisible(false);
		pan_viewmonth.setVisible(false);
		pan_viewmontable.setVisible(false);
		pan_left.setVisible(false);
		pan_right.setVisible(false);
		pan_right_product2.setVisible(false);
		btn_add.setVisible(false);
		btn_update.setVisible(false);
		btn_delete.setVisible(false);
		pan_so.setVisible(false);
		pan_viewmontable.setVisible(false);
		pan_viewmonth.setVisible(false);
		lbl_search.setVisible(false);
		txt_search.setVisible(false);
		btn_search.setVisible(false);
		pan_viewmonth.setVisible(false);
		pan_viewmontable.setVisible(false);
		pan_left.setVisible(false);
		pan_right.setVisible(false);
		pan_right_product2.setVisible(false);
		btn_add.setVisible(false);
		btn_update.setVisible(false);
		btn_delete.setVisible(false);
		pan_so.setVisible(false);

	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void reset() {
		txt_numofemployee.setText("");
		txt_servicesallary.setText("");
		txt_employeesallary.setText("");
		txt_totalcostwarehouse.setText("");
		txt_numberoforder.setText("");
		txt_totalcost.setText("");
		txt_numofservice.setText("");
		date.setDate(null);
		txt_fromclient.setText("");
		txt_fromhere.setText("");
		txt_numofservice.setText("");
		txt_numofemployee.setText("");
		txt_servicesallary.setText("");
		txt_employeesallary.setText("");
		txt_totalcostwarehouse.setText("");
		txt_numberoforder.setText("");
		txt_totalcost.setText("");
		txt_fromclient.setText("");
		txt_fromhere.setText("");
		txt_fromhereamount.setText("");
		txt_fromclientamount.setText("");
		txt_Id.setText("");
		//

		txt_year_s_totalcost.setText("");
		txt_year_emp_totalcost.setText("");
		txt_year_warehouse_totalcost.setText("");
		txt_year_order_totalcost.setText("");
		txt_year_numberof_order.setText("");
		txt_year_orderfromclient.setText("");
		txt_year_orderfromhere.setText("");
		txt_year_orderfromclient_totalcost.setText("");
		txt_year_orderfromhere_totalcost.setText("");
		txt_1.setText("");
		txt_2.setText("");
		txt_3.setText("");
		txt_4.setText("");
		txt_5.setText("");
		txt_6.setText("");
		txt_7.setText("");
		txt_8.setText("");
		txt_9.setText("");

	}

	public void retrive_Orderfromclient(JComboBox<String> cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM emergency_order";
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
	public void retrive_Orderfromclient(String name) {
		DefaultListModel<String> m = new DefaultListModel<String>();

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM emergency_order WHERE emergencyorder_id='" + name + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				st2 = "";
				st3 = "";
				st4 = "";
				st5 = "";
				st6 = "";
				st2 = rs.getString(2).trim();
				st3 = rs.getString(3).trim();
				st4 = rs.getString(4).trim();
				st5 = rs.getString(5).trim();
				st6 = rs.getString(6).trim();
				m.addElement(st2);
				m.addElement(st3);
				m.addElement(st4);
				m.addElement(st5);
				m.addElement(st6);
				rs = null;
				list4.setModel(m);
			}

			conn.close();
		}

		catch (Exception ex) {

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int i = table_month.getSelectedRow();
		TableModel model = table_month.getModel();
		txt_Id.setText(model.getValueAt(i, 0).toString());
		cmb_customer.setSelectedItem(model.getValueAt(i, 1).toString());
		cmb_Item.setSelectedItem(model.getValueAt(i, 2).toString());
		cmb_Subitem.setSelectedItem(model.getValueAt(i, 3).toString());
		cmb_vandetails.setSelectedItem(model.getValueAt(i, 4).toString());
		cmb_numofclient.setSelectedItem(model.getValueAt(i, 5).toString());
		txt_numofemployee.setText(model.getValueAt(i, 6).toString());
		txt_numofservice.setText(model.getValueAt(i, 7).toString());
		txt_employeesallary.setText(model.getValueAt(i, 8).toString());
		txt_servicesallary.setText(model.getValueAt(i, 9).toString());
		txt_totalcostwarehouse.setText(model.getValueAt(i, 10).toString());
		txt_numberoforder.setText(model.getValueAt(i, 11).toString());
		txt_totalcost.setText(model.getValueAt(i, 12).toString());
		txt_fromclient.setText(model.getValueAt(i, 13).toString());
		txt_fromhere.setText(model.getValueAt(i, 14).toString());
		txt_fromclientamount.setText(model.getValueAt(i, 15).toString());
		txt_fromhereamount.setText(model.getValueAt(i, 16).toString());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date addDate = new Date();
		try {
			addDate = dateFormat.parse((String) model.getValueAt(i, 17));
			date.setDate(addDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		txt_statusformonthlyreport.setText(model.getValueAt(i, 18).toString());

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

	class Operation implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int i = table_viewyear.getSelectedRow();
			TableModel model = table_viewyear.getModel();
			txt_Id.setText(model.getValueAt(i, 0).toString());
			txt_1.setText(model.getValueAt(i, 1).toString());
			txt_2.setText(model.getValueAt(i, 2).toString());
			txt_3.setText(model.getValueAt(i, 3).toString());
			txt_4.setText(model.getValueAt(i, 4).toString());
			txt_5.setText(model.getValueAt(i, 5).toString());
			txt_6.setText(model.getValueAt(i, 6).toString());
			txt_7.setText(model.getValueAt(i, 7).toString());
			txt_8.setText(model.getValueAt(i, 8).toString());
			txt_9.setText(model.getValueAt(i, 9).toString());
			txt_year.setText(model.getValueAt(i, 11).toString());

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date addDate = new Date();
			try {
				addDate = dateFormat.parse((String) model.getValueAt(i, 10));
				date.setDate(addDate);
			} catch (ParseException e1) {
				e1.printStackTrace();
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

}
