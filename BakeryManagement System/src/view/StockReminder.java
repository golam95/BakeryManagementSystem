package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Controller.Databaseconnect;

public class StockReminder extends JInternalFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Border thickBorder = new LineBorder(Color.WHITE, 23);
	private JButton btn_change = new JButton("Ok");
	private JTextField txt_change = new JTextField();
	private JButton btn_change1 = new JButton("Ok");
	private JTextField txt_change1 = new JTextField();
	JRadioButton btn_rnd = new JRadioButton("Default");
	JRadioButton btn_off = new JRadioButton("Off");
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	Connection conn;
	Databaseconnect connect = new Databaseconnect();

	// @SuppressWarnings("unchecked")
	public StockReminder(JFrame getParentFrame) {
		super("Add Customer", true, true, true, true);

		this.setSize(450, 250);
		this.setLayout(new GridLayout());
		this.setResizable(false);
		this.setLocation(screenheith / 2, screedwidth / 12);
		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = createImageIcon("");
		JComponent panel1 = makeTextPanel("");
		panel1.setBackground(Color.decode("#875A3C"));
		panel1.setLayout(null);
		JPanel pan_autoreminder = new JPanel();
		pan_autoreminder.setBounds(20, 20, 395, 155);
		pan_autoreminder.setLayout(null);
		pan_autoreminder.setBackground(Color.decode("#C8A064"));
		pan_autoreminder.setBorder(thickBorder);
		pan_autoreminder.setLayout(null);
		JLabel lbl_change = new JLabel("Restock level quantity");
		lbl_change.setBounds(30, 60, 130, 30);
		txt_change.setBounds(160, 60, 140, 30);
		retrive_customer(txt_change);
		btn_change.setBounds(305, 60, 56, 30);
		btn_change.setBackground(Color.ORANGE);
		pan_autoreminder.add(lbl_change);
		pan_autoreminder.add(txt_change);
		pan_autoreminder.add(btn_change);
		panel1.add(pan_autoreminder);
		tabbedPane.addTab("Auto Reminder Stock", icon, panel1, "Stock Setting");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		JComponent panel2 = makeTextPanel("");
		panel2.setBackground(Color.decode("#875A3C"));
		panel2.setLayout(null);
		JPanel pan_autoreminder2 = new JPanel();
		pan_autoreminder2.setBounds(20, 20, 395, 155);
		pan_autoreminder2.setLayout(null);
		pan_autoreminder2.setBackground(Color.decode("#C8A064"));
		pan_autoreminder2.setBorder(thickBorder);
		pan_autoreminder2.setLayout(null);
		JLabel lbl_change1 = new JLabel("Gui Screen Capture");
		lbl_change1.setBounds(30, 40, 130, 30);
		pan_autoreminder2.add(lbl_change1);
		ButtonGroup btn_group = new ButtonGroup();
		btn_group.add(btn_rnd);
		btn_group.add(btn_off);
		txt_change1.setBounds(160, 40, 140, 30);
		btn_change1.setBounds(305, 40, 56, 70);
		btn_rnd.setBounds(160, 85, 76, 30);
		btn_off.setBounds(240, 85, 56, 30);
		btn_rnd.setBackground(Color.decode("#C8A064"));
		btn_off.setBackground(Color.decode("#C8A064"));
		btn_change1.setBackground(Color.ORANGE);
		btn_change1.setForeground(Color.black);
		btn_change1.addActionListener(this);
		btn_change.addActionListener(this);
		btn_rnd.addActionListener(this);
		btn_off.addActionListener(this);
		pan_autoreminder2.add(btn_rnd);
		pan_autoreminder2.add(btn_off);
		pan_autoreminder2.add(txt_change1);
		pan_autoreminder2.add(btn_change1);
		panel2.add(pan_autoreminder2);
		tabbedPane.addTab("Screen Capture", icon, panel2, "Setting Screen Capture");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
		this.add(tabbedPane);
		this.setVisible(true);
	}

	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.add(filler);
		return panel;
	}

	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = MainGui.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();

		if (source.equals(btn_change1)) {
			String str = "";

		} else if (source.equals(btn_change)) {

			btn_off.addActionListener(this);

			if (btn_rnd.isSelected() == true) {

			} else if (btn_off.isSelected() == true) {

			} else {

			}

		}

	}

	public void retrive_customer(JTextField cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM Auto_stockreminder";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String txt_id = rs.getString(2).trim();
				cmb.setText(txt_id);

			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

}
