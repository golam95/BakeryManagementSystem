package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Controller.Databaseconnect;

public class MonthlyReport extends JInternalFrame implements ActionListener {
	JFrame JFParentFrame;
	JButton btn_createReportformonth = new JButton("Create Report");
	static Date td = new Date();
	static String sDate = DateFormat.getDateTimeInstance().format(td);
	private JTextField cmb_date = new JTextField(20);
	String month_code = "";
	JPanel pan_container = new JPanel();
	private String[] Month_Name = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	private JComboBox<String> cmb_month = new JComboBox<String>();
	
	private JTextField txt_year = new JTextField(20);
	private JTextField txt_DATE = new JTextField();
	private JTextField txt_monthlyslip = new JTextField(20);
	
	
	JTextField txt_numberofcustomer = new JTextField();
	JTextField txt_numofitem = new JTextField();
	JTextField txt_stockitem = new JTextField();
	JTextField txt_numberofvan = new JTextField();
	JTextField txt_contactbakery = new JTextField();
	JTextField txt_numservice = new JTextField();
	JTextField txt_numofemp = new JTextField();
	 
	JTextField txt_totalcostservice = new JTextField();
	JTextField txt_tatalcostsallaryemp = new JTextField();
	
	JTextField txt_1 = new JTextField();
	JTextField txt_2 = new JTextField();
	JTextField txt_3 = new JTextField();
	JTextField txt_4 = new JTextField();
	JTextField txt_5 = new JTextField();
	JTextField txt_6 = new JTextField();
	JTextField txt_7 = new JTextField();
	JTextField txt_8 = new JTextField();
	
	
	
	
	private JButton btn_createReport = new JButton("Create Report");
	private JButton btn_exit = new JButton("Exit");
	private JButton btn_preview = new JButton("Preview");
	private JButton btn_pdf = new JButton("PDF");
	private JButton btn_clear = new JButton("Clear");
	Connection conn;
	Databaseconnect connect = new Databaseconnect();
	String str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17,
			str18;

