import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;

public class HomeFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame frame = new HomeFrame();
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
	Connection conn = null;
	private JTable table;
	private JTextField txtEnterResturantid;
	public HomeFrame() throws ClassNotFoundException {
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
		
		JLabel lblNewLabel = new JLabel("1) Select Table to Insert New Data");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 52, 320, 23);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.addItem("Admin");
		comboBox.addItem("City_Employe");

		comboBox.addItem("Visitor/Customer");
		comboBox.setSelectedItem(null);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                    
				
			}
		});
		comboBox.setBounds(340, 52, 155, 24);
		contentPane.add(comboBox);
		
		JButton insert = new JButton("ok");
		insert.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Admin"))
                {
               	     ResturantFrame rf;
					try {
						rf = new ResturantFrame();
	               	     rf.setVisible(true);

					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                else if(comboBox.getSelectedItem().equals("City_Employe"))
                {
               	 MenuFrame m;
				try {
					m = new MenuFrame();
					m.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                }
                else
                {
               	 VisitorFrame vis;
				try {
					vis = new VisitorFrame();
					 vis.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                }
				
                
			
			}
		});
		insert.setBounds(524, 52, 96, 26);
		contentPane.add(insert);
		
		JLabel lblNewLabel_1 = new JLabel("2) Select Table to VIew Existing Data");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 110, 301, 23);
		contentPane.add(lblNewLabel_1);
		comboBox.setSelectedItem(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(100, 281, 566, 148);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Menu Table");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						String query = "select * from menu";

						PreparedStatement ps = conn.prepareStatement(query);
						ResultSet rs = ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                
                
			}
		);
		btnNewButton.setBounds(534, 99, 147, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Resturant Table");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from resturant";

					PreparedStatement ps = conn.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(430, 133, 205, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(" Visitor Table");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from customer";

					PreparedStatement ps = conn.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(340, 99, 141, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("SELECT, INSERT, DELETE Queries");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		lblNewLabel_2.setBounds(34, 0, 669, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("3) Click ok to View Feedback of Customer");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 180, 390, 23);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("Click Here");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select resturant_name,feedback from customer c,resturant r where c.rest_id=r.resturant_id ";

					PreparedStatement ps = conn.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setBounds(479, 183, 141, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("4) Click to View Resturant Menu");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 226, 332, 23);
		contentPane.add(lblNewLabel_4);
		
		txtEnterResturantid = new JTextField();
		txtEnterResturantid.setForeground(SystemColor.controlHighlight);
		txtEnterResturantid.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtEnterResturantid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String r=txtEnterResturantid.getText();
					String query = "select dish_name,price from menu  where resturant_id=?";

					PreparedStatement ps = conn.prepareStatement(query);
		    	      ps.setString(1,txtEnterResturantid.getText());

					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					ps.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtEnterResturantid.setText("Enter resturant_id");
		txtEnterResturantid.setBounds(430, 226, 205, 23);
		contentPane.add(txtEnterResturantid);
		txtEnterResturantid.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\foodsafetyportal\\t.jpg"));
		lblNewLabel_5.setBounds(0, 0, 734, 461);
		contentPane.add(lblNewLabel_5);
		
		
	}
}
