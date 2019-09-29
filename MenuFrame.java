import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class MenuFrame extends JFrame {

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
					MenuFrame frame = new MenuFrame();
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
	private JLabel lblNewLabel_1;
	public MenuFrame() throws ClassNotFoundException {
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
		
		JLabel lblNewLabel = new JLabel("Enter Menu For Perticular Resturant");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 35));
		lblNewLabel.setBounds(66, 26, 645, 45);
		contentPane.add(lblNewLabel);
		
		tf1 = new JTextField();
		tf1.setForeground(SystemColor.controlHighlight);
		tf1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tf1.setText("Enter Menu_id");
		tf1.setBounds(33, 94, 284, 37);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setForeground(SystemColor.controlHighlight);
		tf2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tf2.setText("Enter Dish Name");
		tf2.setColumns(10);
		tf2.setBounds(33, 157, 284, 37);
		contentPane.add(tf2);
		
		tf3 = new JTextField();
		tf3.setForeground(SystemColor.controlHighlight);
		tf3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tf3.setText("Enter Price");
		tf3.setColumns(10);
		tf3.setBounds(33, 222, 284, 37);
		contentPane.add(tf3);
		
		tf4 = new JTextField();
		tf4.setForeground(SystemColor.controlHighlight);
		tf4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tf4.setText("Enter Resturant_id");
		tf4.setColumns(10);
		tf4.setBounds(33, 288, 284, 37);
		contentPane.add(tf4);
		
		JButton btnSubmit = new JButton("Insert");
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tf1.getText();
				String name = tf2.getText();
				String ad = tf3.getText();
				String rest_id =tf4.getText();
				try {
					PreparedStatement ps = conn.prepareStatement( "insert into menu(menu_id,dish_name,price,resturant_id) values(?,?,?,?)");
					  ps.setString(1, id);
		    	      ps.setString(2, name);
		    	      ps.setString(3, ad);
		    	      ps.setString(4, rest_id);

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
		btnSubmit.setBounds(194, 353, 137, 29);
		contentPane.add(btnSubmit);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component frmLoginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm","Login System",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
						{
					         System.exit(0);
						}
			}
			
		});
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnExit.setBounds(372, 353, 137, 29);
		contentPane.add(btnExit);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\foodsafetyportal\\t.jpg"));
		lblNewLabel_1.setBounds(0, 0, 734, 461);
		contentPane.add(lblNewLabel_1);
	}

}
