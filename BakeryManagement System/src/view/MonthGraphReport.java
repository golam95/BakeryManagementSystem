package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Databaseconnect;

public class MonthGraphReport extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JDesktopPane desktop;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	Databaseconnect connect = new Databaseconnect();
	Connection conn;
	private JComboBox<String> cmb_month = new JComboBox<String>();

	private JButton btn_exit1 = new JButton("Exit");
	private JButton btn_barchart1 = new JButton("Barchart");
	private JButton btn_paichart1 = new JButton("Pai Chart");
	private JButton btn_graph1 = new JButton("Graph");

	public MonthGraphReport() {
		super("YearChart Reports");
		try {
			this.setSize(700, 300);
			this.setLocation(screenheith / 2, screedwidth / 7);
			this.setLayout(null);
			this.setResizable(false);
			JPanel pan_left1 = new JPanel();
			pan_left1.setBounds(30, 30, 620, 200);
			pan_left1.setBackground(Color.decode("#C8A064"));
			pan_left1.setLayout(null);
			JPanel pan_button1 = new JPanel();
			pan_button1.setLayout(null);
			pan_button1.setBounds(20, 20, 200, 160);
			pan_button1.setBackground(Color.decode("#FFE4B5"));
			btn_barchart1.setBounds(30, 20, 130, 30);
			btn_paichart1.setBounds(30, 65, 130, 30);
			btn_graph1.setBounds(30, 115, 130, 30);

			btn_exit1.addActionListener(this);
			btn_barchart1.addActionListener(this);
			btn_paichart1.addActionListener(this);
			btn_graph1.addActionListener(this);
			pan_button1.add(btn_barchart1);
			pan_button1.add(btn_paichart1);
			pan_button1.add(btn_graph1);
			JLabel lbl_year = new JLabel("Select Year");
			JPanel pan_search = new JPanel();
			pan_search.setLayout(null);
			pan_search.setBounds(250, 20, 345, 160);
			pan_search.setBackground(Color.decode("#FFE4B5"));
			lbl_year.setBounds(30, 20, 100, 30);
			cmb_month.setBounds(140, 20, 180, 30);
			btn_exit1.setBounds(170, 120, 100, 25);
			pan_search.add(lbl_year);
			pan_search.add(cmb_month);
			pan_search.add(btn_exit1);
			pan_left1.add(pan_search);
			pan_left1.add(pan_button1);
			this.add(pan_left1);
			this.getContentPane().setBackground(Color.decode("#875A3C"));
			this.show();

		} catch (Exception ex) {

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(btn_exit1)) {
			this.setVisible(false);
			dispose();

		} else if (source.equals(btn_barchart1)) {

		} else if (source.equals(btn_paichart1)) {

		} else if (source.equals(btn_graph1)) {

		}

	}

}
