package view;

import java.awt.Color;
import java.awt.Container;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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
import Model.EmployeeInformation;
import Model.RegineEmployeeinfo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Editemployee extends JInternalFrame implements ActionListener, MouseListener {
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
	Databaseconnect connect = new Databaseconnect();
	Connection conn;
	protected JFrame chile_frame;

	private JButton btn_insert = new JButton(new ImageIcon("images/add.png"));
	private JButton btn_update = new JButton(new ImageIcon("images/edit.png"));
	private JButton btn_delete = new JButton(new ImageIcon("images/delete.png"));
	private JButton btn_import = new JButton(new ImageIcon("images/add.png"));
	private JButton btn_rejine = new JButton(new ImageIcon("images/view.png"));
	private JButton btn_searchname = new JButton(new ImageIcon("images/search.png"));

	//

	private JButton btn_deleterejine = new JButton(new ImageIcon("images/delete.png"));
	private JButton btn_searchrejine = new JButton(new ImageIcon("images/search.png"));
	private JButton btn_refinesexit = new JButton(new ImageIcon("images/delete.png"));
	private JButton btn_report = new JButton(new ImageIcon("images/add.png"));

	protected JTextField txt_searchem = new JTextField(10);

	///
	JPanel pan_top = new JPanel();
	//

	private JTextField txt_Empid = new JTextField();
	private JTextField txt_Empfirstname = new JTextField();
	private JTextField txt_Emplastname = new JTextField();
	private JTextField txt_Empaddress = new JTextField();
	private JTextField txt_Empconatactno = new JTextField();
	JDateChooser date_chooser = new JDateChooser();

	//
	private JComboBox<String> cmb_destion = new JComboBox<String>();
	private JComboBox<String> cmb_worktype = new JComboBox<String>();
	private JComboBox<String> cmb_emptype = new JComboBox<String>();
	//
	private JTable table;
	//
	private JTable table1 = new JTable();
	private JScrollPane scrollpane1 = new JScrollPane();
	//
	private JScrollPane scrollpane = new JScrollPane();
	//
	private JTextField txt_empserchbyname = new JTextField(10);

	//
	Container pane = getContentPane();
	//
	String id;
	String firstname;
	String lastname;
	String destion;
	String address;
	String contactno;
	String worktype;
	String emptype;
	String dateofjoing;
	public static int record;
	String reserialid;
	String re_id;
	String re_firstname;
	String re_lastname;
	String re_destion;
	String re_address;
	String re_contactno;
	String re_worktype;
	String re_emptype;
	String re_dateofjoing;
	String re_dateofgine;
	String re_reason;
	///
	private JTextField txt_Empid1 = new JTextField();
	private JTextField txt_Empfirstname1 = new JTextField();
	private JTextField txt_Emplastname1 = new JTextField();
	private JTextField txt_Empaddress1 = new JTextField();
	private JTextField txt_Empconatactno1 = new JTextField();
	JDateChooser date_go = new JDateChooser();
	private JTextField cmb_destion1 = new JTextField();
	private JTextField cmb_worktype1 = new JTextField();
	private JTextField cmb_emptype1 = new JTextField();
	private JTextField cmb_reason = new JTextField();// dssssssssssdfffffffffff

	///
	private JButton btn_add = new JButton("Add Emp");
	JButton btn_clear = new JButton("Clear");
	private JButton btn_home = new JButton("Home");
	JPanel pan_details = new JPanel();
	JPanel pan_first = new JPanel();
	JPanel pan_table = new JPanel();
	JPanel pan_action = new JPanel();

	String username = null;
	///

	public Editemployee(JFrame getParentFrame, String user) {
		super("Employee Management", true, true, true, true);
		try {
			JFParentFrame = getParentFrame;
			this.setSize(1100, 550);
			this.setLayout(null);
			username = user;
			System.out.println("Golam hard work" + username);
			JPanel pan = new JPanel();
			pan.setLayout(null);
			pan.setBackground(Color.decode("#D2DDF1"));
			pan.setBounds(0, 0, 130, 850);
			Border thickBorder = new LineBorder(Color.decode("#394B58"), 12);
			btn_add.setBounds(20, 60, 80, 80);
			btn_home.setBounds(20, 180, 80, 80);
			btn_add.setBackground(Color.decode("#250800"));
			btn_home.setBackground(Color.decode("#250800"));

			btn_add.addActionListener(this);

			btn_home.addActionListener(this);

			btn_add.setForeground(Color.WHITE);
			btn_rejine.setText("View");

			btn_home.setForeground(Color.WHITE);
			btn_add.setBorder(thickBorder);

			btn_home.setBorder(thickBorder);
			pan.add(btn_home);
			pan.add(btn_add);

			Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
			pan_details.setBorder(raisedetched);
			pan_details.setBounds(200, 50, 1100, 500);
			pan_details.setLayout(null);
			TitledBorder reg_Border_reg = BorderFactory.createTitledBorder("Employee Information");
			reg_Border_reg.setTitleJustification(TitledBorder.LEFT);
			pan_first.setBorder(reg_Border_reg);
			pan_first.setBounds(20, 20, 1065, 250);
			pan_first.setLayout(null);
			JLabel lbl_Empid = new JLabel("Id :");
			JLabel lbl_Empfirstname = new JLabel("First Name :");
			JLabel lbl_Emplastname = new JLabel("Last Name :");
			JLabel lbl_Empdesignation = new JLabel("Designation :");
			JLabel lbl_Empaddress = new JLabel("Address :");
			JLabel lbl_Empconatactno = new JLabel("Contact No :");
			JLabel lbl_Empworktype = new JLabel("Work Type :");
			JLabel lbl_Emptype = new JLabel("Employee Type :");
			JLabel lbl_Empdateofjoing = new JLabel("Date of Joing :");
			JLabel lbl_Empdateofresign = new JLabel("Date of Resign :");
			JLabel lbl_Empdtfalse = new JLabel("Reason");

			lbl_Empid.setBounds(30, 20, 100, 30);
			lbl_Empfirstname.setBounds(30, 60, 100, 30);
			lbl_Emplastname.setBounds(30, 100, 100, 30);
			lbl_Empdesignation.setBounds(30, 140, 100, 30);
			lbl_Empaddress.setBounds(30, 180, 100, 30);

			txt_Empid.setBounds(140, 25, 160, 25);
			txt_Empfirstname.setBounds(140, 65, 160, 25);
			txt_Emplastname.setBounds(140, 105, 160, 25);
			txt_Empaddress.setBounds(140, 185, 160, 25);
			cmb_destion.setBounds(140, 145, 160, 25);

			lbl_Empconatactno.setBounds(340, 20, 100, 30);
			lbl_Empworktype.setBounds(340, 60, 100, 30);
			lbl_Emptype.setBounds(340, 100, 100, 30);
			lbl_Empdateofjoing.setBounds(340, 140, 100, 30);
			lbl_Empdateofresign.setBounds(340, 180, 100, 30);

			pan_first.add(lbl_Empconatactno);
			pan_first.add(lbl_Empworktype);
			pan_first.add(lbl_Emptype);
			pan_first.add(lbl_Empdateofjoing);
			pan_first.add(lbl_Empdateofresign);

			txt_Empconatactno.setBounds(450, 25, 160, 25);
			cmb_worktype.setBounds(450, 65, 160, 25);
			cmb_emptype.setBounds(450, 105, 160, 25);
			date_chooser.setBounds(450, 145, 160, 25);
			date_go.setBounds(450, 185, 160, 25);

			lbl_Empdtfalse.setBounds(650, 20, 90, 30);
			cmb_reason.setBounds(720, 20, 150, 30);

			//

			pan_first.setBackground(Color.WHITE);
			cmb_destion.setBackground(Color.WHITE);
			cmb_worktype.setBackground(Color.WHITE);
			cmb_emptype.setBackground(Color.WHITE);
			pan_action.setBackground(Color.WHITE);

			pan_first.add(lbl_Empdtfalse);
			pan_first.add(cmb_reason);

			pan_first.add(txt_Empconatactno);
			pan_first.add(cmb_worktype);
			pan_first.add(cmb_emptype);
			pan_first.add(date_chooser);
			pan_first.add(date_go);

			pan_first.add(txt_Empid);
			pan_first.add(txt_Empfirstname);
			pan_first.add(txt_Emplastname);
			pan_first.add(txt_Empaddress);
			pan_first.add(cmb_destion);

			pan_first.add(lbl_Empid);
			pan_first.add(lbl_Empfirstname);
			pan_first.add(lbl_Emplastname);
			pan_first.add(lbl_Empdesignation);
			pan_first.add(lbl_Empaddress);

			TitledBorder reg_sager = BorderFactory.createTitledBorder("");
			reg_sager.setTitleJustification(TitledBorder.LEFT);
			pan_action.setBorder(reg_sager);
			pan_action.setLayout(null);
			pan_action.setBounds(890, 20, 150, 220);

			JLabel lbl_search = new JLabel("Search");
			lbl_search.setBounds(1010, 10, 40, 30);
			txt_empserchbyname.setBounds(1055, 15, 150, 25);
			btn_searchname.setBounds(1210, 15, 90, 25);
			btn_searchname.setText("Search");
			this.add(lbl_search);
			this.add(txt_empserchbyname);
			this.add(btn_searchname);

			pan_action.add(btn_clear);
			btn_clear.addActionListener(this);

			btn_insert.setBounds(20, 10, 110, 25);
			btn_update.setBounds(20, 45, 110, 25);
			btn_delete.setBounds(20, 80, 110, 25);
			btn_import.setBounds(20, 115, 110, 25);
			btn_rejine.setBounds(20, 150, 110, 25);
			btn_clear.setBounds(20, 185, 110, 25);

			btn_insert.setBackground(Color.decode("#BFFFE6"));
			btn_update.setBackground(Color.decode("#BFFFE6"));
			btn_delete.setBackground(Color.decode("#BFFFE6"));
			btn_import.setBackground(Color.decode("#BFFFE6"));
			btn_rejine.setBackground(Color.decode("#BFFFE6"));
			btn_searchname.setBackground(Color.decode("#BFFFE6"));
			btn_clear.setBackground(Color.decode("#BFFFE6"));

			pan_action.add(btn_rejine);

			pan_action.add(btn_insert);
			pan_action.add(btn_update);
			pan_action.add(btn_delete);
			pan_action.add(btn_import);

			pan_first.add(pan_action);

			pan_details.add(pan_first);
			TitledBorder reg_Border_reg1 = BorderFactory.createTitledBorder("");
			reg_Border_reg1.setTitleJustification(TitledBorder.LEFT);
			pan_table.setBorder(reg_Border_reg1);
			pan_table.setBounds(20, 280, 1065, 200);
			pan_table.setLayout(new GridLayout(0, 1));

			table = new JTable();
			table.addMouseListener(this);
			table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Id", "FirstName",
					"LastName", "Desingnation", "Address", "ContactNo", "WorkType", "EmployeeType", "DataofJoin" }));
			scrollpane.setViewportView(table);
			scrollpane.setBounds(0, 0, 500, 300);
			pan_table.add(scrollpane);

			pan_details.add(pan_table);

			// ++++++++++++++++++++++++++++++++++++++++++++
			// ============================================
			this.add(pan_details);
			this.add(pan);

			JLabel lbl_Empdatefalse = new JLabel("False");
			lbl_Empdatefalse.setVisible(false);
			JLabel lbl_Empdatfalse = new JLabel("False");
			lbl_Empdatfalse.setVisible(false);

			JPanel pangird = new JPanel();
			pangird.setLocation(0, 15);
			pangird.setLayout(new GridLayout(0, 4));
			retrive_empdescation(cmb_destion);
			cmb_worktype.addItem("Full-Time");
			cmb_worktype.addItem("Half-Time");
			cmb_emptype.addItem("Parmanent");
			cmb_emptype.addItem("Temporyey");

			btn_insert.setToolTipText("Insert Button");
			btn_update.setToolTipText("Updaete Button");
			btn_delete.setToolTipText("Delete Button");

			btn_import.setToolTipText("Re Button");
			btn_insert.setText("Insert");
			btn_update.setText("Update");
			btn_delete.setText("Delete");

			btn_import.setText("Rejine");// rejine for employee ha ha ha

			btn_insert.addActionListener(this);
			btn_import.addActionListener(this);
			btn_rejine.addActionListener(this);
			btn_delete.addActionListener(this);
			btn_update.addActionListener(this);
			btn_searchname.addActionListener(this);
			this.setLocation(screenheith / 7, screedwidth / 27);
			Show_Users_In_JTable();
			this.setVisible(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());

		}
	}

	public void rejine_Employee() {
		try {
			chile_frame = new JFrame();
			chile_frame.setTitle("Regine Employee");
			chile_frame.setSize(1040, 500);
			chile_frame.setLayout(null);
			chile_frame.setLocation(screenheith / 4, screedwidth / 16);
			chile_frame.setResizable(false);
			JLabel lbl_search = new JLabel("Search Employee :");
			lbl_search.setBounds(310, 60, 120, 20);
			txt_searchem.setBounds(435, 60, 100, 20);
			btn_searchrejine.setBounds(560, 60, 100, 20);// sdfgsfddsg
			btn_deleterejine.setBounds(365, 430, 100, 20);// sdfgsdfg
			btn_refinesexit.setBounds(490, 430, 100, 20);// fdhdfghdf
			btn_report.setBounds(625, 430, 100, 20);
		
			btn_deleterejine.setText("Delete");
			btn_refinesexit.setText("Exit");
			btn_report.setText("Report");
			btn_searchrejine.setText("Search");

			btn_deleterejine.setBackground(Color.decode("#BFFFE6"));
			btn_refinesexit.setBackground(Color.decode("#BFFFE6"));
			btn_report.setBackground(Color.decode("#BFFFE6"));
			btn_searchrejine.setBackground(Color.decode("#BFFFE6"));

			btn_deleterejine.addActionListener(this);
			btn_searchrejine.addActionListener(this);
			btn_refinesexit.addActionListener(this);
			btn_report.addActionListener(this);

			JPanel pan_one = new JPanel();
			pan_one.setLayout(new GridLayout());
			pan_one.setBounds(20, 100, 1000, 310);
			pan_one.setBackground(Color.red);
			table1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
					new String[] { "RegineId", "PreviousId", "FirstName", "LastName", "Desingnation", "Address",
							"ContactNo", "WorkType", "EmployeeType", "Dataofregine", "Reason", "Dateofjoin" }));

			scrollpane1.setViewportView(table1);
			scrollpane1.setBounds(0, 0, 500, 300);
			pan_one.add(scrollpane1);
			chile_frame.add(lbl_search);
			chile_frame.add(txt_searchem);
			chile_frame.add(btn_searchrejine);
			chile_frame.add(btn_deleterejine);
			chile_frame.add(btn_refinesexit);
			chile_frame.add(btn_report);
			chile_frame.add(pan_one);
			chile_frame.getContentPane().setBackground(Color.WHITE);
			Show_Users_In_JTable_regine();
			chile_frame.setVisible(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Eror the Rejime the Employee" + ex.toString());

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

	public ArrayList<EmployeeInformation> ListUsers(String ValToSearch) {
		ArrayList<EmployeeInformation> usersList = new ArrayList<EmployeeInformation>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `employee` WHERE CONCAT(`emp_id`, `emp_firstname`, `emp_lastname`, `emp_designation`,`emp_address`,`emp_contactno`,`emp_worktype`,`emp_type`,`emp_dateofjoing`) LIKE '%"
					+ ValToSearch + "%'";
			rs = st.executeQuery(searchQuery);

			EmployeeInformation user;

			while (rs.next()) {
				user = new EmployeeInformation(rs.getInt("emp_id"), rs.getString("emp_firstname"),
						rs.getString("emp_lastname"), rs.getString("emp_designation"), rs.getString("emp_address"),
						rs.getString("emp_contactno"), rs.getString("emp_worktype"), rs.getString("emp_type"),
						rs.getString("emp_dateofjoing"));
				usersList.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	public void findUsers() {
		ArrayList<EmployeeInformation> users = ListUsers(txt_empserchbyname.getText());
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "Id", "FirstName", "LastName", "Desingnation", "Address", "ContactNo",
				"WorkType", "EmployeeType", "DataofJoin" });
		Object[] row = new Object[9];
		for (int i = 0; i < users.size(); i++) {
			row[0] = users.get(i).getId();
			row[1] = users.get(i).getFrist_name();
			row[2] = users.get(i).getLast_name();
			row[3] = users.get(i).getDestion();
			row[4] = users.get(i).getAddress();
			row[5] = users.get(i).getContact_no();
			row[6] = users.get(i).getWork_type();
			row[7] = users.get(i).getEmp_type();
			row[8] = users.get(i).getDate_ofjoin();
			model.addRow(row);
		}
		table.setModel(model);

	}

	//

	public void executeSQlQuery(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {
				// refresh jtable data
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				Show_Users_In_JTable();
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
	public ArrayList<EmployeeInformation> getUsersList() {
		ArrayList<EmployeeInformation> usersList = new ArrayList<EmployeeInformation>();
		Connection connection = getConnection();

		String query = "SELECT * FROM  `employee` ";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			EmployeeInformation user;
			while (rs.next()) {
				user = new EmployeeInformation(rs.getInt("emp_id"), rs.getString("emp_firstname"),
						rs.getString("emp_lastname"), rs.getString("emp_designation"), rs.getString("emp_address"),
						rs.getString("emp_contactno"), rs.getString("emp_worktype"), rs.getString("emp_type"),
						rs.getString("emp_dateofjoing"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	// Display Data In JTable

	public void Show_Users_In_JTable() {
		ArrayList<EmployeeInformation> list = getUsersList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[9];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getFrist_name();
			row[2] = list.get(i).getLast_name();
			row[3] = list.get(i).getDestion();
			row[4] = list.get(i).getAddress();
			row[5] = list.get(i).getContact_no();
			row[6] = list.get(i).getWork_type();
			row[7] = list.get(i).getEmp_type();
			row[8] = list.get(i).getDate_ofjoin();
			model.addRow(row);
		}
	}

	// =====================================================================================
	public void executeSQlQuery_regine(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {
				// refresh jtable data
				DefaultTableModel model = (DefaultTableModel) table1.getModel();
				model.setRowCount(0);
				Show_Users_In_JTable_regine();// add the data into table
				resetText();

				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// =====================================================================================
	public void Show_Users_In_JTable_regine() {
		ArrayList<RegineEmployeeinfo> list = getUsersList_rigine();
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		Object[] row = new Object[12];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getRegine_id();
			row[1] = list.get(i).getRe_id();
			row[2] = list.get(i).getRe_firstname();
			row[3] = list.get(i).getRe_lastname();
			row[4] = list.get(i).getRe_designation();
			row[5] = list.get(i).getRe_address();
			row[6] = list.get(i).getRe_contactno();
			row[7] = list.get(i).getRe_worktype();
			row[8] = list.get(i).getRe_employeetype();
			row[9] = list.get(i).getRe_dateregine();
			row[10] = list.get(i).getRe_reason();
			row[11] = list.get(i).getRe_join();
			model.addRow(row);
		}
	}

	// ===================================================================================
	public ArrayList<RegineEmployeeinfo> getUsersList_rigine() {
		ArrayList<RegineEmployeeinfo> usersList = new ArrayList<RegineEmployeeinfo>();
		Connection connection = getConnection();

		String query = "SELECT * FROM  `regine` ";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			RegineEmployeeinfo user;
			while (rs.next()) {
				user = new RegineEmployeeinfo(rs.getInt("regineId"), rs.getInt("re_id"), rs.getString("re_firstname"),
						rs.getString("re_lastname"), rs.getString("re_designation"), rs.getString("re_address"),
						rs.getString("re_contactno"), rs.getString("re_worktype"), rs.getString("re_employetype"),
						rs.getString("re_dateregine"), rs.getString("re_reason"), rs.getString("joindate"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	// ===================================================================================
	public ArrayList<RegineEmployeeinfo> List_remployee(String searchemp_regine) {
		ArrayList<RegineEmployeeinfo> usersList = new ArrayList<RegineEmployeeinfo>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `regine` WHERE CONCAT(`re_id`, `re_firstname`, `re_lastname`, `re_designation`,`re_address`,`re_contactno`,`re_worktype`,`re_employetype`,`re_dateregine`,`re_reason`) LIKE '%"
					+ searchemp_regine + "%'";
			rs = st.executeQuery(searchQuery);

			RegineEmployeeinfo user;

			while (rs.next()) {
				user = new RegineEmployeeinfo(rs.getInt("regineId"), rs.getInt("re_id"), rs.getString("re_firstname"),
						rs.getString("re_lastname"), rs.getString("re_designation"), rs.getString("re_address"),
						rs.getString("re_contactno"), rs.getString("re_worktype"), rs.getString("re_employetype"),
						rs.getString("re_dateregine"), rs.getString("re_reason"), rs.getString("joindate"));
				usersList.add(user);

			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	public void find_Remployee() {
		ArrayList<RegineEmployeeinfo> list = List_remployee(txt_searchem.getText());
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "Id", "FirstName", "LastName", "Desingnation", "Address", "ContactNo",
				"WorkType", "EmployeeType", "DataofJoin", "Reason" });
		Object[] row = new Object[10];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getRe_id();
			row[1] = list.get(i).getRe_firstname();
			row[2] = list.get(i).getRe_lastname();
			row[3] = list.get(i).getRe_designation();
			row[4] = list.get(i).getRe_address();
			row[5] = list.get(i).getRe_contactno();
			row[6] = list.get(i).getRe_worktype();
			row[7] = list.get(i).getRe_employeetype();
			row[8] = list.get(i).getRe_dateregine();
			row[9] = list.get(i).getRe_reason();
			model.addRow(row);
		}
		table1.setModel(model);

	}
	// ====================================================================================

	// ===================================================================================

	// ====================================================================================
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(btn_import)) {// rejine
			reserialid = "";
			re_dateofgine = "";

			re_id = "";
			re_firstname = "";
			re_lastname = "";
			re_destion = "";
			re_address = "";
			re_contactno = "";
			re_worktype = "";
			re_emptype = "";
			re_dateofjoing = "";
			re_reason = "";
			record += 1;
			reserialid = "" + record;
			re_id = txt_Empid.getText().trim();
			re_firstname = txt_Empfirstname.getText().trim();
			re_lastname = txt_Emplastname.getText().trim();
			re_destion = txt_Empaddress.getText().trim();
			re_address = txt_Empconatactno.getText().trim();
			re_contactno = cmb_destion.getSelectedItem().toString();
			re_worktype = cmb_worktype.getSelectedItem().toString();
			re_emptype = cmb_emptype.getSelectedItem().toString();

			SimpleDateFormat f3 = new SimpleDateFormat("yyyy-MM-dd");
			if (date_go.getDate() == null) {
				JOptionPane.showMessageDialog(null, "The date field id Blank!!");
			} else {
				re_dateofjoing = f3.format(date_go.getDate());
			}
			re_reason = cmb_reason.getText().trim();

			if (date_chooser.getDate() == null) {
				JOptionPane.showMessageDialog(null, "The date field id Blank!!");
			} else {
				re_dateofgine = f3.format(date_chooser.getDate());
			}

			if (re_id.equals("") || re_firstname.equals("") || re_lastname.equals("") || re_destion.equals("")
					|| re_address.equals("") || re_contactno.equals("") || re_worktype.equals("")
					|| re_emptype.equals("'") || re_emptype.equals("") || re_reason.equals("")) {
				JOptionPane.showMessageDialog(null, "Field must not be empty!");
			} else {
				String query = "INSERT INTO regine VALUES ('" + reserialid + "','" + re_id + "','" + re_firstname
						+ "','" + re_lastname + "','" + re_destion + "','" + re_address + "','" + re_contactno + "','"
						+ re_worktype + "','" + re_emptype + "','" + re_dateofjoing + "','" + re_reason + "','"
						+ re_dateofgine + "')";

				executeSQlQuery(query, "Inserted");

			}

		} else if (source.equals(btn_clear)) {
			resetText();
		} else if (source.equals(btn_insert)) {
			id = "";
			firstname = "";
			lastname = "";
			destion = "";
			address = "";
			contactno = "";
			worktype = "";
			emptype = "";
			dateofjoing = "";
			id = txt_Empid.getText().trim();
			firstname = txt_Empfirstname.getText().trim();
			lastname = txt_Emplastname.getText().trim();
			destion = (String) cmb_destion.getSelectedItem();
			address = txt_Empaddress.getText().trim();
			contactno = txt_Empconatactno.getText().trim();
			worktype = (String) cmb_worktype.getSelectedItem();
			emptype = (String) cmb_emptype.getSelectedItem();
			SimpleDateFormat f3 = new SimpleDateFormat("yyyy-MM-dd");
			if (date_chooser.getDate() == null) {
				JOptionPane.showMessageDialog(null, "The date field id Blank!!");
			} else {
				dateofjoing = f3.format(date_chooser.getDate());
			}

			if (id.equals("") || firstname.equals("") || lastname.equals("") || destion.equals("") || address.equals("")
					|| contactno.equals("") || worktype.equals("") || emptype.equals("'") || dateofjoing.equals("")) {
				JOptionPane.showMessageDialog(null, "Field must not be empty!");

			} else {
				String query = "INSERT INTO employee VALUES ('" + id + "','" + firstname + "','" + lastname + "','"
						+ destion + "','" + address + "','" + contactno + "','" + worktype + "','" + emptype + "','"
						+ dateofjoing + "')";
				executeSQlQuery(query, "Inserted");
			}

		} else if (source.equals(btn_searchname)) {
			findUsers();

		} else if (source.equals(btn_update)) {
			id = "";
			firstname = "";
			lastname = "";
			destion = "";
			address = "";
			contactno = "";
			worktype = "";
			emptype = "";
			dateofjoing = "";
			id = txt_Empid.getText().trim();
			firstname = txt_Empfirstname.getText().trim();
			lastname = txt_Emplastname.getText().trim();
			destion = (String) cmb_destion.getSelectedItem();
			address = txt_Empaddress.getText().trim();
			contactno = txt_Empconatactno.getText().trim();
			worktype = (String) cmb_worktype.getSelectedItem();
			emptype = (String) cmb_emptype.getSelectedItem();
			DateFormat f = DateFormat.getDateInstance(DateFormat.LONG);
			String sr = f.format(date_chooser.getDate());
			dateofjoing = sr;
			if (id.equals("") || firstname.equals("") || lastname.equals("") || destion.equals("") || address.equals("")
					|| contactno.equals("")) {
				JOptionPane.showMessageDialog(null, "Field Must Not Empty!!!", "Error Empty Field",
						JOptionPane.ERROR_MESSAGE);

			} else {

				String temp = "UPDATE employee SET " + "emp_id = '" + id + "',emp_firstname = '" + firstname
						+ "',emp_lastname = '" + lastname + "',emp_designation = '" + destion + "',emp_address = '"
						+ address + "',emp_contactno = '" + contactno + "',emp_worktype = '" + worktype
						+ "',emp_type = '" + emptype + "',emp_dateofjoing = '" + dateofjoing + "'" + "WHERE emp_id = '"
						+ id + "'";
				executeSQlQuery(temp, "Updated");

			}

		} else if (source.equals(btn_delete)) {
			id = "";
			id = txt_Empid.getText().trim();
			if (id.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Select Table Row!!!", "Error Delete Button",
						JOptionPane.ERROR_MESSAGE);
			} else {
				String query = "DELETE FROM `employee` WHERE emp_id = " + id;
				executeSQlQuery(query, "Deleted Employee");

			}

		} else if (source.equals(btn_rejine)) {

			rejine_Employee();

		} else if (source.equals(btn_home)) {
			dispose();
			this.setVisible(false);

		} else if (source.equals(btn_deleterejine)) {// rejine employee
			re_id = "";
			re_id = txt_searchem.getText().trim();

			if (re_id.equals("")) {
				JOptionPane.showMessageDialog(null, "Field Must Not Empty!!!", "Error Delete Button",
						JOptionPane.ERROR_MESSAGE);

			} else {
				String query = "DELETE FROM `regine` WHERE re_id = " + re_id;
				executeSQlQuery_regine(query, "Deleted Employee");

			}

		} else if (source.equals(btn_searchrejine)) {// rejine employee
			find_Remployee();
		} else if (source.equals(btn_refinesexit)) {// rejine employee
			chile_frame.setVisible(false);

		} else if (source.equals(btn_report)) {
			try {

				
				conn = connect.setConnection(conn);
				JasperDesign jd = JRXmlLoader.load("C:\\Users\\golam\\workspace\\BakeryManagementSystem\\Report\\report1.jrxml");
				JasperReport jr = JasperCompileManager.compileReport(jd);
				JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
				JasperViewer.viewReport(jp, false);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Exception" + ex.toString());

			}

		}

	}

	public void retrive_empdescation(JComboBox<String> cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM Settings";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String txt_catagoryname = rs.getString(2).trim();
				cmb.addItem(txt_catagoryname);
			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void resetText() {
		txt_Empid.setText("");
		txt_Empfirstname.setText("");
		txt_Emplastname.setText("");
		txt_Empaddress.setText("");
		txt_Empconatactno.setText("");
		txt_Empid.setText("");
		txt_Empfirstname.setText("");
		txt_Emplastname.setText("");
		txt_Empaddress.setText("");
		txt_Empconatactno.setText("");
		date_chooser.setDate(null);
		txt_empserchbyname.setText("");
		txt_Empid1.setText("");
		txt_Empfirstname1.setText("");
		txt_Emplastname1.setText("");
		txt_Empaddress1.setText("");
		txt_Empconatactno1.setText("");
		cmb_destion1.setText("");
		cmb_worktype1.setText("");
		cmb_emptype1.setText("");
		cmb_reason.setText("");

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int i = table.getSelectedRow();
		TableModel model = table.getModel();
		txt_Empid.setText(model.getValueAt(i, 0).toString());
		txt_Empfirstname.setText(model.getValueAt(i, 1).toString());
		txt_Emplastname.setText(model.getValueAt(i, 2).toString());
		cmb_destion.setSelectedItem(model.getValueAt(i, 3).toString());
		txt_Empaddress.setText(model.getValueAt(i, 4).toString());
		txt_Empconatactno.setText(model.getValueAt(i, 5).toString());
		cmb_worktype.setSelectedItem(model.getValueAt(i, 6).toString());
		cmb_emptype.setSelectedItem(model.getValueAt(i, 7).toString());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date addDate = new Date();
		try {
			addDate = dateFormat.parse((String) model.getValueAt(i, 8));
			date_chooser.setDate(addDate);
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

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}