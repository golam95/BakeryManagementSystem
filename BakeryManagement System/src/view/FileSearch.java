
package view;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.Databaseconnect;
import Model.FileInformation;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;

class FileSearch extends JFrame implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;

	Connection conn;
	Databaseconnect connect = new Databaseconnect();

	private String MAINPATH = "C:\\"; // Default path on start up.
	boolean FolderSystem;
	File mainFile;
	@SuppressWarnings("rawtypes")
	DefaultListModel listModel = new DefaultListModel();
	JPanel northPanel = new JPanel(new FlowLayout());
	JPanel southPanel, mainPanel, centerPanel;
	JLabel lblFilename;
	JLabel lblPath;
	JButton searchButton = new JButton("Search");
	JButton runButton = new JButton("Run");
	JButton fileButton = new JButton("Select Folder");
	JButton btn_delete = new JButton("Delete");
	JButton btn_exit = new JButton("Exit");
	String str1;
	JTextField txt_delete = new JTextField(20);
	JTextField searchField = new JTextField(20);
	@SuppressWarnings("unchecked")
	JList<String> searchList = new JList<String>(listModel);
	JScrollPane scrollList = new JScrollPane(searchList);
	JFileChooser filechooser = new JFileChooser();
	private JTable table = new JTable();
	private JScrollPane pane = new JScrollPane();
	ButtonGroup btGroup;
	Container con;

	public FileSearch() {

		super("Search File");
		// Default path on start up.
		FolderSystem = true;
		lblPath = new JLabel();
		lblFilename = new JLabel("File/Foler Name : ");
		this.setSize(900, 330);
		this.setLocation(screenheith / 4, screedwidth / 7);
		this.setLayout(null);
		this.setResizable(false);
		JPanel pan_left1 = new JPanel();
		pan_left1.setBounds(30, 30, 830, 240);
		pan_left1.setBackground(Color.decode("#C8A064"));
		pan_left1.setLayout(null);
		JPanel pan_button1 = new JPanel();
		pan_button1.setLayout(null);
		pan_button1.setBounds(20, 20, 200, 205);
		pan_button1.setBackground(Color.decode("#FFE4B5"));
		searchButton.setBounds(30, 10, 130, 30);
		runButton.setBounds(30, 50, 130, 30);
		fileButton.setBounds(30, 90, 130, 30);
		btn_delete.setBounds(30, 130, 130, 30);
		btn_exit.setBounds(30, 170, 130, 30);
		btn_delete.addActionListener(this);
		runButton.addActionListener(this);
		searchButton.addActionListener(this);
		fileButton.addActionListener(this);
		btn_exit.addActionListener(this);
		table.addMouseListener(this);
		txt_delete.setVisible(false);/////// id here false so what

		searchButton.setBackground(Color.gray);
		runButton.setBackground(Color.gray);
		fileButton.setBackground(Color.gray);
		btn_delete.setBackground(Color.gray);
		btn_exit.setBackground(Color.gray);

		btn_exit.setForeground(Color.WHITE);
		runButton.setForeground(Color.WHITE);
		fileButton.setForeground(Color.WHITE);
		btn_delete.setForeground(Color.WHITE);
		searchButton.setForeground(Color.WHITE);

		pan_button1.add(searchButton);
		pan_button1.add(runButton);
		pan_button1.add(fileButton);
		pan_button1.add(btn_delete);
		pan_button1.add(btn_exit);

		JPanel pan_search = new JPanel();
		pan_search.setLayout(null);
		pan_search.setBounds(245, 20, 345, 205);
		pan_search.setBackground(Color.decode("#FFE4B5"));
		lblFilename.setBounds(30, 20, 100, 30);
		searchField.setBounds(140, 20, 180, 30);
		lblPath.setBounds(10, 60, 325, 20);
		scrollList.setBounds(10, 90, 325, 100);

		pan_search.add(lblFilename);
		pan_search.add(searchField);
		pan_search.add(lblPath);
		pan_search.add(scrollList);
		JPanel pan_button = new JPanel();
		pan_button.setLayout(new GridLayout(0, 1));
		table.setModel(
				new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "S.No", "File Name" }));
		pane.setViewportView(table);

		pan_button.add(pane);

		pan_button.setBounds(610, 20, 200, 205);
		pan_button.setBackground(Color.decode("#FFE4B5"));
		pan_left1.add(pan_button);

		pan_left1.add(pan_search);
		pan_left1.add(pan_button1);
		txt_delete.setBounds(102, 2, 40, 30);

		this.add(txt_delete);
		this.add(pan_left1);
		this.getContentPane().setBackground(Color.decode("#875A3C"));
		filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		Show_productreceivemod();

		con = getContentPane();
		scrollList.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Search Result"));
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

	public void executeSQlQuery_file(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				Show_productreceivemod();// get the tabel
				// click_reset();

				JOptionPane.showMessageDialog(null, "File " + message + " Succefully");
			} else {
				JOptionPane.showMessageDialog(null, "File Not " + message);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// get a list of users from mysql database
	public ArrayList<FileInformation> receiveorderinfo() {
		ArrayList<FileInformation> usersList = new ArrayList<FileInformation>();
		Connection connection = getConnection();
		String query = "SELECT * FROM  `File`";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			FileInformation user;
			while (rs.next()) {
				user = new FileInformation(rs.getInt("fileid"), rs.getString("filename"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	// Display Data In JTable

	public void Show_productreceivemod() {
		ArrayList<FileInformation> list = receiveorderinfo();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[2];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getFileid();
			row[1] = list.get(i).getFilename();
			model.addRow(row);
		}
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
		if ((e.getSource() == searchButton)) {
			if (searchField.getText().equals("")) {

				JOptionPane.showMessageDialog(this, "Text Field Must Not Empty!!!", "Error Search Button",
						JOptionPane.ERROR_MESSAGE);
			} else {
				listModel.clear();
				if (FolderSystem) {
					mainFile = new File(MAINPATH);
					new SearchFile(mainFile, searchField.getText().trim(), listModel, lblPath);
				} else {
					File[] roots = File.listRoots();
					for (int i = 0; i < roots.length; i++)
						new SearchFile(roots[i], searchField.getText().trim(), listModel, lblPath);
				}
			}

		} else if ((e.getSource().equals(runButton))) {
			if (listModel.size() > 0) {

				// System.out.println((String)
				// (listModel.get(searchList.getSelectedIndex())));

				try {
					Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL "
							+ (String) (listModel.get(searchList.getSelectedIndex())));
				} catch (Exception exception) {
					// System.out.println("An error occured trying to execute
					// file.");
				}
			} else
				JOptionPane.showMessageDialog(this, "There is no selected list Item To Run", "Error in List item",
						JOptionPane.ERROR_MESSAGE);
		}
		if ((e.getSource().equals(fileButton))) {
			int i = filechooser.showOpenDialog(this);
			if (i == JFileChooser.APPROVE_OPTION) {
				MAINPATH = filechooser.getSelectedFile().getAbsolutePath() + "\\";

			}
		} else if (e.getSource().equals(btn_exit)) {
			this.setVisible(false);
			dispose();

		} else if (e.getSource().equals(btn_delete)) {

			if (txt_delete.getText().equals("")) {

				JOptionPane.showMessageDialog(this, "Please Select Table Row!!!", "Error Delete Button",
						JOptionPane.ERROR_MESSAGE);

			} else {
				String str;
				str = "";
				str = txt_delete.getText().toString();
				String query = "DELETE FROM `File` WHERE fileid = " + str;
				executeSQlQuery_file(query, "Deleted !!");

			}

		}
	}

	class SearchFile extends Thread {
		File Filedir;
		String Filename;
		DefaultListModel<String> listmodel;
		JLabel lblpath;

		public SearchFile(File d, String n, DefaultListModel<String> dm, JLabel l) {
			Filedir = d;
			Filename = n;
			listmodel = dm;
			lblpath = l;
			this.start();
		}

		// this is a recursive file search function
		public void run() {
			search(Filedir, Filename, listmodel, lblpath);
			if (listmodel.size() > 0) {
				searchList.setSelectedIndex(0);
			}
		}

		private void search(File dir, String name, DefaultListModel<String> model, JLabel lb) {
			lb.setText(dir.getAbsolutePath());

			if (dir.getName().toLowerCase().equals(name.toLowerCase())) {

				model.addElement(dir.getAbsolutePath());
				System.out.println(dir.getAbsolutePath());
			} else if (dir.isDirectory()) {
				String[] children = dir.list();
				for (int i = 0; i < children.length; i++) {
					search(new File(dir, children[i]), name, model, lb);
				}

			}
		}
	}// end of class Search File

	@Override
	public void mouseClicked(MouseEvent e) {
		//
		int i = table.getSelectedRow();
		TableModel model = table.getModel();
		txt_delete.setText(model.getValueAt(i, 0).toString());
		searchField.setText(model.getValueAt(i, 1).toString());
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