import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class login_page {

	private JFrame frame;
	private JTextField textUsername;
	private JPasswordField txtPassword;
	protected JFrame frmLoginSystem;
	protected JLabel lblDisplay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_page window = new login_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection conn=null;
	public login_page() throws ClassNotFoundException {
		initialize();
		conn = dbConnectionHelper.Connect();

	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		textUsername.setBounds(386, 140, 242, 31);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("User name :");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(187, 137, 134, 31);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblPassword.setBounds(185, 207, 124, 35);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				    
				    String p=txtPassword.getText();
				    String u=textUsername.getText();
					
			        if(conn != null && p.contains("zabeen") && u.contains("Admin"))
			        {
			        	
			        	JOptionPane.showMessageDialog(null, "Connection Established successfully.");
			        	HomeFrame main;
						try {
							main = new HomeFrame();
				        	main.setVisible(true);

						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			        	System.out.println("Connected");
			        }
			    	
			    	else
			        	JOptionPane.showConfirmDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
				
				
				
			}
		});
		btnLogin.setBounds(227, 296, 112, 31);
		frame.getContentPane().add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLoginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm","Login System",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
						{
					         System.exit(0);
						}
			}
		});
		btnExit.setBounds(386, 296, 104, 31);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_2 = new JLabel("Food Safety Portal");
		lblNewLabel_2.setForeground(Color.CYAN);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 51));
		lblNewLabel_2.setBounds(185, 35, 527, 77);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtPassword.setBounds(386, 212, 242, 31);
		frame.getContentPane().add(txtPassword);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\foodsafetyportal\\hotel.jpg"));
		label.setBounds(0, 0, 734, 461);
		frame.getContentPane().add(label);
	}
}
