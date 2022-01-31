package de.bkbocholtwest.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import de.bkbocholtwest.model.App;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
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
		lblUsername.setBounds(52, 58, 80, 21);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(52, 90, 80, 21);
		frame.getContentPane().add(lblPassword);
		
		
		JButton btnNewButton_1 = new JButton("I dont have an Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register reg = new Register();
			}
		});
		
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
		
		JLabel lblPassOrUserWrong = new JLabel("Password or Username is incorrect!");
		lblPassOrUserWrong.setEnabled(false);
		lblPassOrUserWrong.setBounds(111, 206, 240, 46);
		lblPassOrUserWrong.setVisible(false);
		frame.getContentPane().add(lblPassOrUserWrong);
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean successLog = app.login(txtUsername.getText(),txtPassword.getText());
				if (successLog) {
					//success login username and pass are correct
				}else {
					lblPassOrUserWrong.setEnabled(true);
					lblPassOrUserWrong.setVisible(true);
				}
			}	
		});
		btnNewButton.setBounds(111, 138, 170, 23);
		frame.getContentPane().add(btnNewButton);
		

		
		
	}
}
