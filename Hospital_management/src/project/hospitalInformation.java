package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class hospitalInformation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hospitalInformation frame = new hospitalInformation();
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
	public hospitalInformation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\HospitalInformation.jpeg"));
		lblNewLabel.setBounds(179, 27, 447, 302);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(43, 342, 705, 116);
		textArea.setText("Our Hospital  is  very equipped for the diagnosis of disease, for the treatment, both medical and surgical, of the sick and the injured and for their housing during this process. Our hospital also often serves as a centre for investigation and for teaching.Visit our Hospital any time when needed.");
		textArea.setBorder(BorderFactory.createBevelBorder(2));
		textArea.setFont(new Font("Comic sans",Font.ITALIC,20));
		textArea.setEditable(false);
		
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		contentPane.add(textArea);
	}
}
