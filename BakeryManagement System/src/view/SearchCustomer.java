package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.Databaseconnect;

import java.sql.*;

public class SearchCustomer extends JInternalFrame implements ActionListener {
	JFrame JFParentFrame;
	JDesktopPane desktop;
	String dialogmessage;
	String dialogs;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	int dialogtype = JOptionPane.PLAIN_MESSAGE;
	private JPanel addcutomer_info = new JPanel();
	private JTextField txt_shopNo = new JTextField();
	private JTextField txt_customerspopname = new JTextField();
	private JTextField txt_customerName = new JTextField();
	private JTextField txt_customerAdress = new JTextField();
	private JTextField txt_customerContact = new JTextField();
	private JComboBox cmb_list = new JComboBox();
	private JButton btnCancel = new JButton(new ImageIcon("images/k.png"));
	private JButton btnOk = new JButton(new ImageIcon("images/add.png"));
	// string variable
	String shop_no;
	String shop_name;
	String customer_name;
	String customer_address;
	String contact_numbe;
	Databaseconnect connect = new Databaseconnect();
	Connection conn;

	public SearchCustomer(JFrame getParentFrame) {
		// super (Title, Resizable, Closable, Maximizable, Iconifiable)
		super("Add Customer", false, true, false, true);
		try {
			this.setSize(390, 280);
			JLabel lbl_shopNo = new JLabel("Shop No :");
			JLabel lbl_customerspopname = new JLabel("Shop Name :");
			JLabel lbl_customerName = new JLabel("Customer Name :");
			JLabel lbl_customerAdress = new JLabel("Customer Address :");
			JLabel lbl_customerContact = new JLabel("Contact Number :");
			JLabel lbl_customershoplist = new JLabel("Shop No List :");
			String cat_empName = (String) cmb_list.getSelectedItem();// name
			cmb_list.addActionListener(this);
			lbl_shopNo.setForeground(Color.black);
			lbl_customerspopname.setForeground(Color.black);
			lbl_customerName.setForeground(Color.black);
			lbl_customerAdress.setForeground(Color.black);
			lbl_customerContact.setForeground(Color.black);
			lbl_customershoplist.setBounds(15, 15, 130, 20);
			lbl_shopNo.setBounds(15, 45, 130, 20);
			lbl_customerspopname.setBounds(15, 75, 130, 20);
			lbl_customerName.setBounds(15, 105, 130, 20);
			lbl_customerAdress.setBounds(15, 135, 130, 20);
			lbl_customerContact.setBounds(15, 165, 130, 20);
			txt_shopNo.setHorizontalAlignment(JTextField.LEFT);
			txt_customerAdress.setHorizontalAlignment(JTextField.LEFT);
			txt_customerspopname.setHorizontalAlignment(JTextField.LEFT);
			txt_customerName.setHorizontalAlignment(JTextField.LEFT);
			txt_customerContact.setHorizontalAlignment(JTextField.LEFT);
			cmb_list.setBounds(130, 15, 200, 25);
			retrive_customreshop(cmb_list);
			txt_shopNo.setBounds(130, 45, 200, 25);
			txt_customerspopname.setBounds(130, 75, 200, 25);
			txt_customerName.setBounds(130, 105, 200, 25);
			txt_customerAdress.setBounds(130, 135, 200, 25);
			txt_customerContact.setBounds(130, 165, 200, 25);
			txt_shopNo.setEditable(false);
			txt_customerspopname.setEditable(false);
			txt_customerName.setEditable(false);
			txt_customerAdress.setEditable(false);
			txt_customerContact.setEditable(false);
			btnOk.setText("Add");
			btnOk.setToolTipText("Insert Button");
			btnCancel.setToolTipText("Cancel Button");
			btnOk.setBounds(95, 215, 90, 25);
			btnOk.setBackground(Color.ORANGE);
			btnCancel.setText("Cancel");
			btnCancel.setBounds(195, 215, 90, 25);
			btnCancel.setBackground(Color.orange);
			btnOk.addActionListener(this);
			btnCancel.addActionListener(this);
			addcutomer_info.setLayout(null);
			addcutomer_info.add(lbl_customershoplist);
			addcutomer_info.add(lbl_shopNo);
			addcutomer_info.add(lbl_customerspopname);
			addcutomer_info.add(lbl_customerName);
			addcutomer_info.add(lbl_customerAdress);
			addcutomer_info.add(lbl_customerContact);
			addcutomer_info.add(cmb_list);
			addcutomer_info.add(txt_shopNo);
			addcutomer_info.add(txt_customerspopname);
			addcutomer_info.add(txt_customerName);
			addcutomer_info.add(txt_customerAdress);
			addcutomer_info.add(txt_customerContact);
			addcutomer_info.add(btnOk);
			addcutomer_info.add(btnCancel);
			this.setLocation(screenheith / 2, screedwidth / 10);
			this.getContentPane().add(addcutomer_info, BorderLayout.CENTER);
			fill_formcomb(cat_empName);
			this.setVisible(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error addcustomer", "!WARRING", JOptionPane.ERROR_MESSAGE);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(cmb_list)) {
			String cat_empthirdName = (String) cmb_list.getSelectedItem();
			fill_formcomb(cat_empthirdName);

		} else if (source.equals(btnCancel)) {
			dispose();
			this.setVisible(false);

		}

	}

	public void retrive_customreshop(JComboBox cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM customer";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String emptype = rs.getString(1).trim();
				cmb.addItem(emptype);
			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	public void fill_formcomb(String name) {// get the two id and

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {

			Statement stmt = conn.createStatement();

			String query = "SELECT * FROM customer WHERE shop_no='" + name + "'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String shopno = rs.getString(1).trim();
				String shopname = rs.getString(2).trim();
				String customername = rs.getString(3).trim();
				String customeraddress = rs.getString(4).trim();
				String contact = rs.getString(5).trim();
				txt_shopNo.setText(shopno);
				txt_customerspopname.setText(shopname);
				txt_customerName.setText(customername);
				txt_customerAdress.setText(customeraddress);
				txt_customerContact.setText(contact);
				rs = null;
			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

}