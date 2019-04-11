package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import Controller.Databaseconnect;
import Model.CustomerDetailsInfo;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

@SuppressWarnings("serial")
public class CustomerDetails extends JInternalFrame implements ActionListener, MouseListener {
	JFrame JFParentFrame;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	Databaseconnect connect = new Databaseconnect();
	Connection conn;
	// main

	private JButton btn_view = new JButton("Customer");
	private JButton btn_mainmanu = new JButton("Home");

	// first
	JLabel lbl_firstName = new JLabel("First Name");
	JLabel lbl_lastName = new JLabel("Last Name");
	JLabel lbl_nic = new JLabel("NIC");
	JLabel lbl_shopNo = new JLabel("Shop Name");
	JLabel lbl_shopName = new JLabel("Shop No");
	JLabel lbl_sex = new JLabel("Sex");
	JLabel lbl_Email = new JLabel("Phone No");
	JLabel lbl_Steet = new JLabel("Steet No");
	JLabel lbl_city = new JLabel("City");
	JLabel lbl_date = new JLabel("Date");
	JTextField txt_firstName = new JTextField();
	JTextField txt_lastName = new JTextField();
	JTextField txt_nic = new JTextField();
	JTextField txt_shopNo = new JTextField();
	JTextField txt_shopName = new JTextField();
	JComboBox<String> cmb_sex = new JComboBox<String>();
	JTextField txt_Email = new JTextField();
	JTextField txt_Steet = new JTextField();
	JTextField txt_city = new JTextField();
	JDateChooser date = new JDateChooser();
	private JButton btn_add = new JButton("Save");
	private JButton btn_clear = new JButton("Clear");
	// othe frame must disable yyyyyyyyyyyyyyyyyyyyyyyyyyy
	private JButton btn_update = new JButton("Update");
	private JButton btn_delete = new JButton("Delete");
	JLabel lbl_serchbyshop = new JLabel("Serch By ShopName");
	JLabel lbl_searchbyname = new JLabel("Serch By Name");
	JTextField txt_serchbyshop = new JTextField();
	JTextField txt_searchbyname = new JTextField();
	private JButton btn_serchbyshop = new JButton("Search");
	private JButton btn_searchbyname = new JButton("Search");
	private JButton btn_createreport = new JButton("Create Customer Report");
	JPanel pan_serch = new JPanel();

	// other frame must disableyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy

	private JTable customer_table = new JTable();
	private JScrollPane customer_scroll = new JScrollPane();
	//
	String fistname;
	String lastname;
	String NIC;
	String shopname;
	String shopno;
	String sex;
	String email;
	String contactno;
	String streetname;
	String city;
	String image;
	String submitdate;
	String image_path = "";
	SettingManu settings = new SettingManu();

