package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.Databaseconnect;

import java.sql.*;
import java.util.*;

public class DeleteCustomer extends JInternalFrame implements ActionListener {
	JFrame JFParentFrame;
	JDesktopPane desktop;
	private JPanel delcutomer_info = new JPanel();
	private JTextField txt_shopNo = new JTextField();
	private JTextField txt_customerspopname = new JTextField();
	private JTextField txt_customerName = new JTextField();
	private JTextField txt_customerAdress = new JTextField();
	private JTextField txt_customerContact = new JTextField();
	private JButton btnCancel = new JButton(new ImageIcon("images/k.png"));
	private JButton btnfind = new JButton(new ImageIcon("images/add.png"));
	private JButton btndelete = new JButton(new ImageIcon("images/delete.png"));
	//
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	//
	String dialogmessage;
	String dialogs;
	int dialogtype = JOptionPane.PLAIN_MESSAGE;
	Databaseconnect connect = new Databaseconnect();
	Connection conn;

	public DeleteCustomer(JFrame getParentFrame) {
		// super (Title, Resizable, Closable, Maximizable, Iconifiable)
		super("Delete Customer", false, true, false, true);
		this.setSize(390, 250);
		JLabel lbl_shopNo = new JLabel("Shop No :");
		JLabel lbl_customerspopname = new JLabel("Shop Name :");
		JLabel lbl_customerName = new JLabel("Customer Name :");
		JLabel lbl_customerAdress = new JLabel("Customer Address :");
		JLabel lbl_customerContact = new JLabel("Contact Number :");
		lbl_shopNo.setForeground(Color.black);
		lbl_customerspopname.setForeground(Color.black);
		lbl_customerName.setForeground(Color.black);
		lbl_customerAdress.setForeground(Color.black);
		lbl_customerContact.setForeground(Color.black);
		lbl_shopNo.setBounds(15, 15, 130, 20);
		lbl_customerspopname.setBounds(15, 45, 130, 20);
		lbl_customerName.setBounds(15, 75, 130, 20);
		lbl_customerAdress.setBounds(15, 105, 130, 20);
		lbl_customerContact.setBounds(15, 135, 130, 20);
		txt_shopNo.setHorizontalAlignment(JTextField.LEFT);
		txt_customerAdress.setHorizontalAlignment(JTextField.LEFT);
		txt_customerspopname.setHorizontalAlignment(JTextField.LEFT);
		txt_customerName.setHorizontalAlignment(JTextField.LEFT);
		txt_customerContact.setHorizontalAlignment(JTextField.LEFT);
		txt_shopNo.setBounds(130, 15, 200, 25);
		txt_customerspopname.setBounds(130, 45, 200, 25);
		txt_customerName.setBounds(130, 75, 200, 25);
		txt_customerAdress.setBounds(130, 105, 200, 25);
		txt_customerContact.setBounds(130, 135, 200, 25);
		txt_customerspopname.setEditable(false);
		txt_customerName.setEditable(false);
		txt_customerAdress.setEditable(false);
		txt_customerContact.setEditable(false);
		btnfind.setText("Find");
		btnfind.setToolTipText("Insert Button");
		btnCancel.setToolTipText("Cancel Button");
		btndelete.setToolTipText("Delete Button");
		btnfind.setBackground(Color.ORANGE);
		btnCancel.setText("Cancel");
		btndelete.setText("Delete");
		btnfind.setBounds(95, 185, 80, 25);
		btndelete.setBounds(178, 185, 80, 25);
		btnCancel.setBounds(262, 185, 90, 25);
		btnfind.setBackground(Color.orange);
		btndelete.setBackground(Color.orange);
		btnCancel.setBackground(Color.orange);
		btnfind.addActionListener(this);
		btnCancel.addActionListener(this);
		btndelete.addActionListener(this);
		delcutomer_info.setLayout(null);
		delcutomer_info.add(lbl_shopNo);
		delcutomer_info.add(lbl_customerspopname);
		delcutomer_info.add(lbl_customerName);
		delcutomer_info.add(lbl_customerAdress);
		delcutomer_info.add(lbl_customerContact);
		delcutomer_info.add(txt_shopNo);
		delcutomer_info.add(txt_customerspopname);
		delcutomer_info.add(txt_customerName);
		delcutomer_info.add(txt_customerAdress);
		delcutomer_info.add(txt_customerContact);
		delcutomer_info.add(btnfind);
		delcutomer_info.add(btndelete);
		delcutomer_info.add(btnCancel);
		this.getContentPane().add(delcutomer_info, BorderLayout.CENTER);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		String shop_no = "";
		String shop_name = "";
		String customer_name = "";
		String customer_address = "";
		String customer_contact = "";
		if (source.equals(btnfind)) {
			JOptionPane.showMessageDialog(null, "Eorr the main gui");
			shop_no = txt_shopNo.getText().trim();

			try {
				conn = connect.setConnection(conn);
			} catch (Exception ex) {
			}
			try {

				Statement stmt = conn.createStatement();
				if (!shop_no.equals("")) {
					String query = "SELECT * FROM customer WHERE shop_no='" + shop_no + "'";
					ResultSet rs = stmt.executeQuery(query);
					int foundrec = 0;
					while (rs.next()) {
						shop_name = rs.getString(2).trim();
						customer_name = rs.getString(3).trim();
						customer_address = rs.getString(4).trim();
						customer_contact = rs.getString(5).trim();
						txt_customerspopname.setText(shop_name);
						txt_customerspopname.setEditable(true);
						txt_customerName.setText(customer_name);
						txt_customerName.setEditable(true);
						txt_customerAdress.setText(customer_address);
						txt_customerAdress.setEditable(true);
						txt_customerContact.setText(customer_contact);
						txt_customerContact.setEditable(true);

						foundrec = 1;

					}

					if (foundrec == 0) {
						dialogmessage = "No Such Customer";

						dialogtype = JOptionPane.WARNING_MESSAGE;
						JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs, dialogtype);
						ResetText();

					}

				} else {
					dialogmessage = "No Blank Field Allowed";

					dialogtype = JOptionPane.WARNING_MESSAGE;
					JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs, dialogtype);
					ResetText();

				}
				conn.close();

			} catch (Exception ex) {
				System.out.println("\nUnknown Error");
			}
		} else if (source.equals(btndelete)) {
			int DResult = JOptionPane.showConfirmDialog((Component) null, "Are you sure you want to delete Record?");

			if (DResult == JOptionPane.NO_OPTION) {
				ResetText();

			}

			if (DResult == JOptionPane.YES_OPTION) {

				try {
					conn = connect.setConnection(conn);
				} catch (Exception e) {
				}

				try {
					Statement stmt = conn.createStatement();
					shop_no = txt_shopNo.getText().trim();

					if (!shop_no.equals("")) {
						String temp = "DELETE from customer " + " WHERE shop_no= '" + shop_no + "'";
						int result = stmt.executeUpdate(temp);

						if (result == 1) {
							dialogmessage = "Customer Record Deleted!!!";
							dialogtype = JOptionPane.WARNING_MESSAGE;
							JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs, dialogtype);
							ResetText();
						}

						else

						{
							dialogmessage = "No Such Customer";

							dialogtype = JOptionPane.WARNING_MESSAGE;
							JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs, dialogtype);
							ResetText();

						}

					}

					conn.close();

				}

				catch (Exception e) {
					System.out.println("\nUnknown Error" + e);
				}
			}

		} else if (source.equals(btnCancel)) {
			dispose();
			this.setVisible(false);

		}

	}

	public void ResetText() {
		txt_shopNo.setText("");
		txt_customerspopname.setText("");
		txt_customerName.setText("");
		txt_customerAdress.setText("");
		txt_customerContact.setText("");
	}

}