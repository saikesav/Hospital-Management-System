import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class loginFRAME {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFRAME window = new loginFRAME();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginFRAME() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\home.jpg"));
		frame.setBounds(100, 100, 1229, 722);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUsername.setBounds(502, 236, 93, 23);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBounds(511, 297, 133, 23);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(656, 238, 255, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(656, 299, 255, 22);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("Saikesav")&&passwordField.getText().equals("Kesav@123"))
				{
					homepage homepage = new homepage();
					frame.dispose();
					homepage.setLocation(200,200);
					homepage.setVisible(true);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Incorrect username or password");
				}
				
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogin.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\login.png"));
		btnLogin.setBounds(656, 350, 122, 25);
		frame.getContentPane().add(btnLogin);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int permission = JOptionPane.showConfirmDialog(null,"Do you really want to close", "Select", JOptionPane.YES_NO_OPTION);
				if(permission==0)
				{
					System.exit(0);
				}
			}
		});
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnClose.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\Close.png"));
		btnClose.setBounds(809, 350, 104, 25);
		frame.getContentPane().add(btnClose);
		
		JLabel label = new JLabel("");
		label.setBounds(249, 283, 234, 310);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\secrecy-icon.png"));
		label_1.setBounds(249, 87, 331, 398);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\add new patient background.jpg"));
		label_2.setBounds(207, 138, 754, 368);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\HMS ICON\\HMS ICON\\home.jpg"));
		label_3.setBounds(0, 0, 1211, 675);
		frame.getContentPane().add(label_3);
	}
}
