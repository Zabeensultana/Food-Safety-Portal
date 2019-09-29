import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class VisitorFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisitorFrame frame = new VisitorFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection conn=null;
	private JTextField tf5;
	
	public VisitorFrame() throws ClassNotFoundException {
		Initialize();
		conn=dbConnectionHelper.Connect();
	}
	
	private void Initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tf1.setBounds(221, 101, 206, 32);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Customer Feed Back Form");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 35));
		lblNewLabel.setBounds(94, 11, 465, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(42, 113, 67, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Email-id");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblName.setBounds(42, 157, 80, 20);
		contentPane.add(lblName);
		
		JLabel lblEmailid = new JLabel("Phone_no");
		lblEmailid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmailid.setBounds(42, 200, 80, 20);
		contentPane.add(lblEmailid);
		
		JLabel lblPhno = new JLabel("Resturant_id");
		lblPhno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPhno.setBounds(42, 289, 153, 20);
		contentPane.add(lblPhno);
		
		JLabel lblFoodQuality = new JLabel("Food Quality");
		lblFoodQuality.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblFoodQuality.setBounds(42, 243, 120, 20);
		contentPane.add(lblFoodQuality);
		
		JTextArea tf6 = new JTextArea();
		tf6.setForeground(SystemColor.controlHighlight);
		tf6.setLineWrap(true);
		tf6.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		tf6.setText("Suggestion");
		tf6.setBounds(458, 88, 225, 234);
		contentPane.add(tf6);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tf2.setColumns(10);
		tf2.setBounds(221, 144, 206, 33);
		contentPane.add(tf2);
		
		tf3 = new JTextField();
		tf3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tf3.setColumns(10);
		tf3.setBounds(221, 188, 206, 32);
		contentPane.add(tf3);
		
		tf4 = new JTextField();
		tf4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tf4.setColumns(10);
		tf4.setBounds(221, 274, 206, 35);
		contentPane.add(tf4);
		
		tf5 = new JTextField();
		tf5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tf5.setBounds(221, 231, 206, 32);
		contentPane.add(tf5);
		tf5.setColumns(10);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String n = tf1.getText();
					String email = tf2.getText();
					String no = tf3.getText();
					String rest_id = tf4.getText();
					String qof = tf5.getToolTipText(null);
					String sugg = tf6.getText();
					
					PreparedStatement ps = conn.prepareStatement( "insert into customer(cust_name,email,ph_no,QualityOfFood,rest_id,feedback) values(?,?,?,?,?,?)");
					ps.setString(1, n);
		    	      ps.setString(2, email);
		    	      ps.setString(3, no);
						ps.setString(4, qof);
						ps.setString(5, rest_id);
						ps.setString(6,sugg);

		    	      int status = ps.executeUpdate();

		    	      JOptionPane.showMessageDialog(null, "Successfully inserted");
				
		    	      ps.close();
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
					System.out.println(e2);
				}
				
				
				
				
			}
		});
		btnNewButton.setBounds(193, 357, 125, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmLoginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm","Login System",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
						{
					         System.exit(0);
						}
			}
		});
		btnNewButton_1.setBounds(381, 357, 131, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\foodsafetyportal\\sCmj0Wq.jpg"));
		lblNewLabel_2.setBounds(0, 0, 734, 461);
		contentPane.add(lblNewLabel_2);
		
		
		
		
	}
}
