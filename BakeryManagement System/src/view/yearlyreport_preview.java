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

public class yearlyreport_preview extends JFrame implements ActionListener, Printable {
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
	JTextField txt_totalcostservice = new JTextField();
	JTextField txt_tatalcostsallaryemp = new JTextField();
	JTextField txt_totalcostwarehouse = new JTextField();
	JTextField txt_numberorder = new JTextField();
	JTextField txt_totalordercostperyear = new JTextField();
	JTextField txt_numorderclientperyear = new JTextField();
	JTextField txt_numorderhereperyear = new JTextField();
	JTextField txt_totalcostclient_year = new JTextField();
	JTextField txt_totalcosthear_year = new JTextField();
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
	JLabel lbl_name_year = new JLabel("Create Date :");
	private JButton btn_exit_pre = new JButton("Exit");
	private JButton btn_print_pre = new JButton("print");

	public yearlyreport_preview() {
		this.setSize(550, 600);
		this.setLocation(screenheith / 7, screedwidth / 37);
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan4 = new JPanel();
		JPanel pan5 = new JPanel();
		JPanel pan6 = new JPanel();
		JPanel pan7 = new JPanel();
		JPanel pan8 = new JPanel();
		JLabel lbl_date_pre = new JLabel("Year :");
		JLabel lbl_month_pre = new JLabel("Month :");
		JLabel lbl_year_pre = new JLabel("Year :");
		JLabel lbl_para_pre = new JLabel("#########  GOLAM BAKERY MONTHLY REPORT #########");
		JLabel lbl_report_pre = new JLabel("######  R  E  P  O  R  T  ######");
		JLabel lbl_DATE_pre = new JLabel("Date :");
		JLabel lbl_monthlyslip_pre = new JLabel("Monthly slip Report :");
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
		pan7.add(lbl_totalcostservice);
		pan7.add(txt_totalcostservice);
		pan7.add(lbl_tatalcostsallaryemp);
		pan7.add(txt_tatalcostsallaryemp);
		pan7.add(lbl_totalcostwarehouse);
		pan7.add(txt_totalcostwarehouse);
		pan7.add(lbl_numberorder);
		pan7.add(txt_numberorder);
		pan7.add(lbl_totalordercostperyear);
		pan7.add(txt_totalordercostperyear);
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
		txt_date_pre.setEditable(false);
		txt_month_pre.setEditable(false);
		txt_year_pre.setEditable(false);
		txt_DATE_pre.setEditable(false);
		txt_monthlyslip_pre.setEditable(false);
		txt_totalcostservice.setEditable(false);
		txt_tatalcostsallaryemp.setEditable(false);
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

	public void fill_data(String st1, String st2, String st3, String st4, String st5, String st6, String st7,
			String st8, String st9, String st10, String st11, String st12, String st13, String st14, String st15,
			String st16) {

		txt_date_pre.setText(st1);
		txt_month_pre.setText(st2);
		txt_year_pre.setText(st3);
		txt_DATE_pre.setText(st4);
		txt_monthlyslip_pre.setText(st5);
		txt_tatalcostsallaryemp.setText(st6);
		txt_totalcostservice.setText(st7);
		txt_totalcostwarehouse.setText(st8);
		txt_numberorder.setText(st9);
		txt_totalordercostperyear.setText(st10);
		txt_numorderclientperyear.setText(st11);
		txt_numorderhereperyear.setText(st12);
		txt_totalcostclient_year.setText(st13);
		txt_totalcosthear_year.setText(st14);
		txt_name_year.setText(st15);

	}

}
