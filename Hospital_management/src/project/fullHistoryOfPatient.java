package project;
import project.connectionProvider;
import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class fullHistoryOfPatient extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnShow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fullHistoryOfPatient frame = new fullHistoryOfPatient();
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
	public fullHistoryOfPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnClose.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\Close.png"));
		btnClose.setBounds(588, 454, 97, 25);
		contentPane.add(btnClose);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(25, 41, 724, 224);
		contentPane.add(table);
		
		btnShow = new JButton("Show");
		btnShow.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\login.png"));
		btnShow.setFocusable(false);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Connection con = connectionProvider.getCon();
					Statement st = con.createStatement();
					
					ResultSet rs = st.executeQuery("select * from project.patient inner join project.patientreport where patient.patientID=patientreport.patientID");
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
			
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "Connection Error");
				}
				
			}
		});
		btnShow.setBounds(107, 454, 97, 25);
		contentPane.add(btnShow);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\add new patient background.jpg"));
		lblNewLabel.setBounds(0, -51, 771, 573);
		contentPane.add(lblNewLabel);
	}
}
