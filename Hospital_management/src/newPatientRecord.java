import project.connectionProvider;

import java.awt.BorderLayout;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class newPatientRecord extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newPatientRecord frame = new newPatientRecord();
					frame.setVisible(true);
					frame.setLocation(700, 200);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public newPatientRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPatientId.setBounds(122, 31, 110, 40);
		contentPane.add(lblPatientId);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(122, 84, 96, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contact No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(122, 135, 116, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(122, 188, 68, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(122, 237, 79, 25);
		contentPane.add(lblGender);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBloodGroup.setBounds(122, 287, 130, 25);
		contentPane.add(lblBloodGroup);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddress.setBounds(122, 336, 116, 25);
		contentPane.add(lblAddress);
		
		JLabel lblAnyMajorDieseases = new JLabel("Any major diseases suffered earlier ");
		lblAnyMajorDieseases.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAnyMajorDieseases.setBounds(122, 387, 382, 25);
		contentPane.add(lblAnyMajorDieseases);
		
		textField = new JTextField();
		textField.setBounds(333, 43, 350, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(333, 192, 350, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(333, 138, 350, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(333, 88, 350, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MALE", "FEMALE", "OTHERS"}));
		comboBox.setBounds(333, 241, 350, 22);
		contentPane.add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setBounds(333, 291, 350, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(333, 340, 350, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(122, 436, 569, 25);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String patientID = textField.getText();
				String name = textField_3.getText();
				String contactNumber = textField_2.getText();
				String age = textField_1.getText();
				String gender = (String)comboBox.getSelectedItem();
				String bloodGroup = textField_4.getText();
				String address = textField_5.getText();
				String anymajordiseases = textField_6.getText();
			
              try{
            	  
                	    Connection con = connectionProvider.getCon();
						Statement st = con.createStatement();
						st.executeUpdate("insert into patient values('"+patientID+"','"+name+"','"+contactNumber+"','"+age+"','"+gender+"','"+bloodGroup+"','"+address+"','"+anymajordiseases+"')");
					
                	JOptionPane.showMessageDialog(null, "Succefully Updated");
                	setVisible(false);
                	newPatientRecord newpatient = new newPatientRecord();
                	newpatient.setVisible(true);
               }
               catch(Exception e)
               {
            	   JOptionPane.showMessageDialog(null, "Please fill the correct details");
            	   System.out.println(e);
               }
               
			}
		});
		btnSave.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\save-icon--1.png"));
		btnSave.setBounds(122, 491, 97, 25);
		contentPane.add(btnSave);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				homepage homepage  = new homepage();
				homepage.setVisible(true);
				dispose();

			}
		});
		btnClose.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\Close.png"));
		btnClose.setBounds(553, 491, 97, 25);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\add new patient background.jpg"));
		lblNewLabel_3.setBounds(0, 0, 771, 500);
		contentPane.add(lblNewLabel_3);
	}
}
