package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import Controller.Databaseconnect;

public class loginframe extends JFrame implements MouseListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnsubmit = new JButton(new ImageIcon("images/lol.png"));
	private JButton btnexit = new JButton(new ImageIcon("images/k.png"));
	private JCheckBox btncheck = new JCheckBox(new ImageIcon("images/see.png"));
	private JButton btn_back = new JButton("Back");
	JLabel lbl_time = new JLabel("time");
	private JTextField txtname = new JTextField();
	private JPasswordField txtpass = new JPasswordField();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	private JComboBox<String> cmb_logintype = new JComboBox<String>();
	private JLabel lbl_forgorpassword = new JLabel();
	Databaseconnect connect = new Databaseconnect();// creat class database
	Connection conn;// Connection variable
	String sMSGBOX_TITLE = "Sweets Management System System V. 1.0";
	static Date td = new Date();
	String loginname = "";
	String loginpassword = "";
	String logintype = "";
	int dialogtype = JOptionPane.PLAIN_MESSAGE;
	String dialogmessage;
	String dialogs;
	Font f = new Font("Verdana", Font.BOLD, 17);
	Font f1 = new Font("Verdana", Font.BOLD, 13);
	String forgorpassword = "<html><u>Forgotten Password?</u></html>";

	JLabel lbl_bekeryname = new JLabel(new ImageIcon("images/nice.jpg"));
	JLabel lbl_enter = new JLabel();// 1
	JTextField txt_enter = new JTextField();// 1
	JButton btn_go = new JButton("Go");// 1
	JLabel lbl_enter1 = new JLabel();// 1
	JTextField txt_enter1 = new JTextField();// 1
	JButton btn_go3 = new JButton("Go");// 1

	// 2

	JRadioButton btn_1 = new JRadioButton("white");
	JRadioButton btn_2 = new JRadioButton("Red");
	JRadioButton btn_3 = new JRadioButton("Black");
	JRadioButton btn_4 = new JRadioButton("Null");
	JLabel lbl_chosse = new JLabel();
	JButton btn_go1 = new JButton("Go");
	JButton btn_ok = new JButton("Ok");
	//
	JLabel lbl_succes = new JLabel();
	JLabel lbl_fail = new JLabel();

	//

	String str1, str2, str3;
	String enter = "";
	String enter5 = "";

	//

	public loginframe() {
		try {
			this.adminlog();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error Constructor" + ex.toString());

		}

	}

	public void adminlog() {
		try {
			this.setTitle("LogIn");
			this.setSize(900, 500);
			this.setLayout(null);
			this.setLocation(screenheith / 4, screedwidth / 16);
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					UnloadWindow();
				}
			});
			JPanel panimg = new JPanel();
			Border thickBorder1 = new LineBorder(Color.decode("#875A3C"), 5);

			panimg.setLayout(null);
			panimg.setBounds(7, 60, 251, 405);
			Border thickBorder = new LineBorder(Color.decode("#875A3C"), 16);
         	JLabel lbl_image = new JLabel(new ImageIcon("images/nice.jpg"));
         	

			lbl_image.setBounds(5, 5, 241, 150);
			lbl_image.setBorder(thickBorder1);
			panimg.add(lbl_image);

			lbl_bekeryname.setBounds(5, 160, 240, 150);

			lbl_bekeryname.setBorder(thickBorder1);
			panimg.add(lbl_bekeryname);

			JLabel lbl_man = new JLabel(new ImageIcon("images/home.jpg"));
			lbl_man.setBorder(thickBorder1);
			lbl_man.setBounds(5, 315, 240, 86);
			panimg.add(lbl_man);

			JPanel pan_forgotpassword = new JPanel();
			pan_forgotpassword.setLayout(null);
			pan_forgotpassword.setBounds(5, 160, 241, 140);
			pan_forgotpassword.setBackground(Color.gray);

			TitledBorder emergency_order2 = BorderFactory.createTitledBorder("");
			emergency_order2.setTitleJustification(TitledBorder.LEFT);
			pan_forgotpassword.setBorder(emergency_order2);

			lbl_enter.setText("Enter your Email Address");
			lbl_enter.setBounds(10, 7, 200, 40);
			lbl_enter.setFont(f1);
			lbl_enter.setForeground(Color.WHITE);
			txt_enter.setBounds(10, 50, 200, 30);
			btn_go.setBackground(Color.decode("#35ABD2"));
			btn_go.addActionListener(this);
			btn_go1.addActionListener(this);
			btn_ok.addActionListener(this);
			btn_go3.addActionListener(this);

			lbl_enter1.setText("Enter New Password : ");
			lbl_enter1.setBounds(10, 7, 200, 40);
			lbl_enter1.setFont(f1);
			lbl_enter1.setForeground(Color.WHITE);
			txt_enter1.setBounds(10, 50, 200, 30);
			btn_go3.setBackground(Color.decode("#35ABD2"));
			btn_back.setBackground(Color.decode("#35ABD2"));
			btn_go3.setBounds(170, 96, 40, 25);

			btn_go.setBounds(170, 96, 40, 25);
			btn_back.setBounds(90, 96, 70, 25);
			pan_forgotpassword.add(btn_back);

			pan_forgotpassword.add(btn_go);
			pan_forgotpassword.add(txt_enter);
			pan_forgotpassword.add(lbl_enter);
			pan_forgotpassword.add(btn_go3);
			pan_forgotpassword.add(txt_enter1);
			pan_forgotpassword.add(lbl_enter1);
			// now we are visible false this item

			lbl_chosse.setText("Please Choose Color");
			lbl_chosse.setBounds(10, 5, 200, 40);
			lbl_chosse.setFont(f1);
			lbl_chosse.setForeground(Color.WHITE);
			btn_1.setBounds(30, 47, 70, 15);
			btn_2.setBounds(30, 69, 70, 15);
			btn_3.setBounds(30, 90, 70, 15);
			btn_4.setBounds(30, 109, 70, 15);
			btn_1.setBackground(Color.GRAY);
			btn_2.setBackground(Color.GRAY);
			btn_3.setBackground(Color.GRAY);
			btn_4.setBackground(Color.GRAY);
			btn_1.setForeground(Color.WHITE);
			btn_2.setForeground(Color.WHITE);
			btn_3.setForeground(Color.WHITE);
			btn_4.setForeground(Color.WHITE);
			btn_go1.setBackground(Color.decode("#35ABD2"));
			btn_go1.setBounds(170, 96, 40, 25);
			pan_forgotpassword.add(btn_go1);
			ButtonGroup group = new ButtonGroup();
			group.add(btn_1);
			group.add(btn_2);
			group.add(btn_3);
			group.add(btn_4);
			btn_go3.setVisible(false);
			btn_go1.setVisible(false);
			btn_1.setVisible(false);
			btn_2.setVisible(false);
			btn_3.setVisible(false);
			btn_4.setVisible(false);
			lbl_chosse.setVisible(false);
			lbl_fail.setVisible(false);
			lbl_succes.setVisible(false);
			btn_go.setVisible(false);
			txt_enter.setVisible(false);
			lbl_enter.setVisible(false);
			btn_ok.setVisible(false);
			lbl_succes.setBounds(20, 20, 200, 50);
			lbl_succes.setForeground(Color.WHITE);
			lbl_succes.setFont(f1);
			lbl_succes.setText("Check Password Field !!!");
			pan_forgotpassword.add(lbl_succes);
			lbl_fail.setBounds(20, 20, 200, 50);
			lbl_fail.setForeground(Color.WHITE);

			lbl_fail.setFont(f1);
			lbl_fail.setText("Invalid Email Address !!!");
			pan_forgotpassword.add(lbl_fail);
			btn_ok.setBounds(170, 96, 40, 25);
			btn_ok.setBackground(Color.decode("#35ABD2"));
			pan_forgotpassword.add(btn_ok);

			pan_forgotpassword.add(lbl_chosse);
			pan_forgotpassword.add(btn_1);
			pan_forgotpassword.add(btn_2);
			pan_forgotpassword.add(btn_3);
			pan_forgotpassword.add(btn_4);

			// pan_forgotpassword.add();

			panimg.add(pan_forgotpassword);
			panimg.setBackground(Color.decode("#C8A064"));
			JPanel pan_time = new JPanel();
			pan_time.setBounds(7, 7, 253, 51);
			pan_time.setLayout(new FlowLayout());
			pan_time.setBackground(Color.decode("#875A3C"));
			lbl_time.setForeground(Color.WHITE);
			lbl_time.setFont(f1);
			pan_time.add(lbl_time);
			this.add(pan_time);

			JLabel lblname = new JLabel("Username:");
			JLabel lbl_logintype = new JLabel("LogIn Type");
			JLabel lbl_password = new JLabel("Password:");
			JPanel pantitle = new JPanel();
			pantitle.setLayout(new FlowLayout());
			JLabel lbl_title = new JLabel("User LogIn Panel");// panel title
			pantitle.setBackground(Color.decode("#875A3C"));
			pantitle.setBounds(260, 7, 627, 51);
			pantitle.add(lbl_title);

			lblname.setForeground(Color.WHITE);
			lbl_password.setForeground(Color.WHITE);
			lbl_logintype.setForeground(Color.WHITE);
			btn_back.setVisible(false);
			lblname.setBounds(80, 30, 80, 30);
			JLabel lblpassword = new JLabel("Password: ");
			lblpassword.setBounds(80, 70, 80, 30);
			lbl_logintype.setBounds(80, 110, 80, 30);

			cmb_logintype.addItem("Select Type");
			retrive_logintype(cmb_logintype);

			lbl_title.setFont(f);
			lbl_title.setForeground(Color.WHITE);
			lblname.setFont(f1);
			lblpassword.setFont(f1);
			lbl_logintype.setFont(f1);
			lblpassword.setForeground(Color.WHITE);
			this.add(pantitle);
			txtname.setBounds(220, 30, 180, 30);
			txtpass.setBounds(220, 70, 180, 30);
			cmb_logintype.setBounds(220, 110, 180, 30);
			txtname.setBackground(Color.WHITE);
			txtpass.setBackground(Color.WHITE);
			cmb_logintype.setBackground(Color.WHITE);
			// 875A3C
			//

			btnsubmit.setBounds(220, 170, 180, 30);
			btnsubmit.setBackground(Color.decode("#35ABD2"));
			btncheck.setBounds(400, 75, 20, 20);
			btncheck.setBackground(Color.red);

			btncheck.setBackground(Color.gray);
			Action echo = new Action();
			btnsubmit.addActionListener(echo);
			btnexit.addActionListener(echo);
			btncheck.addActionListener(echo);

			btn_back.addActionListener(echo);

			// btnsubmit.setBackground(Color.);
			btnexit.setBackground(Color.ORANGE);
			txt_enter1.setVisible(false);
			btn_go1.setVisible(false);
			lbl_enter1.setVisible(false);
			btnexit.setText("Exit");
			btnsubmit.setText("LogIn");
			btnexit.setToolTipText("Exit Button");
			btnsubmit.setToolTipText("Submit Button");

			JPanel pan_create = new JPanel();
			pan_create.setBackground(Color.decode("#C8A064"));
			pan_create.setBounds(260, 60, 627, 405);

			lbl_forgorpassword.setBounds(50, 355, 180, 30);
			btnexit.setBounds(470, 355, 70, 20);
			pan_create.add(btnexit);

			lbl_forgorpassword.setFont(f1);
			lbl_forgorpassword.setText(forgorpassword);
			lbl_forgorpassword.setForeground(Color.WHITE);

			lbl_forgorpassword.addMouseListener(this);
			pan_create.add(lbl_forgorpassword);
			pan_create.setLayout(null);
			JPanel pan_internal = new JPanel();
			pan_internal.setBounds(50, 50, 530, 270);
			pan_internal.setLayout(null);
			pan_internal.setBackground(Color.gray);
			pan_internal.add(lblname);
			pan_internal.add(lblpassword);
			pan_internal.add(txtname);
			pan_internal.add(txtpass);
			pan_internal.add(btncheck);
			pan_internal.add(cmb_logintype);
			pan_internal.add(lbl_logintype);

			pan_internal.add(btnsubmit);
			pan_internal.setBorder(thickBorder);
			pan_create.add(pan_internal);
			this.add(pan_create);
			this.add(panimg);
			this.getContentPane().setBackground(Color.black);
			clock();
			this.setVisible(true);
		} catch (Exception ex1) {
			JOptionPane.showMessageDialog(null, "error adminlog" + ex1.toString());

		}

	}

	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					for (;;) {
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);
						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);
						lbl_time.setText("Time : " + hour + " : " + minute + " : " + second + " Date " + year + "/"
								+ month + "/" + day);
						sleep(1000);
					}

				} catch (InterruptedException e) {
					e.printStackTrace();

				}
			}

		};
		clock.start();
	}

	@SuppressWarnings("deprecation")
	public void login() {
		loginname = txtname.getText().trim();
		loginpassword = txtpass.getText().trim();
		logintype = cmb_logintype.getSelectedItem().toString();

		if (loginname.isEmpty() || loginpassword.isEmpty() || logintype.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Some informoation is missing", "WARNING!!!",
					JOptionPane.INFORMATION_MESSAGE);

		} else {

			try {
				conn = connect.setConnection(conn);
			} catch (Exception e) {
			}
			try {

				Statement stmt = conn.createStatement();
				String query = "SELECT * FROM userinfo WHERE user_email='" + loginname + "'AND user_password='"
						+ loginpassword + "'AND userlogintype='" + logintype + "'";

				ResultSet rs = stmt.executeQuery(query);
				boolean recordfound = rs.next();
				if (recordfound) {
					dialogmessage = "Welcome - " + loginname;
					dialogtype = JOptionPane.INFORMATION_MESSAGE;
					JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs, dialogtype);
					txtname.setText("");
					txtpass.setText("");
					this.setVisible(false);
					this.dispose();
					try {
						MainGui menu = new MainGui(loginname, td, logintype);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null,
								"Not Access the MainGui from loginframe gui" + ex.toString());

					}
				} else {

					dialogmessage = "Login Failed!";
					JOptionPane.showMessageDialog(null, "INVALID ID OR PASSWORD!", "WARNING!!",
							JOptionPane.WARNING_MESSAGE);
					txtname.setText("");
					txtpass.setText("");
				}
				conn.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "GENERAL EXCEPTION", "WARNING!!!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void cancel() {
		try {
			int i = JOptionPane.showConfirmDialog(null, "Do you want to Exit?");
			if (i == 0) {
				dispose();
			}

		} catch (Exception ex4) {
			JOptionPane.showMessageDialog(null, "Not work cancelmethod", "WARNING!!!", JOptionPane.INFORMATION_MESSAGE);

		}

	}

	public void seepassword() {
		try {
			if (btncheck.isSelected()) {
				txtpass.setEchoChar((char) 0);
			} else {
				txtpass.setEchoChar('*');
			}
		} catch (Exception ex4) {
			JOptionPane.showMessageDialog(null, "Not work seepasswordmethod", "WARNING!!!",
					JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public static void main(String[] args) {// here i am using lookfeel layout
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			loginframe login = new loginframe();
		} catch (Exception ex2) {
			JOptionPane.showMessageDialog(null, "Error main gui" + ex2.toString());

		}

	}

	class Action implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnsubmit) {
				try {
					login();
				} catch (Exception ex3) {
					JOptionPane.showMessageDialog(null, "Not Access submitbutton", "WARNING!!!",
							JOptionPane.INFORMATION_MESSAGE);

				}

			} else if (e.getSource() == btnexit) {

				try {
					cancel();
				} catch (Exception ex3) {
					JOptionPane.showMessageDialog(null, "Not Access submitbutton", "WARNING!!!",
							JOptionPane.INFORMATION_MESSAGE);

				}
			} else if (e.getSource() == btncheck) {
				try {
					seepassword();
				} catch (Exception ex3) {
					JOptionPane.showMessageDialog(null, "Not Access submitbutton", "WARNING!!!",
							JOptionPane.INFORMATION_MESSAGE);

				}
			} else if (e.getSource() == btn_back) {
				btn_go3.setVisible(false);
				txt_enter1.setVisible(false);
				lbl_enter1.setVisible(false);
				txt_enter.setVisible(false);
				btn_go.setVisible(false);
				lbl_enter.setVisible(false);
				btn_1.setVisible(false);
				btn_2.setVisible(false);
				btn_3.setVisible(false);
				btn_4.setVisible(false);
				lbl_chosse.setVisible(false);
				btn_go1.setVisible(false);
				lbl_bekeryname.setVisible(true);
				btnsubmit.setEnabled(true);
				btn_back.setVisible(false);

			}

		}

	}

	protected void UnloadWindow() {
		try {
			int reply = JOptionPane.showConfirmDialog(this, "Are you sure to exit?", sMSGBOX_TITLE,
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (reply == JOptionPane.YES_OPTION) {
				setVisible(false);
				System.exit(0);
			}
		} catch (Exception e) {
		}

	}// Close the Windows

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
				JOptionPane.showMessageDialog(null, "Update your " + message + " Succefully");
				btn_go3.setVisible(false);
				txt_enter1.setVisible(false);
				lbl_enter1.setVisible(false);
				txt_enter.setVisible(false);
				btn_go.setVisible(false);
				lbl_enter.setVisible(false);
				btn_1.setVisible(false);
				btn_2.setVisible(false);
				btn_3.setVisible(false);
				btn_4.setVisible(false);
				lbl_chosse.setVisible(false);
				btn_go1.setVisible(false);
				lbl_bekeryname.setVisible(true);
				btnsubmit.setEnabled(true);
				btn_back.setVisible(false);
				lbl_forgorpassword.setForeground(Color.WHITE);
				txt_enter1.setText("");
				txt_enter.setText("");

			} else {
				JOptionPane.showMessageDialog(null, "Invalid Email Address!!!!");
				btn_go3.setVisible(false);
				txt_enter1.setVisible(false);
				lbl_enter1.setVisible(false);
				txt_enter.setVisible(true);
				btn_go.setVisible(true);
				lbl_enter.setVisible(true);
				btn_1.setVisible(false);
				btn_2.setVisible(false);
				btn_3.setVisible(false);
				btn_4.setVisible(false);
				lbl_chosse.setVisible(false);
				btn_go1.setVisible(false);
				lbl_bekeryname.setVisible(false);
				btnsubmit.setEnabled(true);
				btn_back.setVisible(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		lbl_forgorpassword.setForeground(Color.green);
		txt_enter.setVisible(true);
		btn_go.setVisible(true);
		lbl_enter.setVisible(true);
		lbl_bekeryname.setVisible(false);
		btnsubmit.setEnabled(false);
		btn_back.setVisible(true);

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

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source.equals(btn_go)) {

			if (!txt_enter.getText().equals("")) {
				enter = "";
				enter = txt_enter.getText().toString();
				btn_go3.setVisible(true);
				txt_enter1.setVisible(true);
				lbl_enter1.setVisible(true);
				txt_enter.setVisible(false);
				btn_go.setVisible(false);
				lbl_enter.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "The Record Field is Empty!!!");
			}

		} else if (source.equals(btn_go3)) {
			enter5 = txt_enter.getText().toString();
			if (enter5.equals("")) {
				JOptionPane.showMessageDialog(null, "The RecordField Is Empty!!!");

			} else {
				enter5 = txt_enter1.getText().toString();
				btn_go3.setVisible(false);
				txt_enter1.setVisible(false);
				lbl_enter1.setVisible(false);
				txt_enter.setVisible(false);
				btn_go.setVisible(false);
				lbl_enter.setVisible(false);
				btn_1.setVisible(true);
				btn_2.setVisible(true);
				btn_3.setVisible(true);
				btn_4.setVisible(true);
				lbl_chosse.setVisible(true);
				btn_go1.setVisible(true);

			}
		} else if (source.equals(btn_go1)) {
			if (!btn_1.isSelected() == false || !btn_2.isSelected() == false || !btn_3.isSelected() == false
					|| !btn_4.isSelected() == false) {
				String temp = "UPDATE userinfo SET " + "user_password = '" + enter5 + "'" + "WHERE user_email = '"
						+ enter + "'";
				executeSQlQuery_CustoemerDetails(temp, "password");

			} else {
				JOptionPane.showMessageDialog(null, "Please Select Color : ");
			}

		}

	}

	public void retrive_logintype(JComboBox<String> cmb) {
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM userinfo";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String type = rs.getString(6).trim();
				cmb.addItem(type);
			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

}
