package de.bkbocholtwest.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.bkbocholtwest.model.Admin;
import de.bkbocholtwest.model.App;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Register extends mainView{

	public JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(26, 50, 112, 28);
		frame.getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(148, 47, 218, 31);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("create password");
		lblPassword.setBounds(25, 87, 113, 28);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("I already have an Account");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWindow.goToLogin();
				
				
			}
		});
		btnLogin.setBounds(148, 171, 218, 28);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblRegister = new JLabel("The user was successful created.");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setBounds(148, 223, 218, 47);
		lblRegister.setVisible(false);
		frame.getContentPane().add(lblRegister);
		
		JLabel lblRegisterUnsuccessful = new JLabel("Username and Password cannot be empty.");
		lblRegisterUnsuccessful.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterUnsuccessful.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblRegisterUnsuccessful.setBounds(148, 223, 218, 47);
		lblRegisterUnsuccessful.setVisible(false);
		frame.getContentPane().add(lblRegisterUnsuccessful);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* 
				Hier soll die Methode aus Admin createTickets aufgerufen werden
				Nur Admin dürfen user erstellen
				*/
				
				Admin ad = new Admin();
				if(!txtUsername.getText().isEmpty() && !passwordField.getText().isEmpty()) {
					ad.createUser(txtUsername.getText(), passwordField.getText());
					lblRegisterUnsuccessful.setVisible(false);
					lblRegister.setVisible(true);
					lblRegister.grabFocus();
				}else {
					lblRegister.setVisible(false);
					lblRegisterUnsuccessful.setVisible(true);
				}

				
			}
		});
		btnRegister.setBounds(148, 137, 218, 23);
		frame.getContentPane().add(btnRegister);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 87, 218, 28);
		frame.getContentPane().add(passwordField);
		
	}
}
