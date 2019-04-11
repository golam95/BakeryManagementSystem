package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Monthly_Preview extends JFrame implements ActionListener, Printable {
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	JFrame JFParentFrame;
	private JTextField txt_date_pre = new JTextField(20);
	private JTextField txt_month_pre = new JTextField(20);
	private JTextField txt_year_pre = new JTextField(20);
	private JTextField txt_DATE_pre = new JTextField(20);
	private JTextField txt_monthlyslip_pre = new JTextField(20);
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
	private JButton btn_exit_pre = new JButton("Exit");
	private JButton btn_print_pre = new JButton("print");

	public Monthly_Preview() {
		this.setSize(550, 600);
		this.setLocation(screenheith / 7, screedwidth / 37);
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan4 = new JPanel();
		JPanel pan5 = new JPanel();
		JPanel pan6 = new JPanel();
		JPanel pan7 = new JPanel();
		JPanel pan8 = new JPanel();
		JLabel lbl_date_pre = new JLabel("Date :");
		JLabel lbl_month_pre = new JLabel("Month :");
		JLabel lbl_year_pre = new JLabel("Year :");
		JLabel lbl_para_pre = new JLabel("#########  GOLAM BAKERY MONTHLY REPORT #########");
		JLabel lbl_report_pre = new JLabel("######  R  E  P  O  R  T  ######");
		JLabel lbl_DATE_pre = new JLabel("Date :");
		JLabel lbl_monthlyslip_pre = new JLabel("Monthly slip Report :");
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
		pan1.add(lbl_date_pre);
		pan1.add(txt_date_pre);
		pan2.setLayout(new FlowLayout());
		pan2.add(lbl_month_pre);
		pan2.add(txt_month_pre);
		pan2.add(lbl_year_pre);
		pan2.add(txt_year_pre);
		pan4.setLayout(new FlowLayout());
		pan4.add(lbl_para_pre);
		pan5.setLayout(new GridLayout(0, 2));
		pan5.add(lbl_DATE_pre);
		pan5.add(txt_DATE_pre);
		pan5.add(lbl_monthlyslip_pre);
		pan5.add(txt_monthlyslip_pre);
		pan6.setLayout(new FlowLayout());
		pan6.add(lbl_report_pre);
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
		pan7.add(lbl_1);
		pan7.add(txt_1);
		pan7.add(lbl_2);
		pan7.add(txt_2);
		pan7.add(lbl_3);
		pan7.add(txt_3);
		pan7.add(lbl_4);
		pan7.add(txt_4);
		pan7.add(lbl_5);
		pan7.add(txt_5);
		pan7.add(lbl_6);
		pan7.add(txt_6);
		pan7.add(lbl_7);
		pan7.add(txt_7);
		pan7.add(lbl_8);
		pan7.add(txt_8);
		txt_numberofcustomer.setEditable(false);
		txt_numofitem.setEditable(false);
		txt_stockitem.setEditable(false);
		txt_numberofvan.setEditable(false);
		txt_contactbakery.setEditable(false);
		txt_numservice.setEditable(false);
		txt_numofemp.setEditable(false);
		txt_totalcostservice.setEditable(false);
		txt_tatalcostsallaryemp.setEditable(false);
		txt_1.setEditable(false);
		txt_2.setEditable(false);
		txt_3.setEditable(false);
		txt_4.setEditable(false);
		txt_5.setEditable(false);
		txt_6.setEditable(false);
		txt_7.setEditable(false);
		txt_8.setEditable(false);
		txt_date_pre.setEditable(false);
		txt_month_pre.setEditable(false);
		txt_year_pre.setEditable(false);
		txt_DATE_pre.setEditable(false);
		txt_monthlyslip_pre.setEditable(false);
		pan8.setLayout(new FlowLayout());
		pan8.add(btn_exit_pre);
		pan8.add(btn_print_pre);
		btn_exit_pre.addActionListener(this);
		btn_print_pre.addActionListener(this);
		Container pane = getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.add(pan1);
		pane.add(pan2);
		pane.add(pan4);
		pane.add(pan5);
		pane.add(pan6);
		pane.add(pan7);
		pane.add(pan8);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(btn_exit_pre)) {
			dispose();
			this.setVisible(false);

		} else if (source.equals(btn_print_pre)) {

			PrinterJob printJob = PrinterJob.getPrinterJob();

			// Get and change default page format settings if necessary.

			printJob.setPrintable(this);
			if (printJob.printDialog()) {
				try {
					printJob.print();

				} catch (Exception PrintException) {
					PrintException.printStackTrace();
				}

				printJob.cancel();

			}

			printJob.cancel();

		}

	}

	@Override
	public int print(Graphics g, PageFormat pf, int pi) throws PrinterException {

		Graphics2D g2 = (Graphics2D) g;
		g2.translate(pf.getImageableX() + 5, pf.getImageableY() + 5);

		Font f = new Font("Monospaced", Font.PLAIN, 12);
		g2.setFont(f);
		paint(g2);

		return Printable.PAGE_EXISTS;
	}

	public void fill_data(String date, String month, String str, String strt, String year, String year1, String code,
			String date1, String desi, String basic_pay, String da, String hra, String wa, String gpf, String it,
			String gis, String pf, String lic, String allow, String dedu, String net_salary, String f) {

		txt_date_pre.setText(date);
		txt_DATE_pre.setText(month);
		txt_month_pre.setText(str);
		txt_year_pre.setText(strt);
		txt_monthlyslip_pre.setText(year);
		txt_numberofcustomer.setText(year1);
		txt_numofitem.setText(code);
		txt_stockitem.setText(date1);
		txt_numberofvan.setText(desi);
		txt_contactbakery.setText(basic_pay);
		txt_numservice.setText(da);
		txt_numofemp.setText(hra);
		txt_totalcostservice.setText(wa);
		txt_tatalcostsallaryemp.setText(gpf);
		txt_1.setText(it);
		txt_2.setText(gis);
		txt_3.setText(pf);
		txt_4.setText(lic);
		txt_5.setText(allow);
		txt_6.setText(dedu);
		txt_7.setText(net_salary);
		txt_8.setText(f);

	}

}
