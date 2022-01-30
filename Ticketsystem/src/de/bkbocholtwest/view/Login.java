package de.bkbocholtwest.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(52, 58, 80, 21);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(52, 90, 80, 21);
		frame.getContentPane().add(lblPassword);
		
		
		JButton btnNewButton_1 = new JButton("I already have an Account!");
		btnNewButton_1.setBounds(111, 172, 170, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(111, 58, 96, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(111, 90, 96, 20);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtPassword.equals(/*liste mit gehashten passwort und Username, bestimmter index*/3) && txtUsername.equals(4/*List mit Username und Passwörtern, bestimmter index*/)) {
					boolean login = true;
				}
				else {
					//penalty 
				}
			}
		});
		btnNewButton.setBounds(111, 138, 170, 23);
		frame.getContentPane().add(btnNewButton);
		
	}
}
