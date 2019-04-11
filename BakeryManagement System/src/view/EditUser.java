package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Controller.Databaseconnect;

public class EditUser extends JInternalFrame implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField txt_first = new JTextField();
	JTextField txt_lastname = new JTextField();
	JTextField txt_nic = new JTextField();
	JTextField txt_email = new JTextField();
	JTextField txt_contactno = new JTextField();
	JTextField txt_first_logintype = new JTextField();
	JPasswordField txt_first_password = new JPasswordField();
	JTextField txt_first_date = new JTextField();
	Databaseconnect connect = new Databaseconnect();
	Connection conn;
	JTextField txt_username = new JTextField();
	JLabel lbl_welcome = new JLabel("Welcome  ");
	private JButton btn_submit = new JButton("Update");
	private JButton btn_exit = new JButton("Exit");
	private JButton btn_edit = new JButton("Edit");

	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	String username = "";
	String email = "";
	String firstname, lastname, nic, email_e, contactno, logintype, username_e, password, date, image_user;
	String s;
	JLabel lbl_strong = new JLabel();

	public EditUser(JFrame getParentFrame, String usernamego) {
		super("Edit Userprofile", true, true, false, true);
		this.setSize(750, 500);
		JLabel lbl_first = new JLabel("First Name");
		JLabel lbl_lastname = new JLabel("Last Name");
		JLabel lbl_email = new JLabel("Email");
		JLabel lbl_contactno = new JLabel("Phone No");
		JLabel lbl_username = new JLabel("User Name");
		JLabel lbl_first_password = new JLabel("Password");

		JPanel pan_infromation = new JPanel();
		pan_infromation.setBounds(120, 70, 500, 330);
		Border thick_sager_Border = new LineBorder(Color.white, 17);
		pan_infromation.setBorder(thick_sager_Border);
		pan_infromation.setBackground(Color.decode("#FFE4B5"));

		this.add(pan_infromation);

		username = usernamego;
		lbl_first.setBounds(20, 20, 100, 30);
		lbl_lastname.setBounds(20, 60, 100, 30);
		lbl_email.setBounds(20, 100, 100, 30);
		lbl_contactno.setBounds(20, 140, 100, 30);
		lbl_username.setBounds(20, 180, 100, 30);
		lbl_first_password.setBounds(20, 220, 100, 30);
		lbl_welcome.setBounds(340, 20, 120, 120);
		pan_infromation.add(lbl_welcome);
		TitledBorder emergency_order5 = BorderFactory.createTitledBorder("");
		emergency_order5.setTitleJustification(TitledBorder.LEFT);
		lbl_welcome.setBorder(emergency_order5);

		txt_first.setBounds(100, 20, 200, 30);
		txt_lastname.setBounds(100, 60, 200, 30);
		txt_email.setBounds(100, 100, 200, 30);
		txt_contactno.setBounds(100, 140, 200, 30);
		txt_username.setBounds(100, 180, 200, 30);
		txt_first_password.setBounds(100, 220, 200, 30);
		lbl_strong.setBounds(340, 220, 200, 30);
		pan_infromation.add(lbl_strong);

		btn_submit.setBounds(100, 280, 80, 25);
		btn_exit.setBounds(190, 280, 80, 25);
		btn_edit.setBounds(280, 280, 80, 25);

		btn_edit.addActionListener(this);
		btn_exit.addActionListener(this);
		btn_submit.addActionListener(this);
		btn_edit.setBackground(Color.ORANGE);
		btn_exit.setBackground(Color.ORANGE);
		btn_submit.setBackground(Color.ORANGE);
		txt_first.setEditable(false);
		txt_lastname.setEditable(false);
		txt_nic.setEditable(false);
		txt_email.setEditable(false);
		txt_contactno.setEditable(false);
		txt_first_logintype.setEditable(false);
		txt_first_password.setEditable(false);
		txt_username.setEditable(false);

		txt_first.setBackground(Color.WHITE);
		txt_lastname.setBackground(Color.WHITE);
		txt_nic.setBackground(Color.WHITE);
		txt_email.setBackground(Color.WHITE);
		txt_contactno.setBackground(Color.WHITE);
		txt_first_logintype.setBackground(Color.WHITE);
		txt_first_password.setBackground(Color.WHITE);
		txt_username.setBackground(Color.WHITE);

		txt_email.setText(username);

		txt_email.addActionListener(this);
		txt_first_password.addKeyListener(this);
		String sr = (String) txt_email.getText();
		fill_form(sr);

		pan_infromation.add(btn_edit);
		pan_infromation.add(btn_exit);
		pan_infromation.add(btn_submit);
		pan_infromation.add(lbl_first);
		pan_infromation.add(lbl_lastname);
		pan_infromation.add(lbl_email);
		pan_infromation.add(lbl_contactno);
		pan_infromation.add(lbl_username);
		pan_infromation.add(lbl_first_password);
		pan_infromation.setLayout(null);
		pan_infromation.add(txt_first);
		pan_infromation.add(txt_lastname);
		pan_infromation.add(txt_email);
		pan_infromation.add(txt_contactno);
		pan_infromation.add(txt_username);
		pan_infromation.add(txt_first_password);
		this.setLocation(screenheith / 2, screedwidth / 15);
		this.getContentPane().setBackground(Color.decode("#875A3C"));
		this.setLayout(null);
		this.setVisible(true);
	}

	@SuppressWarnings("resource")
	public void fill_form(String name) {

		try {
			conn = connect.setConnection(conn);

		} catch (Exception e) {

		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM userinfo WHERE user_email='" + name + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// byte[] img = rs.getBytes("image");
				byte[] img = rs.getBytes("image");
				ImageIcon image = new ImageIcon(img);
				Image im = image.getImage();
				Image myimg = im.getScaledInstance(lbl_welcome.getWidth(), lbl_welcome.getHeight(),
						Image.SCALE_AREA_AVERAGING);
				ImageIcon imagegolam = new ImageIcon(myimg);
				firstname = "";
				lastname = "";
				email_e = "";
				contactno = "";
				username_e = "";
				password = "";
				image_user = "";

				firstname = rs.getString(1).trim();
				lastname = rs.getString(2).trim();
				email_e = rs.getString(4).trim();
				contactno = rs.getString(5).trim();
				username_e = rs.getString(7).trim();
				password = rs.getString(8).trim();

				txt_first.setText(firstname);
				txt_lastname.setText(lastname);
				txt_email.setText(email_e);
				txt_contactno.setText(contactno);
				txt_username.setText(username_e);
				txt_first_password.setText(password);

				lbl_welcome.setIcon(imagegolam);

				rs = null;

			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txt_email) {
			String cat_empthirdName = (String) txt_email.getText();
			fill_form(cat_empthirdName);

		} else if (e.getSource() == btn_submit) {

			update_information();
		} else if (e.getSource() == btn_exit) {
			this.setVisible(false);
			dispose();

		} else if (e.getSource() == btn_edit) {
			txt_first.setEditable(true);
			txt_lastname.setEditable(true);
			txt_nic.setEditable(true);
			txt_email.setEditable(true);
			txt_contactno.setEditable(true);
			txt_first_logintype.setEditable(true);
			txt_first_password.setEditable(true);
			txt_username.setEditable(true);

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

	public void executeSQlQuery_CustoemerDetails(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {

				JOptionPane.showMessageDialog(null, "Data " + message + "Succefully");

			} else {
				JOptionPane.showMessageDialog(null, "Invalid Email Address!!!!");

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void update_information() {

		firstname = "";
		lastname = "";
		email = "";
		contactno = "";
		username_e = "";
		password = "";
		image_user = "";

		firstname = txt_first.getText().toString();
		lastname = txt_lastname.getText().toString();
		nic = txt_nic.getText().toString();
		email = txt_email.getText().toString();
		contactno = txt_contactno.getText().toString();
		logintype = txt_first_logintype.getText().toString();
		username_e = txt_username.getText();
		password = txt_first_password.getText().toString();
		date = txt_first_date.getText().toString();

		String temp = "UPDATE userinfo SET " + "user_firstname = '" + firstname + "',user_lastname = '" + lastname
				+ "',user_email = '" + email + "',user_contactno = '" + contactno + "',user_username = '" + username_e
				+ "',user_password = '" + password + "'" + "WHERE user_email = '" + email + "'";
		executeSQlQuery_CustoemerDetails(temp, "Updated");

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("deprecation")
	@Override
	public void keyTyped(KeyEvent event) {
		if (txt_first_password.getText().length() < 3) {
			lbl_strong.setText("Easy To Guse!!");
			lbl_strong.setForeground(Color.CYAN);
		} else if (txt_first_password.getText().length() <= 4) {
			lbl_strong.setText("Not Strong!!");
			lbl_strong.setForeground(Color.PINK);
		} else if (txt_first_password.getText().length() >= 8) {
			lbl_strong.setText("Strong!!");
			lbl_strong.setForeground(Color.GREEN);

		}

	}

}
