package project;
import project.connectionProvider;
import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updatePatientRecord extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnSearch;
	private JButton btnUpdate;
	private JButton btnClose;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatePatientRecord frame = new updatePatientRecord();
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
	public updatePatientRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatientid = new JLabel("PatientID");
		lblPatientid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPatientid.setBounds(196, 46, 96, 16);
		contentPane.add(lblPatientid);
		
		textField = new JTextField();
		textField.setBounds(299, 43, 208, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(196, 90, 91, 16);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(299, 88, 208, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContactNo.setBounds(196, 137, 88, 16);
		contentPane.add(lblContactNo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(299, 137, 208, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAge.setBounds(196, 184, 56, 22);
		contentPane.add(lblAge);
		
		textField_3 = new JTextField();
		textField_3.setBounds(299, 182, 208, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(196, 234, 56, 16);
		contentPane.add(lblGender);
		
		textField_4 = new JTextField();
		textField_4.setBounds(299, 232, 208, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBloodGroup.setBounds(196, 287, 96, 16);
		contentPane.add(lblBloodGroup);
		
		textField_5 = new JTextField();
		textField_5.setBounds(299, 285, 208, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(196, 342, 96, 16);
		contentPane.add(lblAddress);
		
		textField_6 = new JTextField();
		textField_6.setBounds(299, 336, 208, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Any Major Dieseases Suffered Earlier");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(196, 397, 321, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_7 = new JTextField();
		textField_7.setBounds(196, 430, 311, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setFocusable(false);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PatientID = textField.getText();
				try{
					Connection con = connectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from patient where patientID='"+PatientID+"'");
					if(rs.next()){
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));
						textField_3.setText(rs.getString(4));
						textField_4.setText(rs.getString(5));
						textField_5.setText(rs.getString(6));
						textField_6.setText(rs.getString(7));
						textField_7.setText(rs.getString(8));
						textField.setEditable(false);
						
					}
					else{
						JOptionPane.showMessageDialog(null, "PatientID doesn't exist!");
						
					}
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Connection Error");
				}
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\search.png"));
		btnSearch.setBounds(580, 43, 120, 25);
		contentPane.add(btnSearch);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String PatientID = textField.getText();
				String name = textField_1.getText();
				String contactNumber = textField_2.getText();
				String age = textField_3.getText();
				String gender = textField_4.getText();
				String bloodGroup = textField_5.getText();
				String address = textField_6.getText();
				String anyMajorDisease = textField_7.getText();
				try{
					Connection con = connectionProvider.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("update project.patient set name='"+name+"',contactNumber='"+contactNumber+"',age='"+age+"',gender='"+gender+"',bloodGroup='"+bloodGroup+"',address='"+address+"',anyMajorDisease='"+anyMajorDisease+"' where patientID='"+PatientID+"'");
					JOptionPane.showMessageDialog(null, "Sucessfully Updated");
					setVisible(false);
					new updatePatientRecord().setVisible(true);
				}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Connection Error");
				}
			}
		});
		btnUpdate.setFocusable(false);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\save-icon--1.png"));
		btnUpdate.setBounds(109, 484, 143, 29);
		contentPane.add(btnUpdate);
		
		btnClose = new JButton("Close");
		btnClose.setFocusable(false);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClose.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\Close.png"));
		btnClose.setBounds(490, 484, 143, 29);
		contentPane.add(btnClose);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\add new patient background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 771, 500);
		contentPane.add(lblNewLabel_2);
	}
}