	public MonthlyReport(JFrame getParentFrame) {
		super("Monthly Report", true, true, true, true);
		this.setSize(400, 500);
		this.setLayout(null);
		JPanel pan1 = new JPanel();
		JPanel pane_genteratereport = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan4 = new JPanel();
		JPanel pan5 = new JPanel();
		JPanel pan6 = new JPanel();
		JPanel pan7 = new JPanel();
		JPanel pan8 = new JPanel();
		JPanel pan_right = new JPanel();
		JLabel lbl_date = new JLabel("Enter Date :");
		JLabel lbl_month = new JLabel("Month :");
		JLabel lbl_year = new JLabel("Year :");
		JLabel lbl_para = new JLabel("#########  GOLAM BAKERY MONTHLY REPORT #########");
		JLabel lbl_report = new JLabel("######  R  E  P  O  R  T  ######");
		JLabel lbl_DATE = new JLabel("Date :");

		JLabel lbl_numberofcustomer = new JLabel("Number Of Customer");
		JLabel lbl_numofitem = new JLabel("Number Of Item");
		JLabel lbl_stockitem = new JLabel("Number of StockItem :");
		JLabel lbl_numberofvan = new JLabel("Number of Van :");
		JLabel lbl_contactbakery = new JLabel("Number of Contact Bakery :");
		JLabel lbl_numservice = new JLabel("Number of Service Provider :");
		JLabel lbl_numofemp = new JLabel("Number of Employee :");
		JLabel lbl_totalcostservice = new JLabel("Total sallary(service.p)permonth :");
		JLabel lbl_costsallaryemp = new JLabel("Total sallary(Emp)permonth :");

		JLabel lbl_1 = new JLabel("Total cost Warehouse :");
		JLabel lbl_2 = new JLabel("Number Of Order :");
		JLabel lbl_3 = new JLabel("Total Order Cost :");
		JLabel lbl_4 = new JLabel("Order From Other's Bakery :");
		JLabel lbl_5 = new JLabel("Order From Here :");
		JLabel lbl_6 = new JLabel("Total Cost Other's Bakery :");
		JLabel lbl_7 = new JLabel("Total Cost Order Here :");
		JLabel lbl_8 = new JLabel("Month :");

		pan1.setLayout(new FlowLayout());
		pan1.setBounds(5, 10, 1240, 30);
		// pan1.setBackground(Color.green);
		pan1.add(lbl_date);
		pan1.add(cmb_date);
		cmb_date.addActionListener(this);
		pan2.setLayout(new FlowLayout());
		Border thickBorder = new LineBorder(Color.decode("#394B58"), 5);
		pan2.setBounds(5, 100, 1240, 30);

		// need another frame

		pane_genteratereport.setLayout(new FlowLayout());
		pane_genteratereport.setBounds(5, 50, 1240, 30);
		pane_genteratereport.setBackground(Color.WHITE);
		pane_genteratereport.add(btn_createReportformonth);
		btn_createReportformonth.addActionListener(this);
		pan4.setBounds(5, 140, 1240, 30);
		pan5.setBounds(80, 180, 940, 50);
		pan6.setBounds(5, 240, 1240, 30);
		pan7.setBounds(80, 280, 500, 180);
		pan_right.setBounds(670, 280, 500, 180);
		pan8.setBounds(5, 530, 1240, 30);
		pan_right.setLayout(new GridLayout(0, 2));
		pan2.add(lbl_month);
		for (int month = 0; month < Month_Name.length; month++) {
			cmb_month.addItem(Month_Name[month]);

		}

		pan2.add(cmb_month);
		pan2.add(lbl_year);
		pan2.add(txt_year);

		pan4.setLayout(new FlowLayout());
		pan4.add(lbl_para);
		pan5.setLayout(new GridLayout(0, 2));
		pan5.add(lbl_DATE);

		pan5.add(txt_DATE);
		JLabel lbl_monthlyslip = new JLabel("Monthly Slip");
		pan5.add(lbl_monthlyslip);
		pan5.add(txt_monthlyslip);
		pan6.setLayout(new FlowLayout());
		pan6.add(lbl_report);

		pan_right.add(lbl_1);
		pan_right.add(txt_1);
		pan_right.add(lbl_2);
		pan_right.add(txt_2);
		pan_right.add(lbl_3);
		pan_right.add(txt_3);
		pan_right.add(lbl_4);
		pan_right.add(txt_4);
		pan_right.add(lbl_5);
		pan_right.add(txt_5);
		pan_right.add(lbl_6);
		pan_right.add(txt_6);
		pan_right.add(lbl_7);
		pan_right.add(txt_7);
		pan_right.add(lbl_8);
		pan_right.add(txt_8);
		pan7.setLayout(new GridLayout(0, 2));

		pan7.add(lbl_numberofcustomer);
		pan7.add(txt_numberofcustomer);
		pan7.add(lbl_numofitem);
		pan7.add(txt_numofitem);
		pan7.add(lbl_stockitem);
		pan7.add(txt_stockitem);
		pan7.add(lbl_numberofvan);
		pan7.add(txt_numberofvan);
		pan7.add(lbl_contactbakery);
		pan7.add(txt_contactbakery);
		pan7.add(lbl_numservice);
		pan7.add(txt_numservice);
		pan7.add(lbl_numofemp);
		pan7.add(txt_numofemp);
		pan7.add(lbl_totalcostservice);
		pan7.add(txt_totalcostservice);
		pan7.add(lbl_costsallaryemp);
		pan7.add(txt_tatalcostsallaryemp);
		txt_1.setEditable(false);
		txt_2.setEditable(false);
		txt_3.setEditable(false);
		txt_4.setEditable(false);
		txt_5.setEditable(false);
		txt_6.setEditable(false);
		txt_7.setEditable(false);
		txt_8.setEditable(false);
		txt_monthlyslip.setEditable(false);
		txt_DATE.setEditable(false);
		txt_numberofcustomer.setEditable(false);
		txt_numofitem.setEditable(false);
		txt_stockitem.setEditable(false);
		txt_numberofvan.setEditable(false);
		txt_contactbakery.setEditable(false);
		txt_numservice.setEditable(false);
		txt_numofemp.setEditable(false);
		txt_totalcostservice.setEditable(false);
		txt_tatalcostsallaryemp.setEditable(false);
		txt_tatalcostsallaryemp.setBackground(Color.WHITE);
		pan1.setBackground(Color.WHITE);
		pan2.setBackground(Color.WHITE);
		pan4.setBackground(Color.WHITE);
		pan5.setBackground(Color.WHITE);
		pan6.setBackground(Color.WHITE);
		pan7.setBackground(Color.WHITE);
		pan_right.setBackground(Color.WHITE);
		btn_exit.setBackground(Color.orange);
		btn_preview.setBackground(Color.orange);
		btn_pdf.setBackground(Color.orange);
		txt_numberofcustomer.setBackground(Color.WHITE);
		txt_numofitem.setBackground(Color.WHITE);
		txt_stockitem.setBackground(Color.WHITE);
		txt_numberofvan.setBackground(Color.WHITE);
		txt_contactbakery.setBackground(Color.WHITE);
		txt_numservice.setBackground(Color.WHITE);
		txt_numofemp.setBackground(Color.WHITE);
		txt_totalcostservice.setBackground(Color.WHITE);
		txt_tatalcostsallaryemp.setBackground(Color.WHITE);
		txt_1.setBackground(Color.WHITE);
		txt_2.setBackground(Color.WHITE);
		txt_3.setBackground(Color.WHITE);
		txt_4.setBackground(Color.WHITE);
		txt_5.setBackground(Color.WHITE);
		txt_6.setBackground(Color.WHITE);
		txt_7.setBackground(Color.WHITE);
		txt_8.setBackground(Color.WHITE);
		cmb_date.setBackground(Color.WHITE);
		cmb_month.setBackground(Color.WHITE);
		txt_year.setBackground(Color.WHITE);
		txt_DATE.setBackground(Color.WHITE);
		txt_monthlyslip.setBackground(Color.WHITE);
		pan8.setLayout(new FlowLayout());
		pan8.add(btn_exit);
		pan8.add(btn_preview);
		pan8.add(btn_pdf);
		pan8.add(btn_clear);
		btn_clear.addActionListener(this);
		btn_exit.addActionListener(this);
		btn_pdf.addActionListener(this);
		btn_preview.addActionListener(this);
		pan_container.setBounds(50, 50, 1260, 480);
		pan_container.setLayout(null);
		pan_container.add(pan1);
		pan_container.add(pan2);
		pan_container.add(pane_genteratereport);
		pan_container.add(pan4);
		pan_container.add(pan5);
		pan_container.add(pan6);
		pan_container.add(pan7);
		pan_container.add(pan8);
		pan_container.add(pan_right);
		pan_container.setBackground(Color.white);
		pan_container.setBorder(thickBorder);
		this.add(pan8);
		this.add(pan_container);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(btn_exit)) {
			dispose();
			this.setVisible(false);

		} else if (source.equals(btn_preview)) {

			Monthly_Preview print = new Monthly_Preview();
			print.fill_data(cmb_date.getText().toString(), txt_DATE.getText().toString(),
					cmb_month.getSelectedItem().toString(), txt_year.getText().toString(),
					txt_monthlyslip.getText().toString(), str2, str3, str4, str5, str6, str7, str8, str9, str10, str11,
					str12, str13, str14, str15, str16, str17, str18);

		} else if (source.equals(btn_createReportformonth)) {
			if (cmb_date.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Month Field Must Not Empty!");

			} else {
				month_code = cmb_date.getText().trim();
				Get_Data(month_code);

			}

		} else if (source.equals(btn_clear)) {
			reset();
		}

	}

	public void Get_Data(String code) {
		if (cmb_month.getSelectedItem().toString().equals("") || txt_year.getText().toString().equals("")) {

			JOptionPane.showMessageDialog(null, "Field Must Not Empty!");

		} else {

			try {
				conn = connect.setConnection(conn);
			} catch (Exception e) {
			}
			try {

				Statement stmt = conn.createStatement();

				if (!code.equals("")) {
					String query = "SELECT * FROM monthly_report WHERE month='" + code + "'";
					ResultSet rs = stmt.executeQuery(query);
					int foundrec = 0;
					while (rs.next()) {
						month_code = code;
						str2 = rs.getString(2).trim();
						str3 = rs.getString(3).trim();
						str4 = rs.getString(4).trim();
						str5 = rs.getString(5).trim();
						str6 = rs.getString(6).trim();
						str7 = rs.getString(7).trim();
						str8 = rs.getString(8).trim();
						str9 = rs.getString(9).trim();
						str10 = rs.getString(10).trim();
						str11 = rs.getString(11).trim();
						str12 = rs.getString(12).trim();
						str13 = rs.getString(13).trim();
						str14 = rs.getString(14).trim();
						str15 = rs.getString(15).trim();
						str16 = rs.getString(16).trim();
						str17 = rs.getString(17).trim();
						str18 = rs.getString(18).trim();
						txt_DATE.setText(sDate);
						txt_monthlyslip.setText("For the Month of " + cmb_month.getSelectedItem().toString() + " , "
								+ txt_year.getText().toString());
						txt_numberofcustomer.setText(str2);
						txt_numofitem.setText(str3);
						txt_stockitem.setText(str4);
						txt_numberofvan.setText(str5);
						txt_contactbakery.setText(str6);
						txt_numservice.setText(str7);
						txt_numofemp.setText(str8);
						txt_totalcostservice.setText(str9);
						txt_tatalcostsallaryemp.setText(str10);
						txt_1.setText(str11);
						txt_2.setText(str12);
						txt_3.setText(str13);
						txt_4.setText(str14);
						txt_5.setText(str15);
						txt_6.setText(str16);
						txt_7.setText(str17);
						txt_8.setText(str18);
						foundrec = 1;

					}

					if (foundrec == 0) {
						String dialogmessage = "No Such Month";
						int dialogtype = JOptionPane.WARNING_MESSAGE;
						JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);

					}

				} else {
					String dialogmessage = "No Blank Field Allowed";

					int dialogtype = JOptionPane.WARNING_MESSAGE;
					JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);

				}

			} catch (Exception e) {
				System.out.println("\nUnknown Error at Genrate_Data");
			}
		}

	}

	public void reset() {
		txt_numberofcustomer.setText("");
		txt_numofitem.setText("");
		txt_stockitem.setText("");
		txt_numberofvan.setText("");
		txt_contactbakery.setText("");
		txt_numservice.setText("");
		txt_numofemp.setText("");
		txt_totalcostservice.setText("");
		txt_tatalcostsallaryemp.setText("");
		txt_1.setText("");
		txt_2.setText("");
		txt_3.setText("");
		txt_4.setText("");
		txt_5.setText("");
		txt_6.setText("");
		txt_7.setText("");
		txt_8.setText("");
		txt_year.setText("");
		cmb_date.setText("");
	}

}
