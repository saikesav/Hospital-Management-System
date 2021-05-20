import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.fullHistoryOfPatient;
import project.hospitalInformation;
import project.updatePatientRecord;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.Cursor;
import java.awt.Component;
import javax.swing.JLabel;

public class homepage extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage();
					frame.setVisible(true);
					frame.setLocation(200, 200);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1266, 734);
		contentPane = new JPanel();
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add New Patient Record");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton.setBounds(new Rectangle(250, 66, 42, 67));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\patientsmallimageadd.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				newPatientRecord newPatient = new newPatientRecord();
				newPatient.setLocation(640, 285);
				newPatient.setVisible(true);
			}
		});
		btnNewButton.setBounds(65, 115, 275, 57);
		btnNewButton.setFocusable(false);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Diagnosis Information");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adddiagnosis add = new adddiagnosis();
				add.setLocation(640, 285);
				add.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(new Rectangle(250, 66, 42, 67));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\add diag.png"));
		btnNewButton_1.setBounds(65, 186, 275, 57);
		btnNewButton_1.setFocusable(false);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Full History Of The Patient");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fullHistoryOfPatient full = new fullHistoryOfPatient();
				full.setLocation(640, 285);
				full.setVisible(true);
			}
		});
		btnNewButton_2.setIconTextGap(5);
		btnNewButton_2.setBounds(new Rectangle(250, 66, 42, 67));
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\History-icon.png"));
		btnNewButton_2.setBounds(65, 256, 275, 57);
		btnNewButton_2.setFocusable(false);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update Patient Record");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updatePatientRecord update = new updatePatientRecord();
				update.setLocation(640, 285);
				update.setVisible(true);
			}
		});
		btnNewButton_3.setIconTextGap(8);
		btnNewButton_3.setBounds(new Rectangle(250, 66, 42, 67));
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\updateicon.png"));
		btnNewButton_3.setBounds(65, 326, 275, 57);
		btnNewButton_3.setFocusable(false);
		contentPane.add(btnNewButton_3);
		
		JButton btnHospitalInformation = new JButton("Hospital Information");
		btnHospitalInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hospitalInformation hospital = new hospitalInformation();
				hospital.setLocation(640,285);
				hospital.setVisible(true);
				
			}
		});
		btnHospitalInformation.setBounds(new Rectangle(250, 66, 42, 67));
		btnHospitalInformation.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\rsz_hospital_information.png"));
		btnHospitalInformation.setBounds(65, 396, 275, 57);
		btnHospitalInformation.setFocusable(false);
		contentPane.add(btnHospitalInformation);
		
		JButton btnLogOut = new JButton("LogOut");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int permission = JOptionPane.showConfirmDialog(null,"Do you really want to logout","Message", JOptionPane.YES_NO_OPTION);
			    if(permission==0)
			    {
			    	loginFRAME login = new loginFRAME();
			    	login.frame.setVisible(true);
			    	dispose();
			    }
			}
		});
		btnLogOut.setFocusable(false);
		btnLogOut.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\exit.png"));
		btnLogOut.setBounds(65, 466, 275, 57);
		contentPane.add(btnLogOut);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\architecture-931283_1920.jpg"));
		lblNewLabel.setBounds(0, 0, 1248, 687);
		contentPane.add(lblNewLabel);
	}

}