	//
	public CustomerDetails(JFrame getParentFrame) {
		super("Customer Details", true, true, true, true);
		this.setSize(1010, 550);
		this.setLayout(null);
		JPanel pan = new JPanel();
		pan.setLayout(null);
		pan.setBounds(0, 0, 130, 850);

		@SuppressWarnings("unused")
		Border thickBorder1 = new LineBorder(Color.decode("#394B58"), 12);
		btn_view.setBounds(20, 60, 80, 80);

		btn_view.addActionListener(this);
		btn_mainmanu.addActionListener(this);
		btn_update.addActionListener(this);
		btn_delete.addActionListener(this);
		btn_add.addActionListener(this);

		btn_clear.addActionListener(this);
		customer_table.addMouseListener(this);

		btn_view.setBorder(thickBorder1);
		btn_view.setBackground(Color.decode("#250800"));
		btn_view.setForeground(Color.WHITE);
		pan.add(btn_view);

		btn_mainmanu.setBounds(20, 170, 80, 80);

		btn_mainmanu.setBorder(thickBorder1);
		btn_mainmanu.setBackground(Color.decode("#250800"));
		btn_mainmanu.setForeground(Color.WHITE);
		pan.add(btn_mainmanu);

		pan.setBackground(Color.decode("#D2DDF1"));

		JPanel pan_information = new JPanel();
		pan_information.setLayout(null);
		pan_information.setBounds(155, 15, 1185, 300);
		TitledBorder reg_Border = BorderFactory.createTitledBorder("Registation Customer");
		reg_Border.setTitleJustification(TitledBorder.LEFT);
		pan_information.setBorder(reg_Border);
		lbl_firstName.setBounds(20, 30, 100, 30);
		lbl_lastName.setBounds(20, 80, 100, 30);
		lbl_nic.setBounds(20, 130, 100, 30);
		lbl_shopNo.setBounds(20, 180, 100, 30);
		lbl_shopName.setBounds(20, 230, 100, 30);

		lbl_sex.setBounds(350, 30, 100, 30);

		lbl_Email.setBounds(350, 80, 100, 30);
		lbl_Steet.setBounds(350, 130, 100, 30);
		lbl_city.setBounds(350, 180, 100, 30);
		lbl_date.setBounds(350, 230, 100, 30);

		TitledBorder search_Border = BorderFactory.createTitledBorder("Search Customer");
		search_Border.setTitleJustification(TitledBorder.LEFT);
		pan_serch.setBorder(reg_Border);
		pan_serch.setLayout(null);
		pan_serch.setBounds(640, 20, 350, 246);

		cmb_sex.addItem("Select Gender");
		cmb_sex.addItem("Male");
		cmb_sex.addItem("Female");

		lbl_serchbyshop.setBounds(5, 20, 120, 30);
		txt_serchbyshop.setBounds(130, 20, 100, 30);
		btn_searchbyname.setBounds(240, 20, 100, 30);
		lbl_searchbyname.setBounds(5, 80, 120, 30);
		txt_searchbyname.setBounds(130, 80, 100, 30);
		btn_serchbyshop.setBounds(240, 80, 100, 30);
		btn_createreport.setBounds(90, 190, 190, 20);
		btn_createreport.addActionListener(this);
		pan_serch.add(btn_createreport);
		pan_serch.add(lbl_serchbyshop);
		pan_serch.add(txt_serchbyshop);
		pan_serch.add(btn_searchbyname);
		pan_serch.add(lbl_searchbyname);
		pan_serch.add(txt_searchbyname);
		pan_serch.add(btn_serchbyshop);
		btn_searchbyname.addActionListener(this);
		btn_serchbyshop.addActionListener(this);
		pan_information.add(pan_serch);
		cmb_sex.setBounds(470, 30, 150, 30);
		txt_Email.setBounds(470, 80, 150, 30);
		txt_Steet.setBounds(470, 130, 150, 30);
		txt_city.setBounds(470, 180, 150, 30);
		date.setBounds(470, 230, 150, 30);

		btn_add.setBounds(1010, 30, 145, 25);
		btn_clear.setBounds(1010, 70, 145, 25);
		btn_update.setBounds(1010, 110, 145, 25);
		btn_delete.setBounds(1010, 150, 145, 25);

		btn_add.setBackground(Color.ORANGE);
		btn_clear.setBackground(Color.ORANGE);
		btn_update.setBackground(Color.ORANGE);
		btn_delete.setBackground(Color.ORANGE);
		btn_serchbyshop.setBackground(Color.ORANGE);
		btn_searchbyname.setBackground(Color.ORANGE);
		pan_serch.setBackground(Color.WHITE);
		pan_information.setBackground(Color.WHITE);
		cmb_sex.setBackground(Color.WHITE);
		btn_createreport.setBackground(Color.ORANGE);

		pan_information.add(btn_update);
		pan_information.add(btn_delete);

		pan_information.add(btn_add);
		pan_information.add(btn_clear);
		pan_information.add(lbl_Email);
		pan_information.add(lbl_Steet);
		pan_information.add(lbl_city);
		pan_information.add(lbl_date);
		pan_information.add(cmb_sex);
		pan_information.add(txt_Email);
		pan_information.add(txt_Steet);
		pan_information.add(txt_city);
		pan_information.add(date);
		pan_information.add(lbl_firstName);
		pan_information.add(lbl_lastName);
		pan_information.add(lbl_nic);
		pan_information.add(lbl_shopNo);
		pan_information.add(lbl_shopName);
		pan_information.add(lbl_sex);
		pan_information.add(txt_firstName);
		pan_information.add(txt_lastName);
		pan_information.add(txt_nic);
		pan_information.add(txt_shopNo);
		pan_information.add(txt_shopName);
		txt_firstName.setBounds(140, 30, 150, 30);
		txt_lastName.setBounds(140, 80, 150, 30);
		txt_nic.setBounds(140, 130, 150, 30);
		txt_shopNo.setBounds(140, 180, 150, 30);
		txt_shopName.setBounds(140, 230, 150, 30);

		JPanel pan_table = new JPanel();
		pan_table.setBounds(155, 325, 1185, 240);
		pan_table.setBackground(Color.gray);
		pan_table.setLayout(new GridLayout());
		customer_table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "FirstName",
				"LastName", "NIC", "ShopNo", "ShopName", "Sex", "ContactNo", "StreetName", "City", "SubmitDate" }));
		customer_scroll.setViewportView(customer_table);
		pan_table.add(customer_scroll);
		this.add(pan_table);
		this.add(pan_information);

		this.add(pan);
		this.setLocation(screenheith / 7, screedwidth / 27);

		settings.Numvalidator(txt_shopNo);
		settings.Numvalidator(txt_nic);
		settings.Numvalidator(txt_Email);
		settings.Numvalidator1(txt_firstName);
		settings.Numvalidator1(txt_lastName);
		settings.Numvalidator1(txt_city);
		Show_CustomerDetails();
		this.setVisible(true);

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
				// refresh jtable data
				DefaultTableModel model = (DefaultTableModel) customer_table.getModel();
				model.setRowCount(0);
				Show_CustomerDetails();
				reset_Text();

				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// get a list of users from mysql database
	public ArrayList<CustomerDetailsInfo> receivedcustomerinfo() {
		ArrayList<CustomerDetailsInfo> usersList = new ArrayList<CustomerDetailsInfo>();
		Connection connection = getConnection();
		String query = "SELECT * FROM  `customer` ";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			CustomerDetailsInfo user;
			while (rs.next()) {
				user = new CustomerDetailsInfo(rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("nic"), rs.getString("shop_no"), rs.getString("shop_name"), rs.getString("sex"),
						rs.getString("contact_no"), rs.getString("street_name"), rs.getString("city"),
						rs.getString("date"));
				usersList.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public void ShowItem(int index) {

		txt_firstName.setText(receivedcustomerinfo().get(index).getFirstname());
		txt_lastName.setText(receivedcustomerinfo().get(index).getLastname());
		txt_nic.setText(receivedcustomerinfo().get(index).getNIC());
		txt_shopName.setText(receivedcustomerinfo().get(index).getShopname());
		txt_shopNo.setText(receivedcustomerinfo().get(index).getShopno());
		cmb_sex.setSelectedItem(receivedcustomerinfo().get(index).getSex());
		txt_Email.setText(receivedcustomerinfo().get(index).getEmail());
		txt_lastName.setText(receivedcustomerinfo().get(index).getFirstname());
		txt_Steet.setText(receivedcustomerinfo().get(index).getStreetname());
		txt_city.setText(receivedcustomerinfo().get(index).getCity());

	}

	public void Show_CustomerDetails() {
		ArrayList<CustomerDetailsInfo> list = receivedcustomerinfo();
		DefaultTableModel model = (DefaultTableModel) customer_table.getModel();
		Object[] row = new Object[10];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getFirstname();
			row[1] = list.get(i).getLastname();
			row[2] = list.get(i).getNIC();
			row[3] = list.get(i).getShopno();
			row[4] = list.get(i).getShopname();
			row[5] = list.get(i).getSex();
			row[6] = list.get(i).getEmail();
			row[7] = list.get(i).getStreetname();
			row[8] = list.get(i).getCity();
			row[9] = list.get(i).getDate();
			model.addRow(row);
		}
	}

	public ArrayList<CustomerDetailsInfo> product_Received(String serarchproduct) {
		ArrayList<CustomerDetailsInfo> usersList = new ArrayList<CustomerDetailsInfo>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `customer` WHERE CONCAT(`first_name`, `last_name`, `nic`, `shop_no`,`shop_name`,`sex`,`contact_no`,`street_name`,`city`,`date`) LIKE '%"
					+ serarchproduct + "%'";
			rs = st.executeQuery(searchQuery);
			CustomerDetailsInfo user;

			while (rs.next()) {
				user = new CustomerDetailsInfo(rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("nic"), rs.getString("shop_no"), rs.getString("shop_name"), rs.getString("sex"),
						rs.getString("contact_no"), rs.getString("street_name"), rs.getString("city"),
						rs.getString("date"));
				usersList.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	public void find_Receiveproduct() {

		ArrayList<CustomerDetailsInfo> list = product_Received(txt_serchbyshop.getText());// asdjflasjdf;lja;lkdsfjl;k
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "FirstName", "LastName", "NIC", "ShopNo", "ShopName", "Sex",
				"ContactNo", "StreetName", "City", "SubmitDate" });
		Object[] row = new Object[10];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getFirstname();
			row[1] = list.get(i).getLastname();
			row[2] = list.get(i).getNIC();
			row[3] = list.get(i).getShopno();
			row[4] = list.get(i).getShopname();
			row[5] = list.get(i).getSex();
			row[6] = list.get(i).getEmail();
			row[7] = list.get(i).getStreetname();
			row[8] = list.get(i).getCity();
			row[9] = list.get(i).getDate();
			model.addRow(row);
		}
		customer_table.setModel(model);

	}

	public void customerdetails() {
		btn_update.setVisible(true);
		btn_delete.setVisible(true);
		lbl_serchbyshop.setVisible(true);
		lbl_searchbyname.setVisible(true);
		txt_serchbyshop.setVisible(true);
		txt_searchbyname.setVisible(true);
		btn_serchbyshop.setVisible(true);
		btn_searchbyname.setVisible(true);
		btn_createreport.setVisible(true);
		pan_serch.setVisible(true);

	}

	public void add_customerinformation() {
		boolean flag = false;
		fistname = "";
		lastname = "";
		NIC = "";
		shopname = "";
		shopno = "";
		sex = "";
		email = "";
		contactno = "";
		streetname = "";
		city = "";
		image = "";
		fistname = txt_firstName.getText().trim();
		lastname = txt_lastName.getText().trim();
		NIC = txt_nic.getText().trim();
		shopname = txt_shopName.getText().trim();
		shopno = txt_shopNo.getText().trim();
		sex = cmb_sex.getSelectedItem().toString();
		email = txt_Email.getText().trim();
		streetname = txt_Steet.getText().trim();
		city = txt_city.getText().trim();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (date.getDate() == null) {
			JOptionPane.showMessageDialog(null, "The Date Field Must Not Empty!!!!", "Error empty field",
					JOptionPane.ERROR_MESSAGE);

		} else {

			submitdate = dateFormat.format(date.getDate());
		}
		if (fistname.equals("") || lastname.equals("") || NIC.equals("") || shopno.equals("") || shopname.equals("")
				|| sex.equals("") || email.equals("") || streetname.equals("") || city.equals("")) {
			JOptionPane.showMessageDialog(null, "The Record Field Must Not Empty", "WARNING!!!",
					JOptionPane.ERROR_MESSAGE);
		} else if (txt_nic.getText().length() < 9) {

			JOptionPane.showMessageDialog(null, "NIC is not valid !!", "Error NIC", JOptionPane.ERROR_MESSAGE);

		} else if (txt_Email.getText().length() <= 10) {

			JOptionPane.showMessageDialog(null, "Contact Number is not valid!!", "Error ContactNumber",
					JOptionPane.ERROR_MESSAGE);

		} else if (txt_firstName.getText().length() < 3) {

			JOptionPane.showMessageDialog(null, "At least 3 character is allow!!", "Eorror Username",
					JOptionPane.ERROR_MESSAGE);

		} else {
			String query = "INSERT INTO customer VALUES ('" + fistname + "','" + lastname + "','" + NIC + "','" + shopno
					+ "','" + shopname + "','" + sex + "','" + email + "','" + streetname + "','" + city + "','"
					+ submitdate + "')";
			executeSQlQuery_CustoemerDetails(query, "Add");

		}

	}

	public void update_customerinformation() {
		fistname = "";
		lastname = "";
		NIC = "";
		shopname = "";
		shopno = "";
		sex = "";
		email = "";
		streetname = "";
		city = "";

		fistname = txt_firstName.getText().trim();
		lastname = txt_lastName.getText().trim();
		NIC = txt_nic.getText().trim();
		shopname = txt_shopName.getText().trim();
		shopno = txt_shopNo.getText().trim();
		sex = cmb_sex.getSelectedItem().toString();
		email = txt_Email.getText().trim();
		streetname = txt_Steet.getText().trim();
		city = txt_city.getText().trim();

		DateFormat f3 = DateFormat.getDateInstance(DateFormat.LONG);
		if (date.getDate() == null) {
			JOptionPane.showMessageDialog(null, "The Date filed must not empty!!!", "Error date field",
					JOptionPane.ERROR_MESSAGE);

		} else {
			submitdate = f3.format(date.getDate());
		}
		if (fistname.equals("") || lastname.equals("") || NIC.equals("") || shopname.equals("") || sex.equals("")
				|| email.equals("") || streetname.equals("") || city.equals("")) {

			JOptionPane.showMessageDialog(null, "The Record Field Must Not empty!!!", "Error date field",
					JOptionPane.ERROR_MESSAGE);

		} else {

			String temp = "UPDATE customer SET " + "first_name  = '" + fistname + "',last_name = '" + lastname
					+ "',nic = '" + NIC + "',shop_no = '" + shopname + "',shop_name = '" + shopno + "',sex = '" + sex
					+ "',contact_no = '" + email + "',street_name = '" + streetname + "',city = '" + city + "',date = '"
					+ submitdate + "'" + "WHERE shop_no = '" + shopname + "'";

			executeSQlQuery_CustoemerDetails(temp, "Updated");

		}

	}

	public void delete_customerinformation() {

		shopno = "";
		shopno = txt_shopNo.getText().trim();
		if (shopno.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Select Table Row!!!", "Error Delete Button",
					JOptionPane.ERROR_MESSAGE);
		} else {
			String query = "DELETE FROM `customer` WHERE shop_no = " + shopname;
			executeSQlQuery_CustoemerDetails(query, "Deleted Record!!");
		}

	}

	public void reset_Text() {
		txt_firstName.setText("");
		txt_lastName.setText("");
		txt_nic.setText("");
		txt_shopName.setText("");
		txt_shopNo.setText("");
		cmb_sex.setSelectedItem(null);
		txt_Email.setText("");
		txt_lastName.setText("");
		txt_Steet.setText("");
		txt_city.setText("");
		txt_serchbyshop.setText("");
		txt_searchbyname.setText("");

		date.setDate(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(btn_view)) {
			customerdetails();

		} else if (source.equals(btn_mainmanu)) {

			dispose();

		} else if (source.equals(btn_update)) {
			update_customerinformation();

		} else if (source.equals(btn_delete)) {
			delete_customerinformation();

		} else if (source.equals(btn_add)) {

			add_customerinformation();

		} else if (source.equals(btn_clear)) {

			reset_Text();

		} else if (source.equals(btn_searchbyname)) {
			find_Receiveproduct();
		} else if (source.equals(btn_serchbyshop)) {
			find_Receiveproduct();
		}else if(source.equals(btn_createreport)){
			try {
				conn = connect.setConnection(conn);
				JasperDesign jd = JRXmlLoader.load("C:\\Users\\golam\\workspace\\BakeryManagementSystem\\Report\\customer.jrxml");
				JasperReport jr = JasperCompileManager.compileReport(jd);
				JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
				JasperViewer.viewReport(jp, false);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Exception" + ex.toString());

			}


			
			
			
		}

	}

	@Override
	public void mouseClicked(MouseEvent event) {
		int i = customer_table.getSelectedRow();
		// ShowItem(i);
		TableModel model = customer_table.getModel();
		txt_firstName.setText(model.getValueAt(i, 0).toString());
		txt_lastName.setText(model.getValueAt(i, 1).toString());
		txt_nic.setText(model.getValueAt(i, 2).toString());
		txt_shopName.setText(model.getValueAt(i, 3).toString());
		txt_shopNo.setText(model.getValueAt(i, 4).toString());
		cmb_sex.setSelectedItem(model.getValueAt(i, 5).toString());
		txt_Email.setText(model.getValueAt(i, 6).toString());

		txt_Steet.setText(model.getValueAt(i, 7).toString());
		txt_city.setText(model.getValueAt(i, 8).toString());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date addDate = new Date();
		try {
			addDate = dateFormat.parse((String) model.getValueAt(i, 9));
			date.setDate(addDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// byte[] img = rs.getBytes("Image");
		// ImageIcon image = new ImageIcon(img);
		// Image im = image.getImage();
		// Image myimg = im.getScaledInstance(lblimage.getWidth(),
		// lblimage.getHeight(),
		// Image.SCALE_AREA_AVERAGING);
		// ImageIcon newImage = new ImageIcon(myimg);
		// String txt_name = rs.getString(1).trim();
		// String txt_username = rs.getString(2).trim();
		// String txt_password = rs.getString(3).trim();
		// name.setText(txt_name);
		// username.setText(txt_username);
		// password.setText(txt_password);
		// lblimage.setIcon(newImage);
		//

		// ImageIcon myIcon = (ImageIcon) lbl_picture(model.getValueAt(i, 10));
		// Image img2 =
		// myIcon.getImage().getScaledInstance(lbl_picture.getWidth(),
		// lbl_picture.getHeight(),
		// Image.SCALE_SMOOTH);
		// ImageIcon image3 = new ImageIcon(img2);
		// lbl_picture.setIcon((image3));

		// ImageIcon image = (ImageIcon) customer_table.getValueAt(i, 10);

		//
		//
		// lbl_picture = new JButton(new ImageIcon("images/lol.png"));
		// lbl_picture=ImageIcon("");
		//
		// lbl_picture.setIconTextGap( model.getValueAt(i, 10).getClass());

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
}
