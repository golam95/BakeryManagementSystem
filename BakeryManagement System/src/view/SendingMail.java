package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.Databaseconnect;

public class SendingMail extends JInternalFrame implements ActionListener {
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	Databaseconnect connect = new Databaseconnect();
	Connection conn;
	private JButton btn_attach = new JButton("Attach File");
	private JButton btn_email = new JButton("Send");
	String attachmen_path;
	private static final long serialVersionUID = 1L;
	//
	JComboBox<String> cmb_email = new JComboBox<String>();
	private JTextField txt_filepath = new JTextField();
	JTextField txt_formatename = new JTextField();
	JTextField txt_to = new JTextField();
	JTextField txt_subject = new JTextField();
	JTextArea txt_comment = new JTextArea();

	public SendingMail(JFrame getParentFrame) {
		super("Sending Mail", false, true, false, true);
		try {
			this.setSize(900, 400);
			this.setLocation(screenheith / 2, screedwidth / 15);
			this.setLayout(null);
			this.setResizable(false);
			JPanel pan_left = new JPanel();
			pan_left.setBounds(30, 30, 830, 310);
			pan_left.setBackground(Color.WHITE);
			pan_left.setLayout(null);
			JPanel pan_button = new JPanel();
			pan_button.setLayout(null);
			pan_button.setBounds(20, 18, 510, 275);
			pan_button.setBackground(Color.decode("#FFE4B5"));
			JLabel lbl_to = new JLabel("To");
			JLabel lbl_subject = new JLabel("Subject");
			JLabel lbl_comment = new JLabel("Comment");
			lbl_to.setBounds(15, 20, 40, 30);
			txt_to.setBounds(90, 20, 150, 30);
			lbl_subject.setBounds(15, 70, 70, 30);
			txt_subject.setBounds(90, 70, 250, 30);
			lbl_comment.setBounds(15, 120, 70, 30);
			txt_comment.setBounds(90, 120, 350, 140);
			pan_button.add(lbl_comment);
			pan_button.add(txt_comment);
			pan_button.add(lbl_to);
			pan_button.add(txt_to);
			pan_button.add(lbl_subject);
			pan_button.add(txt_subject);
			JLabel lbl_year = new JLabel("Select Email");
			JPanel pan_search = new JPanel();
			pan_search.setLayout(null);
			pan_search.setBounds(550, 18, 255, 275);
			pan_search.setBackground(Color.decode("#FFE4B5"));
			lbl_year.setBounds(15, 20, 100, 30);
			cmb_email.setBounds(90, 20, 160, 30);
			cmb_email.setBackground(Color.WHITE);
			cmb_email.addActionListener(this);
			retrive_email(cmb_email);
			btn_attach.setBounds(15, 220, 105, 30);
			btn_email.setBounds(135, 220, 105, 30);
			btn_attach.addActionListener(this);
			btn_email.addActionListener(this);
			
			btn_attach.setBackground(Color.ORANGE);
			btn_email.setBackground(Color.ORANGE);
			
			pan_search.add(btn_attach);
			pan_search.add(btn_email);
			JLabel lbl_filepath = new JLabel("File Path");
			JLabel lbl_formatename = new JLabel("File Name");
			lbl_filepath.setBounds(15, 70, 100, 30);
			txt_filepath.setBounds(90, 70, 150, 30);
			lbl_formatename.setBounds(15, 120, 100, 30);
			txt_formatename.setBounds(90, 120, 150, 30);
			pan_search.add(lbl_formatename);
			pan_search.add(txt_formatename);
			pan_search.add(lbl_filepath);
			pan_search.add(txt_filepath);
			pan_search.add(cmb_email);
			pan_search.add(lbl_year);
			pan_left.add(pan_search);
			pan_left.add(pan_button);
			this.add(pan_left);
			this.getContentPane().setBackground(Color.decode("#875A3C"));
			this.setVisible(true);
		} catch (Exception er) {
			JOptionPane.showMessageDialog(null, "Some information is missing");

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(btn_attach)) {
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			File f = chooser.getSelectedFile();
			attachmen_path = f.getAbsolutePath();
			txt_filepath.setText(attachmen_path);

		} else if (source.equals(btn_email)) {
			String To = txt_to.getText().toString();
			String subject = txt_subject.getText().toString();
			String comment = txt_comment.getText().toString();

			if (To.equals("") || subject.equals("") || comment.equals("") || txt_filepath.getText().equals("")
					|| txt_formatename.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Field Must Not Empty!!");

			} else {

				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "465");
				Session session = Session.getDefaultInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("golamnobi280@gmail.com", "sager1.z");
					}
				}

				);

				try {
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("golamnobi280@gmail.com"));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
					message.setSubject(subject);
					MimeBodyPart messageBodyPart = new MimeBodyPart();
					messageBodyPart.setText(comment);
					Multipart multipart = new MimeMultipart();
					multipart.addBodyPart(messageBodyPart);
					messageBodyPart = new MimeBodyPart();
					javax.activation.DataSource email_source = new FileDataSource(attachmen_path);
					messageBodyPart.setDataHandler(new DataHandler(email_source));
					messageBodyPart.setFileName(txt_filepath.getText());
					multipart.addBodyPart(messageBodyPart);
					message.setContent(multipart);
					Transport.send(message);
					JOptionPane.showMessageDialog(null, "Message send succefully");
					reset();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}
			}

		} else if (source.equals(cmb_email)) {
			String str = cmb_email.getSelectedItem().toString();
			txt_to.setText(str);

		}

	}

	public void reset() {
		txt_filepath.setText("");
		txt_formatename.setText("");
		txt_to.setText("");
		txt_subject.setText("");
		txt_comment.setText("");

	}

	public void retrive_email(JComboBox<String> cmb) {

		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM emergency_contact";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String email = rs.getString(5).trim();
				cmb.addItem(email);
			}
			conn.close();
		}

		catch (Exception ex) {

		}

	}

}
