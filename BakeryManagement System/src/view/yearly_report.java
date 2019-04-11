package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Controller.Databaseconnect;

public class yearly_report extends JInternalFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame JFParentFrame;
	JButton btn_createReportformonth = new JButton("Create Report");
	static Date td = new Date();
	static String sDate = DateFormat.getDateTimeInstance().format(td);
	JPanel pane_genteratereport = new JPanel();
	private JButton btn_clear = new JButton("Clear");
	String str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, year_code;
	Connection conn;
	Databaseconnect connect = new Databaseconnect();

	JPanel pan_container = new JPanel();
	private String[] Month_Name = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };

	private JTextField cmb_date = new JTextField(20);
    private JComboBox<String> cmb_month = new JComboBox<String>();
	private JTextField txt_year = new JTextField(20);
	private JTextField txt_DATE = new JTextField(20);
	private JTextField txt_monthlyslip = new JTextField(20);
	

	JTextField txt_tatalcostsallaryemp = new JTextField("1");
	JTextField txt_totalcostservice = new JTextField("1");
	JTextField txt_totalcostwarehouse = new JTextField("1");
	JTextField txt_totalordercostperyear = new JTextField("1");
	JTextField txt_totalcostclient_year = new JTextField("1");
	JTextField txt_totalcosthear_year = new JTextField("1");
	
	
	
	JTextField txt_numberorder = new JTextField();
	JTextField txt_numorderclientperyear = new JTextField();
	
	JTextField txt_numorderhereperyear = new JTextField();
	
	JTextField txt_name_year = new JTextField();

	
	
	JLabel lbl_totalcostservice = new JLabel("Total Cost Service Provider(Per Year) :");
	JLabel lbl_tatalcostsallaryemp = new JLabel("Total Cost Employee Provider(Per Year) :");
	JLabel lbl_totalcostwarehouse = new JLabel("Total Cost Warehouse (Per Year) :");
	JLabel lbl_numberorder = new JLabel("Number Of Order (Per Year) :");
	JLabel lbl_totalordercostperyear = new JLabel("Total Order Cost (Per Year) :");

	JLabel lbl_numorderclientperyear = new JLabel("Number Of EmergenceyOrder(Per Year) :");
	JLabel lbl_numorderhereperyear = new JLabel("Number Of Orderhere(Per Year) :");
	JLabel lbl_totalcostclient_year = new JLabel("Total Cost Emergencey Order(Per Year) :");
	JLabel lbl_totalcosthear_year = new JLabel("Total Cost Order here(Per Year) :");
	JLabel lbl_name_year = new JLabel("Year Name :");

	
	private JButton btn_exit = new JButton("Exit");
	private JButton btn_preview = new JButton("Preview");
	private JButton btn_pdf = new JButton("PDF");

	public yearly_report(JFrame getParentFrame) {
		super("Yearly Report", true, true, true, true);
		this.setSize(400, 500);
		this.setLayout(null);
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan4 = new JPanel();
		JPanel pan5 = new JPanel();
		JPanel pan6 = new JPanel();
		JPanel pan7 = new JPanel();
		JPanel pan8 = new JPanel();
		JPanel pan_right = new JPanel();
		JLabel lbl_date = new JLabel("Select Year :");
		JLabel lbl_month = new JLabel("Month :");
		JLabel lbl_year = new JLabel("Year :");
		JLabel lbl_para = new JLabel("#########  GOLAM BAKERY MONTHLY REPORT #########");
		JLabel lbl_report = new JLabel("######  R  E  P  O  R  T  ######");
		JLabel lbl_DATE = new JLabel("Date :");

		pan1.setLayout(new FlowLayout());
		pan1.setBounds(5, 10, 1240, 30);
		// pan1.setBackground(Color.green);
		pan1.add(lbl_date);
		pan1.add(cmb_date);
		pan2.setLayout(new FlowLayout());
		Border thickBorder = new LineBorder(Color.decode("#394B58"), 5);
	

		pane_genteratereport.setLayout(new FlowLayout());
		pane_genteratereport.setBounds(5, 50, 1240, 30);
		pane_genteratereport.setBackground(Color.WHITE);
		pane_genteratereport.add(btn_createReportformonth);
		btn_createReportformonth.addActionListener(this);

		pan2.setBounds(5, 100, 1240, 30);
		pan4.setBounds(5, 140, 1240, 30);
		pan5.setBounds(80, 180, 940, 50);
		pan6.setBounds(5, 240, 1240, 30);
		pan7.setBounds(80, 290, 500, 150);
		pan_right.setBounds(670, 290, 500, 150);
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
		pan_right.add(lbl_totalcostservice);
		pan_right.add(txt_totalcostservice);
		pan_right.add(lbl_tatalcostsallaryemp);
		pan_right.add(txt_tatalcostsallaryemp);
		pan_right.add(lbl_totalcostwarehouse);
		pan_right.add(txt_totalcostwarehouse);
		pan_right.add(lbl_numberorder);
		pan_right.add(txt_numberorder);
		pan_right.add(lbl_totalordercostperyear);
		pan_right.add(txt_totalordercostperyear);

		pan7.setLayout(new GridLayout(0, 2));
		pan7.add(lbl_numorderclientperyear);
		pan7.add(txt_numorderclientperyear);
		pan7.add(lbl_numorderhereperyear);
		pan7.add(txt_numorderhereperyear);
		pan7.add(lbl_totalcostclient_year);
		pan7.add(txt_totalcostclient_year);
		pan7.add(lbl_totalcosthear_year);
		pan7.add(txt_totalcosthear_year);
		pan7.add(lbl_name_year);
		pan7.add(txt_name_year);

		pan1.setBackground(Color.white);
		pan2.setBackground(Color.white);
		pan4.setBackground(Color.white);
		pan5.setBackground(Color.white);
		pan6.setBackground(Color.white);
		pan7.setBackground(Color.white);
		pan_right.setBackground(Color.WHITE);
		btn_exit.setBackground(Color.ORANGE);
		btn_preview.setBackground(Color.ORANGE);
		btn_pdf.setBackground(Color.ORANGE);
		cmb_date.setBackground(Color.WHITE);
		cmb_month.setBackground(Color.WHITE);
		txt_year.setBackground(Color.WHITE);
		txt_DATE.setBackground(Color.WHITE);
		txt_monthlyslip.setBackground(Color.WHITE);
		txt_totalcostservice.setBackground(Color.WHITE);
		txt_tatalcostsallaryemp.setBackground(Color.WHITE);
		txt_totalcostwarehouse.setBackground(Color.WHITE);
		txt_numberorder.setBackground(Color.WHITE);
		txt_totalordercostperyear.setBackground(Color.WHITE);

		txt_numorderclientperyear.setBackground(Color.WHITE);
		txt_numorderhereperyear.setBackground(Color.WHITE);
		txt_totalcostclient_year.setBackground(Color.WHITE);
		txt_totalcosthear_year.setBackground(Color.WHITE);
		txt_name_year.setBackground(Color.WHITE);

		txt_totalcostservice.setEditable(false);
		txt_tatalcostsallaryemp.setEditable(false);
		txt_totalcostwarehouse.setEditable(false);
		txt_numberorder.setEditable(false);
		txt_totalordercostperyear.setEditable(false);
		txt_numorderclientperyear.setEditable(false);
		txt_numorderhereperyear.setEditable(false);
		txt_totalcostclient_year.setEditable(false);
		txt_totalcosthear_year.setEditable(false);
		txt_name_year.setEditable(false);
		txt_DATE.setEditable(false);
		txt_monthlyslip.setEditable(false);
		txt_totalcostservice.setEditable(false);
		txt_tatalcostsallaryemp.setEditable(false);
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
		pan_container.add(pan4);
		pan_container.add(pan5);
		pan_container.add(pan6);
		pan_container.add(pane_genteratereport);
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
			yearlyreport_preview print = new yearlyreport_preview();
			print.fill_data(cmb_date.getText().toString(),
					cmb_month.getSelectedItem().toString(), txt_year.getText().toString(),
					 txt_DATE.getText().toString(),txt_monthlyslip.getText().toString(), str2, str3, str4, str5, str6, str7, str8, str9, str10, str11,
					str12);


		} else if (source.equals(btn_createReportformonth)) {
			if (cmb_date.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Year Field is Empty!");

			} else {
				year_code = cmb_date.getText().trim();
				Get_Data(year_code);
			}

		} else if (source.equals(btn_clear)) {
			resetext();

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
					String query = "SELECT * FROM yearly_report WHERE yearname='" + code + "'";
					ResultSet rs = stmt.executeQuery(query);
					int foundrec = 0;
					while (rs.next()) {
						year_code = code;
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

						txt_DATE.setText(sDate);
						txt_monthlyslip.setText("For the Month of " + cmb_month.getSelectedItem().toString() + " , "
								+ txt_year.getText().toString());

						txt_tatalcostsallaryemp.setText(str2);
						txt_totalcostservice.setText(str3);
						txt_totalcostwarehouse.setText(str4);
						txt_numberorder.setText(str5);
						txt_numorderclientperyear.setText(str6);
						txt_totalordercostperyear.setText(str7);
						txt_numorderhereperyear.setText(str8);
						txt_totalcostclient_year.setText(str9);
						txt_totalcosthear_year.setText(str10);
						txt_name_year.setText(str12);

						foundrec = 1;

					}

					if (foundrec == 0) {
						String dialogmessage = "No Such Year";
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

	public void resetext() {
		cmb_date.setText("");
		txt_year.setText("");
		txt_DATE.setText("");
		txt_monthlyslip.setText("");
		txt_totalcostservice.setText("");
		txt_tatalcostsallaryemp.setText("");
		txt_totalcostwarehouse.setText("");
		txt_numberorder.setText("");
		txt_totalordercostperyear.setText("");
		txt_numorderclientperyear.setText("");
		txt_numorderhereperyear.setText("");
		txt_totalcostclient_year.setText("");
		txt_totalcosthear_year.setText("");
		txt_name_year.setText("");

	}

}
