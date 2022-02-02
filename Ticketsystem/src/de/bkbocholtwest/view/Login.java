package de.bkbocholtwest.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import de.bkbocholtwest.model.Admin;
import de.bkbocholtwest.model.App;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	public JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;
	App app = new App();

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
		lblUsername.setBounds(52, 54, 92, 25);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(52, 90, 92, 21);
		frame.getContentPane().add(lblPassword);
		
		
		JButton btnRegister = new JButton("I dont have an Account");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//hier noch überprüfen ob der User ein Admin ist.
				Register reg = new Register();
				reg.frame.setVisible(true);
				frame.setVisible(false);
				
				
				
			}
		});
		
		btnRegister.setBounds(154, 167, 170, 28);
		frame.getContentPane().add(btnRegister);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(154, 54, 170, 28);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(154, 86, 170, 28);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblPassOrUserWrong = new JLabel("Password or Username is incorrect!");
		lblPassOrUserWrong.setEnabled(false);
		lblPassOrUserWrong.setBounds(154, 206, 211, 46);
		lblPassOrUserWrong.setVisible(false);
		frame.getContentPane().add(lblPassOrUserWrong);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean successLog = app.login(txtUsername.getText(),txtPassword.getText());
				if (successLog) {
					//success login username and pass are correct
					lblPassOrUserWrong.setEnabled(false);
					lblPassOrUserWrong.setVisible(false);
				}else {
					lblPassOrUserWrong.setEnabled(true);
					lblPassOrUserWrong.setVisible(true);
				}
			}	
		});
		btnLogin.setBounds(154, 125, 170, 28);
		frame.getContentPane().add(btnLogin);
		

		
		
	}
}
