package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class DatabaseBackup extends JInternalFrame implements ActionListener {
	Border thickBorder = new LineBorder(Color.WHITE, 23);
	private JButton btn_browse1 = new JButton("Browse");
	private JButton btn_backup = new JButton("Backup");
	private JTextField txt_browse1 = new JTextField();
	private JButton btn_browse2 = new JButton("Browse");
	private JButton btn_restore = new JButton("Restore");
	private JTextField txt_browse2 = new JTextField();
	String path = null;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;

	public DatabaseBackup(JFrame getParentFrame) {
		super("Database Backup", true, true, false, true);
		this.setSize(450, 250);
		this.setLayout(new GridLayout());
		this.setResizable(false);
		this.setLocation(screenheith / 2, screedwidth / 15);
		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = createImageIcon("");
		JComponent panel1 = makeTextPanel("");
		panel1.setBackground(Color.decode("#875A3C"));
		panel1.setLayout(null);
		JPanel pan_autoreminder = new JPanel();
		pan_autoreminder.setBounds(20, 20, 395, 155);
		pan_autoreminder.setLayout(null);
		pan_autoreminder.setBackground(Color.decode("#FFE4B5"));
		pan_autoreminder.setBorder(thickBorder);
		pan_autoreminder.setLayout(null);
		JLabel lbl_change = new JLabel("Backup Database");
		lbl_change.setBounds(30, 40, 130, 30);
		txt_browse1.setBounds(140, 40, 220, 30);
		btn_browse1.setBounds(140, 90, 100, 30);
		btn_backup.setBounds(260, 90, 100, 30);
		btn_backup.setBackground(Color.ORANGE);
		btn_browse1.setBackground(Color.ORANGE);
		pan_autoreminder.add(lbl_change);
		pan_autoreminder.add(txt_browse1);
		pan_autoreminder.add(btn_browse1);
		pan_autoreminder.add(btn_backup);
		panel1.add(pan_autoreminder);
		tabbedPane.addTab("BackUp Database", icon, panel1, "Stock Setting");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		JComponent panel2 = makeTextPanel("");
		panel2.setBackground(Color.decode("#875A3C"));
		panel2.setLayout(null);
		JPanel pan_autoreminder2 = new JPanel();
		pan_autoreminder2.setBounds(20, 20, 395, 155);
		pan_autoreminder2.setLayout(null);
		pan_autoreminder2.setBackground(Color.decode("#FFE4B5"));
		pan_autoreminder2.setBorder(thickBorder);
		pan_autoreminder2.setLayout(null);
		JLabel lbl_change1 = new JLabel("Restore Database");
		pan_autoreminder2.add(lbl_change1);
		lbl_change1.setBounds(30, 40, 130, 30);
		txt_browse2.setBounds(140, 40, 220, 30);
		btn_browse2.setBounds(140, 90, 100, 30);
		btn_restore.setBounds(260, 90, 100, 30);
		btn_restore.setBackground(Color.ORANGE);
		btn_browse2.setBackground(Color.ORANGE);
		btn_browse2.setForeground(Color.black);
		btn_browse2.addActionListener(this);
		btn_browse1.addActionListener(this);
		btn_restore.addActionListener(this);
		btn_backup.addActionListener(this);
		
		txt_browse2.setEditable(false);
		txt_browse1.setEditable(false);
		
		pan_autoreminder2.add(btn_restore);
		pan_autoreminder2.add(txt_browse2);
		pan_autoreminder2.add(btn_browse2);
		panel2.add(pan_autoreminder2);
		tabbedPane.addTab("Restore Database", icon, panel2, "Setting Screen Capture");
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

		if (source.equals(btn_browse2)) {
			txt_browse2.setEditable(true);
			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(this);
			try {
				File f = fc.getSelectedFile();
				path = f.getAbsolutePath();
				path = path.replace('\\', '/');
				txt_browse2.setText(path);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (source.equals(btn_browse1)) {// browse for the backup
												// database
			txt_browse1.setEditable(true);
			
			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(this);
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

			try {
				File f = fc.getSelectedFile();
				path = f.getAbsolutePath();
				path = path.replace('\\', '/');
				path = path + "_" + date + ".sql";
				txt_browse1.setText(path);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (source.equals(btn_restore)) {// restore datavbase
			String dbUserName = "root";// username
			String dbPassword = "";// Password

			String[] restoreCmd = new String[] { "E:/xampp/mysql/bin/mysql.exe ", "--user=" + dbUserName,
					"--password=" + dbPassword, "-e", "source " + path };
			Process runtimProcess;
			try {
				runtimProcess = Runtime.getRuntime().exec(restoreCmd);
				int proceCom = runtimProcess.waitFor();

				if (proceCom == 0) {
					JOptionPane.showMessageDialog(null, "Restore Create Succefully");
					txt_browse2.setText("");

				} else {
					JOptionPane.showMessageDialog(null, "Can't Restored");
					txt_browse2.setText("");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (source.equals(btn_backup)) {// database backup button
			Process p = null;
			try {
				Runtime runtime = Runtime.getRuntime();
				p = runtime.exec("E:/wamp64/bin/mysql/mysql5.7.14/bin/mysqldump.exe -uroot" + ""
						+ " --add-drop-database -B bakerymanagement -r" + path);
				
				
				

				int processComplete = p.waitFor();
				if (processComplete == 0) {
					JOptionPane.showMessageDialog(null, "Backup Create Succuss");
					txt_browse1.setText("");

				} else {
					JOptionPane.showMessageDialog(null, "Not Create Database Backup");
					txt_browse1.setText("");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

		}

	}

}
