
import project.connectionProvider;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class adddiagnosis extends JFrame {

	private JPanel contentPane;
	JTextField textField;
	public JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
    JLabel lblNewLabel_3;
	JLabel lblTypeOfWarden;
	JComboBox comboBox_1;
	JCheckBox chckbxYes;
	public int flag=0;
	private JLabel lblNewLabel_4;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adddiagnosis frame = new adddiagnosis();
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
	@SuppressWarnings({ "rawtypes", "unchecked"})
	public adddiagnosis() {
		
		
	
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatientid = new JLabel("PatientID");
		lblPatientid.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPatientid.setBounds(161, 46, 97, 33);
		contentPane.add(lblPatientid);
		
		textField = new JTextField();
		textField.setBounds(283, 50, 210, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"PatientID", "Name", "ContactNumber", "Age", "Gender", "BloodGroup", "Address", "AnyMajorDiseases"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Long.class, Integer.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(2).setMinWidth(16);
		table.setBounds(25, 148, 723, 55);
		contentPane.add(table);
		
		lblNewLabel = new JLabel("Symptoms");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(36, 238, 115, 33);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Diagnosis");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(36, 307, 115, 33);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Medicines");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_2.setBounds(36, 378, 115, 23);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(161, 242, 222, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(161, 311, 222, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(161, 376, 222, 33);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PatientID Does Not Exists !");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(305, 105, 210, 19);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		JLabel lblWardRequired = new JLabel("Ward Required");
		
		lblWardRequired.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblWardRequired.setBounds(431, 238, 148, 33);
		contentPane.add(lblWardRequired);
		
		

		JButton btnSearch = new JButton("Search");
		btnSearch.setFocusable(false);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String patientSearch = textField.getText();
				try
				{
					Connection con = connectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet result = st.executeQuery("select * from patient where patientID = '"+patientSearch+"'");
					table.setModel(DbUtils.resultSetToTableModel(result));
					if(!result.first())
					{
						
						lblNewLabel_3.setVisible(true);
						
					}
					else
					{
						
						lblNewLabel_3.setVisible(false);
						textField.setEditable(false);
						flag=1;
						
					}
					
				}
				catch(Exception e)
				{
					//JOptionPane.showMessageDialog(null, "Connection Error!!");
					
				}
			}
		});
		
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnSearch.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\search.png"));
		btnSearch.setBounds(530, 46, 129, 33);
		contentPane.add(btnSearch);
		
		
		chckbxYes = new JCheckBox("Yes");
		
		chckbxYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxYes.isSelected()){
					lblTypeOfWarden.setVisible(true);
				    comboBox_1.setVisible(true);
				}
				else{
					lblTypeOfWarden.setVisible(false);
				    comboBox_1.setVisible(false);
				}
			}
		});
		chckbxYes.setFont(new Font("Tahoma", Font.BOLD, 19));
		chckbxYes.setBounds(621, 242, 113, 25);
		contentPane.add(chckbxYes);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	if(flag==1){
					String patientID=textField.getText();
					String Symptoms =textField_1.getText();
					String Diagnosis = textField_2.getText();
					String medicines = textField_3.getText();
					String wardReq;
					String typeWard;
					if(chckbxYes.isSelected()){
						wardReq="YES";
						typeWard=(String)comboBox_1.getSelectedItem();
					}
					else{
						wardReq="NO";
						typeWard="";
					}
					try{
						
						Connection con = connectionProvider.getCon();
						Statement st = con.createStatement();
						st.executeUpdate("insert into patientreport values('"+patientID+"','"+Symptoms+"','"+Diagnosis+"','"+medicines+"','"+wardReq+"','"+typeWard+"')");
						
						JOptionPane.showMessageDialog(null,"Successfully Updated");
						setVisible(false);
						new adddiagnosis().setVisible(true);
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null,e);
					}
				
			}
		});
		btnSave.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\save-icon--1.png"));
		btnSave.setBounds(91, 442, 97, 25);
		contentPane.add(btnSave);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnClose.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\Close.png"));
		btnClose.setBounds(530, 442, 97, 25);
		contentPane.add(btnClose);
		
		lblTypeOfWarden = new JLabel("Type of Warden");
		lblTypeOfWarden.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTypeOfWarden.setBounds(431, 312, 162, 23);
		lblTypeOfWarden.setVisible(false);
		contentPane.add(lblTypeOfWarden);
		
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"General", "Single", "Dual"}));
		comboBox_1.setBounds(621, 311, 138, 25);
		comboBox_1.setVisible(false);
		contentPane.add(comboBox_1);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\add new patient background.jpg"));
		lblNewLabel_4.setBounds(0, 0, 771, 500);
		contentPane.add(lblNewLabel_4);
		
	}
}
