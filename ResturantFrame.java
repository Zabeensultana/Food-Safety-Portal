import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.driver.Const;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ResturantFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	protected JLabel tfx;
    Scanner sc = new Scanner(System.in);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResturantFrame frame = new ResturantFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * Create the frame.
	 *
	 */
	Connection conn=null;
	public ResturantFrame() throws ClassNotFoundException {
		Initialize();
		conn = dbConnectionHelper.Connect();
	}
		
	private void Initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResturantInformation = new JLabel("Enter Resturant Information");
		lblResturantInformation.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblResturantInformation.setBounds(68, 37, 533, 29);
		contentPane.add(lblResturantInformation);
		
		JLabel resid = new JLabel("Resturant_id");
		resid.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		resid.setBounds(10, 141, 118, 22);
		contentPane.add(resid);
		
		JLabel resName = new JLabel("Resturant Name");
		resName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		resName.setBounds(10, 223, 118, 22);
		contentPane.add(resName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAddress.setBounds(10, 306, 98, 22);
		contentPane.add(lblAddress);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tf1.setBounds(156, 133, 158, 29);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tf2.setBounds(156, 215, 158, 29);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		JTextArea tf3 = new JTextArea();
		tf3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tf3.setBounds(156, 290, 158, 58);
		contentPane.add(tf3);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tf1.getText();
				String name = tf2.getText();
				String ad = tf3.getText();
				try {
					PreparedStatement ps = conn.prepareStatement( "insert into resturant(resturant_id,resturant_name,address) values(?,?,?)");
					  ps.setString(1, id);
		    	      ps.setString(2, name);
		    	      ps.setString(3, ad);
		    	      int status = ps.executeUpdate();

		    	      JOptionPane.showMessageDialog(null, "Successfully inserted");
				
		    	      ps.close();
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
		    	      JOptionPane.showMessageDialog(null, e1);

					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(176, 385, 104, 29);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmLoginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm","Login System",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
						{
					         System.exit(0);
						}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setBounds(366, 385, 104, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\foodsafetyportal\\sCmj0Wq.jpg"));
		lblNewLabel.setBounds(0, 0, 734, 461);
		contentPane.add(lblNewLabel);
		
	}
}
