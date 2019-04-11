package view;


import java.awt.Color;
import java.awt.Component;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import Controller.Databaseconnect;
import Model.InternalLabourAttendanceInfo;
import Model.SupplierAttendanceInfo;

public class Attendence extends JInternalFrame
		implements ActionListener, ItemListener, MouseListener, ListSelectionListener {
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	public static int record;
	public static int record1;
	int foundrec = 0;

	static Date td = new Date();
	static String sDate = DateFormat.getDateTimeInstance().format(td);
	SimpleDateFormat f3 = new SimpleDateFormat("yyyy-MM-dd");

	Connection conn;
	Databaseconnect connect = new Databaseconnect();
	JFrame JFParentFrame;
	JDesktopPane desktop;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	Border thickBorder = new LineBorder(Color.decode("#394B58"), 15);

	private JButton btn_home = new JButton("Home");
	private JButton btn_attendence = new JButton("Attencence");
	private JButton btn_view = new JButton("View");
	private JButton btn_viewsupplier = new JButton("V.Supplier");

	// date +type of emplyee

	JLabel lbl_date = new JLabel("Date");
	JComboBox<String> cmb_typeemployee = new JComboBox<String>();

	// date +type of emplyee

	int style = Font.BOLD;
	Font font = new Font("Garamond", style, 20);
	//
	//
	private JList<String> list_employeelist = new JList<String>();

	private JComboBox<String> cmb_alladdendancetype = new JComboBox<String>();

	private JCheckBox chec_done = new JCheckBox("Done");
	private JTextField txt_yearwithmonth = new JTextField();
	// for the attendence
	JPanel pan_first = new JPanel();
	JPanel pan_third = new JPanel();
	JPanel pan_second = new JPanel();
	JLabel lbl_employeelist = new JLabel("Employee List");
	JLabel lbl_attendencetype = new JLabel("Attendence Type");
	JLabel lbl_status = new JLabel("Status");
	JLabel lbl_employeetype = new JLabel("Employee Type");

	JTextField txt_allid = new JTextField();
	JTextField another_id = new JTextField();

	JDateChooser date = new JDateChooser();
	private JButton btn_save = new JButton("Save");
	private JButton btn_update = new JButton("Update");
	private JButton btn_updaateserviceprovie = new JButton("U.Service");
	private JButton btn_clear = new JButton("Clear");
	private JButton btn_savesupplier = new JButton("Supplier");

	private JButton btn_delete_supplier = new JButton("Delete");
	private JButton btn_delete_internalemp = new JButton("Delete");
	private JButton btn_report_supplier = new JButton("Report");
	private JButton btn_report_InternalEmp = new JButton("Report");

	// for the attendence

	// view
	private JTable tbl_viewemp = new JTable();
	private JTable tbl_viewsupplier = new JTable();
	private JScrollPane employee_pane = new JScrollPane();
	private JScrollPane s_pane = new JScrollPane();
	// view
	JPanel pan_searchemp = new JPanel();
	JTextField txt_searchemployee = new JTextField();
	JButton btn_searchemployee = new JButton("Search");
	// view disable

	JPanel pan_searchsupplier = new JPanel();
	JButton btn_supplier = new JButton("Search");
	JTextField txt_supplier = new JTextField();
	// view disable supplier
	public static String allaccess = "";

	int str1;
	int str2;
	int str3;
	int str4;
	int str5;
	int str6;
	//

	public Attendence(JFrame getParentFrame) {
		super("Attendence Employee", true, true, true, true);
		try {
			JFParentFrame = getParentFrame;
			this.setSize(900, 550);
			this.setLayout(null);
			this.setLocation(screenheith / 2, screedwidth / 10);

			JPanel pan = new JPanel();
			JPanel pan_container = new JPanel();
			pan.setLayout(null);
			pan.setBounds(0, 0, 130, 850);
			pan.setBackground(Color.decode("#D3DFF2"));//F7F7F7

			Border thickBorder = new LineBorder(Color.decode("#394B58"), 12);
			btn_home.setBounds(20, 60, 80, 80);
			btn_home.setBorder(thickBorder);
			btn_home.setBackground(Color.decode("#250800"));
			btn_home.setForeground(Color.GRAY);

			btn_attendence.setBounds(20, 170, 80, 80);
			btn_attendence.setBorder(thickBorder);
			btn_attendence.setBackground(Color.decode("#250800"));
			btn_attendence.setForeground(Color.GRAY);

			btn_view.setBounds(20, 280, 80, 80);
			btn_view.setBorder(thickBorder);
			btn_view.setBackground(Color.decode("#250800"));
			btn_view.setForeground(Color.GRAY);

			btn_viewsupplier.setBounds(20, 390, 80, 80);
			btn_viewsupplier.setBorder(thickBorder);
			btn_viewsupplier.setBackground(Color.decode("#250800"));
			btn_viewsupplier.setForeground(Color.GRAY);

			ThreemainButton mainbutton = new ThreemainButton();
			btn_home.addActionListener(mainbutton);
			btn_attendence.addActionListener(mainbutton);
			btn_view.addActionListener(mainbutton);
			btn_viewsupplier.addActionListener(mainbutton);

			btn_home.setForeground(Color.WHITE);
			btn_attendence.setForeground(Color.WHITE);
			btn_view.setForeground(Color.WHITE);
			btn_viewsupplier.setForeground(Color.WHITE);

			pan.add(btn_home);
			pan.add(btn_attendence);
			pan.add(btn_view);
			pan.add(btn_viewsupplier);

			pan_container.setBounds(183, 50, 1130, 480);
			pan_container.setBorder(thickBorder);
			pan_container.setBackground(Color.GRAY);
			pan_container.setLayout(null);

			Border add_table = new LineBorder(Color.BLACK, 5);
			Border add_table1 = new LineBorder(Color.BLACK, 5);
			Border add_table2 = new LineBorder(Color.BLACK, 5);

			pan_first.setBounds(60, 50, 300, 380);
			pan_first.setLayout(new GridLayout());

			list_employeelist.setBackground(Color.decode("#FFE4B5"));
			pan_first.add(list_employeelist);

			list_employeelist.addListSelectionListener(this);
			cmb_typeemployee.addActionListener(this);

			String goahead = (String) cmb_typeemployee.getSelectedItem();
			fill_form(goahead);
			retrive_customer(cmb_typeemployee);

			pan_first.setBorder(add_table);

			pan_second.setBounds(410, 50, 300, 380);
			pan_second.setBackground(Color.decode("#FFE4B5"));
			pan_second.setLayout(null);
			pan_second.setBorder(add_table1);

			cmb_alladdendancetype.setBounds(60, 30, 140, 30);
			cmb_alladdendancetype.addItem("Present");
			cmb_alladdendancetype.addItem("Absant");
			cmb_alladdendancetype.addItem("Late");
			cmb_alladdendancetype.addItem("Holiday");
			cmb_alladdendancetype.addItem("Sick");
			cmb_alladdendancetype.addItem("Others");
			chec_done.addActionListener(this);

			JLabel lbl_done = new JLabel("**** S T A T U S ****");
			lbl_done.setBounds(60, 240, 300, 30);
			lbl_done.setFont(font);

			chec_done.setBounds(120, 280, 80, 30);
			txt_yearwithmonth.setBounds(120, 320, 80, 30);

			chec_done.setBackground(Color.decode("#FFE4B5"));
			txt_yearwithmonth.setBackground(Color.decode("#FFE4B5"));

			pan_second.add(txt_yearwithmonth);
			pan_second.add(chec_done);
			pan_second.add(lbl_done);
			pan_second.add(cmb_alladdendancetype);

			pan_third.setBounds(770, 50, 300, 380);
			pan_third.setBackground(Color.decode("#FFE4B5"));// 875A3C.
			pan_third.setBorder(add_table2);

			lbl_employeelist.setBounds(150, 20, 170, 30);
			lbl_attendencetype.setBounds(500, 20, 170, 30);
			lbl_status.setBounds(870, 20, 120, 30);
			lbl_employeelist.setFont(font);
			lbl_attendencetype.setFont(font);
			lbl_status.setFont(font);

			pan_searchemp.setLayout(new GridLayout());
			pan_searchemp.setBounds(40, 100, 1055, 350);
			pan_searchemp.setBackground(Color.WHITE);
			tbl_viewemp
					.setModel(
							new javax.swing.table.DefaultTableModel(new Object[][] {},
									new String[] { "Id", "EmployeeName", "EmpType", "present", "Absant", "Late",
											"Holiday", "Sick", "Others", "Status", "CreateDate", "Time", "YearStatus",
											"EmployeeId" }));
			tbl_viewemp.addMouseListener(mainbutton);
			employee_pane.setViewportView(tbl_viewemp);
			txt_searchemployee.setBounds(480, 40, 180, 30);
			btn_searchemployee.setBounds(680, 40, 100, 30);
			btn_searchemployee.addActionListener(this);
			pan_searchemp.add(employee_pane);

			pan_searchsupplier.setLayout(new GridLayout());
			pan_searchsupplier.setBounds(40, 100, 1055, 350);
			tbl_viewsupplier
					.setModel(
							new javax.swing.table.DefaultTableModel(new Object[][] {},
									new String[] { "Id", "EmployeeName", "EmpType", "present", "Absant", "Late",
											"Holiday", "Sick", "Others", "Status", "CreateDate", "Time", "YearStatus",
											"EmployeeId" }));
			s_pane.setViewportView(tbl_viewsupplier);
			tbl_viewsupplier.addMouseListener(this);

			txt_supplier.setBounds(480, 40, 180, 30);
			btn_supplier.setBounds(680, 40, 100, 30);
			btn_supplier.addActionListener(this);
			pan_searchsupplier.add(s_pane);

			pan_container.add(txt_supplier);
			pan_container.add(btn_supplier);
			pan_container.add(pan_searchsupplier);
			pan_container.add(txt_searchemployee);
			pan_container.add(btn_searchemployee);
			pan_container.add(pan_searchemp);

			lbl_employeelist.setForeground(Color.ORANGE);
			lbl_attendencetype.setForeground(Color.ORANGE);
			lbl_status.setForeground(Color.ORANGE);

			pan_container.add(lbl_employeelist);
			pan_container.add(lbl_attendencetype);
			pan_container.add(lbl_status);

			pan_container.add(pan_first);
			pan_container.add(pan_second);
			pan_container.add(pan_third);

			// date +employee type

			lbl_date.setBounds(1080, 10, 100, 30);
			date.setBounds(1140, 15, 160, 25);

			lbl_employeetype.setBounds(600, 15, 110, 25);

			txt_allid.setBounds(400, 15, 110, 25);
			another_id.setBounds(250, 15, 110, 25);

			cmb_typeemployee.setBounds(690, 15, 140, 25);

			btn_save.setBounds(400, 544, 80, 20);
			btn_update.setBounds(500, 544, 80, 20);
			btn_delete_supplier.setBounds(400, 544, 80, 20);
			btn_delete_internalemp.setBounds(400, 544, 80, 20);
			btn_report_supplier.setBounds(500, 544, 80, 20);
			btn_report_InternalEmp.setBounds(500, 544, 80, 20);
			btn_updaateserviceprovie.setBounds(600, 544, 80, 20);
			btn_clear.setBounds(700, 544, 80, 20);
			btn_savesupplier.setBounds(800, 544, 80, 20);

			btn_save.setBackground(Color.decode("#875A3C"));
			btn_update.setBackground(Color.decode("#875A3C"));
			btn_delete_supplier.setBackground(Color.decode("#875A3C"));
			btn_delete_internalemp.setBackground(Color.decode("#875A3C"));
			btn_report_supplier.setBackground(Color.decode("#875A3C"));
			btn_report_InternalEmp.setBackground(Color.decode("#875A3C"));
			btn_updaateserviceprovie.setBackground(Color.decode("#875A3C"));
			btn_clear.setBackground(Color.decode("#875A3C"));
			btn_savesupplier.setBackground(Color.decode("#875A3C"));

			btn_save.setForeground(Color.WHITE);
			btn_update.setForeground(Color.WHITE);
			btn_delete_supplier.setForeground(Color.WHITE);
			btn_delete_internalemp.setForeground(Color.WHITE);
			btn_report_supplier.setForeground(Color.WHITE);
			btn_report_InternalEmp.setForeground(Color.WHITE);
			btn_updaateserviceprovie.setForeground(Color.WHITE);
			btn_clear.setForeground(Color.WHITE);
			btn_savesupplier.setForeground(Color.WHITE);

			btn_delete_supplier.addActionListener(this);
			btn_delete_internalemp.addActionListener(this);
			btn_report_supplier.addActionListener(this);
			btn_report_InternalEmp.addActionListener(this);

			btn_savesupplier.addActionListener(this);
			btn_updaateserviceprovie.addActionListener(this);
			btn_clear.addActionListener(this);
			btn_save.addActionListener(this);
			btn_update.addActionListener(this);
			
			
			txt_allid.setVisible(false);
			another_id.setVisible(false);
			

			// date+employee type

			this.add(btn_delete_supplier);
			this.add(btn_delete_internalemp);
			this.add(btn_report_supplier);
			this.add(btn_report_InternalEmp);

			this.add(btn_updaateserviceprovie);
			this.add(btn_clear);
			this.add(btn_savesupplier);
			this.add(lbl_employeetype);
			this.add(txt_allid);
			this.add(another_id);
			this.add(lbl_date);
			this.add(date);
			this.add(cmb_typeemployee);
			this.add(btn_save);
			this.add(btn_update);
			this.add(pan_container);
			this.add(pan);
			attendence();
			Show_productreceivemod();
			Show_supplierinfo();//
			this.getContentPane().setBackground(Color.decode("#ECEAC4"));////ECEAC4
			this.setVisible(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());

		}
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
				resetext();

				DefaultTableModel model = (DefaultTableModel) tbl_viewemp.getModel();
				DefaultTableModel model1 = (DefaultTableModel) tbl_viewsupplier.getModel();
				model1.setRowCount(0);
				model.setRowCount(0);
				Show_supplierinfo();
				Show_productreceivemod();

				//
				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");

			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<InternalLabourAttendanceInfo> receiveorderinfo() {
		ArrayList<InternalLabourAttendanceInfo> usersList = new ArrayList<InternalLabourAttendanceInfo>();
		Connection connection = getConnection();
		String query = "SELECT * FROM  `attandenceinternallabour`";
		Statement st;
		ResultSet rs;
		// private JTable tbl_viewemp = new JTable();
		// private JTable tbl_viewsupplier = new JTable();
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			InternalLabourAttendanceInfo user;
			while (rs.next()) {
				user = new InternalLabourAttendanceInfo(rs.getInt("internalempid"), rs.getString("name"),
						rs.getString("employeetype"), rs.getInt("present"), rs.getInt("absant"), rs.getInt("late"),
						rs.getInt("holiday"), rs.getInt("sick"), rs.getInt("others"), rs.getString("status"),
						rs.getString("createdate"), rs.getString("dateandtime"), rs.getString("yearmonthstatus"),
						rs.getInt("employeeid"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	// Display Data In JTable

	public void Show_productreceivemod() {
		ArrayList<InternalLabourAttendanceInfo> list = receiveorderinfo();
		DefaultTableModel model = (DefaultTableModel) tbl_viewemp.getModel();
		Object[] row = new Object[14];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getInternalabour_id();
			row[1] = list.get(i).getLabour_name();
			row[2] = list.get(i).getEmployee_type();
			row[3] = list.get(i).getPresent();
			row[4] = list.get(i).getAbsant();
			row[5] = list.get(i).getLate();
			row[6] = list.get(i).getHoliday();
			row[7] = list.get(i).getSick();
			row[8] = list.get(i).getOthers();
			row[9] = list.get(i).getStatus();
			row[10] = list.get(i).getCreatedate();
			row[11] = list.get(i).getDatetime();
			row[12] = list.get(i).getYearmonthstatus();
			row[13] = list.get(i).getRetrive_id();

			model.addRow(row);
		}
	}

	// ===============================

	public ArrayList<InternalLabourAttendanceInfo> List_wa_Order1(String search) {// warehouse
		// emp
		ArrayList<InternalLabourAttendanceInfo> usersList = new ArrayList<InternalLabourAttendanceInfo>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `attandenceinternallabour` WHERE CONCAT(`internalempid`, `name`, `employeetype`, `present`,`absant`,`late`,`holiday`,`sick`,`others`,`status`,`createdate`,`dateandtime`,`yearmonthstatus`) LIKE '%"
					+ search + "%'";
			rs = st.executeQuery(searchQuery);

			InternalLabourAttendanceInfo user;

			while (rs.next()) {
				user = new InternalLabourAttendanceInfo(rs.getInt("internalempid"), rs.getString("name"),
						rs.getString("employeetype"), rs.getInt("present"), rs.getInt("absant"), rs.getInt("late"),
						rs.getInt("holiday"), rs.getInt("sick"), rs.getInt("others"), rs.getString("status"),
						rs.getString("createdate"), rs.getString("dateandtime"), rs.getString("yearmonthstatus"),
						rs.getInt("employeeid"));
				usersList.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	public void find_customerorder1() {
		ArrayList<InternalLabourAttendanceInfo> list = List_wa_Order1(txt_searchemployee.getText());// asdjflasjdf;lja;lkdsfjl;k
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "Id", "EmployeeName", "EmpType", "present", "Absant", "Late",
				"Holiday", "Sick", "Others", "Status", "CreateDate", "Time", "YearStatus", "EmployeeId" });
		Object[] row = new Object[14];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getInternalabour_id();
			row[1] = list.get(i).getLabour_name();
			row[2] = list.get(i).getEmployee_type();
			row[3] = list.get(i).getPresent();
			row[4] = list.get(i).getAbsant();
			row[5] = list.get(i).getLate();
			row[6] = list.get(i).getHoliday();
			row[7] = list.get(i).getSick();
			row[8] = list.get(i).getOthers();
			row[9] = list.get(i).getStatus();
			row[10] = list.get(i).getCreatedate();
			row[11] = list.get(i).getDatetime();
			row[12] = list.get(i).getYearmonthstatus();
			row[13] = list.get(i).getRetrive_id();
			model.addRow(row);
		}
		tbl_viewemp.setModel(model);

	}

	// another for your table just judch your
	// selfsjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj

	public ArrayList<SupplierAttendanceInfo> receive_supplierinfo() {
		ArrayList<SupplierAttendanceInfo> usersList = new ArrayList<SupplierAttendanceInfo>();
		Connection connection = getConnection();
		String query = "SELECT * FROM  `attandence_supplier`";
		Statement st;
		ResultSet rs;
		// private JTable tbl_viewemp = new JTable();
		// private JTable tbl_viewsupplier = new JTable();
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			SupplierAttendanceInfo user;
			while (rs.next()) {
				user = new SupplierAttendanceInfo(rs.getInt("supplier_id"), rs.getString("supplier_name"),
						rs.getString("employee_type"), rs.getInt("present"), rs.getInt("absant"), rs.getInt("late"),
						rs.getInt("holiday"), rs.getInt("sick"), rs.getInt("others"), rs.getString("status"),
						rs.getString("createdate"), rs.getString("dateandtime"), rs.getString("yearmonthstatus"),
						rs.getInt("employeeid"));
				usersList.add(user);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return usersList;
	}

	// Display Data In JTable

	public void Show_supplierinfo() {
		ArrayList<SupplierAttendanceInfo> list = receive_supplierinfo();
		DefaultTableModel model = (DefaultTableModel) tbl_viewsupplier.getModel();
		Object[] row = new Object[14];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getSupplier_id();
			row[1] = list.get(i).getSupplier_name();
			row[2] = list.get(i).getEmployee_type();
			row[3] = list.get(i).getPresent();
			row[4] = list.get(i).getAbsant();
			row[5] = list.get(i).getLate();
			row[6] = list.get(i).getHoliday();
			row[7] = list.get(i).getSick();
			row[8] = list.get(i).getOthers();
			row[9] = list.get(i).getStatus();
			row[10] = list.get(i).getCreatedate();
			row[11] = list.get(i).getDatetime();
			row[12] = list.get(i).getYearmonthstatus();
			row[13] = list.get(i).getRetrive_id();

			model.addRow(row);
		}
	}

	// ===============================

	public ArrayList<SupplierAttendanceInfo> List_supplierinfo(String search) {// warehouse
		// emp
		ArrayList<SupplierAttendanceInfo> usersList = new ArrayList<SupplierAttendanceInfo>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `attandence_supplier` WHERE CONCAT(`supplier_id`, `supplier_name`, `employee_type`, `present`,`absant`,`late`,`holiday`,`sick`,`others`,`status`,`createdate`,`dateandtime`,`yearmonthstatus`) LIKE '%"
					+ search + "%'";
			rs = st.executeQuery(searchQuery);

			SupplierAttendanceInfo user;

			while (rs.next()) {
				user = new SupplierAttendanceInfo(rs.getInt("supplier_id"), rs.getString("supplier_name"),
						rs.getString("employee_type"), rs.getInt("present"), rs.getInt("absant"), rs.getInt("late"),
						rs.getInt("holiday"), rs.getInt("sick"), rs.getInt("others"), rs.getString("status"),
						rs.getString("createdate"), rs.getString("dateandtime"), rs.getString("yearmonthstatus"),
						rs.getInt("employeeid"));
				usersList.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	public void receive_supplierinfo1() {
		ArrayList<SupplierAttendanceInfo> list = List_supplierinfo(txt_supplier.getText());// asdjflasjdf;lja;lkdsfjl;k
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "Id", "EmployeeName", "EmpType", "present", "Absant", "Late",
				"Holiday", "Sick", "Others", "Status", "CreateDate", "Time", "YearStatus", "EmployeeId" });
		Object[] row = new Object[14];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getSupplier_id();
			row[1] = list.get(i).getSupplier_name();
			row[2] = list.get(i).getEmployee_type();
			row[3] = list.get(i).getPresent();
			row[4] = list.get(i).getAbsant();
			row[5] = list.get(i).getLate();
			row[6] = list.get(i).getHoliday();
			row[7] = list.get(i).getSick();
			row[8] = list.get(i).getOthers();
			row[9] = list.get(i).getStatus();
			row[10] = list.get(i).getCreatedate();
			row[11] = list.get(i).getDatetime();
			row[12] = list.get(i).getYearmonthstatus();
			row[13] = list.get(i).getRetrive_id();
			model.addRow(row);
		}
		tbl_viewsupplier.setModel(model);

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void delte_supplierinformation() {// done by history
		String fetch_id = "";
		fetch_id = txt_allid.getText().trim();
		String query = "DELETE FROM `attandence_supplier` WHERE supplier_id = " + fetch_id;
		executeSQlQuery_customerOrder(query, "Deleted Record!!");

	}

	public void delte_internalemployee() {// done by history
		String fetch_id = "";
		fetch_id = txt_allid.getText().trim();
		String query = "DELETE FROM `attandenceinternallabour` WHERE internalempid = " + fetch_id;
		executeSQlQuery_customerOrder(query, "Deleted Record!!");

	}

	public void update_internalemp_information() {// history is done

		if (cmb_typeemployee.getSelectedItem().equals("Supplier")) {
			btn_save.setEnabled(false);
			btn_savesupplier.setEnabled(true);

		} else {

			btn_updaateserviceprovie.setEnabled(false);
			btn_save.setEnabled(true);
			String val = "";
			String strdone = "";
			String simpledate = "";
			String type = "";
			String id = "";
			if (cmb_alladdendancetype.getSelectedItem().equals("Present")) {
				str1 = 1;
			} else if (cmb_alladdendancetype.getSelectedItem().equals("Absant")) {
				str2 = 1;
			} else if (cmb_alladdendancetype.getSelectedItem().equals("Late")) {
				str3 = 1;
			} else if (cmb_alladdendancetype.getSelectedItem().equals("Holiday")) {
				str4 = 1;
			} else if (cmb_alladdendancetype.getSelectedItem().equals("Sick")) {
				str5 = 1;
			} else if (cmb_alladdendancetype.getSelectedItem().equals("Others")) {
				str6 = 1;
			}
			if (chec_done.isSelected() == true) {
				strdone = "Done";
			}

			if (date.getDate() == null) {
				JOptionPane.showMessageDialog(null, "The date field id Blank!!");
			} else {
				simpledate = f3.format(date.getDate());
			}

			if (simpledate.equals("")) {
				JOptionPane.showMessageDialog(null, "Field Must Not Empty!!");
			} else {
				val = list_employeelist.getSelectedValue().toString();
				type = cmb_typeemployee.getSelectedItem().toString();
				String fetch_id = "";
				fetch_id = txt_allid.getText().trim();
				String temp = "UPDATE attandenceinternallabour SET " + "internalempid = '" + fetch_id + "',name = '"
						+ val + "',employeetype = '" + type + "',present = '" + str1 + "',absant = '" + str2
						+ "',late = '" + str3 + "',holiday = '" + str4 + "',sick = '" + str5 + "',others = '" + str6
						+ "',status = '" + strdone + "',createdate = '" + simpledate + "',dateandtime = '" + sDate
						+ "', yearmonthstatus= '" + txt_yearwithmonth.getText() + "'" + "WHERE internalempid = '"
						+ fetch_id + "'";
				executeSQlQuery_customerOrder(temp, "Updated");
			}
		}

	}

	public void update_supplier_information() {// history is done

		if (cmb_typeemployee.getSelectedItem().equals("Supplier")) {
			btn_save.setEnabled(false);
			btn_savesupplier.setEnabled(true);

		} else {

			btn_updaateserviceprovie.setEnabled(false);
			btn_save.setEnabled(true);
			String val = "";
			String strdone = "";
			String simpledate = "";
			String type = "";
			String id = "";
			if (cmb_alladdendancetype.getSelectedItem().equals("Present")) {
				str1 = 1;
			} else if (cmb_alladdendancetype.getSelectedItem().equals("Absant")) {
				str2 = 1;
			} else if (cmb_alladdendancetype.getSelectedItem().equals("Late")) {
				str3 = 1;
			} else if (cmb_alladdendancetype.getSelectedItem().equals("Holiday")) {
				str4 = 1;
			} else if (cmb_alladdendancetype.getSelectedItem().equals("Sick")) {
				str5 = 1;
			} else if (cmb_alladdendancetype.getSelectedItem().equals("Others")) {
				str6 = 1;
			}
			if (chec_done.isSelected() == true) {
				strdone = "Done";
			}

			if (date.getDate() == null) {
				JOptionPane.showMessageDialog(null, "The date field id Blank!!");
			} else {
				simpledate = f3.format(date.getDate());
			}

			if (simpledate.equals("")) {
				JOptionPane.showMessageDialog(null, "Field Must Not Empty!!");
			} else {
				val = list_employeelist.getSelectedValue().toString();
				type = cmb_typeemployee.getSelectedItem().toString();
				String fetch_id = "";
				fetch_id = txt_allid.getText().trim();
				String temp = "UPDATE attandence_supplier SET " + "supplier_id = '" + fetch_id + "',supplier_name = '"
						+ val + "',employee_type = '" + type + "',present = '" + str1 + "',absant = '" + str2
						+ "',late = '" + str3 + "',holiday = '" + str4 + "',sick = '" + str5 + "',others = '" + str6
						+ "',status = '" + strdone + "',createdate = '" + simpledate + "',dateandtime = '" + sDate
						+ "', yearmonthstatus= '" + txt_yearwithmonth.getText() + "'" + "WHERE supplier_id = '"
						+ fetch_id + "'";
				executeSQlQuery_customerOrder(temp, "Updated");
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source.equals(btn_save)) {

			if (cmb_typeemployee.getSelectedItem().equals("Supplier")) {
				btn_save.setEnabled(false);
				btn_savesupplier.setEnabled(true);

			} else {
				try {

					conn = connect.setConnection(conn);

					btn_savesupplier.setEnabled(false);
					btn_save.setEnabled(true);
					String val = "";
					String strdone = "";
					String simpledate = "";
					String type = "";
					String id = "";

					if (cmb_alladdendancetype.getSelectedItem().equals("Present")) {
						str1 = 1;
					} else if (cmb_alladdendancetype.getSelectedItem().equals("Absant")) {
						str2 = 1;
					} else if (cmb_alladdendancetype.getSelectedItem().equals("Late")) {
						str3 = 1;
					} else if (cmb_alladdendancetype.getSelectedItem().equals("Holiday")) {
						str4 = 1;
					} else if (cmb_alladdendancetype.getSelectedItem().equals("Sick")) {
						str5 = 1;
					} else if (cmb_alladdendancetype.getSelectedItem().equals("Others")) {
						str6 = 1;
					}
					if (chec_done.isSelected() == true) {
						strdone = "Done";
					}

					if (date.getDate() == null) {
						JOptionPane.showMessageDialog(null, "The date field id Blank!!");
					} else {
						simpledate = f3.format(date.getDate());
					}

					if (simpledate.equals("") || list_employeelist.getSelectedValue().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Field Must Not Empty!!");
					} else {
						record += 1;
						id = " " + record;
						val = list_employeelist.getSelectedValue().toString();
						type = cmb_typeemployee.getSelectedItem().toString();
						Statement stmt = conn.createStatement();
						String query = "SELECT * FROM  attandenceinternallabour WHERE name='" + val + "'"
								+ "AND createdate ='" + simpledate + "'";
						ResultSet rs = stmt.executeQuery(query);
						int foundrec = 0;
						while (rs.next()) {

							String dialogmessage = "Record Already Exists in DataBase!!!";
							int dialogtype = JOptionPane.WARNING_MESSAGE;
							JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);
							foundrec = 1;

						}
						if (foundrec == 0) {

							String temp = "INSERT INTO Attandenceinternallabour(name,employeetype,present,absant,late,holiday,sick,others,status,createdate,dateandtime,yearmonthstatus,employeeid) VALUES ('"
									+ val + "','" + type + "','" + str1 + "','" + str2 + "','" + str3 + "','" + str4
									+ "','" + str5 + "','" + str6 + "','" + strdone + "','" + simpledate + "','" + sDate
									+ "','" + txt_yearwithmonth.getText() + "','" + another_id.getText() + "')";
							
							
							

							int result = stmt.executeUpdate(temp);
							if (result == 1) {
								DefaultTableModel model = (DefaultTableModel) tbl_viewemp.getModel();
								model.setRowCount(0);
								// Show_supplierinfo();
								Show_productreceivemod();
								resetext();

								str1 = 0;
								str2 = 0;
								str3 = 0;
								str4 = 0;
								str5 = 0;
								str6 = 0;

								String dialogmessage = "New Position Added";
								int dialogtype = JOptionPane.INFORMATION_MESSAGE;
								JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);

							} else {
								resetext();
								String dialogmessage = "Failed To Insert";
								JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!",
										JOptionPane.WARNING_MESSAGE);

							}
						}

						else {
							String dialogmessage = "EMPTY VALUE FOUND";
							JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!",
									JOptionPane.WARNING_MESSAGE);

						}
					}

					conn.close();
				} catch (Exception ex) {
					System.out.println("Unknown Error" + ex);

				}

			}

		} else if (source.equals(btn_update)) {

			update_internalemp_information();

		} else if (source.equals(btn_updaateserviceprovie)) {

			update_supplier_information();

		} else if (source.equals(btn_clear)) {

			resetext();

		} else if (source.equals(btn_savesupplier)) {

			if (cmb_typeemployee.getSelectedItem().equals("Supplier")) {
				btn_save.setEnabled(false);
				btn_savesupplier.setEnabled(true);
			} else {
				try {

					conn = connect.setConnection(conn);
					String val = "";
					String strdone = "";
					String simpledate = "";
					String type = "";
					String id = "";

					if (cmb_alladdendancetype.getSelectedItem().equals("Present")) {
						str1 = 1;
					} else if (cmb_alladdendancetype.getSelectedItem().equals("Absant")) {
						str2 = 1;
					} else if (cmb_alladdendancetype.getSelectedItem().equals("Holiday")) {
						str3 = 1;
					} else if (cmb_alladdendancetype.getSelectedItem().equals("Sick")) {
						str4 = 1;
					} else if (cmb_alladdendancetype.getSelectedItem().equals("Late")) {
						str5 = 1;
					} else if (cmb_alladdendancetype.getSelectedItem().equals("Others")) {
						str6 = 1;
					}

					if (chec_done.isSelected() == true) {
						strdone = "Done";
					}

					if (date.getDate() == null) {
						JOptionPane.showMessageDialog(null, "The date field id Blank!!");
					} else {
						simpledate = f3.format(date.getDate());
					}

					if (simpledate.equals("") || list_employeelist.getSelectedValue().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Field Must Not Empty!!");
					} else {
						record1 += 1;
						id = " " + record1;
						val = list_employeelist.getSelectedValue().toString();
						type = cmb_typeemployee.getSelectedItem().toString();
						Statement stmt = conn.createStatement();
						String query = "SELECT * FROM  attandence_supplier WHERE supplier_name='" + val + "'"
								+ "AND createdate ='" + simpledate + "'";
						ResultSet rs = stmt.executeQuery(query);
						int foundrec = 0;
						while (rs.next()) {
							String dialogmessage = "Record Already Exists in DataBase!!!";
							int dialogtype = JOptionPane.WARNING_MESSAGE;
							JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);
							foundrec = 1;

						}
						if (foundrec == 0) {

							String temp = "INSERT INTO attandence_supplier(supplier_name,employee_type,present,absant,late,holiday,sick,others,status,createdate,dateandtime,yearmonthstatus,employeeid) VALUES ('"
									+ val + "','" + type + "','" + str1 + "','" + str2 + "','" + str3 + "','" + str4
									+ "','" + str5 + "','" + str6 + "','" + strdone + "','" + simpledate + "','" + sDate
									+ "','" + txt_yearwithmonth.getText() + "','" + another_id.getText() + "')";

							int result = stmt.executeUpdate(temp);
							if (result == 1) {
								DefaultTableModel model1 = (DefaultTableModel) tbl_viewsupplier.getModel();
								model1.setRowCount(0);
								Show_supplierinfo();
								resetext();
								str1 = 0;
								str2 = 0;
								str3 = 0;
								str4 = 0;
								str5 = 0;
								str6 = 0;
								String dialogmessage = "New Position Added";
								int dialogtype = JOptionPane.INFORMATION_MESSAGE;
								JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);

							} else {
								String dialogmessage = "Failed To Insert";
								JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!",
										JOptionPane.WARNING_MESSAGE);

							}
						}

						else {
							resetext();
							String dialogmessage = "EMPTY VALUE FOUND";
							JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!",
									JOptionPane.WARNING_MESSAGE);

						}
					}

					conn.close();
				} catch (Exception ex) {
					System.out.println("Unknown Error" + ex);

				}

			}

		} else if (source.equals(cmb_typeemployee)) {

			if (cmb_typeemployee.getSelectedItem().equals("Service Provider") == true) {
				btn_save.setEnabled(false);
				btn_savesupplier.setEnabled(true);
				String goahead = (String) cmb_typeemployee.getSelectedItem();
				fill_form(goahead);
			} else {
				btn_save.setEnabled(true);
				btn_savesupplier.setEnabled(false);
				String goahead = (String) cmb_typeemployee.getSelectedItem();
				fill_form(goahead);
			}

		} else if (source.equals(btn_searchemployee)) {
			find_customerorder1();

		} else if (source.equals(btn_supplier)) {
			receive_supplierinfo1();

		} else if (source.equals(btn_delete_supplier)) {
			delte_supplierinformation();

		} else if (source.equals(btn_delete_internalemp)) {
			delte_internalemployee();
		} else if (source.equals(btn_report_supplier)) {
		} else if (source.equals(btn_report_InternalEmp)) {

		}

	}

	@SuppressWarnings("resource")
	public void retrive_customer(JComboBox<String> cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {
			Statement stmt = conn.createStatement();// emp_designation
			String query = "SELECT * FROM settings";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String txt_id = rs.getString(2).trim();
				cmb.addItem(txt_id);

			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void fill_form(String name) {
		DefaultListModel<String> m = new DefaultListModel<String>();
		int counterso = 0;
		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM employee WHERE emp_designation='" + name + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String sager = rs.getString(2).trim();
				counterso++;
				m.addElement(sager);

			}
			list_employeelist.setModel(m);
			System.out.println(counterso);
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void fill_form1(String name) {

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM employee WHERE emp_firstname='" + name + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String sager = rs.getString(1).trim();
				another_id.setText(sager);

			}

			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void forviewsupplier() {
		cmb_typeemployee.setVisible(false);
		lbl_employeelist.setVisible(false);
		lbl_attendencetype.setVisible(false);
		lbl_status.setVisible(false);
		lbl_employeetype.setVisible(false);
		btn_save.setVisible(false);
		btn_update.setVisible(false);
		btn_updaateserviceprovie.setVisible(false);
		btn_clear.setVisible(false);
		btn_savesupplier.setVisible(false);
		pan_first.setVisible(false);
		pan_third.setVisible(false);
		pan_second.setVisible(false);
		pan_searchemp.setVisible(false);
		txt_searchemployee.setVisible(false);
		btn_searchemployee.setVisible(false);
		pan_searchsupplier.setVisible(true);
		btn_supplier.setVisible(true);
		txt_supplier.setVisible(true);

		btn_delete_supplier.setVisible(true);
		btn_report_supplier.setVisible(true);
		btn_delete_internalemp.setVisible(false);
		btn_report_InternalEmp.setVisible(false);

	}

	public void forview_internalemp() {
		cmb_typeemployee.setVisible(false);
		lbl_employeelist.setVisible(false);
		lbl_attendencetype.setVisible(false);
		lbl_status.setVisible(false);
		lbl_employeetype.setVisible(false);
		btn_save.setVisible(false);
		btn_update.setVisible(false);
		pan_first.setVisible(false);
		pan_third.setVisible(false);
		pan_second.setVisible(false);
		btn_updaateserviceprovie.setVisible(false);
		btn_clear.setVisible(false);
		btn_savesupplier.setVisible(false);
		pan_searchsupplier.setVisible(false);
		btn_supplier.setVisible(false);
		txt_supplier.setVisible(false);
		pan_searchemp.setVisible(true);
		txt_searchemployee.setVisible(true);
		btn_searchemployee.setVisible(true);

		//
		btn_delete_supplier.setVisible(false);
		btn_report_supplier.setVisible(false);
		btn_delete_internalemp.setVisible(true);
		btn_report_InternalEmp.setVisible(true);

		//

	}

	public void attendence() {
		cmb_typeemployee.setVisible(true);
		lbl_employeelist.setVisible(true);
		lbl_attendencetype.setVisible(true);
		lbl_status.setVisible(true);
		lbl_employeetype.setVisible(true);
		date.setVisible(true);
		btn_save.setVisible(true);
		btn_update.setVisible(true);
		pan_first.setVisible(true);
		pan_third.setVisible(true);
		pan_second.setVisible(true);
		btn_updaateserviceprovie.setVisible(true);
		btn_clear.setVisible(true);
		btn_savesupplier.setVisible(true);
		pan_searchemp.setVisible(false);
		txt_searchemployee.setVisible(false);
		btn_searchemployee.setVisible(false);
		pan_searchsupplier.setVisible(false);
		btn_supplier.setVisible(false);
		txt_supplier.setVisible(false);

		// new

		btn_delete_supplier.setVisible(false);
		btn_report_supplier.setVisible(false);
		btn_delete_internalemp.setVisible(false);
		btn_report_InternalEmp.setVisible(false);

		// new

	}

	public void resetext() {
		chec_done.setSelected(false);
		txt_yearwithmonth.setText("");
		date.setDate(null);
	}

	class ThreemainButton implements ActionListener, MouseListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source.equals(btn_home)) {
				dispose();
			} else if (source.equals(btn_attendence)) {
				attendence();
			} else if (source.equals(btn_view)) {
				forview_internalemp();
			} else if (source.equals(btn_viewsupplier)) {
				forviewsupplier();

			}

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			int j = tbl_viewemp.getSelectedRow();
			TableModel modelq = tbl_viewemp.getModel();
			txt_allid.setText(modelq.getValueAt(j, 0).toString());
			cmb_typeemployee.setSelectedItem(modelq.getValueAt(j, 2).toString());
			cmb_alladdendancetype.setSelectedItem(modelq.getValueAt(j, 3).toString());
			chec_done.setText((modelq.getValueAt(j, 9).toString()));
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date addDate = new Date();
			try {
				addDate = dateFormat.parse((String) modelq.getValueAt(j, 10));
				date.setDate(addDate);
			} catch (ParseException ex) {
				ex.printStackTrace();
			}
			txt_yearwithmonth.setText(modelq.getValueAt(j, 12).toString());
			str1 = 0;
			str2 = 0;
			str3 = 0;
			str4 = 0;
			str5 = 0;
			str6 = 0;
			btn_updaateserviceprovie.setEnabled(false);
			btn_update.setEnabled(true);

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

	@Override
	public void mouseClicked(MouseEvent e) {
		int j = tbl_viewsupplier.getSelectedRow();
		TableModel modelq = tbl_viewsupplier.getModel();
		txt_allid.setText(modelq.getValueAt(j, 0).toString());
		cmb_typeemployee.setSelectedItem(modelq.getValueAt(j, 2).toString());
		cmb_alladdendancetype.setSelectedItem(modelq.getValueAt(j, 3).toString());
		chec_done.setText((modelq.getValueAt(j, 9).toString()));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date addDate = new Date();
		try {
			addDate = dateFormat.parse((String) modelq.getValueAt(j, 10));
			date.setDate(addDate);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		txt_yearwithmonth.setText(modelq.getValueAt(j, 12).toString());
		str1 = 0;
		str2 = 0;
		str3 = 0;
		str4 = 0;
		str5 = 0;
		str6 = 0;
		btn_updaateserviceprovie.setEnabled(true);
		btn_update.setEnabled(false);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (e.getSource() == list_employeelist) {
			String goahead1 = list_employeelist.getSelectedValue().toString();
			fill_form1(goahead1);
		}

	}

}
