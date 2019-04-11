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
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



import Controller.Databaseconnect;
import Model.AttendanceMontlyInfo;
import Model.AttendanceYearlyInfo;

public class AttandenceSetting extends JInternalFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int record;
	public static int recore5;
	public String query1, query2, query3, query4, query5, query6, query7, query8, query9, query10, query11, query12;
	static Date td = new Date();
	static String sDate = DateFormat.getDateTimeInstance().format(td);
	JTextField txt_allid = new JTextField();
	Connection conn;
	Databaseconnect connect = new Databaseconnect();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	// sidebar button or main button
	private JButton btn_home = new JButton("Home");
	private JButton btn_monthlysetting = new JButton("Monthly");
	private JButton btn_yearlysetting = new JButton("Yearly");
	Border thickBorder = new LineBorder(Color.decode("#394B58"), 15);
	// sidebar button or main buttonF
	private JButton btn_add = new JButton("Save");
	private JButton btn_update = new JButton("Update");
	private JButton btn_delete = new JButton("Delete");
	private JButton btn_clear = new JButton("Clear");
	private JButton btn_report = new JButton("Report");
	// year
	private JButton btn_add_year = new JButton("Save");
	private JButton btn_update_year = new JButton("Update");
	private JButton btn_delete_year = new JButton("Delete");
	private JButton btn_clear_year = new JButton("Clear");
	private JButton btn_report_year = new JButton("Report");
	// year

	// table
	private JComboBox<String> emb_employeename = new JComboBox<String>();
	private JLabel lbl_id = new JLabel("Employee Id");
	JTextField date = new JTextField();
	JLabel lbl_date = new JLabel("Date");
	// search
	JButton btn_searchmonth = new JButton("Search");
	JTextField txt_monthserch = new JTextField();
	JButton btn_search_year = new JButton("Search");
	JTextField txt_yearserch = new JTextField();

	// search
	JPanel pane_table = new JPanel();
	JPanel pane_uppermonth = new JPanel();
	JPanel pane_table_year = new JPanel();
	JPanel pane_uppermonth_year = new JPanel();

	private JTable tbl_month = new JTable();
	private JScrollPane pane_month = new JScrollPane();
	private JTable tbl_month_year = new JTable();
	private JScrollPane scroll_year = new JScrollPane();

	JTextField txt_present = new JTextField();
	JTextField txt_absant = new JTextField();
	JTextField txt_sick = new JTextField();
	JTextField txt_late = new JTextField();
	JTextField txt_holiday = new JTextField();
	JTextField txt_others = new JTextField();
	JTextField txt_year = new JTextField();
	JTextField txt_yearstatus = new JTextField();
	JTextField txt_employeename = new JTextField();

	JButton btn_query = new JButton("Attendance");
	// table
	// year
	JTextField txt_present_year = new JTextField();
	JTextField txt_absant_year = new JTextField();
	JTextField txt_sick_year = new JTextField();
	JTextField txt_late_year = new JTextField();
	JTextField txt_holiday_year = new JTextField();
	JTextField txt_others_year = new JTextField();
	JTextField txt_year_year = new JTextField();
	JTextField txt_yearstatus_year = new JTextField();
	JTextField txt_employeename_year = new JTextField();

	JButton btn_query_year = new JButton("Query");
	JLabel lbl_present1 = new JLabel("Total Present");
	JLabel lbl_absant1 = new JLabel("Total Absant");
	JLabel lbl_sick1 = new JLabel("Total Sick");
	JLabel lbl_late1 = new JLabel("Total Late");
	JLabel lbl_holiday1 = new JLabel("Total Holiday");
	JLabel lbl_others1 = new JLabel("Total Others");
	JLabel lbl_year1 = new JLabel("Enter Year");
	JLabel lbl_yearemployeetype = new JLabel("Employee Type");
	JLabel lbl_employeename1 = new JLabel("Employee  Name");

	//
	public String str1 = "", str2 = "", str3 = "", str4 = "", str5 = "", str6 = "", str7 = "", str8 = "", str9 = "",
			str10 = "", str11 = "", str12 = "", str13 = "";

	//

	// year
	public AttandenceSetting(JFrame getParentFrame) {
		super("Setting Report", true, true, true, true);
		try {
			this.setSize(1010, 550);
			this.setLayout(null);
			JPanel pan = new JPanel();
			JPanel pan_container = new JPanel();
			pan_container.setBounds(183, 50, 1130, 480);
			pan_container.setBorder(thickBorder);
			pan_container.setBackground(Color.WHITE);
			pan_container.setLayout(null);
			pan.setLayout(null);
			pan.setBounds(0, 0, 130, 850);
			pan.setBackground(Color.decode("#D2DDF1"));
			btn_home.setBounds(20, 60, 80, 80);
			btn_home.setBorder(thickBorder);
			btn_home.setBackground(Color.decode("#250800"));
			btn_home.setForeground(Color.WHITE);
			btn_monthlysetting.setBounds(20, 170, 80, 80);
			btn_monthlysetting.setBorder(thickBorder);
			btn_monthlysetting.setBackground(Color.decode("#250800"));
			btn_monthlysetting.setForeground(Color.WHITE);
			btn_yearlysetting.setBounds(20, 280, 80, 80);
			btn_yearlysetting.setBorder(thickBorder);
			btn_yearlysetting.setBackground(Color.decode("#250800"));
			btn_yearlysetting.setForeground(Color.WHITE);
			btn_home.addActionListener(this);
			btn_monthlysetting.addActionListener(this);
			btn_yearlysetting.addActionListener(this);
			pan.add(btn_home);
			pan.add(btn_monthlysetting);
			pan.add(btn_yearlysetting);
			btn_add.setBounds(600, 544, 80, 20);
			btn_update.setBounds(690, 544, 80, 20);
			btn_delete.setBounds(790, 544, 80, 20);
			btn_clear.setBounds(890, 544, 80, 20);
			btn_report.setBounds(990, 544, 80, 20);

			btn_add.addActionListener(this);
			btn_update.addActionListener(this);
			btn_delete.addActionListener(this);
			btn_clear.addActionListener(this);
			btn_report.addActionListener(this);

			txt_allid.setBounds(400, 15, 110, 25);

			btn_add_year.setBounds(600, 544, 80, 20);
			btn_update_year.setBounds(690, 544, 80, 20);
			btn_delete_year.setBounds(790, 544, 80, 20);
			btn_clear_year.setBounds(890, 544, 80, 20);
			btn_report_year.setBounds(990, 544, 80, 20);

			btn_delete_year.addActionListener(this);
			btn_update_year.addActionListener(this);
			btn_report_year.addActionListener(this);
			btn_clear_year.addActionListener(this);

			lbl_id.setBounds(590, 15, 140, 25);

			emb_employeename.setBounds(690, 15, 140, 25);
			emb_employeename.addActionListener(this);

			String fill_date = (String) emb_employeename.getSelectedItem();
			fill_form(fill_date);

			retrive_customer(emb_employeename);

			date.setBounds(1140, 15, 160, 25);
			lbl_date.setBounds(1080, 10, 100, 30);
			btn_searchmonth.setBounds(840, 264, 80, 25);
			txt_monthserch.setBounds(700, 264, 130, 25);
			btn_search_year.setBounds(840, 264, 80, 25);
			txt_yearserch.setBounds(700, 264, 130, 25);

			// txt_yearserch.addKeyListener(this);///
			// dddddddddddddddddddddddddddddd

			btn_searchmonth.addActionListener(this);
			btn_search_year.addActionListener(this);
			pane_table.setBounds(30, 250, 1070, 200);// panel tabel
			pane_table.setLayout(new GridLayout());
			pane_table.setBackground(Color.red);
			tbl_month
					.setModel(
							new javax.swing.table.DefaultTableModel(new Object[][] {},
									new String[] { "MonthId", "EmployeeId", "EmployeeName", "EmployeeType", "Present",
											"Absant", "Sick", "Late", "Holiday", "Others", "Year", "CreateDate",
											"Date" }));
			tbl_month.addMouseListener(this);
			pane_month.setViewportView(tbl_month);
			pane_table.add(pane_month);
			pane_table_year.setBounds(30, 250, 1070, 200);// panel tabel
			pane_table_year.setLayout(new GridLayout());
			pane_table_year.setBackground(Color.red);
			tbl_month_year
					.setModel(
							new javax.swing.table.DefaultTableModel(new Object[][] {},
									new String[] { "YearId", "EmployeeId", "EmployeeName", "EmployeeType", "Present",
											"Absant", "Sick", "Late", "Holiday", "Others", "Year", "CreateDate",
											"Date" }));
			Action action = new Action();
			tbl_month_year.addMouseListener(action);
			scroll_year.setViewportView(tbl_month_year);
			pane_table_year.add(scroll_year);
			TitledBorder add_combo = BorderFactory.createTitledBorder("");
			add_combo.setTitleJustification(TitledBorder.LEFT);
			pane_uppermonth.setBounds(30, 30, 1070, 170);
			pane_uppermonth.setBackground(Color.WHITE);
			pane_uppermonth.setLayout(null);
			pane_uppermonth.setBorder(add_combo);
			pane_uppermonth_year.setBounds(30, 30, 1070, 170);
			pane_uppermonth_year.setBackground(Color.WHITE);
			pane_uppermonth_year.setLayout(null);
			pane_uppermonth_year.setBorder(add_combo);
			JLabel lbl_present = new JLabel("Total Present");
			JLabel lbl_absant = new JLabel("Total Absant");
			JLabel lbl_sick = new JLabel("Total Sick");
			JLabel lbl_late = new JLabel("Total Late");
			JLabel lbl_holiday = new JLabel("Total Holiday");
			JLabel lbl_others = new JLabel("Total Others");
			JLabel lbl_year = new JLabel("Enter Year");
			JLabel lbl_employeetype = new JLabel("Employee Type");
			JLabel lbl_employeename = new JLabel("Employee  Name");

			lbl_present.setBounds(20, 20, 100, 30);
			lbl_absant.setBounds(20, 70, 100, 30);
			lbl_sick.setBounds(20, 120, 100, 30);
			lbl_late.setBounds(310, 20, 100, 30);
			lbl_holiday.setBounds(310, 70, 100, 30);
			lbl_others.setBounds(310, 120, 100, 30);
			lbl_year.setBounds(600, 20, 100, 30);
			lbl_employeetype.setBounds(600, 70, 100, 30);

			lbl_employeename.setBounds(600, 120, 100, 30);

			lbl_present1.setBounds(20, 20, 100, 30);
			lbl_absant1.setBounds(20, 70, 100, 30);
			lbl_sick1.setBounds(20, 120, 100, 30);
			lbl_late1.setBounds(310, 20, 100, 30);
			lbl_holiday1.setBounds(310, 70, 100, 30);
			lbl_others1.setBounds(310, 120, 100, 30);
			lbl_year1.setBounds(600, 20, 100, 30);
			lbl_yearemployeetype.setBounds(600, 70, 100, 30);
			lbl_employeename1.setBounds(600, 120, 100, 30);
			btn_query.setBounds(940, 20, 80, 25);

			btn_query.addActionListener(this);
			btn_query_year.addActionListener(this);

			txt_year.setBounds(700, 20, 180, 30);
			txt_yearstatus.setBounds(700, 70, 180, 30);

			txt_employeename.setBounds(700, 120, 180, 30);
			txt_employeename_year.setBounds(700, 120, 180, 30);

			txt_present.setBounds(110, 20, 180, 30);
			txt_absant.setBounds(110, 70, 180, 30);
			txt_sick.setBounds(110, 120, 180, 30);
			txt_late.setBounds(400, 20, 180, 30);
			txt_holiday.setBounds(400, 70, 180, 30);
			txt_others.setBounds(400, 120, 180, 30);
			btn_query_year.setBounds(940, 20, 80, 25);
			txt_year_year.setBounds(700, 20, 180, 30);
			txt_yearstatus_year.setBounds(700, 70, 180, 30);
			txt_present_year.setBounds(110, 20, 180, 30);
			txt_absant_year.setBounds(110, 70, 180, 30);
			txt_sick_year.setBounds(110, 120, 180, 30);
			txt_late_year.setBounds(400, 20, 180, 30);
			txt_holiday_year.setBounds(400, 70, 180, 30);
			txt_others_year.setBounds(400, 120, 180, 30);
			pane_uppermonth.add(btn_query);
			pane_uppermonth.add(txt_year);
			pane_uppermonth.add(txt_yearstatus);
			pane_uppermonth.add(txt_employeename);

			pane_uppermonth.add(lbl_year);
			pane_uppermonth.add(lbl_employeetype);
			pane_uppermonth.add(lbl_employeename);
			pane_uppermonth.add(lbl_present);
			pane_uppermonth.add(lbl_absant);
			pane_uppermonth.add(lbl_sick);
			pane_uppermonth.add(lbl_late);
			pane_uppermonth.add(lbl_holiday);
			pane_uppermonth.add(lbl_others);
			pane_uppermonth.add(txt_present);
			pane_uppermonth.add(txt_absant);
			pane_uppermonth.add(txt_sick);
			pane_uppermonth.add(txt_late);
			pane_uppermonth.add(txt_holiday);
			pane_uppermonth.add(txt_others);

			pane_uppermonth_year.add(lbl_employeename1);
			pane_uppermonth_year.add(btn_query_year);
			pane_uppermonth_year.add(txt_year_year);
			pane_uppermonth_year.add(txt_yearstatus_year);
			pane_uppermonth_year.add(txt_employeename_year);

			pane_uppermonth_year.add(lbl_year1);
			pane_uppermonth_year.add(lbl_yearemployeetype);
			pane_uppermonth_year.add(lbl_present1);
			pane_uppermonth_year.add(lbl_absant1);
			pane_uppermonth_year.add(lbl_sick1);
			pane_uppermonth_year.add(lbl_late1);
			pane_uppermonth_year.add(lbl_holiday1);
			pane_uppermonth_year.add(lbl_others1);
			pane_uppermonth_year.add(txt_present_year);
			pane_uppermonth_year.add(txt_absant_year);
			pane_uppermonth_year.add(txt_sick_year);
			pane_uppermonth_year.add(txt_late_year);
			pane_uppermonth_year.add(txt_holiday_year);
			pane_uppermonth_year.add(txt_others_year);
			pan_container.add(pane_uppermonth_year);
			pan_container.add(pane_uppermonth);
			pan_container.add(pane_table);
			pan_container.add(pane_table_year);
			this.add(txt_allid);
			this.add(btn_searchmonth);
			this.add(txt_monthserch);
			this.add(btn_search_year);
			this.add(txt_yearserch);
			this.add(lbl_id);
			this.add(emb_employeename);
			this.add(lbl_date);
			this.add(date);
			this.add(btn_add);
			this.add(btn_update);
			this.add(btn_delete);
			this.add(btn_clear);
			this.add(btn_report);
			this.add(btn_add_year);
			this.add(btn_update_year);
			this.add(btn_delete_year);
			this.add(btn_clear_year);
			this.add(btn_report_year);
			this.add(pan_container);
			this.add(pan);
			Month();
			Show_yearattendancemode();
			Show_productreceivemod();
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

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source.equals(btn_add)) {
			add_monthly();
		} else if (source.equals(btn_clear)) {
			reset();
		} else if (source.equals(btn_delete)) {
			delete_monthly();

		} else if (source.equals(btn_update)) {
			update_monthly();

		} else if (source.equals(btn_report)) {

		} else if (source.equals(btn_home)) {
			this.setVisible(false);
			dispose();

		} else if (source.equals(btn_monthlysetting)) {
			Month();

		} else if (source.equals(btn_yearlysetting)) {
			Year();
		} else if (source.equals(btn_query)) {
			retrive_allattendance();

		} else if (source.equals(btn_query_year)) {
			retrive_allattendance_year();

		} else if (source.equals(emb_employeename)) {
			String fill_date = (String) emb_employeename.getSelectedItem();
			fill_form(fill_date);

		} else if (source.equals(btn_add_year)) {

			add_Yearly();

		} else if (source.equals(btn_delete_year)) {
			delete_yearly();
		} else if (source.equals(btn_update_year)) {
			update_yearly();
		} else if (source.equals(btn_report_year)) {
		} else if (source.equals(btn_clear_year)) {
			rest_year();

		} else if (source.equals(btn_searchmonth)) {
			find_customerorder1();
		} else if (source.equals(btn_search_year)) {
			find_yearattendance();

		}

	}

	public void add_monthly() {
		try {
			record += 1;
			str1 = "" + record;
			str2 = emb_employeename.getSelectedItem().toString();
			str3 = txt_employeename.getText().toString();
			str4 = txt_yearstatus.getText().toString();
			str5 = txt_present.getText().toString();
			str6 = txt_absant.getText().toString();
			str7 = txt_sick.getText().toString();
			str8 = txt_late.getText().toString();
			str9 = txt_holiday.getText().toString();
			str10 = txt_others.getText().toString();
			str11 = txt_year.getText().toString();
			str12 = sDate;
			str13 = date.getText().toString();

			if (!str2.equals("") || !str3.equals("") || !str4.equals("") || !str5.equals("") || !str6.equals("")
					|| !str7.equals("") || !str8.equals("") || !str9.equals("") || !str10.equals("")
					|| !str11.equals("") || !str12.equals("") || !str13.equals("")) {

				Statement stmt = conn.createStatement();
				String query = "SELECT * FROM  attendance_monthly WHERE employee_name='" + str3 + "'" + "AND date ='"
						+ str13 + "'";
				ResultSet rs = stmt.executeQuery(query);
				int foundrec = 0;
				while (rs.next()) {
					String dialogmessage = "Record Already Exists in DataBase!!!";
					int dialogtype = JOptionPane.WARNING_MESSAGE;
					JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);
					foundrec = 1;

				}
				if (foundrec == 0) {
					String temp = "INSERT INTO attendance_monthly(employee_id,employee_name,employee_type,total_present,total_absant,total_sick,total_late,total_holiday,total_other,year,time,date) VALUES ('"
							+ str2 + "','" + str3 + "','" + str4 + "','" + str5 + "','" + str6 + "','" + str7 + "','"
							+ str8 + "','" + str9 + "','" + str10 + "','" + str11 + "','" + str12 + "','" + str13
							+ "')";

					// String querey = "INSERT INTO
					// attendance_monthly(employee_id,employee_name,employee_type,total_present,total_absant,total_sick,total_late,total_holiday,total_other,year,time,date)
					// VALUES ('" + str2 + "','" + str3 + "','"
					// + str4 + "','" + str5 + "','" + str6 + "','" + str7 +
					// "','" + str8 + "','" + str9 + "','"
					// + str10 + "','" + str11 + "','" + str12 + "','" + str13 +
					// "','" + str14 + "')";
					//
					//

					int result = stmt.executeUpdate(temp);
					if (result == 1) {
						DefaultTableModel model = (DefaultTableModel) tbl_month.getModel();
						model.setRowCount(0);
						Show_productreceivemod();
						reset();
						String dialogmessage = "New Position Added";
						int dialogtype = JOptionPane.INFORMATION_MESSAGE;
						JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);

					} else {

						String dialogmessage = "Failed To Insert";
						JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!", JOptionPane.WARNING_MESSAGE);

					}
				}

				else {
					String dialogmessage = "EMPTY VALUE FOUND";
					JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!", JOptionPane.WARNING_MESSAGE);

				}
			}

			conn.close();
		} catch (Exception ex) {
			System.out.println("Unknown Error" + ex);

		}

	}

	public void update_monthly() {
		str1 = txt_allid.getText().trim();
		str2 = emb_employeename.getSelectedItem().toString();
		str3 = txt_employeename.getText().toString();
		str4 = txt_yearstatus.getText().toString();
		str5 = txt_present.getText().toString();
		str6 = txt_absant.getText().toString();
		str7 = txt_sick.getText().toString();
		str8 = txt_late.getText().toString();
		str9 = txt_holiday.getText().toString();
		str10 = txt_others.getText().toString();
		str11 = txt_year.getText().toString();
		str12 = sDate;
		str13 = date.getText().toString();

		if (!str1.equals("") || !str2.equals("") || !str3.equals("") || !str4.equals("") || !str5.equals("")
				|| !str6.equals("") || !str7.equals("") || !str8.equals("") || !str9.equals("") || !str10.equals("")
				|| !str11.equals("") || !str12.equals("") || !str13.equals("")) {

			String temp = "UPDATE attendance_monthly SET " + "month_id = '" + str1 + "',employee_name = '" + str3
					+ "',employee_type = '" + str4 + "',total_present = '" + str5 + "',total_absant = '" + str6
					+ "',total_sick = '" + str7 + "',total_late = '" + str8 + "',total_holiday = '" + str9
					+ "',total_other = '" + str10 + "',year = '" + str11 + "',time = '" + str12 + "',date = '" + str13
					+ "'" + "WHERE month_id = '" + str1 + "'";
			executeSQlQuery_customerOrder(temp, "Updated");

		} else {
			JOptionPane.showMessageDialog(null, "Some Information is missing");
		}

	}

	public void rest_year() {
		txt_present_year.setText("");
		txt_absant_year.setText("");
		txt_sick_year.setText("");
		txt_late_year.setText("");
		txt_holiday_year.setText("");
		txt_others_year.setText("");
		txt_year_year.setText("");
		txt_yearstatus_year.setText("");
		txt_employeename_year.setText("");

	}

	public void update_yearly() {
		str1 = txt_allid.getText().trim();
		str2 = emb_employeename.getSelectedItem().toString();
		str3 = txt_employeename_year.getText().toString();
		str4 = txt_yearstatus_year.getText().toString();
		str5 = txt_present_year.getText().toString();
		str6 = txt_absant_year.getText().toString();
		str7 = txt_sick_year.getText().toString();
		str8 = txt_late_year.getText().toString();
		str9 = txt_holiday_year.getText().toString();
		str10 = txt_others_year.getText().toString();
		str11 = txt_year_year.getText().toString();
		str12 = sDate;
		str13 = date.getText().toString();
		if (!str1.equals("") || !str2.equals("") || !str3.equals("") || !str4.equals("") || !str5.equals("")
				|| !str6.equals("") || !str7.equals("") || !str8.equals("") || !str9.equals("") || !str10.equals("")
				|| !str11.equals("") || !str12.equals("") || !str13.equals("")) {

			String temp = "UPDATE attendance_yearly SET " + "year_id = '" + str1 + "',employee_name = '" + str3
					+ "',employee_type = '" + str4 + "',total_present = '" + str5 + "',total_absant = '" + str6
					+ "',total_sick = '" + str7 + "',total_late = '" + str8 + "',total_holiday = '" + str9
					+ "',total_others = '" + str10 + "',year = '" + str11 + "',time = '" + str12 + "',date = '" + str13
					+ "'" + "WHERE year_id = '" + str1 + "'";
			executeSQlQuery_customerOrder(temp, "Updated");

		} else {
			JOptionPane.showMessageDialog(null, "Some Information is missing");
		}
	}

	public void delete_monthly() {
		str1 = "";
		str1 = txt_allid.getText().trim();
		if (str1.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Select Table Row!!!");
		} else {
			String query = "DELETE FROM `attendance_monthly` WHERE month_id = " + str1;
			executeSQlQuery_customerOrder(query, "Deleted Record!!");
		}

	}

	public void delete_yearly() {
		str1 = "";
		str1 = txt_allid.getText().trim();
		if (str1.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Select Table Row!!!");
		} else {
			String query = "DELETE FROM `attendance_yearly` WHERE year_id = " + str1;
			executeSQlQuery_customerOrder(query, "Deleted Record!!");
		}

	}

	public void add_Yearly() {
		try {
			recore5 += 1;
			str1 = "" + recore5;
			str2 = emb_employeename.getSelectedItem().toString();
			str3 = txt_employeename_year.getText().toString();
			str4 = txt_yearstatus_year.getText().toString();
			str5 = txt_present_year.getText().toString();
			str6 = txt_absant_year.getText().toString();
			str7 = txt_sick_year.getText().toString();
			str8 = txt_late_year.getText().toString();
			str9 = txt_holiday_year.getText().toString();
			str10 = txt_others_year.getText().toString();
			str11 = txt_year_year.getText().toString();
			str12 = sDate;
			str13 = date.getText().toString();

			if (!str2.equals("") || !str3.equals("") || !str4.equals("") || !str5.equals("") || !str6.equals("")
					|| !str7.equals("") || !str8.equals("") || !str9.equals("") || !str10.equals("")
					|| !str11.equals("") || !str12.equals("") || !str13.equals("")) {

				Statement stmt = conn.createStatement();
				String query = "SELECT * FROM  attendance_yearly WHERE employee_name='" + str3 + "'" + "AND year ='"
						+ str11 + "'";
				ResultSet rs = stmt.executeQuery(query);
				int foundrec = 0;
				while (rs.next()) {
					String dialogmessage = "Record Already Exists in DataBase!!!";
					int dialogtype = JOptionPane.WARNING_MESSAGE;
					JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);
					foundrec = 1;

				}
				if (foundrec == 0) {
					
					String temp = "INSERT INTO attendance_yearly(employee_id,employee_name,employee_type,total_present,total_absant,total_sick,total_late,total_holiday,total_others,year,time,date) VALUES ('"
							+ str2 + "','" + str3 + "','" + str4 + "','" + str5 + "','" + str6 + "','" + str7 + "','"
							+ str8 + "','" + str9 + "','" + str10 + "','" + str11 + "','" + str12 + "','" + str13
							+ "')";

					// String temp = "INSERT INTO
					// attendance_yearly(employee_id,employee_name,employee_type,total_present,total_absant,total_sick,total_late,total_holiday,total_others,year,time,date)
					// VALUES ('"
					// + str2 + "','" + str3 + "','" + str4 + "','" + str5 +
					// "','" + str6 + "','" + str7 + "','"
					// + str8 + "','" + str9 + "','" + str10 + "','" + str11 +
					// "','" + str12 + "','" + str13
					// + "')";
					//
					int result = stmt.executeUpdate(temp);
					if (result == 1) {
						DefaultTableModel model1 = (DefaultTableModel) tbl_month_year.getModel();
						model1.setRowCount(0);
						Show_yearattendancemode();
						reset();
						rest_year();
						String dialogmessage = "New Position Added";
						int dialogtype = JOptionPane.INFORMATION_MESSAGE;
						JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);

					} else {

						String dialogmessage = "Failed To Insert";
						JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!", JOptionPane.WARNING_MESSAGE);

					}
				}

				else {
					String dialogmessage = "EMPTY VALUE FOUND";
					JOptionPane.showMessageDialog(null, dialogmessage, "WARNING!!", JOptionPane.WARNING_MESSAGE);

				}
			}

			conn.close();
		} catch (Exception ex) {
			System.out.println("Unknown Error" + ex);

		}

	}

	public void retrive_allattendance() {
		String first = JOptionPane.showInputDialog(null, "Please Enter Name");
		String second = JOptionPane.showInputDialog(null, "Please Enter Status");
		if (first.equals("") || second.equals("")) {
			JOptionPane.showMessageDialog(null, "Information Missing");

		} else {

			try {
				query1 = first;
				query2 = second;

				conn = connect.setConnection(conn);
				Statement stmt = conn.createStatement();
				String sql = "SELECT sum(present) FROM  attandenceinternallabour WHERE name='" + query1 + "'"
						+ "AND yearmonthstatus ='" + query2 + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String count = rs.getString("sum(present)");
					txt_present.setText(count);

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString());

			}
			// ++++++++++++++++++++++++

			try {
				query3 = first;
				query4 = second;

				conn = connect.setConnection(conn);
				Statement stmt = conn.createStatement();
				String sql = "SELECT sum(absant) FROM  attandenceinternallabour WHERE name='" + query3 + "'"
						+ "AND yearmonthstatus ='" + query4 + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String count = rs.getString("sum(absant)");
					txt_absant.setText(count);

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString());

			}
			// +++++++++++++
			try {
				query5 = first;
				query6 = second;

				conn = connect.setConnection(conn);
				Statement stmt = conn.createStatement();
				String sql = "SELECT sum(late) FROM  attandenceinternallabour WHERE name='" + query5 + "'"
						+ "AND yearmonthstatus ='" + query6 + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String count = rs.getString("sum(late)");
					txt_late.setText(count);

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString());

			}

			try {
				query7 = first;
				query8 = second;
				conn = connect.setConnection(conn);
				Statement stmt = conn.createStatement();
				String sql = "SELECT sum(holiday) FROM  attandenceinternallabour WHERE name='" + query7 + "'"
						+ "AND yearmonthstatus ='" + query8 + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String count = rs.getString("sum(holiday)");
					txt_holiday.setText(count);

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString());

			}

			try {
				query9 = first;
				query10 = second;
				conn = connect.setConnection(conn);
				Statement stmt = conn.createStatement();
				String sql = "SELECT sum(sick) FROM  attandenceinternallabour WHERE name='" + query9 + "'"
						+ "AND yearmonthstatus ='" + query10 + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String count = rs.getString("sum(sick)");
					txt_sick.setText(count);

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString());

			}

			try {
				query11 = first;
				query12 = second;
				conn = connect.setConnection(conn);
				Statement stmt = conn.createStatement();
				String sql = "SELECT sum(others) FROM  attandenceinternallabour WHERE name='" + query11 + "'"
						+ "AND yearmonthstatus ='" + query12 + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String count = rs.getString("sum(others)");
					txt_others.setText(count);

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString());

			}
		}

	}

	public void retrive_allattendance_year() {
		String first = JOptionPane.showInputDialog(null, "Please Enter Name");
		String second = JOptionPane.showInputDialog(null, "Please Enter Year");
		if (first.equals("") || second.equals("")) {
			JOptionPane.showMessageDialog(null, "Information Missing");

		} else {

			try {
				query1 = first;
				query2 = second;
				conn = connect.setConnection(conn);
				Statement stmt = conn.createStatement();
				String sql = "SELECT sum(total_present) FROM  attendance_monthly WHERE employee_name='" + query1 + "'"
						+ "AND year ='" + query2 + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String count = rs.getString("sum(total_present)");
					txt_present_year.setText(count);
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString());

			}
			// ++++++++++++++++++++++++

			try {
				query3 = first;
				query4 = second;

				conn = connect.setConnection(conn);
				Statement stmt = conn.createStatement();
				String sql = "SELECT sum(total_absant) FROM  attendance_monthly WHERE employee_name='" + query3 + "'"
						+ "AND year ='" + query4 + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String count = rs.getString("sum(total_absant)");
					txt_absant_year.setText(count);

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString());

			}
			// +++++++++++++
			try {
				query5 = first;
				query6 = second;

				conn = connect.setConnection(conn);
				Statement stmt = conn.createStatement();
				String sql = "SELECT sum(total_late) FROM  attendance_monthly WHERE employee_name='" + query5 + "'"
						+ "AND year ='" + query6 + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String count = rs.getString("sum(total_late)");
					txt_late_year.setText(count);

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString());

			}

			try {
				query7 = first;
				query8 = second;
				conn = connect.setConnection(conn);
				Statement stmt = conn.createStatement();
				String sql = "SELECT sum(total_holiday) FROM  attendance_monthly WHERE employee_name='" + query7 + "'"
						+ "AND year ='" + query8 + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String count = rs.getString("sum(total_holiday)");
					txt_holiday_year.setText(count);

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString());

			}

			try {
				query9 = first;
				query10 = second;
				conn = connect.setConnection(conn);
				Statement stmt = conn.createStatement();
				String sql = "SELECT sum(total_sick) FROM  attendance_monthly WHERE employee_name='" + query9 + "'"
						+ "AND year ='" + query10 + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String count = rs.getString("sum(total_sick)");
					txt_sick_year.setText(count);

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString());

			}

			try {
				query11 = first;
				query12 = second;
				conn = connect.setConnection(conn);
				Statement stmt = conn.createStatement();
				String sql = "SELECT sum(total_other) FROM  attendance_monthly WHERE employee_name='" + query11 + "'"
						+ "AND year ='" + query12 + "'";

				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String count = rs.getString("sum(total_other)");
					txt_others_year.setText(count);

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString());

			}
		}

	}

	public void retrive_customer(JComboBox<String> cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {
			Statement stmt = conn.createStatement();// emp_designation
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
				String firstname = rs.getString(2).trim();
				String employeetype = rs.getString(4).trim();
				txt_yearstatus.setText(employeetype);
				txt_employeename.setText(firstname);
				txt_yearstatus_year.setText(employeetype);
				txt_employeename_year.setText(firstname);

				rs = null;

			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void Month() {
		pane_table.setVisible(true);
		pane_uppermonth.setVisible(true);
		btn_add.setVisible(true);
		btn_update.setVisible(true);
		btn_delete.setVisible(true);
		btn_clear.setVisible(true);
		btn_report.setVisible(true);
		txt_monthserch.setVisible(true);
		btn_searchmonth.setVisible(true);
		// year
		btn_add_year.setVisible(false);
		btn_update_year.setVisible(false);
		btn_delete_year.setVisible(false);
		btn_clear_year.setVisible(false);
		btn_report_year.setVisible(false);
		btn_search_year.setVisible(false);
		txt_yearserch.setVisible(false);
		pane_table_year.setVisible(false);
		pane_uppermonth_year.setVisible(false);
		btn_add_year.addActionListener(this);

		// year

	}

	public void Year() {
		pane_table.setVisible(false);
		pane_uppermonth.setVisible(false);
		btn_add.setVisible(false);
		btn_update.setVisible(false);
		btn_delete.setVisible(false);
		btn_clear.setVisible(false);
		btn_report.setVisible(false);
		txt_monthserch.setVisible(false);
		btn_searchmonth.setVisible(false);

		// year

		btn_add_year.setVisible(true);
		btn_update_year.setVisible(true);
		btn_delete_year.setVisible(true);
		btn_clear_year.setVisible(true);
		btn_report_year.setVisible(true);
		btn_search_year.setVisible(true);
		txt_yearserch.setVisible(true);
		pane_table_year.setVisible(true);
		pane_uppermonth_year.setVisible(true);

		// year

	}

	public void reset() {
		txt_present.setText("");
		txt_absant.setText("");
		txt_sick.setText("");
		txt_late.setText("");
		txt_holiday.setText("");
		txt_others.setText("");
		txt_year.setText("");
		txt_yearstatus.setText("");
		txt_employeename.setText("");
		txt_employeename_year.setText("");
		txt_monthserch.setText("");
		date.setText("");
		txt_allid.setText("");

	}

	public void executeSQlQuery_customerOrder(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {
				reset();
				rest_year();
				DefaultTableModel model = (DefaultTableModel) tbl_month.getModel();
				DefaultTableModel model1 = (DefaultTableModel) tbl_month_year.getModel();
				model1.setRowCount(0);
				model.setRowCount(0);
				Show_productreceivemod();
				Show_yearattendancemode();
				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<AttendanceMontlyInfo> receiveorderinfo() {
		ArrayList<AttendanceMontlyInfo> usersList = new ArrayList<AttendanceMontlyInfo>();
		Connection connection = getConnection();
		String query = "SELECT * FROM  `attendance_monthly`";
		Statement st;
		ResultSet rs;
		// private JTable tbl_viewemp = new JTable();
		// private JTable tbl_viewsupplier = new JTable();
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			AttendanceMontlyInfo user;
			while (rs.next()) {
				user = new AttendanceMontlyInfo(rs.getInt("month_id"), rs.getInt("employee_id"),
						rs.getString("employee_name"), rs.getString("employee_type"), rs.getInt("total_present"),
						rs.getInt("total_absant"), rs.getInt("total_sick"), rs.getInt("total_late"),
						rs.getInt("total_holiday"), rs.getInt("total_other"), rs.getString("year"),
						rs.getString("time"), rs.getString("date"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	// Display Data In JTable

	public void Show_productreceivemod() {
		ArrayList<AttendanceMontlyInfo> list = receiveorderinfo();
		DefaultTableModel model = (DefaultTableModel) tbl_month.getModel();
		Object[] row = new Object[13];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getMonthid();
			row[1] = list.get(i).getEmployeeid();
			row[2] = list.get(i).getEmployeename();
			row[3] = list.get(i).getEmployeetype();
			row[4] = list.get(i).getPresent();
			row[5] = list.get(i).getAbsant();
			row[6] = list.get(i).getSick();
			row[7] = list.get(i).getLate();
			row[8] = list.get(i).getHoliday();
			row[9] = list.get(i).getOthers();
			row[10] = list.get(i).getYear();
			row[11] = list.get(i).getCreatedatetime();
			row[12] = list.get(i).getDate();

			model.addRow(row);
		}
	}

	// ===============================

	public ArrayList<AttendanceMontlyInfo> List_wa_Order1(String search) {// warehouse
		// emp
		ArrayList<AttendanceMontlyInfo> usersList = new ArrayList<AttendanceMontlyInfo>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `attendance_monthly` WHERE CONCAT(`month_id`, `employee_id`, `employee_name`, `employee_type`,`total_present`,`total_absant`,`total_sick`,`total_late`,`total_holiday`,`total_other`,`year`,`time`,`date`) LIKE '%"
					+ search + "%'";
			rs = st.executeQuery(searchQuery);

			AttendanceMontlyInfo user;

			while (rs.next()) {
				user = new AttendanceMontlyInfo(rs.getInt("month_id"), rs.getInt("employee_id"),
						rs.getString("employee_name"), rs.getString("employee_type"), rs.getInt("total_present"),
						rs.getInt("total_absant"), rs.getInt("total_sick"), rs.getInt("total_late"),
						rs.getInt("total_holiday"), rs.getInt("total_other"), rs.getString("year"),
						rs.getString("time"), rs.getString("date"));
				usersList.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	public void find_customerorder1() {
		ArrayList<AttendanceMontlyInfo> list = List_wa_Order1(txt_monthserch.getText());// asdjflasjdf;lja;lkdsfjl;k
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "MonthId", "EmployeeId", "EmployeeName", "EmployeeType", "Present",
				"Absant", "Sick", "Late", "Holiday", "Others", "Year", "CreateDate", "Date" });
		Object[] row = new Object[13];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getMonthid();
			row[1] = list.get(i).getEmployeeid();
			row[2] = list.get(i).getEmployeename();
			row[3] = list.get(i).getEmployeetype();
			row[4] = list.get(i).getPresent();
			row[5] = list.get(i).getAbsant();
			row[6] = list.get(i).getSick();
			row[7] = list.get(i).getLate();
			row[8] = list.get(i).getHoliday();
			row[9] = list.get(i).getOthers();
			row[10] = list.get(i).getYear();
			row[11] = list.get(i).getCreatedatetime();
			row[12] = list.get(i).getDate();

			model.addRow(row);
		}
		tbl_month.setModel(model);

	}

	// another for your self whar are you doing

	public ArrayList<AttendanceYearlyInfo> receiveorderinfo_year() {
		ArrayList<AttendanceYearlyInfo> usersList = new ArrayList<AttendanceYearlyInfo>();
		Connection connection = getConnection();
		String query = "SELECT * FROM  `attendance_yearly`";
		Statement st;
		ResultSet rs;
		// private JTable tbl_viewemp = new JTable();
		// private JTable tbl_viewsupplier = new JTable();
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			AttendanceYearlyInfo user;
			while (rs.next()) {
				user = new AttendanceYearlyInfo(rs.getInt("year_id"), rs.getInt("employee_id"),
						rs.getString("employee_name"), rs.getString("employee_type"), rs.getInt("total_present"),
						rs.getInt("total_absant"), rs.getInt("total_sick"), rs.getInt("total_late"),
						rs.getInt("total_holiday"), rs.getInt("total_others"), rs.getString("year"),
						rs.getString("time"), rs.getString("date"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	// Display Data In JTable

	public void Show_yearattendancemode() {
		ArrayList<AttendanceYearlyInfo> list = receiveorderinfo_year();
		DefaultTableModel model = (DefaultTableModel) tbl_month_year.getModel();
		Object[] row = new Object[13];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getYearid();
			row[1] = list.get(i).getEmployeeid();
			row[2] = list.get(i).getEmployeename();
			row[3] = list.get(i).getEmployeetype();
			row[4] = list.get(i).getPresent();
			row[5] = list.get(i).getAbsant();
			row[6] = list.get(i).getSick();
			row[7] = list.get(i).getLate();
			row[8] = list.get(i).getHoliday();
			row[9] = list.get(i).getOthers();
			row[10] = list.get(i).getYear();
			row[11] = list.get(i).getCreatedatetime();
			row[12] = list.get(i).getDate();

			model.addRow(row);
		}
	}

	// ===============================

	public ArrayList<AttendanceYearlyInfo> List_year(String search) {// warehouse
		// emp
		ArrayList<AttendanceYearlyInfo> usersList = new ArrayList<AttendanceYearlyInfo>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `attendance_yearly` WHERE CONCAT(`year_id`, `employee_id`, `employee_name`, `employee_type`,`total_present`,`total_absant`,`total_sick`,`total_late`,`total_holiday`,`total_others`,`year`,`time`,`date`) LIKE '%"
					+ search + "%'";
			rs = st.executeQuery(searchQuery);

			AttendanceYearlyInfo user;

			while (rs.next()) {
				user = new AttendanceYearlyInfo(rs.getInt("year_id"), rs.getInt("employee_id"),
						rs.getString("employee_name"), rs.getString("employee_type"), rs.getInt("total_present"),
						rs.getInt("total_absant"), rs.getInt("total_sick"), rs.getInt("total_late"),
						rs.getInt("total_holiday"), rs.getInt("total_others"), rs.getString("year"),
						rs.getString("time"), rs.getString("date"));
				usersList.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	public void find_yearattendance() {
		ArrayList<AttendanceYearlyInfo> list = List_year(txt_yearserch.getText());// asdjflasjdf;lja;lkdsfjl;k
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "YearId", "EmployeeId", "EmployeeName", "EmployeeType", "Present",
				"Absant", "Sick", "Late", "Holiday", "Others", "Year", "CreateDate", "Date" });
		Object[] row = new Object[13];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getYearid();
			row[1] = list.get(i).getEmployeeid();
			row[2] = list.get(i).getEmployeename();
			row[3] = list.get(i).getEmployeetype();
			row[4] = list.get(i).getPresent();
			row[5] = list.get(i).getAbsant();
			row[6] = list.get(i).getSick();
			row[7] = list.get(i).getLate();
			row[8] = list.get(i).getHoliday();
			row[9] = list.get(i).getOthers();
			row[10] = list.get(i).getYear();
			row[11] = list.get(i).getCreatedatetime();
			row[12] = list.get(i).getDate();

			model.addRow(row);
		}
		tbl_month_year.setModel(model);

	}

	@Override
	public void mouseClicked(MouseEvent event) {

		int i = tbl_month.getSelectedRow();
		TableModel model = tbl_month.getModel();
		txt_allid.setText(model.getValueAt(i, 0).toString());
		emb_employeename.setSelectedItem(model.getValueAt(i, 1).toString());
		txt_employeename.setText(model.getValueAt(i, 2).toString());
		txt_yearstatus.setText(model.getValueAt(i, 3).toString());
		txt_present.setText(model.getValueAt(i, 4).toString());
		txt_absant.setText(model.getValueAt(i, 5).toString());
		txt_sick.setText(model.getValueAt(i, 6).toString());
		txt_late.setText(model.getValueAt(i, 7).toString());
		txt_holiday.setText(model.getValueAt(i, 8).toString());
		txt_others.setText(model.getValueAt(i, 9).toString());
		txt_year.setText(model.getValueAt(i, 10).toString());
		date.setText(model.getValueAt(i, 12).toString());

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

	class Action implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {
			int i = tbl_month_year.getSelectedRow();
			TableModel model = tbl_month_year.getModel();
			txt_allid.setText(model.getValueAt(i, 0).toString());
			emb_employeename.setSelectedItem(model.getValueAt(i, 1).toString());
			txt_employeename_year.setText(model.getValueAt(i, 2).toString());
			txt_yearstatus_year.setText(model.getValueAt(i, 3).toString());
			txt_present_year.setText(model.getValueAt(i, 4).toString());
			txt_absant_year.setText(model.getValueAt(i, 5).toString());
			txt_sick_year.setText(model.getValueAt(i, 6).toString());
			txt_late_year.setText(model.getValueAt(i, 7).toString());
			txt_holiday_year.setText(model.getValueAt(i, 8).toString());
			txt_others_year.setText(model.getValueAt(i, 9).toString());
			txt_year_year.setText(model.getValueAt(i, 10).toString());
			date.setText(model.getValueAt(i, 12).toString());

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
