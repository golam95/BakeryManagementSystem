package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.Databaseconnect;
import Model.TrakingInformation;

public class TrakingView extends JInternalFrame implements ActionListener, MouseListener {
	Connection conn;
	Databaseconnect connect = new Databaseconnect();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	private JButton btn_delete = new JButton("Delete History");
	private JButton btn_exit = new JButton("Exit");
	private JTextField txt_delete = new JTextField(20);
	private JTable table_history = new JTable();
	private JScrollPane pane_history = new JScrollPane();
	private JPanel pan_mainbody = new JPanel();

	public TrakingView(JFrame getParentFrame) {
		super("History", true, true, true, true);
		this.setSize(1010, 550);
		this.setLayout(null);
		pan_mainbody.setLayout(new GridLayout(0, 1));
		pan_mainbody.setBounds(80, 50, 1215, 470);
		Border thickBorder = new LineBorder(Color.decode("#394B58"), 25);
		pan_mainbody.setBorder(thickBorder);
		pan_mainbody.setBackground(Color.GRAY);
		table_history.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Serial No", "User Name", "Track Field", "Create Date", "Status" }));
		table_history.addMouseListener(this);
		pane_history.setViewportView(table_history);
		table_history.setBackground(Color.WHITE);
		pan_mainbody.add(pane_history);
		JPanel pan8 = new JPanel();
		pan8.setBounds(600, 530, 250, 30);
		pan8.setLayout(new GridLayout(0, 2));
		txt_delete.setBounds(600, 10, 180, 30);
		txt_delete.setVisible(false);
		btn_delete.addActionListener(this);
		btn_exit.addActionListener(this);
		pan8.add(btn_exit);
		pan8.add(btn_delete);
		this.add(pan8);
		this.add(txt_delete);
		this.add(pan_mainbody);
		Show_productreceivemod();
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

	public void executeSQlQuery_customerOrder(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {

				DefaultTableModel model = (DefaultTableModel) table_history.getModel();
				model.setRowCount(0);
				Show_productreceivemod();// get the tabel
				click_reset();
				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");

			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// get a list of users from mysql database
	public ArrayList<TrakingInformation> receiveorderinfo() {
		ArrayList<TrakingInformation> usersList = new ArrayList<TrakingInformation>();
		Connection connection = getConnection();
		String query = "SELECT * FROM  `history`";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			TrakingInformation user;
			while (rs.next()) {
				user = new TrakingInformation(rs.getInt("trackId"), rs.getString("track_name"),
						rs.getString("issue_name"), rs.getString("create_date"), rs.getString("Status"));

				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	// Display Data In JTable

	public void Show_productreceivemod() {
		ArrayList<TrakingInformation> list = receiveorderinfo();
		DefaultTableModel model = (DefaultTableModel) table_history.getModel();
		Object[] row = new Object[5];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getTrackid();
			row[1] = list.get(i).getUsername();
			row[2] = list.get(i).getIssuename();
			row[3] = list.get(i).getCreateddate();
			row[4] = list.get(i).getStatus();
			model.addRow(row);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int i = table_history.getSelectedRow();
		TableModel model = table_history.getModel();
		txt_delete.setText(model.getValueAt(i, 0).toString());
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
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(btn_delete)) {
			if (txt_delete.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please select Table Row");

			} else {
				String str = "";
				str = "";
				str = txt_delete.getText().trim();
				String query = "DELETE FROM `history` WHERE trackId = " + str;
				executeSQlQuery_customerOrder(query, "Deleted Record!!");

			}

		} else if (source.equals(btn_exit)) {
			dispose();
			this.setVisible(false);

		}

	}

	public void click_reset() {
		txt_delete.setText("");

	}

}
